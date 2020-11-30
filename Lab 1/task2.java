import java.util.*;
public class task2{
	public static void main(String[] arg){
		System.out.print("Output: ");
		if(arg[2].equals("+"))
			System.out.println(Double.parseDouble(arg[0])+Double.parseDouble(arg[1]));		
		else if(arg[2].equals("-"))
			System.out.println(Double.parseDouble(arg[0])-Double.parseDouble(arg[2]));
		else if(arg[2].equals("x"))
			System.out.println(Double.parseDouble(arg[0])*Double.parseDouble(arg[2]));
		else if(arg[2].equals("/"))
		{	
			if(Integer.parseInt(arg[1]) != 0)
				System.out.println(Double.parseDouble(arg[0])/Double.parseDouble(arg[1]));
			else
				System.out.println("Undefined");
		}
		else{
			System.out.println("ERROR");
		}		
	}
}