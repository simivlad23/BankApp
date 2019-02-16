import java.io.Serializable;
import java.util.Observable;

public abstract class Account extends Observable implements Serializable{


    private int idCont;
    private int sumaCont;

    public abstract void depozit(int suma);
    public abstract void retragere(int suma);


    public Account(int idCont, int sumaCont) {
        this.idCont = idCont;

        this.sumaCont = sumaCont;
    }

    public int getIdCont() {
        return idCont;
    }

    public void setIdCont(int idCont) {
        this.idCont = idCont;
    }


    public int getSumaCont() {
        return sumaCont;
    }

    public void setSumaCont(int sumaCont) {
        this.sumaCont = sumaCont;
    }


}
