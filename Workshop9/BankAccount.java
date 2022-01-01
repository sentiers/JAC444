package workshop9;

public class BankAccount {

	private double balance;
	private String currency;
	private boolean isEmpty = true;

	BankAccount(double balance, String currency) {
		this.balance = balance;
		this.currency = currency;
	}

	// setters
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	// getters
	public double getBalance() {
		return this.balance;
	}

	public String getCurrency() {
		return this.currency;
	}

	// deposit
	public synchronized void deposit(double amount, String currency) {
		while (!isEmpty && getCurrency() != currency) {
			try {
				System.out.println("=======" + Thread.currentThread().getName() + "=======");
				System.out.println("*CURRENCY ERROR");
				System.out.println("*unable to deposit!");
				System.out.println("=====================\n");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		if (getCurrency() == currency) {
			setCurrency(currency);
			setBalance(getBalance() + amount);
		} else {
			setCurrency(currency);
			setBalance(amount);
		}
		isEmpty = false;
		System.out.println("=======" + Thread.currentThread().getName() + "=======");
		System.out.println("Deposit: " + getCurrency() + " " + amount);
		System.out.println("Balance: " + getCurrency() + " " + getBalance());
		System.out.println("=====================\n");
		notify();
	}

	// withdraw
	public synchronized void withdraw(double amount) {
		while (isEmpty) {
			try {
				System.out.println("=====" + Thread.currentThread().getName() + "=====");
				System.out.println("*BALANCE IS ZERO");
				System.out.println("*unable to withdraw!");
				System.out.println("=====================\n");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		if (getBalance() > 0) {
			setBalance(getBalance() - amount);
		}
		if (getBalance() == 0) {
			isEmpty = true;
		}

		System.out.println("=====" + Thread.currentThread().getName() + "=====");
		System.out.println("Withdraw: " + getCurrency() + " " + amount);
		System.out.println("Balance:  " + getCurrency() + " " + getBalance());
		System.out.println("=====================\n");
		notify();
	}

}