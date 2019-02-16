import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    JFrame frameMain = new JFrame("<SimionBank>");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Persons");
    JLabel label2 = new JLabel("Accounts");
    JButton addClientBtn = new JButton("ADD");
    JButton addAccountBtn = new JButton("ADD");
    JButton editClientBtn = new JButton("EDIT");
    JButton editAccountBtn = new JButton("EDIT");
    JButton deleteClientBtn = new JButton("DELETE");
    JButton deleteAccoutBtn = new JButton("DELETE");
    JButton viewClientBtn = new JButton("VIEW");
    JButton viewAccountBtn = new JButton("VIEW");
    JButton operationsBtn = new JButton("OPERATIONS");

    public MainFrame() {
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(380, 300);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(60, 20);
        label.setLocation(60, 15);

        label2.setSize(60, 20);
        label2.setLocation(230, 15);

        addClientBtn.setSize(120, 20);
        addClientBtn.setLocation(20, 50);

        editClientBtn.setSize(120, 20);
        editClientBtn.setLocation(20, 80);

        deleteClientBtn.setSize(120, 20);
        deleteClientBtn.setLocation(20, 110);

        viewClientBtn.setSize(120, 20);
        viewClientBtn.setLocation(20, 140);
//----------------------------------------------------------

        addAccountBtn.setSize(120, 20);
        addAccountBtn.setLocation(200, 50);

        editAccountBtn.setSize(120, 20);
        editAccountBtn.setLocation(200, 80);

        deleteAccoutBtn.setSize(120, 20);
        deleteAccoutBtn.setLocation(200, 110);


        viewAccountBtn.setSize(120, 20);
        viewAccountBtn.setLocation(200, 140);

        operationsBtn.setSize(120, 30);
        operationsBtn.setLocation(115, 180);


        panel.add(label);
        panel.add(label2);
        panel.add(addClientBtn);
        panel.add(addAccountBtn);
        panel.add(editClientBtn);
        panel.add(editAccountBtn);
        panel.add(deleteClientBtn);
        panel.add(deleteAccoutBtn);
        panel.add(viewClientBtn);
        panel.add(viewAccountBtn);
        panel.add(operationsBtn);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }
    public void addClientListener(ActionListener listener) {
        addClientBtn.addActionListener(listener);
    }
    public void addAccountListener(ActionListener listener) {
        addAccountBtn.addActionListener(listener);
    }
    public void editClientListener(ActionListener listener) {
        editClientBtn.addActionListener(listener);
    }
    public void editAccountListener(ActionListener listener) {
        editAccountBtn.addActionListener(listener);
    }
    public void deleteClientListener(ActionListener listener) {
        deleteClientBtn.addActionListener(listener);
    }
    public void deleteAccountListener(ActionListener listener) {
        deleteAccoutBtn.addActionListener(listener);
    }
    public void viewClientListener(ActionListener listener) {
        viewClientBtn.addActionListener(listener);
    }
    public void viewAccountListener(ActionListener listener) {
        viewAccountBtn.addActionListener(listener);
    }
    public void addOperationListener(ActionListener listener) {
        operationsBtn.addActionListener(listener);
    }


}
