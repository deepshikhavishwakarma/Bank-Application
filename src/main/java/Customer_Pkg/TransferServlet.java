package Customer_Pkg;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{

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
			long accNo = Long.parseLong(req.getParameter("accNo"));
			double amt = Double.parseDouble(req.getParameter("amt"));
			if(accNo != cb.getAccNo()) {
				req.setAttribute("msg", "Please enter Valid Account Number.");
				req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			}else if(amt>cb.getBalance()|| amt<=0 ){
				req.setAttribute("msg", "Insufficient Balance");
				req.getRequestDispatcher("Msg.jsp").forward(req, resp);
				
			}else {
				long sAccNo = Long.parseLong(req.getParameter("sAccNo"));
				int k = new CustRegisterDAO().transactAmt(amt, sAccNo, cb);
				if(k>0) {
					req.setAttribute("msg", "Fund Transfer Successfully done.");
					req.getRequestDispatcher("transfer.jsp").forward(req, resp);
				}else {
					req.setAttribute("msg", "Fund not Transfered.");
					req.getRequestDispatcher("Msg.jsp").forward(req, resp);
				}
				
			}
		}
		
		
	}

}
