package dao.impl;

import dao.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import util.JDBCutil;

import javax.swing.plaf.UIResource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-07 17:11
 */

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutil.getDataSource());

    public User getUser(String name, String password) {
        String sql = "select * from user where name = ? and password = ?;";
        User user = null;
        try{
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }
}
