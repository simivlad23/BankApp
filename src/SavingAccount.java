import javax.swing.*;

public class SavingAccount extends Account  {

    private int dobanda =2;
    private int numarRetrageriPermise;

    public SavingAccount(int idCont, int sumaCont) {
        super(idCont, sumaCont);

        numarRetrageriPermise=3;
    }

    @Override
    public void depozit(int suma) {


        String string ="In SpandingAccount s-a introdus suma:"+suma;
        setChanged();
        notifyObservers(string);
        int actual = super.getSumaCont();
        super.setSumaCont(actual+suma+dobanda);


    }

    @Override
    public void retragere(int suma) {

        if(numarRetrageriPermise>=0)
        {
            int actual = super.getSumaCont();
            if(suma<=actual)
                super.setSumaCont(actual-suma);

            setChanged();
            notifyObservers(new String("Din contul SavingAccount s-a retras suma:"+suma));
            numarRetrageriPermise--;
        }
        else {
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,"S-a atins numarul maxim de retrageri permise");
            f.setVisible(true);
        }



    }


}
