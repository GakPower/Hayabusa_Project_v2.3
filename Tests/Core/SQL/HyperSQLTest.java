package Core.SQL;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class HyperSQLTest {

    private static String filePath = "C:\\Hayabusa Project\\Test\\HayaBusa";

    private static String url = "jdbc:hsqldb:file:"+filePath+"\\1;shutdown=true";

    private File tmp = new File(filePath+"\\1.tmp");
    private File lck = new File(filePath+"\\1.lck");
    private File log = new File(filePath+"\\1.log");
    private File properties = new File(filePath+"\\1.properties");
    private File script = new File(filePath+"\\1.script");

    private HyperSQL sql = new HyperSQL(url);

    private void deleteDBFile() {
        try {
            Files.deleteIfExists(Paths.get(filePath + "\\1.tmp"));
            Files.deleteIfExists(Paths.get(filePath + "\\1.lck"));
            Files.deleteIfExists(Paths.get(filePath + "\\1.log"));
            Files.deleteIfExists(Paths.get(filePath + "\\1.properties"));
            Files.deleteIfExists(Paths.get(filePath + "\\1.script"));
            Files.deleteIfExists(Paths.get(filePath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @BeforeEach
    void doBeforeEach(){
        deleteDBFile();
        sql.connDB();
    }

    @Test
    void ConnDBCreatesAllFiles(){
        boolean result = properties.exists()
                && script.exists()
                && log.exists()
                && tmp.exists()
                && lck.exists();

        sql.shutDB();
        assertTrue(result);
    }

    @Test
    void ShutDBKeepsOnly2Files() {
        sql.shutDB();

        boolean result = properties.exists()
                && script.exists()
                && !log.exists()
                && !tmp.exists()
                && !lck.exists();

        assertTrue(result);
    }
}