package Core.Components;

import Core.DayConvertion.DateConvertion;
import com.jfoenix.controls.JFXDatePicker;

public class DatePicker implements Component {

    private JFXDatePicker datePicker;

    public DatePicker(JFXDatePicker datePicker)
    {
        this.datePicker = datePicker;
    }

    @Override
    public String getText() {
        return DateConvertion.convert(datePicker.getValue());
    }

    @Override
    public void clearInput() {
        datePicker.getEditor().setText("");
    }

    @Override
    public void setText(String newText) {
        datePicker.getEditor().setText(newText);
    }

    @Override
    public void setDisable(boolean disable) {
        datePicker.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return datePicker.getEditor().getText() == null || datePicker.getEditor().getText().isEmpty();
    }
}
