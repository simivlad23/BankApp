import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationFrame {

    JFrame frameMain = new JFrame("Operations");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Id Cont");
    JLabel label2 = new JLabel("Suma");

    JTextField tfIdCont = new JTextField();
    JTextField tfSuma = new JTextField();


    JButton addDepozitBtn = new JButton("Deposit");
    JButton addRetragreBtn = new JButton("Withdraw");

    Bank bank;
    public OperationFrame() {
        bank= new Bank();
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 200);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);




        tfIdCont.setSize(120, 20);
        tfIdCont.setLocation(100, 20);

        tfSuma.setSize(120, 20);
        tfSuma.setLocation(100, 50);



        addDepozitBtn.setSize(100, 20);
        addDepozitBtn.setLocation(10, 120);

        addRetragreBtn.setSize(100, 20);
        addRetragreBtn.setLocation(120, 120);

        addDepozitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDepozit();
            }
        });

        addRetragreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWithdraw();
            }
        });

        panel.add(label);
        panel.add(label2);

        panel.add(addDepozitBtn);
        panel.add(addRetragreBtn);
        panel.add(tfIdCont);
        panel.add(tfSuma);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }



    public int getIdCont() {
        return Integer.valueOf(tfIdCont.getText());
    }

    public int getSuma() {
        return Integer.valueOf(tfSuma.getText());
    }

    public void addDepozit() {

       bank.depunere(getIdCont(),getSuma());
       resetTf();

    }
    public void addWithdraw()
    {

        bank.retragere(getIdCont(),getSuma());
        resetTf();

    }
    public void resetTf(){
        tfSuma.setText("");
        tfIdCont.setText("");

    }

}
