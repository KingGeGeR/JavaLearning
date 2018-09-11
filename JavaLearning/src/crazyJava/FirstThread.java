package crazyJava;
/*
 * 通过继承Thread类重写run方法来实现的多线程
 */
public class FirstThread extends Thread {

	private int i;
	
	public void run() {
	
		for(;i<100;i++) {
			System.out.println(getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20) {
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}

}
