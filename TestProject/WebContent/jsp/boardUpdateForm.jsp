<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>                                                                                            
	.update_wrap{                                                                                  
		margin: auto;	                                                                           
	}                                                                                              
	                                                                                               
	                                                                                               
	.con_wrap {                                                                                    
		width: 800px;                                                                              
		height: 400px;                                                                             
	}                                                                                              
	                                                                                               
	textarea {                                                                                     
		width: 100%;                                                                               
		height:80%;                                                                                
		resize: none;			                                                                   
	}                                                                                              
</style>                                                                                           
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>     
<script type="text/javascript">                                                                  
$(document).ready(function(){                                                                      
	$("#b_con").on("keyup",function(){                                                         
		$("#text_cnt").html("("+$(this).val().length+" / 2000)");                            
		                                                                                           
		if($(this).val().length > 2000){                                                           
			$(this).val($(this).val().substring(0,2000));                                          
			$("#text_cnt").html("(2000 / 2000)");			                                   
		}                                                                                          
	});                                                                                            
	                                                                                               
	$("#update_btn").on("click",function(){                                                    
		$("#update_form").submit();                                                              
	});                                                                                            
	                                                                                               
	$("#back_btn").on("click",function(){                                                      
		history.back();                                                                            
	});                                                                                            
});                                                                                                
</script>          
<body>
<div class="update_wrap">                                                                        
	<form action="boardUpdateRun.do" id="update_form" method="post">                         
		<input type="hidden" name="b_no" value="<%=request.getParameter("b_no") %>">		
		<div class="title_wrap">                                                                 
			<input type="text" id="b_title" name="b_title" placeholder="제목을 입력해주세요." value="<%=request.getParameter("b_title") %>">       
		</div>                                                                                           
		<div class="writer_wrap">                                                                      
			<input type="text" id="b_writer" name="b_writer" placeholder="이름을 입력해주세요." value="<%=request.getParameter("b_writer") %>">     
		</div>                                                                                            
		<div class="con_wrap">                                                                          
			<textarea rows="" cols="" id="b_con" name="b_con" placeholder="내용을 입력해주세요."><%=request.getParameter("b_con") %></textarea>
			<div id="text_cnt">(0 / 2000)</div>                                                         
		</div>                                                                                            
	</form>                                                                                               
<div class="btn_wrap">
	<button type="button" id="update_btn">수정하기</button>                                           
	<button type="button" id="back_btn">목록</button>                                                 
</div>                                                                                                    
</div>                                                                                                    
</body>
</html>