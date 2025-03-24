package org.example.Components;

import javafx.scene.control.Control;

public abstract class AbstractControl {
    private Control control;

    public AbstractControl(Control control) {
        this.control = control;
    }

//    public void setText(String text) {
//        control.setText(text);
//    }
}
