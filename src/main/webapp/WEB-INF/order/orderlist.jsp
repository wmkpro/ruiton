<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>     
    <%@ include file="/WEB-INF/js_css.jsp" %>
    <script type="text/javascript">
		//搜索参数
    	var params = {};
		var searchData="";
		var grid;
        $(function (){
        	load();
        	loadBar();//导航
        });
        
        var impmenu = {
        		width : 120,
        		items : [ {text : "导出",click : exports}
        				 ,{ line: true }
        				 ,{text : "导入",click : imports}
        				]
        };
        function loadBar(){
        	$("#menuBar").ligerMenuBar({
    			items : [ {text : "导入/导出",menu : impmenu} ]
    		});
        }
        function exports(){
    		location.href = "${basePath}order/exports?searchData=" + searchData;
        }
        function imports(){
        	$.ligerDialog.open({
   				url : '${basePath}order/importsUI',
   				width : 530,
   				height : 380,
   				title : "导入数据",
   				showMax : true,
   				showToggle : true,
   				showMin : true,
   				isResize : true
   			});
        }
        
         //搜索字段
    	var searchfields = [ 
    	                     {display : "客户",name : "customerName",editor : {type : "String"}}
    	                     , {display : "订单号",name : "orderNo",editor : {type : "String"}}
    	                     , {display : "接单日期",name : "receiptTime",type : "date",editor : {type : "date",options : {showTime : true,format : "yyyy-MM-dd"}}}
    	                     /*, {display : "状态",name : "status",editor : {type : "combobox",
    	           				 										  options : {
    																		valueField : "statusVal",textField : "statusTxt",
														    				data : [ {statusVal : "0",statusTxt : "未使用(启用)"}, 
														    				         {statusVal : 1,statusTxt : "已使用(停用)"}, 
														    				         {statusVal : 2,statusTxt : "已使用未投资"}, 
														    				         {statusVal : 3,statusTxt : "使用中"} 
														    				       ]
    	                                                                   }
    																	  }
    					      }*/
    	                ];
      
        function load(){
        	grid=$("#maingrid").ligerGrid({
                height: '98%',
                columns: [
                { display: 'id', name: 'id',hide:true},
                { display: '序号', name: 'no', width: 100, minWidth: 60 },
                { display: '区域', name: 'area', minWidth: 120 },
                { display: '单位', name: 'address', minWidth: 140 },
                { display: '客户', name: 'customerName',minWidth: 140 },
                { display: '重量', name: 'weight', minWidth: 140 },
                { display: '患者', name: 'patient', minWidth: 140 },
                { display: '订单号', name: 'orderNo', minWidth: 140 },
                { display: '付款单位', name: 'paymentUnit', minWidth: 140 },
                { display: '接单日期', name: 'receiptTime', minWidth: 140,
                	render: function(rowdata, rowindex, value) {
        				return  yyyyMMdd(value);
        			}	
                },
                { display: '出货日期', name: 'shipmentTime', minWidth: 140 ,
                	render: function(rowdata, rowindex, value) {
        				return  yyyyMMdd(value);
        			}	
                },
                { display: '有效日期', name: 'effectiveTime', minWidth: 140 ,
                    	render: function(rowdata, rowindex, value) {
            				return  yyyyMMdd(value);
            			}	
        		},
        		
        		{ display: '型号', name: 'model', minWidth: 140 },
                { display: '全口/单颌', name: 'singlejaw', minWidth: 140 },
                { display: '材料', name: 'material', minWidth: 140 },
                { display: '价格', name: 'price', minWidth: 140 },
                { display: '材料', name: 'material', minWidth: 140 },
                { display: '付款情况', name: 'paymentDesc', minWidth: 140 },
                { display: '付款日期', name: 'paymentTime', minWidth: 140 ,
                	render: function(rowdata, rowindex, value) {
        				return  yyyyMMdd(value);
        			}	
                },
                { display: '备注', name: 'remark', minWidth: 140 },
                { display: 'eBrace/eLoc', name: 'eBrace', minWidth: 140 },
                { display: '跟单员', name: 'followPerson', minWidth: 140 },
                { display: '销售员', name: 'salePerson', minWidth: 140 }
                ],
                url: "${basePath}order/orderlist",
                parms: params,
                pageSize: 10, pageSizeOptions: [10, 20, 30, 40, 50], rownumbers: true,
                checkbox : true,// 复选
				rownumbers : false,//行号隐藏
                toolbar: {
                    items: [
                    { text: '增加', click: add, icon: 'add' },
                    { line: true },
                    { text: '修改', click: upd, icon: 'modify' },
                    { line: true },
                    { text: '删除', click: del, img: '${basePath}lib/ligerUI/skins/icons/delete.gif' },
                    {text : "高级查询",type : "quty",click : search,icon : "search2"}
                    ]
                }
                //,autoFilter: true
            });
              
            $("#pageloading").hide();
        }
        //新增
        function add(item)
        {
        	$.ligerDialog.open({
        		width: 800,
        		height: 600,
        		title: "新增",
        		url: "${basePath}/order/addOrderUI",
        		showMax: true,
        		showToggle: true,
        		showMin: true,
        		isResize: true
        	});
        }
      	//修改
        function upd(item) {
        	var rows = grid.getCheckedRows();
    		var idStr = "",flag=false;
    		$(rows).each(function() {
    			if ($.trim(idStr).length > 0) {
    				flag=true;
    				$.ligerDialog.error("只能选择一行");
    				return ;
    			} else {
    				idStr = this.id;
    			}
    		});
    		if(flag){
    			return ;
    		}
    		if(idStr==""){
    			$.ligerDialog.error("请选择一行数据");
    			return ;
    		}
        	$.ligerDialog.open({
        		width: 800,
        		height: 600,
        		title: "修改",
        		url: "${basePath}/order/updOrderUI?id=" + idStr,
        		showMax: true,
        		showToggle: true,
        		showMin: true,
        		isResize: true
        	});
        }
 		//删除
        function del(item)
        {
        	var rows = grid.getCheckedRows();
    		var idStr = "";
    		$(rows).each(function() {
    			if ($.trim(idStr).length > 0) {
    				idStr += "," + this.id;
    				return ;
    			} else {
    				idStr = this.id;
    			}
    		});
    		if(idStr==""){
    			$.ligerDialog.error("请选择要删除的数据");
    			return ;
    		}
    		$.ligerDialog.confirm('确定要删除吗？', function (yes) {
    			if(yes){
    				$.post("${basePath}order/delOrder?ids="+idStr, function(data) {
    	    			if (data.code=="0000") {
    	    				$.ligerDialog.success(data.msg);
    	    				load();
    	    			} else if (data.code =="9999") {
    	    				$.ligerDialog.error(data.msg);
    	    			}
    	    		});
    			}
    		});
        }
        //搜索
        function search(){
        	if (window.winfilter) {
    			window.winfilter.show();
    		} else {
    			var filtercontainer = $("<div id=\"filtercontainer\"></div>").width(500).height(200).hide();
    			window.filter = filtercontainer.ligerFilter({fields : searchfields});
    			window.winfilter = $.ligerDialog.open({
    				width : 540,
    				height : 288,
    				target : filtercontainer,
    				isResize : true,
    				top : 50,
    				buttons : [ {
    					text : "确定",
    					onclick : function(item, dialog) {
    						var group = window.filter.getData();
    						searchData= JSON.stringify(group);
    						gridRefresh();
    						dialog.hide();
    					}
    				},{
    					text : "取消",
    					onclick : function(item, dialog) {
    						dialog.hide();
    					}
    				}]
    			});
    		}
        }
        //刷新列表
        function gridRefresh() {
    		if (grid!=null) {
    			params["searchData"] = searchData;
    			var p = grid.options;
    			p.newPage = 1;
    			grid.loadServerData(params);
    		}
    	}
        
 
    </script>

  </head>
  
  <body>
  	<div id="menuBar"></div>
    <div id="maingrid"></div>
  </body>
</html>
