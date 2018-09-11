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
			System.out.println(account.getName()+"账户的i值"+i);
		}
	}
	
}

public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Account2 at=new Account2("初始名");
		new MyTest(at,"线程甲").start();
		new MyTest(at,"线程乙").start();
	}

}
