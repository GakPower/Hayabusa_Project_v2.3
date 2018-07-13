package Core.SQL;

//
// Author: GakPower
// 
// Date: 13-Jun-2018 (4:44 PM)
//

import java.sql.*;

public class HyperSQL {

    private Connection connection;
    private ResultSet resultSet;

    private String URL = "jdbc:hsqldb:file:C:\\Hayabusa Project\\HayaBusa\\1;shutdown=true";
    private static final String USERNAME = "963258741";
    private static final String PASSWORD = "147852369";

    public HyperSQL(){
        initialize();
    }
    public HyperSQL(String url){
        this.URL = url;
        initialize();
    }

    private void initialize(){
        try{
            tryInitialize();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    private void tryInitialize() throws ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
    }

    public void connDB(){

        try {
            tryConnDB();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private void tryConnDB()
            throws SQLException{

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void shutDB(){
        try {
            tryShutDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void tryShutDB() throws SQLException{
        closeResultSetIfNotNull();
        closeConnIfNotNull();
    }
    private void closeResultSetIfNotNull() throws SQLException{
        if (resultSetNotNull()){
            resultSet.close();
        }
    }
    private boolean resultSetNotNull(){
        return resultSet != null;
    }
    private void closeConnIfNotNull() throws SQLException{
        if (connNotNull()){
            connection.close();
        }
    }
    private boolean connNotNull(){
        return connection != null;
    }

    public void execCommand(String command){
        try {
            tryExecCommand(command);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private void tryExecCommand(String command) throws SQLException{
        resultSet = createResultSetForExecutionWithCommand(command);
    }
    private ResultSet createResultSetForExecutionWithCommand(String command)
            throws SQLException{
        return initStatement().executeQuery(command);
    }
    private Statement initStatement() throws SQLException{
        return connection.createStatement();
    }

    public void execUpdateCommand(String command){
        try {
            tryExecUpdateCommand(command);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private void tryExecUpdateCommand(String command)
            throws SQLException{

        initStatement().executeUpdate(command);

        //PreparedStatement preparedStatement = connection.prepareStatement(command);
        //preparedStatement.executeUpdate();
    }

    public ResultSet getResultSet(){
        return resultSet;
    }
}
