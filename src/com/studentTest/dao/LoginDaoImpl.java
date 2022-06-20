package com.studentTest.dao;

import com.studentTest.bean.User;
import com.studentTest.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao{
    @Override
    public User logindao(User u) {

        int id=u.getU_id();
        String pwd = u.getU_pwd();

        //就在这里写数据库的东西
        //获取连接对象->准备我们的sql语句->把sql语句放在preoareStatement = ConnectionFactory.获取结果
        //执行

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT * FROM u_user WHERE u_id="+id+" AND u_pwd='"+pwd+"'";

        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
            * 如果信息正确->返回来一条数据
            * 如果信息错误->返回null
            *
            * */
            while (res.next()){
                User user = new User();
                user.setU_id(res.getInt("u_id"));
                user.setU_name(res.getString("u_name"));
                user.setU_pwd(res.getString("u_pwd"));
                user.setU_phone(res.getString("u_phone"));
                user.setRole(res.getInt("u_role"));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
