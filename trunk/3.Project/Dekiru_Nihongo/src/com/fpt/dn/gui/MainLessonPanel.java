/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.dao.DataProvider;
import com.fpt.dn.entity.Properties;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 *
 * @author WindzLord
 */
public class MainLessonPanel extends javax.swing.JFrame {

    public static MainLessonPanel instance = new MainLessonPanel();

    private final Stack<JPanel> stackPanel = new Stack<>();

    // Variables declaration - do not modify                     
    private JPanel panelWhole;
    private JPanel panelTop;
    private JPanel panelMain;
    private JPanel panelListLeson;
    private JButton btnBack;
    private JButton btnGo;
    private JScrollPane scrollPaneListLesson;
    JList<String> listLesson;
    // End of variables declaration   

    /**
     * Creates new form NewJFrame
     */
    public MainLessonPanel() {
        settingWindow();
        initComponents();
        addListeners();
    }

    private void settingWindow() {
        setTitle("My Application");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        refreshScreen();

        setLocationRelativeTo(null);
        setResizable(false);

        panelWhole = new JPanel(new BorderLayout());
        getContentPane().add(panelWhole, BorderLayout.CENTER);
    }

    private void initComponents() {

        panelTop = new JPanel(new BorderLayout());
        panelWhole.add(panelTop, BorderLayout.NORTH);

        btnBack = new JButton("Back");
        btnBack.setFont(new java.awt.Font("Dialog", 0, 30));
        panelTop.add(btnBack, BorderLayout.WEST);

        JPanel panelTopCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTopCenter.setBorder(new LineBorder(Color.BLACK, 2));
        panelTop.add(panelTopCenter, BorderLayout.CENTER);

        JLabel lblName = new JLabel("できる 日本語");
        lblName.setFont(new java.awt.Font("Dialog", 0, 30));
        panelTopCenter.add(lblName);

        btnGo = new JButton("Go");
        btnGo.setFont(new java.awt.Font("Dialog", 0, 30));
        panelTop.add(btnGo, BorderLayout.EAST);

        panelMain = new JPanel(new GridLayout(0, 1));
        panelMain.setBorder(new EmptyBorder(Properties.screenBorder));
        panelWhole.add(panelMain, BorderLayout.CENTER);

        // List Lessons
        DefaultListModel<String> arrayListModel = new DefaultListModel<>();

        List<String> listLessons = new DataProvider().getListOfLessonName("vocab", "1");
        String paddingLeft = "  Lesson ";
        for (int i = 0; i < listLessons.size(); i++) {
            arrayListModel.addElement(paddingLeft + (i + 1) + ": " + listLessons.get(i));
        }
        listLesson = new JList<>(arrayListModel);
        listLesson.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listLesson.setBackground(new Color(222, 222, 222));
        listLesson.setFont(new java.awt.Font("Dialog", 0, 18));
        listLesson.setFixedCellHeight(50);

        scrollPaneListLesson = new JScrollPane(listLesson);

        panelListLeson = new JPanel(new BorderLayout());
        panelListLeson.add(scrollPaneListLesson, BorderLayout.CENTER);

        nextStackPanel(panelListLeson);
    }

    private void addListeners() {
        btnBack.addActionListener((ActionEvent event) -> {
            backStackPanel();
        });

        btnGo.addActionListener((ActionEvent event) -> {

        });

        listLesson.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int lesson = listLesson.getSelectedIndex() + 1;
                    nextStackPanel(new TabbedPanel("" + lesson).getPanelMain());
                }
            }
        });
    }

    public void nextStackPanel(JPanel nextPanel) {
        if (!stackPanel.isEmpty()) {
            panelMain.remove(stackPanel.peek());
        }
        stackPanel.push(nextPanel);
        panelMain.add(stackPanel.peek());
        refreshScreen();
        repaint();
    }

    public void backStackPanel() {
        if (stackPanel.size() <= 1) {
            return;
        }
        panelMain.remove(stackPanel.pop());
        panelMain.add(stackPanel.peek());
        repaint();
    }

    public void refreshScreen() {
        pack();
        setSize(Properties.screenWidth, Properties.screenHeight);
    }
}
