package Customer_Pkg;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/balance")
@SuppressWarnings("serial")
public class CheckBalanceServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			 req.setAttribute("msg", "Session is Experied... ");
			 req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		
		}else {
			 CustBean cb1 = (CustBean)hs.getAttribute("cbean");
			 if(cb1==null)
			 {
				 req.setAttribute("msg","Sessioin Expired....<br>");
					req.getRequestDispatcher("Msg.jsp").forward(req, resp); 
			 }
			ServletContext sct = req.getServletContext();
			CustBean cb = (CustBean)sct.getAttribute("cbean");

		if(cb!=null) {
			double balance = new CustRegisterDAO().checkBalance(cb.getAccNo());
			
			System.out.print(balance);
			cb.setBalance(balance);
			 hs.setAttribute("cbean", cb);
			 req.setAttribute("msg", "Welcome to Your Bank ");
			 req.getRequestDispatcher("Balance.jsp").forward(req, resp);
		}
	}
	}
   
	
	
}
