import java.util.*;
import java.io.*;
import javax.swing.*;
class LoginInfo{
	private String id;
	private String name;
	private String password;
	public LoginInfo(){
		this(null, null, null);
	}
	public LoginInfo(LoginInfo l){
		this(l.id, l.name, l.password);
	}
	public LoginInfo(String i, String n, String p){
		this.id = i;
		this.name = n;
		this.password = p;
	}
	public String getId(){
		return this.id;
	}
	public String getPassword(){
		return this.password;
	}
	public String getName(){
		return this.name;
	}
	public void setId(String i){
		this.id = i;
	}
	public void setPassword(String p){
		this.password = p;
	}
	public void setName(String n){
		this.name = n;
	}
	@Override
	public String toString(){
		return "Id:"+this.id+", Name:"+this.name+", Password:"+this.password;
	}
}
class LoginSystem{
	private ArrayList<LoginInfo> arr;
	private String filePath;
	public LoginSystem(String s){
		arr = new ArrayList<LoginInfo>();
		filePath = s;
		try{
			FileReader inp = new FileReader(filePath);
			BufferedReader bf =  new BufferedReader(inp);
			String line;
			while((line = bf.readLine()) != null){
				int loc1 = line.indexOf(',',3);
				int loc2 = line.indexOf(',',loc1+7);
				LoginInfo li = new LoginInfo(line.substring(3, loc1),line.substring(loc1+7, loc2),line.substring(loc2+11, line.length()));
				arr.add(li);
			}
			bf.close();
			inp.close();
		}
		catch(IOException ex){
			System.out.println(ex);
		}
	}
	public String getName(String id)throws Exception{
		return arr.get(this.searchDetail(id)).getName();
	}
	public void viewDetail(){
		System.out.println("======= View Client Details =======");
		for(int i = 0; i<arr.size(); i++){
				System.out.println(arr.get(i).toString());
		}
	}
	public int searchDetail(String id)throws Exception{
		for(int i = 0; i<arr.size(); i++){
			if(id.equals(arr.get(i).getId())){
				return i;
			}
		}
		throw new Exception("Can't Find Client with given ID");
	}
	public void deleteDetail(String id)throws Exception{
		arr.remove(this.searchDetail(id));
	}
	public boolean validateLogin(String id, String pass){
		for(int i = 0; i<arr.size(); i++){
			if(id.equals(arr.get(i).getId())&& pass.equals(arr.get(i).getPassword())){
				return true;
			}
		}
		return false;
	}
	public void close(){
		try{
			FileWriter out = new FileWriter(filePath);
			PrintWriter pr =  new PrintWriter(out);
			String line;
			for(int i = 0; i<arr.size(); i++){
				pr.println(arr.get(i).toString());
			}
			pr.close();
			out.close();
		}
		catch(IOException ex){
			System.out.println(ex);
		}
	}
}
class Driver{
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		while(true){
			try{
				System.out.println("======= Choose Module =======");
				System.out.println("1. Admin");
				System.out.println("2. Client");
				System.out.println("3. Exit");
				System.out.print("Enter a number: ");
				switch(in.nextInt()){
				case 1:
					while(true){
						try{
							LoginSystem lg = new LoginSystem(".\\admin.txt");
							String ai = JOptionPane.showInputDialog("Enter Admin ID: ");
							if(lg.validateLogin(ai, JOptionPane.showInputDialog("Enter Admin Password: "))){
								while(true){
									try{
										LoginSystem dt = new LoginSystem(".\\client.txt");
										System.out.println("======= Welcome "+lg.getName(ai)+" =======");
										System.out.println("1. View Clients Details");
										System.out.println("2. Search Client Details");
										System.out.println("3. Delete Client Details");
										System.out.println("4. Back to Main Menu");
										System.out.print("Enter a number: ");
										switch(in.nextInt()){
										case 1:
											in.nextLine();
											dt.viewDetail();
											System.out.println("Press Enter to go back...");
											in.nextLine();
											break;
										case 2:
											in.nextLine();
											System.out.print("Enter ID of the Client to search");
											try{
												dt.searchDetail(in.nextLine());
												System.out.println("Client Existed!");
											}
											catch(Exception ex){
												System.out.println(ex);
											}
											break;
										case 3:
											in.nextLine();
											System.out.print("Enter ID of the Client to Detete it's details: ");
											try{
												dt.deleteDetail(in.nextLine());
												dt.close();
												System.out.println("Client Successfully Removed!");
											}
											catch(Exception ex){
												System.out.println(ex);
											}
											break;
										case 4:
											break;
										default:
											System.out.println("Choose in range of 1-4");
											continue;
										}
										break;
									}
									catch(Exception ex){
										in.nextLine();
										System.out.println(ex);
									}
								}
							}
							else{
									JOptionPane.showMessageDialog(null,"Invalid Login");
									continue;
							}
							break;
						}
						catch(Exception ex){
							System.out.println(ex);
						}
					}
					break;
				case 2:
					in.nextLine();
					while(true){
						try{
							LoginSystem lg = new LoginSystem(".\\client.txt");
							String ai = JOptionPane.showInputDialog("Enter Client ID: ");
							if(lg.validateLogin(ai, JOptionPane.showInputDialog("Enter Client Password: "))){
								try{
									FileReader inp = new FileReader(".\\event.txt");
									BufferedReader bf =  new BufferedReader(inp);
									System.out.println("======= Welcome "+lg.getName(ai)+"! Events are shown below =======");
									String line;
									while((line = bf.readLine()) != null){
									System.out.println(line);
									}
									bf.close();
									inp.close();
									System.out.println("Press Enter to go back...");
									in.nextLine();
									break;
								}
								catch(IOException ex){
									System.out.println(ex);
								}
							}
							else{
									JOptionPane.showMessageDialog(null,"Invalid Login");
									continue;
							}
						}
						catch(Exception ex){
							System.out.println(ex);
						}
					}
					break;
				case 3:
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