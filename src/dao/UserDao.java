package dao;

import javabean.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*JDBC连接数据库步骤
     1、加载Mysql数据库驱动
     2、设置访问数据库的用户名、密码及连接URL
     3、通过JDBC API的DriverManager的getConnection()的方法创建与数据库之间的连接
     4、建立连接后，使用该连接对象conn创建用户操作SQL语句的Statement对象
     5、调用Statement对象的execute()方法，编译执行sql语句
     6、关闭数据库连接。数据库用完后要及时关闭与数据库之间的连接，释放系统资源*/

public class UserDao {
    /*用户注册*/
    public static Boolean register(UserBean userBean) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preStatement = null;
        int resultSet = 0;
        String sql = "insert into tb_user(name,password)values(?,?)";
        try {
            connection = Base.getConnection();
            preStatement = connection.prepareStatement(sql);
            preStatement.setString(1, userBean.getUserName());
            preStatement.setString(2, userBean.getUserPassword());
            resultSet = preStatement.executeUpdate();//插入，删除，更新本身并不产生resultSet
        } catch (SQLException ignored) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                Base.closeResource(connection, preStatement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet == 1;//如果一行受到影响，返回true
    }

    /*用户登录*/
    public static Boolean login(UserBean userBean) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;
        boolean result = false;
        String sql = "select * from tb_user where name=? and password=? limit 1";
        try {
            connection = Base.getConnection();
            preStatement = connection.prepareStatement(sql);
            preStatement.setString(1, userBean.getUserName());
            preStatement.setString(2, userBean.getUserPassword());
            resultSet = preStatement.executeQuery();
            //能够查询到一条数据就表示登录成功
            //否则可能是用户或者密码错误，或者用户不存在
            result = resultSet.next();
        } catch (SQLException ignored) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                Base.closeResource(connection, preStatement, resultSet);//关闭结果集，statement和数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}