package Customer_Pkg;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
@SuppressWarnings("serial")
public class Cust_Register extends HttpServlet{
   
	CustBean cb = null;
	CustRegisterDAO crd = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		cb = new CustBean();
		crd = new CustRegisterDAO();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		cb.setAccNo(Long.parseLong(req.getParameter("accNo")));
		cb.setCname(req.getParameter("cname"));
		cb.setPword(req.getParameter("pword"));
		cb.setPhno(Long.parseLong(req.getParameter("phno")));
		cb.setMail(req.getParameter("mail"));
		cb.setAadhar(Long.parseLong(req.getParameter("aadhar")));
		cb.setBalance(Double.parseDouble(req.getParameter("bal")));
		cb.setAccType(req.getParameter("accType"));
		int k = crd.register(cb);
		if(k>0) {
			req.setAttribute("msg", "Registration Successfully done...");
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}else {
			req.setAttribute("msg","Admin Not Registered....");
			req.getRequestDispatcher("Register.jsp").forward(req,res);
		}
	}

	

}
