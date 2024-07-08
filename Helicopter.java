import javax.swing.*;
import java.awt.*;

class Helicopter extends JFrame implements SuperDefence{
    private JTextField txtSoldierCount;
    private JTextField txtAmmoCount;
    private JButton shoot;
    private JButton missileOperation;
    private JButton laserOperation;
    private JCheckBox position;
    private JLabel areaClear;
    private JTextArea txtNotification;
    private JTextField txtSend;
    private JButton send;

    public Helicopter(JFrame mainController){
        setTitle("Helicopter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = mainController.getX() + mainController.getWidth();
        setLocation(x+20 , 0);
        setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(600, 400));

        // Left side components
        JLabel lblSoldierCount = new JLabel("Soldier Count");
        lblSoldierCount.setBounds(20, 30, 150, 30);
        mainPanel.add(lblSoldierCount);

        txtSoldierCount = new JTextField();
        txtSoldierCount.setBounds(130, 30, 120, 30);
        mainPanel.add(txtSoldierCount);

        JLabel lblAmmoCount = new JLabel("Ammo Count");
        lblAmmoCount.setBounds(20, 70, 120, 30);
        mainPanel.add(lblAmmoCount);

        txtAmmoCount = new JTextField();
        txtAmmoCount.setBounds(130, 70, 120, 30);
        mainPanel.add(txtAmmoCount);

        shoot = new JButton("Shoot");
        shoot.setBounds(65, 130, 150, 30);
        mainPanel.add(shoot);

        missileOperation = new JButton("Missile Operation");
        missileOperation.setBounds(65, 170, 150, 30);
        mainPanel.add(missileOperation);

        laserOperation = new JButton("Laser Operation");
        laserOperation.setBounds(65, 210, 150, 30);
        mainPanel.add(laserOperation);

        position = new JCheckBox("Position");
        position.setBounds(20, 270, 150, 30);
        mainPanel.add(position);

        areaClear = new JLabel("Area Not Cleared");
        areaClear.setBounds(20, 310, 150, 30);
        mainPanel.add(areaClear);

        // Separator
        JSeparator separator3 = new JSeparator(SwingConstants.VERTICAL);
        separator3.setBounds(275, 20, 1, 320);
        mainPanel.add(separator3);

        // Right side components
        JLabel lblNotification = new JLabel("Notifications");
        lblNotification.setBounds(300, 30, 150, 30);
        mainPanel.add(lblNotification);

        txtNotification = new JTextArea();
        txtNotification.setLineWrap(true);
        txtNotification.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtNotification);
        scrollPane.setBounds(300, 60, 265, 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane);

        txtSend = new JTextField();
        txtSend.setBounds(300, 300, 190, 30);
        mainPanel.add(txtSend);

        send = new JButton("Send");
        send.setBounds(500, 300, 65, 30);
        mainPanel.add(send);

        add(mainPanel);
    }

    @Override
    public void areaClear(Boolean isAreaClear) {
        if(isAreaClear){
            areaClear.setText("Area Cleared");
        }else{
            areaClear.setText("Area Not Cleared");
        }
    }
}