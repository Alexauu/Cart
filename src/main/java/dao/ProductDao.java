package dao;

import pojo.Product;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-07 16:20
 */

public interface ProductDao {

    public List<Product> listAll();

    public Product getProduct(int id);


}
