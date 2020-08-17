package com.example.springtransaction.spring.txt;

import java.sql.*;

/**
 * 查  修改  查
 */
public class ReadRepeatableExample {

    static Object lock = new Object();

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

    //修改操作
    public static void update(String id){

        try {
            Connection connection = openConnect();
            String sql = "update sex set tenant_id = 'tenant_cm' where id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, id);
            pst.executeUpdate();
            connection.close();
            System.out.println("执行修改成功");
        } catch (SQLException e) {
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
                try {
                    synchronized (lock) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                update("11");
            }
        });

        //启动查询线程
        Thread t2 = run(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    Connection conn = openConnect();
                    //将参数升级成Connection.TRANSACTION_READ_COMMITTED
                    conn.setAutoCommit(false);
                    //Connection.TRANSACTION_REPEATABLE_READ   解决可重重复读问题
                    conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
                    //第一次读取不到
                    select("11", conn);
                    //释放锁,开始执行线程一的插入操作
                    synchronized (lock){
                        lock.notify();
                    }
                    //第二次读取到（数据不一致）
                    Thread.sleep(500);
                    select("11", conn);
                    /*//回滚
                    conn.setReadOnly(true);*/
                    conn.close();
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
