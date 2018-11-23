package Core.Scenes.Login_SingUp;

import Core.Animations.Animation;
import Core.Animations.AnimationControls;
import Core.Components.Component;
import Core.Components.ComponentFactories.GroupFactory;
import Core.Components.ComponentType;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import Core.Components.GroupOfComponents.GroupType;
import Core.SQL.CurrentUser;
import Core.SQL.HyperSQL;
import Core.SQL.HyperSQLControl;
import Core.Scenes.Dialog;
import Core.Scenes.Scenes;
import Core.Scenes.UIControls;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.File;

import static Core.Components.ComponentFactory.createComponent;

@SuppressWarnings("Duplicates")
public class Login_SingUpController {

    private static final HyperSQL sql = new HyperSQL();
    private static final HyperSQLControl sqlControl = new HyperSQLControl(sql);
    private final File file = new File("C:\\Hayabusa Project\\HayaBusa");
    private static final int DURATION_INT = 500;
    private static final Duration DURATION = Duration.millis(DURATION_INT);

    @FXML private StackPane mainLogin_SignUp_Stack;
    @FXML private AnchorPane SignUp_Anchor;
    @FXML private AnchorPane main_Anchor;
    @FXML private AnchorPane Login_Anchor;
    @FXML private AnchorPane EnterUsername_Anchor;
    @FXML private AnchorPane AnswerQuestion_Anchor;
    @FXML private AnchorPane ChangePassword_Anchor;
    @FXML private Label CommentAboveLogin_SingUpButton;
    @FXML private JFXButton Login_SingUp_Button;
    @FXML private JFXCheckBox RememberMe_CheckBox;

    @FXML private JFXTextField UsernameLogin_Field;
    @FXML private JFXPasswordField PasswordLogin_Field;
    @FXML private Label UsernameLogin_Label;
    @FXML private ImageView UsernameLogin_ImageView;
    @FXML private Label PasswordLogin_Label;
    @FXML private ImageView PasswordLogin_ImageView;

    private ErrorLabel UsernameLogin_ErrorLabel;
    private ErrorLabel PasswordLogin_ErrorLabel;
    private Component UsernameLogin_Comp;
    private Component PasswordLogin_Comp;
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
    private Component UsernameSingUp_Comp;
    private Component PasswordSingUp_Comp;
    private Component PasswordConfirmSingUp_Comp;
    private Component SecQuestionSingUp_Comp;
    private Component SecAnsSingUp_Comp;
    private GroupOfComponents UsernameSingUp_Group;
    private GroupOfComponents PasswordSingUp_Group;
    private GroupOfComponents PasswordConfirmSingUp_Group;
    private GroupOfComponents SecQuestionSingUp_Group;
    private GroupOfComponents SecAnsSingUp_Group;

    @FXML private JFXTextField UsernameForget_Field;
    @FXML private Label EnterUsername_Label;
    @FXML private ImageView EnterUsername_Image;

    private ErrorLabel UsernameForgetPass_ErrorLabel;
    private Component UsernameForget_Comp;
    private GroupOfComponents UsernameForgetPass_Group;

    @FXML private JFXTextField SecQuestionForget_Field;
    @FXML private JFXTextField SecAnswerForget_Field;
    @FXML private Label SecQuestionForget_Label;
    @FXML private ImageView SecQuestionForget_Image;
    @FXML private Label SecAnswerForget_Label;
    @FXML private ImageView SecAnswerForget_Image;

    private ErrorLabel SecQuestionForget_ErrorLabel;
    private ErrorLabel SecAnswerForget_ErrorLabel;
    private Component SecQuestionForge_Comp;
    private Component SecAnswerForget_Comp;
    private GroupOfComponents SecQuestionForget_Group;
    private GroupOfComponents SecAnswerForget_Group;

    @FXML private JFXPasswordField NewPasswordForget_Field;
    @FXML private JFXPasswordField ConfirmPasswordForget_Field;
    @FXML private Label NewPasswordForget_Label;
    @FXML private ImageView NewPasswordForget_Image;
    @FXML private Label ConfirmPasswordForget_Label;
    @FXML private ImageView ConfirmPasswordForget_Image;

