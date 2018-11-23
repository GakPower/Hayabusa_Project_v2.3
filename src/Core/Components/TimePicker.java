package Core.Components;

import com.jfoenix.controls.JFXTimePicker;

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
        timepicker.getEditor().setText(newText);
    }

    @Override
    public void setDisable(boolean disable) {
        timepicker.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return timepicker.getEditor().getText() == null || timepicker.getEditor().getText().isEmpty();
    }
}
