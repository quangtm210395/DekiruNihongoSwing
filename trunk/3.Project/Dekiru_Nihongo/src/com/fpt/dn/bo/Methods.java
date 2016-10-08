/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.dn.bo;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author WindzLord
 */
public class Methods {

    private static Random random = new Random();

    public static ImageIcon newImageIcon(String path, int slaceWidth, int scaleHeight) {
        return (new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(slaceWidth, scaleHeight, 0)));
    }

    public static int getRandom(int max) {
        if (max == 0) {
            return -1;
        }
        return random.nextInt(max);
    }

}
