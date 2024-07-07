import javax.swing.JFrame;

class Tank extends JFrame implements SuperDefence{
    public Tank(JFrame mainController){
        setTitle("Tank");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int y = mainController.getY() + mainController.getHeight();
        setLocation(0 , y+20);
        setVisible(true);
    }
}
