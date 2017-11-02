package loginApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    loginModel loginmodel = new loginModel();

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    Label dbStatus;
    public void initialize(URL url, ResourceBundle rb){
      if(this.loginmodel.isDatabaseConnected()){
          this.dbStatus.setText("Connected");
        }
        else{
          this.dbStatus.setText("Not Connected");
        }

    }
}
