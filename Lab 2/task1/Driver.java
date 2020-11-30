import javax.swing.*;
public class Driver{
	private Dictionary[] dic;
	private int size;
	private int loc;
	public Driver(){
		this(0);	
	}
	public Driver(int s){
		this.loc = 0;
		this.size = s;
		this.dic = new Dictionary[this.size];
		for(int i =0; i<this.size; i++)
			this.dic[i] = new Dictionary();
	}
	public boolean addWord(Dictionary Obj){
		if(this.size >= this.loc+1)
		{
			this.dic[this.loc].setWord(Obj.getWord());
			this.dic[this.loc].setMeaning(Obj.getMeaning());
			this.loc=this.loc+1;
			return true;
		}
		return false;
	}
	public String searchWord(String w){
		for(int i = 0; i<this.loc; i++)
			if(this.dic[i].getWord().equals(w))
				return this.dic[i].getMeaning();
		return "No";
	}
	public void printCompleteDict(){
		for(int i = 0; i<this.loc; i++)
			System.out.println(this.dic[i].toString());	
	}
	public static void main(String[] arg){
		Driver d = new Driver(10);
		int num;
		while(true){
			try{
				num = Integer.parseInt(JOptionPane.showInputDialog("Press 1 to new Add Word\nPress 2 to Search Word\nPress 3 to Print Dictionary\nPress 4 to Exit"));
				if(num == 1)
				{	if(!d.addWord(new Dictionary(JOptionPane.showInputDialog("Enter Word:"),JOptionPane.showInputDialog("Enter Meaning:"))))
						JOptionPane.showMessageDialog(null, "Can't Add More");
				}
				else if(num == 2)
					JOptionPane.showMessageDialog(null, d.searchWord(JOptionPane.showInputDialog("Enter Word:")));
				else if(num == 3)
					d.printCompleteDict();
				else if(num == 4)
					break;
				else
					JOptionPane.showMessageDialog(null, "Enter Value 1-4");
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid Input");		
			}
		}
	}
}