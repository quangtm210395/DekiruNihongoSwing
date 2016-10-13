/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.bo.Methods;
import com.fpt.dn.dao.LessonData;
import com.fpt.dn.entity.DNObject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author WindzLord
 */
public class MainQuizPanel extends javax.swing.JFrame {

    private JButton buttonStart;
    private JPanel panelButtonStart;
    private List<DNObject> listQuiz;
    private DNObject currentQuiz;
    private int correct;
    private int incorrect;
    private String lesson;
    private boolean checked;

    /**
     * Creates new form MainQuizPanel
     *
     * @param lesson
     */
    public MainQuizPanel(String lesson) {
        initComponents();
        setLesson(lesson);
        initData();
        initScreen();
        addListeners();
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void setLesson(String lesson) {
        this.lesson = lesson;
    }

    private void initScreen() {
        panelButtonStart = new JPanel(new GridLayout(4, 1));
        panelButtonStart.add(new JLabel(""));
        
        buttonStart = new JButton("Start");
        buttonStart.setFont(new Font("Dialog", 0, 28));
        
        JPanel panelFlowBorder = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFlowBorder.add(buttonStart);
        panelButtonStart.add(panelFlowBorder);
        
        panelMain.remove(panelCenter);
        panelMain.add(panelButtonStart);
        
        repaint();
    }

    private void initData() {
        listQuiz = new LessonData("1", lesson).getListQuiz();
        correct = incorrect = 0;
        checked = false;

        label_icon_remain.setIcon(Methods.newImageIcon("src/icon/ic_remain.png", 60, 60));
        label_icon_remain.setText(String.format("%-5s", "" + listQuiz.size()));
        label_icon_remain.setFont(new Font("Dialog", 0, 24));

        label_icon_correct.setIcon(Methods.newImageIcon("src/icon/ic_correct.png", 60, 60));
        label_icon_correct.setText(String.format("%-5s", "" + correct));
        label_icon_correct.setFont(new Font("Dialog", 0, 24));

        label_icon_incorrect.setIcon(Methods.newImageIcon("src/icon/ic_incorrect.png", 60, 60));
        label_icon_incorrect.setText(String.format("%-5s", "" + incorrect));
        label_icon_incorrect.setFont(new Font("Dialog", 0, 24));

        nextQuestion();
    }

    private void nextQuestion() {
        currentQuiz = listQuiz.get(Methods.getRandom(listQuiz.size()));
        listQuiz.remove(currentQuiz);

        labelQuestion.setText(currentQuiz.getKey());

        buttonGroupChoices.clearSelection();
        radioChoiceA.setEnabled(true);
        radioChoiceB.setEnabled(true);
        radioChoiceC.setEnabled(true);
        radioChoiceD.setEnabled(true);

        Integer[] numbers = {0, 1, 2, 3};
        List<Integer> number = new ArrayList<>(Arrays.asList(numbers));
        for (int i = 0; i < 4; i++) {
            int choice = Methods.getRandom(number.size());
            if (i == 0) {
                radioChoiceA.setText(currentQuiz.getQuizAnswer()[number.get(choice)]);
                label_hint_a.setIcon(Methods.newImageIcon("src/icon/empty.png", 20, 20));
            }
            if (i == 1) {
                radioChoiceB.setText(currentQuiz.getQuizAnswer()[number.get(choice)]);
                label_hint_b.setIcon(Methods.newImageIcon("src/icon/empty.png", 20, 20));
            }
            if (i == 2) {
                radioChoiceC.setText(currentQuiz.getQuizAnswer()[number.get(choice)]);
                label_hint_c.setIcon(Methods.newImageIcon("src/icon/empty.png", 20, 20));
            }
            if (i == 3) {
                radioChoiceD.setText(currentQuiz.getQuizAnswer()[number.get(choice)]);
                label_hint_d.setIcon(Methods.newImageIcon("src/icon/empty.png", 20, 20));
            }
            number.remove(choice);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupChoices = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        panel_no_1 = new javax.swing.JPanel();
        label_space_1 = new javax.swing.JLabel();
        label_icon_remain = new javax.swing.JLabel();
        label_space_2 = new javax.swing.JLabel();
        label_icon_correct = new javax.swing.JLabel();
        label_space_3 = new javax.swing.JLabel();
        label_icon_incorrect = new javax.swing.JLabel();
        panel_no_2 = new javax.swing.JPanel();
        labelQuestion = new javax.swing.JLabel();
        panel_no_3 = new javax.swing.JPanel();
        panel_3_top_left = new javax.swing.JPanel();
        label_space_a = new javax.swing.JLabel();
        label_hint_a = new javax.swing.JLabel();
        radioChoiceA = new javax.swing.JRadioButton();
        panel_3_top_right = new javax.swing.JPanel();
        label_space_b = new javax.swing.JLabel();
        label_hint_b = new javax.swing.JLabel();
        radioChoiceB = new javax.swing.JRadioButton();
        panel_no_4 = new javax.swing.JPanel();
        panel_4_bot_left = new javax.swing.JPanel();
        label_space_c = new javax.swing.JLabel();
        label_hint_c = new javax.swing.JLabel();
        radioChoiceC = new javax.swing.JRadioButton();
        panel_4_bot_right = new javax.swing.JPanel();
        label_space_d = new javax.swing.JLabel();
        label_hint_d = new javax.swing.JLabel();
        radioChoiceD = new javax.swing.JRadioButton();
        panel_no_5 = new javax.swing.JPanel();
        buttonRestart = new javax.swing.JButton();
        label_5_space = new javax.swing.JLabel();
        buttonNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setLayout(new java.awt.BorderLayout());

        panelCenter.setLayout(new java.awt.GridLayout(5, 1));

        label_space_1.setText("       ");
        panel_no_1.add(label_space_1);
        panel_no_1.add(label_icon_remain);

        label_space_2.setText("     ");
        panel_no_1.add(label_space_2);
        panel_no_1.add(label_icon_correct);

        label_space_3.setText("     ");
        panel_no_1.add(label_space_3);
        panel_no_1.add(label_icon_incorrect);

        panelCenter.add(panel_no_1);

        labelQuestion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelQuestion.setForeground(java.awt.Color.DARK_GRAY);
        labelQuestion.setText("Question");
        labelQuestion.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));
        panel_no_2.add(labelQuestion);

        panelCenter.add(panel_no_2);

        panel_no_3.setLayout(new java.awt.GridLayout(1, 2));

        panel_3_top_left.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        label_space_a.setText("                                 ");
        panel_3_top_left.add(label_space_a);
        panel_3_top_left.add(label_hint_a);

        buttonGroupChoices.add(radioChoiceA);
        radioChoiceA.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioChoiceA.setText("Choice A");
        panel_3_top_left.add(radioChoiceA);

        panel_no_3.add(panel_3_top_left);

        panel_3_top_right.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        label_space_b.setText("               ");
        panel_3_top_right.add(label_space_b);
        panel_3_top_right.add(label_hint_b);

        buttonGroupChoices.add(radioChoiceB);
        radioChoiceB.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioChoiceB.setText("Choice Boo");
        panel_3_top_right.add(radioChoiceB);

        panel_no_3.add(panel_3_top_right);

        panelCenter.add(panel_no_3);

        panel_no_4.setLayout(new java.awt.GridLayout(1, 2));

        panel_4_bot_left.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        label_space_c.setText("                                 ");
        panel_4_bot_left.add(label_space_c);
        panel_4_bot_left.add(label_hint_c);

        buttonGroupChoices.add(radioChoiceC);
        radioChoiceC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioChoiceC.setText("せんせいではありません");
        panel_4_bot_left.add(radioChoiceC);

        panel_no_4.add(panel_4_bot_left);

        panel_4_bot_right.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        label_space_d.setText("               ");
        panel_4_bot_right.add(label_space_d);
        panel_4_bot_right.add(label_hint_d);

        buttonGroupChoices.add(radioChoiceD);
        radioChoiceD.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        radioChoiceD.setText("Choice K");
        panel_4_bot_right.add(radioChoiceD);

        panel_no_4.add(panel_4_bot_right);

        panelCenter.add(panel_no_4);

        buttonRestart.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        buttonRestart.setText("Start Again");
        buttonRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRestartActionPerformed(evt);
            }
        });
        panel_no_5.add(buttonRestart);

        label_5_space.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_5_space.setText("                              ");
        panel_no_5.add(label_5_space);

        buttonNext.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });
        panel_no_5.add(buttonNext);

        panelCenter.add(panel_no_5);

        panelMain.add(panelCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        // TODO add your handling code here:
        if (checked) {
            checked = false;
            nextQuestion();
            return;
        }
        checked = true;

        if (getSelectedButtonText(buttonGroupChoices).equals(currentQuiz.getWrightAnswer())) {
            correct++;
        } else {
            incorrect++;
        }
        label_icon_remain.setText(String.format("%-5s", "" + listQuiz.size()));
        label_icon_correct.setText(String.format("%-5s", "" + correct));
        label_icon_incorrect.setText(String.format("%-5s", "" + incorrect));
        if (listQuiz.isEmpty()) {
            buttonNext.setEnabled(false);
        }

        radioChoiceA.setEnabled(false);
        radioChoiceB.setEnabled(false);
        radioChoiceC.setEnabled(false);
        radioChoiceD.setEnabled(false);

        if (radioChoiceA.isSelected()) {
            label_hint_a.setIcon(Methods.newImageIcon("src/icon/ic_incorrect.png", 20, 20));
        }
        if (radioChoiceA.getText().equals(currentQuiz.getWrightAnswer())) {
            label_hint_a.setIcon(Methods.newImageIcon("src/icon/ic_correct.png", 20, 20));
        }

        if (radioChoiceB.isSelected()) {
            label_hint_b.setIcon(Methods.newImageIcon("src/icon/ic_incorrect.png", 20, 20));
        }
        if (radioChoiceB.getText().equals(currentQuiz.getWrightAnswer())) {
            label_hint_b.setIcon(Methods.newImageIcon("src/icon/ic_correct.png", 20, 20));
        }

        if (radioChoiceC.isSelected()) {
            label_hint_c.setIcon(Methods.newImageIcon("src/icon/ic_incorrect.png", 20, 20));
        }
        if (radioChoiceC.getText().equals(currentQuiz.getWrightAnswer())) {
            label_hint_c.setIcon(Methods.newImageIcon("src/icon/ic_correct.png", 20, 20));
        }

        if (radioChoiceD.isSelected()) {
            label_hint_d.setIcon(Methods.newImageIcon("src/icon/ic_incorrect.png", 20, 20));
        }
        if (radioChoiceD.getText().equals(currentQuiz.getWrightAnswer())) {
            label_hint_d.setIcon(Methods.newImageIcon("src/icon/ic_correct.png", 20, 20));
        }

    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRestartActionPerformed
        // TODO add your handling code here:
        buttonNext.setEnabled(true);
        initData();
    }//GEN-LAST:event_buttonRestartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupChoices;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonRestart;
    private javax.swing.JLabel labelQuestion;
    private javax.swing.JLabel label_5_space;
    private javax.swing.JLabel label_hint_a;
    private javax.swing.JLabel label_hint_b;
    private javax.swing.JLabel label_hint_c;
    private javax.swing.JLabel label_hint_d;
    private javax.swing.JLabel label_icon_correct;
    private javax.swing.JLabel label_icon_incorrect;
    private javax.swing.JLabel label_icon_remain;
    private javax.swing.JLabel label_space_1;
    private javax.swing.JLabel label_space_2;
    private javax.swing.JLabel label_space_3;
    private javax.swing.JLabel label_space_a;
    private javax.swing.JLabel label_space_b;
    private javax.swing.JLabel label_space_c;
    private javax.swing.JLabel label_space_d;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panel_3_top_left;
    private javax.swing.JPanel panel_3_top_right;
    private javax.swing.JPanel panel_4_bot_left;
    private javax.swing.JPanel panel_4_bot_right;
    private javax.swing.JPanel panel_no_1;
    private javax.swing.JPanel panel_no_2;
    private javax.swing.JPanel panel_no_3;
    private javax.swing.JPanel panel_no_4;
    private javax.swing.JPanel panel_no_5;
    private javax.swing.JRadioButton radioChoiceA;
    private javax.swing.JRadioButton radioChoiceB;
    private javax.swing.JRadioButton radioChoiceC;
    private javax.swing.JRadioButton radioChoiceD;
    // End of variables declaration//GEN-END:variables

    private void addListeners() {
        buttonStart.addActionListener((ActionEvent e) -> {
            panelMain.remove(panelButtonStart);
            panelMain.add(panelCenter);
            MainLessonPanel.instance.refreshScreen();
        });
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

}
