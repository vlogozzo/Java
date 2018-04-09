package serializer;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try {
			new Account(789, "Vincent", "Logozzo", 52.82);
			new Account(123, "jeff", "box", 100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}


		Scanner is = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Account information, enter nothing to finish");
			System.out.print("Account number:");
			String account = is.nextLine();
			System.out.print("First Name:");
			String firstName = is.nextLine();
			System.out.print("Last Name:");
			String lastName = is.nextLine();
			System.out.print("Balance:");
			String balance = is.nextLine();

			try {
				new Account(Integer.parseInt(account), firstName, lastName, Float.parseFloat(balance));
			} catch (NumberFormatException e) {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			System.out.print("enter another account? ");
			if (is.nextLine().equals("no")) {
				is.close();
				Accounts.Serialize();
				Accounts.Deserialize();
				break;

			}
		}
		new MainFrame("test");
	}
}
