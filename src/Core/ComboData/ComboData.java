package Core.ComboData;

import java.util.ArrayList;

public class ComboData {
    private String groupName;
    private ArrayList<String> value;

    public ComboData(String groupName, ArrayList<String> value){
        this.groupName = groupName;
        this.value = value;
    }
    public ComboData(String groupName, String value){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(value);

        this.groupName = groupName;
        this.value = arrayList;
    }
    public ComboData(String groupName){
        this.groupName = groupName;
        this.value = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }
    public ArrayList<String> getValues() {
        return value;
    }
}
