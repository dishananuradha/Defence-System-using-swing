import java.util.ArrayList;

class Observer implements SuperObserver{
    private ArrayList<SuperDefence> defenceList = new ArrayList<SuperDefence>();

    public void addDefence(SuperDefence defence){
        defenceList.add(defence);
    }

    @Override
    public void areaClear(Boolean isAreaClear){
        for(SuperDefence d : defenceList){
            d.areaClear(isAreaClear);
        }
    }

    @Override
    public void position(int positionValue){
        for(SuperDefence d : defenceList){
            d.position(positionValue);
        }
    }

    @Override
    public void sendPrivate(String message, String defence){
        for(SuperDefence d : defenceList){
            d.sendPrivate(message, defence);
        }
    }

    @Override
    public void sendAll(String message){
        for(SuperDefence d : defenceList){
            d.sendAll(message);
        }
    }
}
