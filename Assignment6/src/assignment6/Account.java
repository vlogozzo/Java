package assignment6;

import java.io.*;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private int account;
	private String firstName;
	private String lastName;
	private double balance;

	public Account(int account, String firstName, String lastName, double balance) throws Exception {
		super();
		if (account > 0 && firstName != "" && lastName != "" && balance > 0) {
			this.account = account;
			this.firstName = firstName;
			this.lastName = lastName;
			this.balance = balance;
			Accounts.AddAccount(this);
		} else {
			throw new Exception("Invalid Account!");
		}
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getbalance() {
		return balance;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

}
