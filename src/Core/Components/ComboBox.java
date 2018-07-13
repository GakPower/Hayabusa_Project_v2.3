package Core.Components;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;

public class ComboBox implements Component {

    private JFXComboBox<String> comboBox;

    public ComboBox(JFXComboBox<String> comboBox){
        this.comboBox = comboBox;
        setShowAndHideDynamically();
    }
    private void setShowAndHideDynamically() {
        comboBox.setOnMouseEntered(event -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            comboBox.show();
        });
        comboBox.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
            if (newPropertyValue) {
                comboBox.show();
            } else {
                comboBox.hide();
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
