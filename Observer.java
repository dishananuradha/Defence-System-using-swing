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

    @Override
    public String getSoldierCount(String defence){
        if(defence.equals("All")){
            int totalSoldierCount = 0;
            for(SuperDefence d : defenceList){
                totalSoldierCount += Integer.parseInt(d.getSoldierCount() == null? "0" : d.getSoldierCount());
            }
            return String.valueOf(totalSoldierCount);
        }else{
            for(SuperDefence d : defenceList){
                if(defence.equals(d.getClass().getName())){
                    return d.getSoldierCount();
                }
            }
        }
        return null;
    }

    @Override
    public String getAmmoCount(String defence){
        if(defence.equals("All")){
            int totalAmmoCount = 0;
            for(SuperDefence d : defenceList){
                totalAmmoCount += Integer.parseInt(d.getAmmoCount() == null? "0" : d.getAmmoCount());
            }
            return String.valueOf(totalAmmoCount);
        }else{
            for(SuperDefence d : defenceList){
                if(defence.equals(d.getClass().getName())){
                    return d.getAmmoCount();
                }
            }
        }
        return null;
    }

    @Override
    public String getEnergyLevel(String defence){
        if(defence.equals("Submarine") || defence.equals("All")){
            for(SuperDefence d : defenceList){
                if(d.getClass().getName().equals("Submarine")){
                    return d.getEnergyLevel();
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public String getOxygenLevel(String defence){
        if(defence.equals("Submarine") || defence.equals("All")){
            for(SuperDefence d : defenceList){
                if(d.getClass().getName().equals("Submarine")){
                    return d.getOxygenLevel();
                }
            }
            return null;
        }
        return null;
    }
}
