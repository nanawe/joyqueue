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
package com.jd.journalq.network.command;

import com.google.common.collect.Table;
import com.jd.journalq.exception.JMQCode;
import com.jd.journalq.network.transport.command.JMQPayload;

/**
 * CommitAck
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/12/12
 */
public class CommitAckAck extends JMQPayload {

    private Table<String, Short, JMQCode> result;

    @Override
    public int type() {
        return JMQCommandType.COMMIT_ACK_ACK.getCode();
    }

    public void setResult(Table<String, Short, JMQCode> result) {
        this.result = result;
    }

    public Table<String, Short, JMQCode> getResult() {
        return result;
    }
}