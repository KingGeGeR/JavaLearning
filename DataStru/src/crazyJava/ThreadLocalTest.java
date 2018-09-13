package crazyJava;

class Account2{
	private ThreadLocal<String> name=new ThreadLocal<>();
	
	public Account2(String str) {
		this.name.set(str);
		System.out.println("----"+this.name.get());
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String str) {
		this.name.set(str);
	}
}

class MyTest extends Thread{

	private Account2 account;
	
	public MyTest(Account2 account,String name) {
	
		super(name);
		this.setAccount(account);
	}

	public Account2 getAccount() {
		return account;
	}

	public void setAccount(Account2 account) {
		this.account = account;
	}
	
	public void run() {
		for(int i=0;i<10;i++) {
			if(i==6) {
				account.setName(getName());
			}
			System.out.println(account.getName()+"�˻���iֵ"+i);
		}
	}
	
}

public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Account2 at=new Account2("��ʼ��");
		new MyTest(at,"�̼߳�").start();
		new MyTest(at,"�߳���").start();
	}

}
