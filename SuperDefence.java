interface SuperDefence {
    public void areaClear(Boolean isAreaClear);
    public void position(int positionValue);
    public void sendPrivate(String message, String defence);
    public void sendAll(String message);
    public String getSoldierCount();
    public String getAmmoCount();

    default public String getEnergyLevel(){
        return null;
    };
    
    default public String getOxygenLevel(){
        return null;
    };
}
