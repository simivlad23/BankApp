import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAccountFrame {
    JFrame frameMain = new JFrame("Edit Account");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("idCont");
    JLabel label2 = new JLabel("Sold Nou");


    JTextField tfIdCont = new JTextField();
    JTextField tfSoldNou = new JTextField();





    JButton addAccountBtn = new JButton("EDIT");


    Bank bank;
    public EditAccountFrame() {
        bank = new Bank();
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 160);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);




        tfIdCont.setSize(120, 20);
        tfIdCont.setLocation(100, 20);

        tfSoldNou.setSize(120, 20);
        tfSoldNou.setLocation(100, 50);





        addAccountBtn.setSize(120, 20);
        addAccountBtn.setLocation(60, 90);

        addAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccount();
            }
        });

        panel.add(label);
        panel.add(label2);


        panel.add(addAccountBtn);
        panel.add(tfIdCont);
        panel.add(tfSoldNou);


        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }


    public int getIdCont() {
        return Integer.valueOf(tfIdCont.getText());
    }

    public int getSoldNou() {
        return Integer.valueOf(tfSoldNou.getText());
    }



    public void addAccount() {




        resetTf();
    }
    public void resetTf(){
        tfSoldNou.setText("");
        tfIdCont.setText("");

    }

}
