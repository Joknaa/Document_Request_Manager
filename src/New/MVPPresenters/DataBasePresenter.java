package New.MVPPresenters;

import New.MVPModels.DataBaseModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static New.MVPPresenters.RequestPresenter.*;

public class DataBasePresenter {
    private static final String url = DataBaseModel.GetUrl();
    private static final String login = DataBaseModel.GetLogin();
    private static final String password = DataBaseModel.GetPassword();
    private static Connection Session = null;

    //<editor-fold desc="Loading the 'Request's list !!">
    public static void SetupDataBaseConnection() throws SQLException, ClassNotFoundException {
        Connect();
        int[] IDs = SQL_GetRequestsIDList();
        SetRequestsList(IDs);
        Disconnect();
    }
    private static void Connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Session = DriverManager.getConnection(url,login,password);
    }
    private static int[] SQL_GetRequestsIDList() throws SQLException {
        String query = "SELECT id FROM request WHERE accepted = false;";
        ResultSet dataSet = Session.createStatement().executeQuery(query);

        String querySize = "SELECT COUNT(id) AS total FROM request WHERE accepted = false;";
        ResultSet dataSetSize = Session.createStatement().executeQuery(querySize);
        return ConvertMediaListToStringArray(dataSet, dataSetSize);
    }
    private static int[] ConvertMediaListToStringArray(ResultSet dataSet, ResultSet dataSetSize) throws SQLException {
        dataSetSize.next();
        int[] IDs = new int[dataSetSize.getInt("total")];

        for (int i = 0; i < IDs.length && dataSet.next(); i++) {
            IDs[i] = Integer.parseInt((dataSet.getString(1)));
        }

        return IDs;
    }
    private static void Disconnect() throws SQLException {
        if (Session != null){
            Session.close();
            Session = null;
        }
    }
    //</editor-fold">
    //<editor-fold desc="SignIn / SignUp">
    public static void SignUp(String login, String password) throws SQLException, ClassNotFoundException, UserAlreadyExistException {
            Connect();
            SQL_Check_LoginAvailable(login);
            SQL_SignUp(login, password);
            SignIn(login);
            Disconnect();
    }
    private static void SQL_Check_LoginAvailable(String login) throws SQLException, UserAlreadyExistException {
        String query = "SELECT * FROM admin WHERE username='" + login + "';";
        ResultSet rt = Session.createStatement().executeQuery(query);
        if (rt.next()) throw new UserAlreadyExistException("login already exist");
    }
    private static void SQL_SignUp(String login, String password) throws SQLException {
        String query = "INSERT INTO admin(username, password) VALUES ('" + login + "', '" + password + "');";
        Session.createStatement().executeUpdate(query);
    }

    public static void SignIn(String login, String password) throws SQLException, ClassNotFoundException, UserNotFoundException {
            Connect();
            SQL_Check_UserExist(login, password);
            SignIn(login);
            Disconnect();
    }
    private static void SQL_Check_UserExist(String login, String password) throws SQLException, UserNotFoundException {
        String query = "SELECT * FROM admin WHERE Username='" + login + "' AND Password='" + password + "';";
        ResultSet rt = Session.createStatement().executeQuery(query);
        if (!rt.isBeforeFirst()){
            throw new UserNotFoundException("Login or Password Incorrect");
        }
    }
    private static void SignIn(String login) { UserPresenter.Login(login); }
    //</editor-fold>
    //<editor-fold desc="Getting 'Request' data">
    public static String[] GetRequestDescription(String requestName) throws SQLException, ClassNotFoundException {
        Connect();
        String[] ItemDescription = SQL_GetRequestDescription(GetRequestID(requestName));
        System.out.println("hehoo: " + Arrays.toString(ItemDescription));
        Disconnect();
        return ItemDescription;
    }
    private static String[] SQL_GetRequestDescription(int requestID) throws SQLException {
        //todo; query returns null; check the connection between the tables (joint) ..
        String query = "SELECT stu.CIN, stu.N_apogee, stu.email, req.Doc_type" +
                " FROM request req JOIN student stu ON req.N_apogee = stu.N_apogee" +
                " WHERE req.id='" + requestID + "';";
        ResultSet dataSet = Session.createStatement().executeQuery(query);
        return ConvertDataSetToStringArray(dataSet);
    }
    private static String[] ConvertDataSetToStringArray(ResultSet dataSet) throws SQLException {
        String[] requestInfo = new String[]{"fill", "fill", "fill", "fill"};

        for (int i = 0; i < requestInfo.length && dataSet.next(); i++) {
            requestInfo[i] = dataSet.getString(i);
            System.out.println("-----> " + requestInfo[i]);
        }

        return requestInfo;
    }
    //</editor-fold>
    //<editor-fold desc="Accept/Decline 'Request's">
    public static void ManageRequest(String requestName, boolean accepted) throws SQLException, ClassNotFoundException {
        Connect();
        SQL_ManageRequest(GetRequestID(requestName), accepted);
        Disconnect();
    }
    private static void SQL_ManageRequest(int id, boolean accepted) throws SQLException {
        String query = "UPDATE request SET accepted = "+ accepted +" WHERE id = " + id + ";";
        Session.createStatement().executeUpdate(query);
    }
    //</editor-fold>

    public static class UserNotFoundException extends Exception { UserNotFoundException(String s){ super(s);}}
    public static class UserAlreadyExistException extends Exception { UserAlreadyExistException(String s){ super(s);}}
}
