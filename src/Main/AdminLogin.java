package Main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField emailFild;
	private JTextField passwordFild;
	private static String email,currentPass,password;
	public static int AdminLoginStatus =0;
	static String studentId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 694);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 630, 694);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 255, 255));
		lblNewLabel_3.setBounds(0, 94, 630, 600);
		panel.add(lblNewLabel_3); 
		ImageIcon backgroudImage = new ImageIcon(Login.class.getResource("/icon/6610.jpg"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(650, 600, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage));
		
		JLabel lblStudentPanel = new JLabel("Admin Panel");
		lblStudentPanel.setBounds(0, 49, 630, 63);
		panel.add(lblStudentPanel);
		lblStudentPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentPanel.setForeground(new Color(0, 0, 0));
		lblStudentPanel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
		lblStudentPanel.setBackground(new Color(0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(193, 235, 255));
		panel_1.setBounds(630, 0, 313, 694);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(235, 27, 65, 22);
		panel_1.add(lblNewLabel2);
		
		ImageIcon closeIcon = new ImageIcon(Login.class.getResource("/icon/3917189.png"));
		Image  newCloseIconImage = closeIcon.getImage();
		Image newCloseIconImageResize = newCloseIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel2.setIcon(new ImageIcon(newCloseIconImageResize));
		
		
		
		emailFild = new JTextField();
		emailFild.setBounds(27, 267, 273, 34);
		panel_1.add(emailFild);
		emailFild.setColumns(10);
		
		passwordFild = new JTextField();
		passwordFild.setBounds(27, 366, 273, 34);
		panel_1.add(passwordFild);
		passwordFild.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setBounds(25, 323, 230, 28);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(0, 111, 221));
		lblNewLabel_1_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 23));
		
		JButton login = new JButton("login");
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(0, 120, 240));
		login.setBounds(27, 432, 273, 34);
		panel_1.add(login);
		login.setFont(new Font("Raleway SemiBold", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setBounds(25, 228, 97, 28);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(new Color(0, 111, 221));
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 120, 240));
		lblNewLabel.setBackground(new Color(0, 120, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 126, 290, 47);
		panel_1.add(lblNewLabel);
		
		
		
		
		
		JLabel errorMassage = new JLabel("");
		errorMassage.setBounds(25, 215, 275, 14);
		panel_1.add(errorMassage);
		errorMassage.setForeground(new Color(255, 0, 0));
		errorMassage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = emailFild.getText();
				password = Password.passwordHash(passwordFild.getText()) ;
				try {
					AdminLoginStatus = loginCheck(email); 
					if(AdminLoginStatus == 1) {
						Dashboard.main(AdminLoginStatus);
						setVisible(false);
					}
					else if(AdminLoginStatus == 0)  errorMassage.setText("Email not pound");
					else errorMassage.setText("Password dos't match");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static Connection getCont() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niloyproject", "root", "");
		return con;
	}

	public static int loginCheck(String email ) throws Exception {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("Select *from admins where email=?");
		pr.setString(1, email);
		
		ResultSet rs = pr.executeQuery();
		int count =0;
		while(rs.next())
		{
			
			currentPass = rs.getString("password");
			studentId = rs.getString("id");
			count++;
		}
		
		if(count > 0) {
			if(currentPass.equals(password)) {
				AdminLoginStatus = 1 ; 
			
			}
			else {
				AdminLoginStatus = 2;
				studentId = " ";
			}
		}
		else AdminLoginStatus = 0;
		
		return AdminLoginStatus ;
	}
	
	
}
