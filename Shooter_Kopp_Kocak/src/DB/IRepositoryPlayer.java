package DB;
import models.*;
import java.sql.SQLException;
import java.util.List;

public interface IRepositoryPlayer {

    void open() throws SQLException;

    void close() throws SQLException;

    // Alle Spieler Ausgeben
    List<register> getAllPlayers() throws SQLException;

    // Neuen Spieler hinzufügen
    boolean createNewPlayer(register p) throws SQLException;
    // Einloggen
    boolean login(register p) throws SQLException;

}