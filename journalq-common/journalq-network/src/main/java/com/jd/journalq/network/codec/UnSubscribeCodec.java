/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jd.journalq.network.codec;

import com.jd.journalq.domain.Subscription;
import com.jd.journalq.domain.TopicName;
import com.jd.journalq.network.command.CommandType;
import com.jd.journalq.network.command.UnSubscribe;
import com.jd.journalq.network.serializer.Serializer;
import com.jd.journalq.network.transport.codec.PayloadCodec;
import com.jd.journalq.network.transport.command.Header;
import com.jd.journalq.network.transport.command.Type;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wylixiaobin
 * Date: 2018/10/16
 */
public class UnSubscribeCodec implements PayloadCodec<Header, UnSubscribe>, Type {
    @Override
    public Object decode(Header header, ByteBuf buffer) throws Exception {
        Short subscriptionSize = buffer.readShort();
        List<Subscription> subscriptions = new ArrayList();
        if (subscriptionSize > 0) {
            for (int i = 0; i < subscriptionSize; i++) {
                TopicName topic = TopicName.parse(Serializer.readString(buffer));
                String app = Serializer.readString(buffer);
                Subscription.Type type = Subscription.Type.valueOf(buffer.readByte());
                subscriptions.add(new Subscription(topic, app, type));
            }
        }
        return new UnSubscribe().subscriptions(subscriptions);
    }

    @Override
    public void encode(UnSubscribe payload, ByteBuf buffer) throws Exception {
        List<Subscription> subscriptions = payload.getSubscriptions();
        int subscriptionSize = subscriptions == null ? 0 : subscriptions.size();
        buffer.writeShort(subscriptionSize);
        if (subscriptionSize > 0) {
            for (Subscription subscription : subscriptions) {
                Serializer.write(subscription.getTopic().getFullName(), buffer);
                Serializer.write(subscription.getApp(), buffer);
                buffer.writeByte(subscription.getType().getValue());
            }
        }
    }

    @Override
    public int type() {
        return CommandType.UNSUBSCRIBE;
    }
}
