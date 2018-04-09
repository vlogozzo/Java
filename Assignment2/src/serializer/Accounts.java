package serializer;

import java.io.*;
import java.util.ArrayList;

public class Accounts {
	public static ArrayList<Account> accounts = new ArrayList<Account>();

	public Accounts() {
		super();
	}

	public void CreateAccount(int account, String firstName, String lastName, double balance) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.bin"));
			try {
				os.writeObject(new Account(account, firstName, lastName, balance));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			os.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static void Serialize() {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.bin"));
			os.writeObject(accounts);
			os.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void Deserialize() {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.bin"));
			ArrayList<Account> deserialized = new ArrayList<Account>();

			deserialized = (ArrayList<Account>) is.readObject();
			is.close();

			for (Account a : deserialized) {
				// System.out.println("Account: " + a.getAccount() + "\t" + "First Name: " +
				// a.getFirstName() + "\t"
				// + "Last Name: " + a.getLastName() + "\t" + "Balance :" + a.getbalance());
				System.out.printf("Account: %d  First Name: %10s  Last Name: %10s  Balance: %.2f\n", a.getAccount(),
						a.getFirstName(), a.getLastName(), a.getbalance());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void AddAccount(Account account) {
		accounts.add(account);
	}

}
