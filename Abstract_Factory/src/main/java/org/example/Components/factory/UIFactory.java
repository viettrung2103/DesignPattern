package org.example.Components.factory;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.example.Components.AbstractControl;
import org.example.Components.button.AbstractButton;
import org.example.Components.checkbox.AbstractCheckbox;
import org.example.Components.textfield.AbstractTextField;

import java.util.ArrayList;
import java.util.List;

public abstract class UIFactory {
    private String text;
    private HBox hBox;
    private List<AbstractControl> controlList;
    public UIFactory(HBox hBox,String text) {
        this.text = text;
        this.hBox = hBox;
        controlList = new ArrayList<>();
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    public  void setText(String text) {

        for (AbstractControl control: controlList){
            control.setMyText(text);
        }
    }

    public HBox gethBox() {
        return this.hBox;
    }

    public String getText() {
        return this.text;
    }

    public List<AbstractControl> getControlList() {
        return this.controlList;
    }

    public void addControl(AbstractControl control) {
        this.controlList.add(control);
    }

    public abstract AbstractButton createButton();
    public abstract AbstractTextField createTextField();
    public abstract AbstractCheckbox createCheckBox();
}
