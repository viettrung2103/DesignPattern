package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtApp extends Application {
    private static final int SIZE = 40;
    private final PixelGrid model = new PixelGrid();
    private final Rectangle[][] rectangles = new Rectangle[8][8];

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();

        // Initialize grid UI
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rect = new Rectangle(SIZE, SIZE);
                rect.setStroke(Color.GRAY);
                rectangles[y][x] = rect;
                gridPane.add(rect, x, y);
            }
        }

        updateUI();
        Label instruction = new Label("A : Go Left, D: Go Right, W: Go Up, S: Go Down, Enter: toggle box");

        Scene scene = new Scene(new VBox(gridPane, createCodeButton(), instruction), SIZE * 9, SIZE * 10);
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();

        scene.setOnKeyPressed(e -> {
            Command command = switch (e.getCode()) {
                case W -> new MoveCursorUpCommand(model);
                case S -> new MoveCursorDownCommand(model);
                case A -> new MoveCursorLeftCommand(model);
                case D -> new MoveCursorRightCommand(model);
                case ENTER -> new TogglePixelCommand(model);
                default -> null;
            };
            if (command != null) {
                command.execute();
                updateUI();
            }
        });
    }

    private void updateUI() {
        int[][] grid = model.getGrid();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                rectangles[y][x].setFill(grid[y][x] == 1 ? Color.BLACK : Color.WHITE);
            }
        }
        rectangles[model.getCursorY()][model.getCursorX()].setFill(Color.RED); // Highlight cursor
    }

    private Button createCodeButton() {
        Button button = new Button("Create Code");
        button.setOnAction(e -> {
            int[][] grid = model.getGrid();
            System.out.println("int[][] pixelArt = {");
            for (int y = 0; y < 8; y++) {
                System.out.print("    {");
                for (int x = 0; x < 8; x++) {
                    System.out.print(grid[y][x]);
                    if (x < 7) System.out.print(", ");
                }
                System.out.println("}" + (y < 7 ? "," : ""));
            }
            System.out.println("};");
        });
        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}