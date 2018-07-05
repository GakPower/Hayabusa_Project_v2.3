package Core.Components.GroupOfComponents;

import Core.Components.Component;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;

public abstract class GroupOfComponents {
    private final HyperSQL sql = new HyperSQL();
    protected final HyperSQLControl sqlControl = new HyperSQLControl(sql);

    public Component component;
    public ErrorLabel errorLabel;

    public GroupOfComponents(Component component, ErrorLabel errorLabel) {
        this.component = component;
        this.errorLabel = errorLabel;
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
        }
        return result;
    }

    public int getMaxInputLength() {
        return 30;
    }
    public boolean isInputMoreThanMaxLength(){
        return getInput().length() > getMaxInputLength();
    }
}
