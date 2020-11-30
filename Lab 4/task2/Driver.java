import java.util.Scanner;
class InvalidRangeException extends Exception{
	String val;
	public InvalidRangeException(){
		val = "Invalid Range Exception";
	}
	public InvalidRangeException(String s){
		val = s;
	}
	@Override
	public String toString(){
		return val;
	}
}
class Prime{
	public int primes(int a, int b)throws InvalidRangeException{
		if(a < 0 || b < 0)
			throw new InvalidRangeException("Negative Value Exists!");
		int count = 0;
		boolean t = true;
		for(int i = a; i<=b; i++){
			if(i<2)
				continue;
			for(int j = 2; j<=i/2; j++){
				if(i % j == 0)
				{
					t = false;
					break;
				}
			}
			if(t)
			{
				count += 1;
			}	
			t = true;
		}
		return count;
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
				if(n2 <= n1)
					throw new InvalidRangeException("2nd Number less or equal to 1st Number");
				break;			
			}
			catch(InvalidRangeException a){
				in.nextLine();
				System.out.println(a);
			}
			catch(Exception a){
				in.nextLine();
				System.out.println("Input Mismatch Exception! :(");		
			}
		}
		try{
			System.out.println("Count = " + new Prime().primes(n1,n2));
		}
		catch(InvalidRangeException a){
			System.out.println("Negative Value Exists!");
		}
	}
}