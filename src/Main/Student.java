package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField titleFild;
	private static JTextField authorNameFild;
	private static JTextField costFild;
	private static JTable table;
	private static JTable orderTable;
	private static JTable bookTable;
	private static JTable table2;
	private static JTextField nameFild; 
	private static JTextField qntFild; 
	private static JTextField priceFild; 
	public static String name;
	public static Integer price ; 
	public static Integer qty;
	private static JTextField textField_4;
	private static	int bookInt;
	private static JLabel titleLbl;
	private static JLabel authorLbl;
	private static JLabel costLbl;
	static String  currentDate ;
	static String  afterTenDate ;
	static String studentId;
	static String  studentName;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(int studentLoginStatus) {
		if(studentLoginStatus >0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Student frame = new Student();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public Student() throws NumberFormatException, Exception {
		studentId = Login.studentId;
		getStudentDetail(Integer.parseInt(studentId));
		
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 694);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 235, 255));
		panel.setBounds(0, 0, 943, 694);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime afterTenDay = LocalDateTime.now().plusDays(10);
		currentDate = dtf.format(now);
		afterTenDate = dtf.format(afterTenDay);
		
//		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 177, 943, 517);
		panel.add(panel_1);
		panel_1.setLayout(null);
		bookManage(panel_1);
		panel_1.setVisible(false);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 177, 943, 517);
		panel.add(panel_2);
		panel_2.setLayout(null);
		dashboard(panel_2);
		panel_2.setVisible(false);
		panel_2.setVisible(true);
		
		
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setBackground(new Color(193, 235, 255));
		lblNewLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(868, 11, 65, 22);
		panel.add(lblNewLabel2);
		
		ImageIcon closeIcon = new ImageIcon(Login.class.getResource("/icon/3917189.png"));
		Image  newCloseIconImage = closeIcon.getImage();
		Image newCloseIconImageResize = newCloseIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel2.setIcon(new ImageIcon(newCloseIconImageResize));
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(119, 187, 255));
		btnNewButton.setFont(new Font("Raleway SemiBold", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton.setBounds(65, 120, 155, 31);
		panel.add(btnNewButton);
		
		JButton btnOrder = new JButton(" Order Book");
		btnOrder.setForeground(new Color(255, 255, 255));
		btnOrder.setBackground(new Color(119, 187, 255));
		btnOrder.setFont(new Font("Raleway SemiBold", Font.PLAIN, 16));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		btnOrder.setBounds(272, 120, 155, 31);
		panel.add(btnOrder);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(119, 187, 255));
		btnLogout.setFont(new Font("Raleway SemiBold", Font.PLAIN, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login.main(null);
			}
		});
		btnLogout.setBounds(734, 120, 155, 31);
		panel.add(btnLogout);
		
		JLabel lblNewLabel_2 = new JLabel("Library Management System");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 28, 923, 52);
		panel.add(lblNewLabel_2);
		
		JButton btnRefresh = new JButton("Refresh ");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				int StudentLoginStatus;
				Student.main(StudentLoginStatus=1);
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Raleway SemiBold", Font.PLAIN, 16));
		btnRefresh.setBackground(new Color(119, 187, 255));
		btnRefresh.setBounds(502, 120, 155, 31);
		panel.add(btnRefresh);
		
		
		
	}
	public static void dashboard(JPanel panel_1) throws ClassNotFoundException, SQLException {
		JLabel lblNewLabel = new JLabel("Student Dashboard");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Raleway SemiBold", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 21, 923, 54);
		panel_1.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Student Id : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(33, 114, 125, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(studentId);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(176, 114, 208, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(studentName);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(176, 148, 208, 30);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Student Name : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(33, 148, 125, 30);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(currentDate);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(176, 182, 208, 30);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(33, 182, 125, 30);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Student Details ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBounds(33, 84, 160, 30);
		panel_1.add(lblNewLabel_1_2_1_1);
		panel_1.setVisible(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(193, 235, 255));
		panel_2.setBounds(33, 240, 871, 266);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 851, 200);
		panel_2.add(scrollPane);
		
		
		
		
		orderTable = new JTable();
		orderTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row =orderTable.getSelectedRow();
				DefaultTableModel orderModel = (DefaultTableModel) orderTable.getModel();
				bookInt = Integer.parseInt(orderModel.getValueAt(row, 0).toString());
			}
		});
		DefaultTableModel orderModel= (DefaultTableModel) orderTable.getModel();
		orderTable(orderModel,studentId);
		scrollPane.setViewportView(orderTable);
		
		JLabel lblBookList = new JLabel(" Order Book List");
		lblBookList.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookList.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBookList.setBounds(10, 11, 851, 40);
		panel_2.add(lblBookList);
		
	}
	
	public static void bookManage(JPanel panel_1) throws ClassNotFoundException, SQLException {
		JLabel lblNewLabel = new JLabel("Order Book");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Raleway SemiBold", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 21, 923, 54);
		panel_1.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Student Id : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(551, 130, 125, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(studentId);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(694, 130, 208, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(studentName);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(694, 164, 208, 30);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Student Name : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(551, 164, 125, 30);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(currentDate);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(694, 198, 208, 30);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Issue Date :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(551, 198, 125, 30);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel(afterTenDate);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(694, 238, 208, 30);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Expire Date :");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(551, 238, 125, 30);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Book Details ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(551, 277, 160, 30);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Student Details ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBounds(551, 100, 160, 30);
		panel_1.add(lblNewLabel_1_2_1_1);
		panel_1.setVisible(true);
		
		
		titleLbl = new JLabel("Tittle ");
		titleLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLbl.setBounds(551, 318, 125, 30);
		panel_1.add(titleLbl);
		
		titleFild = new JTextField();
		titleFild.setBounds(694, 320, 208, 30);
		panel_1.add(titleFild);
		titleFild.setColumns(10);
		
		authorNameFild = new JTextField();
		authorNameFild.setColumns(10);
		authorNameFild.setBounds(694, 361, 208, 30);
		panel_1.add(authorNameFild);
		
		authorLbl = new JLabel("Author Name");
		authorLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		authorLbl.setBounds(551, 359, 125, 30);
		panel_1.add(authorLbl);
		
		costFild = new JTextField();
		costFild.setColumns(10);
		costFild.setBounds(694, 402, 208, 30);
		panel_1.add(costFild);
		
		
		costLbl = new JLabel("Cost");
		costLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		costLbl.setBounds(551, 402, 125, 30);
		panel_1.add(costLbl);
		
		JButton createBtn = new JButton("Submit");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleFild.getText();
				String author = authorNameFild.getText();
				int cost = Integer.parseInt( costFild.getText()) ;
				try {
					int id = bookInt;
					if(id >=0) {
						DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
						orderSave(id,cost,studentId,currentDate,afterTenDate);
						bookInt = -1;
						titleFild.setText( " ");
						authorNameFild.setText(" ");
						costFild.setText(" "); 
						model.setRowCount(0);
						bookTable(model);
						DefaultTableModel orderModel = (DefaultTableModel) orderTable.getModel();
						orderModel.setRowCount(0);
						orderTable(orderModel,studentId);
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		createBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createBtn.setBounds(805, 459, 97, 30);
		panel_1.add(createBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(193, 235, 255));
		panel_2.setBounds(33, 100, 466, 389);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 446, 313);
		panel_2.add(scrollPane);
		
		
		
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row =bookTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
				bookInt = Integer.parseInt(model.getValueAt(row, 0).toString());
				titleFild.setText( model.getValueAt(row, 1).toString());
				authorNameFild.setText(model.getValueAt(row, 2).toString());
				costFild.setText(model.getValueAt(row, 3).toString());
			}
		});
		DefaultTableModel model= (DefaultTableModel) bookTable.getModel();
		bookTable(model);
		scrollPane.setViewportView(bookTable);
		
		JLabel lblBookList = new JLabel(" Book List");
		lblBookList.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookList.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBookList.setBounds(105, 11, 270, 40);
		panel_2.add(lblBookList);
		
		JButton editBtn = new JButton("Reset");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = bookInt;
				if(id >=0) {
					try {
						bookInt = -1;
						titleFild.setText( " ");
						authorNameFild.setText(" ");
						costFild.setText(" "); 
						model.setRowCount(0);
						bookTable(model);
						
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		editBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editBtn.setBounds(698, 459, 97, 30);
		panel_1.add(editBtn);
		
	}
	

	public static void getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emonProject", "root", "");
		Statement str = con.createStatement();
		String sql ="CREATE TABLE PRODUCTS" +
					"(id int not NULL AUTO_INCREMENT,"+
					"name VARCHAR(255),"+
					"price int ,"+
					"quntity int,"+
					"update_at TIMESTAMP default CURRENT_TIMESTAMP ," +
					"PRIMARY KEY (id))";
		str.executeUpdate(sql);
	}
	public static Connection getCont() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niloyproject", "root", "");
		return con;
	}

	public static void bookSave(String title, String author,int cost, int qty ) throws ClassNotFoundException, SQLException {
		Connection con = getCont();
		PreparedStatement pr = con.prepareStatement("insert into book (title, author_name, price, quantity) values(?,?,?,?)");
							pr.setString(1, title);
							pr.setString(2, author);
							pr.setInt(3, cost);
							pr.setInt(4, qty);
							pr.executeUpdate();

	} 
	
		public static void orderSave(int bookId, int cost, String studentId2,String currentDate, String afterTenDate  ) throws ClassNotFoundException, SQLException {
		Connection con = getCont();
		PreparedStatement pr = con.prepareStatement("insert into orders (student_id, book_id, price, issue_date, expire_date) values(?,?,?,?,?)");
							pr.setInt(1, Integer.parseInt(studentId2));
							pr.setInt(2, bookId);
							pr.setInt(3, cost);
							pr.setString(4, currentDate);
							pr.setString(5, afterTenDate);
							pr.executeUpdate();
	
	} 
	
	public static ResultSet bookGet() throws ClassNotFoundException, SQLException {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("select * from book ");
				ResultSet rs = 	pr.executeQuery();
				
				return rs;

	} 

	public static ResultSet orderGet(String studentId2) throws ClassNotFoundException, SQLException {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("select * from orders where student_id =? ");
				pr.setInt(1, Integer.parseInt(studentId2));
				ResultSet rs = 	pr.executeQuery();
				
				return rs;

	} 
	
	
	public static void bookUpdate(int id, String title, String author,int cost, int qty) throws ClassNotFoundException, SQLException {
		Connection con = getCont();
		PreparedStatement pr = con.prepareStatement("update book set title=? , author_name=?, price=?,quantity=? where id=?");
							pr.setString(1, title);
							pr.setString(2, author);
							pr.setInt(3, cost);
							pr.setInt(4, qty);
							pr.setInt(5, id);
							pr.executeUpdate();

	} 
	
	
	public static void bookTable(DefaultTableModel model) throws ClassNotFoundException, SQLException {
		ResultSet rs = bookGet();
		
		String colName[] = {"id","Title","Author Name", "Price", "Quantity"};
		String id, nm, qn,pr,aut,qty;
		model.setColumnIdentifiers(colName);
		while(rs.next())
		{
			id = rs.getString("id");
			nm = rs.getString("title"); 
			aut = rs.getString("author_name");
			pr = rs.getString("price");
			qty = rs.getString("quantity");
			String rows[] = {id,nm,aut,pr,qty};
			model.addRow(rows); 
		}
	}
	
	
	public static void bookDelete(int id) throws ClassNotFoundException, SQLException {
		Connection con = getCont();
		PreparedStatement pr = con.prepareStatement("delete from book where id=?");
							pr.setInt(1, id);
							pr.executeUpdate();

	} 
	

	public static int getStudentDetail(int id) throws Exception {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("Select *from students where id=?");
		pr.setString(1, studentId);
		
		ResultSet rs = pr.executeQuery();
		int count =0;
		while(rs.next())
		{
			studentId = rs.getString("id");
			studentName = rs.getString("name");
			count++;
		}
		return count;
		
	}
	
	public static String orderBookDetail(int id) throws ClassNotFoundException, SQLException {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("select * from book where id=?");
		pr.setInt(1, id);
		ResultSet rs = pr.executeQuery();
		String bookName = null;
		while(rs.next())
		{
			bookName = rs.getString("title");
			
		}
		return bookName;
	} 
	
	public static void orderTable(DefaultTableModel model,String studentId) throws ClassNotFoundException, SQLException {
		ResultSet rs = orderGet(studentId);
		
		String colName[] = {"id","Title", "Price", "Issue Date", "Expire Date","Status"};
		String id, price,issue_date,expire_date,statusData,bookname;
		int book_id;
		int status;
		model.setColumnIdentifiers(colName);
		while(rs.next())
		{
			id = rs.getString("id");
			book_id = Integer.parseInt(rs.getString("book_id")); 
			price = rs.getString("price");
			issue_date = rs.getString("issue_date");
			expire_date = rs.getString("expire_date");
			
			bookname =orderBookDetail(book_id); 
//			bookname ="";
			
			status = Integer.parseInt(rs.getString("status"));
			if(status!=0) {
				 statusData = "Approved";
			}
			else
			{
				 statusData = "Not Approved";
			}
				
				
			String rows[] = {id, bookname,price,issue_date,expire_date,statusData};
			model.addRow(rows); 
		}
	}
}
