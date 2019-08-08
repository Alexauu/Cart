package servlet;

import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import pojo.Order;
import pojo.OrderItem;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/createOrder")
public class OrderCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        if(null==u){
            response.sendRedirect("/Cart/userLogin");
            return;
        }

        Order o = new Order();
        o.setUser(u);

        new OrderDaoImpl().update(o);

        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
        for (OrderItem oi : ois) {
            oi.setOrder(o);
            new OrderItemDaoImpl().update(oi);
        }

        ois.clear();

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("订单创建成功");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
