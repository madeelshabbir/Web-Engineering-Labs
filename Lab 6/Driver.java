import java.io.*;
import java.util.*;
class Word implements Serializable{
	private String name;
	private String meaning;
	public Word(){
		this(null, null);
	}
	public Word(Word d){
		this(d.name, d.meaning);
	}
	public Word(String n, String m){
		this.name = n;
		this.meaning = m;
	}
	public String getName(){
		return this.name;
	}
	public String getMeaning(){
		return this.meaning;
	}
	public void setName(String n){
		this.name = n;
	}
	public void setMeaning(String m){
		this.meaning = m;
	}
	@Override
	public String toString(){
		return "Name: "+this.name+" | "+"Meaning: "+this.meaning;
	}
}
class Dictionary{
	private ArrayList<Word> arr;
	public Dictionary(){
		arr = new ArrayList<Word>();
		try{
			FileInputStream is = new FileInputStream(".\\Dictionary.txt");
			ObjectInputStream inp = new ObjectInputStream(is);
			while(true){
				try{
					arr.add((Word)inp.readObject());
				}
				catch(Exception ex){
					break;
				}
			}
			inp.close();
			is.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void addNewRecord(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String n = in.nextLine();
		System.out.print("Enter Meaning: ");
		arr.add(new Word(n, in.nextLine()));
	}
	public int searchIndex(String n)throws Exception{
		for(int i = 0; i<arr.size(); i++){
			if(n.equals(arr.get(i).getName())){
				return i;
			}
		}
		throw new Exception("Word does not Exist!");
	}
	public String searchRecord(String n)throws Exception{
		int i = this.searchIndex(n);
		return arr.get(i).toString();
	}
	public void updateRecord(String n, String m)throws Exception{
		arr.set(this.searchIndex(n), new Word(n,m));
	}
	public void deleteRecord(String n)throws Exception{
		arr.remove(this.searchIndex(n));
	}
	public void show(){
		for(int i = 0; i<arr.size(); i++)
			System.out.println(arr.get(i).toString());
	}
	public void saveDictionary(){
		try{
			FileOutputStream os = new FileOutputStream(".\\Dictionary.txt");
			ObjectOutputStream out =  new ObjectOutputStream(os);
			for(int i = 0; i<arr.size(); i++)
				out.writeObject(arr.get(i));
			out.close();
			os.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}
class Driver{
	public static void main(String[] args){
		Dictionary d = new Dictionary();
		Scanner in = new Scanner(System.in);
		while(true){
			try{
				System.out.println("======= Dictionary =======");
				System.out.println("1. Add New Word");
				System.out.println("2. Search Word");
				System.out.println("3. Update Word");
				System.out.println("4. Delete Word");
				System.out.println("5. Show Dictionary");
				System.out.println("6. Save & Exit");
				System.out.print("Enter a number: ");
				switch(in.nextInt()){
				case 1:
					in.nextLine();
					d.addNewRecord();
					break;
				case 2:
					in.nextLine();
					System.out.print("Enter Name to search: ");
					try{
						System.out.println(d.searchRecord(in.nextLine()));
					}
					catch(Exception ex){
						System.out.println(ex);
					}
					System.out.println("Press Enter to go back...");
					in.nextLine();
					break;
				case 3:
					in.nextLine();
					System.out.print("Enter Name to update: ");
					String n = in.nextLine();
					System.out.print("Enter New Meaning: ");
					try{
						d.updateRecord(n,in.nextLine());
						System.out.println("Word Successfully Updated!");
					}
					catch(Exception ex){
						System.out.println(ex);
					}
					break;
				case 4:
					in.nextLine();
					System.out.print("Enter Name to delete: ");
					try{
						d.deleteRecord(in.nextLine());
						System.out.println("Word Successfully Deleted!");
					}
					catch(Exception ex){
						System.out.println(ex);
					}
					break;
				case 5:
					in.nextLine();
					d.show();
					System.out.println("Press Enter to go back...");
					in.nextLine();
					break;
				case 6:
					d.saveDictionary();
					return;
				default:
					System.out.println("Choose in range of 1-3");
				}
			}
			catch(Exception ex){
				in.nextLine();
				System.out.println(ex);
			}
		}
	}
}