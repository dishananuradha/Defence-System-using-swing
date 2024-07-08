import java.util.ArrayList;

class Observer implements SuperObserver{
    private ArrayList<SuperDefence> defenceList = new ArrayList<SuperDefence>();

    public void addDefence(SuperDefence defence){
        defenceList.add(defence);
    }

    @Override
    public void areaClear(Boolean isAreaClear){
        for(SuperDefence defence : defenceList){
            defence.areaClear(isAreaClear);
        }
    }

    @Override
    public void position(int positionValue){
        for(SuperDefence defence : defenceList){
            defence.position(positionValue);
        }
    }
}
