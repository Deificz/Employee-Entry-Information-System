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

public class JobInfo extends JFrame {
	private Image job = new ImageIcon(PersonalInfo.class.getResource("logo/job.png")).getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH);
	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtEmployeeId;
	private JTextField txtEmail;
	private JTextField txtWorkLocation;
	private JTextField txtWorkPhone;
	private JTextField txtStartDate;
	private JTextField txtSalary;
	private JTextField txtSupervisor;
	private JTextField txtDepartment;
	public static JTextField txtGovId;
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
	public JobInfo(Connection objConn) {
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
		
		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTitle.setBounds(37, 131, 158, 63);
		contentPane.add(lblTitle);
		
		JLabel lbJobInfo = new JLabel("JOB INFORMATION");
		lbJobInfo.setForeground(new Color(255, 255, 255));
		lbJobInfo.setFont(new Font("RockoFLF", Font.PLAIN, 25));
		lbJobInfo.setBounds(355, 51, 422, 63);
		contentPane.add(lbJobInfo);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setForeground(new Color(255, 255, 255));
		lblEmployeeId.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblEmployeeId.setBounds(37, 174, 158, 63);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmailAddress = new JLabel("WORK E-MAIL ADDRESS");
		lblEmailAddress.setForeground(new Color(255, 255, 255));
		lblEmailAddress.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblEmailAddress.setBounds(37, 261, 204, 63);
		contentPane.add(lblEmailAddress);
		
		JLabel lblWorkLocation = new JLabel("WORK LOCATION");
		lblWorkLocation.setForeground(new Color(255, 255, 255));
		lblWorkLocation.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblWorkLocation.setBounds(37, 303, 224, 63);
		contentPane.add(lblWorkLocation);
		
		JLabel lblWorkPhone = new JLabel("WORK PHONE NUMBER");
		lblWorkPhone.setForeground(new Color(255, 255, 255));
		lblWorkPhone.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblWorkPhone.setBounds(37, 348, 204, 43);
		contentPane.add(lblWorkPhone);
		
		JLabel lblStartDate = new JLabel("START DATE");
		lblStartDate.setForeground(new Color(255, 255, 255));
		lblStartDate.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblStartDate.setBounds(37, 397, 158, 28);
		contentPane.add(lblStartDate);
		
		JLabel lblSalary = new JLabel("SALARY");
		lblSalary.setForeground(new Color(255, 255, 255));
		lblSalary.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSalary.setBounds(37, 417, 158, 63);
		contentPane.add(lblSalary);
		
		txtTitle = new JTextField();
		txtTitle.setText("ex. Manager");
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTitle.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtTitle.getText().equals("ex. Manager")) 
					txtTitle.setText("");
				else
					txtTitle.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtTitle.getText().equals(""))
					txtTitle.setText("ex. Manager");
			}
		});
		
		txtTitle.setBounds(251, 149, 511, 28);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setText("ex. 2019-07170-MN-0");
		txtEmployeeId.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtEmployeeId.getText().equals("ex. 2019-07170-MN-0")) 
					txtEmployeeId.setText("");
				else
					txtEmployeeId.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtEmployeeId.getText().equals(""))
					txtEmployeeId.setText("ex. 2019-07170-MN-0");
			}
		});
		txtEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(251, 192, 511, 28);
		contentPane.add(txtEmployeeId);
		
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
		txtEmail.setBounds(251, 279, 511, 28);
		contentPane.add(txtEmail);
		
		txtWorkLocation = new JTextField();
		txtWorkLocation.setText("ex. Makati City");
		txtWorkLocation.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtWorkLocation.getText().equals("ex. Makati City")) 
					txtWorkLocation.setText("");
				else
					txtWorkLocation.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtWorkLocation.getText().equals(""))
					txtWorkLocation.setText("ex. Makati City");
			}
		});
		txtWorkLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtWorkLocation.setColumns(10);
		txtWorkLocation.setBounds(251, 317, 511, 28);
		contentPane.add(txtWorkLocation);
		
		txtWorkPhone = new JTextField();
		txtWorkPhone.setText("ex. 639123456789");
		txtWorkPhone.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtWorkPhone.getText().equals("ex. 639123456789")) 
					txtWorkPhone.setText("");
				else
					txtWorkPhone.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtWorkPhone.getText().equals(""))
					txtWorkPhone.setText("ex. 639123456789");
			}
		});
		txtWorkPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtWorkPhone.setColumns(10);
		txtWorkPhone.setBounds(250, 356, 512, 28);
		contentPane.add(txtWorkPhone);
		
		txtStartDate = new JTextField();
		txtStartDate.setText("ex. 2001-05-08");
		txtStartDate.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtStartDate.getText().equals("ex. 2001-05-08")) 
					txtStartDate.setText("");
				else
					txtStartDate.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtStartDate.getText().equals(""))
					txtStartDate.setText("ex. 2001-05-08");
			}
		});
		txtStartDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStartDate.setColumns(10);
		txtStartDate.setBounds(251, 397, 511, 28);
		contentPane.add(txtStartDate);
		
		txtSalary = new JTextField();
		txtSalary.setText("ex. 20000");
		txtSalary.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtSalary.getText().equals("ex. 20000")) 
					txtSalary.setText("");
				else
					txtSalary.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtSalary.getText().equals(""))
					txtSalary.setText("ex. 20000");
			}
		});
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSalary.setColumns(10);
		txtSalary.setBounds(251, 435, 511, 28);
		contentPane.add(txtSalary);
		
		JLabel lblSupervisor = new JLabel("SUPERVISOR");
		lblSupervisor.setForeground(new Color(255, 255, 255));
		lblSupervisor.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSupervisor.setBounds(37, 217, 158, 63);
		contentPane.add(lblSupervisor);
		
		txtSupervisor = new JTextField();
		txtSupervisor.setText("Last Name , First Name , Middle Name");
		txtSupervisor.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtSupervisor.getText().equals("Last Name , First Name , Middle Name")) 
					txtSupervisor.setText("");
				else
					txtSupervisor.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtSupervisor.getText().equals(""))
					txtSupervisor.setText("Last Name , First Name , Middle Name");
			}
		});
		txtSupervisor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSupervisor.setColumns(10);
		txtSupervisor.setBounds(144, 235, 266, 28);
		contentPane.add(txtSupervisor);
		
		JLabel lblDepartment = new JLabel("DEPARTMENT");
		lblDepartment.setForeground(new Color(255, 255, 255));
		lblDepartment.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDepartment.setBounds(420, 217, 158, 63);
		contentPane.add(lblDepartment);
		
		txtDepartment = new JTextField();
		txtDepartment.setText("ex. Department of Computer Science");
		txtDepartment.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtDepartment.getText().equals("ex. Department of Computer Science")) 
					txtDepartment.setText("");
				else
					txtDepartment.selectAll();
			}
			public void focusLost(FocusEvent e) {
				if(txtDepartment.getText().equals(""))
					txtDepartment.setText("ex. Department of Computer Science");
			}
		});
		txtDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(536, 235, 256, 28);
		contentPane.add(txtDepartment);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(SystemColor.text);
		btnNext.setBackground(SystemColor.controlDkShadow);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strDriver = "com.mysql.cj.jdbc.Driver";
		        String strConn = "jdbc:mysql://localhost:3306/Employee_Information";
		        String strUser = "deificz";
		        String strPass = "pass123";
		        
		        String EmployeeId = txtEmployeeId.getText();
		        String Title = txtTitle.getText();
		        String Supervisor = txtSupervisor.getText();
		        String Department =txtDepartment.getText();
		        String Email = txtEmail.getText();
		        String WorkLocation = txtWorkLocation.getText();
		        String WorkPhone = txtWorkPhone.getText();
		        String StartDate = txtStartDate.getText();
		        String Salary = txtSalary.getText();
		        String GovId = txtGovId.getText();
		        
		        try {        
		            Class.forName(strDriver);
		            Connection objConn = DriverManager.getConnection(strConn, strUser, strPass);   
		            System.out.println("Successfully connected to the database server..");
		                        
		            String database = "INSERT INTO Job_Information VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement prstmt = objConn.prepareStatement(database);
		            
		            prstmt.setString(1, EmployeeId);
		            prstmt.setString(2, Title);
		            prstmt.setString(3, Department);
		            prstmt.setString(4, Supervisor);
		            prstmt.setString(5, WorkLocation);
		            prstmt.setString(6, Email);
		            prstmt.setLong(7, Long.parseLong(WorkPhone));
		            prstmt.setString(8, StartDate);
		            prstmt.setFloat(9, Float.parseFloat(Salary));
		            prstmt.setString(10, GovId);

		            prstmt.executeUpdate();
		                      
		            EmergencyInfo emergencyInfo = new EmergencyInfo(objConn);
		            emergencyInfo.txtEmpId.setText(EmployeeId);
		            emergencyInfo.setVisible(true);
		            
		            JobInfo.this.dispose();
		    
		        
		            objConn.close();
		        } catch (Exception objEx) {
		            System.out.println("Problem retrieving information..");
		            System.out.println(objEx);
		            JOptionPane.showMessageDialog(null, "Please Fill and Check all the Requirements");
		        }
			}
		});
		btnNext.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		btnNext.setBounds(328, 490, 266, 59);
		contentPane.add(btnNext);
		
		txtGovId = new JTextField();
		txtGovId.setVisible(false);
		txtGovId.setBounds(10, 38, 86, 20);
		contentPane.add(txtGovId);
		txtGovId.setColumns(10);
		
		JLabel lblJob = new JLabel("");
		lblJob.setBounds(263, 38, 181, 97);
		contentPane.add(lblJob);
		lblJob.setIcon(new ImageIcon(job));
		
		textField = new JTextField();
		textField.setBounds(10, 11, -2, 0);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
