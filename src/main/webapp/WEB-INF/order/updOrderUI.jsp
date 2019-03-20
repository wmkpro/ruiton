<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>修改数据</title>     
   <%@ include file="/WEB-INF/js_css.jsp" %>
    
    <script type="text/javascript">
        $(function ()
        {
            $("#form1").ligerForm({
                validate: true
            });	
           
        });
      //校验通过
     function valid()
     {
         var form = liger.get("form1");
         return form.valid();
     }
     
     function submitForm()
     {
    	 if(valid()){
    		 var data = {};
             $("input,select,textarea").each(function ()
             {
                 var name = $(this).attr("name");
                 if (name && name.indexOf('ligerui') == -1)
                 {
                     data[name] = this.value;
                 }
             });
             data["id"]="${vo.id}";
             $.post("${basePath}order/updOrder",data,function(data) {
            	 addOrUpdateRetInfoParent(data);
	    	});
    	 }
     }
 
    </script>
    <style type="text/css">
            body{padding-left:10px;font-size:13px;}
            h1{font-size:20px;font-family:Verdana;}
            h4{font-size:16px;margin-top:25px;margin-bottom:10px;}
            .description{padding-bottom:30px;font-family:Verdana;}
            .description h3{color:#CC0000;font-size:16px;margin:0 30px 10px 0px;padding:45px 0 8px;border-bottom:solid 1px #888;}
			td {padding: 5px;}
    </style>

</head>
<body style="padding:0px">
    <form id="form1" >
    	<table>
            <tr>
                <td><label for="no">序号：</label></td>
                <td><input id="no"  name="no" type="text" value="${vo.no}" class="ui-textbox"  validate="{required:true}"  /></td>
                <td><label for="area">区域：</label></td>
                <td><input id="area" name="area" type="text" value="${vo.area}" class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="address">单位：</label></td>
                <td> <input id="address" name="address" type="text" value="${vo.address}" class="ui-textbox"  validate="{required:true}" /></td>
                <td><label for="customerName">客户：</label></td>
                <td><input id="customerName" name="customerName" type="text" value="${vo.customerName}" class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="weight">重量：</label></td>
                <td> <input id="weight" name="weight" type="text" value="${vo.weight}" class="ui-textbox"  validate="{required:true}" /></td>
                <td><label for="patient">患者：</label></td>
                <td><input id="patient" name="patient" type="text" value="${vo.patient}"  class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="orderNo">订单号：</label></td>
                <td> <input id="orderNo" name="orderNo" type="text"  value="${vo.orderNo}"   class="ui-textbox"  validate="{required:true}" /></td>
                <td><label for="paymentUnit">付款单位：</label></td>
                <td><input id="paymentUnit" name="paymentUnit" type="text" value="${vo.paymentUnit}"   class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="receiptTime">接单日期：</label></td>
                <td> <input id="receiptTime" name="receiptTime" type="text" value="<fmt:formatDate value="${vo.receiptTime}" pattern="yyyy-MM-dd"/>" class="ui-datepicker" validate="{required:true}" /></td>
                <td><label for="shipmentTime">出货日期：</label></td>
                <td><input id="shipmentTime" name="shipmentTime" type="text" value="<fmt:formatDate value="${vo.shipmentTime}" pattern="yyyy-MM-dd"/>" class="ui-datepicker"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="effectiveTime">有效日期：</label></td>
                <td> <input id="effectiveTime" name="effectiveTime" type="text" value="<fmt:formatDate value="${vo.effectiveTime}" pattern="yyyy-MM-dd"/>" class="ui-datepicker"  validate="{required:true}" /></td>
                <td><label for="singlejaw">全口/单颌：</label></td>
                <td><input id="singlejaw" name="singlejaw" type="text" value="${vo.singlejaw}" class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="material">材料：</label></td>
                <td> <input id="material" name="material" type="text" value="${vo.material}"  class="ui-textbox"  validate="{required:true}" /></td>
                <td><label for="price">价格：</label></td>
                <td><input id="price" name="price" type="text" value="${vo.price}"   class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="paymentDesc">付款情况：</label></td>
                <td> <input id="paymentDesc" name="paymentDesc" type="text"  value="${vo.paymentDesc}"  class="ui-textbox"  validate="{required:true}" /></td>
                <td><label for="paymentTime">付款日期：</label></td>
                <td><input id="paymentTime" name="paymentTime" type="text" value="<fmt:formatDate value="${vo.paymentTime}" pattern="yyyy-MM-dd"/>"  class="ui-datepicker"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="remark">备注：</label></td>
                <td> <textarea id="remark" name="remark" class="ui-textarea l-textarea" style="width:178px" validate="{required:true}">${vo.remark}</textarea></td>
                <td><label for="eBrace">eBrace/eLoc：</label></td>
                <td><input id="eBrace" name="eBrace" type="text" value="${vo.eBrace}" class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td> <label for="followPerson">跟单员：</label></td>
                <td> <input id="followPerson" name="followPerson" type="text" value="${vo.followPerson}" class="ui-textbox"  validate="{required:true}" /></td>
                <td><label for="salePerson">销售员：</label></td>
                <td><input id="salePerson" name="salePerson" type="text" value="${vo.salePerson}" class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
            	<td> <label for="model">型号：</label></td>
                <td> <input id="model" name="model" type="text" value="${vo.model}" class="ui-textbox"  validate="{required:true}" /></td>
            	<td></td>
                <td></td>
            </tr>
            <tr>
                <td>
                    
                </td>
                <td>
                    <input value=" 提交  " type="button" onclick="submitForm()" />
                    
                </td>
            </tr>
        </table>
    </form>

</body>
</html>

