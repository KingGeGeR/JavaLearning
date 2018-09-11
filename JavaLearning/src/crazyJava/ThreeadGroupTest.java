package crazyJava;

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	
	public MyThread(ThreadGroup group,String name) {
		super(group,name);
	}
	
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println(getName()+"�߳�i�ı���"+i);
		}
	}
}

public class ThreeadGroupTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
		System.out.println("���߳��������:"+mainGroup.getName());
		System.out.println("���߳����Ƿ��Ǻ�̨�߳���:"+mainGroup.isDaemon());
		new MyThread("���߳�����߳�").start();
		ThreadGroup tg=new ThreadGroup("���߳���");
		tg.setDaemon(true);
		System.out.println("tg�߳����Ƿ��Ǻ�̨�߳���"+tg.isDaemon());
		MyThread tt=new MyThread(tg,"tg����̼߳�");
		tt.start();
		new MyThread(tg,"tg����߳���").start();
	}

}