package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    public static DataSource getDataSource(){
        return dataSource;
    }
    //创建一个ThreadLocal对象，以当前线程作为key
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    //提供当前线程中的Connection
    public static Connection getConnection() throws SQLException{
        Connection connection = threadLocal.get();
        if(null ==connection){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
}
