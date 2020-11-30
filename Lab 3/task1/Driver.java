import javax.swing.*;
public class Driver{
	public static void main(String[] arg){
		Shape[] arr = new  Shape[5];
		for(int i = 0; i<5; i++){
			int n;
			while(true){
				try{
					n = Integer.parseInt(JOptionPane.showInputDialog("Choose the option:\n1. Create Square\n2. Create Sphere\n"));
					if(n == 1){
						while(true){
							try{
								arr[i] = new Square(Double.parseDouble(JOptionPane.showInputDialog("Enter length:")), Double.parseDouble(JOptionPane.showInputDialog("Enter width:")), Double.parseDouble(JOptionPane.showInputDialog("Enter height:")));
								break;
							}
							catch(Exception ex){
								JOptionPane.showMessageDialog(null, "Invalid Value!");	
							}
						}
					}	
					else if(n == 2){
						while(true){
							try{
								arr[i] = new Sphere(Double.parseDouble(JOptionPane.showInputDialog("Enter radius:")));
								break;
							}
							catch(Exception ex){
								JOptionPane.showMessageDialog(null, "Invalid Value!");	
							}
						}			
					}
					else
						continue;
					break;
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Enter an Integer");	
				}
			}
			if(arr[i] instanceof Square)
				System.out.println("Square:\n"+arr[i].calculateArea()+"\n"+arr[i].calculateVolume());
			else
				System.out.println("Sphere:\n"+arr[i].calculateArea()+"\n"+arr[i].calculateVolume());
		}
	}
}