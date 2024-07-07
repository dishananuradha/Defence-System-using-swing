import javax.swing.JFrame;

class MainController extends JFrame{
    private static MainController mainController;
    private Observer observer;

    private MainController(){
        observer = new Observer();

        setTitle("Main Controller");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0,0);

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
