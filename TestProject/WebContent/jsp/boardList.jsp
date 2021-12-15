<%@ page import="com.board.dto.BoardDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>                                                                                         
table {                                                                                         
	border: 1px solid black;                                                                    
	border-collapse: collapse;                                                                  
width: 95%;     ");
  	margin: auto;   ");
}                                                                                               
                                                                                                
thead {                                                                                         
	border-bottom: 1px solid black;                                                             
}                                                                                               
                                                                                                
tbody {                  ");
	text-align: center;   ");
}                        ");
.btn_wrap{                  ");
	margin-left: 90%;        ");
    margin-bottom: 5px;     ");
}                           ");
</style>                                                                                        
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>  
<script type="text/javascript">                                                               
$(document).ready(function(){                                                                   
	$("tbody").on("click","#title",function(){                                            
		$("#b_no").val($(this).attr("no"));                                                 
		$("#dtl_form").submit();                                                              
	});                                                                                         
	$("#write_btn").on("click",function(){                                                      
		location.href="boardWrite.do";                                                            
	});                                                                                             
});                                                                                             
</script>                                 
<body>
	<form action="boardDtl.do" id="dtl_form" method="get">                                    
		<input type="hidden" name="b_no" id="b_no" value ="">                               
	</form>                                                                                         
	<div class="btn_wrap">                                                                        
		<button type="button" id="write_btn">글 작성</button>                                   
	</div>                                                                                          
	<div class="search_wrap">                                                                     
		<form action="boardList.do" id="search_form" method="get">		                    
			<select name="gbn">                                                                   
				<option value="0">전체</option>                                                   
				<option value="1">제목</option>                                                   
				<option value="2">작성자</option>                                                 
			</select>                                                                               
			<input type="text" id="search_text" name="search_text">                           
			<button type="button">검색</button>	                                                
		</form>                                                                                     
	</div>                                                                                          
	<div>                                                                                           
		<table>                                                                                     
			<thead>                                                                                 
				<tr>                                                                                
					<th>글번호</th>                                                                 
					<th>제 목</th>                                                                  
					<th>작성자</th>                                                                 
					<th>작성일</th>                                                                 
					<th>조회수</th>                                                                 
				</tr>                                                                               
			</thead>                                                                                
			<tbody>                                                                                 
	
	<% 
	List<BoardDto> list = (ArrayList<BoardDto>)request.getAttribute("list");
	for ( BoardDto dto : list ){ 
	%>
	<tr>                                    
		<td><%= dto.getB_no() %></td>			               
		<td id="title" no="<%= dto.getB_no() %>"><%= dto.getB_title() %></td>		
		<td><%= dto.getB_writer() %></td>
		<td><%= dto.getB_date() %></td>	
		<td><%= dto.getB_hits() %></td>	
	</tr>                                   
	<%
	}
	%> 
</body>
</html>