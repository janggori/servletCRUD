<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>                                                                                             
	.write_wrap{                                                                                    
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
	                                                                                                
	$("#write_btn").on("click",function(){                                                      
		$("#write_form").submit();                                                                
	});                                                                                             
	                                                                                                
	$("#back_btn").on("click",function(){                                                       
		history.back();                                                                             
	});                                                                                             
});                                                                                                 
</script>
</head>
<body>
		<div class="write_wrap">                                                                          
			<form action="boardInsert.do" id="write_form" method="post">                              
				<div class="title_wrap">                                                                  
					<input type="text" id="b_title" name="b_title" placeholder="제목을 입력해주세요.">
				</div>                                                                                      
				<div class="writer_wrap">                                                                 
					<input type="text" id="b_writer" name="b_writer" placeholder="이름을 입력해주세요">
				</div>                                                                                      
				<div class="con_wrap">                                                                    
					<textarea rows="" cols="" id="b_con" name="b_con" placeholder="내용을 입력해주세요."></textarea>
					<div id="text_cnt">(0 / 2000)</div>                                                     
				</div>                                                                                        
			</form>                                                                                           
		<div class="btn_wrap">
			<button type="button" id="write_btn">글쓰기</button>                                          
			<button type="button" id="back_btn">목록</button>                                             
		</div>                                                                                                
		</div>                                                                                                
</body>
</html>