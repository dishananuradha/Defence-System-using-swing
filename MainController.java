import javax.swing.JFrame;

class MainController extends JFrame{
    private static MainController mainController;
    private Defence defence;

    private MainController(){
        defence = new Defence();
    }

    public static MainController getInstance(){
        if(mainController == null){
            mainController = new MainController();
        }
        return mainController;
    }

    public Defence getDefence(){
        return defence;
    }
}
