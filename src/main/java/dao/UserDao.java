package dao;

import jdk.nashorn.internal.runtime.UserAccessorProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-08-07 17:07
 */

public interface UserDao {

    public User getUser(String name, String password);

}
