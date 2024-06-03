import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GUInterface extends JFrame implements ActionListener {

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
    private JTable table;

    public GUInterface() {
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
        Object[][] data = {{"John", "Doe", "12345", "$1000"}, {"Jane", "Smith", "54321", "$2000"}};
        JTable table = new JTable(data, columnNames);

        // Set table background color
        table.setBackground(new Color(235, 247, 254));

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

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
        } else if (e.getSource() == withdrawCard) {
            cardLayout.show(cards, "card4");
        }
        else if (e.getSource() == transferCard) {
            cardLayout.show(cards, "card5");
        }
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUInterface().setVisible(true);
            }
        });
    }
}
