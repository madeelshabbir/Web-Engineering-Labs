public class Dictionary{
	private String word;
	private String meaning;
	public Dictionary(){
		this(null, null);
	}
	public Dictionary(String w, String m){
		this.word = w;
		this.meaning = m;
	}
	public Dictionary(Dictionary d){
		this(d.word, d.meaning);
	}
	public String getWord(){
		return this.word;	
	}
	public String getMeaning(){
		return this.meaning;	
	}
	public void setWord(String w){
		this.word = w;
	}
	public void setMeaning(String m){
		this.meaning = m;
	}
	public String toString(){
		return this.word+" "+this.meaning;
	}
}