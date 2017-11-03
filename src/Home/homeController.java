package Home;


import dbUtils.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class homeController implements Initializable{

    @FXML
    private TextField usn;
    @FXML
    private TextField name;
    @FXML
    private TableView<studentData> studentTable;
    @FXML
    private TableColumn<studentData,String> USNcolumn;
    @FXML
    private TableColumn<studentData,String> Namecolumn;


    private dbConnection dc;
    private ObservableList<studentData> data;
    private String sql = "SELECT * FROM studentDet";

    public void initialize(URL url, ResourceBundle rb){
        this.dc = new dbConnection();

    }
    @FXML
    private void loadStudentData(ActionEvent event) throws SQLException{
        try {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                this.data.add(new studentData(rs.getString(1),rs.getString(2)));
            }
        }
        catch (SQLException e){
            System.err.println("error" + e);
        }

        this.USNcolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>("USN"));
        this.Namecolumn.setCellValueFactory(new PropertyValueFactory<studentData,String>( "Name"));





        this.studentTable.setItems(null);
        this.studentTable.setItems(this.data);

    }
    @FXML
    private void addStudent(ActionEvent actionEvent)
    {
        String sqlInsert="INSERT INTO studentDet(USN,Name) VALUES(?,?)";
        try {
            //here the name is same but it doesn't matter because this is a local variable
            Connection conn=dbConnection.getConnection();
            PreparedStatement statement=conn.prepareStatement(sqlInsert);
            statement.setString(1,this.usn.getText());
            statement.setString(2,this.name.getText());
            statement.execute();
            conn.close();




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearFields(ActionEvent actionEvent)
    {
        this.usn.setText("");
        this.name.setText("");
    }

}
