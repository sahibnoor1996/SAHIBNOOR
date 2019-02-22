package prabhjot.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import prabhjot.DBHelper;
import prabhjot.Customer;


public class AddCustomerWindow implements ActionListener
{
	JFrame fr;
	JLabel lblTitle,lblName,lblPhone,lblEmail;
	JTextField txtName,txtPhone,txtEmail;
	JButton btnAddCustomer;
	JPanel pnlTitle,pnlName,pnlPhone,pnlEmail,pnlButton,pnlAll;
	
	
	public AddCustomerWindow()
	{
		fr=new JFrame();
		fr.setTitle("Add customer");
		
lblTitle=new JLabel("Enter customer details");
lblName=new JLabel("Enter Customemr Name");
lblPhone=new JLabel("Enter Customer phone");

lblEmail=new JLabel();
lblEmail.setText("Enter Customer email");

txtName=new JTextField(16);
txtPhone=new JTextField(16);
txtEmail=new JTextField(16);


btnAddCustomer=new JButton("Add Customer");

btnAddCustomer.addActionListener(this);
	
pnlTitle=new JPanel();
pnlName=new JPanel();
pnlPhone=new JPanel();
pnlEmail=new JPanel();
pnlButton=new JPanel();
pnlAll=new JPanel();
	}
	
	
	public void showWindow()
	{
		pnlTitle.add(lblName);
		
		pnlName.add(lblName);
		pnlName.add(txtName);
		
		
		pnlPhone.add(lblPhone);
		pnlPhone.add(txtPhone);
		
		pnlEmail.add(lblEmail);
		pnlEmail.add(txtEmail);
		
		pnlButton.add(btnAddCustomer);
		
		
		
		pnlAll.add(pnlTitle);
		pnlAll.add(pnlName);
		pnlAll.add(pnlPhone);
		pnlAll.add(pnlEmail);
		pnlAll.add(pnlButton);
		
		GridLayout layout=new GridLayout(5,1);
		pnlAll.setLayout(layout);
		
		fr.add(pnlAll);
		
		fr.add(pnlAll);
		
		fr.setSize(400,400);
		fr.setVisible(true);
		
	}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==btnAddCustomer)	
	{
		Customer cRef=new Customer();
		cRef.name=txtName.getText();
		cRef.phone=txtPhone.getText();
		cRef.email=txtEmail.getText();
		System.out.println(cRef);
		
		DBHelper db=new DBHelper();
		db.createConnection();
		int i=db.addCustomerInDb(cRef);
		
		db.closeConnection();
		
		
		if(i>0) {
			System.out.println(">>" +cRef.name+ "Added"); 
			txtName.setText("");
			txtPhone.setText("");
			txtEmail.setText("");
			}
	else
	{
		System.out.println(">" +cRef.name+  "Not added");
	}
	
	}
}
}


	
	
	