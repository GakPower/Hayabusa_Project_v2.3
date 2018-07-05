package Core.torubbish;
//
// Author: GakPower
// 
// Date: 22-Jun-2018 (7:45 PM)
//

public interface Component {

    String getText();

    void clearInput();
    void setText(String newText);

    boolean inputIsNullOrEmpty();
}
