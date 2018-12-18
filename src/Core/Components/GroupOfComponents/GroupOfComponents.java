package Core.Components.GroupOfComponents;

import Core.Components.Component;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

public abstract class GroupOfComponents {
    private final HyperSQL sql = new HyperSQL();
    protected final HyperSQLControl sqlControl = new HyperSQLControl(sql);
    private int inputLength = 30;

    public Component component;
    public ErrorLabel errorLabel;
    public JFXButton button;
    public JFXCheckBox checkBox;

    public GroupOfComponents(Component component, ErrorLabel errorLabel) {
        this.component = component;
        this.errorLabel = errorLabel;
    }
    public GroupOfComponents(Component component, ErrorLabel errorLabel, JFXButton button){
        this.component = component;
        this.errorLabel = errorLabel;
        this.button = button;
    }
    public GroupOfComponents(Component component, ErrorLabel errorLabel, JFXCheckBox checkBox){
        this.component = component;
        this.errorLabel = errorLabel;
        this.checkBox = checkBox;
    }

    public void setInput(String newText) {
        component.setText(newText);
    }
    public String getInput() {
        return component.getText();
    }
    public void clearInput() {
        component.clearInput();
    }
    public void showErrorLabel(){
        errorLabel.show();
    }
    public void hideErrorLabel(){
        errorLabel.hide();
    }
    public boolean isInputOK(String str) {
        boolean result = true;
        if (component.inputIsNullOrEmpty()) {
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input is empty... Please try again");
            result = false;
        }else if (isInputMoreThanMaxLength()){
            errorLabel.show();
            errorLabel.setTooltipText("Invalid input! Input's length is more that "+getMaxInputLength()+" characters... Please try again");
            result = false;
        }
        return result;
    }

    public int getMaxInputLength() {
        return inputLength;
    }
    public void setMaxInputLength(int inputLength){
        this.inputLength = inputLength;
    }
    public boolean isInputMoreThanMaxLength(){
        return getInput().length() > getMaxInputLength();
    }
}
