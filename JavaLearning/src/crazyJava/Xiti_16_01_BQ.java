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
			while(flag.flag!=0) {System.out.print('-');};//如果旗标指示现在应该consumer线程执行，则当前
			                       //循环等待,知道阻塞挂起当前线程
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
    		bq.take();//这里如果不可取是会阻塞当前线程，但是一旦可取且取了之后，生产者线程也唤醒了
    		          //因此如果不加下面的while循环判断旗标，则有可能会出现错乱的执行，因为生产者可以抢占CPU，同理
    		          //生产者那里也需要一个循环判断旗标的过程，果然还是得自己亲自手敲一遍，尽信书，则不如无书
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
		// TODO 自动生成的方法存根

		comflag flag=new comflag();
		BlockingQueue<Integer> bq=new ArrayBlockingQueue<>(1);
		new Producer1(bq,flag).start();
		new Consumer1(bq,flag).start();
	}

}
