package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.Struct;
import com.studentTest.bean.User;
import com.studentTest.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileDaoImpl implements FileDao{

    /*
    * 获取所有的信息代码就完成了！
    *
    * */
    @Override
    public ArrayList<User> getAllStudent() {
        ArrayList<User> arr = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT * FROM u_user";

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
                arr.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public User getFileByNameOrId(String v) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT * FROM u_user WHERE u_name='"+v+"'";

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

    @Override
    public User getAdmine(String id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT * FROM u_user WHERE u_id="+id;
        System.out.println(sql);

        try {
            pre = connection.prepareStatement(sql);
            System.out.println(sql);
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
                user.setRole(res.getInt("u_role"));
                return user;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList getPersonFile(String studentId) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT c_name courseName,c_score score FROM" +
                " course a,userchoose b WHERE a.c_id=b.c_id AND b.u_id="+studentId;
        System.out.println(sql);
        ArrayList<Major> arr = new ArrayList<>();
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
             * 如果信息正确->返回来一条数据
             * 如果信息错误->返回null
             *
             * */

            while (res.next()){
                Major m = new Major();
                m.setA(res.getString("courseName"));
                m.setB(res.getString("score"));
                arr.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arr;

    }

    @Override
    public void del(String stu) {
        /*
        * 要查询：询问一类的(kind):res = pre.executeQuery();
        * 增加  删除  修改 (kind) 这三个都是属于更新类的   pre.executeUpdate();
        * */

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句
        String sql1 = "DELETE FROM u_user WHERE u_id="+stu;
        String sql2 = "DELETE FROM userchoose WHERE u_id="+stu;
        try {
            pre = connection.prepareStatement(sql1);
            pre.executeUpdate();
            pre = connection.prepareStatement(sql2);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void upScore(String stuId, String a, String b, String c, String d) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        String[] file = {a,b,c,d};//4
        int index=0;
        try {
            for(int i=1001;i<=1004;i++){
                String sql = "UPDATE userchoose SET c_score = "+file[index]+" WHERE u_id="+stuId+" AND c_id="+i;
                index++;
                pre = connection.prepareStatement(sql);
                pre.executeUpdate();
            }

            /*pre = connection.prepareStatement(sql1);
            pre.executeUpdate();
            pre = connection.prepareStatement(sql2);
            pre.executeUpdate();*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDate(String name, String pwd, String phone, String a, String b, String c, String d) {
            /*
             * 要查询：询问一类的(kind):res = pre.executeQuery();
             * 增加  删除  修改 (kind) 这三个都是属于更新类的   pre.executeUpdate();
             * */

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement pre=null;
            ResultSet res = null;
            //准备SQl语句
            String sql1 = "INSERT INTO u_user(u_pwd,u_phone,u_role,u_isdelte,u_name) VALUES('"+pwd+"','"+phone+"',1,0,'"+name+"')";
        System.out.println(sql1);
            try {
                pre = connection.prepareStatement(sql1);
                pre.executeUpdate();
                String[] s = {a,b,c,d};
                int index = 0;

                for(int i =1001;i<=1004;i++){
                    String sql ="INSERT INTO userchoose (u_id,c_id,c_score) VALUES((SELECT u_id FROM u_user WHERE u_pwd='"+pwd+"' AND u_name='"+name+"'),"+i+","+s[index]+") ";
                    index++;
                    pre = connection.prepareStatement(sql);
                    pre.executeUpdate();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


    }

    @Override
    public void uppwd(String id, String pwd) {
        String sql="UPDATE u_user SET u_pwd='"+pwd+"' WHERE u_id="+id;
        ins(sql);
    }


    public void ins(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre=null;
        ResultSet res = null;
        //准备SQl语句

        try {
            pre = connection.prepareStatement(sql);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Struct> getPrecent() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Struct> list = null;
        try {
            //② 准备SQL语句
            String sql= "SELECT u_id a, SUM(c_score) b FROM userchoose WHERE u_id IN (SELECT u_id FROM u_user WHERE u_role=1) GROUP BY u_id ORDER BY b DESC LIMIT 5";


            //③ 获取集装箱或者说是车
            preparedStatement = connection.prepareStatement(sql);

            //④执行SQL,获取执行后的结果,查询的结果封装在ResultSet
            rs = preparedStatement.executeQuery();

            list = new ArrayList<Struct>();
            //因为查询出来的结果包括表头信息，所以要指针下移一行，看是否有查询出来的数据
            //如有数据，就进入循环体，封装该行数据
            while (rs.next()) {
                Struct s = new Struct();
                s.setName(rs.getString("a"));
                s.setPrecent(rs.getDouble("b"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(connection, preparedStatement, rs);
        }
        return list;

    }


    public void register(User u) {
        String sql = "INSERT INTO u_user(`u_name`,`u_phone`,`u_pwd`,`u_role`,`u_isdelte`) VALUES('" + u.getU_name() + "','" + u.getU_phone() + "','" + u.getU_pwd() + "',1,0)";
        ins(sql);
        int id = getIdByNamePwd(u.getU_name(), u.getU_pwd());
        creScore(id);

    }


    public int getIdByNamePwd(String u_name, String u_pwd) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        //准备SQl语句
        String sql = "SELECT u_id FROM u_user WHERE u_name='" + u_name + "'AND u_pwd='" + u_pwd + "'";

        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            /*
             * 如果信息正确->返回来一条数据
             * 如果信息错误->返回null
             *
             * */
            res.next();
            return res.getInt("u_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public void creScore(int stuId) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        int index = 0;
        try {
            for (int i = 1001; i <= 1004; i++) {
                String sql = "insert into userchoose values("+stuId+","+i+",0)";
                index++;
                pre = connection.prepareStatement(sql);
                pre.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
