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
package com.jd.journalq.manage;

import java.io.Serializable;

/**
 * Created by wangxiaofei1 on 2019/4/10.
 */
public class PartitionPosition implements Serializable {
    private int partition;
    private long rightPosition;
    private long rightPositionInterval;

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public long getRightPosition() {
        return rightPosition;
    }

    public void setRightPosition(long rightPosition) {
        this.rightPosition = rightPosition;
    }

    public long getRightPositionInterval() {
        return rightPositionInterval;
    }

    public void setRightPositionInterval(long rightPositionInterval) {
        this.rightPositionInterval = rightPositionInterval;
    }
}
