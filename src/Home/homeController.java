package Home;


import dbUtils.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class homeController implements Initializable{


    //Student tab
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

//Result tab
    @FXML
    private TextField rusn;
    @FXML
    private ComboBox rSelectSem;
    @FXML
    private TextField rSub1;
    @FXML
    private TextField rSub2;
    @FXML
    private TextField rSub3;
    @FXML
    private TextField rSub4;
    @FXML
    private TextField rSub5;
    @FXML
    private TextField rSub6;
    @FXML
    private TextField rSub7;
    @FXML
    private TextField rSub8;
    @FXML
    private Button rAdd;
    @FXML
    private Button rLoad;
    @FXML
    private Button rClear;
    @FXML
    private ComboBox rSelectSem1;
    @FXML
    private Button rLoad1;
    @FXML
    private TableView<resultData> rTable;
    @FXML
    private TableColumn<resultData,String> rColusn;
    @FXML
    private TableColumn<resultData,String> rColname;
    @FXML
    private TableColumn<resultData,Integer> rColsub1;
    @FXML
    private TableColumn<resultData,Integer> rColsub2;
    @FXML
    private TableColumn<resultData,Integer> rColsub3;
    @FXML
    private TableColumn<resultData,Integer> rColsub4;
    @FXML
    private TableColumn<resultData,Integer> rColsub5;
    @FXML
    private TableColumn<resultData,Integer> rColsub6;
    @FXML
    private TableColumn<resultData,Integer> rColsub7;
    @FXML
    private TableColumn<resultData,Integer> rColsub8;
    @FXML
    private TableColumn<resultData,Integer> rColtotal;



    //Analyze tab
    @FXML
    private ComboBox aSelectSem;
    @FXML
    private Button aHighmarks;
    @FXML
    private Button aPassedstudent;
    @FXML
    private Button aFailedstudent;
    @FXML
    private Button aListallstudent;
    @FXML
    private Button adistiction;
    @FXML
    private Button aFirstclass;
    @FXML
    private Button aSecondclass;
    @FXML
    private TableView<analysisData> aTable;
    @FXML
    private TableColumn<analysisData,String> aColusn;
    @FXML
    private TableColumn<analysisData,String> aColname;
    @FXML
    private TableColumn<analysisData,Integer> aColsub1;
    @FXML
    private TableColumn<analysisData,Integer> aColsub2;
    @FXML
    private TableColumn<analysisData,Integer> aColsub3;
    @FXML
    private TableColumn<analysisData,Integer> aColsub4;
    @FXML
    private TableColumn<analysisData,Integer> aColsub5;
    @FXML
    private TableColumn<analysisData,Integer> aColsub6;
    @FXML
    private TableColumn<analysisData,Integer> aColsub7;
    @FXML
    private TableColumn<analysisData,Integer> aColsub8;
    @FXML
    private TableColumn<analysisData,Integer> aColtotal;


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

    @FXML
    private void rclearFields(ActionEvent actionEvent)
    {
        this.rusn.setText("");
        this.rSub1.setText("");
        this.rSub2.setText("");
        this.rSub3.setText("");
        this.rSub4.setText("");
        this.rSub5.setText("");
        this.rSub6.setText("");
        this.rSub7.setText("");
        this.rSub8.setText("");
    }

}
