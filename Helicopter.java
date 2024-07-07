import javax.swing.JFrame;

class Helicopter extends JFrame implements SuperDefence{
    public Helicopter(JFrame mainController){
        setTitle("Helicopter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = mainController.getX() + mainController.getWidth();
        setLocation(x+20 , 0);
        setVisible(true);
    }
}