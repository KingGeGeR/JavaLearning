package crazyJava;

class myrun1 implements Runnable{

	private comflag flag;
	
	public myrun1(comflag flag){
		this.setFlag(flag);
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
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

class myrun2 implements Runnable{

	private comflag flag;
	
	public myrun2(comflag flag){
		this.setFlag(flag);
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
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

public class Xiti_16_011 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		comflag flag=new comflag();
		new Thread(new myrun1(flag)).start();
		new Thread(new myrun2(flag)).start();
	}

}
