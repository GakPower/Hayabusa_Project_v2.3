package Core.Scenes.Login_SingUp;

import Core.Animations.Animation;
import Core.Animations.AnimationControls;
import Core.Components.ComboBox;
import Core.Components.GroupOfComponents.*;
import Core.Components.PasswordField;
import Core.Components.TextField;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import Core.Scenes.Scenes;
import Core.Scenes.UIControls;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.io.File;

public class Login_SingUpController {

    private static final HyperSQL sql = new HyperSQL();
    private static final HyperSQLControl sqlControl = new HyperSQLControl(sql);
    private final File file = new File("C:\\Hayabusa Project\\HayaBusa");
    private static final int DURATION_INT = 500;
    private static final Duration DURATION = Duration.millis(DURATION_INT);

    @FXML private AnchorPane SignUp_Anchor;
    @FXML private AnchorPane mainRight_Anchor;
    @FXML private AnchorPane Login_Anchor;
    @FXML private StackPane mainLogin_SignUp_Stack;
    @FXML private Label CommentAboveLogin_SingUpButton;
    @FXML private JFXButton Login_SingUp_Button;

    @FXML private AnchorPane EnterUsername_Anchor;
    @FXML private AnchorPane AnswerQuestion_Anchor;
    @FXML private AnchorPane ChangePassword_Anchor;
    @FXML private Label UsernameLogin_Label;
    @FXML private ImageView UsernameLogin_ImageView;
    @FXML private Label PasswordLogin_Label;
    @FXML private ImageView PasswordLogin_ImageView;
    @FXML private JFXTextField UsernameLogin_Field;
    @FXML private JFXPasswordField PasswordLogin_Field;
    @FXML private JFXCheckBox RememberMe_CheckBox;

    private ErrorLabel UsernameLogin_ErrorLabel;
    private ErrorLabel PasswordLogin_ErrorLabel;
    private GroupOfComponents UsernameLogin_Group;
    private GroupOfComponents PasswordLogin_Group;


    @FXML private JFXTextField UsernameSingUp_Field;
    @FXML private JFXPasswordField PasswordSingUp_Field;
    @FXML private JFXPasswordField PasswordConfirmSingUp_Field;
    @FXML private JFXComboBox<String> SecQuestionSingUp_Combo;
    @FXML private JFXTextField SecAnsSingUp_Field;
    @FXML private Label UsernameSingUp_Label;
    @FXML private ImageView UsernameSingUp_Image;
    @FXML private Label PasswordSingUp_Label;
    @FXML private ImageView PasswordSingUp_Image;
    @FXML private Label PasswordConfirmSingUp_Label;
    @FXML private ImageView PasswordConfirmSingUp_Image;
    @FXML private Label SecQuestionSingUp_Label;
    @FXML private ImageView SecQuestionSingUp_Image;
    @FXML private Label SecAnsSingUp_Label;
    @FXML private ImageView SecAnsSingUp_Image;

    private ErrorLabel UsernameSingUp_ErrorLabel;
    private ErrorLabel PasswordSingUp_ErrorLabel;
    private ErrorLabel PasswordConfirmSingUp_ErrorLabel;
    private ErrorLabel SecQuestionSingUp_ErrorLabel;
    private ErrorLabel SecAnsSingUp_ErrorLabel;
    private GroupOfComponents UsernameSingUp_Group;
    private GroupOfComponents PasswordSingUp_Group;
    private GroupOfComponents PasswordConfirmSingUp_Group;
    private GroupOfComponents SecQuestionSingUp_Group;
    private GroupOfComponents SecAnsSingUp_Group;

    @FXML private JFXTextField EnterUsername_Field;
    @FXML private Label EnterUsername_Label;
    @FXML private ImageView EnterUsername_Image;

    private ErrorLabel UsernameForgetPass_ErrorLabel;
    private GroupOfComponents UsernameForgetPass_Group;

    @FXML private JFXTextField SecQuestionAnsQuestion_Field;
    @FXML private JFXTextField SecAnswerAnsQuestion_Field;
    @FXML private Label SecQuestionAnsQuestion_Label;
    @FXML private ImageView SecQuestionAnsQuestion_Image;
    @FXML private Label SecAnswerAnsQuestion_Label;
    @FXML private ImageView SecAnswerAnsQuestion_Image;

