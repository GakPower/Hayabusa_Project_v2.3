package Core;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;

public class TableData
{
    private SimpleStringProperty id;
    private SimpleStringProperty departureDate;
    private SimpleStringProperty departureTime;
    private SimpleStringProperty exportationProduct;
    private SimpleStringProperty departureEnterprise;
    private SimpleStringProperty departureShip;
    private SimpleStringProperty departurePort;
    private SimpleStringProperty unloadingLocations;
    private SimpleStringProperty arrivalDate;
    private SimpleStringProperty arrivalTime;
    private SimpleStringProperty importationProduct;
    private SimpleStringProperty arrivalEnterprise;
    private SimpleStringProperty arrivalShip;
    private SimpleStringProperty arrivalPort;
    private SimpleStringProperty loadingLocations;
    private SimpleStringProperty truck;
    private SimpleStringProperty company;
    private SimpleStringProperty cmr;
    private SimpleStringProperty income;
    private SimpleStringProperty kilometers;
    private SimpleStringProperty comments;

    private ArrayList<String> extraData = new ArrayList<>();

    private ArrayList<String> data;

    public TableData(ArrayList<String> tableData){
        id = new SimpleStringProperty(String.valueOf(TableDatas.getTableInfo().size()+1));
        departureDate = new SimpleStringProperty(tableData.get(0));
        departureTime = new SimpleStringProperty(tableData.get(1));
        exportationProduct = new SimpleStringProperty(tableData.get(2));
        departureEnterprise = new SimpleStringProperty(tableData.get(3));
        departureShip = new SimpleStringProperty(tableData.get(4));
        departurePort = new SimpleStringProperty(tableData.get(5));
        unloadingLocations = new SimpleStringProperty(tableData.get(6));
        arrivalDate = new SimpleStringProperty(tableData.get(7));
        arrivalTime = new SimpleStringProperty(tableData.get(8));
        importationProduct = new SimpleStringProperty(tableData.get(9));
        arrivalEnterprise = new SimpleStringProperty(tableData.get(10));
        arrivalShip = new SimpleStringProperty(tableData.get(11));
        arrivalPort = new SimpleStringProperty(tableData.get(12));
        loadingLocations = new SimpleStringProperty(tableData.get(13));
        truck = new SimpleStringProperty(tableData.get(14));
        company = new SimpleStringProperty(tableData.get(15));
        cmr = new SimpleStringProperty(tableData.get(16));
        income = new SimpleStringProperty(tableData.get(17));
        kilometers = new SimpleStringProperty(tableData.get(18));
        comments = new SimpleStringProperty(tableData.get(19));

        for (int i = 20; i < tableData.size(); i++) {
            extraData.add(tableData.get(i));
        }

        data = tableData;
    }
    public TableData(int ID, ArrayList<String> tableData){
        id = new SimpleStringProperty(String.valueOf(ID));
        departureDate = new SimpleStringProperty(tableData.get(0));
        departureTime = new SimpleStringProperty(tableData.get(1));
        exportationProduct = new SimpleStringProperty(tableData.get(2));
        departureEnterprise = new SimpleStringProperty(tableData.get(3));
        departureShip = new SimpleStringProperty(tableData.get(4));
        departurePort = new SimpleStringProperty(tableData.get(5));
        unloadingLocations = new SimpleStringProperty(tableData.get(6));
        arrivalDate = new SimpleStringProperty(tableData.get(7));
        arrivalTime = new SimpleStringProperty(tableData.get(8));
        importationProduct = new SimpleStringProperty(tableData.get(9));
        arrivalEnterprise = new SimpleStringProperty(tableData.get(10));
        arrivalShip = new SimpleStringProperty(tableData.get(11));
        arrivalPort = new SimpleStringProperty(tableData.get(12));
        loadingLocations = new SimpleStringProperty(tableData.get(13));
        truck = new SimpleStringProperty(tableData.get(14));
        company = new SimpleStringProperty(tableData.get(15));
        cmr = new SimpleStringProperty(tableData.get(16));
        income = new SimpleStringProperty(tableData.get(17));
        kilometers = new SimpleStringProperty(tableData.get(18));
        comments = new SimpleStringProperty(tableData.get(19));

        for (int i = 20; i < tableData.size(); i++) {
            extraData.add(tableData.get(i));
        }

        data = tableData;
    }

