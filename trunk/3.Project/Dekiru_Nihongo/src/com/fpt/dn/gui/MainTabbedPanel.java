/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.dao.LessonData;
import com.fpt.dn.entity.DNObject;
import com.fpt.dn.entity.Properties;
import com.fpt.dn.entity.UnEditableTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WindzLord
 */
public class MainTabbedPanel extends javax.swing.JFrame {

    private JPanel panelVoca;
    private JPanel panelGram;
    private JPanel panelKanji;
    private JPanel panelQuiz;
    private JPanel panelEmptyGram;
    private JPanel panelEmptyKanji;
    private JPanel panelEmptyQuiz;

    private JPanel panelMain;
    private JButton buttonnLearn;

    private JTable dataTableVoca;
    private JTable dataTableGram;
    private JTable dataTableKanji;
    private LessonData lessonData;

    /**
     * Creates new form MainTabbedPanel
     *
     * @param lesson
     */
    public MainTabbedPanel(String lesson) {
        initComponents();
        initScreen();
        initData(lesson);
        addListeners(lesson);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void initComponents() {

        JTabbedPane tabbedPanel = new javax.swing.JTabbedPane();

        panelVoca = new javax.swing.JPanel();
        panelGram = new javax.swing.JPanel();
        panelKanji = new javax.swing.JPanel();
        panelQuiz = new javax.swing.JPanel();

        panelMain = new javax.swing.JPanel();
        buttonnLearn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setLayout(new java.awt.BorderLayout());

        buttonnLearn.setText("Learn vocabulary");
        buttonnLearn.setForeground(Color.RED);

        tabbedPanel.addTab(Properties.tabVoca, panelVoca);
        panelVoca.setLayout(new BorderLayout());
        panelVoca.add(buttonnLearn, BorderLayout.SOUTH);

        tabbedPanel.addTab(Properties.tabGram, panelGram);
        panelGram.setLayout(new BorderLayout());

        tabbedPanel.addTab(Properties.tabKanji, panelKanji);
        panelKanji.setLayout(new BorderLayout());

        tabbedPanel.addTab(Properties.tabQuiz, panelQuiz);
        panelQuiz.setLayout(new BorderLayout());

        panelMain.add(tabbedPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void addListeners(String lesson) {
        buttonnLearn.addActionListener((ActionEvent e) -> {
            MainLessonPanel.instance.nextStackPanel(new LearnVocabPanel(lesson).getPanelMain());
        });

        if (lesson.charAt(0) <= '3' && lesson.length() == 1) {
            dataTableGram.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        DNObject currentGram = lessonData.getListGram().get(dataTableGram.getSelectedRow());
                        MainLessonPanel.instance.nextStackPanel(new LearnGramPanel(currentGram).getPanelMain());
                    }
                }
            });
        }

