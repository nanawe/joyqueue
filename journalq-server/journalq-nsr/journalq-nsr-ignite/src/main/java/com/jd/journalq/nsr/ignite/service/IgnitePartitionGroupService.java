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
package com.jd.journalq.nsr.ignite.service;

import com.google.inject.Inject;
import com.jd.journalq.domain.PartitionGroup;
import com.jd.journalq.domain.TopicName;
import com.jd.journalq.model.PageResult;
import com.jd.journalq.model.QPageQuery;
import com.jd.journalq.nsr.ignite.dao.PartitionGroupDao;
import com.jd.journalq.nsr.ignite.model.IgnitePartitionGroup;
import com.jd.journalq.nsr.model.PartitionGroupQuery;
import com.jd.journalq.nsr.service.PartitionGroupService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wylixiaobin
 * Date: 2018/9/4
 */
public class IgnitePartitionGroupService implements PartitionGroupService {
    private PartitionGroupDao partitionGroupDao;

    @Inject
    public IgnitePartitionGroupService(PartitionGroupDao igniteDao) {
        this.partitionGroupDao = igniteDao;
    }

    @Override
    public PartitionGroup findByTopicAndGroup(TopicName topic, int group) {
        return getById(IgnitePartitionGroup.getId(topic, group));
    }

    @Override
    public List<PartitionGroup> getByTopic(TopicName topic) {
        return convert(partitionGroupDao.list(new PartitionGroupQuery(topic.getCode(), topic.getNamespace())));
    }


    public IgnitePartitionGroup toIgniteModel(PartitionGroup model) {
        return new IgnitePartitionGroup(model);
    }

    @Override
    public PartitionGroup getById(String id) {
        return partitionGroupDao.findById(id);
    }

    @Override
    public PartitionGroup get(PartitionGroup model) {
        return partitionGroupDao.findById(toIgniteModel(model).getId());
    }

    @Override
    public void addOrUpdate(PartitionGroup partitionGroup) {
        partitionGroupDao.addOrUpdate(toIgniteModel(partitionGroup));
    }

    @Override
    public void deleteById(String id) {
        partitionGroupDao.deleteById(id);
    }

    @Override
    public void delete(PartitionGroup model) {
        partitionGroupDao.deleteById(toIgniteModel(model).getId());
    }

    @Override
    public List<PartitionGroup> list() {
        return list(null);
    }

    @Override
    public List<PartitionGroup> list(PartitionGroupQuery query) {
        return convert(partitionGroupDao.list(query));
    }

    @Override
    public PageResult<PartitionGroup> pageQuery(QPageQuery<PartitionGroupQuery> pageQuery) {
        PageResult<IgnitePartitionGroup> pageResult = partitionGroupDao.pageQuery(pageQuery);
        return new PageResult<>(pageResult.getPagination(), convert(pageResult.getResult()));
    }

    List<PartitionGroup> convert(List<IgnitePartitionGroup> groups) {

        List<PartitionGroup> result = new ArrayList<>();
        if (groups != null) {
            result.addAll(groups);
        }

        return result;
    }
}
