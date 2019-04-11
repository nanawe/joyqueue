/*
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
webpackJsonp([24],{"2HcQ":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("T0gc"),n=a("fo4W"),i=a("95hR"),s={name:"",components:{myTable:r.a,myDialog:n.a},mixins:[i.a],data:function(){return{urls:{search:"/broker/search"},searchData:{keyword:""},searchRules:{},tableData:{rowData:[],colData:[{title:"分组",key:"brokerGroup.code"},{title:"IP",key:"ip"},{title:"端口",key:"port"},{title:"数据中心",key:"dataCenter.name"},{title:"角色",key:"role",render:function(e,t){return e("label",{},"SLAVE"===t.item.role?"从":"主")}},{title:"复制方式",key:"syncMode",render:function(e,t){return e("label",{},"SYNCHRONOUS"===t.item.syncMode?"同步":"异步")}},{title:"重试类型",key:"retryType",render:function(e,t){var a=void 0;switch(t.item.retryType){case"DB":a="直连数据库";break;case"REMOTE":a="访问远程服务"}return e("label",{},a)}},{title:"权限",key:"permission",render:function(e,t){var a=void 0;switch(t.item.permission){case"NONE":a="无权限";break;case"FULL":a="读写";break;case"READ":a="只读";break;case"WRITE":a="只写"}return e("label",{},a)}},{title:"备注",key:"description"},{title:"状态",key:"status",render:function(e,t){return e("label",{},1===t.item.status?"已启用":"不可用")}}]}}},computed:{},methods:{},mounted:function(){this.getList()}},c={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"ml20 mt30"},[a("d-input",{staticClass:"left mr10",staticStyle:{width:"10%"},attrs:{placeholder:"请输入分组/IP"},model:{value:e.searchData.name,callback:function(t){e.$set(e.searchData,"name",t)},expression:"searchData.name"}},[a("icon",{attrs:{slot:"suffix",name:"search",size:"14",color:"#CACACA"},on:{click:e.getList},slot:"suffix"})],1)],1),e._v(" "),a("my-table",{attrs:{data:e.tableData,showPin:e.showTablePin,page:e.page},on:{"on-size-change":e.handleSizeChange,"on-current-change":e.handleCurrentChange}})],1)},staticRenderFns:[]};var l=a("VU/8")(s,c,!1,function(e){a("I4Tv")},"data-v-d13dad96",null);t.default=l.exports},I4Tv:function(e,t){}});
//# sourceMappingURL=24.83647bf2e63100a95b00.js.map