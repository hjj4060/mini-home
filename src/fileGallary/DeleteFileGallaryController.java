package fileGallary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/filegallary/deletefilegallary")
public class DeleteFileGallaryController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		try {
			
			GallaryDAO dao = new GallaryDAO();
			dao.deleteBoard(no);
			
			request.setAttribute("homepageNo", request.getParameter("homepageNo"));
			request.setAttribute("categoryNo", request.getParameter("categoryNo"));
			
			RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/filegallary/listfilegallary"	
			);
			rd.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}






