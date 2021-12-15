package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dao.BoardDaoImpl;
import com.board.dto.BoardDto;


/**
 * Servlet implementation class boardListServlet
 */
public class boardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException 
	{
		BoardDao dao = new BoardDaoImpl();
		
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		List<BoardDto> list = dao.boardList(searchType, searchText);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/boardList.jsp");
		rd.forward(request, response);
		
//		PrintWriter out = response.getWriter();
//		BoardDao    dao = new BoardDaoImpl();
//		
//		String gbn        = request.getParameter("gbn");
//		String searchText = request.getParameter("search_text");
//		
//		List<BoardDto> list = dao.boardList(gbn, searchText);
//		
//		out.println("<!DOCTYPE html>           ");
//		out.println("<html>                    ");
//		out.println("<head>                    ");
//		out.println("<meta charset=\"UTF-8\">    ");
//		out.println("<title>Index Page</title> ");
//		out.println("</head>                   ");
//		out.println("<style>                                                                                         ");
//		out.println("table {                                                                                         ");
//		out.println("	border: 1px solid black;                                                                     ");
//		out.println("	border-collapse: collapse;                                                                   ");
//		out.println("width: 95%;     ");
//    	out.println("margin: auto;   ");
//		out.println("}                                                                                               ");
//		out.println("                                                                                                ");
//		out.println("thead {                                                                                         ");
//		out.println("	border-bottom: 1px solid black;                                                              ");
//		out.println("}                                                                                               ");
//		out.println("                                                                                                ");
//		out.println("tbody {                  ");
//		out.println("	text-align: center;   ");
//		out.println("}                        ");
//		out.println(".btn_wrap{                  ");
//		out.println("	margin-left: 90%;        ");
//		out.println("    margin-bottom: 5px;     ");
//		out.println("}                           ");
//		out.println("</style>                                                                                        ");
//		out.println("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.min.js\"></script>      ");
//		out.println("<script type=\"text/javascript\">                                                                 ");
//		out.println("$(document).ready(function(){                                                                   ");
//		out.println("	$(\"tbody\").on(\"click\",\"#title\",function(){                                                   ");
//		out.println("		$(\"#b_no\").val($(this).attr(\"no\"));                                                      ");
//		out.println("		$(\"#dtl_form\").submit();                                                                  ");
//		out.println("	});                                                                                          ");
//		out.println("$(\"#write_btn\").on(\"click\",function(){                                                        ");
//		out.println("	location.href=\"boardWrite.do\";                                                               ");
//		out.println("});                                                                                               ");
//		out.println("});                                                                                             ");
//		out.println("</script>                                                                                       ");
//		out.println("<body>                                                                                          ");
//		out.println("<form action=\"boardDtl.do\" id=\"dtl_form\" method=\"get\">                                          ");
//		out.println("	<input type=\"hidden\" name=\"b_no\" id=\"b_no\" value =\"\">                                        ");
//		out.println("</form>                                                                                         ");
//		out.println("<div class=\"btn_wrap\">                                                                             ");
//		out.println("	<button type=\"button\" id=\"write_btn\">글 작성</button>                                                          ");
//		out.println("</div>                                                                                             ");
//		out.println("<div class=\"search_wrap\">                                                                          ");
//		out.println("	<form action=\"boardList.do\" id=\"search_form\" method=\"get\">		                                                                        ");
//		out.println("		<select name=\"gbn\">                                                                            ");
//		out.println("			<option value=\"0\">전체</option>                                                            ");
//		out.println("			<option value=\"1\">제목</option>                                                            ");
//		out.println("			<option value=\"2\">작성자</option>                                                          ");
//		out.println("		</select>                                                                                      ");
//		out.println("		<input type=\"text\" id=\"search_text\" name=\"search_text\">                                     ");
//		out.println("		<button type=\"button\">검색</button>	                                                        ");
//		out.println("	</form>                                                                                         ");
//		out.println("</div>                                                                                             ");
//		out.println("<div>                                                                                           ");
//		out.println("	<table>                                                                                      ");
//		out.println("		<thead>                                                                                  ");
//		out.println("			<tr>                                                                                 ");
//		out.println("				<th>글번호</th>                                                                  ");
//		out.println("				<th>제 목</th>                                                                   ");
//		out.println("				<th>작성자</th>                                                                  ");
//		out.println("				<th>작성일</th>                                                                  ");
//		out.println("				<th>조회수</th>                                                                  ");
//		out.println("			</tr>                                                                                ");
//		out.println("		</thead>                                                                                 ");
//		out.println("		<tbody>                                                                                  ");
//		
//		for ( BoardDto dto : list ) 
//		{
//			out.println("<tr>                                    ");
//			out.println("	<td>"+dto.getB_no()+"</td>			                 ");
//			out.println("	<td id=\"title\" no=\""+dto.getB_no()+"\">"+ dto.getB_title() +"</td>");			
//			out.println("	<td>"+ dto.getB_writer() +"</td>			     ");
//			out.println("	<td>"+ dto.getB_date() +"</td>			     ");
//			out.println("	<td>"+ dto.getB_hits() +"</td>			     ");
//			out.println("</tr>                                   ");
//		}
//		out.println("</body>                   ");
//		out.println("</html>                   ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
