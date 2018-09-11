package algorithm;
import java.util.*;
public class Main {

	static class point2{
		public int x;
		public int y;
        point2(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static boolean IsPtInPoly(point2 point, List<point2> pts){
	    
	    int N = pts.size();
	    boolean boundOrVertex = true; 
	    int intersectCount = 0;
	    double precision = 2e-10; 
	    point2 p1, p2;
	    point2 p = point; 
	    
	    p1 = pts.get(0);       
	    for(int i = 1; i <= N; ++i){            
	        if(p.equals(p1)){
	            return boundOrVertex;
	        }
	        
	        p2 = pts.get(i % N);          
	        if(p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)){               
	            p1 = p2; 
	            continue;
	        }
	        
	        if(p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)){
	            if(p.y <= Math.max(p1.y, p2.y)){              
	                if(p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)){
	                    return boundOrVertex;
	                }
	                
	                if(p1.y == p2.y){                       
	                    if(p1.y == p.y){
	                        return boundOrVertex;
	                    }else{
	                        ++intersectCount;
	                    } 
	                }else{                       
	                    double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;//cross point of y                        
	                    if(Math.abs(p.y - xinters) < precision){
	                        return boundOrVertex;
	                    }
	                    
	                    if(p.y < xinters){
	                        ++intersectCount;
	                    } 
	                }
	            }
	        }else{                
	            if(p.x == p2.x && p.y <= p2.y){                    
	                point2 p3 = pts.get((i+1) % N);                  
	                if(p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)){//p.x lies between p1.x & p3.x
	                    ++intersectCount;
	                }else{
	                    intersectCount += 2;
	                }
	            }
	        }            
	        p1 = p2;
	    }
	    
	    if(intersectCount % 2 == 0){
	        return false;
	    } else { 
	        return true;
	    }
	    
	}
	
	//�㵽ֱ�ߵ���̾�����жϣ�x0,y0�� ����������ɵ��߶Σ�x1,y1�� ,( x2,y2 )  
	public static double pointToLine(point2 tar,point2 b1,point2 b2) {
		double x1=b1.x;
		double y1=b1.y;
		double x2=b2.x; 
		double y2=b2.y;
	    double x0=tar.x;
	    double y0=tar.y;
		double space = 0;
		double a, b, c;
		a = lineSpace(x1, y1, x2, y2);// �߶εĳ���
		b = lineSpace(x1, y1, x0, y0);// (x1,y1)����ľ���
		c = lineSpace(x2, y2, x0, y0);// (x2,y2)����ľ���
		if (c + b == a) {// �����߶���
			space = 0;
			return space;
		}
		if (a <= 0.000001) {// �����߶Σ���һ����
			space = b;
			return space;
		}
		if (c * c >= a * a + b * b) { // ���ֱ�������λ�۽������Σ�(x1,y1)Ϊֱ�ǻ�۽�
			System.out.println("���ֱ�������λ�۽������Σ�(x1,y1)Ϊֱ�ǻ�۽�  ");
			space = b;
			return space;
		}
		if (b * b >= a * a + c * c) {// ���ֱ�������λ�۽������Σ�(x2,y2)Ϊֱ�ǻ�۽�
			System.out.println("���ֱ�������λ�۽������Σ�(x2,y2)Ϊֱ�ǻ�۽� ");
			space = c;
			return space;
		}
		// �����������Σ����������εĸ�
		System.out.println("�����������Σ����������εĸ�  ");
		double p = (a + b + c) / 2;// ���ܳ�
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));// ���׹�ʽ�����
		space = 2 * s / a;// ���ص㵽�ߵľ��루���������������ʽ��ߣ�
		return space;
	}

	// ��������֮��ľ���
	public static double lineSpace(double x1, double y1, double x2, double y2) {
		double lineLength = 0;
		lineLength = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		return lineLength;
	} 

	public static boolean contains(point2 tar,List<point2> pts) {

		
		return IsPtInPoly(tar, pts);
	}
	
	public static double cal(point2 tar,point2 b1,point2 b2) {
		
		return 0;
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Scanner sc=new Scanner(System.in);
		String[] s1=sc.nextLine().split(",");
		String[] s2=sc.nextLine().split(",");
		sc.close();
		int[] tar=new int[2];
		int[] shape=new int[s2.length];
		for(int i=0;i<2;i++) {
			tar[i]=Integer.parseInt(s1[i]);
		}
		for(int i=0;i<s2.length;i++) {
			shape[i]=Integer.parseInt(s2[i]);
		}
		int len=shape.length/2;
		int[] x=new int[len];
		int[] y=new int[len];
		point2 ptar=new point2(tar[0],tar[1]);
		List<point2> pts=new ArrayList<point2>();
		int j=0;
		for(int i=0;i<shape.length;i+=2) {
			x[j]=shape[i];
			y[j]=shape[i+1];
			point2 temp=new point2(x[j],y[j]);
            pts.add(temp);
		}
		if(contains(ptar,pts)) {
			System.out.println("yes"+","+"0");
		}else {
			System.out.println("no"+","+"y");
		}
	}

}
