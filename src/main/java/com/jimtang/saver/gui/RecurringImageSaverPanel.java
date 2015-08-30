package com.jimtang.saver.gui;

import com.jimtang.saver.controller.ImageSaverController;
import com.jimtang.saver.controller.RecurringImageSaverController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tangz on 8/29/2015.
 */
public class RecurringImageSaverPanel extends CommonApplicationPanel {

    SaveSettingsPanel saveSettingsPanel;
    TimingPanel timingPanel;
    JButton runButton;


    @Override
    protected void initController() {
        controller = new RecurringImageSaverController();
    }

    @Override
    protected JButton getRunTarget() {
        return runButton;
    }

    @Override
    protected ControllerInjectable[] getInjectables() {
        return new ControllerInjectable[]{saveSettingsPanel, timingPanel};
    }

    @Override
    public void buildUIComponents() {
        setGridAlignment(0, 0);
        saveSettingsPanel = new SaveSettingsPanel();
        add(saveSettingsPanel, gbc);

        setGridAlignment(0, 1);
        timingPanel = new TimingPanel();
        add(timingPanel, gbc);

        setGridAlignment(0, 2);
        runButton = new JButton("Run");
        add(runButton, gbc);
    }
}
