package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JTextField titleFild;
	private static JTextField authorNameFild;
	private static JTextField costFild;
	private static JTextField qtyFild;
	private static JTable table;
	private static JTable bookTable;
	private static JTable table2;
	private static JTextField nameFild; 
	private static JTextField qntFild; 
	private static JTextField priceFild; 
	public static String name;
	public static Integer price ; 
	public static Integer qty;
	public static String	orderId;
	private static JTextField orderIdFild;
	private static	int bookInt;
	private static	int	orderInt;

	/**
	 * Launch the application.
	 */
	public static void main(int AdminLoginStatus) {
		if(AdminLoginStatus >0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Dashboard frame = new Dashboard();
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Dashboard() throws ClassNotFoundException, SQLException {
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
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 177, 943, 517);
		panel.add(panel_1);
		panel_1.setLayout(null);
		bookManage(panel_1);
		panel_1.setVisible(true);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 177, 943, 517);
		panel.add(panel_2);
		panel_2.setLayout(null);
		orderManage(panel_2);
		panel_2.setVisible(false);
		
		
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
		
		JButton btnNewButton = new JButton("Add Book ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(119, 187, 255));
		btnNewButton.setFont(new Font("Raleway SemiBold", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		btnNewButton.setBounds(65, 120, 235, 31);
		panel.add(btnNewButton);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setForeground(new Color(255, 255, 255));
		btnOrder.setBackground(new Color(119, 187, 255));
		btnOrder.setFont(new Font("Raleway SemiBold", Font.PLAIN, 16));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnOrder.setBounds(358, 120, 235, 31);
		panel.add(btnOrder);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(119, 187, 255));
		btnLogout.setFont(new Font("Raleway SemiBold", Font.PLAIN, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminLogin.main(null);
			}
		});
		btnLogout.setBounds(654, 120, 235, 31);
		panel.add(btnLogout);
		
		JLabel lblNewLabel_2 = new JLabel("Library Management System");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 28, 923, 52);
		panel.add(lblNewLabel_2);
		
		
		
		
		
	}
	public static void orderManage(JPanel panel_1) throws ClassNotFoundException, SQLException {
		JLabel lblNewLabel = new JLabel(" Order Manage ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(321, 11, 270, 54);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(193, 235, 255));
		panel_2.setBounds(33, 87, 900, 382);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 880, 189);
		panel_2.add(scrollPane);
		
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row =table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
			}
		});
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		orderTable(model);
		scrollPane.setViewportView(table);
		
		orderIdFild = new JTextField();
		orderIdFild.setBounds(143, 59, 401, 34);
		panel_2.add(orderIdFild);
		orderIdFild.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderId = orderIdFild.getText();
				DefaultTableModel model= (DefaultTableModel) table.getModel();
				try {
					model.setRowCount(0);
					orderTableSearch(model);
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchBtn.setBounds(566, 57, 156, 34);
		panel_2.add(searchBtn);
		
		JLabel lblSearchBookNot = new JLabel("");
		lblSearchBookNot.setForeground(new Color(255, 0, 0));
		lblSearchBookNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBookNot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchBookNot.setBounds(10, 27, 880, 19);
		panel_2.add(lblSearchBookNot);
		
		JLabel lblOrderId = new JLabel(" Order Id : ");
		lblOrderId.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblOrderId.setBounds(10, 54, 150, 34);
		panel_2.add(lblOrderId);
		
		JButton btnNewButton_1 = new JButton("Approved ");
		btnNewButton_1.setBounds(734, 330, 156, 41);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row =table.getSelectedRow();
				DefaultTableModel orderModel = (DefaultTableModel) table.getModel();
				orderInt = Integer.parseInt(model.getValueAt(row, 0).toString());

				try {
					orderUpdate(orderInt);
					orderModel.setRowCount(0);
					orderTable(orderModel);
					orderInt=0;
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel) table.getModel();
				try {
					orderIdFild.setText(" ");
					model.setRowCount(0);
					orderTable(model);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(732, 57, 156, 34);
		panel_2.add(btnReset);

	}
	
	public static void bookManage(JPanel panel_1) throws ClassNotFoundException, SQLException {
		JLabel lblNewLabel = new JLabel(" Book Manage ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Raleway SemiBold", Font.PLAIN, 30));
		lblNewLabel.setBounds(319, 21, 270, 54);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tittle ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(33, 103, 92, 30);
		panel_1.add(lblNewLabel_1);
		
		titleFild = new JTextField();
		titleFild.setBounds(33, 137, 323, 30);
		panel_1.add(titleFild);
		titleFild.setColumns(10);
		
		authorNameFild = new JTextField();
		authorNameFild.setColumns(10);
		authorNameFild.setBounds(33, 207, 323, 30);
		panel_1.add(authorNameFild);
		
		JLabel lblNewLabel_1_1 = new JLabel("Author Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(33, 177, 111, 30);
		panel_1.add(lblNewLabel_1_1);
		
		costFild = new JTextField();
		costFild.setColumns(10);
		costFild.setBounds(33, 279, 323, 30);
		panel_1.add(costFild);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cost");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(33, 248, 92, 30);
		panel_1.add(lblNewLabel_1_2);
		
		qtyFild = new JTextField();
		qtyFild.setColumns(10);
		qtyFild.setBounds(33, 354, 323, 30);
		panel_1.add(qtyFild);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantity ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(33, 320, 92, 30);
		panel_1.add(lblNewLabel_1_3);
		
		JButton createBtn = new JButton("Submit");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleFild.getText();
				String author = authorNameFild.getText();
				int cost = Integer.parseInt( costFild.getText()) ;
				int qty = Integer.parseInt( qtyFild.getText()) ;
				try {
					int id = bookInt;
					if(id >0) {
						DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
						bookUpdate(id,title, author, cost, qty);
						bookInt = -1;
						titleFild.setText( " ");
						authorNameFild.setText(" ");
						costFild.setText(" "); 
						qtyFild.setText(" ");
						model.setRowCount(0);
						bookTable(model);
					}
					else
					{
						bookSave(title, author, cost, qty);
						
						titleFild.setText( " ");
						authorNameFild.setText(" ");
						costFild.setText(" "); 
						qtyFild.setText(" ");
						DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
						model.setRowCount(0);
						bookTable(model);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		createBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createBtn.setBounds(33, 412, 97, 30);
		panel_1.add(createBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(193, 235, 255));
		panel_2.setBounds(451, 127, 466, 315);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 446, 235);
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
				qtyFild.setText(model.getValueAt(row, 4).toString());
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
						qtyFild.setText(" ");
						model.setRowCount(0);
						bookTable(model);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		editBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editBtn.setBounds(148, 412, 97, 30);
		panel_1.add(editBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = bookInt;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do you went to delete this data","Warning", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					if(id >=0) {
						try {
							bookDelete(id);
							bookInt = -1;
							titleFild.setText( " ");
							authorNameFild.setText(" ");
							costFild.setText(" "); 
							qtyFild.setText(" ");
							model.setRowCount(0);
							bookTable(model);
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteBtn.setBounds(259, 412, 97, 30);
		panel_1.add(deleteBtn);
		
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
	
	public static ResultSet bookGet() throws ClassNotFoundException, SQLException {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("select * from book ");
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
	
	public static void dataUpdate(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emonProject", "root", "");
		PreparedStatement pr = con.prepareStatement("update products set name=? , price=?, quntity=? where id=?");
							pr.setString(1, name);
							pr.setInt(2, price);
							pr.setInt(3, qty);
							pr.setInt(4,id);
							pr.executeUpdate();

	} 

	public static void dataDelete(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emonProject", "root", "");
		PreparedStatement pr = con.prepareStatement("delete from products where id=?");
							pr.setInt(1, id);
							pr.executeUpdate();

	} 
	
	public static ResultSet dataGet() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emonProject", "root", "");
		PreparedStatement pr = con.prepareStatement("select * from products ");
				ResultSet rs = 	pr.executeQuery();
				
				return rs;

	} 
	public static ResultSet orderGet() throws ClassNotFoundException, SQLException {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("select * from orders ");
				ResultSet rs = 	pr.executeQuery();
				return rs;

	} 
	public static ResultSet orderSearch(String orderId) throws ClassNotFoundException, SQLException {
		Connection con =getCont();
		PreparedStatement pr = con.prepareStatement("select * from orders where id=? ");
						pr.setString(1, orderId);
				ResultSet rs = 	pr.executeQuery();
				return rs;

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
	public static void orderTable(DefaultTableModel model) throws ClassNotFoundException, SQLException {
		ResultSet rs = orderGet();
		
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
	
	public static void orderTableSearch(DefaultTableModel model) throws ClassNotFoundException, SQLException {
		ResultSet rs = orderSearch(orderId);
		
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

	public static void orderUpdate(int id) throws ClassNotFoundException, SQLException {
		
		Connection con = getCont();
		PreparedStatement pr = con.prepareStatement("update orders set status=? where id=?");
							pr.setString(1, "1");
							pr.setInt(2, id);
							pr.executeUpdate();

	} 
}