    private ErrorLabel SecQuestionForgetPass_ErrorLabel;
    private ErrorLabel SecAnswerForgetPass_ErrorLabel;
    private GroupOfComponents SecQuestionForgetPass_Group;
    private GroupOfComponents SecAnswerForgetPass_Group;

    private AnchorPane activeAnchorPane = Login_Anchor;


    @FXML private void initialize(){
        IfFirstTimeExecutedShowSignUp();
        initGroups();
        setRememberedUsernameIfInDB();
    }
    private void IfFirstTimeExecutedShowSignUp(){
        if (firstTimeExecuted()){
            onLogin_SingUpButtonClick();
        }
    }
    private boolean firstTimeExecuted(){
        return !file.exists() || (file.exists() && !sqlControl.hasMoreThen1User());
    }
    private void initGroups(){
        initErrorLabels();
        UsernameLogin_Group = new GroupOfUsername(new TextField(UsernameLogin_Field), UsernameLogin_ErrorLabel);
        PasswordLogin_Group = new GroupOfPassword(new PasswordField(PasswordLogin_Field), PasswordLogin_ErrorLabel);

        UsernameSingUp_Group = new GroupOfUsername(new TextField(UsernameSingUp_Field), UsernameSingUp_ErrorLabel);
        PasswordSingUp_Group = new GroupOfPassword(new PasswordField(PasswordSingUp_Field), PasswordSingUp_ErrorLabel);
        PasswordConfirmSingUp_Group = new GroupOfConfirmPassword(new PasswordField(PasswordConfirmSingUp_Field), PasswordConfirmSingUp_ErrorLabel, (GroupOfPassword) PasswordSingUp_Group);
        SecQuestionSingUp_Group = new GroupOfComboBox(new ComboBox(SecQuestionSingUp_Combo), SecQuestionSingUp_ErrorLabel);
        SecAnsSingUp_Group = new GroupOfInfo(new TextField(SecAnsSingUp_Field), SecAnsSingUp_ErrorLabel);

        UsernameForgetPass_Group = new GroupOfUsername(new TextField(EnterUsername_Field), UsernameForgetPass_ErrorLabel);

        SecQuestionForgetPass_Group = new GroupOfUsername(new TextField(SecQuestionAnsQuestion_Field), SecQuestionForgetPass_ErrorLabel);
        SecAnswerForgetPass_Group = new GroupOfUsername(new TextField(SecAnswerAnsQuestion_Field), SecAnswerForgetPass_ErrorLabel);
    }
    private void initErrorLabels(){
        UsernameLogin_ErrorLabel = new ErrorLabel(UsernameLogin_Label, UsernameLogin_ImageView);
        PasswordLogin_ErrorLabel = new ErrorLabel(PasswordLogin_Label, PasswordLogin_ImageView);

        UsernameSingUp_ErrorLabel = new ErrorLabel(UsernameSingUp_Label, UsernameSingUp_Image);
        PasswordSingUp_ErrorLabel = new ErrorLabel(PasswordSingUp_Label, PasswordSingUp_Image);
        PasswordConfirmSingUp_ErrorLabel = new ErrorLabel(PasswordConfirmSingUp_Label, PasswordConfirmSingUp_Image);
        SecQuestionSingUp_ErrorLabel = new ErrorLabel(SecQuestionSingUp_Label, SecQuestionSingUp_Image);
        SecAnsSingUp_ErrorLabel = new ErrorLabel(SecAnsSingUp_Label, SecAnsSingUp_Image);

        UsernameForgetPass_ErrorLabel = new ErrorLabel(EnterUsername_Label, EnterUsername_Image);

        SecQuestionForgetPass_ErrorLabel = new ErrorLabel(SecQuestionAnsQuestion_Label, SecQuestionAnsQuestion_Image);
        SecAnswerForgetPass_ErrorLabel = new ErrorLabel(SecAnswerAnsQuestion_Label, SecAnswerAnsQuestion_Image);
    }
    private void setRememberedUsernameIfInDB(){
        if (wasCheckBoxSelected()){
            RememberMe_CheckBox.setSelected(true);
            UsernameLogin_Field.setText(sqlControl.getRememberMeUsername());
        }
    }
    private boolean wasCheckBoxSelected(){
        return sqlControl.getRememberMeBoolean();
    }

