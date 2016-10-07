/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.entity;

/**
 *
 * @author Rin's
 */
public class DNObject {
    private String key;
    private String value;

    /**
     * Constructor
     * @param key
     * @param value
     */
    public DNObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * get key
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * set key
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * get value
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * set value
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * return an object to add to table
     * @return
     */
    public Object[] toObject(){return new Object[]{key,value};}
}
