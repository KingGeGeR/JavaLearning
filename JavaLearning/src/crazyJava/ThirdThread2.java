package crazyJava;

import java.util.concurrent.*;

public class ThirdThread2 implements Callable{

	private int i;
	
	@Override
	public Object call() throws Exception {
		// TODO �Զ����ɵķ������
		for(;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"����ѭ������i: "+i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		ThirdThread2 rt=new ThirdThread2();
		FutureTask<Integer> task=new FutureTask<Integer>(rt);
		//ThirdThread2 rt2=new ThirdThread2();
		FutureTask<Integer> task2=new FutureTask<Integer>(rt);
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"����ѭ������i: "+i);
			if(i==20) {
				new Thread(task,"���з���ֵ���߳�1").start();
				new Thread(task2,"���з���ֵ���߳�2").start();
			}
		}
		try {
			System.out.println("�����̵߳ķ��ؽ���ĺ�"+(task.get()+task2.get()));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
