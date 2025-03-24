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
        AbstractButton button = new ButtonB(super.gethBox(), super.getText());
        super.addControl(button);
        return button;
    }

    @Override
    public AbstractTextField createTextField() {
        AbstractTextField textField = new TextFieldB(super.gethBox(), super.getText());
        super.addControl(textField);
        return textField;
    }

    @Override
    public AbstractCheckbox createCheckBox() {
        AbstractCheckbox checkbox = new CheckBoxB(super.gethBox(), super.getText());
        super.addControl(checkbox);
        return checkbox;
    }
}
