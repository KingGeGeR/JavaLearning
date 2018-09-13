package crazyJava;

public class DrawTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Account acct=new Account("1234567",0);
		new DrawThread("取钱者",acct,800).start();
		new DepositThread("甲",acct,800).start();
		new DepositThread("乙",acct,800).start();
		new DepositThread("丙",acct,800).start();
	}

}
