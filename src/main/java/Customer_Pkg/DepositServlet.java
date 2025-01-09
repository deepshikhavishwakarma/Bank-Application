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

@SuppressWarnings("serial")
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet{
     CustRegisterDAO crd =null;
     CustBean cb = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		crd = new CustRegisterDAO();
		cb=new CustBean();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);//Accessing existing Session
		if(hs!=null) {
			 CustBean cb1 = (CustBean)hs.getAttribute("cbean");
			 if(cb1==null)
			 {
				 req.setAttribute("msg","Sessioin Expired....<br>");
					req.getRequestDispatcher("Msg.jsp").forward(req, resp); 
			 }
			ServletContext sct = req.getServletContext();
			CustBean cb = (CustBean)sct.getAttribute("cbean");
			
			int k =crd.depositAmt(Double.parseDouble(req.getParameter("amt")),cb.getAccNo());
			System.out.println("account number : "+cb.getAccNo());
			if(k>0) {
				req.setAttribute("msg","Amount Deposit Successfully.....");
				req.getRequestDispatcher("Deposit.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg","Amount not Deposited....");
				req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg","Sessioin Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);

		}

		
		
		
		
		
	
	
	}

	
	
	

}