    private ErrorLabel NewPasswordForget_ErrorLabel;
    private ErrorLabel ConfirmPasswordForget_ErrorLabel;
    private Component NewPasswordForget_Comp;
    private Component ConfirmPasswordForget_Comp;
    private GroupOfComponents NewPasswordForget_Group;
    private GroupOfComponents ConfirmPasswordForget_Group;

    private AnchorPane activeAnchorPane = Login_Anchor;


    @FXML private void initialize() {
        IfFirstTimeExecutedShowSignUp();
        initGroups();
        setRememberedUsernameIfInDB();
    }
    private void IfFirstTimeExecutedShowSignUp() {
        if (isFirstTimeExecuted()) {
            onLogin_SingUpButtonClick();
        }
    }
    private boolean isFirstTimeExecuted() {
        return !file.exists() || (file.exists() && !sqlControl.hasMoreThen1User());
    }
    private void initGroups() {
        initComponents();
        initErrorLabels();
        UsernameLogin_Group = GroupFactory.createGroup(GroupType.LOGIN, ComponentType.USERNAME, UsernameLogin_Comp, UsernameLogin_ErrorLabel);
        PasswordLogin_Group = GroupFactory.createGroup(GroupType.LOGIN, ComponentType.PASSWORD, PasswordLogin_Comp, PasswordLogin_ErrorLabel);

        UsernameSingUp_Group = GroupFactory.createGroup(GroupType.SIGNUP, ComponentType.USERNAME, UsernameSingUp_Comp, UsernameSingUp_ErrorLabel);
        PasswordSingUp_Group = GroupFactory.createGroup(GroupType.SIGNUP, ComponentType.PASSWORD, PasswordSingUp_Comp, PasswordSingUp_ErrorLabel);
        PasswordConfirmSingUp_Group = GroupFactory.createGroup(GroupType.SIGNUP, ComponentType.CONFIRMPASSWORD, PasswordConfirmSingUp_Comp, PasswordConfirmSingUp_ErrorLabel);
        SecQuestionSingUp_Group = GroupFactory.createGroup(GroupType.SIGNUP, ComponentType.COMBOBOX, SecQuestionSingUp_Comp, SecQuestionSingUp_ErrorLabel);
        SecAnsSingUp_Group = GroupFactory.createGroup(GroupType.SIGNUP, ComponentType.INFO, SecAnsSingUp_Comp, SecAnsSingUp_ErrorLabel);

        UsernameForgetPass_Group = GroupFactory.createGroup(GroupType.FORGETPASS, ComponentType.USERNAME, UsernameForget_Comp, UsernameForgetPass_ErrorLabel);

        SecQuestionForget_Group = GroupFactory.createGroup(GroupType.FORGETPASS, ComponentType.INFO, SecQuestionForge_Comp, SecQuestionForget_ErrorLabel);
        SecAnswerForget_Group = GroupFactory.createGroup(GroupType.FORGETPASS, ComponentType.INFO, SecAnswerForget_Comp, SecAnswerForget_ErrorLabel);

        NewPasswordForget_Group = GroupFactory.createGroup(GroupType.FORGETPASS, ComponentType.PASSWORD, NewPasswordForget_Comp, NewPasswordForget_ErrorLabel);
        ConfirmPasswordForget_Group = GroupFactory.createGroup(GroupType.FORGETPASS, ComponentType.PASSWORD, ConfirmPasswordForget_Comp, ConfirmPasswordForget_ErrorLabel);
    }
    private void initComponents() {
        UsernameLogin_Comp = createComponent(UsernameLogin_Field);
        PasswordLogin_Comp = createComponent(PasswordLogin_Field);

        UsernameSingUp_Comp = createComponent(UsernameSingUp_Field);
        PasswordSingUp_Comp = createComponent(PasswordSingUp_Field);
        PasswordConfirmSingUp_Comp = createComponent(PasswordConfirmSingUp_Field);
        SecQuestionSingUp_Comp = createComponent(SecQuestionSingUp_Combo);
        SecAnsSingUp_Comp = createComponent(SecAnsSingUp_Field);

        UsernameForget_Comp = createComponent(UsernameForget_Field);

        SecQuestionForge_Comp = createComponent(SecQuestionForget_Field);
        SecAnswerForget_Comp = createComponent(SecAnswerForget_Field);

        NewPasswordForget_Comp = createComponent(NewPasswordForget_Field);
        ConfirmPasswordForget_Comp = createComponent(ConfirmPasswordForget_Field);
    }
    private void initErrorLabels() {
        UsernameLogin_ErrorLabel = new ErrorLabel(UsernameLogin_Label, UsernameLogin_ImageView);
        PasswordLogin_ErrorLabel = new ErrorLabel(PasswordLogin_Label, PasswordLogin_ImageView);

        UsernameSingUp_ErrorLabel = new ErrorLabel(UsernameSingUp_Label, UsernameSingUp_Image);
        PasswordSingUp_ErrorLabel = new ErrorLabel(PasswordSingUp_Label, PasswordSingUp_Image);
        PasswordConfirmSingUp_ErrorLabel = new ErrorLabel(PasswordConfirmSingUp_Label, PasswordConfirmSingUp_Image);
        SecQuestionSingUp_ErrorLabel = new ErrorLabel(SecQuestionSingUp_Label, SecQuestionSingUp_Image);
        SecAnsSingUp_ErrorLabel = new ErrorLabel(SecAnsSingUp_Label, SecAnsSingUp_Image);

        UsernameForgetPass_ErrorLabel = new ErrorLabel(EnterUsername_Label, EnterUsername_Image);

        SecQuestionForget_ErrorLabel = new ErrorLabel(SecQuestionForget_Label, SecQuestionForget_Image);
        SecAnswerForget_ErrorLabel = new ErrorLabel(SecAnswerForget_Label, SecAnswerForget_Image);

        NewPasswordForget_ErrorLabel = new ErrorLabel(NewPasswordForget_Label, NewPasswordForget_Image);
        ConfirmPasswordForget_ErrorLabel = new ErrorLabel(ConfirmPasswordForget_Label, ConfirmPasswordForget_Image);
    }
    private void setRememberedUsernameIfInDB() {
        if (wasCheckBoxSelected()) {
            RememberMe_CheckBox.setSelected(true);
            UsernameLogin_Field.setText(sqlControl.getRememberMeUsername());
        }
    }
    private boolean wasCheckBoxSelected() {
        return sqlControl.getRememberMeBoolean();
    }

