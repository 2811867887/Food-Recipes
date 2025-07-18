package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import controller.MainController;


public class MainView extends Application {
    private Stage primaryStage;
    private BorderPane root;
    private MainController controller;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.controller = new MainController(primaryStage);
        this.root = new BorderPane();

        showMainPage();

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Digital Cookbook");
        primaryStage.show();
    }

    public void showMainPage() {
        Button createButton = new Button("Create Recipe");
        Button viewButton = new Button("View Recipes");
        Button historyButton = new Button("History");
        
        HBox topBar = new HBox(10, createButton, viewButton, historyButton);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: #ececec;");
        root.setTop(topBar);
        
        Label titleText = new Label("Welcome to the Digital Cookbook");
        titleText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #333;");
        VBox titleBox = new VBox(titleText);
        titleBox.setAlignment(Pos.CENTER);
        
        TextField searchField = new TextField();
        searchField.setPromptText("Enter recipe name...");
        Button searchButton = new Button("Search");

        HBox searchBox = new HBox(10, searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER);

        VBox centerBox = new VBox(15,titleText, searchBox);
        centerBox.setAlignment(Pos.CENTER);

        root.setCenter(centerBox);

        createButton.setOnAction(e -> controller.onCreateRecipeClicked());
        viewButton.setOnAction(e -> controller.onViewRecipesClicked());
        historyButton.setOnAction(e -> controller.onHistoryClicked());
        searchButton.setOnAction(e -> controller.onSearchClicked(searchField.getText().trim()));
    }
}
