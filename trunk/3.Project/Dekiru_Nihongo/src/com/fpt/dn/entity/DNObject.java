/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.entity;

/**
 *
 * @author Tran Minh Quang
 */
public class DNObject {

    private String key;
    private String value;

    /**
     * Constructor
     *
     * @param key vocabulary or grammar structure or kanji...
     * @param value meanings or explanation or information of kanji
     */
    public DNObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * get key
     *
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * set key
     *
     * @param key require key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * get value
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Get an array of answers if Object is quiz
     *
     * @return the array of answers
     */
    public String[] getQuizAnswer() {
        return value.split(" | ");
    }

    /**
     * Get the wright answer if Object is quiz
     *
     * @return the wright answer
     */
    public String getWrightAnswer() {
        return getQuizAnswer()[4];
    }

    /**
     * set value
     *
     * @param value require value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * return an object to add to table
     *
     * @return an object[] contains key and value
     */
    public Object[] toObject() {
        return new Object[]{key, value};
    }
}
