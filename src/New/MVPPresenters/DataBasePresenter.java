package New.MVPPresenters;

import New.MVPModels.DataBaseModel;
import java.sql.*;
import java.util.Arrays;

import static New.MVPPresenters.RequestPresenter.*;

public class DataBasePresenter {
    private static final String url = DataBaseModel.GetUrl();
    private static final String login = DataBaseModel.GetLogin();
    private static final String password = DataBaseModel.GetPassword();
    private static Connection Session = null;

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

    //<editor-fold desc="Adding 'Request'">
    public static void SaveRequest(String cin, String apoge, String email, String docType) throws SQLException, ClassNotFoundException {
        Connect();
        AddRequest(SQL_AddRequestAndGetID(apoge, email, docType));
        if (!SQL_Check_StudentExist(cin, apoge))
            SQL_AddStudent(cin, apoge);
        Disconnect();
    }
    private static int SQL_AddRequestAndGetID(String apoge, String email, String docType) throws SQLException {
        String query = "INSERT INTO request(N_apogee, email, Doc_type, accepted) " +
                "VALUES ('" + apoge + "', '" + email + "', '" + docType + "', 0);";
        PreparedStatement prepStmt = Session.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        prepStmt.execute();
        ResultSet dataSet = prepStmt.getGeneratedKeys();
        if (dataSet.next()) return dataSet.getInt(1);
        throw new SQLException("Request couldn't be submitted, try again.");
    }
    private static boolean SQL_Check_StudentExist(String cin, String apoge) throws SQLException {
        String query = "SELECT * FROM student WHERE CIN='" + cin + "' AND N_apogee='" + apoge + "';";
        ResultSet dataSet = Session.createStatement().executeQuery(query);
        return dataSet.isBeforeFirst();
    }
    private static void SQL_AddStudent(String cin, String apoge) throws SQLException {
        //todo; CIN-Apoge combination need to ba unique. To avoid trouble remove one of them from the form..
        String query = "INSERT INTO student(CIN, N_apogee) VALUES ('" + cin + "', '" + apoge + "');";
        Session.createStatement().executeUpdate(query);
    }
    //</editor-fold>

    //<editor-fold desc="Getting 'Request' data">
    public static String[] GetRequestDescription(String requestName) throws SQLException, ClassNotFoundException {
        Connect();
        String[] ItemDescription = SQL_GetRequestDescription(GetRequestID(requestName));
        Disconnect();
        return ItemDescription;
    }
    private static String[] SQL_GetRequestDescription(int requestID) throws SQLException {
        //todo; query returns null; check the connection between the tables (joint) ..
        String query = "SELECT stu.CIN, stu.N_apogee, req.email, req.Doc_type" +
                " FROM request req JOIN student stu ON req.N_apogee = stu.N_apogee" +
                " WHERE req.id='" + requestID + "';";
        ResultSet dataSet = Session.createStatement().executeQuery(query);
        return ConvertDataSetToStringArray(dataSet);
    }
    private static String[] ConvertDataSetToStringArray(ResultSet dataSet) throws SQLException {
        String[] requestInfo = new String[]{"fill", "fill", "fill", "fill"};
        dataSet.next();

        for (int i = 0; i < requestInfo.length; i++) {
            requestInfo[i] = dataSet.getString(i + 1);
        }

        return requestInfo;
    }
    //</editor-fold>

    //<editor-fold desc="Accept/Decline 'Request's">
    public static void ManageRequest(String requestName, boolean accepted) throws SQLException, ClassNotFoundException {
        Connect();
        int id = GetRequestID(requestName);
        SQL_ManageRequest(id, accepted);
        RemoveRequest(requestName);
        Disconnect();
    }
    private static void SQL_ManageRequest(int id, boolean accepted) throws SQLException {
        String query = "UPDATE request SET accepted = '" + (accepted ? 1 : 0) + "' WHERE id = " + id + ";";
        Session.createStatement().executeUpdate(query);
    }
    //</editor-fold>

    public static class UserNotFoundException extends Exception { UserNotFoundException(String s){ super(s);}}
    public static class UserAlreadyExistException extends Exception { UserAlreadyExistException(String s){ super(s);}}
}
