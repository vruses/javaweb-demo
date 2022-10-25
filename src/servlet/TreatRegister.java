package servlet;

import dao.UserDao;
import javabean.UserBean;

import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class TreatRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name").trim();
        String password = req.getParameter("password").trim();
        String passwordConfirm = req.getParameter("passwordConfirm").trim();
        UserBean user = new UserBean();
        user.setUserName(name);
        user.setUserPassword(password);
//        ServletConfig config = getServletConfig();
        //Servlet配置对象，描述基本信息，局部作用域
//        ServletContext application = config.getServletContext();//获取当前容器的上下文
        //一个Web应用对应一个ServletContext，多个Servlet实例对应一个 ServletContext，全局作用域
        //        检验用户密码是否为空，检验密码输入是否相同
        if (!name.equals("") && !password.equals("")) {//如果用户和密码为空直接提示不能为空，优先级高于密码是否匹配
            if (!password.equals(passwordConfirm)) {
                String unMatchError = "请确认密码输入是否匹配！";
                req.setAttribute("result", unMatchError);
            } else {//如果用户密码不为空且密码输入匹配才注册成功
//                if (application.getAttribute(name) == null) {
//                    application.setAttribute(name, user);
               /* 如果注册成功，将以name为唯一标识的user对象放入application中，再将请求以name为唯一标识的键值对放入request中
                如果application已经注册过一次name，判断将这次name是否在application键值对中，如果在则提示用户已被注册
                */
                    String result="注册失败，用户已被注册！";
                    try {
                       if(UserDao.register(user)){//接受dao层判定结果
                           result="注册成功";
                       }
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
//                    String registerSuccess = name + "，您好!恭喜注册成功！ ";

                    req.setAttribute("result", result);
//                }
               /*  else {
                    String existError="用户已被注册！";
                    req.setAttribute("result", existError);
                }*/
            }
        } else {
            String nullError = "请确认用户或者密码是否为空！";
            req.setAttribute("result", nullError);

        }
        String url = "/Register/registerResult.jsp";//注意相对路径填写
        System.out.println(req.getAttribute("result"));
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);//携带请求响应信息到url中
    }

    @Override
    /*重写doPost，将post请求处理交给doGet处理*/
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
