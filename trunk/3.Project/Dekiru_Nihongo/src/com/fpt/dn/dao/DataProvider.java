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
    public void requestData(ReceiveData callback ){
        GetData getData = new GetData(callback);
        Thread t = new Thread(getData);
        t.start();
    }
    
    
}
