import java.util.ArrayList;

class Observer implements SuperObserver{
    private ArrayList<SuperDefence> defenceList = new ArrayList<SuperDefence>();

    public void addDefence(SuperDefence defence){
        defenceList.add(defence);
    }
}
