/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.gui.design.FrameTabbedPanel;
import com.fpt.dn.entity.Properties;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author WindzLord
 */
public class TabbedPanel extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnLearn;
    private javax.swing.JPanel panelVoca;
    private javax.swing.JPanel panelGram;
    private javax.swing.JPanel panelKanji;
    private javax.swing.JPanel panelQuiz;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration     

    /**
     * Creates new form NewJFrame
     */
    public TabbedPanel() {
        initComponents();
        addListeners();
    }
    
    public JPanel getPanelMain() {
        return panelMain;
    }
    
    public JTabbedPane getTabbedPane() {
        return tabbedPanel;
    }
    
    private void initComponents() {
        
        panelMain = new javax.swing.JPanel();
        tabbedPanel = new javax.swing.JTabbedPane();
        panelVoca = new javax.swing.JPanel();
        panelGram = new javax.swing.JPanel();
        panelKanji = new javax.swing.JPanel();
        panelQuiz = new javax.swing.JPanel();
        btnLearn = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        panelMain.setLayout(new java.awt.BorderLayout());
        
        btnLearn.setText("Learn vocabulary");
        
        tabbedPanel.addTab(Properties.tabVoca, panelVoca);
        panelVoca.setLayout(new BorderLayout());
        panelVoca.add(btnLearn, java.awt.BorderLayout.SOUTH);
        
        tabbedPanel.addTab(Properties.tabGram, panelGram);
        
        tabbedPanel.addTab(Properties.tabKanji, panelKanji);
        
        tabbedPanel.addTab(Properties.tabQuiz, panelQuiz);
        
        panelMain.add(tabbedPanel, java.awt.BorderLayout.CENTER);
        
        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);
        
        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new FrameTabbedPanel().setVisible(true);
    }
    
    private void addListeners() {
        btnLearn.addActionListener((ActionEvent e) -> {
            JPanel learnVoca = new LearnVocaPanel().getPanelMain();
            
            MainLesson.instance.nextStackPanel(learnVoca);
        });
    }
}
