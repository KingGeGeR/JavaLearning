package crazyJava;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class thread_c1 extends Thread{

	private comflag_c flag;
	public thread_c1(comflag_c flag) {

		this.flag=flag;
	}

	public void run() {
		for (int i = 0; i < 52; i += 2) {
			flag.lock.lock();
			try {
				while (flag.flag!= 0)
					flag.con.await();
				System.out.print((i + 1) + "" + (i + 2));
				flag.flag = 1;
				flag.con.signalAll();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				flag.lock.unlock();
			}

		}
    }
}

class thread_c2 extends Thread{

	private comflag_c flag;
	
	public thread_c2(comflag_c flag) {

		this.flag=flag;
	}

	public void run() {
		for (int i = 0; i < 26; i++) {
			flag.lock.lock();
			try {
				while (flag.flag != 1)
					flag.con.await();
				char temp = (char) ('A' + i);
				System.out.print(temp);
				flag.flag = 0;
				flag.con.signalAll();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				flag.lock.unlock();
			}
		}
	}

}

class comflag_c{	
	Lock lock=new ReentrantLock();
	Condition con=lock.newCondition();
	int flag=0;
}

public class Xiti_16_01c1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		comflag_c flag=new comflag_c();
		new thread_c1(flag).start();
		new thread_c2(flag).start();
	}

}
