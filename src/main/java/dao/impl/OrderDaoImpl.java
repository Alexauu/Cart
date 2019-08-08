package dao.impl;

import dao.OrderDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pojo.Order;
import util.JDBCutil;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-08 12:22
 */

public class OrderDaoImpl implements OrderDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutil.getDataSource());

    public void update(Order order) {
        String sql = "insert into order_ values(null,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,order.getUser().getId());
            return ps;
        };
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        order.setId(keyHolder.getKey().intValue());
    }
}
