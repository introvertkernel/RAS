package Home;


import dbUtils.dbConnection;
//import Home.resultData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;
//import Home.resultData;
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
    private ComboBox<option> rSelectSem;
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
    private ComboBox<option> rSelectSem1;
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
    private ComboBox<option> aSelectSem;
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
    private ObservableList<resultData> list;
    private String sql = "SELECT * FROM studentDet";
    @Override
    public void initialize(URL url, ResourceBundle rb){
        this.dc = new dbConnection();
        this.rSelectSem.setItems(FXCollections.observableArrayList(option.values()));
        this.rSelectSem1.setItems(FXCollections.observableArrayList(option.values()));
        this.aSelectSem.setItems(FXCollections.observableArrayList(option.values()));
        //  rTable.setItems(list);
    }



    //Load student data in student tab
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


    //Add student in student tab
    @FXML
    private void addStudent(ActionEvent actionEvent) {

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



    //Clear feilds in Student tab
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

    //Add marks to sem in Result tab
    @FXML
    private void addSemMarks(ActionEvent actionEvent)
    {
        String sqlInsert;
        try {
            switch (((option) this.rSelectSem.getValue()).toString()) {
                case "SEM1":
                    sqlInsert="INSERT INTO SEM1(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
                case "SEM2":
                    sqlInsert="INSERT INTO SEM2(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
                case "SEM3":
                    sqlInsert="INSERT INTO SEM3(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
                case "SEM4":
                    sqlInsert="INSERT INTO SEM4(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
                case "SEM5":
                    sqlInsert="INSERT INTO SEM5(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
                case "SEM6":
                    sqlInsert="INSERT INTO SEM6(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
                case "SEM7":
                    sqlInsert="INSERT INTO SEM7(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
                case "SEM8":
                    sqlInsert="INSERT INTO SEM8(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
                    semMarksAdd(sqlInsert);
                    break;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    private void semMarksAdd(String sqlinsert){
        //String sqlInsert="INSERT INTO SEM1(USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            //here the name is same but it doesn't matter because this is a local variable
            Connection conn=dbConnection.getConnection();
            PreparedStatement statement=conn.prepareStatement(sqlinsert);
            statement.setString(1,this.rusn.getText());
            statement.setString(2,this.rSub1.getText());
            statement.setString(3,this.rSub2.getText());
            statement.setString(4,this.rSub3.getText());
            statement.setString(5,this.rSub4.getText());
            statement.setString(6,this.rSub5.getText());
            statement.setString(7,this.rSub6.getText());
            statement.setString(8,this.rSub7.getText());
            statement.setString(9,this.rSub8.getText());

            statement.execute();
            conn.close();




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
