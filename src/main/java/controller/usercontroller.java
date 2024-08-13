package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userdao;
import model.user;

/**
 * Servlet implementation class usercontroller
 */
@WebServlet("/usercontroller")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("showdata")) {
			int id=Integer.parseInt(request.getParameter("uid"));
            user u = new userdao().getuserbyid(id);
            request.setAttribute("u",u);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			user u = new user();
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setDob(request.getParameter("date"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			new userdao().insertuser(u);
			response.sendRedirect("login.jsp");
			
		}
		else if (action.equalsIgnoreCase("login")) {
			user u = new user();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			user u1 = new userdao().dologin(u);
			if(u1!=null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("id", u1.getId());
				response.sendRedirect("usercontroller?action=showdata&uid="+u1.getId());
				
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "invalid email ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			}
			
		}
		
		
		
		
	}


