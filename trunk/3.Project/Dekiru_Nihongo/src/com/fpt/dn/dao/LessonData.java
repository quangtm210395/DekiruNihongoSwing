/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.dao;

import com.fpt.dn.entity.DNObject;
import java.util.List;
import org.json.JSONException;

/**
 *
 * @author Tran Minh Quang
 */
public class LessonData {

    private static List<DNObject> listVocab;
    private static List<DNObject> listGram;
    private static List<DNObject> listKanji;
    private static List<DNObject> listQuiz;

    public LessonData(String book, String lesson) {
        DataProvider dp = new DataProvider();
        listVocab = dp.getDataOfLesson("vocab", book, lesson);
        listGram = dp.getDataOfLesson("gra", book, lesson);
        listKanji = dp.getDataOfLesson("kan", book, lesson);
        listQuiz = dp.getDataOfLesson("quiz", book, lesson);
    }

    public List<DNObject> getListVocab() {
        return listVocab;
    }

    public List<DNObject> getListGram() {
        return listGram;
    }

    public List<DNObject> getListKanji() {
        return listKanji;
    }

    public List<DNObject> getListQuiz() {
        return listQuiz;
    }

    /**
     * Get array of vocabulary
     *
     * @return an array of vocabulary
     */
    public String[] getVocabArray() {
        String[] vocabArray = new String[listVocab.size()];
        for (int i = 0; i < listVocab.size(); i++) {
            vocabArray[i] = listVocab.get(i).getKey();
        }
        return vocabArray;
    }

    /**
     * Get array of vocabulary meanings
     *
     * @return an array of meanings
     */
    public String[] getVocabMeansArray() {
        String[] meansArray = new String[listVocab.size()];
        for (int i = 0; i < listVocab.size(); i++) {
            meansArray[i] = listVocab.get(i).getValue();
        }
        return meansArray;
    }

    /**
     * Get an array of Grammar structure
     *
     * @return an array of grammar
     */
    public String[] getGramArray() {
        String[] gramArray = new String[listGram.size()];
        for (int i = 0; i < listGram.size(); i++) {
            gramArray[i] = listGram.get(1).getKey();
        }
        return gramArray;
    }

    /**
     * Get an array of Kanji
     *
     * @return an array of Kanji
     */
    public String[] getKanjiArray() {
        String[] kanjiArray = new String[listKanji.size()];
        for (int i = 0; i < listKanji.size(); i++) {
            kanjiArray[i] = listKanji.get(i).getKey();
        }
        return kanjiArray;
    }

}
