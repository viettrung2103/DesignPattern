package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class GameView extends Application {
    private static final int TILE_SIZE = 80;
    private GameController controller;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the controller with a default map
//        controller = new GameController(MapType.CITY, 0, 0);
//        controller = new GameController(MapType.WILDERNESS, 0, 0);
        controller = new GameController(MapType.CITY);


        // Set up the canvas
        int canvasWidth = controller.getMapWidth() * TILE_SIZE;
        int canvasHeight = controller.getMapHeight() * TILE_SIZE;
        canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Draw the map
        drawMap(gc);

        // Set up the JavaFX scene
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, canvasWidth, canvasHeight);

        primaryStage.setTitle("Game Map Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawMap(GraphicsContext gc) {
        for (int row = 0; row < controller.getMapHeight(); row++) {
            for (int col = 0; col < controller.getMapWidth(); col++) {
                Image tileImage = controller.getTileImage(row, col);
                gc.drawImage(tileImage, col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
