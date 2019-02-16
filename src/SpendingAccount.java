public class SpendingAccount extends Account  {

    public SpendingAccount(int idCont, int sumaCont) {
        super(idCont, sumaCont);
    }

    @Override
    public void depozit(int suma) {

        int actual = super.getSumaCont();
        super.setSumaCont(actual+suma);
        setChanged();
        notifyObservers(new String("In SpandingAccount s-au introdus suma:"+suma));


    }

    @Override
    public void retragere(int suma) {


        int actual = super.getSumaCont();
        if(suma<=actual)
        super.setSumaCont(actual-suma);
        setChanged();
        notifyObservers(new String("Din contul SpandingAccount s-a retras suma:"+suma));

    }

}
