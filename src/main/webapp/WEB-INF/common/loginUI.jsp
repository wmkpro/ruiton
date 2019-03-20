<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>登录</title>     
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
    		 data["pwd"]=MD5($("#pwd").val());
    		 data["userName"]=$("#userName").val();
             $.post("${basePath}common/login",data,function(data) {
            	 	var code=data.code;
            		var msg=data.msg;
            		if (code == '0000') {
            			$.ligerDialog.success(msg);
            			location.href="${basePath}index.htm";
            		} else if (code == '9999') {
            			$.ligerDialog.error(msg);
            		}
	    	});
    	 }
     }
 
    </script>
    <style type="text/css">
            body{font-size:13px;margin: 0 auto}
            h1{font-size:20px;font-family:Verdana;}
            h4{font-size:16px;margin-top:25px;margin-bottom:10px;}
            .description{padding-bottom:30px;font-family:Verdana;}
            .description h3{color:#CC0000;font-size:16px;margin:0 30px 10px 0px;padding:45px 0 8px;border-bottom:solid 1px #888;}
			td {padding: 5px;}
    </style>

</head>
<body style="padding:0px">
    <form id="form1" >
        <table style="margin-left:35%;margin-top: 15%">
        	<tr>
                <td style="font-size:20px;" colspan="2">欢迎来到登录系统</td>
            </tr>
            <tr>
                <td><label for="no">用户名：</label></td>
                <td><input id="userName"  name="userName" type="text" class="ui-textbox"  validate="{required:true}"  /></td>
            </tr>
            <tr>
                <td> <label for="address">密  	码：</label></td>
                <td> <input id="pwd" name="pwd" type="password" class="ui-textbox"  validate="{required:true}" /></td>
            </tr>
            <tr>
                <td>
                    
                </td>
                <td>
                    <input value=" 登录  " type="button" onclick="submitForm()" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