        if (lesson.charAt(0) <= '3' && lesson.length() == 1) {
            dataTableKanji.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        DNObject currentKanji = lessonData.getListKanji().get(dataTableKanji.getSelectedRow());
                        MainLessonPanel.instance.nextStackPanel(new LearnKanjiPanel(currentKanji).getPanelMain());
                    }
                }

            });
        }
    }

    private void initData(String lesson) {
        lessonData = new LessonData("1", lesson);

        // Vocabulary
        DefaultTableModel defaultTableModelVocabulary = new UnEditableTableModel();
        defaultTableModelVocabulary.addColumn("");
        defaultTableModelVocabulary.addColumn("");
        lessonData.getListVocab().stream().forEach((object) -> {
            defaultTableModelVocabulary.addRow(object.toObject());
        });
        dataTableVoca = new JTable(defaultTableModelVocabulary);
        dataTableVoca.getColumnModel().getColumn(0).setPreferredWidth(300);
        dataTableVoca.getColumnModel().getColumn(1).setPreferredWidth(400);
        dataTableVoca.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        dataTableVoca.setFont(new Font("Dialog", 0, 20));
        dataTableVoca.setRowHeight(30);
        panelVoca.add(new JScrollPane(dataTableVoca));

        // Kanji
        if (lesson.charAt(0) <= '3' && lesson.length() == 1) {
            UnEditableTableModel defaultTableModelKanji = new UnEditableTableModel();
            defaultTableModelKanji.addColumn("");
            defaultTableModelKanji.addColumn("");
            defaultTableModelKanji.addColumn("");
            lessonData.getListKanji().stream().forEach((object) -> {
                String[] objects = object.getKey().split(" - ");
                defaultTableModelKanji.addRow(objects);
            });
            dataTableKanji = new JTable(defaultTableModelKanji);
            dataTableKanji.getColumnModel().getColumn(0).setPreferredWidth(15);
            dataTableKanji.getColumnModel().getColumn(1).setPreferredWidth(300);
            dataTableKanji.getColumnModel().getColumn(2).setPreferredWidth(300);
            dataTableKanji.setFont(new Font("Dialog", 0, 20));
            dataTableKanji.setRowHeight(30);
            panelKanji.add(new JScrollPane(dataTableKanji));
        } else {
            panelKanji.add(panelEmptyKanji);
        }

        // Grammar
        if (lesson.charAt(0) <= '3' && lesson.length() == 1) {
            UnEditableTableModel defaultTableModelGram = new UnEditableTableModel();
            defaultTableModelGram.addColumn("");
            defaultTableModelGram.addColumn("");
            lessonData.getListGram().stream().forEach((object) -> {
                String[] objects = object.getKey().split(" - ");
                defaultTableModelGram.addRow(objects);
            });
            dataTableGram = new JTable(defaultTableModelGram);
            dataTableGram.getColumnModel().getColumn(0).setPreferredWidth(15);
            dataTableGram.getColumnModel().getColumn(1).setPreferredWidth(657);
            dataTableGram.setFont(new Font("Dialog", 0, 20));
            dataTableGram.setRowHeight(30);
            panelGram.add(new JScrollPane(dataTableGram));
        } else {
            panelGram.add(panelEmptyGram);
        }

        // Quiz
        if (lesson.charAt(0) <= '3' && lesson.length() == 1) {
            panelQuiz.add(new MainQuizPanel(lesson).getPanelMain());
        } else {
            panelQuiz.add(panelEmptyQuiz);
        }
    }

    private void initScreen() {
        panelEmptyGram = new JPanel(new GridLayout(4, 1));
        panelEmptyGram.add(new JLabel(""));
        JLabel labelFoolGram = new JLabel("    COMING SOON    ");
        labelFoolGram.setFont(new Font("Dialog", 0, 28));
        labelFoolGram.setForeground(Color.GREEN);
        labelFoolGram.setBorder(new LineBorder(Color.ORANGE, 2));
        JPanel panelFoolGram = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFoolGram.add(labelFoolGram);
        panelEmptyGram.add(panelFoolGram);
        
        panelEmptyQuiz = new JPanel(new GridLayout(4, 1));
        panelEmptyQuiz.add(new JLabel(""));
        JLabel labelFoolQuiz = new JLabel("    COMING SOON    ");
        labelFoolQuiz.setFont(new Font("Dialog", 0, 28));
        labelFoolQuiz.setForeground(Color.GREEN);
        labelFoolQuiz.setBorder(new LineBorder(Color.ORANGE, 2));
        JPanel panelFoolQuiz = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFoolQuiz.add(labelFoolQuiz);
        panelEmptyQuiz.add(panelFoolQuiz);
        
        panelEmptyKanji = new JPanel(new GridLayout(4, 1));
        panelEmptyKanji.add(new JLabel(""));
        JLabel labelFoolKanji = new JLabel("    COMING SOON    ");
        labelFoolKanji.setFont(new Font("Dialog", 0, 28));
        labelFoolKanji.setForeground(Color.GREEN);
        labelFoolKanji.setBorder(new LineBorder(Color.ORANGE, 2));
        JPanel panelFoolKanji = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFoolKanji.add(labelFoolKanji);
        panelEmptyKanji.add(panelFoolKanji);
    }

}
