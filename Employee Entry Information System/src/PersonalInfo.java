import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class PersonalInfo extends JFrame {

	private Image personal = new ImageIcon(PersonalInfo.class.getResource("logo/personal.png")).getImage().getScaledInstance(90,90, Image.SCALE_SMOOTH);
	
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtGovId;
	private JTextField txtBirthDate;
	private JTextField txtSpouseName;
	private JTextField txtPhone;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo frame = new PersonalInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonalInfo() {
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 599);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("FULL NAME");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblName.setBounds(37, 147, 158, 63);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblAddress.setBounds(37, 180, 158, 63);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("E-MAIL ADDRESS");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblEmail.setBounds(37, 266, 158, 63);
		contentPane.add(lblEmail);
		
		JLabel lblGovId = new JLabel("SSS ID/GOVERNMENT ID");
		lblGovId.setForeground(new Color(255, 255, 255));
		lblGovId.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblGovId.setBounds(37, 311, 224, 63);
		contentPane.add(lblGovId);
		
		JLabel lblBirthdate = new JLabel("BIRTH DATE");
		lblBirthdate.setForeground(new Color(255, 255, 255));
		lblBirthdate.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblBirthdate.setBounds(37, 359, 158, 63);
		contentPane.add(lblBirthdate);
		
		JLabel lblSpouseName = new JLabel("SPOUSE'S NAME");
		lblSpouseName.setForeground(new Color(255, 255, 255));
		lblSpouseName.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSpouseName.setBounds(37, 404, 158, 63);
		contentPane.add(lblSpouseName);
		
		txtName = new JTextField();
		txtName.setText("Last Name , First Name , Middle Name");
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtName.getText().equals("Last Name , First Name , Middle Name")) 
					txtName.setText("");
				else
					txtName.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtName.getText().equals(""))
					txtName.setText("Last Name , First Name , Middle Name");
			}
		});
		
		txtName.setBounds(251, 159, 511, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("Street Address , Barangay , City , State , Zip Code");
		txtAddress.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtAddress.getText().equals("Street Address , Barangay , City , State , Zip Code")) 
					txtAddress.setText("");
				else
					txtAddress.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtAddress.getText().equals(""))
					txtAddress.setText("Street Address , Barangay , City , State , Zip Code");
			}
		});
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(251, 198, 511, 28);
		contentPane.add(txtAddress);
		
		txtEmail = new JTextField();
		txtEmail.setText("ex. juan_delacruz@yahoo.com");
		txtEmail.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtEmail.getText().equals("ex. juan_delacruz@yahoo.com")) 
					txtEmail.setText("");
				else
					txtEmail.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().equals(""))
					txtEmail.setText("ex. juan_delacruz@yahoo.com");
			}
		});
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(251, 284, 511, 28);
		contentPane.add(txtEmail);
		
		txtGovId = new JTextField();
		txtGovId.setText("ex. N1C356589");
		txtGovId.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtGovId.getText().equals("ex. N1C356589")) 
					txtGovId.setText("");
				else
					txtGovId.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtGovId.getText().equals(""))
					txtGovId.setText("ex. N1C356589");
			}
		});
		txtGovId.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtGovId.setColumns(10);
		txtGovId.setBounds(251, 329, 511, 28);
		contentPane.add(txtGovId);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setText("ex. 2001-05-08");
		txtBirthDate.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtBirthDate.getText().equals("ex. 2001-05-08")) 
					txtBirthDate.setText("");
				else
					txtBirthDate.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtBirthDate.getText().equals(""))
					txtBirthDate.setText("ex. 2001-05-08");
			}
		});
		txtBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBirthDate.setColumns(10);
		txtBirthDate.setBounds(143, 377, 256, 28);
		contentPane.add(txtBirthDate);
		
		JLabel lblMaritalStatus = new JLabel("MARITAL STATUS");
		lblMaritalStatus.setForeground(new Color(255, 255, 255));
		lblMaritalStatus.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblMaritalStatus.setBounds(409, 359, 158, 63);
		contentPane.add(lblMaritalStatus);
		
		txtSpouseName = new JTextField();
		txtSpouseName.setText("Last Name , First Name , Middle Name (If NONE Type N/A)");
		txtSpouseName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtSpouseName.getText().equals("Last Name , First Name , Middle Name (If NONE Type N/A)")) 
					txtSpouseName.setText("");
				else
					txtSpouseName.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtSpouseName.getText().equals(""))
					txtSpouseName.setText("Last Name , First Name , Middle Name (If NONE Type N/A)");
			}
		});
		txtSpouseName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSpouseName.setColumns(10);
		txtSpouseName.setBounds(251, 422, 511, 28);
		contentPane.add(txtSpouseName);
		
		JComboBox cmbMarital = new JComboBox();
		cmbMarital.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cmbMarital.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married", "Separated", "Divorced", "Widowed"}));
		cmbMarital.setBounds(555, 377, 207, 25);
		contentPane.add(cmbMarital);
		
		JLabel lblPhone = new JLabel("PHONE NUMBER");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPhone.setBounds(37, 221, 158, 63);
		contentPane.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setText("ex. 639215443342");
		txtPhone.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtPhone.getText().equals("ex. 639215443342")) 
					txtPhone.setText("");
				else
					txtPhone.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtPhone.getText().equals(""))
					txtPhone.setText("ex. 639215443342");
			}
		});
		txtPhone.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtPhone.setColumns(10);
		txtPhone.setBounds(251, 237, 511, 28);
		contentPane.add(txtPhone);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(SystemColor.text);
		btnNext.setBackground(SystemColor.controlDkShadow);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strDriver = "com.mysql.cj.jdbc.Driver";
		        String strConn = "jdbc:mysql://localhost:3306/Employee_Information";
		        String strUser = "deificz";
		        String strPass = "pass123";
		        
		        String GovId = txtGovId.getText();
		        String Name = txtName.getText();
		        String Address = txtAddress.getText();
		        String HomePhone =txtPhone.getText();
		        String Email = txtEmail.getText();
		        String Birthdate = txtBirthDate.getText();
		        String MaritalStatus = (String)cmbMarital.getSelectedItem();
		        String SpouseName = txtSpouseName.getText();
	
		        
		        try {        
		            Class.forName(strDriver);
		            Connection objConn = DriverManager.getConnection(strConn, strUser, strPass);   
		            System.out.println("Successfully connected to the database server..");
		            
		            String database = "INSERT INTO Personal_Information VALUE (?, ?, ?, ?, ?, ?, ?,?)";
		            PreparedStatement prstmt = objConn.prepareStatement(database);
		            prstmt.setString(1, GovId);
		            prstmt.setString(2, Name);
		            prstmt.setString(3, Address);
		            prstmt.setLong(4, Long.parseLong(HomePhone));
		            prstmt.setString(5, Email);
		            prstmt.setString(6, Birthdate);
		            prstmt.setString(7, MaritalStatus);
		            prstmt.setString(8, SpouseName);
		 
		            
		            prstmt.executeUpdate();
		            
		            JobInfo jobInfo = new JobInfo(objConn);
		            jobInfo.txtGovId.setText(GovId);
		            jobInfo.setVisible(true);
		            PersonalInfo.this.dispose();
		            objConn.close();
		        } catch (Exception objEx) {
		            System.out.println("Problem retrieving information..");
		            System.out.println(objEx);
		            JOptionPane.showMessageDialog(null, "Please Fill and Check all the Requirements");
		        }
			}
		});
		btnNext.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		btnNext.setBounds(305, 476, 266, 59);
		contentPane.add(btnNext);
		
		JLabel lblpersonal = new JLabel("");
		lblpersonal.setBounds(228, 34, 199, 79);
		contentPane.add(lblpersonal);
		lblpersonal.setIcon(new ImageIcon(personal));
		
		JLabel lblPersonalInfo = new JLabel("PERSONAL INFORMATION");
		lblPersonalInfo.setFont(new Font("RockoFLF", Font.PLAIN, 25));
		lblPersonalInfo.setForeground(new Color(255, 255, 255));
		lblPersonalInfo.setBounds(329, 51, 321, 60);
		contentPane.add(lblPersonalInfo);
		
		textField = new JTextField();
		textField.setBounds(251, 124, -5, -4);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
