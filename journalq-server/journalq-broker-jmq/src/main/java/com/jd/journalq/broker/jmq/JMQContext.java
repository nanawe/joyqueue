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
package com.jd.journalq.broker.jmq;

import com.jd.journalq.broker.jmq.coordinator.assignment.PartitionAssignmentHandler;
import com.jd.journalq.broker.BrokerContext;
import com.jd.journalq.broker.jmq.config.JMQConfig;
import com.jd.journalq.broker.jmq.coordinator.JMQCoordinator;
import com.jd.journalq.broker.jmq.coordinator.JMQCoordinatorGroupManager;
import com.jd.journalq.broker.polling.LongPollingManager;

/**
 * JMQContext
 * author: gaohaoxiang
 * email: gaohaoxiang@jd.com
 * date: 2018/11/28
 */
public class JMQContext {

    private static JMQConfig config;
    private JMQCoordinator coordinator;
    private JMQCoordinatorGroupManager coordinatorGroupManager;
    private PartitionAssignmentHandler partitionAssignmentHandler;
    private LongPollingManager longPollingManager;
    private BrokerContext brokerContext;

    public JMQContext(JMQConfig config, JMQCoordinator coordinator, JMQCoordinatorGroupManager coordinatorGroupManager, PartitionAssignmentHandler partitionAssignmentHandler,
                      LongPollingManager longPollingManager, BrokerContext brokerContext) {
        this.config = config;
        this.coordinator = coordinator;
        this.coordinatorGroupManager = coordinatorGroupManager;
        this.partitionAssignmentHandler = partitionAssignmentHandler;
        this.longPollingManager = longPollingManager;
        this.brokerContext = brokerContext;
    }

    public static JMQConfig getConfig() {
        return config;
    }

    public JMQCoordinator getCoordinator() {
        return coordinator;
    }

    public JMQCoordinatorGroupManager getCoordinatorGroupManager() {
        return coordinatorGroupManager;
    }

    public PartitionAssignmentHandler getPartitionAssignmentHandler() {
        return partitionAssignmentHandler;
    }

    public LongPollingManager getLongPollingManager() {
        return longPollingManager;
    }

    public BrokerContext getBrokerContext() {
        return brokerContext;
    }
}