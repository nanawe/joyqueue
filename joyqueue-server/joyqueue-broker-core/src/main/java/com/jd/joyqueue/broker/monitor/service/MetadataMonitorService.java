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
package com.jd.joyqueue.broker.monitor.service;

import com.jd.joyqueue.domain.TopicConfig;
import com.jd.joyqueue.response.BooleanResponse;

/**
 * MetadataMonitorService
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2019/2/11
 */
public interface MetadataMonitorService {

    TopicConfig getTopicMetadata(String topic, boolean isCluster);

    BooleanResponse getReadableResult(String topic, String app, String address);

    BooleanResponse getWritableResult(String topic, String app, String address);
}