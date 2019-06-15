package Controller;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;


public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession();
        session.invalidate();
        //response.("/login.jsp");
        request.getRequestDispatcher("login.jsp").forward(request, response);


    }
}
