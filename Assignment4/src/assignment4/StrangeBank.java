package assignment4;

import java.util.HashMap;

class Container {
	private double balance = 0;
	private String currency;
	private boolean writeable = true;

	public synchronized void deposit(String currency, double val) {
		while (!writeable || balance != 0) { // not the producer's turn
			try {
				System.out.println(Thread.currentThread().getName() + " Waiting for Waiting for Withdrawl...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.balance += val;
		this.currency = currency;
		this.writeable = false;
		System.out.println(Thread.currentThread().getName() + " deposited " + val + " " + this.currency + "(s)");
		notifyAll(); // tell a waiting thread to become ready
	}

	public synchronized void withdraw(String currency, double val) {
		while (writeable || !this.currency.equals(currency)) { // not the consumer's turn
			try {
				System.out.println(Thread.currentThread().getName() + " Waiting for Deposit...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.balance -= val;
		this.currency = currency;
		this.writeable = true;
		System.out.println(Thread.currentThread().getName() + " withdrew " + val + " " + this.currency + "(s)");
		notifyAll(); // tell a waiting thread to become ready
	}

	public double getBalance() {
		return balance;
	}

}

class Deposit extends Thread {
	private Container container;
	private String currency;
	private double val;

	public Deposit(Container c, String currency, double val) {
		this.container = c;
		this.currency = currency;
		this.val = val;
	}

	@Override
	public void run() {
		this.container.deposit(currency, val);
	}
}

class Withdraw extends Thread {
	private Container container;
	private String currency;
	private double val;

	public Withdraw(Container c, String currency, double val) {
		this.container = c;
		this.currency = currency;
		this.val = val;
	}

	@Override
	public void run() {
		this.container.withdraw(currency, val);

	}

}

public class StrangeBank {
	public static void main(String[] args) {

		HashMap<String, Double> deposits = new HashMap<String, Double>();

		deposits.put("Dollar", 1.0);
		deposits.put("Euro", 2.0);
		deposits.put("Pound", 3.0);

		Container container = new Container();

		deposits.forEach((currency, value) -> {
			Deposit d = new Deposit(container, currency, value);
			Withdraw w = new Withdraw(container, currency, value);

			d.start();
			w.start();
		});

	}

}
