import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BankTest {

    @Test
    void addPerson() {
        Bank bank=new Bank();
        Person person =new Person(133,"Vlad","David","ecevasad",12);
        assertNotNull(person);
        int preSize =bank.getListaConturi().size();
        bank.addPerson(person);
        int postSize= bank.getListaConturi().size();

        assertEquals(true,bank.getListaConturi().containsKey(person));
        assertEquals(postSize,preSize+1);
    }

    @Test
    void editPerson() {

        Bank bank=new Bank();
        int cnp =133;
        String nume= "Vlad";
        String prenume ="Andrei";
        String email ="dsf";
        int varsta =33;
        int preSize =bank.getListaConturi().size();
        bank.editPerson(cnp,nume,prenume,email,varsta);
        int postSize= bank.getListaConturi().size();

        assertEquals(postSize,preSize);

    }

    @Test
    void addAccount() {

        Bank bank =new Bank();
        SavingAccount savingAccount =new SavingAccount(5,200);
        Person person =new Person(24,"Vlad","Irina","email2",32);
        int preSize =bank.getListaConturi().size();
        bank.addPerson(person);
        bank.addAccount(24,savingAccount);


        int postSize= bank.getListaConturi().size();
        assertEquals(true,bank.getListaConturi().containsKey(person));
        assertEquals(true,bank.getAllAccount().contains(savingAccount));
        assertEquals(postSize,preSize+1);

    }

    @Test
    void removeAccount() {

        Bank bank =new Bank();

        SavingAccount savingAccount =new SavingAccount(6,200);
        Person person =new Person(222,"Vlad","Maria","email2",32);

        bank.addPerson(person);
        bank.addAccount(222,savingAccount);
        assertEquals(true,bank.getAllAccount().contains(savingAccount));
        int preSize =bank.getListaConturi().size();

        bank.removeAccount(savingAccount.getIdCont());

        int postSize= bank.getListaConturi().size();
        assertEquals(true,bank.getListaConturi().containsKey(person));
        assertEquals(false,bank.getAllAccount().contains(savingAccount));
        assertEquals(postSize,preSize);
    }
}