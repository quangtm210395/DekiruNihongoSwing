/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.bo;

import javax.swing.ImageIcon;

/**
 *
 * @author WindzLord
 */
public class Methods {

    public static ImageIcon newImageIcon(String path, int width, int height) {
        return (new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, 0)));
    }

}
