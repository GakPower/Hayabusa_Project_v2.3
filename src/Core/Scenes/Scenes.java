package Core.Scenes;

import Core.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Scenes {

    private static Map<String, Scene> scenes = new HashMap<>();
    private double xOffset = 0;
    private double yOffset = 0;

    private static Stage stage = Main.stage;
    private Parent root;

    private static Scenes ourInstance = new Scenes();

    public static Scenes getInstance() {
        return ourInstance;
    }

    private Scenes(){}

    public void addScene(String sceneName, String fxmlPath){
        initRoot(fxmlPath);
        Scene scene = createScene();
        addSceneToMap(sceneName, scene);
        customizeScene(scene);
    }

    private void initRoot(String fxmlPath){
        try{
            root = tryInitRoot(fxmlPath);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private Parent tryInitRoot(String fxmlPath) throws IOException {
        return FXMLLoader.load(getClass().getClassLoader().getResource(fxmlPath));
    }

    private Scene createScene(){
        return new Scene(root);
    }

    private void customizeScene(Scene scene){
        setTransparentFillScene(scene);
        makeDraggable();
    }
    private void setTransparentFillScene(Scene scene){
        scene.setFill(Color.TRANSPARENT);
    }
    private void makeDraggable(){

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

    }

    public static void changeScene(Scene newScene){
        stage.setScene(newScene);
    }

    private void addSceneToMap(String sceneName, Scene scene){
        scenes.put(sceneName, scene);
    }
    public static Scene getFromMap(String sceneName){
        return scenes.get(sceneName);
    }
}
