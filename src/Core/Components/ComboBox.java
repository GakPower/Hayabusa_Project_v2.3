package Core.Components;
//
// Author: GakPower
// 
// Date: 22-Jun-2018 (9:18 PM)
//

import com.jfoenix.controls.JFXComboBox;

public class ComboBox implements Component {

    private JFXComboBox<String> comboBox;

    public ComboBox(JFXComboBox<String> comboBox){
        this.comboBox = comboBox;
    }

    @Override
    public String getText() {
        return comboBox.getValue() != null ? comboBox.getValue() : "";
    }

    @Override
    public void clearInput() {
        comboBox.setValue("");
    }

    @Override
    public void setText(String newText) {
        comboBox.setValue(newText);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return comboBox.getValue() == null || comboBox.getValue().isEmpty();
    }
}
