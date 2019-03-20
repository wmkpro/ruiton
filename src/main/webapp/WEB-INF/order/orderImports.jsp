<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <%@ include file="/WEB-INF/js_css.jsp" %>
        <script type="text/javascript">
		$(function() {
			showRetInfoParent('${resultCode.code}','${resultCode.msg}');
		});
	</script>
  </head>
  
  <body>
   <form method="post"
		action="${basePath}/order/imports"
		enctype="multipart/form-data">
		<table style="line-height: 3">
			<tr>
				<td align="right">选择Excel文件：</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="确定导入数据" /></td>
			</tr>
		</table>
	</form>
  </body>
</html>