    public ObservableValue<String> getExtraValue(int index){
        if (extraData.size() <= index){
            return new SimpleStringProperty("");
        }
        return new SimpleStringProperty(extraData.get(index));
    }

    public ArrayList<String> getExtraData(){
        return extraData;
    }

    public String[] getArrayOfData(){
        return data.toArray(new String[0]);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getDepartureDate() {
        return departureDate.get();
    }

    public SimpleStringProperty departureDateProperty() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate.set(departureDate);
    }

    public String getDepartureTime() {
        return departureTime.get();
    }

    public SimpleStringProperty departureTimeProperty() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime.set(departureTime);
    }

    public String getExportationProduct() {
        return exportationProduct.get();
    }

    public SimpleStringProperty exportationProductProperty() {
        return exportationProduct;
    }

    public void setExportationProduct(String exportationProduct) {
        this.exportationProduct.set(exportationProduct);
    }

    public String getDepartureEnterprise() {
        return departureEnterprise.get();
    }

    public SimpleStringProperty departureEnterpriseProperty() {
        return departureEnterprise;
    }

    public void setDepartureEnterprise(String departureEnterprise) {
        this.departureEnterprise.set(departureEnterprise);
    }

    public String getDepartureShip() {
        return departureShip.get();
    }

    public SimpleStringProperty departureShipProperty() {
        return departureShip;
    }

    public void setDepartureShip(String departureShip) {
        this.departureShip.set(departureShip);
    }

    public String getDeparturePort() {
        return departurePort.get();
    }

    public SimpleStringProperty departurePortProperty() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort.set(departurePort);
    }

    public String getUnloadingLocations() {
        return unloadingLocations.get();
    }

    public SimpleStringProperty unloadingLocationsProperty() {
        return unloadingLocations;
    }

    public void setUnloadingLocations(String unloadingLocations) {
        this.unloadingLocations.set(unloadingLocations);
    }

    public String getArrivalDate() {
        return arrivalDate.get();
    }

    public SimpleStringProperty arrivalDateProperty() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate.set(arrivalDate);
    }

    public String getArrivalTime() {
        return arrivalTime.get();
    }

    public SimpleStringProperty arrivalTimeProperty() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime.set(arrivalTime);
    }

    public String getImportationProduct() {
        return importationProduct.get();
    }

    public SimpleStringProperty importationProductProperty() {
        return importationProduct;
    }

    public void setImportationProduct(String importationProduct) {
        this.importationProduct.set(importationProduct);
    }

    public String getArrivalEnterprise() {
        return arrivalEnterprise.get();
    }

    public SimpleStringProperty arrivalEnterpriseProperty() {
        return arrivalEnterprise;
    }

    public void setArrivalEnterprise(String arrivalEnterprise) {
        this.arrivalEnterprise.set(arrivalEnterprise);
    }

    public String getArrivalShip() {
        return arrivalShip.get();
    }

    public SimpleStringProperty arrivalShipProperty() {
        return arrivalShip;
    }

    public void setArrivalShip(String arrivalShip) {
        this.arrivalShip.set(arrivalShip);
    }

    public String getArrivalPort() {
        return arrivalPort.get();
    }

    public SimpleStringProperty arrivalPortProperty() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort.set(arrivalPort);
    }

    public String getLoadingLocations() {
        return loadingLocations.get();
    }

    public SimpleStringProperty loadingLocationsProperty() {
        return loadingLocations;
    }

    public void setLoadingLocations(String loadingLocations) {
        this.loadingLocations.set(loadingLocations);
    }

    public String getTruck() {
        return truck.get();
    }

    public SimpleStringProperty truckProperty() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck.set(truck);
    }

    public String getCompany() {
        return company.get();
    }

    public SimpleStringProperty companyProperty() {
        return company;
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public String getCmr() {
        return cmr.get();
    }

    public SimpleStringProperty cmrProperty() {
        return cmr;
    }

    public void setCmr(String cmr) {
        this.cmr.set(cmr);
    }

    public String getIncome() {
        return income.get();
    }

    public SimpleStringProperty incomeProperty() {
        return income;
    }

    public void setIncome(String income) {
        this.income.set(income);
    }

    public String getKilometers() {
        return kilometers.get();
    }

    public SimpleStringProperty kilometersProperty() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers.set(kilometers);
    }

    public String getComments() {
        return comments.get();
    }

    public SimpleStringProperty commentsProperty() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments.set(comments);
    }
}