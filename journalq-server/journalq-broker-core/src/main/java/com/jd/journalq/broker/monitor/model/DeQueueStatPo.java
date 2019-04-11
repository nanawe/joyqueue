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
package com.jd.journalq.broker.monitor.model;

/**
 * 出队
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/10/12
 */
public class DeQueueStatPo extends BasePo {

    private long total;
    private long totalSize;

    public DeQueueStatPo(long total, long totalSize) {
        this.total = total;
        this.totalSize = totalSize;
    }

    public DeQueueStatPo() {

    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
}