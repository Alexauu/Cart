package servlet;

import pojo.OrderItem;
import redis.clients.jedis.Jedis;
import util.JedisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/deleteOrderItem")
public class OrderItemDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        List<OrderItem> list = (List<OrderItem>)request.getSession().getAttribute("ois");
        Iterator<OrderItem> itemIterator = list.iterator();
        while(itemIterator.hasNext()){

            if(itemIterator.next().getProduct().getName().equals(name)){
                itemIterator.remove();
                break;
            }
        }
        request.getSession().setAttribute("ois",list);
        response.sendRedirect("/Cart/listOrderItem");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
