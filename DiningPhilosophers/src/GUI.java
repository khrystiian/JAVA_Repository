import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUI {
    Table tbl = Table.getInstance(); //using this method each philosopher will call the same instance of the class Table
	private JFrame frame;
	private JTable table;
	
	Philosoph1 philosoph1 = new Philosoph1();
	Philosoph2 philosoph2 = new Philosoph2();
	Philosoph3 philosoph3 = new Philosoph3();
	Philosoph4 philosoph4 = new Philosoph4();
	Philosoph5 philosoph5 = new Philosoph5();
	
	
	Thread phi1 = new Thread(philosoph1);
	Thread phi2 = new Thread(philosoph2);
	Thread phi3 = new Thread(philosoph3);
	Thread phi4 = new Thread(philosoph4);
	Thread phi5 = new Thread(philosoph5);
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final String[] tableHeader = new String[] {"Eat/Think", "Philosoph1", "Philosoph2", "Philosoph3", "Philosoph4", "Philosoph5"};
		final String rows[][] = new String [0][6];		
		final DefaultTableModel model = new DefaultTableModel(rows, tableHeader);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 450, 91);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		table.setModel(model);
			
		
		// This Thread will refresh the table that display how many times each philosoph  eat/think
		new Thread (new Runnable() {
			@Override
			public void run() {
				while(tbl.isAct()){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			table.setModel(model);
			DefaultTableModel tblMod = (DefaultTableModel) table.getModel();
			tblMod = new DefaultTableModel(rows, tableHeader);
			tblMod.addRow(new Object[]{"Eat", tbl.getP1eat(), tbl.getP2eat(), tbl.getP3eat(), tbl.getP4eat(), tbl.getP5eat()});
			tblMod.addRow(new Object[]{"Think", tbl.getP1think(), tbl.getP2think(), tbl.getP3think(), tbl.getP4think(), tbl.getP5think()});
			table.setModel(tblMod);
			}
			}
		}).start();
		
		
		// The Start button will start the threads
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				phi1.start();
				phi2.start();
				phi3.start();
				phi4.start();
				phi5.start();
			}
		});
		btnStart.setBounds(326, 43, 89, 23);
		frame.getContentPane().add(btnStart);
		
		
	}
	
		
}
	
