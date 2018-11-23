package Core.Components;

public interface Component {

    String getText();

    void clearInput();

    void setText(String newText);

    void setDisable(boolean disable);

    boolean inputIsNullOrEmpty();
}
