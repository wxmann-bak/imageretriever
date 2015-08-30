package com.jimtang.saver.gui;

import com.jimtang.saver.controller.ImageSaverController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tangz on 8/29/2015.
 */
public abstract class CommonApplicationPanel extends JPanel implements ActionListener, CustomPanel {

    GridBagConstraints gbc = new GridBagConstraints();
    ImageSaverController controller;

    CommonApplicationPanel() {
        super(new GridBagLayout());
        setPadding();
        handleBorder();
        buildUIComponents();
        initController();
        injectController(controller);

        getRunTarget().addActionListener(this);
    }

    protected abstract void initController();

    protected abstract JButton getRunTarget();

    protected abstract ControllerInjectable[] getInjectables();

    public abstract void buildUIComponents();

    void injectController(ImageSaverController controller) {
        for (ControllerInjectable injectable : getInjectables()) {
            injectable.setController(controller);
        }
    }

    public void setPadding() {
        gbc.insets = new Insets(9, 9, 9, 9);
    }

    public void handleBorder() {
        // default implementation does nothing
    }

    protected void setGridAlignment(int x, int y) {
        GUIUtils.setGridPositionWithLeftAlign(gbc, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getRunTarget()) {
            controller.kickoff();
        }
    }
}
