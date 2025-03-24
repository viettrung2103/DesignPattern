package org.example.Components.factory;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.example.Components.button.AbstractButton;
import org.example.Components.checkbox.AbstractCheckbox;
import org.example.Components.textfield.AbstractTextField;

public abstract class UIFactory {
    private String text;
    private HBox hBox;
    public UIFactory(HBox hBox,String text) {
        this.text = text;
        this.hBox = hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    public  void setText(String text) {
        createButton().setText(text);
        createTextField().setText(text);
        createCheckBox().setText(text);
    }

    public HBox gethBox() {
        return this.hBox;
    }

    public String getText() {
        return this.text;
    }

    public abstract AbstractButton createButton();
    public abstract AbstractTextField createTextField();
    public abstract AbstractCheckbox createCheckBox();
}
