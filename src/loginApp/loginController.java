package loginApp;

import Home.homeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML
    Label loginStatus;
    public void initialize(URL url, ResourceBundle rb){
      if(this.loginmodel.isDatabaseConnected()){
          this.dbStatus.setText("Connected");
        }
        else{
          this.dbStatus.setText("Not Connected");
        }

    }

    @FXML
    public void login(ActionEvent event){
        try {
            if(this.loginmodel.isLogin(this.username.getText(),this.password.getText())){
                Stage stage = (Stage)this.loginButton.getScene().getWindow();
                stage.close();
                adminLogin();
            }
            else {
                loginStatus.setText("Wrong Credentials");
            }
        }
        catch (Exception localException){

        }
    }
    public void adminLogin(){
        try{
            Stage HomeStage = new Stage();
            FXMLLoader HomeLoader =new FXMLLoader();
            Pane Homeroot = (Pane) HomeLoader.load(getClass().getResource("/Home/Home.fxml").openStream());
            homeController homecontroller = (homeController) HomeLoader.getController();

            Scene scene = new Scene(Homeroot);
            HomeStage.setScene(scene);
            HomeStage.setTitle("Home");
            HomeStage.setResizable(false);
            HomeStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
