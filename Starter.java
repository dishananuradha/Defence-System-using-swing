class Starter{
    public static void main(String[] args){
        Observer observer = new Observer();
        MainController mainController = new MainController(observer);
        mainController.setVisible(true);

        observer.addDefence(new Helicopter(mainController));
        observer.addDefence(new Tank(mainController));
        observer.addDefence(new Submarine(mainController));
    }
}