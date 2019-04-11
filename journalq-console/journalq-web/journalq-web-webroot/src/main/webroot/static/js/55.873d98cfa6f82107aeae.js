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
webpackJsonp([55],{adcC:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=a("1a0f"),r=(a("vcXF"),a("T0gc")),n=a("95hR"),o={name:"brokerTab",components:{myTable:r.a},mixins:[n.a],data:function(){return{urls:{search:"/broker/search",removeBroker:"/broker/update"},searchData:{brokerGroupId:this.$route.query.id,keyword:""},searchRules:{},tableData:{rowData:[],colData:[{title:"ID",key:"id"},{title:"IP",key:"ip"},{title:"端口",key:"port"},{title:"数据中心",key:"dataCenter.id"},{title:"重试方式",key:"retryType"},{title:"描述",key:"description"}],btns:[{txt:"移除",method:"on-del"}]}}},computed:{},methods:{getList:function(){var e=this;this.showTablePin=!0;var t={pagination:{page:this.page.page,size:this.page.size},query:{brokerGroupId:this.$route.query.id,keyword:this.searchData.keyword}};i.a.post(this.urlOrigin.search,{},t).then(function(t){t.data=t.data||[],t.pagination=t.pagination||{totalRecord:t.data.length},e.page.total=t.pagination.totalRecord,e.page.page=t.pagination.page,e.page.size=t.pagination.size,e.tableData.rowData=t.data,e.showTablePin=!1})},del:function(e){var t=this,a={id:e.id,group:{id:-1}};i.a.put(this.urls.removeBroker+"/"+e.id,{},a).then(function(e){t.getList()})}},mounted:function(){this.getList()}},s={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("div",{staticClass:"ml20 mt30"},[a("d-input",{staticClass:"left mr10",staticStyle:{width:"10%"},attrs:{placeholder:"请输入ID/分组编码/IP"},model:{value:e.searchData.keyword,callback:function(t){e.$set(e.searchData,"keyword",t)},expression:"searchData.keyword"}},[a("icon",{attrs:{slot:"suffix",name:"search",size:"14",color:"#CACACA"},on:{click:e.getList},slot:"suffix"})],1)],1),e._v(" "),a("my-table",{attrs:{data:e.tableData,showPin:e.showTablePin,page:e.page},on:{"on-size-change":e.handleSizeChange,"on-current-change":e.handleCurrentChange,"on-del":e.del}})],1)},staticRenderFns:[]};var d=a("VU/8")(o,s,!1,function(e){a("nH+r")},"data-v-1ad954c1",null);t.default=d.exports},"nH+r":function(e,t){}});
//# sourceMappingURL=55.873d98cfa6f82107aeae.js.map