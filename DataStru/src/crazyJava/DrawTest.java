package crazyJava;

public class DrawTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Account acct=new Account("1234567",0);
		new DrawThread("ȡǮ��",acct,800).start();
		new DepositThread("��",acct,800).start();
		new DepositThread("��",acct,800).start();
		new DepositThread("��",acct,800).start();
	}

}
