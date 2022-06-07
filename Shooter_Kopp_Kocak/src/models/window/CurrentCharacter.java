package models.window;

public class CurrentCharacter {
    private int _id;
    private boolean _selected;

    public void setId(int id){
        this._id = id;
        System.out.println(_id);
    }
    public int getId(){
        return this._id;
    }

}
