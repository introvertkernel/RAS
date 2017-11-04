package loginApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtils.dbConnection;

public class loginModel {
    Connection connection;

    public loginModel() {
        try{
            this.connection=dbConnection.getConnection();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        if(this.connection==null){
            System.exit(1);
        }
    }

    public boolean isDatabaseConnected(){
        return this.connection !=null;
    }
    public boolean isLogin(String user,String pass)  throws Exception {
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where user = ? and pass = ? ";

        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            rs = pr.executeQuery();
            boolean bol1;

            if (rs.next()){
                return true;
            }
            return false;
        }
        catch (SQLException ex){
            return false;
        }
        finally {
            pr.close();
            rs.close();
        }
    }
       /* if((user == "admin") && (pass == "admin"))
        {
            return true;
        }
        else return false;
    }*/
}
