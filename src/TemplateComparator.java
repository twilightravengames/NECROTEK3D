import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class TemplateComparator {
	///xmlpattern and template
	
	
	//1.start by matching templates
	//2.if you have a match then do 3 and below
	
	//3.finds signalverb(s) in template
	//4."line up" signalverb in template and pattern
	//5. extract speaker and speakee position from template
	
	//maybe?
	//4.for each signal verb look at previouse tag
	//5.for each signal verb look at next tag
	//(pull them in three out of the xml pattern
	
	
	
	
	public HashMap<String,String> matcher (String source, HashMap<String,String> match, String template)
	{

		//iterate over templates, everytime it finds a match in
		//the input pattern, it moves to the next tag in the
		//template. When it reaches the last tag and fulfills it
		//then a match is returned
		//If it finishes the pattern without fulfilling the template
		//then the compariison is rejected.
		//

		//iterate over templates
		//template name
		List<String> templateList = Arrays.asList(template.split("<"));


		//iterating through template
		//for (String t : templateList)
		//{

		System.out.println("PatternsFactory::Launching Compare Patterns");

		for (int i=0;i<templateList.size();i++)
		{
			System.out.println("PatternsFactory::Iterating through the templates");
			String t = templateList.get(i);

			List<String> patternList = Arrays.asList(source.split(">"));

			String t_lemma = null;
			String pos = null;

			String [] templateXML = thirdTemplatePattern(t, pos, t_lemma);


			String prevNoun = null;
			String signalVerb = null;
			String nextNoun = null;



			//System.out.println("Phrase: " + t + " part of speech " + pos + "lemma" + t_lemma);
			System.out.println("PatternsFactory: Iterate through patterns");
			for (int j = 0;j<patternList.size();j++)
			{
				//System.out.println("Pattern " + pattern);
				String pattern = patternList.get(j);

				String phrase = null;
				String pos2 = null;
				String lemma = null;




				String [] patternXML = preparePattern(pattern, pos, lemma);
				//String [] patternXML = null;
				if (patternXML != null)
				{
					System.out.println("Pattern Processed patternXML 0 is " + patternXML[0]);
					System.out.println("Pattern Procesed patternXML 1 is " + patternXML[1]);
					System.out.println("Template is: " + t);
				}
				//must match template's first half of the tag with 
				//the pattern tag's first half
				//note executing the block below


				if (templateXML != null && templateXML.length > 0)
				{
					//System.out.println("Template Processed XML pattern 0 is  " + patternXML[0]);

					//System.out.println("Template Processed Template 0 is " + templateXML[0]);
					System.out.println("Template Part of Speech is " + templateXML[0]);

					System.out.println("Template Content " + templateXML[1]);
				}


				System.out.println("PatternsFactory: Performing match");
				if (templateXML != null && patternXML != null && ((templateXML[0].contains(patternXML[0]) || patternXML[0].contains(templateXML[0]))))
				{
					//found a patttern in the template
					///also this is the last template pattern and it matches
					//so we assume there is a match

					//System.out.println("Pattern " + pattern + " contains templates " + t);
					//System.out.println("Patterns matched");
					System.out.println("PATTERNS PART OF SPEECH MATCHED");
					System.out.println("Origin template " + templateXML[0]);
					System.out.println("Origin patterns " + patternXML[0]);
					
					//**need to have access to prev noun, current verb, and next noun
					//if noun is <speakernoun><misc><signalverb> then speakernoun is speaker
					//if noun is <signalverb><misc><speakernoun> then speakernoun is speaker
					//remaining nouns could be speakee

					HashMap<String,String> m = (alignMatchedSpeaker(source, template));

					//match is null
					if (m == null)
					{
							System.out.println("m null");
					}

					//store solutions
					match.putAll(m);
					
					///do this once i can identify the speaker
					///this is a whole nother ball game
					HashMap<String, String> e = (identifySpeakee(source, template));
					
					match.putAll(e);;

					//identifySpeakee(source, template);
					//printHashMap(match, "Speakers");
					//printHashMap(e, "Speakees");
					//match.putAll(e);
/*

					if (e == null)
					{
						System.out.println("speakee is null");
					}

					if (m == null)
					{
						System.out.println("speaker is null");
					}
*/
					//printHashMap(m, "ted m");
					//printHashMap(e, "ted e");

					//continue;
				}
				if (pattern.contains("templates"))
				{
					////template marker, skip over
					System.out.println("Template Marker");
					continue;
				}

				if ((pattern.contains(t)) || (t.contains(pattern)))
				{
					System.out.println("Pattern Contains template and template contains pattern");
					System.out.println("Pattern: " + pattern);
					System.out.println("Template:" + t);
					//System.out.println("Pattern " + pattern + " contains templates " + t);
					System.out.println("match - break");
					System.out.println("Aligning....:");
					alignMatchedSpeaker(pattern, t);
					break;
				}


				System.out.println("PatternsFactory::compare Patterns Nouns to detect identify");


				if (patternXML != null) {
					System.out.println("patternXML.length = " + patternXML.length);
					if (patternXML.length < 2)
					{
						nextNoun = patternXML[j + 1];
					}
				}
				//once if innner loop and outer loop can't find a match
				//return false, no match between pattern and template

			}




		}

		System.out.println("PATTTERNS PARTS OF SPEECH FAILED TO MATCH");
		System.out.println("SIMPLE WAY FAILED, TRYING TEMPLATES?");
		System.out.println("Origin template " + template);
		System.out.println("Origin patterns " + source);



		return match;

	}
	public String [] thirdTemplatePattern(String phrase, String partOfSpeech, String lemma)
	{
		String[] prepared = null;
		
		String tphrase = phrase.replace('<', ' ');
		
		String ephrase = phrase.replace('>', ' ');
		
		//System.out.println("Template EPHRASE PARTS " + ephrase);
		
		String[] parts = ephrase.split(":");


		
		//System.out.println("Prepared split 0 " + parts[0]); //part of speech but with <
		//System.out.println("Prepared split 1 " + parts[1]); //lemma correct
		//this is showing an error
		
		if (parts.length >= 2)
		{
			System.out.println("third template pattern size is " + parts.length);
		
			System.out.println("Template split 0 " + parts[0]); //part of speech but with 
			System.out.println("Template split 1 " + parts[1]);
		}
		
		//System.out.println("Prepared split 1 " + parts[1]); //lemma correct
		//this is showing an error
		
		
		//System.out.println("Indexing 0 " + lastSplit[0]);
		//System.out.println("INdexing 1" + lastSplit[1]);
		//output xml 
		
		if (parts.length >= 2)
		{
			//partOfSpeech = prepared[0];
			partOfSpeech = parts[0];
			lemma = parts[1];
			
			System.out.println("Template PoS " + parts[0] + " lemma " + lemma);
		}
		
		if (parts.length >= 2)
		{
			String [] returnValue = new String[2];
		
			returnValue[0] = parts[0];
			returnValue[1] = parts[1];
			return returnValue;

		}
		else
		{
			return null;
		}
		
		
	}
	
	HashMap<String, String> identifySpeaker(String source, String template)
	{
		return null;
	}

	HashMap<String, String> identifySpeakee(String source, String template)
	{
		return null;
	}
			
	String [] preparePattern(String pattern, String pos, String lemma)
	{
		 String [] patternXML = null;
		 return patternXML;
	}
	
	HashMap<String,String> alignMatchedSpeaker(String pattern, String template)
	{
		System.out.println("Running alignMatchedSpeaker");
		//assuming template and patterns are matches
		//find first speakernoun then find speakee from the template
		//and match it to the pattern
		int speakercounter=0;
		int tmpcounter =0;
		StringTokenizer str = new StringTokenizer(template, ">");
		while (str.hasMoreTokens())
		{
			String st = str.nextToken();
			tmpcounter++;
			if (st.contains("speakernoun"))
			{
				StringTokenizer patternTok = new StringTokenizer(pattern, ">");
				while (patternTok.hasMoreTokens())
				{
					speakercounter++;
					String tr = patternTok.nextToken();
					if (speakercounter == tmpcounter)
					{
						//positional match
						System.out.println("Discovered a positional matvh");
						System.out.println("Template: " + st);
						System.out.println("Pattern: " + tr);
						
						//save results
						HashMap<String, String> hash = new HashMap<String,String>();
						hash.put(st, tr);     //template and pattern words
						
						return (hash);
					}
				}
			}

		}
		return null;
	}

}


	


