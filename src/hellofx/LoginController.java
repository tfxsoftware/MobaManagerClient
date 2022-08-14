package hellofx;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button LoginButton;

    @FXML
    private Button NewAccButton;

    @FXML
    private TextField emailfield;

    @FXML
    private ImageView imglogin;

    @FXML
    private PasswordField pwdfield;

    @FXML
    void VerifyAccount(ActionEvent event) throws UnknownHostException, IOException {
        String client = emailfield.getText();
        String pw = pwdfield.getText();
        String info = client + "/" + pw;
        try{
            Socket socket = new Socket("localhost", 4999);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            output.writeObject(info);
            socket.close();
        }
            catch(Exception e) {
                Stage offlineerror = new Stage();
                offlineerror.setTitle("servidor offline");
                offlineerror.show();
                return;
            }
    
        
    }
    @FXML
    void OpenNewAccWindow(ActionEvent event) throws IOException {
        Stage NAStage = new Stage();
        FXMLLoader fxmlLoaderNA = new FXMLLoader(getClass().getResource("NewAccountLayout.fxml"));
        Parent root = fxmlLoaderNA.load();
        Scene NAscreen = new Scene(root);
        NAStage.setScene(NAscreen);
        NAStage.setResizable(false);
        NAStage.initModality(Modality.APPLICATION_MODAL);
        NAStage.show();
    }
}
