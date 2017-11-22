package Home;


import dbUtils.dbConnection;
//import Home.rControl;
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
import java.util.List;
import java.util.ResourceBundle;


public class homeController /*extends resultController*/ implements Initializable{


    //Student tab
    @FXML
    private TextField usn;
    @FXML
    private TextField name;
    @FXML
    protected TableView<studentData> studentTable;
    @FXML
    protected TableColumn<studentData,String> USNcolumn;
    @FXML
    protected TableColumn<studentData,String> Namecolumn;

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


    protected dbConnection dc;
    protected ObservableList<studentData> data;
    //private ObservableList<resultData> list;
    private ObservableList<resultData> list = FXCollections.observableArrayList();
    private ObservableList<analysisData> alist = FXCollections.observableArrayList();
    protected String sql = "SELECT * FROM studentDet";
    @Override
    public void initialize(URL url, ResourceBundle rb){
        this.dc = new dbConnection();
        this.rSelectSem.setItems(FXCollections.observableArrayList(option.values()));
        this.rSelectSem1.setItems(FXCollections.observableArrayList(option.values()));
        this.aSelectSem.setItems(FXCollections.observableArrayList(option.values()));
        //  rTable.setItems(list);


        
    }



    //Load student data in student tab
    //This is working
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

    //This is working
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


