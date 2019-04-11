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

import com.google.common.collect.Lists;
import com.jd.journalq.exception.JMQCode;
import com.jd.journalq.network.command.FetchProduceFeedbackAck;
import com.jd.journalq.network.command.FetchProduceFeedbackAckData;
import com.jd.journalq.network.command.JMQCommandType;
import com.jd.journalq.network.serializer.Serializer;
import com.jd.journalq.network.transport.codec.JMQHeader;
import com.jd.journalq.network.transport.codec.PayloadCodec;
import com.jd.journalq.network.transport.command.Type;
import io.netty.buffer.ByteBuf;

import java.util.List;

/**
 * FetchProduceFeedbackAckCodec
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/12/19
 */
public class FetchProduceFeedbackAckCodec implements PayloadCodec<JMQHeader, FetchProduceFeedbackAck>, Type {

    @Override
    public FetchProduceFeedbackAck decode(JMQHeader header, ByteBuf buffer) throws Exception {
        short dataSize = buffer.readShort();
        List<FetchProduceFeedbackAckData> data = Lists.newArrayListWithCapacity(dataSize);
        for (int i = 0; i < dataSize; i++) {
            String topic = Serializer.readString(buffer, Serializer.SHORT_SIZE);
            String txId = Serializer.readString(buffer, Serializer.SHORT_SIZE);
            String transactionId = Serializer.readString(buffer, Serializer.SHORT_SIZE);
            data.add(new FetchProduceFeedbackAckData(topic, txId, transactionId));
        }

        FetchProduceFeedbackAck fetchProduceFeedbackAck = new FetchProduceFeedbackAck();
        fetchProduceFeedbackAck.setData(data);
        fetchProduceFeedbackAck.setCode(JMQCode.valueOf(buffer.readInt()));
        return fetchProduceFeedbackAck;
    }

    @Override
    public void encode(FetchProduceFeedbackAck payload, ByteBuf buffer) throws Exception {
        buffer.writeShort(payload.getData().size());
        for (FetchProduceFeedbackAckData data : payload.getData()) {
            Serializer.write(data.getTopic(), buffer, Serializer.SHORT_SIZE);
            Serializer.write(data.getTxId(), buffer, Serializer.SHORT_SIZE);
            Serializer.write(data.getTransactionId(), buffer, Serializer.SHORT_SIZE);
        }
        buffer.writeInt(payload.getCode().getCode());
    }

    @Override
    public int type() {
        return JMQCommandType.FETCH_PRODUCE_FEEDBACK_ACK.getCode();
    }
}