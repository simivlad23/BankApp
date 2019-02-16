

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameCont  {

    private MainFrame mainFrame;
Bank bank;
    public MainFrameCont(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        bank =new Bank();
        mainFrame.addClientListener(new AddClientBtn());
        mainFrame.addAccountListener(new AddAccountBtn());
        mainFrame.deleteClientListener(new DeleteClientBtn());
        mainFrame.editClientListener(new EditClientBtn());
        mainFrame.viewClientListener(new ViewClientBtn());
        mainFrame.editAccountListener(new EditAccountBtn());
        mainFrame.deleteAccountListener(new DeleteAccountBtn());
        mainFrame.viewAccountListener(new ViewAccountBtn());
        mainFrame.addOperationListener(new operationsBtn());

    }

    public void addClient() {
        AddClientFrame addClientFrame = new AddClientFrame();

    }

    public void editClient() {
        EditClientFrame editClientFrame = new EditClientFrame();
    }

    public void deleteClient() {
        DeleteClientFrame deleteClientFrame = new DeleteClientFrame();

    }

    public void viewClient() {

        ViewClientFrame viewClientFrame = new ViewClientFrame();
    }

    public void addAccount() {
        AddAccountFrame addAccountFrame = new AddAccountFrame();

    }

    public void editAccount() {

        EditAccountFrame editAccountFrame = new EditAccountFrame();
    }

    public void deleteAccount() {
        DeleteAccountFrame deleteAccountFrame = new DeleteAccountFrame();
    }

    public void viewAccount() {
        ViewAccountFrame viewAccountFrame = new ViewAccountFrame();

    }

    public void addOperation() {

        OperationFrame operationFrame =new OperationFrame();
    }

    class AddClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                addClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class EditClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                editClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DeleteClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                deleteClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ViewClientBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                viewClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class AddAccountBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                addAccount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class EditAccountBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                editAccount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DeleteAccountBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                deleteAccount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ViewAccountBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                viewAccount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class operationsBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                addOperation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}





