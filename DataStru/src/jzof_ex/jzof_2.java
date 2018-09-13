package jzof_ex;
/*
 * 这个题做的不好，上来就想着自己之前还记得的过程
 * 没有去思考，如果从右下角开始，则势必会分成两条路
 * 那样你怎么缩小范围，会有重叠，所以一定要缩小区域
 * 左下角或者右上角
 */
public class jzof_2 {

	public boolean Find(int target, int [][] array) {

		int rowLen=array.length;
		int colLen=array[0].length;
		int i=rowLen-1;
		int j=0;
		//主要还是这一部分，其实你并不知道循环会进行多久
		//还有就是数据长得样子一定要好好分析，查找一定是一个让范围或区域确定单一并逐渐变小的过程
		while((i>=0)&(j<colLen)) {
			if(target>array[i][j]) {
				j++;//列右移
			}else if(target<array[i][j]) {
				i--;//行上
			}else {
				return true;
			}
		}
		return false;
		
    }
}