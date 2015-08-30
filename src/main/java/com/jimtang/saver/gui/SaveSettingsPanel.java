package com.jimtang.saver.gui;

import com.jimtang.saver.controller.ImageSaverController;
import com.jimtang.saver.imagesav.ImageSaver;
import com.jimtang.saver.imagesav.SimpleImageSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by tangz on 8/29/2015.
 */
public class SaveSettingsPanel extends CommonComponentPanel implements ActionListener, InputSource {

    static final String imageUrlTextFieldString = "Image URL:";
    static final String chooseDirectoryString = "Choose";
    static final String fileNameTextFieldString = "File name (including extension):";
    static final String selectDirectoryString = "Select directory:";
    static final String addLocationsString = "Add image to save";

    static final int TEXT_FIELD_WIDTH = 25;

    JTextField imageUrlField;
    JTextField fileNameField;

    JButton selectDirectoryButton;
    JFileChooser directorySelector;
    JTextField directoryIndicator;

    JButton setLocationsButton;

    @Override
    public void handleBorder() {
        // TODO: we might need to work on this.
//        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
//                BorderFactory.createLineBorder(Color.BLUE)));
    }

    @Override
    public void buildUIComponents() {
        // user inputs URL of image
        initImageLocationTextField();

        // user inputs directory
        initSelectDirectory();

        // user inputs destination file name
        initDestinationFileNameTextField();

        // go!
        initSetLocationsButton();
    }


    void initImageLocationTextField() {
        imageUrlField = new JTextField(TEXT_FIELD_WIDTH);

        // add label
        JLabel imageUrlLabel = new JLabel(imageUrlTextFieldString);
        imageUrlLabel.setLabelFor(imageUrlField);
        setGridAlignment(0, 0);
        add(imageUrlLabel, gbc);

        // add text field
        setGridAlignment(1, 0);
        add(imageUrlField, gbc);
    }

    void initSelectDirectory() {
        // directory selector window
        directorySelector = new JFileChooser();
        directorySelector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // select directory label
        JLabel selectDirLabel = new JLabel(selectDirectoryString);

        // select directory button
        selectDirectoryButton = new JButton(chooseDirectoryString);
        selectDirectoryButton.addActionListener(this);

        // put items in place
        directoryIndicator = new JTextField(TEXT_FIELD_WIDTH);

        setGridAlignment(0, 1);
        add(selectDirLabel, gbc);

        setGridAlignment(1, 1);
        add(directoryIndicator, gbc);

        setGridAlignment(2, 1);
        add(selectDirectoryButton, gbc);
    }

    void initDestinationFileNameTextField() {
        fileNameField = new JTextField(TEXT_FIELD_WIDTH);

        // add label
        JLabel fileNameLabel = new JLabel(fileNameTextFieldString);
        fileNameLabel.setLabelFor(fileNameLabel);
        setGridAlignment(0, 2);
        add(fileNameLabel, gbc);

        // add text field
        setGridAlignment(1, 2);
        add(fileNameField, gbc);
    }

    void initSetLocationsButton() {
        setLocationsButton = new JButton(addLocationsString);
        setLocationsButton.addActionListener(this);

        setGridAlignment(0, 3);
        add(setLocationsButton, gbc);
    }

    void clearExistingSettings() {
        imageUrlField.setText(null);
        directoryIndicator.setText(null);
        fileNameField.setText(null);
    }

    void handleSelectDirectoryButton() {
        int returnValue = directorySelector.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File location = directorySelector.getSelectedFile();
            String locationSelectedPath = location.getAbsolutePath();

            directoryIndicator.setText(locationSelectedPath);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectDirectoryButton) {
            handleSelectDirectoryButton();
        }
        if (e.getSource() == setLocationsButton) {
            addInputsToController();
            clearExistingSettings();
        }
    }

    String getTargetLocation() {
        // TODO: handle nulls.
        File targetDirectory = directorySelector.getSelectedFile();
        String targetFileName = fileNameField.getText();
        return new File(targetDirectory, targetFileName).getAbsolutePath();
    }

    @Override
    public void addInputsToController() {
        String sourceLocation = imageUrlField.getText();
        this.controller.addLocations(sourceLocation, getTargetLocation());
    }
}
