package com.example.springtransaction.spring.txt;

import java.sql.*;

public class ReadUncommitedExample {

    public static Connection openConnect(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://172.16.26.13:3306/test?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=true&useSSL=false";
            String username = "root";
            String password = "MySQL!123@";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insert(){
        //连接数据库
        Connection connection = openConnect();

        String sql = "insert into sex values('11', '1', '男', 'tenant_system', '2020-06-30 14:55:00', '0')";
        try {
            //关闭自动提及
            connection.setAutoCommit(false);
            PreparedStatement pst = connection.prepareStatement(sql);
            //执行sql
            pst.executeUpdate();
            System.out.println("插入结果");
            //休眠3秒
            Thread.sleep(300);
            connection.close();;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询操作
    public static void select(String id, Connection connection){

        try {
            PreparedStatement pst = connection.prepareStatement("select * from sex where id = ?");
            pst.setString(1, id);
            ResultSet resultSet = pst.executeQuery();
            System.out.println("查询结果");
            while (resultSet.next()){
                for(int i=1; i<=6; i++){
                    System.out.print(resultSet.getString(i)+", ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Thread run(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.start();
        return  thread;
    }

    //main方法  先插后读在关闭事物
    public static void main(String[] args){
        //启动插入线程
        Thread t1 = run(new Runnable() {
            @Override
            public void run() {
                insert();
            }
        });

        //启动查询线程
        Thread t2 = run(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    Connection conn = openConnect();
                    // conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                    // 事物级别为  Connection.TRANSACTION_READ_UNCOMMITTED  容易出现脏读（插入语句所在的事物并未提交，但查询语句读到了这条记录）
                    //将参数升级成Connection.TRANSACTION_READ_COMMITTED
                    conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                    select("11", conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
