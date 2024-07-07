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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int StudentLoginStatus =0;
	static String studentId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
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
		panel.setBounds(0, 0, 943, 694);
		contentPane.add(panel);
		panel.setLayout(null);
		
		

		
		JLabel lblStudentPanel = new JLabel("Library Management System");
		lblStudentPanel.setBounds(10, 51, 923, 63);
		panel.add(lblStudentPanel);
		lblStudentPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentPanel.setForeground(new Color(0, 0, 0));
		lblStudentPanel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 32));
		lblStudentPanel.setBackground(new Color(0, 0, 0));
		
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(264, 536, 147, 110);
		panel.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Student Panel");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 82, 127, 22);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setBackground(Color.CYAN);
		lblNewLabel_3_1.setBounds(33, 11, 85, 60);
		panel_2.add(lblNewLabel_3_1);
		ImageIcon backgroudImage3 = new ImageIcon(Dashboard.class.getResource("/icon/student.png"));
		Image newBackgroudImage3 = backgroudImage3.getImage();
		Image resizeNewBackgroudImage3 = newBackgroudImage3.getScaledInstance(85, 60, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3_1.setIcon(new ImageIcon(resizeNewBackgroudImage3));
		
		
		
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin.main(null);
				setVisible(false);
			}
		});
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(421, 536, 147, 110);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Admin Panel");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 81, 127, 19);
		panel_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBackground(Color.CYAN);
		lblNewLabel_3_1_1.setBounds(32, 10, 85, 60);
		panel_2_1.add(lblNewLabel_3_1_1);
		ImageIcon backgroudImage2 = new ImageIcon(Dashboard.class.getResource("/icon/admin.png"));
		Image newBackgroudImage2 = backgroudImage2.getImage();
		Image resizeNewBackgroudImage2 = newBackgroudImage2.getScaledInstance(85, 60, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3_1_1.setIcon(new ImageIcon(resizeNewBackgroudImage2));
		
		
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(868, 27, 65, 22);
		panel.add(lblNewLabel2);
		
		ImageIcon closeIcon = new ImageIcon(Login.class.getResource("/icon/3917189.png"));
		Image  newCloseIconImage = closeIcon.getImage();
		Image newCloseIconImageResize = newCloseIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel2.setIcon(new ImageIcon(newCloseIconImageResize));
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 255, 255));
		lblNewLabel_3.setBounds(0, 101, 943, 582);
		panel.add(lblNewLabel_3); 
		ImageIcon backgroudImage = new ImageIcon(Login.class.getResource("/icon/mainpagebackgroung.png"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(943, 650, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage));
		
		
	}
}
