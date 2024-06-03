//Name: Pujan Upadhyay
//University Student Number: 2408612

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	  //this method deduct amount from one account and add the same amount in another account
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
	  //method to read the first name from file and store it in firstNames <List>
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
	//method to read the last name from file and store it in lastNames <List>
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
	//method to read the account numbers from file and store it accountNumbers <List>
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
	//method to read the balance from file and store it in balances <List>
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


//GUI class
class GUI extends JFrame implements ActionListener{
	/*
	 This GUI class will show the Graphical User Interface to the user so they can interact with my
	 application in simplest way. All they have to do is enter the account number and balance then conform
	 and the eventHandler will handle the rest according to the program written.
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cards;
    private CardLayout cardLayout;
    private JButton showAccountsCard, depositeCard, withdrawCard, transferCard;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JScrollPane scrollPane;
    DefaultTableModel model; 
    
    //object of transaction class
    Transaction transfer=new Transaction();
      
    public void updateTable(List<Account> accounts,DefaultTableModel model) {
    	//updateTable() method is used to show the user update balance.
    	//will be called when press conform
    	Object[][] data = new Object[accounts.size()][4];
        int index = 0;
        for (Account account : accounts) {
            data[index][0] = account.getFirstName();
            data[index][1] = account.getLastName();
            data[index][2] = account.getAccountNumber();
            data[index][3] = account.getBalance();
            index++;
        }
    	model.removeRow(3);
    	model.removeRow(2);
    	model.removeRow(1);
    	model.removeRow(0);
    	
    	for(Object[] row: data) {
        	model.addRow(row);
        }	
    }
        
    //constructor of GUI class
    public GUI(List<Account> accounts) {
        setTitle("GUI for Banking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(745, 471);

        // Create the cards panel
        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        // Create card panels
        JPanel card1 = new JPanel();
        card1.setBackground(new Color(255, 255, 255));
        card1.setLayout(null);

        JPanel card2 = new JPanel();
        card2.setBackground(new Color(255, 255, 255));

        JPanel card3 = new JPanel();
        card3.setBackground(new Color(255, 255, 255));
        card3.setLayout(null);
        
        JPanel card4 = new JPanel();
        card4.setBackground(new Color(255, 255, 255));
        
        JPanel card5 = new JPanel();
        card5.setBackground(new Color(255, 255, 255));
        card5.setLayout(null);

        // Add cards to the card panel
        cards.add(card1, "card1");
        
        JLabel welMessage = new JLabel("Welcome To Banking Application");
        welMessage.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        welMessage.setBounds(41, 41, 304, 27);
        card1.add(welMessage);
        
        JLabel lblThisApplicationIs = new JLabel("This application is developed by :   ");
        lblThisApplicationIs.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblThisApplicationIs.setBounds(41, 107, 407, 42);
        card1.add(lblThisApplicationIs);
        
        JLabel lblNewLabel_1_1 = new JLabel("Name : Pujan Upadhyay");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(120, 138, 215, 42);
        card1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("University Student Number : 2408612   ");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_2.setBounds(120, 170, 304, 42);
        card1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("College ID : np03cs4a230284");
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblNewLabel_1_3.setBounds(120, 203, 215, 42);
        card1.add(lblNewLabel_1_3);
        cards.add(card2, "card2");
        card2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Accounts Information");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel.setBounds(20, 21, 167, 27);
        card2.add(lblNewLabel);
    	String[] columnNames = {"First Name", "Last Name", "Account Number", "Balance"};
        //convert linkedList to object
        Object[][] data = new Object[accounts.size()][4];
        int index = 0;
        for (Account account : accounts) {
            data[index][0] = account.getFirstName();
            data[index][1] = account.getLastName();
            data[index][2] = account.getAccountNumber();
            data[index][3] = account.getBalance();
            index++;
        }
        
        JTable table = new JTable(data, columnNames);
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        for(Object[] row: data) {
        	model.addRow(row);
        }
        // Set table background color
        table.setBackground(new Color(235, 247, 254));

        // Create a scroll pane and add the table to it
        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        // Set bounds for the scroll pane
        scrollPane.setBounds(53, 70, 537, 242);

        // Add scroll pane to the card2 panel
        card2.add(scrollPane);
        
        cards.add(card3, "card3");
        
        JLabel lblNewLabel_1 = new JLabel("Deposite Details");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1.setBounds(46, 45, 155, 30);
        card3.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Account Number :");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(88, 87, 103, 30);
        card3.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(201, 90, 147, 27);
        card3.add(textField);
        
        JLabel lblNewLabel_2_1 = new JLabel("Amount :");
        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2_1.setBounds(132, 143, 64, 30);
        card3.add(lblNewLabel_2_1);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(201, 145, 147, 27);
        card3.add(textField_1);
        
        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.setBounds(226, 232, 122, 42);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		/*
        		 This action listener will take the input from input field,
        		 check if empty or not, if the entered amount and account number are 
        		 valid or not. If valid then will add amount to the balance else
        		 send the corresponding error message to the user.
        		 */
        		String input1=textField.getText();
            	String input2=textField_1.getText();
            	if(input1.isEmpty() || input2.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Field cannot be empty!!!");
        		}else if(!(input1.matches("[0-9]+"))) {
        			JOptionPane.showMessageDialog(null, "Account Number must have only numbers");
        		}else if(!(input2.matches("[0-9]+"))) {
            		JOptionPane.showMessageDialog(null, "Amount must be in numbers!!!");
            	}else {
        			int amount=Integer.parseInt(input2);
        			if(amount<0) {
        				JOptionPane.showMessageDialog(null, "Invalid Amount");
        			}
        			else {
        			for(int i=0;i<=3;i++) {
        				if(data[i][2].equals(Integer.parseInt(input1))) {
        					Account account1 = accounts.get(i);
        					account1.deposit(amount);
        					updateTable(accounts,model);
        					JOptionPane.showMessageDialog(null, "Amount Deposited Sucessfully");
        					break;
        				}
        				else if(i==3){
        					JOptionPane.showMessageDialog(null, "Invalid Account NUmber");
        				}
        			}
        		}
        	}
        }
       });
          
        card3.add(btnNewButton);
        cards.add(card4, "card4");
        card4.setLayout(null);
        
        JLabel lblNewLabel_1_4 = new JLabel("Withdrawl Details");
        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1_4.setBounds(39, 34, 155, 30);
        card4.add(lblNewLabel_1_4);
        
        JLabel lblNewLabel_2_2 = new JLabel("Account Number :");
        lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2_2.setBounds(81, 76, 103, 30);
        card4.add(lblNewLabel_2_2);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(194, 79, 147, 27);
        card4.add(textField_2);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Amount :");
        lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2_1_1.setBounds(125, 132, 64, 30);
        card4.add(lblNewLabel_2_1_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(194, 134, 147, 27);
        card4.add(textField_3);
        
        JButton btnNewButton_1 = new JButton("Confirm");
        btnNewButton_1.setBounds(219, 221, 122, 42);
        card4.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		/*
       		 This action listener will take the input from input field,
       		 check if empty or not, if the entered amount and account number are 
       		 valid or not. If valid then will deduct amount from balance else
       		 send the corresponding error message to the user.
       		 */
        		String input1=textField_2.getText();
        		String input2=textField_3.getText();
        		
        		if(input1.isEmpty() || input2.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Field cannot be empty!!!");
        		}else if(!(input1.matches("[0-9]+"))) {
        			JOptionPane.showMessageDialog(null, "Account Number must have only numbers");
        		}else if(!(input2.matches("[0-9]+"))) {
            		JOptionPane.showMessageDialog(null, "Amount must be in numbers!!!");
            	}else {
        			int amount=Integer.parseInt(input2);
        			if(amount<0) {
        				JOptionPane.showMessageDialog(null, "Invalid Amount");
        			}
        			else {
        			for(int i=0;i<=3;i++) {
        				if(data[i][2].equals(Integer.parseInt(input1))) {
        					Account account1 = accounts.get(i);
        					if(account1.getBalance()>=amount) {
        					account1.withdraw(amount);
        					updateTable(accounts,model);
        					JOptionPane.showMessageDialog(null, "Amount Withdrew Sucessfully");
        					}else {
        						JOptionPane.showMessageDialog(null, "Insuffecient Balance");
        					}
        					break;
        				}
        				else if(i==3){
        					JOptionPane.showMessageDialog(null, "Invalid Account NUmber");
        				}
        			}
        		}
        	}
        }
       });
        cards.add(card5, "card5");
        
        JLabel lblNewLabel_1_5 = new JLabel("Transfer Details");
        lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1_5.setBounds(54, 38, 155, 30);
        card5.add(lblNewLabel_1_5);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(250, 99, 147, 27);
        card5.add(textField_4);
        
        JLabel lblNewLabel_2_3 = new JLabel("Sender's Account Number :");
        lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2_3.setBounds(85, 96, 170, 30);
        card5.add(lblNewLabel_2_3);
        
        JLabel lblNewLabel_2_3_1 = new JLabel("Receiver's Account Number :");
        lblNewLabel_2_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2_3_1.setBounds(85, 137, 155, 30);
        card5.add(lblNewLabel_2_3_1);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(250, 140, 147, 27);
        card5.add(textField_5);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Amount :");
        lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_2_1_2.setBounds(129, 200, 64, 30);
        card5.add(lblNewLabel_2_1_2);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(198, 202, 147, 27);
        card5.add(textField_6);
        
        JButton btnNewButton_2 = new JButton("Confirm");
        btnNewButton_2.setBounds(223, 260, 122, 42);
        card5.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		/*
       		 This action listener will take the input from input field,
       		 check if empty or not, if the entered amount and account number are 
       		 valid or not. If valid then will deduct from account1 and add it to account2 in balance else
       		 send the corresponding error message to the user.
       		 */
        		String input1=textField_4.getText();
        		String input2=textField_5.getText();
        		String input3=textField_6.getText();
        		
        		if(input1.isEmpty() || input2.isEmpty() || input3.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Field cannot be empty!!!");
        		}else if(!(input1.matches("[0-9]+"))) {
        			JOptionPane.showMessageDialog(null, "Account Number must have only numbers");
        		}else if(!(input2.matches("[0-9]+"))) {
        			JOptionPane.showMessageDialog(null, "Account Number must have only numbers");
        		} else if(!(input3.matches("[0-9]+"))) {
            		JOptionPane.showMessageDialog(null, "Amount must be in numbers!!!");
            	}	
        		else {
    				Boolean sender=false,receiver=false;
    				Account account1 = null,account2=null;
        		
        			int amount=Integer.parseInt(input3);
        			if(amount<0) {
        				JOptionPane.showMessageDialog(null, "Invalid Amount");
        			}
        			else {
        			for(int i=0;i<=3;i++) {
        				if(data[i][2].equals(Integer.parseInt(input1))) {
        					sender=true;
        					account1 = accounts.get(i);
        					        				}
        				else if(i==3){
        					if(sender==false) {
        						JOptionPane.showMessageDialog(null, "Invalid Sender's Account Number");
            					break;
        					}
        					
        				}
        				if(data[i][2].equals(Integer.parseInt(input2))) {
        					receiver=true;
        					account2=accounts.get(i);
        				}
        				else if(i==3) {
        					if(receiver==false) {
        					JOptionPane.showMessageDialog(null, "Invalid Rceiver's Account Number");
        					break;
        					}
        				}
        				
        				if(sender && receiver) { 
        					if(account1.getBalance()<amount) {
        						JOptionPane.showMessageDialog(null, "Insuffecient Balance, transfer failed");
        						break;
        					}
        					else {
        						transfer.transfer(account1, account2, amount);
        						updateTable(accounts,model);
        						JOptionPane.showMessageDialog(null, "Amount Transferred sucessfully...");
        						break;
        					}
        					}
        				}
        		}}
        	}
        	
        });
        

        // Create buttons to switch between cards
        showAccountsCard = new JButton("Show Accounts");
        showAccountsCard.addActionListener(this);

        depositeCard = new JButton("Deposite");
        depositeCard.addActionListener(this);

        withdrawCard = new JButton("Withdraw");
        withdrawCard.addActionListener(this);
        
        transferCard = new JButton("Transfer");
        transferCard.addActionListener(this);
        
        // Add buttons to a panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showAccountsCard);
        buttonPanel.add(depositeCard);
        buttonPanel.add(withdrawCard);
        buttonPanel.add(transferCard);

        // Add cards panel and button panel to the frame
        getContentPane().add(cards, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        JPanel headPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) headPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setAlignOnBaseline(true);
        getContentPane().add(headPanel, BorderLayout.NORTH);
        
        JButton welcomeCard = new JButton("Home");
        welcomeCard.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == welcomeCard) {
                    cardLayout.show(cards, "card1");
                }
        	}
        });
        headPanel.add(welcomeCard);
        
        JLabel heading = new JLabel("Banking Application");
        heading.setFont(new Font("MV Boli", Font.BOLD, 20));
        heading.setBackground(new Color(0, 255, 255));
        headPanel.add(heading);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showAccountsCard) {
            cardLayout.show(cards, "card2");
        } else if (e.getSource() == depositeCard) {
            cardLayout.show(cards, "card3");
            textField.setText("");
            textField_1.setText("");
        } else if (e.getSource() == withdrawCard) {
            cardLayout.show(cards, "card4");
            textField_2.setText("");
            textField_3.setText("");
        } else if (e.getSource() == transferCard) {
            cardLayout.show(cards, "card5");
            textField_4.setText("");
            textField_5.setText("");
            textField_6.setText("");
        }
        
    }
}

public class Main{
	public static void main(String[] args) {			
		String file="Accounts.csv";
    	try {
    	//object of ReadAccounts Class
    	ReadAccounts readAccounts = new ReadAccounts(file);
    	
    	//list to store firstNames, lastNames, account number and balance
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
    	
    	//make and run GUI visible
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
			public void run() {
				GUI frame = new GUI(accounts);
				frame.setVisible(true);
			}});
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}	
	}
}
/*
 Code by: 	Pujan Upadhyay
 			np03cs4a230284
 			2408612
 */