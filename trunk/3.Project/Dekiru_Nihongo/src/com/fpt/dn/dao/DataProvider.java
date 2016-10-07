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
    
    /** 
     * Constructor
     */
    public DataProvider() {
        sqliteConnection = new SQLiteConnection();
    }
    
    /**
     * request data from source
     * @param rq: request to get
     * @param callback: call back to process the data
     */
    public void requestData(String rq, ReceiveData callback){
        new GetData(rq, callback).start();
    }
    
    /**
     * get local revision
     * @return the local revision
     */
    public int getLocalRev() {
        return sqliteConnection.getLocalRev();
    }
    
    /**
     * get local data
     * @return
     */
    public String getLocalData() {
        return sqliteConnection.getLocalData();
    }
    
    /**
     * update new data
     * @param rev newest revision
     * @param data newest data
     * @return
     */
    public boolean updateData(String rev, String data) {
        return sqliteConnection.updateData(rev, data);
    }
    
    /**
     * close the database
     */
    public void closeDB() {
        sqliteConnection.close();
    }
    
}
