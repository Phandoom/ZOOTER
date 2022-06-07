package models;

import models.Enums.classes;
import models.Enums.races;

public class register {


    // fields
    private int _playerId;
    private String  _name;
    private String _password;
    private races _races;
    private classes _classes;


// getter/setter

    public int getPlayerId() {return _playerId;}
    public void setPlayerId(int playerId) {this._playerId = playerId;}

    public String getName() {
        return this._name;
    }
    public void setName(String name) {
        this._name = name;
    }

    public String getPassword() {
        return this._password;
    }
    public void setPassword(String passwort) {
        this._password = passwort;
    }

    public races getRaces() {
        return this._races;
    }
    public void setRaces(races races) {
        this._races = races;
    }

    public classes getClasses() {
        return this._classes;
    }
    public void setClasses(classes classes) {
        this._classes = classes;
    }


//ctors
    public register(){
        this(0,"", "", races.human, classes.knight);
    }
    public register(int playerId, String name, String passwort, races races, classes classes){
        this.setPlayerId(playerId);
        this.setName(name);
        this.setPassword(passwort);
        this.setRaces(races);
        this.setClasses(classes);

    }


//other methods


    @Override
    public String toString() {
        return _name + "\n" + _password + "\n" + _races + "\n" +
               _classes;
    }
}
