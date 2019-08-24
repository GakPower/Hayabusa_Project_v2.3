package Core;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class DataSorter {

    private ObservableList<TableData> data;

    public DataSorter(ObservableList<TableData> data){
        this.data = data;
    }

    public SortedMap<String, ArrayList<TableData>> getYearlySortedData(){
        SortedMap<String, ArrayList<TableData>> yearlySortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String year = data.getDepartureDate().split(" ")[3];
            if (!yearlySortedData.containsKey(year))
            {
                ArrayList<TableData> tableDataOfYear = new ArrayList<>();

                yearlySortedData.put(year, tableDataOfYear);
                tableDataOfYear.add(data);
            }else{
                yearlySortedData.get(year).add(data);
            }
        }
        return yearlySortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getCompanySortedData(){
        SortedMap<String, ArrayList<TableData>> companySortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String company = data.getCompany();
            if (!companySortedData.containsKey(company))
            {
                ArrayList<TableData> tableDataOfCompany = new ArrayList<>();

                companySortedData.put(company, tableDataOfCompany);
                tableDataOfCompany.add(data);
            }else{
                companySortedData.get(company).add(data);
            }
        }
        return companySortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getExpProductSortedData(){
        SortedMap<String, ArrayList<TableData>> expProductSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String expProduct = data.getExportationProduct();
            if (!expProductSortedData.containsKey(expProduct))
            {
                ArrayList<TableData> tableDataOfExpProduct = new ArrayList<>();

                expProductSortedData.put(expProduct, tableDataOfExpProduct);
                tableDataOfExpProduct.add(data);
            }else{
                expProductSortedData.get(expProduct).add(data);
            }
        }
        return expProductSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getDepEnterpriseSortedData(){
        SortedMap<String, ArrayList<TableData>> expProductSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String depEnterprise = data.getDepartureEnterprise();
            if (!expProductSortedData.containsKey(depEnterprise))
            {
                ArrayList<TableData> tableDataOfDepEnterprise = new ArrayList<>();

                expProductSortedData.put(depEnterprise, tableDataOfDepEnterprise);
                tableDataOfDepEnterprise.add(data);
            }else{
                expProductSortedData.get(depEnterprise).add(data);
            }
        }
        return expProductSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getDepShipSortedData(){
        SortedMap<String, ArrayList<TableData>> depShipSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String depShip = data.getDepartureShip();
            if (!depShipSortedData.containsKey(depShip))
            {
                ArrayList<TableData> tableDataOfDepShip = new ArrayList<>();

                depShipSortedData.put(depShip, tableDataOfDepShip);
                tableDataOfDepShip.add(data);
            }else{
                depShipSortedData.get(depShip).add(data);
            }
        }
        return depShipSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getDepPortSortedData(){
        SortedMap<String, ArrayList<TableData>> depPortSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String depPort = data.getDeparturePort();
            if (!depPortSortedData.containsKey(depPort))
            {
                ArrayList<TableData> tableDataOfDepPort = new ArrayList<>();

                depPortSortedData.put(depPort, tableDataOfDepPort);
                tableDataOfDepPort.add(data);
            }else{
                depPortSortedData.get(depPort).add(data);
            }
        }
        return depPortSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getUnloadingLocSortedData(){
        SortedMap<String, ArrayList<TableData>> unloadingLocSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String unloadingLoc = data.getUnloadingLocations();
            if (!unloadingLocSortedData.containsKey(unloadingLoc))
            {
                ArrayList<TableData> tableDataOfUnloadingLoc = new ArrayList<>();

                unloadingLocSortedData.put(unloadingLoc, tableDataOfUnloadingLoc);
                tableDataOfUnloadingLoc.add(data);
            }else{
                unloadingLocSortedData.get(unloadingLoc).add(data);
            }
        }
        return unloadingLocSortedData;
    }
    //////////////////////////////////////////////////////////////////////////////////
    public SortedMap<String, ArrayList<TableData>> getImportProductSortedData(){
        SortedMap<String, ArrayList<TableData>> impProductSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String impProduct = data.getImportationProduct();
            if (!impProductSortedData.containsKey(impProduct))
            {
                ArrayList<TableData> tableDataOfImpProduct = new ArrayList<>();

                impProductSortedData.put(impProduct, tableDataOfImpProduct);
                tableDataOfImpProduct.add(data);
            }else{
                impProductSortedData.get(impProduct).add(data);
            }
        }
        return impProductSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getArrEnterpriseSortedData(){
        SortedMap<String, ArrayList<TableData>> arrProductSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String arrEnterprise = data.getArrivalEnterprise();
            if (!arrProductSortedData.containsKey(arrEnterprise))
            {
                ArrayList<TableData> tableDataOfArrEnterprise = new ArrayList<>();

                arrProductSortedData.put(arrEnterprise, tableDataOfArrEnterprise);
                tableDataOfArrEnterprise.add(data);
            }else{
                arrProductSortedData.get(arrEnterprise).add(data);
            }
        }
        return arrProductSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getArrShipSortedData(){
        SortedMap<String, ArrayList<TableData>> arrShipSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String arrShip = data.getArrivalShip();
            if (!arrShipSortedData.containsKey(arrShip))
            {
                ArrayList<TableData> tableDataOfArrShip = new ArrayList<>();

                arrShipSortedData.put(arrShip, tableDataOfArrShip);
                tableDataOfArrShip.add(data);
            }else{
                arrShipSortedData.get(arrShip).add(data);
            }
        }
        return arrShipSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getArrPortSortedData(){
        SortedMap<String, ArrayList<TableData>> arrPortSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String arrPort = data.getArrivalPort();
            if (!arrPortSortedData.containsKey(arrPort))
            {
                ArrayList<TableData> tableDataOfArrPort = new ArrayList<>();

                arrPortSortedData.put(arrPort, tableDataOfArrPort);
                tableDataOfArrPort.add(data);
            }else{
                arrPortSortedData.get(arrPort).add(data);
            }
        }
        return arrPortSortedData;
    }

    public SortedMap<String, ArrayList<TableData>> getLoadingLocSortedData(){
        SortedMap<String, ArrayList<TableData>> loadingLocSortedData = new TreeMap<>();
        for (TableData data : data)
        {
            String loadingLoc = data.getLoadingLocations();
            if (!loadingLocSortedData.containsKey(loadingLoc))
            {
                ArrayList<TableData> tableDataOfLoadingLoc = new ArrayList<>();

                loadingLocSortedData.put(loadingLoc, tableDataOfLoadingLoc);
                tableDataOfLoadingLoc.add(data);
            }else{
                loadingLocSortedData.get(loadingLoc).add(data);
            }
        }
        return loadingLocSortedData;
    }
}
