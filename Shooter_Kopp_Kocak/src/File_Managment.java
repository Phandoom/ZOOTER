import java.io.*;
import models.Characters;
import models.Gender;
import models.Login;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class File_Managment {


    static Scanner reader = new Scanner(System.in);


    public static void main(String[] args) {


        String pathAndFilenameC1 = "C:\\Users\\Daniel kopp\\Desktop\\FileManager_Zooter\\Character_Data\\character_1.txt";
        String pathAndFilenameC2 = "C:\\Users\\Daniel kopp\\Desktop\\FileManager_Zooter\\Character_Data\\character_2.txt";
        String pathAndFilenameC3 = "C:\\Users\\Daniel kopp\\Desktop\\FileManager_Zooter\\Character_Data\\character_3.txt";
        String pathAndFilenameL = "C:\\Users\\Daniel kopp\\Desktop\\FileManager_Zooter\\Login_data\\login_1.txt";

        Characters c1 = new Characters(1, " Arnald ", 12, Gender.male, " Magician");
        Characters c2 = new Characters(2, " Amalia ", 1, Gender.female, " Archer");
        Characters c3 = new Characters(3, " Ezecial ", 4.5, Gender.male, " Assasin");

        Login l = new Login("bkdk", "12345");

        System.out.println("\nWrite character data to file: ");
        writeCharactertoFile(c1, pathAndFilenameC1);
        writeCharactertoFile(c2, pathAndFilenameC2);
        writeCharactertoFile(c3, pathAndFilenameC3);

        System.out.println("\nWrite login data to file:  ");
        writeLoginToFile(l, pathAndFilenameL);

        System.out.println("\n\nRead character data from file");
        Characters c_1 = readCharacterFromFile(pathAndFilenameC1);
        if (c_1 != null) {
            System.out.println(c1);
        } else {
            System.out.println("No data available");
        }
        Characters c_2 = readCharacterFromFile(pathAndFilenameC2);
        if (c_2 != null) {
            System.out.println(c2);
        } else {
            System.out.println("No data available");
        }
        Characters c_3 = readCharacterFromFile(pathAndFilenameC3);
        if (c_3 != null) {
            System.out.println(c3);
        } else {
            System.out.println("No data available");
        }

        System.out.println("\n\nRead Login data from file");
        Login l1 = readLoginFromFile(pathAndFilenameL);
        if (l1 != null) {
            System.out.println(l);
        } else {
            System.out.println("No data available");


        }
    }

    private static void writeCharactertoFile(Characters characters, String pathToFile){

        Path p = Path.of(pathToFile);


        if (Files.exists(p)){

            System.out.println("The data already exists");
            return;
        }

        try {

            String s = "";
            s += characters.get_cId() + "\n";
            s += characters.get_cName() + "\n";
            s += characters.get_level() + "\n";
            s += characters.get_gender() + "\n";
            s += characters.get_class() + "\n";

            Files.writeString(p, s);

        }catch (IOException e){
            System.err.println("Couldn't write data " + e);
        }



    }

    private static Characters readCharacterFromFile(String path){


        Path p = Path.of(path);


        if (Files.exists(p)){
            try {

                return convertStringToCharacter(Files.readAllLines(p));
            }catch (IOException e){
                System.err.println("Couldn't read data" + e);
            }

        }else {
            System.out.println("The data already exists");
        }
     return null;
    }

    private static Characters convertStringToCharacter(List<String> lines){

        Characters c = new Characters();

        c.set_cId(Integer.parseInt(lines.get(0)));
        c.set_cName(lines.get(1));
        c.set_level(Double.parseDouble(lines.get(2)));
        c.set_gender(convertStringToGender(lines.get(3)));
        c.set_class(lines.get(4));

        return c;
    }

    private static Gender convertStringToGender(String gender){

        switch (gender.toLowerCase()){
            case "male":
                return Gender.male;
            case "female":
                return Gender.female;
            default:
                return Gender.notSpecified;
        }



    }
    private static void writeLoginToFile(Login login, String pathToFile){

        Path p = Path.of(pathToFile);


        if (Files.exists(p))
    }




}
