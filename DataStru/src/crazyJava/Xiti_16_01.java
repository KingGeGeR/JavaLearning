package crazyJava;

//打印数字的线程
class thread1 extends Thread{

	private comflag flag;
	public thread1(String name,comflag flag) {
		super(name);
		this.setFlag(flag);
	}
	
	public void run() {
		for (int i = 0; i < 52; i += 2) {
			synchronized (flag) {
				try {
					while (flag.flag != 0)
						flag.wait();
					System.out.print((i + 1) + "" + (i + 2));
					flag.flag = 1;
					flag.notifyAll();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}

		}


	}

	public comflag getFlag() {
		return flag;
	}
	
	public void setFlag(comflag flag) {
		this.flag = flag;
	}
}

//打印字母的线程
class thread2 extends Thread{

	private comflag flag;
	
	public thread2(String name,comflag flag) {
		super(name);
		this.setFlag(flag);
	}
	
	public void run() {
		for (int i = 0; i < 26; i++) {
			synchronized (flag) {
				try {
					while (flag.flag != 1)
						flag.wait();
					char temp = (char) ('A' + i);
					System.out.print(temp);
					flag.flag = 0;
					flag.notifyAll();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

	public comflag getFlag() {
		return flag;
	}

	public void setFlag(comflag flag) {
		this.flag = flag;
	}
	
}

class comflag{
	int flag=0;
}

public class Xiti_16_01 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		comflag com=new comflag();
		thread1 th1=new thread1("甲",com);
		thread2 th2=new thread2("乙",com);
		th1.start();
		th2.start();
	}

}
