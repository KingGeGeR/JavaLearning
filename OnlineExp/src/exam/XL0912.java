package exam;
import java.util.*;
public class XL0912 {
	public static int con(int a, int b)
	{
		return b == 0 ? a : con(b, a%b);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=sc.nextInt();
			int tot = 0;
			for (int i = 1; i <= (int)(Math.sqrt(n/2)); i++)
			{
				for (int j = i + 1; j <= (int)(Math.sqrt(n)); j++)
				{
					if (!(con(i, j) == 1 && (i % 2 != j % 2))) continue;
					int x = j * j - i * i;
					int y = 2 * j*i;
					int z = i * i + j * j;
					if (z>n) break;
					if (con(x, y) == 1 && con(x, z) == 1 && con(y, z) == 1)
					{
						tot++;
					}
				}
			}
			System.out.println(tot);
		}
		
	}
}
