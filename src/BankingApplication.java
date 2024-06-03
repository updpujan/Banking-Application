import java.io.*;
import java.util.*;

//customer class
class Customer {
    private String firstName;
    private String lastName;
    
    //getFirstName() method to return fName
    public String getFirstName() {
        return firstName;
    }

    //getLastName() method to return lName
    public String getLastName() {
        return lastName;
    }

    //setFirstName() method to initialize fName
    public void setFirstName(String fName) {
        firstName = fName;
    }

  //setLastName() method to initialize lName
    public void setLastName(String lName) {
        lastName = lName;
    }
}

//Child class of Customer Class:- Account Class
class Account extends Customer {
    private int balance;
    private int accountNumber;

    public Account(String fName, String lName, int accountNumber, int balance) {
    	/*
    	 Account constructor to set first name and last name by calling parent method.
    	 And to set the balance and account number of that customer bank account.
    	*/
        setFirstName(fName);
        setLastName(lName);
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    //returns the balance in account of customer
    public int getBalance() {
        return balance;
    }

    //return account number of customer
    public int getAccountNumber() {
        return accountNumber;
    }

    //this method add the amount to the balance
    public void deposit(int amount) {
        balance += amount;
    }

    //this method deduct the amount from the balance
    public void withdraw(int amount) {
        balance -= amount;
    }
}

//transaction class
class Transaction {
    public void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}

//ReadAccount class
class ReadAccounts {
    String URL;
    BufferedReader reader;
    public ReadAccounts(String URL) {
        this.URL = URL;
    }

    public List<String> getFirstNames() throws IOException {
        List<String> firstNames = new LinkedList<>();
        reader = new BufferedReader(new FileReader(URL));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            firstNames.add(data[0]);
        }
        reader.close();
        return firstNames;
    }

    public List<String> getLastNames() throws IOException {
        List<String> lastNames = new LinkedList<>();
        reader = new BufferedReader(new FileReader(URL));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            lastNames.add(data[1]);
        }
        reader.close();
        return lastNames;
    }

    public List<Integer> getAccountNumbers() throws IOException {
        List<Integer> accountNumbers = new LinkedList<>();
        reader = new BufferedReader(new FileReader(URL));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            accountNumbers.add(Integer.parseInt(data[2]));
        }
        reader.close();
        return accountNumbers;
    }

    public List<Integer> getBalances() throws IOException {
        List<Integer> balances = new LinkedList<>();
        reader = new BufferedReader(new FileReader(URL));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            balances.add(Integer.parseInt(data[3]));
        }
        reader.close();
        return balances;
    }
}

//main class
public class BankingApplication {
    public static void main(String[] args) {
    	
    	String file="Accounts.csv";
    	
    	try {
    	//object of ReadAccounts Class
    	ReadAccounts readAccounts = new ReadAccounts(file);
    	
    	//list to store firstnames, lastnames, account number and balance
    	List<String> firstNames = readAccounts.getFirstNames();
        List<String> lastNames = readAccounts.getLastNames();
        List<Integer> accountNumbers = readAccounts.getAccountNumbers();
        List<Integer> balances = readAccounts.getBalances();
        
        //linked list of accounts
    	List<Account> accounts=new LinkedList<>();
    	//for loop to store each account accounts list
    	for (int i = 0; i < firstNames.size(); i++) {
            Account account = new Account(firstNames.get(i), lastNames.get(i), accountNumbers.get(i), balances.get(i));
            accounts.add(account);
        }
    	
    	//print all the account and information
    	for(Account account:accounts) {
    		System.out.println("First Name : "+account.getFirstName());
    		System.out.println("Last Name : "+account.getLastName());
    		System.out.println("Account Number : "+account.getAccountNumber());
    		System.out.println("Balance : "+account.getBalance()+"\n");
    	}
    	
    	//Test deposite and withdrawl and transfer
    	Account account1 = accounts.get(0);
    	Account account2= accounts.get(1);
    	
    	System.out.println("The balance of account1 before deposite is "+account1.getBalance());
    	System.out.println("The balnce of account2 before withdraw is "+account2.getBalance());
    	
    	account1.deposit(250);
    	account2.withdraw(500);
    	
    	System.out.println("The balance of account1 after deposite is "+account1.getBalance());
    	System.out.println("The balance of account2 after withdraw is "+account2.getBalance());
    	
    	Transaction transfer=new Transaction();
    	transfer.transfer(account1, account2, 250);
    	
    	System.out.println("The balance of account1 after transfer/given by is "+account1.getBalance());
    	System.out.println("The balance of account2 after transfer/recevied by is "+account2.getBalance());
    	    	
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    }
}
