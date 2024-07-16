class Starter{
    public static void main(String[] args){
        Observer observer = new Observer();                                     //create observer
        MainController mainController = new MainController(observer);           //create main controller
        mainController.setVisible(true);

        observer.addDefence(new Helicopter(mainController));                    //add defences to observer
        observer.addDefence(new Tank(mainController));
        observer.addDefence(new Submarine(mainController));
    }
}