package jzof_ex;

public class Jzof_13 {

    public int movingCount(int threshold, int rows, int cols)
    {
    	boolean[][] visit=new boolean[rows][cols];
    	int num=Count(threshold,rows,cols,0,0,visit);
        return num;
    }
    
    public int sumEachSite(int i) {
    	int a=i;
    	int sum=0;
    	while(a>0) {
    		sum=sum+a%10;
    		a=a/10;    		   		
    	}
    	return sum;
    }
    
    public int Count(int threshold,int rows,int cols,int i,int j,boolean[][] visit) {
    	int count=0;
		if (match(threshold,rows,cols,i,j,visit)) {
			visit[i][j] = true;
			count=1+Count(threshold, rows, cols, i, j - 1, visit)+Count(threshold, rows, cols, i, j + 1, visit)
				   +Count(threshold, rows, cols, i - 1, j, visit)+Count(threshold, rows, cols, i + 1, j, visit);
		}
		return count;
    }
    public boolean match(int threshold,int rows,int cols,int i,int j,boolean[][] visit) {
		if (sumEachSite(i) + sumEachSite(j)<= threshold && i < rows && i >= 0 && j < cols && j >= 0&&visit[i][j]!=true) {
			return true;
		}
		return false;
    	
    }
}
