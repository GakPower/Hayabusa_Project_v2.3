package Core.Components;

import com.jfoenix.controls.JFXTextArea;

public class TextArea implements Component {

    private JFXTextArea textArea;

    public TextArea(JFXTextArea textArea)
    {
        this.textArea = textArea;
        banGreekCharacters();
    }

    private void banGreekCharacters(){
        this.textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]")) {
                this.textArea.setText(newValue.replaceAll("[ΑαΒβΓγΔδΕεΖζΗηΘθΙιΚκΛλΜμΝνΞξΟοΠπΡρΣσΤτΥυΦφΧχΨψΩω]", ""));
            }
        });
    }

    @Override
    public String getText() {
        return textArea.getText();
    }

    @Override
    public void clearInput() {
        textArea.clear();
    }

    @Override
    public void setText(String newText) {
        textArea.setText(newText);
    }

    @Override
    public void setdisable(boolean disable) {
        textArea.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return textArea.getText() == null || textArea.getText().isEmpty();
    }

    @Override
    public void setStyleClass(String style) {
        textArea.getStyleClass().clear();
        textArea.getStyleClass().add(style);
    }
}
