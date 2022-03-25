package models;

public class Characters {

    private int _cId;
    private String _cName;
    private double _level;
    private Gender _gender;
    private String _class;


    public int get_cId(){
        return this._cId;
    }

    public void set_cId(int _cId){
        if (this._cId >= 0){
            this._cId = _cId;
        }
    }

    public String get_cName() {
        return _cName;
    }

    public void set_cName(String _cName) {
        this._cName = _cName;
    }

    public double get_level() {
        return _level;
    }

    public void set_level(double _level) {
        if (this._level >= 0) {
            this._level = _level;
        }
    }

    public Gender get_gender() {
        return _gender;
    }

    public void set_gender(Gender _gender) {
        this._gender = _gender;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }


    public Characters(){
        this(0, "", 0.0, Gender.notSpecified,  "");
    }
    public Characters(int _cId, String _cName, double _level, Gender _gender, String _class){
        this.set_cId(_cId);
        this.set_cName(_cName);
        this.set_level(_level);
        this.set_gender(_gender);
        this.set_class(_class);
    }

    @Override
    public String toString(){
        return _cId + "" + _cName + "" + _level + "" + _class;
    }
}
