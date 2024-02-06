package com.example.codecityjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

//import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class handling JavaFX application for visualizing class information as buildings.
 */

public class Window extends Application {

    // X and Y components for canvas size

    int x = 750;
    int y = 750;

    // fixed building width

    final int BUILDING_WIDTH = 100;
    ArrayList<DummyBuilding> buildings = new ArrayList<>();
    ArrayList<BuildingFrontEnd> buildingFrontEnds = new ArrayList<>();
    ArrayList<String> superClasses = new ArrayList<>();
    Canvas canvas;
    Pane root;

    /**
     * JavaFX application entry point
     *
     * @param stage The primary stage for this application
     * @throws IOException If an I/O error occurs
     */

    @Override
    public void start(Stage stage) throws IOException {

        canvas = new Canvas(x, y);

        root = new Pane(canvas);


        // Below is some dummy code to demonstrate the functionality.
        // Replace this with the integration with the actual parsed class (building) data.

        buildings.add(new DummyBuilding("superclass1", 5, "class1"));
        buildings.add(new DummyBuilding("superclass1", 3, "class2"));
        buildings.add(new DummyBuilding("superclass1", 6, "class3"));
        buildings.add(new DummyBuilding("superclass2", 1, "class4"));
        buildings.add(new DummyBuilding("superclass2", 10, "class5"));

        //
        // Begin drawing code
        //

        drawBuildings(canvas.getGraphicsContext2D());

        //Creating a scene object
        Scene scene = new Scene(root, 1200, 1000);

        //Setting title to the Stage
        stage.setTitle("Draw Buildings - Miro");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    /**
     * Draw buildings and display textual information on the canvas based on class information
     *
     * @param gc The GraphicsContext used for drawing on the canvas
     */

    public void drawBuildings(GraphicsContext gc) {

        //Count number of super classes

        for (DummyBuilding b : buildings) {
            if (!superClasses.contains(b.getSuperClass())) {
                superClasses.add(b.getSuperClass());
            }
        }
        int n = superClasses.size();
        int[] numClassesOnRow = new int[n];

        // Fill out data for buildings

        for (DummyBuilding b : buildings) {
            int nm = b.getNumMethods();
            Color c;
            int superClassIndex = superClasses.indexOf(b.getSuperClass());
            int rowPos = (superClassIndex + 1) * x / n;
            int colPos = 100 + numClassesOnRow[superClassIndex] * BUILDING_WIDTH;
            String info = b.getName() + "\n" + nm + " methods\n" + b.getSuperClass();
            Text t = new Text(info);
            t.setLayoutX(colPos);
            t.setLayoutY(rowPos+15);
            root.getChildren().add(t);

            // COLOR SCHEME
            // If less than 5 methods, color it green. If between 5 and 10, color it yellow, if between 10 and 15,
            // orange, if greater, red.

            if (nm < 5) {
                c = Color.GREEN;
            } else if (nm < 10) {
                c = Color.YELLOW;
            } else if (nm < 15) {
                c = Color.ORANGE;
            } else {
                c = Color.RED;
            }
            int height = nm*20;
            buildingFrontEnds.add(new BuildingFrontEnd(colPos, rowPos, c, height));
            numClassesOnRow[superClassIndex]++;
        }

        // Draw them!

        for (BuildingFrontEnd b : buildingFrontEnds) {
            int adjustedY = b.getY() - b.getHeight();
            int adjustedHeight = b.getHeight();
            gc.setFill(b.getColor());
            gc.fillRect(b.getX(), adjustedY, BUILDING_WIDTH, adjustedHeight);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
