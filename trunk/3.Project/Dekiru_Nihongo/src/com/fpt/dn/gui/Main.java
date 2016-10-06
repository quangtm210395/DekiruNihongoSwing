/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.bo.JSONParserBO;
import com.fpt.dn.dao.DataProvider;
import com.fpt.dn.entity.DNObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import com.fpt.dn.dao.ReceiveData;

/**
 *
 * @author Rin's
 */
public class Main {
    public static void main(String[] args) {
        DataProvider gd = new DataProvider();
        gd.requestData(new ReceiveData() {
            @Override
            public void onReceive(String result) {
                JSONObject jSONObject = JSONParserBO.parseJSON(result);
                List<DNObject> list = JSONParserBO.parseJSONArray(JSONParserBO.parseJSONObject(jSONObject, "gra1"), "l1");
                System.out.println(list.get(0).getValue());
            }
        });
    }
}
