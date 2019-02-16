import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Map;

public class ViewAccountFrame extends JFrame {


    private JScrollPane jScrollPane;
    private JPanel panel;
    Bank bank = new Bank();

    public static JTable getJTable(Bank bank) {

        int i = 0;


        Object[][] tabela = new Object[bank.getAllAccount().size()][4];
        String[] listaCampuri = new String[4];

        listaCampuri[0] = "Id Cont";
        listaCampuri[2] = "CNP Client";
        listaCampuri[1] = "Suma";
        listaCampuri[3] = "Type Account";


        for (Map.Entry<Person, LinkedList<Account>> entry : bank.getListaConturi().entrySet()) {
            if (!entry.getValue().isEmpty())
                for (Account account : entry.getValue()) {

                    tabela[i][0] = account.getIdCont();
                    tabela[i][1] = account.getSumaCont();
                    tabela[i][2] = entry.getKey().getCNP();
                    tabela[i][3] = account.getClass().getSimpleName();
                    i++;
                }


        }


        JTable t = new JTable(tabela, listaCampuri);
        return t;
    }

    public ViewAccountFrame() {
        panel = new JPanel();
        this.setName("ViewAccountFrame");

        jScrollPane = new JScrollPane(getJTable(bank));
        this.setSize(500, 400);
        this.setLocation(860, 0);
        panel.add(jScrollPane);
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);

    }



}

