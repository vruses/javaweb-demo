package dao;
import javabean.DBConstants;
import java.sql.*;

public class Base {
    private static final String driver = DBConstants.driver;
    private static final String url = DBConstants.url;
    private static final String username = DBConstants.username;
    private static final String password = DBConstants.password;

    /*数据库连接*/
    public static Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /*释放资源*/
    public static void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
            throws SQLException {
//        boolean flag = true;
        /*先关闭ResultSet，然后是Statement，
        最后是Connection,刚好与创建相应对象时的顺序相反*/
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
//                flag = false;
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
//                flag = false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
//                flag = false;
            }
        }
    }

}
