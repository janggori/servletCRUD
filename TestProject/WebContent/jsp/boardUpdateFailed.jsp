<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript">                                                              
$(document).ready(function(){                                                              
	alert("글 수정에 실패하였습니다.");                                                  
	$("#update_form").submit();                                                    
});                                                                                        
</script>         
</head>
<body>	
	<form action="boardDtl.do" id="update_form" method="get">                            
		<input type="hidden" name="b_no" value="<%=request.getParameter("b_no") %>">                               
	</form>   
</body>
</html>