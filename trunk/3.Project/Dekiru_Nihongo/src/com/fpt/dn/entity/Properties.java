/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.entity;

import java.awt.Insets;

/**
 *
 * @author WindzLord
 */
public class Properties {

    public static final int screenWidth = 800;
    public static final int screenHeight = 500;
    public static final Insets screenBorder = new Insets(10, 15, 10, 15);

    private static final int tabWidth = screenWidth / 4 - 32;
    public static final String tabVoca = String.format("<html><body><table width='%d'>Vocabulary</table></body></html>", tabWidth);
    public static final String tabGram = String.format("<html><body><table width='%d'>Grammar</table></body></html>", tabWidth);
    public static final String tabKanji = String.format("<html><body><table width='%d'>Kanji</table></body></html>", tabWidth);
    public static final String tabQuiz = String.format("<html><body><table width='%d'>Quiz</table></body></html>", tabWidth);

}
