package dao.impl;

import dao.OrderItemDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pojo.Order;
import pojo.OrderItem;
import util.JDBCutil;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-08 12:36
 */

public class OrderItemDaoImpl implements OrderItemDao {


    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutil.getDataSource());

    @Override
    public void update(OrderItem orderItem) {
        String sql = "insert into orderitem values(null,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,orderItem.getProduct().getId());
            ps.setInt(2,orderItem.getNum());
            ps.setInt(3,orderItem.getOrder().getId());
            return ps;
        };
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        orderItem.setId(keyHolder.getKey().intValue());

    }
}
