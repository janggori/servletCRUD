<%@ page import="com.board.dto.BoardDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>                                                                                         
	.dtl_wrap {                                                                                 
		width: 800px;                                                                           
		height: 800px;                                                                          
		margin: auto;                                                                           
	}                                                                                           
                                                                                                
	.dtl_info_wrap{                                                                             
		display: flex;                                                                          
		width: 100%;                                                                            
		text-align: center;                                                                     
		margin-bottom: 5px;                                                                     
		padding-bottom: 5px;                                                                    
		border-bottom: 1px solid silver;		                                                
	}                                                                                           
	                                                                                            
	.a{                                                                                         
		width: 150px;                                                                           
	}                                                                                           
	                                                                                            
	.b{	                                                                                        
		width: 650px;                                                                           
	}                                                                                           
	.blank_div {                                                                                
		height: 21.6px;                                                                         
	}                                                                                           
	                                                                                            
	.dtl_content_wrap{                                                                          
		text-align: center;                                                                     
		margin: 20px;                                                                           
	}                                                                                           
	.dtl_title {                                                                                
		margin-bottom: 10px;		                                                            
	}                                                                                           
	                                                                                            
	.dtl_con{                                                                                   
		width: 750px;                                                                           
		height: 500px;		                                                                    
		                                                                                        
	}                                                                                           
	                                                                                            
	textarea {                                                                                  
		width: 100%;                                                                            
		height: 100%;                                                                           
		resize: none;                                                                           
	}                                                                                           
</style>                                                                                        
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>  
<script type="text/javascript">                                                               
$(document).ready(function(){                                                                   
	$("#update_btn").on("click",function(){                                                 
		$("#update_form").submit();                                                           
	});                                                                                         
	                                                                                            
	$("#delete_btn").on("click",function(){                                                 
		$("#delete_form").submit();                                                           
	});                                                                                         
	                                                                                            
	$("#back_btn").on("click",function(){                                                   
		location.href="boardList.do";                                                         
	});                                                                                         
});                                                                                             
</script>                                                                                       
</head>
<body>
	<% 
	BoardDto dto= (BoardDto)request.getAttribute("dto");
	%>
	<div class="dtl_wrap">                                                                      
		<div class="dtl_info_wrap">                                                             
			<div class="info_inner_wrap a">		                                              
				<div>                                                                             
					작성자 <%=dto.getB_writer()%>                                               
				</div>                                                                            
				<div>                                                                             
					작성일 <%=dto.getB_date()%>
				</div>                                                                            
			</div>                                                                                
			<div class="info_inner_wrap b">                                                     
				<div class="blank_div">                                                         
				</div>                                                                            
				<div>                                                                             
					조회수 <%=dto.getB_hits()%>
				</div>			                                                                  
			</div>                                                                                
		</div>                                                                                    
		<div class="dtl_content_wrap">                                                          
			<div class="dtl_title">                                                             
				 <%=dto.getB_title()%>                                                         
			</div>                                                                                
			<div class="dtl_con">                                                               
				<textarea rows="" cols=""><%=dto.getB_con()%></textarea>                     
			</div>                                                                                
		</div>	                                                                                  
		<div class="dtl_btn_wrap">                                                              
			<form action="boardUpdate.do" id="update_form" method="post">                   
				<input type="hidden" name="b_no" value="<%=dto.getB_no()%>">			  
				<input type="hidden" name="b_title" value="<%=dto.getB_title()%>">		
				<input type="hidden" name="b_con" value="<%=dto.getB_con()%>">			  
				<input type="hidden" name="b_writer" value="<%=dto.getB_writer()%>">		
			</form>                                                                               
			<form action="boardDelete.do" id="delete_form" method="post">                   
				<input type="hidden" name="b_no" value="<%=dto.getB_no()%>">               
			</form>                                                                               
			<button type="button" id="update_btn">수정</button>                               
			<button type="button" id="delete_btn">삭제</button>                               
			<button type="button" id="back_btn">목록</button>                                 
		</div>                                                                                    
	</div>                                                                                        
</body>
</html>