package jzof_ex;
/*
 * ��������Ĳ��ã������������Լ�֮ǰ���ǵõĹ���
 * û��ȥ˼������������½ǿ�ʼ�����Ʊػ�ֳ�����·
 * ��������ô��С��Χ�������ص�������һ��Ҫ��С����
 * ���½ǻ������Ͻ�
 */
public class jzof_2 {

	public boolean Find(int target, int [][] array) {

		int rowLen=array.length;
		int colLen=array[0].length;
		int i=rowLen-1;
		int j=0;
		//��Ҫ������һ���֣���ʵ�㲢��֪��ѭ������ж��
		//���о������ݳ�������һ��Ҫ�ú÷���������һ����һ���÷�Χ������ȷ����һ���𽥱�С�Ĺ���
		while((i>=0)&(j<colLen)) {
			if(target>array[i][j]) {
				j++;//������
			}else if(target<array[i][j]) {
				i--;//����
			}else {
				return true;
			}
		}
		return false;
		
    }
}