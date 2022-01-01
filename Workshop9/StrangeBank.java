package workshop9;

public class StrangeBank {

	public static void main(String[] args) {

		double[] balance = { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		String[] currency = { "$", "€", "€", "£", "£", "£" };

		BankAccount acount = new BankAccount(0.0, "");

		Thread withdraw = new Withdraw(acount, balance);
		Thread deposit = new Deposit(acount, balance, currency);

		deposit.start();
		withdraw.start();

	}

}