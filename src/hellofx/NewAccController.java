package hellofx;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        
        String client = NewEmailField.getText();
        String pw = NewPwFIeld.getText();
        String repw = NewRePwField.getText();
        String id = "2";
        String info = client + "/" + pw + "/" + id;
        
        if (pw.equals(repw)){
            try{
                Socket socket = new Socket("localhost", 4999);
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.flush();
                output.writeObject(info);
                Thread.sleep(500);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                Boolean sucesso = (Boolean) input.readObject();
                if (sucesso){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Congratulations!");
                    alert.setHeaderText("Your account has been created!");
                    alert.setContentText("Welcome to MobaManager!");
                    alert.showAndWait();
                } else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Im sorry!");
                    alert.setHeaderText("This email is already registered!");
                    alert.setContentText("Please try another email!");
                    alert.showAndWait();
                }
                socket.close();
            }
            catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Connection Issues");
                alert.setHeaderText("The server is offline!");
                alert.setContentText("Please try again later!");
                alert.showAndWait();
                return;
            }
    
        }   else {
                Stage offlineerror = new Stage();
                offlineerror.setTitle("Passwords dont match!");
                offlineerror.show();
                return;
            }
            NewEmailField.clear();
            NewPwFIeld.clear();
            NewRePwField.clear();

    }
}



