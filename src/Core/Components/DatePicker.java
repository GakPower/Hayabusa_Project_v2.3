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
        return DateConvertion.convertToGreek(datePicker.getValue());
    }

    @Override
    public void clearInput() {
        datePicker.getEditor().setText("");
    }

    @Override
    public void setText(String newText) {
        datePicker.setValue(DateConvertion.convertFromGreekToDate(newText));
    }

    @Override
    public void setdisable(boolean disable) {
        datePicker.setDisable(disable);
    }

    @Override
    public boolean inputIsNullOrEmpty() {
        return datePicker.getEditor().getText() == null || datePicker.getEditor().getText().isEmpty();
    }

    @Override
    public void setStyleClass(String style) {
        datePicker.getStyleClass().clear();
        datePicker.getStyleClass().add(style);
    }
}
