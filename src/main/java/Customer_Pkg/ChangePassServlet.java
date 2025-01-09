package Customer_Pkg;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/changepass")
public class ChangePassServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session is Experied Plrase Login again... ");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);

		} else {
			CustBean cb1 = (CustBean) hs.getAttribute("cbean");

			if (cb1 == null) {
				req.setAttribute("msg", "Sessioin Expired....<br>");
				req.getRequestDispatcher("Msg.jsp").forward(req, resp);
			}

			ServletContext sct = req.getServletContext();
			CustBean cb = (CustBean) sct.getAttribute("cbean");
			String oPass = req.getParameter("oPass");// 1234
			String nPass = req.getParameter("nPass");// 8989
			int captcha = (int) hs.getAttribute("captcha");
			int enteredcaptcha = Integer.parseInt(req.getParameter("enteredcaptcha"));
//			System.out.println(cb.getPword() + "  " + "Old:"+oPass + "   " + "New:"+nPass+"  Capcha:"+captcha);
//            System.out.println("Entered Capcha:"+enteredcaptcha);
			if (!oPass.equals(cb.getPword())) {// 1234!=1234
				req.setAttribute("msg", "Old Password should be correct.. ");
				req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);
			} else if (nPass.equals(cb.getPword())) {// 8989 == 1234
				req.setAttribute("msg", "New Password must not be same Previous password");
				req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);
			} else if (oPass.equals(nPass)) { // 1234==8989
				req.setAttribute("msg", "New password must not be same.");
				req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);
			} else if (!(captcha == enteredcaptcha)) {
			
				req.setAttribute("msg1", "Please Enter valid Capatcha.");
				req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);

			} else {// 1234 != 8989

				int k = new CustRegisterDAO().changePassword(oPass, nPass,cb.getAccNo());
				if (k > 0) {
					req.setAttribute("msg", "Password changed Successfully done.");
					req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);
				}

				else {
					req.setAttribute("msg", "Password not changed.");
					req.getRequestDispatcher("ChangePass.jsp").forward(req, resp);

				}
			}
		}

	}
}
