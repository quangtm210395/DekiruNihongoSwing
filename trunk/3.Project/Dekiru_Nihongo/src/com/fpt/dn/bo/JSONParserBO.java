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
 * @author Rin's
 */
public class JSONParserBO {
    
    /**
     * parse a string to JSONObject
     * @param s
     * @return
     */
    public static JSONObject parseJSON(String s) {
        try {
            return new JSONObject(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * get a lower JSONObject from another JSONObject
     * @param jsonObject
     * @param objName
     * @return
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
     * get a JSONArray from a JSONObject
     * @param jsonObject
     * @param arrName
     * @return
     */
    public static List<DNObject> parseJSONArray(JSONObject jsonObject, String arrName) {
        List<DNObject> list = new ArrayList<>();
        try {
            JSONArray array = jsonObject.getJSONArray(arrName);
            for (int i = 0; i < arrName.length(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                DNObject objectDN = new DNObject(obj.getString("n"), obj.getString("m"));
                list.add(objectDN);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
