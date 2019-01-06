package Core.Components;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ComboBox implements Component {

    private JFXComboBox<String> comboBox;

    public ComboBox(JFXComboBox<String> comboBox) {
        this.comboBox = comboBox;
        setShowAndHideDynamically();
        banGreekCharacters();
    }

    private void banGreekCharacters(){
        this.comboBox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]")) {
                this.comboBox.getEditor().setText(newValue.replaceAll("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]", ""));
            }
        });
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

    @Override
    public void setStyleClass(String style) {
        comboBox.getStyleClass().clear();
        comboBox.getStyleClass().add(style);
    }

    public void add(String item) {
        if (!comboBox.getItems().contains(item)){
            comboBox.getItems().add(item);
        }
    }

    public ObservableList<String> getItems() {
        return comboBox.getItems();
    }

    public void setItems(ArrayList<String> items){
        for (String string : items) {
            comboBox.getItems().add(string);
        }
    }

    public String getPromptText(){
        return comboBox.getPromptText();
    }
}
