import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccountFrame {

    JFrame frameMain = new JFrame("Add Account");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("idCont");
    JLabel label2 = new JLabel("CNP Client");
    JLabel label3 = new JLabel("Sold initial");
    JLabel label4 = new JLabel("Type");

    JTextField tfIdCont = new JTextField();
    JTextField tfCnpClient = new JTextField();
    JTextField tfSold= new JTextField();
    String[] comboContent ={"Saving Account","Spending Account"};
    JComboBox<String> typeCombo = new JComboBox<>(comboContent);




    JButton addAccountBtn = new JButton("ADD");


    Bank bank;
    public AddAccountFrame() {
        bank = new Bank();
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 230);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);


        label3.setSize(60, 20);
        label3.setLocation(20, 80);

        label4.setSize(60, 20);
        label4.setLocation(20, 110);





        tfIdCont.setSize(120, 20);
        tfIdCont.setLocation(100, 20);

        tfCnpClient.setSize(120, 20);
        tfCnpClient.setLocation(100, 50);

        tfSold.setSize(120, 20);
        tfSold.setLocation(100, 80);

        typeCombo.setSize(120, 20);
        typeCombo.setLocation(100, 110);



        addAccountBtn.setSize(120, 20);
        addAccountBtn.setLocation(60, 150);

        addAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccount();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        panel.add(addAccountBtn);
        panel.add(tfIdCont);
        panel.add(tfCnpClient);
        panel.add(tfSold);
        panel.add(typeCombo);

        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }


    public int getIdCont() {
        return Integer.valueOf(tfIdCont.getText());
    }

    public int getCnpClient() {
        return Integer.valueOf(tfCnpClient.getText());
    }

    public int getSold() {
        return Integer.valueOf(tfSold.getText());
    }

    public void addAccount() {


        if(typeCombo.getSelectedIndex()==0)
        {
            bank.addAccount(getCnpClient(),new SavingAccount(getIdCont(),getSold()));

        }
        else
        {
            bank.addAccount(getCnpClient(),new SpendingAccount(getIdCont(),getSold()));
        }

        resetTf();
    }
    public void resetTf(){
        tfSold.setText("");
        tfCnpClient.setText("");
        tfIdCont.setText("");

    }


}
