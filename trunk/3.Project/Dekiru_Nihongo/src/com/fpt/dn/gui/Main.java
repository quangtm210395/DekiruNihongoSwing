/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.bo.JSONParserBO;
import com.fpt.dn.dao.DataProvider;
import com.fpt.dn.entity.DNObject;
import java.util.List;
import org.json.JSONObject;
import com.fpt.dn.dao.ReceiveData;

/**
 *
 * @author Rin's
 */
public class Main {
    public static void main(String[] args) {
        DataProvider dp = new DataProvider();
        dp.requestData("version.json", new ReceiveData() {
            @Override
            public void onReceive(String result) {
//                JSONObject jSONObject = JSONParserBO.parseJSON(result);
//                List<DNObject> list = JSONParserBO.parseJSONArray(JSONParserBO.parseJSONObject(jSONObject, "gra1"), "l1");
//                System.out.println(list.get(0).getValue());
                int localRev = dp.getLocalRev();
                int newestRev;
                try {
                    newestRev = Integer.parseInt(result);
                } catch (Exception e) {
                    System.out.println(e);
                    return;
                }
                dp.closeDB();
                if (localRev < newestRev) {
                    // update found
                    new DataProvider().requestData("data.json", new ReceiveData() {
                        @Override
                        public void onReceive(String result) {
                            if (result.equals("")) {
                                return;
                            }
                            boolean upd = dp.updateData(String.valueOf(newestRev), result);
                            if (upd) {
                                System.out.println("Update successful!");
                            } else System.out.println("Update failed!");
                        }
                    });
                } else {
                    System.out.println("No update");
                    return;
                }
            }
        });
    }
}
