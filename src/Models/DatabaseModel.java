package GLProject.src.Models;

public class DatabaseModel {
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;

    public void setdbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getdbUrl() {
        return this.dbUrl;
    }

    public void setdbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getdbUsername() {
        return this.dbUsername;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getdbPassword() {
        return this.dbPassword;
    }

}
