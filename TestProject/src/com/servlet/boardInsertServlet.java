package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dao.BoardDaoImpl;


/**
 * Servlet implementation class boardInsertServlet
 */
public class boardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDaoImpl();
		String title = request.getParameter("b_title");
		String writer = request.getParameter("b_writer");
		String con = request.getParameter("b_con");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(con);
		
		int result = dao.insertBoard(title, writer, con);
		
//		PrintWriter out = response.getWriter();
		if(result > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/boardInsertSuccess.jsp");
			rd.forward(request, response);
//			out.println("<!DOCTYPE html>                                                                              ");
//			out.println("<html>                                                                                       ");
//			out.println("<head>                                                                                       ");
//			out.println("<meta charset=\"UTF-8\">                                                                       ");
//			out.println("<title>Insert title here</title>                                                             ");
//			out.println("</head>                                                                                      ");
//			out.println("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.min.js\"></script>   ");
//			out.println("<script type=\"text/javascript\">                                                              ");
//			out.println("$(document).ready(function(){                                                                ");
//			out.println("	alert(\"글 등록이 완료되었습니다.\");                                                           ");
//			out.println("	location.href=\"boardList.do\";                                                             ");
//			out.println("});                                                                                          ");
//			out.println("</script>                                                                                    ");
//			out.println("<body>                                                                                       ");
//			out.println("</body>                                                                                      ");
//			out.println("</html>                                                                                      ");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/boardInsertFailed.jsp");
			rd.forward(request, response);
//			out.println("<!DOCTYPE html>                                                                              ");
//			out.println("<html>                                                                                       ");
//			out.println("<head>                                                                                       ");
//			out.println("<meta charset=\"UTF-8\">                                                                       ");
//			out.println("<title>Insert title here</title>                                                             ");
//			out.println("</head>                                                                                      ");
//			out.println("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.min.js\"></script>   ");
//			out.println("<script type=\"text/javascript\">                                                              ");
//			out.println("$(document).ready(function(){                                                                ");
//			out.println("	alert(\"글 등록에 실패하였습니다.\");                                                             ");
//			out.println("	location.href=\"boardList.do\";                                                             ");
//			out.println("});                                                                                          ");
//			out.println("</script>                                                                                    ");
//			out.println("<body>                                                                                       ");
//			out.println("</body>                                                                                      ");
//			out.println("</html>                                                                                      ");			
		}
	}

}
