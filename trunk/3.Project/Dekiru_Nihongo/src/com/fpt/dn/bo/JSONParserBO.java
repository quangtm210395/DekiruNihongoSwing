/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.bo;

import com.fpt.dn.entity.DNObject;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

/**
 *
 * @author Tran Minh Quang
 */
public class JSONParserBO {

    /**
     * get a JSONObject from a string
     *
     * @param string to parse to JSONObject
     * @return an JSONObject
     */
    public static JSONObject parseJSON(String string) {
        try {
            return new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get a lower JSONObject from another JSONObject with name objName
     *
     * @param jsonObject higher JSONObject
     * @param objName name of Object need to parse JSON
     * @return a JSONObject
     */
    public static JSONObject parseJSONObject(JSONObject jsonObject, String objName) {
        try {
            return jsonObject.getJSONObject(objName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get a List from a JSONObject
     *
     * @param jsonObject higher JSONObject
     * @param arrName name of JSONArray
     * @return a List of data
     */
    public static List<DNObject> parseJSONArrayData(JSONObject jsonObject, String arrName) {
        List<DNObject> list = new ArrayList<>();
        try {
            JSONArray array = jsonObject.getJSONArray(arrName);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                DNObject objectDN = new DNObject(obj.getString("n"), obj.getString("m"));
                list.add(objectDN);
            }
        } catch (JSONException e) {
//            e.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * get a list of lesson name
     *
     * @param jsonObject higher JSONObject
     * @param arrName name of JSONArray
     * @return List of name of lessons
     */
    public static List<String> parseJSONArrayName(JSONObject jsonObject, String arrName) {
        List<String> list = new ArrayList<>();
        try {
            JSONArray array = jsonObject.getJSONArray(arrName);
            for (int i = 0; i < array.length(); i++) {
                list.add((String) array.get(i));
            }
        } catch (JSONException e) {
//            e.printStackTrace();
            return null;
        }
        return list;
    }

}
