

import java.util.ArrayList;

public class ScratchPad {

	
	

	public boolean isQuote() {
		return isQuote;
	}

	public void setQuote(boolean isQuote) {
		this.isQuote = isQuote;
	}

	public ArrayList<String> getDirectObject() {
		return directObject;
	}

	public void setDirectObject(ArrayList<String> directObject) {
		this.directObject = directObject;
	}

	public ArrayList<String> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<String> subject) {
		this.subject = subject;
	}

	public ArrayList<String> getSignalVerb() {
		return signalVerb;
	}

	public void setSignalVerb(ArrayList<String> signalVerb) {
		this.signalVerb = signalVerb;
	}

	public ArrayList<String> getDirectVerb() {
		return directVerb;
	}

	public void setDirectVerb(ArrayList<String> directVerb) {
		this.directVerb = directVerb;
	}

	public ArrayList<String> getVerb() {
		return verb;
	}

	public void setVerb(ArrayList<String> verb) {
		this.verb = verb;
	}

	public ArrayList<String> getNoun() {
		return noun;
	}

	public void setNoun(ArrayList<String> noun) {
		this.noun = noun;
	}

	public ArrayList<String> getAdverb() {
		return adverb;
	}

	public void setAdverb(ArrayList<String> adverb) {
		this.adverb = adverb;
	}

	boolean isQuote = false;
		
	public ArrayList<String> directObject = new ArrayList<String>();
	
	public ArrayList<String>  subject = new ArrayList<String>();
	
	public ArrayList<String>  signalVerb = new ArrayList<String>();
	
	public ArrayList<String>  directVerb = new ArrayList<String>();
	
	public ArrayList<String>  verb = new ArrayList<String>();
	
	public ArrayList<String>  noun = new ArrayList<String>();
	
	public ArrayList<String>  adverb = new ArrayList<String>();
	
	public ArrayList<ArgumentPOS> arguments = new ArrayList<ArgumentPOS>();
	
	public ArrayList<String> quote = new ArrayList<String>();

    public ArrayList<String> getPos_pronoun() {
		return pos_pronoun;
	}

	public  void setPos_pronoun(ArrayList<String> pos_pronoun) {
		this.pos_pronoun = pos_pronoun;
	}

	public ArrayList<String> open_quote = new ArrayList<String>();
	
	public ArrayList<String> prep = new ArrayList<String>();
	
	public ArrayList<String> conjunction = new ArrayList<String>();
	
	public ArrayList<String> adjective = new ArrayList<String>();
	
	public ArrayList<String> pos_pronoun = new ArrayList<String>();
	
	
	public ArrayList<String> getAdjective() {
		return adjective;
	}

	public void setAdjective(ArrayList<String> adjective) {
		this.adjective = adjective;
	}

	public ArrayList<String> getConjunction() {
		return conjunction;
	}

	public void setConjunction(ArrayList<String> conjunction) {
		this.conjunction = conjunction;
	}

	public ArrayList<String> getPrep() {
		return prep;
	}

	public void setPrep(ArrayList<String> prep) {
		this.prep = prep;
	}

	public ArrayList<String> getDef_article() {
		return def_article;
	}

	public void setDef_article(ArrayList<String> def_article) {
		this.def_article = def_article;
	}

	public ArrayList<String> close_quote = new ArrayList<String>();
	
	public ArrayList<String> pronouns = new ArrayList<String>();
	
	public ArrayList<String> def_article = new ArrayList<String>();
	
	public ArrayList<String> getOpen_quote() {
		return open_quote;
	}

	public void setOpen_quote(ArrayList<String> open_quote) {
		this.open_quote = open_quote;
	}

	public ArrayList<String> getClose_quote() {
		return close_quote;
	}

	public void setClose_quote(ArrayList<String> close_quote) {
		this.close_quote = close_quote;
	}

	public ArrayList<String> getPronouns() {
		return pronouns;
	}

	public void setPronouns(ArrayList<String> pronouns) {
		this.pronouns = pronouns;
	}

	public ArrayList<ArgumentPOS> getArguments() {
		return arguments;
	}

	public void setArguments(ArrayList<ArgumentPOS> arguments) {
		this.arguments = arguments;
	}

	public ArrayList<String> getQuote() {
		return quote;
	}

	public void setQuote(ArrayList<String> quote) {
		this.quote = quote;
	}

	public String speakerNoun = new String();

	public void setSpeakerNoun(String speaker) {  this.speakerNoun = speaker; }

	public String getSpeakerNoun() { return speakerNoun; }



	public void writeToScratchPad(PartOfSpeech pOS, String word)
	{
		System.out.println("writeToScratchPad(): Word being written to scratchpad is: " + word);
		if (pOS.directObject == true)
		{
			System.out.println("writeToScratchPad(): Writing a directObject");
			directObject.add(word);
		}
		

		if (pOS.subject == true)
		{
			System.out.println("writeToScratchPad(): Writing a subject");

			subject.add(word);
		}
		
		if (pOS.signalVerb == true)
		{
			System.out.println("writeToScratchPad(): Writing a signalVerb");

			signalVerb.add(word);
		}
		
		if (pOS.directVerb == true)
		{
			System.out.println("writeToScratchPad(): Writing a directVerb");

			directVerb.add(word);
		}
		
		if (pOS.verb == true)
		{
			System.out.println("writeToScratchPad(): Writing a verb");

			verb.add(word);
		}
		
		if (pOS.noun == true)
		{
			System.out.println("writeToScratchPad(): Writing a noun");

			noun.add(word);
		}
		
		if (pOS.adverb == true)
		{
			System.out.println("writeToScratchPad(): Writing a adverb");

			adverb.add(word);
		}
		
		if (pOS.quote == true)
		{
			System.out.println("writeToScratchPad(): Writing a quote");
			
			quote.add(word);
		}
		
	}
	
	//return if element is in scratchpad
	public boolean containsVerb(String element)
	{
		boolean contains = false;
		for (String word: this.verb)
		{
			if (element.equals(word))
			{
				contains = true;
				return true;
			}
		}
		return contains;
	}
	
	//if is in scratchpad
	public boolean containsNoun(String element)
	{
		boolean contains = false;
		for (String word: this.noun)
		{
			if (element.equals(word))
			{
				contains = true;
				return true;
			}
		}
		return contains;
	}
	
}
