package crazyJava;

import java.util.concurrent.*;

class Producer extends Thread{
	private BlockingQueue<String> bq;
	
	public Producer(BlockingQueue<String> bq) {
		this.bq=bq;
	}
	
	public void run() {
		String[] strArr=new String[] {
				"Java",
				"Struts",
				"Spring"
		};
		for(int i=0;i<99999999;i++) {
			System.out.println(getName()+"������׼����������Ԫ��");
			try {
				Thread.sleep(1000);
				bq.put(strArr[i%3]);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(getName()+"�������"+bq);
		}

	}
}

class Consumer extends Thread{
	private BlockingQueue<String> bq;
	
	public Consumer(BlockingQueue<String> bq) {
		this.bq=bq;
	}
	
	public void run() {
		while(true) {
			System.out.println(getName()+"������׼�����Ѽ���Ԫ��");
			try {
				Thread.sleep(1000);
				bq.take();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(getName()+"�������"+bq);
		}
	}
	
}

public class BlockingQueueTest2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		BlockingQueue<String> bq=new ArrayBlockingQueue<>(1);
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		new Consumer(bq).start();
	}

}
