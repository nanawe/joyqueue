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
package com.jd.journalq.service;

import com.jd.journalq.model.domain.BaseModel;
import com.jd.journalq.model.exception.RepositoryException;
import com.jd.journalq.model.ListQuery;
import com.jd.journalq.model.PageResult;
import com.jd.journalq.model.QPageQuery;
import com.jd.journalq.model.Query;

import java.util.List;

/**
 * 服务接口
 * Created by chenyanying3 on 2018-10-15.
 */
public interface PageService<M extends BaseModel, Q extends Query> extends Service<M> {
    /**
     * 分页查询
     *
     * @param query 分页查询条件
     * @return 分页数据
     * @throws RepositoryException
     */
    PageResult<M> findByQuery(QPageQuery<Q> query) throws RepositoryException;
    /**
     * 根据条件查询
     *  @param query 查询条件
     ** @return 匹配的实体列表
     */
    List<M> findByQuery(ListQuery<Q> query);

}
