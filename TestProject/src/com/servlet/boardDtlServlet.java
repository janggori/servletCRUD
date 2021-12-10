package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dao.BoardDaoImpl;
import com.board.dto.BoardDto;

/**
 * Servlet implementation class boardDtlServlet
 */
public class boardDtlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardDtlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String b_no = request.getParameter("b_no");

		if(b_no != null && b_no != "") {
			int no = Integer.parseInt(b_no);
			
			BoardDao dao = new BoardDaoImpl();
			Cookie[] cookies = request.getCookies();
			Cookie compCookie = null;
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("postView"+b_no)) {
						compCookie = cookie;
					}
				}
			}
			
			if(compCookie == null) {
				Cookie cookie = new Cookie("postView"+ b_no, "["+ b_no + "]");
				
				response.addCookie(cookie);
				
				int result = dao.viewCntUp(no);
				
				if(result > 0) {
					System.out.println("조회수 증가");
				} else {
					System.out.println("조회수 에러");
				}
			}
			
			BoardDto dto = dao.selectOne(no);
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>                                                                                   ");
			out.println("<html>                                                                                            ");
			out.println("<head>                                                                                            ");
			out.println("<meta charset=\"UTF-8\">                                                                            ");
			out.println("<title>Insert title here</title>                                                                  ");
			out.println("</head>                                                                                           ");
			out.println("<style>                                                                                           ");
			out.println("	.dtl_wrap {                                                                                    ");
			out.println("		width: 800px;                                                                              ");
			out.println("		height: 800px;                                                                             ");
			out.println("		margin: auto;                                                                              ");
			out.println("	}                                                                                              ");
			out.println("                                                                                                  ");
			out.println("	.dtl_info_wrap{                                                                                ");
			out.println("		display: flex;                                                                             ");
			out.println("		width: 100%;                                                                               ");
			out.println("		text-align: center;                                                                        ");
			out.println("		margin-bottom: 5px;                                                                        ");
			out.println("		padding-bottom: 5px;                                                                       ");
			out.println("		border-bottom: 1px solid silver;		                                                   ");
			out.println("	}                                                                                              ");
			out.println("	                                                                                               ");
			out.println("	.a{                                                                                            ");
			out.println("		width: 150px;                                                                              ");
			out.println("	}                                                                                              ");
			out.println("	                                                                                               ");
			out.println("	.b{	                                                                                           ");
			out.println("		width: 650px;                                                                              ");
			out.println("	}                                                                                              ");
			out.println("	.blank_div {                                                                                   ");
			out.println("		height: 21.6px;                                                                            ");
			out.println("	}                                                                                              ");
			out.println("	                                                                                               ");
			out.println("	.dtl_content_wrap{                                                                             ");
			out.println("		text-align: center;                                                                        ");
			out.println("		margin: 20px;                                                                              ");
			out.println("	}                                                                                              ");
			out.println("	.dtl_title {                                                                                   ");
			out.println("		margin-bottom: 10px;		                                                               ");
			out.println("	}                                                                                              ");
			out.println("	                                                                                               ");
			out.println("	.dtl_con{                                                                                      ");
			out.println("		width: 750px;                                                                              ");
			out.println("		height: 500px;		                                                                       ");
			out.println("		                                                                                           ");
			out.println("	}                                                                                              ");
			out.println("	                                                                                               ");
			out.println("	textarea {                                                                                     ");
			out.println("		width: 100%;                                                                               ");
			out.println("		height: 100%;                                                                              ");
			out.println("		resize: none;                                                                              ");
			out.println("	}                                                                                              ");
			out.println("</style>                                                                                          ");
			out.println("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-latest.min.js\"></script>        ");
			out.println("<script type=\"text/javascript\">                                                                   ");
			out.println("$(document).ready(function(){                                                                     ");
			out.println("	$(\"#update_btn\").on(\"click\",function(){                                                        ");
			out.println("		$(\"#update_form\").submit();                                                                ");
			out.println("	});                                                                                            ");
			out.println("	                                                                                               ");
			out.println("	$(\"#delete_btn\").on(\"click\",function(){                                                        ");
			out.println("		$(\"#delete_form\").submit();                                                                ");
			out.println("	});                                                                                            ");
			out.println("	                                                                                               ");
			out.println("	$(\"#back_btn\").on(\"click\",function(){                                                          ");
			out.println("		location.href=\"boardList.do\";                                                              ");
			out.println("	});                                                                                            ");
			out.println("});                                                                                               ");
			out.println("</script>                                                                                         ");
			out.println("<body>                                                                                            ");
			out.println("<div class=\"dtl_wrap\">                                                                            ");
			out.println("	<div class=\"dtl_info_wrap\">                                                                    ");
			out.println("		<div class=\"info_inner_wrap a\">		                                                       ");
			out.println("			<div>                                                                                  ");
			out.println("				작성자 " + dto.getB_writer() +"                                                                            ");
			out.println("			</div>                                                                                 ");
			out.println("			<div>                                                                                  ");
			out.println("				작성일 " + dto.getB_date() +"                                                                             ");
			out.println("			</div>                                                                                 ");
			out.println("		</div>                                                                                     ");
			out.println("		<div class=\"info_inner_wrap b\">                                                            ");
			out.println("			<div class=\"blank_div\">                                                                ");
			out.println("			</div>                                                                                 ");
			out.println("			<div>                                                                                  ");
			out.println("				조회수 " + dto.getB_hits() +"                                                                             ");
			out.println("			</div>			                                                                       ");
			out.println("		</div>                                                                                     ");
			out.println("	</div>                                                                                         ");
			out.println("	<div class=\"dtl_content_wrap\">                                                                 ");
			out.println("		<div class=\"dtl_title\">                                                                    ");
			out.println("			 " + dto.getB_title() +"                                                                                   ");
			out.println("		</div>                                                                                     ");
			out.println("		<div class=\"dtl_con\">                                                                      ");
			out.println("			<textarea rows=\"\" cols=\"\">"+ dto.getB_con() +"</textarea>                                              ");
			out.println("		</div>                                                                                     ");
			out.println("	</div>	                                                                                       ");
			out.println("	<div class=\"dtl_btn_wrap\">                                                                     ");
			out.println("		<form action=\"boardUpdate.do\" id=\"update_form\" method=\"post\">                              ");
			out.println("			<input type=\"hidden\" name=\"b_no\" value=\"" + dto.getB_no() +"\">			                                   ");
			out.println("			<input type=\"hidden\" name=\"b_title\" value=\"" + dto.getB_title() +"\">			                               ");
			out.println("			<input type=\"hidden\" name=\"b_con\" value=\"" + dto.getB_con() +"\">			                                   ");
			out.println("			<input type=\"hidden\" name=\"b_writer\" value=\""+ dto.getB_writer() +"\">			                               ");
			out.println("		</form>                                                                                    ");
			out.println("		<form action=\"boardDelete.do\" id=\"delete_form\" method=\"post\">                              ");
			out.println("			<input type=\"hidden\" name=\"b_no\" value=\""+ dto.getB_no() +"\">                                             ");
			out.println("		</form>                                                                                    ");
			out.println("		<button type=\"button\" id=\"update_btn\">수정</button>                                        ");
			out.println("		<button type=\"button\" id=\"delete_btn\">삭제</button>                                        ");
			out.println("		<button type=\"button\" id=\"back_btn\">목록</button>                                          ");
			out.println("	</div>                                                                                         ");
			out.println("</div>                                                                                            ");
			out.println("</body>                                                                                           ");
			out.println("</html>                                                                                           ");
		} else {
			response.sendRedirect("/TestProject/boardList.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
