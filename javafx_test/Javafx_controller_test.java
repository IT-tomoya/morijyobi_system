package javafx_test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Javafx_controller_test {

//	@FXML
//	private TextField txtName;
//
//	@FXML
//	private Label lblName;

//	@FXML
//	protected void writeText(ActionEvent e) {
//		this.lblName.setText(this.txtName.getText());
//	}

	@FXML
    private void nextButtonAction(ActionEvent event) {
		new Java_xml_gui_test().changeView("add_student_info.fxml");

    }
}