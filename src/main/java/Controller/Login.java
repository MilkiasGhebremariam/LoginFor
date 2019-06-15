package Controller;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dataaccess.DataUser;


public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        //super.init();
        DataUser.addUsers();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("username")) {
                userName = cookie.getValue();
                break;}
        }
        if(userName != null) {
            request.setAttribute("uname", userName);
            request.setAttribute("rememberme", "checked");
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("userpassword");
        Boolean rememberme = request.getParameter("rememberme")!= null;
        //check if user exist and if password is pass
        User loggedInUser = DataUser.checkUser(username, password);
        if(DataUser.hasLoggedIn()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("CurrentUser", loggedInUser);
            if(rememberme) {
                //adding cookie
                Cookie cookie = new Cookie("username", loggedInUser.getUsername());
                cookie.setMaxAge(23400000);
                cookie.setPath("/");
                response.addCookie(cookie);
                response.sendRedirect("welcome.jsp");
            }
            else {
                //removing cookie
                Cookie cookie = new Cookie("username", null);
                cookie.setMaxAge(-1);
                response.addCookie(cookie);
                response.sendRedirect("welcome.jsp");
            }
        }
        else
            response.sendRedirect("login.jsp");


    }

}
