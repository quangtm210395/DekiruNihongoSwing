/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.dao;

import com.fpt.dn.bo.JSONParserBO;
import com.fpt.dn.entity.DNObject;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Tran Minh Quang
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
     *
     * @param rq: request to get
     * @param callback: call back to process the data
     */
    public void requestData(String rq, ReceiveData callback) {
        new GetData(rq, callback).start();
    }

    /**
     * get local revision
     *
     * @return the local revision
     */
    public int getLocalRev() {
        return sqliteConnection.getLocalRev();
    }

    /**
     * get local data
     *
     * @return local data
     */
    public String getLocalData() {
        return sqliteConnection.getLocalData();
    }

    /**
     * update new data
     *
     * @param rev newest revision
     * @param data newest data
     * @return update successful or failed
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

    /**
     * get all data of a lesson
     *
     * @param part grammar or vocabulary or quiz...
     * @param book number of book
     * @param lesson l1,l2,l3...
     * @return a list of object contains data
     */
    public List<DNObject> getDataOfLesson(String part, String book, String lesson) {
        part = part + book;
        lesson = "l" + lesson;
        JSONObject jSONObject = JSONParserBO.parseJSON(getLocalData());
        return JSONParserBO.parseJSONArrayData(JSONParserBO.parseJSONObject(jSONObject, part), lesson);
    }

    /**
     * Get a list of lessons name
     *
     * @param part require part of lesson
     * @param book require book number
     * @return a list of lesson name
     */
    public List<String> getListOfLessonName(String part, String book) {
        String tableName;
        book = "b" + book;
        if (part.equals("vocab")) {
            tableName = "list1";
        } else if (part.equals("gra")) {
            tableName = "list2";
        } else if (part.equals("quiz")) {
            tableName = "list3";
        } else {
            tableName = "list4";
        }
        JSONObject jSONObject = JSONParserBO.parseJSON(getLocalData());
        return JSONParserBO.parseJSONArrayName(JSONParserBO.parseJSONObject(jSONObject, tableName), book);
    }

}
