package Core.torubbish.GroupOfComponents;

import Core.SQL.HyperSQL;

public interface GroupOfComponents {

    int maxInputLength = 30;
    HyperSQL sql = new HyperSQL();

    void hideErrorLabel();

    int getMaxInputLength();
    void clearInput();
    boolean isLoginInputOK(String str);
    boolean isSingUpInputOK(String str);
    boolean isForgetPassInputOK();
    void setInput(String newText);
    String getInput();
    void showLabel();
    void hideLabel();
    void setErrorLabelText(String newText);
}
