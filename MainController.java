import javax.swing.JFrame;

class MainController extends JFrame{
    private static MainController mainController;
    private Observer observer;

    private MainController(){
        observer = new Observer();
    }

    public static MainController getInstance(){
        if(mainController == null){
            mainController = new MainController();
        }
        return mainController;
    }

    public Observer getObserver(){
        return observer;
    }
}
