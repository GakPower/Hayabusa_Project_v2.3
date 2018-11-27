package Core.Components;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class ComboBox implements Component, Serializable {

    private transient JFXComboBox<String> comboBox;

    public ComboBox(JFXComboBox<String> comboBox) {
        this.comboBox = comboBox;
        setShowAndHideDynamically();
    }

    private void setShowAndHideDynamically() {
        comboBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
            {
                comboBox.show();
            }
        });
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
    public void setdisable(boolean disable) {
        comboBox.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return comboBox.getValue() == null || comboBox.getValue().isEmpty();
    }

    public void add(String items) {
        comboBox.getItems().add(items);
    }

    public ObservableList<String> getItems() {
        return comboBox.getItems();
    }
}
