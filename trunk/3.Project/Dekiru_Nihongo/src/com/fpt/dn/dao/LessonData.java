/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.dao;

import com.fpt.dn.entity.DNObject;
import java.util.List;

/**
 *
 * @author Rin's
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
    
    public static List<DNObject> getListVocab() {
        return listVocab;
    }

    public static List<DNObject> getListGram() {
        return listGram;
    }

    public static List<DNObject> getListKanji() {
        return listKanji;
    }

    public static List<DNObject> getListQuiz() {
        return listQuiz;
    }
    
    
    
    public String[] getVocabArray(){
        String[] vocabArray = new String[listVocab.size()];
        for (int i = 0; i < listVocab.size(); i++) {
            vocabArray[i] = listVocab.get(i).getKey();
        }
        return vocabArray;
    }
    
    public String[] getVocabMeansArray() {
        String[] meansArray = new String[listVocab.size()];
        for (int i = 0; i < listVocab.size(); i++) {
            meansArray[i] = listVocab.get(i).getValue();
        }
        return meansArray;
    }
    
    public String[] getGramArray() {
        String[] gramArray = new String[listGram.size()];
        for (int i = 0; i < listGram.size(); i++) {
            gramArray[i] = listGram.get(1).getKey();
        }
        return gramArray;
    }
    
    public String[] getKanjiArray() {
        String[] kanjiArray = new String[listKanji.size()];
        for (int i = 0; i < listKanji.size(); i++) {
            kanjiArray[i] = listKanji.get(i).getKey();
        }
        return kanjiArray;
    }
    
    
}
