package Core.ComboData;

public class ComboData {
    private String groupName;
    private String value;

    public ComboData(String groupName, String value){
        this.groupName = groupName;
        this.value = value;
    }

    public String getGroupName() {
        return groupName;
    }
    public String getValue() {
        return value;
    }
}
