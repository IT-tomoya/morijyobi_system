import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Java_xml_gui_test extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// タイトル設定
		stage.setTitle("Test");

		// シーン設定
		Parent fxmlSchene = FXMLLoader.load(getClass().getResource("test.fxml"));
		Scene scene = new Scene(fxmlSchene, 300, 100);
		stage.setScene(scene);

		// 表示
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}