    @FXML private void onLoginClick(){
        hideLoginErrorLabels();
        loginIfInputIsOK();
        storeUsernameIfCheckBoxIsSelected();
        clearLoginInput();
    }
    private void hideLoginErrorLabels(){
        UsernameLogin_Group.hideErrorLabel();
        PasswordLogin_Group.hideErrorLabel();
    }
    private void loginIfInputIsOK(){
        if (isLoginInputOK()){
            Scenes.changeScene(Scenes.getFromMap("App"));
        }
    }
    private boolean isLoginInputOK(){
        return UsernameLogin_Group.isLoginInputOK(null) && PasswordLogin_Group.isLoginInputOK(UsernameLogin_Group.getInput());
    }
    private void clearLoginInput(){
        UsernameLogin_Group.clearInput();
        PasswordLogin_Group.clearInput();
    }

    @FXML private void onSignUpClick() {
        hideSignUpErrorLabels();
        if (isSignUpInputOK()) {
            initDialog();
            storeInfoToDBInNewThreadAncClearInput();
            onLogin_SingUpButtonClick();
        }
    }
    private boolean isSignUpInputOK(){
        boolean isUsernameOK = UsernameSingUp_Group.isSingUpInputOK(UsernameSingUp_Group.getInput());
        boolean isPasswordOK = PasswordSingUp_Group.isSingUpInputOK(null);
        boolean isPasswordConfirmOK = PasswordConfirmSingUp_Group.isSingUpInputOK(null);
        boolean isSecQuestionOK = SecQuestionSingUp_Group.isSingUpInputOK(null);
        boolean isSecAnsOK = SecAnsSingUp_Group.isSingUpInputOK(null);

        return isUsernameOK && isPasswordOK && isPasswordConfirmOK && isSecQuestionOK && isSecAnsOK;
    }
    private void initDialog(){
        JFXButton okDialogButton = initDialogButtonAndReturnIt();
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(mainLogin_SignUp_Stack,dialogLayout,JFXDialog.DialogTransition.CENTER);
        dialog.setStyle("-fx-background-color: transparent");

        dialogLayout.setHeading(new Label("You have successfully been registered to Hayabusa Project!"));
        dialogLayout.setActions(okDialogButton);
        okDialogButton.setOnAction(event -> dialog.close());
        initAndSetBlurEffectOnDialog(dialog);

        dialog.show();
    }
    private JFXButton initDialogButtonAndReturnIt(){
        JFXButton okDialogButton = new JFXButton("OK");
        okDialogButton.getStylesheets().add("Core/Scenes/Login_SingUp/StyleSheet.css");
        okDialogButton.getStyleClass().add("dialogButton");
        return okDialogButton;
    }
    private void initAndSetBlurEffectOnDialog(JFXDialog dialog){
        BoxBlur blur = new BoxBlur(3,3,3);
        dialog.setOnDialogOpened(event-> {
            SignUp_Anchor.setEffect(blur);
            mainRight_Anchor.setEffect(blur);
            Login_Anchor.setEffect(blur);
        });
        dialog.setOnDialogClosed(event-> {
            SignUp_Anchor.setEffect(null);
            mainRight_Anchor.setEffect(null);
            Login_Anchor.setEffect(null);
        });
    }
    private void storeInfoToDBInNewThreadAncClearInput(){
        new Thread(()-> {
            storeInfoToDB();
            clearSingUpInput();
        }).start();

    }
    private void clearSingUpInput(){
        UsernameSingUp_Group.clearInput();
        PasswordSingUp_Group.clearInput();
        PasswordConfirmSingUp_Group.clearInput();
        SecQuestionSingUp_Group.clearInput();
        SecAnsSingUp_Group.clearInput();
    }
    private void hideSignUpErrorLabels(){
        UsernameSingUp_Group.hideErrorLabel();
        PasswordSingUp_Group.hideErrorLabel();
        PasswordConfirmSingUp_Group.hideErrorLabel();
        SecQuestionSingUp_Group.hideErrorLabel();
        SecAnsSingUp_Group.hideErrorLabel();
    }
    private void storeInfoToDB(){
        storeQuestionToDB();
        storeUserToDB();
    }
    private void storeUserToDB(){
        String[] info = new String[5];
        info[0] = String.valueOf(sqlControl.getNextIDFromTable("Users"));
        info[1] = "\'"+UsernameSingUp_Group.getInput()+"\'";
        info[2] = "\'"+PasswordSingUp_Group.getInput()+"\'";
        info[3] = sqlControl.getIDToStringForQuestionOfUsername(UsernameSingUp_Group.getInput());
        info[4] = "\'"+SecAnsSingUp_Group.getInput()+"\'";

        sqlControl.storeSignInInfoToTable(info, "Users");
    }
    private void storeQuestionToDB() {
        sqlControl.addInfoToTable("SecurityCombo", sqlControl.getNextIDFromTable("SecurityCombo") +
                ", \'" + UsernameSingUp_Group.getInput() + "\', " +
                "\'" + SecQuestionSingUp_Group.getInput() + "\', " +
                "\'" + SecAnsSingUp_Group.getInput()+"\'");
    }

