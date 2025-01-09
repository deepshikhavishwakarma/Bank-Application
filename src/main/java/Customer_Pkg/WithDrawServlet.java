package Customer_Pkg;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/withdraw")
@SuppressWarnings("serial")
public class WithDrawServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session is Experied....");
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
			double Wamt = Double.parseDouble(req.getParameter("amt"));
			if(Wamt>cb.getBalance() || Wamt<=0) {
				req.setAttribute("msg", "Insuffient Balance ..");
		    	req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			}else {
			   int k = new CustRegisterDAO().withdrawAmt(Wamt,cb.getAccNo());
		        if(k>0) {
		    	req.setAttribute("msg","Please Collect your Money...");
		    	req.getRequestDispatcher("WithDraw.jsp").forward(req, resp);
		    }}
		}
	}
 
}
