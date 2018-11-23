package Core.Components.GroupOfComponents.GroupOfAppComponents;

import Core.Components.Component;
import Core.Components.GroupOfComponents.ErrorLabel;
import Core.Components.GroupOfComponents.GroupOfComponents;
import com.jfoenix.controls.JFXCheckBox;

public class GroupOfTextArea extends GroupOfComponents {

    public GroupOfTextArea(Component component, ErrorLabel errorLabel, JFXCheckBox checkBox) {
        super(component, errorLabel, checkBox);
        initCheckBox();
    }

    private void initCheckBox(){
        checkBox.setOnAction((event)->{
            if (checkBox.isSelected()){
                checkBox.setText("ON");
                component.setDisable(false);
            }else{
                checkBox.setText("OFF");
                component.setDisable(true);
            }
        });
    }

}
