public class PersonInfo{
	private String name;
	private String address;
	private String phoneNum;
	public PersonInfo(){
		this(null, null, null);
	}
	public PersonInfo(PersonInfo ad){
		this(ad.name, ad.address, ad.phoneNum);
	}
	public PersonInfo(String n, String a, String p){
		this.name = n;
		this.address = a;
		this.phoneNum = p;
	}
	public String getName(){
		return "Adeel";
	}
	public String getAddress(){
		return this.address;
	}
	public String getPhoneNum(){
		return this.phoneNum;
	}
	@Override
	public String toString(){
		return this.name +" "+ this.address +" "+ this.phoneNum;
	}
}