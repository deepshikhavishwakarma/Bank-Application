package Customer_Pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
@SuppressWarnings("serial")
public class CustLoginServlet extends HttpServlet{
	CustBean cb = null;
	CustRegisterDAO crd = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		cb = new CustBean();
		crd = new CustRegisterDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
//			cb = crd.loginValidate(Long.parseLong(req.getParameter("accNo")), req.getParameter("pword"));
//			System.out.println(cb.getCname());
			 long accNo = Long.parseLong(req.getParameter("accNo"));
		     String password = req.getParameter("pword");
		     cb = crd.loginValidate(accNo, password);
			
			ServletContext sct = req.getServletContext();
			sct.setAttribute("cbean", cb);
			
			if(cb!=null) {
				
				req.setAttribute("msg", "Welcome");
				HttpSession hs = req.getSession();
				hs.setAttribute("cbean", cb);
				req.getRequestDispatcher("Dashboard.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "Invalid Login Process...");
				
				req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
			}
		} catch (NumberFormatException e) {
			PrintWriter pw=res.getWriter();
			pw.println("Please Enter Correct Account Number ");
		    e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
  
	
}
