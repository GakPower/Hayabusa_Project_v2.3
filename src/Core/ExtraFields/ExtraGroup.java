package Core.ExtraFields;

import Core.Components.*;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.io.Serializable;

public class ExtraGroup implements Serializable {

    private ComponentType componentType;
    private String groupName;
    private MinusButton minusButton = new MinusButton();
    private Node node;
    private Component component;
    private HBox hBox;

    public ExtraGroup(String groupName, ComponentType componentType){
        this.groupName = groupName;
        this.componentType = componentType;
        createComponent(componentType);
        createLayout();
        ExtraGroups.addToLayout(this);
    }

     private void createComponent(ComponentType componentType){
        switch (componentType) {
            case INFO:
                JFXTextField textField = new JFXTextField();
                textField.getStyleClass().add("addComboBoxes");
                textField.setPrefSize(240, 30);
                textField.setEditable(true);
                textField.setPromptText(groupName);
                textField.setLabelFloat(true);
                node = textField;

                component = new TextField(textField);
                break;
            case COMBOBOX:
                JFXComboBox<String> comboBox = new JFXComboBox<>();
                comboBox.getStyleClass().add("addComboBoxes");
                comboBox.setPrefSize(240, 30);
                comboBox.setEditable(true);
                comboBox.setPromptText(groupName);
                comboBox.setLabelFloat(true);
                node = comboBox;

                component = new ComboBox(comboBox);
                break;
        }
    }

    private void createLayout(){
        hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPrefSize(356,32);
        hBox.getChildren().add(this.node);
        if (this.getComponentType() == ComponentType.COMBOBOX) {
            hBox.getChildren().add(this.minusButton);
        }
    }

    public Component getComponent() {
        return component;
    }
    public ComponentType getComponentType() {
        return componentType;
    }
    public String getGroupName(){
        return groupName;
    }
    HBox getHBox(){
        return hBox;
    }
}
