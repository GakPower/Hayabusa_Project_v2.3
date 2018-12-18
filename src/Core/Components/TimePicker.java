package Core.Components;

import com.jfoenix.controls.JFXTimePicker;

import java.time.LocalTime;

public class TimePicker implements Component {

    private JFXTimePicker timepicker;

    public TimePicker(JFXTimePicker timePicker)
    {
        this.timepicker = timePicker;
    }

    @Override
    public String getText() {
        return timepicker.getValue().toString();
    }

    @Override
    public void clearInput() {
        timepicker.getEditor().setText("");
    }

    @Override
    public void setText(String newText) {
        String[] splited = newText.split(":");
        timepicker.setValue(LocalTime.of(Integer.valueOf(splited[0]), Integer.valueOf(splited[1])));
    }

    @Override
    public void setdisable(boolean disable) {
        timepicker.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return timepicker.getEditor().getText() == null || timepicker.getEditor().getText().isEmpty();
    }

    @Override
    public void setStyleClass(String style) {
        timepicker.getStyleClass().clear();
        timepicker.getStyleClass().add(style);
    }
}
