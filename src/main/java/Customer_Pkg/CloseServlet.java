package Customer_Pkg;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/close")
public class CloseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		hs.removeAttribute("cbean");
		if(hs==null) {
			 request.setAttribute("msg", "Session is Experied... ");
			 request.getRequestDispatcher("Msg.jsp").forward(request, response);
		
		}else {
		ServletContext sct = request.getServletContext();
		sct.removeAttribute("cbean");
		
		request.setAttribute("msg", "Logout done Successfully...");
			request.getRequestDispatcher("Logout.jsp").forward(request, response);
		
	}

	
	
}}
