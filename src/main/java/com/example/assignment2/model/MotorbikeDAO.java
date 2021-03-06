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



    public ArrayList<Motorbike> selectOne(String email) throws Exception {
        ArrayList<Motorbike> mb = new ArrayList<>();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM MOTORBIKE where EMAIL ='" + email +"'");
        while(rs.next()) {

            if(rs.getString("email").equals(email)) {

                Motorbike m = new Motorbike(rs.getString("motorbikeID"),rs.getString("email"),
                        rs.getString("make"),
                        rs.getString("model"),rs.getString("cc"));
                mb.add(m);
            }
        }
        return mb;
    }


    public void save(Motorbike m) throws Exception{

        Connection conn = getConnection();
        PreparedStatement psmt = conn.prepareStatement("INSERT INTO MOTORBIKE(motorbikeID, email, make, model, cc) VALUES (?,?,?,?,?)");

        psmt.setString(1, null);
        psmt.setString(2, m.getEmail());
        psmt.setString(3, m.getMake());
        psmt.setString(4, m.getModel());
        psmt.setString(5, m.getCc());
        psmt.executeUpdate();
        psmt.close();
        conn.close();
    }

    public void update(String motorbikeID, String email, String make, String model, String cc) throws Exception {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        PreparedStatement psmt = conn.prepareStatement("UPDATE MOTORBIKE SET make = '" + make + "' WHERE motorbikeID = '" + motorbikeID + "' and email ='" + email + "'");
        PreparedStatement psmt2 = conn.prepareStatement("UPDATE MOTORBIKE SET model = '" + model + "' WHERE motorbikeID = '" + motorbikeID + "' and email ='" + email + "'");
        PreparedStatement psmt3 = conn.prepareStatement("UPDATE MOTORBIKE SET cc = '" + cc + "' WHERE motorbikeID = '" + motorbikeID + "' and email ='" + email + "'");

        psmt.executeUpdate();
        psmt2.executeUpdate();
        psmt3.executeUpdate();

        psmt.close();
        psmt2.close();
        psmt3.close();

        conn.close();
    }

    public void delete(String motorbikeID, String email) throws Exception {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            PreparedStatement psmt = conn.prepareStatement("DELETE FROM MOTORBIKE where motorbikeID = '" + motorbikeID + "' and email = '" + email +"'");
            psmt.executeUpdate();

            psmt.close();

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public ArrayList<Motorbike> list() throws Exception{
        ArrayList<Motorbike> listOfMotorbikes = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM MOTORBIKE");
        while (rs.next()) {
            Motorbike m = new Motorbike(rs.getString("motorbikeID"),rs.getString("email"),
                    rs.getString("make"),
                    rs.getString("model"),rs.getString("cc"));
            listOfMotorbikes.add(m);
        }
        return listOfMotorbikes;
    }
}
