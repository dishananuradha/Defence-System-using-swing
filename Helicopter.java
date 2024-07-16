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

    public Helicopter(SuperMainController mainController){
        setTitle("Helicopter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x = ((MainController) mainController).getX() + ((MainController) mainController).getWidth();
        setLocation(x+20 , 0);
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
        position.setBounds(20, 130, 150, 30);
        mainPanel.add(position);

        shoot = new JButton("Shoot");
        shoot.setEnabled(false);
        shoot.setBounds(65, 180, 150, 30);
        mainPanel.add(shoot);

        missileOperation = new JButton("Missile Operation");
        missileOperation.setEnabled(false);
        missileOperation.setBounds(65, 220, 150, 30);
        mainPanel.add(missileOperation);

        laserOperation = new JButton("Laser Operation");
        laserOperation.setEnabled(false);
        laserOperation.setBounds(65, 260, 150, 30);
        mainPanel.add(laserOperation);

        areaClear = new JLabel("Area Not Cleared");
        areaClear.setBounds(20, 310, 150, 30);
        areaClear.setForeground(Color.RED);
        mainPanel.add(areaClear);

        //vertical separator
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
            mainController.sendToMain(txtSend.getText(), "Helicopter");
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
            shoot.setEnabled(positionValue > 25? true : false);
            missileOperation.setEnabled(positionValue > 50? true : false);
            laserOperation.setEnabled(positionValue > 75? true : false);
        }
    }

    //send msgs to defences privately
    @Override
    public void sendPrivate(String message, String defence) {
        if (defence.equals("Helicopter")) {
            txtNotification.append("From Main Controller to Helicopter: " + message + "\n");
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