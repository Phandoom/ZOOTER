import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DB.IRepositoryPlayer;
import DB.RepositoryPlayerDB;
import models.*;
import models.Enums.classes;
import models.Enums.races;
import models.window.Game;
import models.window.SelectWindow;
import models.window.playerWindow;


public class mainProgram {
    static Scanner reader = new Scanner(System.in);


    public static void main(String[] args) {
        String loginOrRegister;
        boolean ingame = false;

        register user = new register(1, "Daniel","Daniel123", races.elf, classes.mage);

        IRepositoryPlayer rep;
        try{
            rep = new RepositoryPlayerDB();
            rep.open();

            System.out.println("\nErgebnisse:");
            List<register> allPlayerResults = rep.getAllPlayers();
            if (allPlayerResults == null){
                System.out.println("Noch keine Spielerresultate vorhanden");
            }
            else
            {
                for (register re : allPlayerResults ){
                    System.out.println(re);
                }
            }


        }
            catch (ClassNotFoundException e) {
            System.out.println("MySQL Treiber konnte nicht geladen werden!");
        }
            catch (SQLException e) {
            System.out.println("Datenbankfehler!" + e.getMessage());
        }
        SelectWindow.main();

    }

}
