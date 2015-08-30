package com.jimtang.saver.gui;

import javax.swing.*;

/**
 * Created by tangz on 8/29/2015.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        setUpGui();
    }

    public void setUpGui() {
        setTitle("Save Images");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 1200);

        SaveSettingsPanel panel = new SaveSettingsPanel();
        add(panel);
        pack();
        setVisible(true);
    }
}
