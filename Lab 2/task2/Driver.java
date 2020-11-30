import java.util.Scanner;
public class Driver{
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter No of Rows of Matrix 1: ");
		int a = in.nextInt();
		System.out.print("Enter No of Columns of Matrix 1: ");
		int b = in.nextInt();
		Matrix m = new Matrix(a,b);
		for(int i = 0; i<m.getRow(); i++)
			for(int j = 0; j<m.getCol(); j++)
				m.setElement(i,j,in.nextInt());
		System.out.print("Enter No of Rows of Matrix 2: ");
		a = in.nextInt();
		System.out.print("Enter No of Columns of Matrix 2: ");
		b = in.nextInt();
		Matrix n = new Matrix(a,b);
		for(int i = 0; i<n.getRow(); i++)
			for(int j = 0; j<n.getCol(); j++)
				n.setElement(i,j,in.nextInt());
		in.close();
		Matrix k = new Matrix();
		k.add(m,n);
		k.showMatrix();
		k.multiply(m,n);
		k.showMatrix();
	}
}