import javax.swing.JFrame;

class Submarine extends JFrame implements SuperDefence{
    public Submarine(JFrame mainController){
        setTitle("Submarine");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = mainController.getX() + mainController.getWidth();
        int y = mainController.getY() + mainController.getHeight();
        setLocation(x-180 , y+20);
        setVisible(true);
    }
}
