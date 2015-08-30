package com.jimtang.saver.gui;

import java.awt.*;

/**
 * Created by tangz on 8/29/2015.
 */
public final class GUIUtils {

    public static void setGridPositionWithLeftAlign(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        if (x == 0) {
            // left-align
            gbc.anchor = GridBagConstraints.WEST;
        } else {
            // right-align
            gbc.anchor = GridBagConstraints.EAST;
        }
    }
}
