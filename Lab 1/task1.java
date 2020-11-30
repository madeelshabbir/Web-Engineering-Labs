import java.util.*;
import javax.swing.*;
public class task1{
	public static void main(String[] arg){
		int start = 0;
		while(true){
			try{
				start = Integer.parseInt(JOptionPane.showInputDialog("Enter Starting Number: "));
				break;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid Input");		
			}
		}
		int end = 0;
		while(true){
			try{
				end = Integer.parseInt(JOptionPane.showInputDialog("Enter Ending Number: "));
				break;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid Input");		
			}
		}
		for(int i = start; i <= end; i++){
			int n = i;
			int sum = 0;
			int prod = 1;
			while(n >= 10){
				int r = n % 10;
				n/=10;
				sum+=r*r*r;
			}
			sum+=n*n*n;
			if(i == sum)
			{
				if(i != end)
					System.out.print(i+", ");
				else
					System.out.println(i);	
			}
		}
	}
}