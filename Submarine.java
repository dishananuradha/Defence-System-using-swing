import javax.swing.*;
import java.awt.*;

class Submarine extends JFrame implements SuperDefence{
    private JTextField txtSoldierCount;
    private JTextField txtAmmoCount;
    private JButton shoot;
    private JButton sonarOperation;
    private JButton tomahawkMissile;
    private JButton tridentMissile;
    private JCheckBox position;
    private JLabel areaClear;
    private JTextArea txtNotification;
    private JTextField txtSend;
    private JButton send;

    public Submarine(MainController mainController){
        setTitle("Submarine");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = mainController.getX() + mainController.getWidth();
        int y = mainController.getY() + mainController.getHeight();
        setLocation(x-180 , y+20);
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
        shoot.setEnabled(false);
        shoot.setBounds(65, 110, 150, 30);
        mainPanel.add(shoot);

        sonarOperation = new JButton("Sonar Operation");
        sonarOperation.setEnabled(false);
        sonarOperation.setBounds(65, 150, 150, 30);
        mainPanel.add(sonarOperation);

        tomahawkMissile = new JButton("Tomahawk Missile");
        tomahawkMissile.setEnabled(false);
        tomahawkMissile.setBounds(65, 190, 150, 30);
        mainPanel.add(tomahawkMissile);

        tridentMissile = new JButton("trident Missile");
        tridentMissile.setEnabled(false);
        tridentMissile.setBounds(65, 230, 150, 30);
        mainPanel.add(tridentMissile);

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
        send.addActionListener(e -> {
            mainController.sendToMain(txtSend.getText(), "Helicopter");
            txtSend.setText("");
        });
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

    @Override
    public void position(int positionValue) {
        if(position.isSelected()){
            shoot.setEnabled(positionValue > 20? true : false);
            sonarOperation.setEnabled(positionValue > 40? true : false);
            tomahawkMissile.setEnabled(positionValue > 60? true : false);
            tridentMissile.setEnabled(positionValue > 80? true : false);
        }
    }

    @Override
    public void sendPrivate(String message, String defence) {
        if (defence.equals("Submarine")) {
            txtNotification.append("Message to Submarine: " + message + "\n");
        }
    }

    @Override
    public void sendAll(String message) {
        txtNotification.append("Message to all: " + message + "\n");
    }
}
