package application;

 import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tetris extends Application {
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static final int XMAX = SIZE * 12;
    public static final int YMAX = SIZE * 12;
    public static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
    private static Pane group = new Pane();
    private static Block object;
    private static Scene scene = new Scene(group, XMAX + 150, YMAX);
    public static int score = 0;
    private static boolean game = true;
    private static Block nextObj = Controller.makeRect();
    private static int linesNo = 0;




    @Override
    public void start(Stage stage) throws Exception {

    }
}
