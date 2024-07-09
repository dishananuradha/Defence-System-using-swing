interface SuperObserver {
    public void areaClear(Boolean isAreaClear);
    public void position(int positionValue);
    public void sendPrivate(String message, String defence);
    public void sendAll(String message);
    public String getSoldierCount(String defence);
    public String getAmmoCount(String defence);
}
