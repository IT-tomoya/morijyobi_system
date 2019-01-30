package javafx_test;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.log4j.chainsaw.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Java_xml_gui_test extends Application {

	//stageを変数として持つことで画面繊維できる？
	private static Stage stage;
	private static String defpass;
	@Override
	public void start(Stage stage) throws Exception {

		// タイトル設定
		Java_xml_gui_test.stage = stage;
		stage.setTitle("Test");

		// シーン設定
		FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));

        loader.setController(new Javafx_controller_test());

        Parent root = loader.load();
		Scene scene = new Scene(root, 600, 500);
		Java_xml_gui_test.stage.setScene(scene);

		// 表示
		Java_xml_gui_test.stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void changeView(String fxml) {
        try {
        	// シーン設定
    		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
    		System.out.println(getClass().getResource(fxml));
            loader.setController(new Javafx_controller_test());
            Parent root = loader.load();
    		Scene scene = new Scene(root, 600, 400);
    		stage.setScene(scene);
    		stage.show();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}