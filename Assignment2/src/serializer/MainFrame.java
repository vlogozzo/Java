package serializer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JFrame frame = new JFrame("Account Entry");
	private Container main = getContentPane();

	private JPanel panel = new JPanel();
	private JLabel accountlabel = new JLabel(" account number");
	private JTextField accounttextfield = new JTextField("", 20);

	private JLabel firstnamelabel = new JLabel(" first name");
	private JTextField firstnametextfield = new JTextField("", 20);

	private JLabel lastnamelabel = new JLabel(" last name");
	private JTextField lastnametextfield = new JTextField("", 20);

	private JLabel balancelabel = new JLabel(" balance");
	private JTextField balancetextfield = new JTextField("", 20);

	private JPanel buttonpanel = new JPanel();
	private JButton submit = new JButton("submit");
	private JButton done = new JButton("done");

	private JTextArea returnedaccounts = new JTextArea();

	public MainFrame(String title) {
		super(title);
		GridLayout grid = new GridLayout(4, 2);
		grid.setVgap(40);
		panel.setLayout(grid);

		panel.add(accountlabel);
		panel.add(accounttextfield);

		panel.add(firstnamelabel);
		panel.add(firstnametextfield);

		panel.add(lastnamelabel);
		panel.add(lastnametextfield);

		panel.add(balancelabel);
		panel.add(balancetextfield);

		main.add(panel, BorderLayout.NORTH);

		frame.add(main);

		buttonpanel.add(submit);
		buttonpanel.add(done);

		frame.add(buttonpanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600, 500);

		done.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				Accounts.Serialize();
				buttonpanel.setVisible(false);
				frame.remove(main);

				frame.add(returnedaccounts);
				try {
					ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.bin"));
					ArrayList<Account> deserialized = new ArrayList<Account>();

					deserialized = (ArrayList<Account>) is.readObject();
					is.close();
					String result = "";
					for (Account a : deserialized) {
						result += String.format("Account: %d  First Name: %10s  Last Name: %10s  Balance: %.2f\n",
								a.getAccount(), a.getFirstName(), a.getLastName(), a.getbalance());
					}
					returnedaccounts.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
					returnedaccounts.setText(result);
					returnedaccounts.setEditable(false);

				} catch (FileNotFoundException exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				} catch (IOException exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				} catch (ClassNotFoundException exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				}

			}
		});

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Account(Integer.parseInt(accounttextfield.getText()), firstnametextfield.getText(),
							lastnametextfield.getText(), Double.parseDouble(balancetextfield.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}

				accounttextfield.setText("");
				firstnametextfield.setText("");
				lastnametextfield.setText("");
				balancetextfield.setText("");

			}
		});
	}
}
