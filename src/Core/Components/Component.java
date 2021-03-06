package Core.Components;

public interface Component {

    String getText();

    void clearInput();

    void setText(String newText);

    void setdisable(boolean disable);

    boolean inputIsNullOrEmpty();

    void setStyleClass(String style);
}
