package com.internshala.temp_conver_tool;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args) {
		System.out.println("main method is executed");
		launch(args);
	}
	@Override
	public void init() throws Exception {
		System.out.println("init  method is executed"); // Initialize point of  application
		super.init();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println("start  method is executed");    // Starts an application and mandatory to override

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}

	private MenuBar createMenu() {

		// File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> newMenuItemInformation()) ;

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		// Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void newMenuItemInformation() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Temperature Convertor Tool");
		alert.setHeaderText("You clicked New MenuItem ");
		alert.setContentText("I will add some new functionally early.!!THANKING YOU!!.");
		alert.show();
	}

	public static void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Temperature Convertor Tool");
		alertDialog.setHeaderText("Developer:- RAMRATAN SHARMA");
		alertDialog.setContentText("I am just a beginner so this tool only convert to Celsius to Fahrenheit" +
				" and vice versa.I will improve this early and add more functionality. ");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
			System.out.println("Yes Button Clicked !");
		} else {
			System.out.println("No Button Clicked !");
		}
	}
	@Override
	public void stop() throws Exception {

		System.out.println("stop  method is executed"); //  for shutdown application but it is optional
		super.stop();
	}

}
