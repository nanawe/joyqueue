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
webpackJsonp([29],{c5DE:function(t,i,a){"use strict";Object.defineProperty(i,"__esModule",{value:!0});var o=a("1a0f"),e=a("T0gc"),n=a("fo4W"),r=a("+Ohd"),l=a("JSa9"),c=a("9xs8"),g=a("tdWL"),s=a("95hR"),u={name:"",components:{myTable:e.a,myDialog:n.a,groupDetail:r.default,groupScale:l.default,groupMerge:c.default,groupNew:g.default},mixins:[s.a],data:function(){return{urls:{search:"/partitionGroup/search",del:"/partitionGroup/delete",addPartition:"/partitionGroup/addPartition",removePartition:"/partitionGroup/removePartition",getMonitor:"/monitor"},searchData:{topic:{id:this.$route.query.id,code:this.$route.query.code},namespace:{id:this.$route.query.namespaceId,code:this.$route.query.namespaceCode},keyword:""},searchRules:{},tableData:{rowData:[],colData:[{title:"ID",key:"id"},{title:"主题",key:"topic.code"},{title:"group",key:"groupNo"},{title:"选举类型",key:"electType",render:function(t,i){var a=void 0;switch(i.item.electType){case 0:a="raft";break;case 1:a="fix"}return t("label",{},a)}},{title:"partitions",key:"partitions"},{title:"leader",key:"leader"},{title:"推荐leader",key:"recLeader"},{title:"isr",key:"isr"},{title:"term",key:"term"}],btns:[{txt:"详情",method:"on-view-detail"},{txt:"增加副本数",method:"on-scale"},{txt:"减副本数",method:"on-merge"},{txt:"删除",method:"on-del"},{txt:"增加分区",method:"on-addPartition"},{txt:"减少分区",method:"on-removePartition"}]},groupDetailDialog:{visible:!1,title:"详情",width:800,showFooter:!1},groupDetailDialogData:{},groupScaleDialog:{visible:!1,title:"增加副本",width:800,showFooter:!1},groupScaleDialogData:{},groupMergeDialog:{visible:!1,title:"减少副本",width:800,showFooter:!1},groupMergeDialogData:{},addPartitionDialog:{visible:!1,title:"增加分区数",width:500,showFooter:!0},addPartitionDialogData:{},removePartitionDialog:{visible:!1,title:"减少分区数",width:800,showFooter:!0},removePartitionDialogData:{},groupNewDialog:{visible:!1,title:"详情",width:800,showFooter:!1},groupNewDialogData:{topic:this.$route.query.topic,namespace:this.$route.query.namespace,electType:0,replicaGroups:[],partitions:0},newGroupData:{}}},computed:{},methods:{getList:function(){var t=this;this.showTablePin=!0;var i={pagination:{page:this.page.page,size:this.page.size},query:{topic:this.searchData.topic,namespace:this.searchData.namespace,keyword:this.searchData.keyword}};o.a.post(this.urlOrigin.search,{},i).then(function(i){i.data=i.data||[],i.pagination=i.pagination||{totalRecord:i.data.length},t.page.total=i.pagination.totalRecord,t.page.page=i.pagination.page,t.page.size=i.pagination.size,t.tableData.rowData=i.data,t.showTablePin=!1})},goDetail:function(t){this.groupDetailDialogData={groupNo:t.groupNo,topic:this.searchData.topic,namespace:this.searchData.namespace},this.groupDetailDialog.visible=!0},groupDetailConfirm:function(){},groupDetailCancel:function(){this.groupDetailDialog.visible=!1},groupScale:function(t){this.groupScaleDialogData={groupNo:t.groupNo,topic:{id:t.topic.id,code:t.topic.code},namespace:{id:t.namespace.id,code:t.namespace.code}},this.groupScaleDialog.visible=!0},groupScaleConfirm:function(){},groupScaleCancel:function(){this.groupScaleDialog.visible=!1},groupNewConfirm:function(){},groupNewCancel:function(){this.groupNewDialog.visible=!1,this.getList()},groupNew:function(){this.groupNewDialogData={topic:this.searchData.topic,namespace:this.searchData.namespace},this.groupNewDialog.visible=!0},groupMerge:function(t){this.groupMergeDialog.visible=!0,this.groupMergeDialogData={groupNo:t.groupNo,topic:{id:t.topic.id,code:t.topic.code},namespace:{id:t.namespace.id,code:t.namespace.code}}},groupMergeConfirm:function(){},groupMergeCancel:function(){this.groupMergeDialog.visible=!1,this.getList()},addPartition:function(t){this.addPartitionDialog.visible=!0,this.addPartitionDialogData=t},addPartitionConfirm:function(){var t=this;this.addPartitionDialogData.partitionsCount<=0||o.a.post(this.urls.addPartition,{},this.addPartitionDialogData).then(function(i){200==i.code?(t.addPartitionDialog.visible=!1,t.$Dialog.success({content:"添加成功"}),t.getList()):t.$Dialog.error({content:"操作失败"})})},addPartitionCancel:function(){this.addPartitionDialog.visible=!1},removePartition:function(t){this.removePartitionDialog.visible=!0,this.removePartitionDialogData=t},removePartitionConfirm:function(){var t=this;this.removePartitionDialogData.partitionsCount<=0||o.a.post(this.urls.removePartition,{},this.removePartitionDialogData).then(function(i){200==i.code?(t.removePartitionDialog.visible=!1,t.$Dialog.success({content:"减少成功"}),t.getList()):t.$Dialog.error({content:"操作失败"})})},removePartitionCancel:function(){this.removePartitionDialog.visible=!1},del:function(t){var i=this,a=t;o.a.post(this.urls.del,{},a).then(function(t){i.$Message.success("删除成功"),i.getList()})},topicUpdate:function(){this.$emit("on-partition-group-change")},afterDel:function(){this.topicUpdate()}},mounted:function(){}},p={render:function(){var t=this,i=t.$createElement,a=t._self._c||i;return a("div",[a("div",{staticClass:"ml20 mt30"},[a("d-button",{attrs:{type:"primary"},on:{click:t.groupNew}},[t._v("扩容"),a("icon",{staticStyle:{"margin-left":"5px"},attrs:{name:"plus-circle"}})],1)],1),t._v(" "),a("my-table",{attrs:{data:t.tableData,showPin:t.showTablePin,page:t.page},on:{"on-size-change":t.handleSizeChange,"on-current-change":t.handleCurrentChange,"on-view-detail":t.goDetail,"on-scale":t.groupScale,"on-merge":t.groupMerge,"on-del":t.del,"on-addPartition":t.addPartition,"on-removePartition":t.removePartition}}),t._v(" "),a("my-dialog",{attrs:{dialog:t.groupDetailDialog},on:{"on-dialog-confirm":function(i){return t.groupDetailConfirm()},"on-dialog-cancel":function(i){return t.groupDetailCancel()}}},[a("group-detail",{attrs:{data:t.groupDetailDialogData}})],1),t._v(" "),a("my-dialog",{attrs:{dialog:t.groupScaleDialog},on:{"on-dialog-confirm":function(i){return t.groupScaleConfirm()},"on-dialog-cancel":function(i){return t.groupScaleCancel()}}},[a("group-scale",{attrs:{data:t.groupScaleDialogData}})],1),t._v(" "),a("my-dialog",{attrs:{dialog:t.groupMergeDialog},on:{"on-dialog-confirm":function(i){return t.groupMergeConfirm()},"on-dialog-cancel":function(i){return t.groupMergeCancel()}}},[a("group-merge",{attrs:{data:t.groupMergeDialogData}})],1),t._v(" "),a("my-dialog",{attrs:{dialog:t.addPartitionDialog},on:{"on-dialog-confirm":function(i){return t.addPartitionConfirm()},"on-dialog-cancel":function(i){return t.addPartitionCancel()}}},[a("d-input",{staticStyle:{width:"400px"},attrs:{placeholder:"请输入增加分区数"},model:{value:t.addPartitionDialogData.partitionCount,callback:function(i){t.$set(t.addPartitionDialogData,"partitionCount",i)},expression:"addPartitionDialogData.partitionCount"}},[a("span",{attrs:{slot:"prepend"},slot:"prepend"},[t._v("增加分区数")])])],1),t._v(" "),a("my-dialog",{attrs:{dialog:t.removePartitionDialog},on:{"on-dialog-confirm":function(i){return t.removePartitionConfirm()},"on-dialog-cancel":function(i){return t.removePartitionCancel()}}},[a("d-input",{staticStyle:{width:"400px"},attrs:{placeholder:"请输入减少分区数"},model:{value:t.removePartitionDialogData.partitionCount,callback:function(i){t.$set(t.removePartitionDialogData,"partitionCount",i)},expression:"removePartitionDialogData.partitionCount"}},[a("span",{attrs:{slot:"prepend"},slot:"prepend"},[t._v("减少分区数")])])],1),t._v(" "),a("my-dialog",{attrs:{dialog:t.groupNewDialog},on:{"on-dialog-confirm":function(i){return t.groupNewConfirm()},"on-dialog-cancel":function(i){return t.groupNewCancel()}}},[a("group-new",{attrs:{data:t.groupNewDialogData},on:{"on-dialog-confirm":function(i){return t.groupNewConfirm()},"on-dialog-cancel":function(i){return t.groupNewCancel()},"on-partition-group-change":t.topicUpdate}})],1)],1)},staticRenderFns:[]};var d=a("VU/8")(u,p,!1,function(t){a("hgeI")},"data-v-807c867c",null);i.default=d.exports},hgeI:function(t,i){}});
//# sourceMappingURL=29.32828545fd7d1616c5c9.js.map