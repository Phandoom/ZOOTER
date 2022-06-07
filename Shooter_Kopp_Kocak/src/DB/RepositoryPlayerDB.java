package DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.jdbc.CallableStatement;
import models.Enums.classes;
import models.Enums.races;
import models.register;

public class RepositoryPlayerDB implements IRepositoryPlayer {

    private String url = "jdbc:mysql://localhost/project_shooter";
    private String user = "root";
    private String pwd = "dani99dani";
    private Connection _connection;

    // ctor
    public RepositoryPlayerDB() throws ClassNotFoundException {
        Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
        if (c!=null){
            System.out.println("MySQL Treiber wurde geladen");
        }
    }


    @Override
    public void open() throws SQLException {
       this._connection = DriverManager.getConnection(url,user,pwd);

    } //Done
    @Override
    public void close() throws SQLException {
        if((this._connection != null) && (!this._connection.isClosed())){
            this._connection.close();
            System.out.println("Verbindung wurde geschlossen");
        }
    } //Done

    @Override
    public List<register> getAllPlayers() throws SQLException {
        List<register> players = new ArrayList<>();
        PreparedStatement pStmt = this._connection.prepareStatement("select * from Players");

        ResultSet result = pStmt.executeQuery();



        while (result.next()){
            register p = new register();
            p.setPlayerId(result.getInt("player_id"));
            p.setName(result.getString("player_name"));
            p.setPassword(result.getString("player_password"));
            p.setClasses(classes.valueOf(result.getString("player_class")));
            p.setRaces(races.valueOf(result.getString("player_race")));

            players.add(p);
        }
        if (players.size() >= 1){
            return players;
        }
        else {
            return null;
        }
    } //Done


    @Override
    public boolean createNewPlayer(register p) throws SQLException {
       return false;
    }

    @Override
    public boolean login(register p) throws SQLException {
        return false;
    }


}
