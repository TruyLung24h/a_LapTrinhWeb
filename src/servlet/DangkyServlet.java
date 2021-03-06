package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaiKhoanDAO;
import model.TaiKhoan;


@WebServlet("/DangkyServlet")
public class DangkyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DangkyServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	      request.setCharacterEncoding("UTF-8");
		
		
		String	username =request.getParameter("username");
		String	p_assword=request.getParameter("p_assword");
		String  hoTen =request.getParameter("hoTen");
		String  gioiTinh ="";
		String  ngaySinh = "";	
		String  diaChi ="";
		String  idType ="2";
	    String  avatar ="avatar";
		TaiKhoanDAO tkDAO = new TaiKhoanDAO();
		TaiKhoan tk = new TaiKhoan(username, p_assword, hoTen, gioiTinh, ngaySinh ,diaChi ,idType ,avatar);
		
		try {
			
			tkDAO.insertNew(tk);
			response.sendRedirect("main");
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("TrangChu.jsp");
			rd.forward(request, response);
		}
	}

}
