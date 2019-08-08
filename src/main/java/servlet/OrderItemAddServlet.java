package servlet;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import pojo.OrderItem;
import pojo.Product;
import redis.clients.jedis.Jedis;
import util.JDBCutil;
import util.JedisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addOrderItem")
public class OrderItemAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        Jedis jedis = JedisUtil.getJedis();
        int id = Integer.parseInt(jedis.get("userid"));
        jedis.close();
        Product product = new ProductDaoImpl().getProduct(pid);
        OrderItem orderItem = new OrderItem(id,product,num);
        List<OrderItem> list = (List<OrderItem>) request.getSession().getAttribute("ois");
        if(list == null){
            list = new ArrayList<OrderItem>();
        }
        boolean found = false;
        for (OrderItem item : list) {
            if(item.getProduct().getId() == pid){
                item.setNum(item.getNum() + num);
                found = true;
                break;
            }
        }
        if(!found)
        list.add(orderItem);
        request.getSession().setAttribute("ois",list);
        response.sendRedirect("/Cart/listProduct");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
