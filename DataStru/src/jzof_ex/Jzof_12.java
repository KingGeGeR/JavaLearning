package jzof_ex;
import java.util.*;
public class Jzof_12 {

	class node{
		public int x;
		public int y;
		node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || rows < 0 || cols < 0 || str == null)
			return false;

		boolean[][] visit = new boolean[rows][cols];
		//Stack<node> tmp = new Stack<node>();
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (match(matrix, rows, cols, str, i, j, index, visit)) {
					// match()
					return true;
				}
			}
		}
		return false;
	}
    
	public boolean match(char[] matrix, int rows, int cols, char[] str, int i, int j,int index,boolean[][] visit) {

		if(index>=str.length) {//����Ƚϵ���index>str.length-1,�򵱷��ʵ�index-2��ʱ��ƥ�䣬index++����index=str.length-1
			                   //��index=length-1,�ͷ��ش��ڵ������ǣ��ַ��������һ���ַ�û��ƥ��
			return true;
		}
		boolean hasmatch=false;
		//tmp.push(new node(i,j));
		if (i>=0&&i<rows&&j>=0&&j<cols&&visit[i][j]!=true&&matrix[i*cols+j]==str[index]) {
			//tmp.push(new node(i-1,j));
			visit[i][j] = true;
			index++;
			
			hasmatch=match(matrix,rows,cols,str,i-1,j,index,visit)||
					match(matrix,rows,cols,str,i+1,j,index,visit)||
					match(matrix,rows,cols,str,i,j-1,index,visit)||
					match(matrix,rows,cols,str,i,j+1,index,visit);
			if(!hasmatch) {
				visit[i][j]=false;
				index--;
			}
			
		}

		return hasmatch;
	}
}
