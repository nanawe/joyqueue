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
package com.jd.journalq.broker.kafka.network.codec;

import com.jd.journalq.broker.kafka.network.KafkaHeader;
import com.jd.journalq.broker.kafka.network.KafkaPayloadCodec;
import com.jd.journalq.broker.kafka.KafkaCommandType;
import com.jd.journalq.broker.kafka.command.ApiVersionsRequest;
import com.jd.journalq.broker.kafka.command.ApiVersionsResponse;
import com.jd.journalq.broker.kafka.model.ApiVersion;
import com.jd.journalq.network.transport.command.Type;
import io.netty.buffer.ByteBuf;

/**
 * ApiVersionsCodec
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/11/5
 */
public class ApiVersionsCodec implements KafkaPayloadCodec<ApiVersionsResponse>, Type {

    @Override
    public Object decode(KafkaHeader header, ByteBuf buffer) throws Exception {
        if (buffer.isReadable(4)) {
            buffer.skipBytes(4);
        }
        return new ApiVersionsRequest();
    }

    @Override
    public void encode(ApiVersionsResponse payload, ByteBuf buffer) throws Exception {
        buffer.writeShort(payload.getErrorCode());
        buffer.writeInt(payload.getApis().size());
        for (ApiVersion api : payload.getApis()) {
            buffer.writeShort(api.getCode());
            buffer.writeShort(api.getMinVersion());
            buffer.writeShort(api.getMaxVersion());
        }
        buffer.writeInt(payload.getThrottleTimeMs());
    }

    @Override
    public int type() {
        return KafkaCommandType.API_VERSIONS.getCode();
    }
}