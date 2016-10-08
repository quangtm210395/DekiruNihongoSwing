/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.dao;

import com.fpt.dn.bo.JSONParserBO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tran Minh Quang
 */
public class GetData extends Thread {

    private final String httpUrl = "https://dekiru-nihongo.firebaseio.com/";
    private ReceiveData callback;
    private String request = "";

    /**
     * Constructor
     *
     * @param rq request: version or data
     * @param callback call back to process the data
     */
    public GetData(String rq, ReceiveData callback) {
        this.callback = callback;
        this.request = rq;
    }

    @Override
    public void run() {
        String result = "";
        try {
            URL url = new URL(httpUrl + request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println(conn.getHeaderFields());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
            br.close();
            if (request.equals("version.json")) {
                try {
                    JSONObject jsonObject = JSONParserBO.parseJSON(result);
                    result = jsonObject.getInt("ver") + "";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        callback.onReceive(result);
    }

}
