package com.example.springtransaction.spring.txt;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.*;

public class SpringTransactionExample {

    private static String url = "jdbc:mysql://172.16.26.13:3306/test?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=true&useSSL=false";
    private static String username = "root";
    private static String password = "MySQL!123@";

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username,password);
        return conn;
    }

    public static void main(String[] args) {
        final DataSource ds = new DriverManagerDataSource(url, username, password);

        final TransactionTemplate template = new TransactionTemplate();
        template.setTransactionManager(new DataSourceTransactionManager(ds));

        template.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                Connection conn = DataSourceUtils.getConnection(ds);
                Object savePoint = null;

                try {
                    {
                        PreparedStatement prepare = conn.prepareStatement("insert into sex (id, sex_code, sex_name, tenant_id, work_end_time, code) values (?, ?, ?, ?, ?, ?)");

                        prepare.setString(1, "12");
                        prepare.setString(2, "1");
                        prepare.setString(3, "男");
                        prepare.setString(4, "tenant_system");
                        prepare.setString(5, "2020-06-30 14:55:00");
                        prepare.setString(6, "0");

                        prepare.executeUpdate();
                    }

                    //设置保存点  不回滚保存点之前的操作
                    savePoint = status.createSavepoint();

                    {
                        PreparedStatement prepare = conn.prepareStatement("insert into sex (id, sex_code, sex_name, tenant_id, work_end_time, code) values (?, ?, ?, ?, ?, ?)");
                        prepare.setString(1, "13");
                        prepare.setString(2, "1");
                        prepare.setString(3, "男");
                        prepare.setString(4, "tenant_system");
                        prepare.setString(5, "2020-06-30 14:55:00");
                        prepare.setString(6, "0");
                        prepare.executeUpdate();
                    }
                    {
                        //更新
                        PreparedStatement prepare = conn.prepareStatement("update sex set tenant_id='tenant_cm' where id = ?");
                        prepare.setString(1, "10");
                        Assert.isTrue(prepare.executeUpdate()>0, "");
                    }

                    
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    System.out.println("更新失败！");
                    if(savePoint != null){
                        status.rollbackToSavepoint(savePoint);
                    }else{
                        status.setRollbackOnly();
                    }
                }

                return null;
            }
        });

    }

}
