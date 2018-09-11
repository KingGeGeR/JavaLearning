package crazyJava;

import java.util.concurrent.*;

class mycal1 implements Callable<Object>{

	private comflag flag;
	
	public mycal1(comflag flag) {	
		this.setFlag(flag);
	}
	
	@Override
	public Object call() throws Exception {
		// TODO �Զ����ɵķ������
		for (int i = 0; i < 52; i += 2) {
			synchronized (flag) {
				try {
					while (flag.flag != 0)
						flag.wait();
					System.out.print((i + 1) + "" + (i + 2));
					flag.flag = 1;
					flag.notifyAll();
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}

			}

		}
		return null;
	}

	public comflag getFlag() {
		return flag;
	}

	public void setFlag(comflag flag) {
		this.flag = flag;
	}
	
}

class mycal2 implements Callable<Object>{

	private comflag flag;
	
	public mycal2(comflag flag) {
	
		this.setFlag(flag);
	}
	
	@Override
	public Object call() throws Exception {
		// TODO �Զ����ɵķ������
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public comflag getFlag() {
		return flag;
	}

	public void setFlag(comflag flag) {
		this.flag = flag;
	}
	
}

public class Xiti_16_012 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		comflag flag=new comflag();
		FutureTask<Object> task=new FutureTask<>(new mycal1(flag));
		FutureTask<Object> task2=new FutureTask<>(new mycal2(flag));
		new Thread(task,"��").start();
		new Thread(task2,"��").start();
	}

}
