package com.example.tuling.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Jdbc01 {

    public static void main(String[] args) {

        insert();
    }

    public static void insert(){

        String id = "10";
        String sexCode = "1";
        String sex_name = "男";
        String tenantId = "1233212";
        String workEndTime = "2020-06-30 14:55:00";
        String code = "1";

        JdbcUtil jdbcUtil = new JdbcUtil();
        Connection conn = jdbcUtil.getConnection();
        String sql = "insert into sex values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, sexCode);
            ps.setString(3, sex_name);
            ps.setString(4, tenantId);
            ps.setString(5, workEndTime);
            ps.setString(6, code);

            ps.execute();
            System.out.println(">>>>数据插入成功！");
            JdbcUtil.close(ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
