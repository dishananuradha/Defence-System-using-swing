class Starter{
    public static MainController mainController = MainController.getInstance();
    public static void main(String[] args){
        mainController.setVisible(true);
        addDefences();
    }

    public static void addDefences(){
        Observer observer = mainController.getObserver();
        observer.addDefence(new Helicopter(mainController));
        observer.addDefence(new Tank(mainController));
        observer.addDefence(new Submarine(mainController));
    }
}