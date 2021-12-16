<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>  
<script type="text/javascript">                                                           
$(document).ready(function(){                                                               
	alert("글 삭제에 실패하였습니다.");                                                   
	$("#delete_form").submit();                                                           
});                                                                                         
</script>                                                                                   
<body>
<body>                                                                                      
<form action="boardDtl.do" id="delete_form" method="get">                             
	<input type="hidden" name="b_no" value="<%=request.getParameter("b_no") %>">                                  
</form>                                                                                     
</body>
</html>