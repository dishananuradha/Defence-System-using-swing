import javax.swing.*;
import java.awt.*;

class MainController extends JFrame{
    private static MainController mainController;
    private Observer observer;

    private JCheckBox areaClear;
    private JSlider position;
    private JComboBox<String> selectDefence;
    private JButton collectInfo;
    private JTextField txtSoldierCount;
    private JTextField txtAmmoCount;
    private JTextArea txtNotification;
    private JTextField txtSend;
    private JButton send;

    private MainController(){
        observer = new Observer();

        setTitle("Main Controller");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(800, 400));

        // Left side components
        String[] item = {"----Select Defence----", "Helicopter", "Tank", "Submarine"};
        selectDefence = new JComboBox<String>(item);
        selectDefence.setBounds(20, 30, 150, 30);
        mainPanel.add(selectDefence);

        collectInfo = new JButton("Collect Info");
        collectInfo.setBounds(200, 30, 150, 30);
        mainPanel.add(collectInfo);

        JLabel lblSoldierCount = new JLabel("Soldier Count");
        lblSoldierCount.setBounds(20, 100, 150, 30);
        mainPanel.add(lblSoldierCount);

        txtSoldierCount = new JTextField();
        txtSoldierCount.setBounds(200, 100, 150, 30);
        mainPanel.add(txtSoldierCount);

        JLabel lblAmmoCount = new JLabel("Ammo Count");
        lblAmmoCount.setBounds(20, 140, 150, 30);
        mainPanel.add(lblAmmoCount);

        txtAmmoCount = new JTextField();
        txtAmmoCount.setBounds(200, 140, 150, 30);
        mainPanel.add(txtAmmoCount);

        JLabel lblPosition = new JLabel("Position");
        lblPosition.setBounds(20, 200, 150, 30);
        mainPanel.add(lblPosition);

        position = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        position.setBounds(20, 230, 330, 60);
        position.setMajorTickSpacing(20);
        position.setMinorTickSpacing(5);
        position.setPaintTicks(true);
        position.setPaintLabels(true);
        mainPanel.add(position);

        areaClear = new JCheckBox("Area Clear");
        areaClear.setBounds(20, 310, 100, 30);
        mainPanel.add(areaClear);

        // Separator
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setBounds(400, 0, 1, 400);
        mainPanel.add(separator);

        // Right side components
        JLabel lblNotification = new JLabel("Notification");
        lblNotification.setBounds(420, 30, 150, 30);
        mainPanel.add(lblNotification);

        txtNotification = new JTextArea();
        txtNotification.setBounds(420, 60, 350, 200);
        mainPanel.add(txtNotification);

        txtSend = new JTextField();
        txtSend.setBounds(420, 300, 250, 30);
        mainPanel.add(txtSend);

        send = new JButton("Send");
        send.setBounds(680, 300, 90, 30);
        mainPanel.add(send);

        add(mainPanel);
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
