



public class PartOfSpeechUtilities {

	public void outputPoS(PartOfSpeech pOS)
	{
		if (pOS == null)
		{
			System.out.println("PartOFSpeechUtilities(): pOS null pointer");
			return;
		}

		System.out.println("pOS.isNoun" + pOS.isNoun());
		System.out.println("pOS isDirectVerb " + pOS.isDirectVerb());
		System.out.println("pOS isSignalVerb " + pOS.isSignalVerb());
		System.out.println("pOS isDO" + pOS.isDirectObject());
		System.out.println("pOS isAdj" + pOS.isAdjectives());
		System.out.println("pOS isDefArt" + pOS.isDefiniteArticle());
		System.out.println("pOS isAdverb" + pOS.isAdverb());
		System.out.println("pOS isSubject" + pOS.isSubject());
		System.out.println("pOS isPreposition" + pOS.isPreposition());
		System.out.println("pOS isVerb" + pOS.isVerb());
		return;
	}
	
}
