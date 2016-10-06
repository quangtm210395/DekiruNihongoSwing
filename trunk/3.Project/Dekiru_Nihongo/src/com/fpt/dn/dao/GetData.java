/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rin's
 */
public class GetData extends Thread {
        private final String httpUrl = "https://dekiru-nihongo.firebaseio.com/data.json";
        private ReceiveData callback;

        public GetData(ReceiveData callback) {
            this.callback = callback;
        }
        
        @Override
        public void run() {
            String result = "";
            try {
                URL url = new URL(httpUrl);
                HttpURLConnection conn  = (HttpURLConnection) url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line ;
                while( (line = br.readLine()) != null) {
                    result += line;
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
            callback.onReceive(result);
        }
        
    }
