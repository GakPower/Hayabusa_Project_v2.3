package Core;

import java.util.ArrayList;

public class TableData {

    private String depDate;
    private String depTime;
    private String depProduct;
    private String depEnterprise;
    private String depShip;
    private String depPort;
    private String depUnloadingLoc;

    private String arrDate;
    private String arrTime;
    private String arrProduct;
    private String arrEnterprise;
    private String arrShip;
    private String arrPort;
    private String arrUnloadingLoc;

    private String truck;
    private String company;
    private String cmr;
    private String income;
    private String kilometers;
    private String comments = "";

    private ArrayList<String> extraData = new ArrayList<>();

    public TableData(
            ArrayList<String> standardData,
            ArrayList<String> extraData)
    {
        this.depDate = standardData.get(0);
        this.depTime = standardData.get(1);
        this.depProduct = standardData.get(2);
        this.depEnterprise = standardData.get(3);
        this.depShip = standardData.get(4);
        this.depPort = standardData.get(5);
        this.depUnloadingLoc = standardData.get(6);

        this.arrDate = standardData.get(7);
        this.arrTime = standardData.get(8);
        this.arrProduct = standardData.get(9);
        this.arrEnterprise = standardData.get(10);
        this.arrShip = standardData.get(11);
        this.arrPort = standardData.get(12);
        this.arrUnloadingLoc = standardData.get(13);

        this.truck = standardData.get(14);
        this.company = standardData.get(15);
        this.cmr = standardData.get(16);
        this.income = standardData.get(17);
        this.kilometers = standardData.get(18);
        this.comments = standardData.get(19);

        this.extraData = extraData;
    }

    public String getDepDate() {
        return depDate;
    }

    public String getDepTime() {
        return depTime;
    }

    public String getDepProduct() {
        return depProduct;
    }

    public String getDepEnterprise() {
        return depEnterprise;
    }

    public String getDepShip() {
        return depShip;
    }

    public String getDepPort() {
        return depPort;
    }

    public String getDepUnloadingLoc() {
        return depUnloadingLoc;
    }

    public String getArrDate() {
        return arrDate;
    }

    public String getArrTime() {
        return arrTime;
    }

    public String getArrProduct() {
        return arrProduct;
    }

    public String getArrEnterprise() {
        return arrEnterprise;
    }

    public String getArrShip() {
        return arrShip;
    }

    public String getArrPort() {
        return arrPort;
    }

    public String getArrUnloadingLoc() {
        return arrUnloadingLoc;
    }

    public String getTruck() {
        return truck;
    }

    public String getCompany() {
        return company;
    }

    public String getCmr() {
        return cmr;
    }

    public String getIncome() {
        return income;
    }

    public String getKilometers() {
        return kilometers;
    }

    public String getComments() {
        return comments;
    }

    public ArrayList<String> getExtraData() {
        return extraData;
    }
}
