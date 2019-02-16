
import java.io.*;
import java.util.*;

public class Bank implements BankProc  {

    private HashMap<Person, LinkedList<Account>> listaConturi;

    public Bank(HashMap<Person, LinkedList<Account>> listaConturi) {
        this.listaConturi = listaConturi;
        this.read();
    }

    public Bank() {
        listaConturi=new HashMap<Person,LinkedList<Account>>();
        this.read();
        updateObserver();
    }

    @Override
    public void addPerson(Person p) {

        assert p!=null : "person = null";
        int presize = listaConturi.size();
        assert isWellFormed();
        listaConturi.put(p, new LinkedList<Account>());
        assert listaConturi.size()==presize+1 :" dimensiune la fel";
        assert listaConturi.containsKey(p) :" dupa inserare nu se afla cheia";
        assert isWellFormed();
        this.write();
    }


    @Override
    public void removePerson(int id) {

        assert id>0 : "id negativ nu se poate";
        int preSize =listaConturi.size();
        assert isWellFormed();
        Person p=null;
        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {
            if (entry.getKey().getCNP() == id){
                p=entry.getKey();
                //listaConturi.remove(p,entry.getValue());
                listaConturi.remove(entry.getKey());
                this.write();
            }
        }

        assert listaConturi.size() ==preSize-1:"dupa stergere dimensiunea nu s-a schimbat";
        assert p!=null:" persoana nu se afla in evidenta";
        assert listaConturi.containsKey(p)==false :" persoana inca se afla in evidenta";
        assert isWellFormed();

    }

    @Override
    public void editPerson(int CNP, String nume, String prenume, String email,int varsta) {

        assert CNP>0 : "CNP negativ nu se poate";
        assert nume!="" : "nu se poate nume gol";
        assert prenume!="" : "nu se poate prenume gol";
        assert varsta>0 : "varsta negativa nu se poate";
        int preSize =listaConturi.size();
        assert isWellFormed();

        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {
            if (entry.getKey().getCNP() == CNP) {
                entry.getKey().setNume(nume);
                entry.getKey().setPrenume(prenume);
                entry.getKey().setEmail(email);
                entry.getKey().setVarsta(varsta);
                this.write();
                break;
            }
        }
        assert listaConturi.size()==preSize :"dimensiune diferita";
        assert isWellFormed();
        this.write();


    }

    @Override
    public void addAccount(int cnpClient, Account c) {

        Person p=null;
        assert cnpClient>0 : "cnp negati nu se poate";
        int sizePre= listaConturi.size();
        assert isWellFormed();
        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            p =entry.getKey();
            c.addObserver(p);
            if (entry.getKey().getCNP()==cnpClient) {
                entry.getValue().add(c);
            }
        }
        assert p!=null :"cnp negasit";
        assert listaConturi.size()==sizePre;
        assert isWellFormed();
        this.write();

    }

    @Override
    public void removeAccount(int idCont) {

        Account p=null;
        assert idCont>0 : "cnp negativ nu se poate";
        int sizePre= listaConturi.size();
        assert isWellFormed();
        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            for(Account account: entry.getValue())
            {
                if(account.getIdCont()==idCont)
                {
                    p=account;
                    if(entry.getValue().remove(account))
                    {
                        System.out.println("Contul cu id:"+ idCont+ " a fost sters");
                        this.write();
                        return;
                    }
                    else
                        System.out.println("Contul cu id:"+ idCont+ "  nu a fost sters");


                }
            }

        }
        assert p!=null :"cont negasit";
        assert listaConturi.size()==sizePre-1;
        assert isWellFormed();

    }

    @Override
    public void editAccount(int idCont, int suma) {

        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            for(Account account: entry.getValue())
            {
                if(account.getIdCont()==idCont)
                {
                    account.setSumaCont(suma);
                    System.out.println("Contul cu id:"+idCont+" a fost modificat");
                    this.write();
                    return;
                }
            }

        }


    }

    @Override
    public void depunere(int idCont, int suma) {

        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            for(Account account: entry.getValue())
            {
                if(account.getIdCont()==idCont)
                {
                    account.depozit(suma);
                    System.out.println("S-au depus in cont:"+idCont+" suma "+suma +" noua suma:"+account.getSumaCont());
                    this.write();
                    return;
                }
            }

        }


    }

    @Override
    public void retragere(int idCont, int suma) {

        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            for(Account account: entry.getValue())
            {
                if(account.getIdCont()==idCont)
                {
                    account.retragere(suma);
                    System.out.println("S-au retras din cont:"+idCont+" suma "+suma +" noua suma:"+account.getSumaCont());
                    this.write();
                    return;
                }
            }

        }

    }

    public ArrayList<Object> getAllPerson()
    {
        ArrayList<Object> listPerson=new ArrayList<>();
        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            listPerson.add(entry.getKey());

        }
        return listPerson;


    }

    public void updateObserver()
    {

        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            Person p =entry.getKey();
            for(Account acc: entry.getValue())
            {
                acc.addObserver(p);
            }

        }


    }

    public ArrayList<Object> getAllAccount()
    {
        ArrayList<Object> listAccount=new ArrayList<>();
        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {

            for(Account acc: entry.getValue())
            {
                listAccount.add(acc);
                acc.addObserver(entry.getKey());
            }

        }
        return listAccount;


    }
    public HashMap<Person, LinkedList<Account>> getListaConturi() {
        return listaConturi;
    }


    public void read() {
        try {
            FileInputStream fileIn = new FileInputStream("bank.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listaConturi = (HashMap) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Bank class not found");
            c.printStackTrace();
        }
    }

    public void write() {
        try {
            FileOutputStream fileOut = new FileOutputStream("bank.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaConturi);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in bank.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    protected boolean isWellFormed()
    {
        for (Map.Entry<Person, LinkedList<Account>> entry : listaConturi.entrySet()) {
            if (entry.getKey()==null ){
              return false;
            }
        }
        return true;
    }
}


