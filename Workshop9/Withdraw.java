package workshop9;

public class Withdraw extends Thread {

	private BankAccount acount;
	private int size;

	public Withdraw(BankAccount acount, double[] deposit) {
		super("From Friend");
		this.acount = acount;
		this.size = deposit.length;
	}

	@Override
	public void run() {
		for (int i = 0; i < size; i++) {
			synchronized (acount) {
				acount.withdraw(1.0);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
	}
}