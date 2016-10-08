/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.gui;

import com.fpt.dn.dao.DataProvider;
import com.fpt.dn.entity.Properties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author WindzLord
 */
public class MainLessonPanel extends javax.swing.JFrame {

    public static MainLessonPanel instance = new MainLessonPanel();

    private final Stack<JPanel> stackPanel = new Stack<>();
    private final String title = "できる 日本語";

    private JPanel panelMain;
    private JButton buttonBack;
    private JButton buttonSearch;
    JList<String> listLesson;

    /**
     * Creates new form MainLessonPanel
     */
    public MainLessonPanel() {
        settingWindow();
        initComponents();
        addListeners();
    }

    private void settingWindow() {

        setTitle(title);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        refreshScreen();

        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {

        JPanel panelAll = new JPanel(new BorderLayout());
        getContentPane().add(panelAll, BorderLayout.CENTER);

        JPanel panelTop = new JPanel(new BorderLayout());
        panelAll.add(panelTop, BorderLayout.NORTH);

        buttonBack = new JButton("Back");
        buttonBack.setFont(new java.awt.Font("Dialog", 0, 30));
        panelTop.add(buttonBack, BorderLayout.WEST);

        JPanel panelTopCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTopCenter.setBorder(new LineBorder(Color.BLACK, 2));
        panelTop.add(panelTopCenter, BorderLayout.CENTER);

        JLabel lblName = new JLabel(title);
        lblName.setFont(new java.awt.Font("Dialog", 0, 30));
        panelTopCenter.add(lblName);

        buttonSearch = new JButton("Search");
        buttonSearch.setFont(new java.awt.Font("Dialog", 0, 30));
        panelTop.add(buttonSearch, BorderLayout.EAST);

        panelMain = new JPanel(new GridLayout(0, 1));
        panelMain.setBorder(new EmptyBorder(Properties.screenBorder));
        panelAll.add(panelMain, BorderLayout.CENTER);

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

        JPanel panelListLeson = new JPanel(new BorderLayout());
        panelListLeson.add(new JScrollPane(listLesson), BorderLayout.CENTER);

        nextStackPanel(panelListLeson);
    }

    private void addListeners() {
        buttonBack.addActionListener((ActionEvent event) -> {
            backStackPanel();
        });

        buttonSearch.addActionListener((ActionEvent event) -> {

        });

        listLesson.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int lesson = listLesson.getSelectedIndex() + 1;
                    nextStackPanel(new MainTabbedPanel("" + lesson).getPanelMain());
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
