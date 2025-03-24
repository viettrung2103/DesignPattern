package org.example.Components.factory;

import javafx.scene.layout.HBox;
import org.example.Components.button.AbstractButton;
import org.example.Components.button.ButtonB;
import org.example.Components.checkbox.AbstractCheckbox;
import org.example.Components.checkbox.CheckBoxB;
import org.example.Components.textfield.AbstractTextField;
import org.example.Components.textfield.TextFieldB;

public class BFactory extends UIFactory{

    public BFactory(HBox hBox, String text) {
        super(hBox, text);
    }
    @Override
    public AbstractButton createButton() {
        return new ButtonB(super.gethBox(), super.getText());
    }

    @Override
    public AbstractTextField createTextField() {
        return new TextFieldB(super.gethBox(), super.getText());
    }

    @Override
    public AbstractCheckbox createCheckBox() {
        return new CheckBoxB(super.gethBox(), super.getText());
    }
}
