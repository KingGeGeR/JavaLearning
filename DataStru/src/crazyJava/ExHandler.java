package crazyJava;

class MyExHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO �Զ����ɵķ������
		System.out.println(t+"�̳߳������쳣"+e);
	}
	
}
public class ExHandler {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a=5/0;
		System.out.println("������������");
	}

}
