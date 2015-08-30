package com.jimtang.saver.gui;

import com.jimtang.saver.controller.ControllerUtils;
import com.jimtang.saver.controller.ImageSaverController;
import com.jimtang.saver.controller.RecurringImageSaverController;
import com.jimtang.saver.imagesav.ImageSaver;
import com.jimtang.saver.imagesav.RecurringImageSaver;
import com.jimtang.saver.imagesav.SimpleImageSaver;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created by tangz on 8/29/2015.
 */
public class TimingPanel extends CommonComponentPanel implements ActionListener, InputSource {

    static final String[] validTimes = ControllerUtils.VALID_TIME_STRINGS;

    JFormattedTextField timeValueField;
    JComboBox<String> timeUnitSelection;
    JLabel label;
    JButton setButton;

    public void buildUIComponents() {
        label = new JLabel("Time Interval:");

        timeValueField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        timeValueField.setColumns(8);

        timeUnitSelection = new JComboBox<>(validTimes);

        setButton = new JButton("Update");

        setGridAlignment(0, 0);
        add(label, gbc);

        setGridAlignment(0, 1);
        add(timeValueField, gbc);

        setGridAlignment(1, 1);
        add(timeUnitSelection, gbc);

        setGridAlignment(0, 2);
        setButton.addActionListener(this);
        add(setButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addInputsToController();
    }

    @Override
    public void addInputsToController() {
        String timeUnitString = (String)timeUnitSelection.getSelectedItem();
        int timeNumericValue = Integer.parseInt(timeValueField.getText());

        ImageSaverController ourController = this.controller;
        if (ourController instanceof RecurringImageSaverController) {
//            RecurringImageSaverController castedController = (RecurringImageSaverController)ourController;
            ((RecurringImageSaverController)ourController).setTimeNumericValue(timeNumericValue);
            ((RecurringImageSaverController)ourController).setTimeUnit(timeUnitString);
//            setController(castedController);
        }
    }
}
