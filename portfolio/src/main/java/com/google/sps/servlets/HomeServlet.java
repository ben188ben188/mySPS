package com.google.sps.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class HomeServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    UserService userService = UserServiceFactory.getUserService();
    if (userService.isUserLoggedIn()) {
      String userEmail = userService.getCurrentUser().getEmail();
      String urlToRedirectToAfterUserLogsOut = "/";
      String logoutUrl = userService.createLogoutURL(urlToRedirectToAfterUserLogsOut);

      response.getWriter().println("<p>Hello " + userEmail + "!</p>"); 
      //<form action="/data" method="POST">
      response.getWriter().println("<form action=\"/data\" method=\"POST\">");
      response.getWriter().println("<textarea name=\"email-input\">" + userEmail + "</textarea>");
      //<p>Enter your name:</p>
      response.getWriter().println("<p>Enter your name:</p>");
      //<textarea name="name-input">your name</textarea>
      response.getWriter().println("<textarea name=\"name-input\">your name</textarea>");
   
      //<p>Enter your comment:</p>
      response.getWriter().println("<p>Enter your comment:</p>");
      //<textarea name="comment-input" style="width:200px; height:100px">your comment</textarea>
      response.getWriter().println("<textarea name=\"comment-input\" style=\"width:200px; height:100px\">your comment</textarea>");
      //<br/><br/>
      response.getWriter().println("<br/><br/>");

     // <input type="submit" />
     response.getWriter().println("<input type=\"submit\" />");
    //</form>
    response.getWriter().println("</form>");
       
      response.getWriter().println("<p>Logout <a href=\"" + logoutUrl + "\">here</a>.</p>");
    } else {
       String urlToRedirectToAfterUserLogsIn = "/";
       String loginUrl = userService.createLoginURL(urlToRedirectToAfterUserLogsIn);
       response.getWriter().println("<p>Hello stranger.</p>");
       response.getWriter().println("<p>Before make comment, Please login first!</p>");
       response.getWriter().println("<p>Login <a href=\"" + loginUrl + "\">here</a>.</p>");
      //response.sendRedirect("/"+loginUrl);
     // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/"+loginUrl);
    //dispatcher.forward(request, response);
    //try{request.getRequestDispatcher("/"+loginUrl).forward(request, response);}catch(Exception e) {
						
	//e.printStackTrace();}
  }
  
}
}
