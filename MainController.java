import javax.swing.*;
import java.awt.*;

class MainController extends JFrame implements SuperMainController{
    private JComboBox<String> selectDefence;
    private JButton collectInfo;
    private JTextField txtSoldierCount;
    private JTextField txtAmmoCount;
    private JTextField txtEnergyLevel;
    private JTextField txtOxygenLevel;
    private JSlider position;
    private JCheckBox areaClear;
    private JTextArea txtNotification;
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

        // Left side components
        String[] item = {"----Select Defence----", "Helicopter", "Tank", "Submarine","All"};
        selectDefence = new JComboBox<String>(item);
        selectDefence.setBounds(20, 30, 150, 30);
        mainPanel.add(selectDefence);

        collectInfo = new JButton("Collect Info");
        collectInfo.setBounds(200, 30, 150, 30);
        collectInfo.addActionListener(e -> {
            txtSoldierCount.setText(observer.getSoldierCount(selectDefence.getSelectedItem().toString()));
            txtAmmoCount.setText(observer.getAmmoCount(selectDefence.getSelectedItem().toString()));
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

        //Separator1
        JSeparator Separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        Separator1.setBounds(20, 190, 340, 1);
        mainPanel.add(Separator1);

        JLabel lblPosition = new JLabel("Position");
        lblPosition.setBounds(20, 200, 150, 30);
        mainPanel.add(lblPosition);

        position = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        position.setBounds(20, 230, 330, 60);
        position.setMajorTickSpacing(20);
        position.setMinorTickSpacing(5);
        position.setPaintTicks(true);
        position.setPaintLabels(true);
        position.addChangeListener(e -> {
            observer.position(position.getValue());
        });
        mainPanel.add(position);

        //Separator2
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

        // Separator3
        JSeparator separator3 = new JSeparator(SwingConstants.VERTICAL);
        separator3.setBounds(405, 20, 1, 320);
        mainPanel.add(separator3);

        // Right side components
        JLabel lblNotification = new JLabel("Notifications");
        lblNotification.setBounds(420, 20, 150, 30);
        mainPanel.add(lblNotification);

        txtNotification = new JTextArea();
        txtNotification.setLineWrap(true);
        txtNotification.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtNotification);
        scrollPane.setBounds(420, 50, 350, 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(scrollPane);

        sendPrivate = new JCheckBox("Send Private");
        sendPrivate.setBounds(420, 255, 100, 30);
        mainPanel.add(sendPrivate);

        txtSend = new JTextField();
        txtSend.setBounds(420, 300, 250, 30);
        mainPanel.add(txtSend);

        send = new JButton("Send");
        send.setBounds(680, 300, 90, 30);
        send.addActionListener(e -> {
            if(sendPrivate.isSelected()){
                observer.sendPrivate(txtSend.getText(), selectDefence.getSelectedItem().toString());
            }else{
                observer.sendAll(txtSend.getText());
            }
            txtSend.setText("");
        });
        mainPanel.add(send);

        add(mainPanel);
    }

    @Override
    public void sendToMain(String message, String defence){
        txtNotification.append(defence + ": " + message + "\n");
    }
}
