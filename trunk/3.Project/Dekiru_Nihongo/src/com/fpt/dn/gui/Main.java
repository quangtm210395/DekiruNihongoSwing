/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.dao.DataProvider;

/**
 *
 * @author Tran Minh Quang
 */
public class Main {

    public static void main(String[] args) {
        DataProvider dp = new DataProvider();
        dp.requestData("version.json", (String result) -> {
            int localRev = dp.getLocalRev();
            int newestRev;
            try {
                newestRev = Integer.parseInt(result);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            dp.closeDB();
            if (localRev < newestRev) {
                // update found
                new DataProvider().requestData("data.json", (String result1) -> {
                    if (result1.equals("")) {
                        //update found but can not get data
                        return;
                    }
                    boolean canUpd = dp.updateData(String.valueOf(newestRev), result1);
                    if (canUpd) {
                        // update to database successful
                        System.out.println("Update successful!");
                    } else {
                        // update to database failed
                        System.out.println("Update failed!");
                    }
                });
            } else {
                // update not found
                System.out.println("No update");
                return;
            }
        });
        
        System.out.println(dp.getListOfLessonName("vocab", "1"));
    }
}
