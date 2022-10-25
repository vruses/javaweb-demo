package servlet;


import dao.UserDao;
import javabean.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class TreatLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();//对应input的name属性名，为空返回”“,属性名错误则返回null
        String number = req.getParameter("number").trim();
        UserBean user = new UserBean();
        user.setUserName(name);
        user.setUserPassword(number);
//        ServletConfig config = getServletConfig();
//        ServletContext application = config.getServletContext();
// 创建application指向当前容器上下文
//        UserBean user=(UserBean)application.getAttribute(name);
        /*创建user可以将其直接传入login，但提前得判定user对象是否为空，
        因为之前直接从application拿对象，所以没有额外创建user对象*/
//        if(user!=null){//user为null的话直接提示登录失败，同时避免引用空指针
        if (!user.getUserName().equals("") && !user.getUserPassword().equals("")) {//先检查用户密码是否为空再进行数据库校验操作
            String result = "登录失败！请检查用户名或者密码是否正确！";
            try {
                if(UserDao.login(user)){//接受dao层判定结果
                    result="登录成功！";
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
//            if(number.equals(user.getUserPassword())&&name.equals(user.getUserName())) {//如果和application里的键值对都能匹配成功
            HttpSession session = req.getSession();
            session.setAttribute(name, number);//建立登录成功标识
            req.setAttribute("result", result);//返回判定结果
//                String loginSuccess = "您好！" + name + "，恭喜您登录成功！";
//                req.setAttribute("result", loginSuccess);
//            }else{
//                String loginFail="您的账户或者密码错误！";
//                req.setAttribute("result",loginFail);
//            }
        } else {
//            String nullError = "用户并未创建！";
            String nullError = "用户名和密码不能为空！";
            req.setAttribute("result", nullError);
        }
        String url = "/Login/loginResult.jsp";//注意相对路径填写
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);//携带请求响应信息到url中
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
