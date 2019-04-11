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
package com.jd.journalq.model.domain;

/**
 * 用户类型
 */
public enum UserType {
    /**
     * 管理员
     */
    ADMIN,
    /**
     * 业务系统用户
     */
    USER,
    /**
     * 管理员和系统用户
     */
    ADMIN_USER
}
