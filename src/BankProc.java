public interface BankProc {

    public void addPerson(Person p);
    public void removePerson(int CNP);
    public void editPerson(int CNP,String nume,String prenume,String email,int varsta);
    public void addAccount(int cnpClient,Account c);
    public void removeAccount(int idCont);
    public void editAccount(int idCont,int suma);
    public void depunere(int idCont,int suma);
    public void retragere(int idCont,int suma);
}
