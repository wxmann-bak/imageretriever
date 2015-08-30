package com.jimtang.saver.gui;

import com.jimtang.saver.controller.ImageSaverController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tangz on 8/29/2015.
 */
public abstract class CommonComponentPanel extends JPanel implements ControllerInjectable, CustomPanel {

    ImageSaverController controller;
    GridBagConstraints gbc = new GridBagConstraints();;

    CommonComponentPanel() {
        super(new GridBagLayout());
        setPadding();
        handleBorder();
        buildUIComponents();
    }

    public void handleBorder() {
        // default implementation does nothing
    }

    public void setPadding() {
        gbc.insets = new Insets(5, 5, 0, 0);
    }

    protected void setGridAlignment(int x, int y) {
        GUIUtils.setGridPositionWithLeftAlign(gbc, x, y);
    }

    boolean controllerIsInitialized() {
        return controller != null;
    }

    @Override
    public void setController(ImageSaverController controller) {
        this.controller = controller;
    }

    public abstract void buildUIComponents();
}
