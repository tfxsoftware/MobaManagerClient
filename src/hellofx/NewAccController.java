package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NewAccController {

    @FXML
    private TextField NewEmailField;

    @FXML
    private PasswordField NewPwFIeld;

    @FXML
    private PasswordField NewRePwField;

    @FXML
    private Label PwLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private Button CreateButton;
    
    @FXML
    void VerifyCreateClear(ActionEvent event) {
        NewEmailField.clear();
        NewPwFIeld.clear();
        NewRePwField.clear();
    }

}

