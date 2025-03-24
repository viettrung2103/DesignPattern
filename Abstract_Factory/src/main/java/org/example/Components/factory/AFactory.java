package org.example.Components.factory;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.Components.button.AbstractButton;
import org.example.Components.button.ButtonA;
import org.example.Components.checkbox.AbstractCheckbox;
import org.example.Components.checkbox.CheckBoxA;
import org.example.Components.textfield.AbstractTextField;
import org.example.Components.textfield.TextFieldA;

public class AFactory extends UIFactory {
    public AFactory(HBox hBox, String text) {
        super(hBox, text);
    }

    @Override
    public AbstractButton createButton() {
        return  new ButtonA(super.gethBox(), super.getText());
    }

    @Override
    public AbstractTextField createTextField() {
        return new TextFieldA(super.gethBox(),super.getText());
    }

    @Override
    public AbstractCheckbox createCheckBox() {
        return new CheckBoxA(super.gethBox(), super.getText());
    }
}
