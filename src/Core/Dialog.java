package Core;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Dialog extends JFXDialog {

    private JFXDialog dialog;
    private JFXButton button;
    private Label label;

    public Dialog(StackPane paneToShow,
                  String message,
                  String buttonText,
                  String buttonCssFilePath,
                  String buttonCssClass,
                  AnchorPane... panesToAffectBlur) {
        button = initDialogButton(buttonText,
                buttonCssFilePath,
                buttonCssClass);

        createDialog(paneToShow, message, panesToAffectBlur);
    }

    private void createDialog(StackPane paneToShow, String message, AnchorPane... panesToAffectBlur){
        JFXDialogLayout dialogLayout = new JFXDialogLayout();

        label = new Label(message);
        dialogLayout.setHeading(label);
        dialogLayout.setActions(button);

        dialog = new JFXDialog(paneToShow, dialogLayout,JFXDialog.DialogTransition.CENTER);
        dialog.setStyle("-fx-background-color: transparent");

        initAndSetBlurEffectOnDialog(panesToAffectBlur);

        dialog.show();
    }
    private JFXButton initDialogButton(String buttonText, String cssFilePath, String cssClass){
        button = new JFXButton(buttonText);
        button.getStylesheets().add(cssFilePath);
        button.getStyleClass().add(cssClass);
        button.setOnAction(event -> label.setText("You have to change the onAction method od the button"));

        return button;
    }
    private void initAndSetBlurEffectOnDialog(AnchorPane... panesToAffectBlur){
        BoxBlur blur = new BoxBlur(3,3,3);
        dialog.setOnDialogOpened(event-> {
            for (AnchorPane pane: panesToAffectBlur) {
                pane.setEffect(blur);
            }
        });
        dialog.setOnDialogClosed(event-> {
            for (AnchorPane pane: panesToAffectBlur) {
                pane.setEffect(null);
            }
        });
    }

    public JFXButton getButton() {
        return button;
    }

    public void close(){
        dialog.close();
    }

}
