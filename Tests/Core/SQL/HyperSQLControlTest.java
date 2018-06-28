package Core.SQL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class HyperSQLControlTest {

    private static String filePath = "C:\\Hayabusa Project\\Test\\HayaBusa";
    private static HyperSQL sql = new HyperSQL("jdbc:hsqldb:file:"+filePath+"\\1;shutdown=true");
    private static HyperSQLControl sqlControl = new HyperSQLControl(sql);

    private void deleteDBFile() {
        try {
            Files.deleteIfExists(Paths.get(filePath + "\\1.properties"));
            Files.deleteIfExists(Paths.get(filePath + "\\1.script"));
            Files.deleteIfExists(Paths.get(filePath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @BeforeEach
    void setUp() {
        deleteDBFile();
    }

    @Test
    void passIfSQLHasNoneUsers() {
        sqlControl.createTable("Users","ID int NOT NULL PRIMARY KEY, Username varchar(20) NOT NULL, Password varchar(20) NOT NULL, SafeQuestion int NOT NULL, SafeAnswer varchar(50) NOT NULL");

        boolean result = sqlControl.hasMoreThen1User();
        assertFalse(result);
    }
    @Test
    void passIfSQLHas1Users(){
        sqlControl.createTable("Users","ID int NOT NULL PRIMARY KEY, Username varchar(20) NOT NULL, Password varchar(20) NOT NULL, SafeQuestion int NOT NULL, SafeAnswer varchar(50) NOT NULL");
        sqlControl.addInfoToTable("Users","1, 'gakpower', 'password', 1, 'fine'");

        boolean result = sqlControl.hasMoreThen1User();
        assertTrue(result);
    }
    @Test
    void passIfSQLHasMoreThan1Users(){
        sqlControl.createTable("Users","ID int NOT NULL PRIMARY KEY, Username varchar(20) NOT NULL, Password varchar(20) NOT NULL, SafeQuestion int NOT NULL, SafeAnswer varchar(50) NOT NULL");
        sqlControl.addInfoToTable("Users","1, 'gakpower', 'password', 1, 'fine'");
        sqlControl.addInfoToTable("Users","2, 'gakpower', 'password', 1, 'fine'");
        sqlControl.addInfoToTable("Users","3, 'gakpower', 'password', 1, 'fine'");

        boolean result = sqlControl.hasMoreThen1User();
        assertTrue(result);
    }

    @Test
    void passIfMaxIDIs0(){
        sqlControl.createTable("Users","ID int NOT NULL PRIMARY KEY, Username varchar(20) NOT NULL, Password varchar(20) NOT NULL, SafeQuestion int NOT NULL, SafeAnswer varchar(50) NOT NULL");

        int actual= sqlControl.getMaxIDFromDBTable("Users");
        assertEquals(0, actual);
    }
    @Test
    void passIfMaxIDIs3(){
        sqlControl.createTable("Users","ID int NOT NULL PRIMARY KEY, Username varchar(20) NOT NULL, Password varchar(20) NOT NULL, SafeQuestion int NOT NULL, SafeAnswer varchar(50) NOT NULL");
        sqlControl.addInfoToTable("Users","1, 'gakpower', 'password', 1, 'fine'");
        sqlControl.addInfoToTable("Users","2, 'gakpower', 'password', 1, 'fine'");
        sqlControl.addInfoToTable("Users","3, 'gakpower', 'password', 1, 'fine'");

        int actual= sqlControl.getMaxIDFromDBTable("Users");
        assertEquals(3, actual);
    }
}