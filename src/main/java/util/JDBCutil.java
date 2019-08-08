package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ClassName:
 * @Description:
 * @author: Ouzl
 * @create: 2019-07-30 15:04
 */

public class JDBCutil {

    private static DataSource dataSource;

    static{

        try {
            Properties properties = new Properties();
            InputStream inputStream = JDBCutil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e) {
            System.out.println("#"+e);

        }



    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }


}
