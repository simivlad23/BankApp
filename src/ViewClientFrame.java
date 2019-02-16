import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewClientFrame extends JFrame {
    private JScrollPane jScrollPane;
    private JPanel panel;
    Bank bank = new Bank() ;
    public ViewClientFrame(){
        panel=new JPanel();
        this.setName("ViewPersonFrame");
        List<Object> personList = bank.getAllPerson();
        jScrollPane = new JScrollPane(Refection.getJTable(personList));
        this.setSize(500, 400);
        panel.add(jScrollPane);
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);

    }



}
