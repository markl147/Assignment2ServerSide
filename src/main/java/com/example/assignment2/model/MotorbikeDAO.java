package com.example.assignment2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public enum MotorbikeDAO {
    instance;

    //CRUD
    //Create - Insert - save
    //Read - Select - list
    //Update - Update - update
    //Delete - Delete - remove

    public Connection getConnection() throws Exception {


        Class.forName("org.hsqldb.jdbcDriver");


        Connection con = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");

        return con;
    }

    private String motorbikeID;
    private String email;
    private String make;
    private String model;
    private String cc;

    public Motorbike selectOne(String email) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM MOTORBIKE where email ='" + email +"'");
        while(rs.next()) {

            if(rs.getString("email").equals(email)) {

                Motorbike m = new Motorbike(rs.getString("motorbikeID"), rs.getString("email"),
                        rs.getString("make"),
                        rs.getString("model"),rs.getString("cc"));
                return m;
            }
        }
        return null;
    }


    public void save(Motorbike m) throws Exception{

        Connection conn = getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO MOTORBIKE(null, email, make, model, cc) VALUES (?,?,?,?,?)");

        psmt.setString(1, m.getMotorbikeID());
        psmt.setString(2, m.getEmail());
        psmt.setString(3, m.getMake());
        psmt.setString(4, m.getModel());
        psmt.setString(5, m.getCc());
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }

    public ArrayList<Motorbike> list() throws Exception{
        ArrayList<Motorbike> listOfMotorbikes = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM MOTORBIKE");
        while (rs.next()) {
            Motorbike m = new Motorbike(rs.getString("motorbikeID"), rs.getString("email"),
                    rs.getString("make"),
                    rs.getString("model"),rs.getString("cc"));
            listOfMotorbikes.add(m);
        }
        return listOfMotorbikes;
    }
}