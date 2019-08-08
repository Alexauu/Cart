package dao.impl;

import dao.ProductDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Product;
import util.JDBCutil;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-07 16:25
 */

public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutil.getDataSource());

    public List<Product> listAll() {
        String sql = "select * from product;";
        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
        return list;
    }

    public Product getProduct(int id) {

        String sql = "select * from product where id = ?;";
        Product product = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Product>(Product.class),id);
        return product;
    }
}