    @FXML private void onLoginClick() {
        hideLoginErrorLabels();
        if (isLoginInputOK()) {
            CurrentUser.setUsername(UsernameLogin_Group.getInput());
            changeSceneToApp();
            storeUsernameIfCheckBoxIsSelected();
            clearLoginInput();
        }
    }
    private void hideLoginErrorLabels() {
        UsernameLogin_Group.hideErrorLabel();
        PasswordLogin_Group.hideErrorLabel();
    }
    private boolean isLoginInputOK() {
        boolean username = UsernameLogin_Group.isInputOK(null);
        boolean password = PasswordLogin_Group.isInputOK(UsernameLogin_Group.getInput());

        return username && password;
    }
    private void changeSceneToApp() {
        Scenes.changeScene(Scenes.getFromMap("App"));
    }
    private void clearLoginInput() {
        UsernameLogin_Group.clearInput();
        PasswordLogin_Group.clearInput();
    }
    private void storeUsernameIfCheckBoxIsSelected(){
        sqlControl.setRememberMe(RememberMe_CheckBox.isSelected(), UsernameLogin_Group.getInput());
    }

    @FXML private void onSignUpClick() {
        hideSignUpErrorLabels();
        if (isSignUpInputOK()) {
            showSignUpDialog();
            storeInfoToDBInNewThreadAncClearInput();
        }
    }
    private void hideSignUpErrorLabels(){
        UsernameSingUp_Group.hideErrorLabel();
        PasswordSingUp_Group.hideErrorLabel();
        PasswordConfirmSingUp_Group.hideErrorLabel();
        SecQuestionSingUp_Group.hideErrorLabel();
        SecAnsSingUp_Group.hideErrorLabel();
    }
    private boolean isSignUpInputOK() {
        boolean isUsernameOK = UsernameSingUp_Group.isInputOK(UsernameSingUp_Group.getInput());
        boolean isPasswordOK = PasswordSingUp_Group.isInputOK(null);
        boolean isPasswordConfirmOK = PasswordConfirmSingUp_Group.isInputOK(PasswordSingUp_Group.getInput());
        boolean isSecQuestionOK = SecQuestionSingUp_Group.isInputOK(null);
        boolean isSecAnsOK = SecAnsSingUp_Group.isInputOK(null);

        return isUsernameOK && isPasswordOK && isPasswordConfirmOK && isSecQuestionOK && isSecAnsOK;
    }
    private void showSignUpDialog() {
        Dialog dialog = new Dialog(mainLogin_SignUp_Stack,
                "You have successfully been registered to Hayabusa Project!",
                "OK",
                "Core/Scenes/Login_SingUp/StyleSheet.css",
                "dialogButton",
                main_Anchor, SignUp_Anchor);
        dialog.getButton().setOnAction(event -> {
            dialog.close();
            onLogin_SingUpButtonClick();
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
    private boolean isButtonTextEqualToSingUp() {
        return Login_SingUp_Button.getText().equals("Sing up");
    }
    private void animationSignUpIn() {
        Animation.scaleAnimationToX(DURATION, SignUp_Anchor, 1).play();
        Animation.fadeInAnimation(DURATION, SignUp_Anchor).play();

        AnimationControls.translateAndFadeOutInDuration(activeAnchorPane, -345, DURATION);

        AnimationControls.translateAndFadeOutInDuration(Login_Anchor, -345, DURATION);
    }
    private void animationSignUpOut() {
        Animation.scaleAnimationToX(DURATION, SignUp_Anchor, 0.1).play();
        Animation.fadeOutAnimation(DURATION, SignUp_Anchor).play();

        Animation.translateAnimationToX(DURATION, activeAnchorPane, 0).play();

        Animation.translateAnimationToX(DURATION, Login_Anchor, 0).play();
        Animation.fadeInAnimation(DURATION, Login_Anchor).play();
        Login_Anchor.setVisible(true);
    }

    @FXML private void onFinishChangePassClick() {
        if (NewPasswordForget_Group.isInputOK(null) && ConfirmPasswordForget_Group.isInputOK(NewPasswordForget_Group.getInput())) {
            showForgetDialog();
            changePasswordInNewThreadAncClearInput();
            activeAnchorPane = Login_Anchor;
        }
    }
    private void showForgetDialog() {
        Dialog dialog = new Dialog(mainLogin_SignUp_Stack,
                "You have successfully changed your password!",
                "OK",
                "Core/Scenes/Login_SingUp/StyleSheet.css",
                "dialogButton",
                main_Anchor, ChangePassword_Anchor);
        dialog.getButton().setOnAction(event -> {
            dialog.close();
            AnimationControls.hideAndShowWithAnimationInDuration(ChangePassword_Anchor, Login_Anchor, DURATION);
        });
    }
    private void changePasswordInNewThreadAncClearInput() {
        new Thread(()-> {
            sqlControl.changePasswordWithUsername(UsernameForgetPass_Group.getInput(), NewPasswordForget_Group.getInput());
            cleanForgetFields();
        }).start();
    }
    private void cleanForgetFields() {
        UsernameForgetPass_Group.clearInput();
        SecAnswerForget_Group.clearInput();
        SecQuestionForget_Group.clearInput();
        NewPasswordForget_Group.clearInput();
        ConfirmPasswordForget_Group.clearInput();
    }
    @FXML private void onNextAnswerQuestionClick() {
        if (SecAnswerForget_Group.isInputOK(SecQuestionForget_Group.getInput())) {
            AnimationControls.hideAndShowWithAnimationInDuration(AnswerQuestion_Anchor, ChangePassword_Anchor, DURATION);
            activeAnchorPane = ChangePassword_Anchor;
        }
    }
    @FXML private void onNextEnterUsernameClick() {
        if (UsernameForgetPass_Group.isInputOK(null)) {
            AnimationControls.hideAndShowWithAnimationInDuration(EnterUsername_Anchor, AnswerQuestion_Anchor, DURATION);
            SecQuestionForget_Group.setInput(sqlControl.getQuestionForUser(UsernameForgetPass_Group.getInput()));
            activeAnchorPane = AnswerQuestion_Anchor;
        }
    }
    @FXML private void onForgotButtonClick(){
        AnimationControls.hideAndShowWithAnimationInDuration(Login_Anchor, EnterUsername_Anchor, DURATION);
        activeAnchorPane = EnterUsername_Anchor;
    }
    @FXML private void onBackChangePassClick(){
        AnimationControls.hideAndShowWithAnimationInDuration(ChangePassword_Anchor, AnswerQuestion_Anchor, DURATION);
        activeAnchorPane = ChangePassword_Anchor;
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
