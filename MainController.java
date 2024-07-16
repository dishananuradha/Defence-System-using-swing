import javax.swing.*;
import java.awt.*;

class MainController extends JFrame implements SuperMainController{
    private JComboBox<String> selectDefence1;
    private JButton collectInfo;
    private JTextField txtSoldierCount;
    private JTextField txtAmmoCount;
    private JTextField txtEnergyLevel;
    private JTextField txtOxygenLevel;
    private JSlider position;
    private JCheckBox areaClear;
    private JTextArea txtNotification;
    private JComboBox<String> selectDefence2;
    private JCheckBox sendPrivate;
    private JTextField txtSend;
    private JButton send;

    public MainController(SuperObserver observer){
        setTitle("Main Controller");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(800, 400));

        //left side components
        String[] item1 = {"----Select Defence----", "Helicopter", "Tank", "Submarine","All"};
        selectDefence1 = new JComboBox<String>(item1);
        selectDefence1.setBounds(20, 30, 150, 30);
        mainPanel.add(selectDefence1);

        collectInfo = new JButton("Collect Info");
        collectInfo.setBounds(200, 30, 150, 30);
        collectInfo.addActionListener(e -> {
            txtSoldierCount.setText(observer.getSoldierCount(selectDefence1.getSelectedItem().toString()));
            txtAmmoCount.setText(observer.getAmmoCount(selectDefence1.getSelectedItem().toString()));
            txtEnergyLevel.setText(observer.getEnergyLevel(selectDefence1.getSelectedItem().toString()));
            txtOxygenLevel.setText(observer.getOxygenLevel(selectDefence1.getSelectedItem().toString()));
        });
        mainPanel.add(collectInfo);

        JLabel lblSoldierCount = new JLabel("Soldier Count");
        lblSoldierCount.setBounds(20, 100, 70, 30);
        mainPanel.add(lblSoldierCount);

        txtSoldierCount = new JTextField();
        txtSoldierCount.setBounds(100, 100, 100, 30);
        txtSoldierCount.setEditable(false);
        mainPanel.add(txtSoldierCount);

        JLabel lblAmmoCount = new JLabel("Ammo Count");
        lblAmmoCount.setBounds(20, 140, 70, 30);
        mainPanel.add(lblAmmoCount);

        txtAmmoCount = new JTextField();
        txtAmmoCount.setBounds(100, 140, 100, 30);
        txtAmmoCount.setEditable(false);
        mainPanel.add(txtAmmoCount);

        JLabel lblEnergyLevel = new JLabel("Energy Level");
        lblEnergyLevel.setBounds(220, 100, 70, 30);
        mainPanel.add(lblEnergyLevel);

        txtEnergyLevel = new JTextField();
        txtEnergyLevel.setBounds(300, 100, 90, 30);
        txtEnergyLevel.setEditable(false);
        mainPanel.add(txtEnergyLevel);

        JLabel lblOxygenLevel = new JLabel("Oxygen Level");
        lblOxygenLevel.setBounds(220, 140, 70, 30);
        mainPanel.add(lblOxygenLevel);

        txtOxygenLevel = new JTextField();
        txtOxygenLevel.setBounds(300, 140, 90, 30);
        txtOxygenLevel.setEditable(false);
        mainPanel.add(txtOxygenLevel);

        //horizontal separator1
        JSeparator Separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        Separator1.setBounds(20, 190, 340, 1);
        mainPanel.add(Separator1);

        JLabel lblPosition = new JLabel("Position");
        lblPosition.setBounds(20, 200, 150, 30);
        mainPanel.add(lblPosition);

        position = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        position.setBounds(20, 230, 350, 60);
        position.setMajorTickSpacing(20);
        position.setMinorTickSpacing(5);
        position.setPaintTicks(true);
        position.setPaintLabels(true);
        position.addChangeListener(e -> {
            observer.position(position.getValue());
        });
        mainPanel.add(position);

        //horizontal separator2
        JSeparator Separator2 = new JSeparator(SwingConstants.HORIZONTAL);
        Separator2.setBounds(20, 295, 340, 1);
        mainPanel.add(Separator2);

        areaClear = new JCheckBox("Area Clear");
        areaClear.setBounds(20, 310, 100, 30);
        areaClear.addActionListener(e -> {
            if(areaClear.isSelected()){
                observer.areaClear(true);
            }else{
                observer.areaClear(false);
            }
        });
        mainPanel.add(areaClear);

        //vertical separator
        JSeparator separator3 = new JSeparator(SwingConstants.VERTICAL);
        separator3.setBounds(405, 20, 1, 320);
        mainPanel.add(separator3);

        //right side components
        JLabel lblNotification = new JLabel("Notifications");
        lblNotification.setBounds(420, 20, 150, 30);
        mainPanel.add(lblNotification);

        txtNotification = new JTextArea();
        txtNotification.setLineWrap(true);
        txtNotification.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtNotification);
        scrollPane.setBounds(420, 50, 350, 190);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane);

        String[] item2 = {"----Select Defence----", "Helicopter", "Tank", "Submarine"};
        selectDefence2 = new JComboBox<String>(item2);
        selectDefence2.setBounds(470, 255, 150, 30);
        selectDefence2.setEnabled(false);
        mainPanel.add(selectDefence2);

        sendPrivate = new JCheckBox("Send Private");
        sendPrivate.setBounds(650, 255, 100, 30);
        sendPrivate.addActionListener(e -> {
            if(sendPrivate.isSelected()){
                selectDefence2.setEnabled(true);
            }else{
                selectDefence2.setEnabled(false);
                selectDefence2.setSelectedIndex(0);
            }
        });
        mainPanel.add(sendPrivate);

        txtSend = new JTextField();
        txtSend.setBounds(420, 300, 250, 30);
        mainPanel.add(txtSend);

        send = new JButton("Send");
        send.setBounds(680, 300, 90, 30);
        send.addActionListener(e -> {
            if(sendPrivate.isSelected()){
                observer.sendPrivate(txtSend.getText(), selectDefence2.getSelectedItem().toString());
            }else{
                observer.sendAll(txtSend.getText());
            }
            txtSend.setText("");
        });
        mainPanel.add(send);

        add(mainPanel);
    }

    //send msg to the main controller
    @Override
    public void sendToMain(String message, String defence){
        txtNotification.append("From "+ defence + ": " + message + "\n");
    }
}
