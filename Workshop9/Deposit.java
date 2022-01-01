package workshop9;

public class Deposit extends Thread {

	private BankAccount acount;
	private double[] balance;
	private String[] currency;

	public Deposit(BankAccount acount, double[] balance, String[] currency) {
		super("From Me");
		this.acount = acount;
		this.balance = balance;
		this.currency = currency;
	}

	@Override
	public void run() {
		for (int i = 0; i < balance.length; i++) {
			synchronized (acount) {
				acount.deposit(balance[i], currency[i]);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}

		}
	}
}