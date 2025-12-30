package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/college_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    // Insert student
    public boolean addStudent(Student student) {

        boolean status = false;
        String sql = "INSERT INTO student (id, sem, department) VALUES (?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, student.getId());
            ps.setInt(2, student.getSem());
            ps.setString(3, student.getDepartment());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
