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

public class EmergencyInfo extends JFrame {
	
	private Image emergency = new ImageIcon(PersonalInfo.class.getResource("logo/emergency contact.png")).getImage().getScaledInstance(70,60, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	public static JTextField txtEmpId;

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
	public EmergencyInfo(Connection objConn) {
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
		lblName.setBounds(37, 142, 158, 63);
		contentPane.add(lblName);
		
		JLabel lblPersonalInfo = new JLabel("EMERGENCY CONTACT INFORMATION");
		lblPersonalInfo.setForeground(new Color(255, 255, 255));
		lblPersonalInfo.setFont(new Font("RockoFLF", Font.PLAIN, 25));
		lblPersonalInfo.setBounds(251, 38, 530, 63);
		contentPane.add(lblPersonalInfo);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblAddress.setBounds(37, 173, 158, 63);
		contentPane.add(lblAddress);
		
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
		
		txtName.setBounds(251, 152, 511, 28);
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
		txtAddress.setBounds(251, 191, 511, 28);
		contentPane.add(txtAddress);
		
		JLabel lblRelationship = new JLabel("RELATIONSHIP");
		lblRelationship.setForeground(new Color(255, 255, 255));
		lblRelationship.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblRelationship.setBounds(37, 273, 158, 63);
		contentPane.add(lblRelationship);
		
		JComboBox cmbRelation = new JComboBox();
		cmbRelation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cmbRelation.setModel(new DefaultComboBoxModel(new String[] {"Family", "Friend", "Acquaintance", "Romantic"}));
		cmbRelation.setBounds(251, 291, 207, 25);
		contentPane.add(cmbRelation);
		
		JLabel lblPhone = new JLabel("PHONE NUMBER");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPhone.setBounds(37, 216, 158, 63);
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
		txtPhone.setBounds(251, 234, 256, 28);
		contentPane.add(txtPhone);
		
		JButton btnDone = new JButton("DONE");
		btnDone.setForeground(SystemColor.text);
		btnDone.setBackground(SystemColor.controlDkShadow);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strDriver = "com.mysql.cj.jdbc.Driver";
		        String strConn = "jdbc:mysql://localhost:3306/Employee_Information";
		        String strUser = "deificz";
		        String strPass = "pass123";
		        
		        
		        String Name = txtName.getText();
		        String Address = txtAddress.getText();
		        String PrimaryPhone =txtPhone.getText();
		        String Relation = (String)cmbRelation.getSelectedItem();
		        String EmpId = txtEmpId.getText();
		        
		        try {        
		            Class.forName(strDriver);
		            Connection objConn = DriverManager.getConnection(strConn, strUser, strPass);   
		            System.out.println("Successfully connected to the database server..");
		            
		            String database = "INSERT INTO Emergency_Information VALUE (?, ?, ?, ?, ?)";
		            PreparedStatement prstmt = objConn.prepareStatement(database);
		            prstmt.setString(1, Name);
		            prstmt.setString(2, Address);
		            prstmt.setLong(3, Long.parseLong(PrimaryPhone));
		            prstmt.setString(4, Relation);
		            prstmt.setString(5, EmpId);
		            
		            prstmt.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Thank you!");
		            EmergencyInfo.this.dispose();
		            objConn.close();
		        } catch (Exception objEx) {
		            System.out.println("Problem retrieving information..");
		            System.out.println(objEx);
		            JOptionPane.showMessageDialog(null, "Please Fill and Check all the Requirements");
		        }
			}
		});
		btnDone.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		btnDone.setBounds(322, 435, 266, 59);
		contentPane.add(btnDone);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Confirmation", JOptionPane.YES_NO_OPTION)==0) 
					EmergencyInfo.this.dispose();
			}
			public void mouseEntered(MouseEvent e) {
				lblClose.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {		
				lblClose.setForeground(Color.WHITE);
			}
		});
		lblClose.setBackground(SystemColor.desktop);
		lblClose.setForeground(SystemColor.desktop);
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClose.setBounds(822, 11, 14, 27);
		contentPane.add(lblClose);
		
		txtEmpId = new JTextField();
		txtEmpId.setVisible(false);
		txtEmpId.setBounds(37, 38, 86, 20);
		contentPane.add(txtEmpId);
		txtEmpId.setColumns(10);
		
		JLabel lblEmerg = new JLabel("");
		lblEmerg.setBounds(177, 28, 158, 89);
		lblEmerg.setIcon(new ImageIcon(emergency));
		contentPane.add(lblEmerg);
	}
}
