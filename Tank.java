import javax.swing.*;
import java.awt.*;

class Tank extends JFrame implements SuperDefence{
    private JTextField txtSoldierCount;
    private JTextField txtAmmoCount;
    private JButton shoot;
    private JButton missileOperation;
    private JButton radarOperation;
    private JButton rotateShooting;
    private JCheckBox position;
    private JLabel areaClear;
    private JTextArea txtNotification;
    private JTextField txtSend;
    private JButton send;

    public Tank(MainController mainController){
        setTitle("Tank");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int y = mainController.getY() + mainController.getHeight();
        setLocation(0 , y+20);
        setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(600, 400));

        //left side components
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

        position = new JCheckBox("Position");
        position.setBounds(20, 110, 150, 30);
        mainPanel.add(position);

        shoot = new JButton("Shoot");
        shoot.setEnabled(false);
        shoot.setBounds(65, 150, 150, 30);
        mainPanel.add(shoot);

        missileOperation = new JButton("Missile Operation");
        missileOperation.setEnabled(false);
        missileOperation.setBounds(65, 190, 150, 30);
        mainPanel.add(missileOperation);

        radarOperation = new JButton("Radar Operation");
        radarOperation.setEnabled(false);
        radarOperation.setBounds(65, 230, 150, 30);
        mainPanel.add(radarOperation);

        rotateShooting = new JButton("Rotate Shooting");
        rotateShooting.setEnabled(false);
        rotateShooting.setBounds(65, 270, 150, 30);
        mainPanel.add(rotateShooting);

        areaClear = new JLabel("Area Not Cleared");
        areaClear.setBounds(20, 310, 150, 30);
        areaClear.setForeground(Color.RED);
        mainPanel.add(areaClear);

        //separator
        JSeparator separator3 = new JSeparator(SwingConstants.VERTICAL);
        separator3.setBounds(275, 20, 1, 320);
        mainPanel.add(separator3);

        //right side components
        JLabel lblNotification = new JLabel("Notifications");
        lblNotification.setBounds(300, 20, 150, 30);
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
            mainController.sendToMain(txtSend.getText(), "Tank");
            txtSend.setText("");
        });
        mainPanel.add(send);

        add(mainPanel);
    }

    //set area clear or not
    @Override
    public void areaClear(Boolean isAreaClear) {
        if(isAreaClear){
            areaClear.setText("Area Cleared");
            areaClear.setForeground(Color.GREEN);
        }else{
            areaClear.setText("Area Not Cleared");
            areaClear.setForeground(Color.RED);
        }
    }

    //set position
    @Override
    public void position(int positionValue) {
        if(position.isSelected()){
            shoot.setEnabled(positionValue > 20? true : false);
            missileOperation.setEnabled(positionValue > 40? true : false);
            radarOperation.setEnabled(positionValue > 60? true : false);
            rotateShooting.setEnabled(positionValue > 80? true : false);
        }
    }

    //send msgs to defences privately
    @Override
    public void sendPrivate(String message, String defence) {
        if (defence.equals("Tank")) {
            txtNotification.append("From Main Controller to Tank: " + message + "\n");
        }
    }

    //send msgs to all defences
    @Override
    public void sendAll(String message) {
        txtNotification.append("From Main Controller to all: " + message + "\n");
    }

    //get soldier count
    @Override
    public String getSoldierCount() {
        return txtSoldierCount.getText();
    }

    //get ammo count
    @Override
    public String getAmmoCount() {
        return txtAmmoCount.getText();
    }
}