    //This is working
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
        list.clear();
    }


    
    //This is working
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
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void rDelete(ActionEvent actionEvent)
    {
        String sqlDelete;
        try {
            switch (((option) this.rSelectSem.getValue()).toString()) {
                case "SEM1":
                    sqlDelete="DELETE FROM SEM1 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
                case "SEM2":
                    sqlDelete="DELETE FROM SEM2 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
                case "SEM3":
                    sqlDelete="DELETE FROM SEM3 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
                case "SEM4":
                    sqlDelete="DELETE FROM SEM4 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
                case "SEM5":
                    sqlDelete="DELETE FROM SEM5 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
                case "SEM6":
                    sqlDelete="DELETE FROM SEM6 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
                case "SEM7":
                    sqlDelete="DELETE FROM SEM7 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
                case "SEM8":
                    sqlDelete="DELETE FROM SEM8 WHERE USN=?";
                    rDeleteE(sqlDelete);
                    break;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }


    public void rDeleteE(String sqlDelete){
        try {
            Connection conn=dbConnection.getConnection();
            PreparedStatement statement=conn.prepareStatement(sqlDelete);
            statement.setString(1,this.rusn.getText());

            statement.execute();
            conn.close();

            this.rusn.setText("");
        }
        catch (Exception ex){
            System.out.println("error"+ex);
        }
    }

    //#########################################################Stable upto here
    //From here it is giving error
    //TO LOAD STUDENT MARKS DATA IN RESULT TABLE

    @FXML
    private void loadResultData(ActionEvent actionEvent){
        String sqlLoad;
        try {
            switch (((option) this.rSelectSem1.getValue()).toString()) {

                case "SEM1":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
                case "SEM2":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM2 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
                case "SEM3":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM3 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
                case "SEM4":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM4 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
                case "SEM5":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM5 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
                case "SEM6":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM6 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
                case "SEM7":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM7 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
                case "SEM8":
                    sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM8 WHERE  USN IS NOT NULL AND USN IS NOT ''";
                    loadRdata(sqlLoad);
                    break;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    

   /*@FXML
    public void loadResultData(ActionEvent actionEvent) {
        String sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1";
        loadRdata(sqlLoad); //Error here
    }*/

/*private void loadResultData(ActionEvent actionEvent) {
    String sqlLoad = "SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1";
    rc.loadRdata(sqlLoad);
}*/
    //private ObservableList<resultData> list = FXCollections.observableArrayList();
    private void loadRdata(String sqlLoad) {
        try {
            Connection conn = dbConnection.getConnection();
            this.list = FXCollections.observableArrayList();
            //System.out.println("Hello"); //working
            //list.clear();
            ///this.rTable.setItems(null);
            ResultSet rs = conn.createStatement().executeQuery(sqlLoad);

            while (rs.next()) {
                //System.out.println(rs.getString(1));  //Working
                this.list.add(new resultData(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            //list.clear();
            // this.rColusn.setCellValueFactory("Helloworld"); //working
            this.rColusn.setCellValueFactory(new PropertyValueFactory<resultData, String>("rColUsn"));
            this.rColsub1.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub1"));
            this.rColsub2.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub2"));
            this.rColsub3.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub3"));
            this.rColsub4.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub4"));
            this.rColsub5.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub5"));
            this.rColsub6.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub6"));
            this.rColsub7.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub7"));
            this.rColsub8.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColSub8"));
            this.rColtotal.setCellValueFactory(new PropertyValueFactory<resultData, Integer>("rColTotal"));
            System.out.println("after block1");

            System.out.println("after block2");
            //rTable.setItems(list);// CAUSING NULL POINTER EXCEPTION
            System.out.println("after block3");//NOT PRINTING

            //this.studentTable.setItems(null);
            this.rTable.setItems(this.list);
        }
        catch (Exception e) {//System.out.println(" "+e);
            System.err.println("error" + e);
        }
    }


    @FXML
    private void setSQL(ActionEvent actionEvent){
        String sqlLoad;
        try {
            switch (((option) this.rSelectSem1.getValue()).toString()) {
                case "SEM1":
                case "SEM2":
                case "SEM3":
                case "SEM4":
                case "SEM5":
                case "SEM6":
                case "SEM7":
                case "SEM8":


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }
    }


    private void loadAdata(String asqlLoad) {
        try {
            Connection conn = dbConnection.getConnection();
            this.alist = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(asqlLoad);

            while (rs.next()) {
                //System.out.println(rs.getString(1));  //Working
                this.alist.add(new analysisData(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));

            }
            //list.clear();
            // this.rColusn.setCellValueFactory("Helloworld"); //working
            this.aColusn.setCellValueFactory(new PropertyValueFactory<analysisData, String>("aColUsn"));
            this.aColsub1.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub1"));
            this.aColsub2.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub2"));
            this.aColsub3.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub3"));
            this.aColsub4.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub4"));
            this.aColsub5.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub5"));
            this.aColsub6.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub6"));
            this.aColsub7.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub7"));
            this.aColsub8.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColSub8"));
            this.aColtotal.setCellValueFactory(new PropertyValueFactory<analysisData, Integer>("aColTotal"));
            System.out.println("after block1");

            System.out.println("after block2");
            //rTable.setItems(list);// CAUSING NULL POINTER EXCEPTION
            System.out.println("after block3");//NOT PRINTING

            //this.studentTable.setItems(null);
            this.aTable.setItems(this.alist);
        }
        catch (Exception e) {//System.out.println(" "+e);
            System.err.println("error" + e);
        }
    }
    @FXML
    private void ahMarks(ActionEvent actionEvent){
        String asqlLoad;
        try {
            switch (((option) this.aSelectSem.getValue()).toString()) {
                case "SEM1":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;
                case "SEM2":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM2 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;
                case "SEM3":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM3 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;
                case "SEM4":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM4 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;
                case "SEM5":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM5 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;
                case "SEM6":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM6 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;
                case "SEM7":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM7 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;
                case "SEM8":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM8 ASC WHERE  USN IS NOT NULL AND USN IS NOT '' ORDER BY TOTAL";
                    loadAdata(asqlLoad);
                    break;


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }

    }

    @FXML
    private void apStudent(ActionEvent actionEvent){
        String asqlLoad;
        try {
            switch (((option) this.aSelectSem.getValue()).toString()) {
                case "SEM1":
                    asqlLoad="SELECT * FROM SEM1 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM2":
                    asqlLoad="SELECT * FROM SEM2 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM3":
                    asqlLoad="SELECT * FROM SEM3 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM4":
                    asqlLoad="SELECT * FROM SEM4 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM5":
                    asqlLoad="SELECT * FROM SEM5 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM6":
                    asqlLoad="SELECT * FROM SEM6 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM7":
                    asqlLoad="SELECT * FROM SEM7 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM8":
                    asqlLoad="SELECT * FROM SEM8 WHERE SUB1E >= 40 AND SUB2E >= 40 AND SUB3E  >= 40 AND SUB4E  >= 40 AND SUB5E  >= 40 AND SUB6E  >= 40 AND SUB7E   >= 40 AND SUB8E >= 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }

    }

    @FXML
    private void afStudent(ActionEvent actionEvent){
        String asqlLoad;
        try {
            switch (((option) this.aSelectSem.getValue()).toString()) {
                case "SEM1":
                    asqlLoad="SELECT * FROM SEM1 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM2":
                    asqlLoad="SELECT * FROM SEM2 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM3":
                    asqlLoad="SELECT * FROM SEM3 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM4":
                    asqlLoad="SELECT * FROM SEM4 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM5":
                    asqlLoad="SELECT * FROM SEM5 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM6":
                    asqlLoad="SELECT * FROM SEM6 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM7":
                    asqlLoad="SELECT * FROM SEM7 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM8":
                    asqlLoad="SELECT * FROM SEM8 WHERE SUB1E < 40 OR SUB2E < 40 OR SUB3E  < 40 OR SUB4E  < 40 OR SUB5E  < 40 OR SUB6E  < 40 OR SUB7E < 40 OR SUB8E< 40 AND  USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }

    }

    @FXML
    private void alistAll(ActionEvent actionEvent){
        String asqlLoad;
        try {
            switch (((option) this.aSelectSem.getValue()).toString()) {
                case "SEM1":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM2":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM2 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM3":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM3 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM4":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM4 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM5":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM5 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM6":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM6 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM7":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM7 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM8":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM8 WHERE USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }

    }

    @FXML
    private void adistnct(ActionEvent actionEvent){
        String asqlLoad;
        try {
            switch (((option) this.aSelectSem.getValue()).toString()) {
                case "SEM1":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM2":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM2 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM3":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM3 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM4":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM4 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM5":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM5 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM6":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM6 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM7":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM7 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM8":
                    asqlLoad="SELECT USN,SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM8 WHERE TOTAL != null AND TOTAL>679 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }

    }


    @FXML
    private void afClass(ActionEvent actionEvent){
        String asqlLoad;
        try {
            switch (((option) this.aSelectSem.getValue()).toString()) {
                case "SEM1":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM2":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM2 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM3":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM3 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM4":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM4 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM5":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM5 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM6":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM6 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM7":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM7 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM8":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM8 WHERE TOTAL != null AND TOTAL>519 AND TOTAL < 680 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }

    }


    @FXML
    private void asClass(ActionEvent actionEvent){
        String asqlLoad;
        try {
            switch (((option) this.aSelectSem.getValue()).toString()) {
                case "SEM1":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM1 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM2":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM2 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM3":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM3 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM4":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM4 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM5":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM5 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM6":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM6 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM7":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM7 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;
                case "SEM8":
                    asqlLoad="SELECT SUB1E,SUB2E,SUB3E,SUB4E,SUB5E,SUB6E,SUB7E,SUB8E,TOTAL FROM SEM8 WHERE TOTAL != null AND TOTAL>319 AND TOTAL < 520 AND USN IS NOT NULL AND USN IS NOT ''";
                    loadAdata(asqlLoad);
                    break;


            }
        }
        catch (Exception e){
            System.err.println("error"+e);
        }

    }

}




