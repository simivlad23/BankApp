import java.util.LinkedList;
import java.util.Map;

public class Start {
    public static void main(String[] args) {
       Bank bank =new Bank();
//        bank.depunere(3,300);
//        SavingAccount savingAccount =new SavingAccount(5,200);
//        Person person =new Person(24,"Vlad","Irina","email2",32);
////
//        bank.addPerson(person);
//        bank.addAccount(24,savingAccount);

       //bank.depunere(1,300);

//        if(bank.getListaConturi().containsKey(person)) {
//
//
//            System.out.println("gasit");
//
//            LinkedList<Account> list = bank.getListaConturi().get(person);
//            for(Account account : list)
//            {
//                System.out.println(account.toString());
//            }
//        }
//        else
//            System.out.println("negasit");

        for (Map.Entry<Person, LinkedList<Account>> entry : bank.getListaConturi().entrySet())
        {
            if(!entry.getValue().isEmpty())
            System.out.println(entry.getKey().toString()+ " si suma totala:"+entry.getValue().get(0).getSumaCont());


        }

        MainFrame mainFrame =new MainFrame();
        MainFrameCont mainFrameCont =new MainFrameCont(mainFrame);


    }
}
