import javax.swing.*;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class Person implements Serializable, Observer {

    private int CNP;
    private String nume;
    private String prenume;
    private String email;
    private int varsta;


    public Person(int CNP, String nume, String prenume, String email, int varsta) {
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.varsta = varsta;
    }

    public Person() {

    }

    public int getCNP() {
        return CNP;
    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Person: "+nume+" "+prenume+ " are varsta "+varsta;
    }

    @Override
    public void update(Observable o, Object arg) {

            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,arg);
            f.setVisible(true);
        System.out.println("intra-------");



    }
}
