package crazyJava;

public class DepositThread extends Thread{

	private Account account;
	private double depositAmount;
	
	public DepositThread(String name,Account account,double depositAmount) {
		super(name);
		this.setAccount(account);
		this.setDepositAmount(depositAmount);
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	public void run() {
		for(int i=0;i<100;i++) {
			account.deposit(depositAmount);
		}
	}
}
