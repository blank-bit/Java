package model;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class test {

	private JFrame frmTest;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest = new JFrame();
		frmTest.setTitle("ScoreInformation");
		frmTest.setBounds(100, 100, 859, 536);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTest.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(137, 74, 72, 18);
		frmTest.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801");
		lblNewLabel_1.setBounds(137, 145, 72, 18);
		frmTest.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(223, 71, 163, 24);
		frmTest.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(223, 142, 163, 24);
		frmTest.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnNewButton.setBounds(137, 227, 113, 27);
		frmTest.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setBounds(273, 227, 113, 27);
		frmTest.getContentPane().add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 841, 489);
		frmTest.getContentPane().add(panel);

		table = new JTable();
		panel.add(table);
	}
}
