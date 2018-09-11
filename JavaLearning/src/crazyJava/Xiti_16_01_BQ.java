package crazyJava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class Producer1 extends Thread{
	private BlockingQueue<Integer> bq;
	private comflag flag;
	public Producer1(BlockingQueue<Integer> bq,comflag flag) {
		this.bq=bq;
		this.setFlag(flag);
	}
	
	public void run() {
		for (int i = 0; i < 52; i += 2) {
			produce(i);
		}
	}

	@SuppressWarnings("finally")
	public int produce(int i) {
		try {
			bq.put(i);
			while(flag.flag!=0) {System.out.print('-');};//������ָʾ����Ӧ��consumer�߳�ִ�У���ǰ
			                       //ѭ���ȴ�,֪����������ǰ�߳�
			System.out.print((i + 1) + "" + (i + 2));
			flag.flag=1;
        } catch(InterruptedException e) {
            System.out.println(e);
        }finally {
        	return 1;
        }
	}
	public comflag getFlag() {
		return flag;
	}

	public void setFlag(comflag flag) {
		this.flag = flag;
	}
}

class Consumer1 extends Thread{
	private BlockingQueue<Integer> bq;
	private comflag flag;
	public Consumer1(BlockingQueue<Integer> bq,comflag flag) {
		this.bq=bq;
		this.setFlag(flag);
	}
	
	public void run() {
		for (int i = 0; i < 26; i++) {
			consume(i);
		}

	}

	public void consume(int i) {
        try {
    		bq.take();//�����������ȡ�ǻ�������ǰ�̣߳�����һ����ȡ��ȡ��֮���������߳�Ҳ������
    		          //���������������whileѭ���ж���꣬���п��ܻ���ִ��ҵ�ִ�У���Ϊ�����߿�����ռCPU��ͬ��
    		          //����������Ҳ��Ҫһ��ѭ���ж����Ĺ��̣���Ȼ���ǵ��Լ���������һ�飬�����飬��������
    		while(flag.flag!=1) {System.out.print('-');}
    		char temp = (char) ('A' + i);				
    		System.out.print(temp);
    		flag.flag=0;
        } catch(InterruptedException e) {
            System.out.println(e);
        }
	}
	public comflag getFlag() {
		return flag;
	}

	public void setFlag(comflag flag) {
		this.flag = flag;
	}
}

public class Xiti_16_01_BQ {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		comflag flag=new comflag();
		BlockingQueue<Integer> bq=new ArrayBlockingQueue<>(1);
		new Producer1(bq,flag).start();
		new Consumer1(bq,flag).start();
	}

}
