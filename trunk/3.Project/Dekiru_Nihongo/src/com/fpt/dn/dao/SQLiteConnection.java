/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rin's
 */
public class SQLiteConnection {
    private Connection conn;
    private Statement st;

    /**
     * Constructor
     */
    public SQLiteConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:dn.db");
            st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS dnTable (num integer, rev int, dat text)");
            int numRow;
            ResultSet rs = st.executeQuery("SELECT Count(*) from dnTable");
            if (!rs.next()) {
                st.execute("INSERT INTO dnTable (num, rev) values(1, 0)");
            }
            st.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * get Local data from database
     * @return
     */
    public String getLocalData() {
        String localData;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM dnTable");
            rs.next();
            localData= rs.getString(3);
            return localData;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * get local revision from database
     * @return
     */
    public int getLocalRev() {
        int rev;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM dnTable");
            rs.next();
            rev = rs.getInt(2);
            return rev;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     * update data with newest revision and data
     * @param rev
     * @param data
     * @return
     */
    public boolean updateData(String rev, String data){
        try {
            st.execute("UPDATE dnTable SET rev = "+ rev + ", dat = '"+ data + "' WHERE num = 1");
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    /**
     * close database
     */
    public void close() {
        if (conn != null) {
            conn = null;
        }
    }
    
    
    
}