    private void storeUsernameIfCheckBoxIsSelected(){
        sqlControl.setRememberMe(RememberMe_CheckBox.isSelected(), UsernameLogin_Group.getInput());
    }

    @FXML private void onLogin_SingUpButtonClick(){
        if (isButtonTextEqualToSingUp()){
            SignUp_Anchor.setVisible(true);
            animationSignUpIn();

            CommentAboveLogin_SingUpButton.setText("Do you already have an account?");
            Login_SingUp_Button.setText("Login");
        }else{
            animationSignUpOut();

            CommentAboveLogin_SingUpButton.setText("Don't you have an account yet?");
            Login_SingUp_Button.setText("Sing up");
        }

    }
    private boolean isButtonTextEqualToSingUp(){
        return Login_SingUp_Button.getText().equals("Sing up");
    }
    private void animationSignUpIn(){
        Animation.scaleAnimationToX(DURATION, SignUp_Anchor, 1).play();
        Animation.fadeInAnimation(DURATION, SignUp_Anchor).play();

        AnimationControls.translateAndFadeOutInDuration(activeAnchorPane, -345, DURATION);

        AnimationControls.translateAndFadeOutInDuration(Login_Anchor, -345, DURATION);
    }
    private void animationSignUpOut(){
        Animation.scaleAnimationToX(DURATION, SignUp_Anchor, 0.1).play();
        Animation.fadeOutAnimation(DURATION, SignUp_Anchor).play();

        Animation.translateAnimation(DURATION, activeAnchorPane, 0).play();

        Animation.translateAnimation(DURATION, Login_Anchor, 0).play();
        Animation.fadeInAnimation(DURATION, Login_Anchor).play();
        Login_Anchor.setVisible(true);
    }

    @FXML private void onFinishChangePassClick(){
        //Check and change pass
    }
    @FXML private void onNextAnswerQuestionClick(){
        AnimationControls.hideAndShowWithAnimationInDuration(AnswerQuestion_Anchor, ChangePassword_Anchor, DURATION);
        activeAnchorPane = ChangePassword_Anchor;
    }
    @FXML private void onNextEnterUsernameClick(){
        if (isEnterUsernameInputOK()) {
            new Thread(()->);
            AnimationControls.hideAndShowWithAnimationInDuration(EnterUsername_Anchor, AnswerQuestion_Anchor, DURATION);
            activeAnchorPane = AnswerQuestion_Anchor;
        }
    }
    private boolean isEnterUsernameInputOK(){
        return UsernameForgetPass_Group.isForgetPassInputOK();
    }
    @FXML private void onForgotButtonClick(){
        AnimationControls.hideAndShowWithAnimationInDuration(Login_Anchor, EnterUsername_Anchor, DURATION);
        activeAnchorPane = EnterUsername_Anchor;
    }
    @FXML private void onBackChangePassClick(){
        AnimationControls.hideAndShowWithAnimationInDuration(ChangePassword_Anchor, AnswerQuestion_Anchor, DURATION);
        activeAnchorPane = AnswerQuestion_Anchor;
    }
    @FXML private void onBackAnswerQuestionClick(){
        AnimationControls.hideAndShowWithAnimationInDuration(AnswerQuestion_Anchor, EnterUsername_Anchor, DURATION);
        activeAnchorPane = EnterUsername_Anchor;
    }
    @FXML private void onExitAddUsernameClick(){
        AnimationControls.hideAndShowWithAnimationInDuration(EnterUsername_Anchor, Login_Anchor, DURATION);
        activeAnchorPane = Login_Anchor;
    }

    @FXML private void onExitButtonClick(){
        UIControls.closeApplication();
    }
    @FXML private void onMinimizeButtonClick(){
        UIControls.minimizeApplication();
    }
}
