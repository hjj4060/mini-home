package fileGallary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/filegallary/deletecomment")
public class DeleteCommentController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		try {
			GallaryDAO dao = new GallaryDAO();
			dao.deleteComment(commentNo);
			
			
			response.sendRedirect(
					request.getContextPath() + "/jsp/filegallary/detailfilegallary"
							+ "?homepage_no="+request.getParameter("homepage_no")
							+"&category_group_no="+request.getParameter("category_group_no")
							+"&category_no="+request.getParameter("category_no")
							+ "&no="+request.getParameter("no")
			);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}






