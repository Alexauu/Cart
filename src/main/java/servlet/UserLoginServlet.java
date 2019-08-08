package servlet;

import dao.impl.UserDaoImpl;
import pojo.User;
import redis.clients.jedis.Jedis;
import util.JedisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new UserDaoImpl().getUser(request.getParameter("name"), request.getParameter("password"));
        if (user != null) {
            Jedis jedis = JedisUtil.getJedis();
            jedis.set("userid",user.getId()+"");
            jedis.close();
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/Cart/listProduct");
        } else {
            response.sendRedirect("/Cart/login.jsp");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
