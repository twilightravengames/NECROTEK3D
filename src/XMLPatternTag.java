

public class XMLPatternTag {

	public String name;

	public XMLPatternTag() {
		name = new String();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public XMLPatternTag prevTag;
	public XMLPatternTag nextTag;
}
