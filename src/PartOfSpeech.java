


//contains Part of Speech type for a word


public class PartOfSpeech {

	public boolean directVerb;
	//
	public boolean signalVerb;
	//
	public boolean verb;
	//
	public boolean subject;
	//
	public boolean noun;
	//
	public boolean adverb;
	//
	public boolean directObject;
	
	//
	public boolean quote;
	
	public boolean isQuote() {
		return quote;
	}

	public void setQuote(boolean quote) {
		this.quote = quote;
	}

	public boolean isPrep_from() {
		return prep_from;
	}

	public void setPrep_from(boolean prep_from) {
		this.prep_from = prep_from;
	}

	public boolean isPrep_to() {
		return prep_to;
	}

	public void setPrep_to(boolean prep_to) {
		this.prep_to = prep_to;
	}

	public boolean isPrep_on() {
		return prep_on;
	}

	public void setPrep_on(boolean prep_on) {
		this.prep_on = prep_on;
	}

	public boolean isPrep_at() {
		return prep_at;
	}

	public void setPrep_at(boolean prep_at) {
		this.prep_at = prep_at;
	}

	public boolean isDobj() {
		return dobj;
	}

	public void setDobj(boolean dobj) {
		this.dobj = dobj;
	}

	public boolean isDirectObject() {
		return directObject;
	}

	public void setDirectObject(boolean directObject) {
		this.directObject = directObject;
	}

	public boolean isDirectVerb() {
		return directVerb;
	}

	public void setDirectVerb(boolean directVerb) {
		this.directVerb = directVerb;
	}

	public boolean isSignalVerb() {
		return signalVerb;
	}

	public void setSignalVerb(boolean signalVerb) {
		this.signalVerb = signalVerb;
	}

	public boolean isSubject() {
		return subject;
	}

	public void setSubject(boolean subject) {
		this.subject = subject;
	}

	public boolean isNoun() {
		return noun;
	}

	public void setNoun(boolean noun) {
		this.noun = noun;
	}

	public boolean isAdverb() {
		return adverb;
	}

	public void setAdverb(boolean adverb) {
		this.adverb = adverb;
	}

	public boolean isAdjectives() {
		return adjectives;
	}

	public void setAdjectives(boolean adjectives) {
		this.adjectives = adjectives;
	}

	public boolean isPreposition() {
		return preposition;
	}

	public void setPreposition(boolean preposition) {
		this.preposition = preposition;
	}

	public boolean isDefiniteArticle() {
		return definiteArticle;
	}

	public void setDefiniteArticle(boolean definiteArticle) {
		this.definiteArticle = definiteArticle;
	}

	boolean adjectives;
	
	boolean preposition;
	
	boolean definiteArticle;
	
	boolean prep_from;
	
	boolean prep_to;
	
    boolean prep_on;
    
	boolean prep_at;
	
	boolean dobj;
	
	
	
	
	public boolean isVerb() {
		return verb;
	}

	public void setVerb(boolean verb) {
		this.verb = verb;
	}

	public void returnPartOfSpeech()
	{
		if (directVerb)
		{
			System.out.println("Direct Verb");
		}
		 if (signalVerb)
		{
			System.out.println("Signal Verb");
		}
		 if (subject)
		{
			System.out.println("Subject Verb");
		}
		 if (noun)
		{
			System.out.println("Noun");
			
		}
		
		 if (adverb)
		{
			System.out.println("adverb");
		}
		
		 if (directObject)
		{
			System.out.println("direcftObject");
		}
		 if (prep_from)
		{
			System.out.println("prep_from");
		}
		
		 if (prep_to)
		{
			System.out.println("prep_to");
		}
		
		 if (prep_on)
		{
			System.out.println("prep_on");
		}
	    
		 if (prep_at)
		{
			System.out.println("prep_at");	
		}
		
		 if (dobj)
		{
			System.out.println("dobj");
		}
	}
	
	
	
}
