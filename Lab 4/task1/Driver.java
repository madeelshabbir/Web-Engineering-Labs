import java.util.Scanner;
class NewException extends Exception{
	String val;
	public NewException(){
		val = null;
	}
	public NewException(String s){
		val = s;
	}
	@Override
	public String toString(){
		return val;
	}
}
class Number{
	public float CalculatorQuotient(int n1, int n2)throws NewException{
		if(n2 == 0)
		{
			throw new NewException("Divide By Zero");}
		return n1/n2;
	}
}
class Driver{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n1, n2;
		while(true){
			try{
				System.out.print("Enter 1st Number: ");
				n1 = in.nextInt();	
				break;		
			}
			catch(Exception a){
				System.out.println("Input Mismatch Exception! :(");
				in.nextLine();	
			}
		}
		while(true){
			try{
				System.out.print("Enter 2nd Number:");
				n2 = in.nextInt();
				in.nextLine();
				break;			
			}
			catch(Exception a){
				in.nextLine();
				System.out.println("Input Mismatch Exception! :(");		
			}
		}
		try{
			System.out.println(new Number().CalculatorQuotient(n1, n2));
		}
		catch(NewException a){
			System.out.println(a.toString());
		}
	}
}