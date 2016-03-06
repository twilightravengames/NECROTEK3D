

public class StackElement {

	boolean isQuote = false;
	
	boolean isVerb = false;
	
	boolean isDirectObject = false;
	
	boolean isSubject = false;
	
	boolean isNoun = false;
	
	boolean isSignalVerb = false;
	
	boolean isDirectVerb = false;
	
	boolean isAdverb = false;
	
	public String elementContent = "";
	
	StackElement previous;
	
	StackElement next;
	
	

	public boolean isAdverb() {
		return isAdverb;
	}

	public void setAdverb(boolean isAdverb) {
		this.isAdverb = isAdverb;
	}

	public boolean isNoun() {
		return isNoun;
	}

	public void setNoun(boolean isNoun) {
		this.isNoun = isNoun;
	}

	public boolean isQuote() {
		return isQuote;
	}

	public void setQuote(boolean isQuote) {
		this.isQuote = isQuote;
	}

	public boolean isVerb() {
		return isVerb;
	}

	public void setVerb(boolean isVerb) {
		this.isVerb = isVerb;
	}

	public boolean isDirectObject() {
		return isDirectObject;
	}

	public void setDirectObject(boolean isDirectObject) {
		this.isDirectObject = isDirectObject;
	}

	public boolean isSubject() {
		return isSubject;
	}

	public void setSubject(boolean isSubject) {
		this.isSubject = isSubject;
	}

	public boolean isSignalVerb() {
		return isSignalVerb;
	}

	public void setSignalVerb(boolean isSignalVerb) {
		this.isSignalVerb = isSignalVerb;
	}

	public boolean isDirectVerb() {
		return isDirectVerb;
	}

	public void setDirectVerb(boolean isDirectVerb) {
		this.isDirectVerb = isDirectVerb;
	}

	public String getElementContent() {
		return elementContent;
	}

	public void setElementContent(String elementContent) {
		this.elementContent = elementContent;
	}
	
	
	JSONString convertStackElementToJSONString(StackElement element)
	{
	
		return null;
	}

	StackElement convertJSONStringToStackElement(JSONString jSONString)
	{
		return null;
	}
	
	
}
