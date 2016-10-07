/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.dao;


/**
 *
 * @author Rin's
 */
public class DataProvider {
    private SQLiteConnection sqliteConnection;
    public DataProvider() {
        sqliteConnection = new SQLiteConnection();
    }
    
    
    public void requestData(String rq, ReceiveData callback){
        new GetData(rq, callback).start();
    }
    
    public int getLocalRev() {
        return sqliteConnection.getLocalRev();
    }
    
    public String getLocalData() {
        return sqliteConnection.getLocalData();
    }
    
    public boolean updateData(String rev, String data) {
        return sqliteConnection.updateData(rev, data);
    }
    
    public void closeDB() {
        sqliteConnection.close();
    }
    
}
