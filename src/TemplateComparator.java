import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

//have entire pos strings for both patterns and templates
//need to divide them into speaker sentence (first) and speakee sentence (second)
//fso we wil divide source (pattern) at the quote symbol

public class TemplateComparator {
	///xmlpattern and template
	
	
	//1.start by matching templates
	//2.if you have a match then do 3 and below
	
	//3.finds signalverb(s) in template
	//4."line up" signalverb in temp late and pattern
	//5. extract speaker and speakee position from template
	
	//maybe?
	//4.for each signal verb look at previouse tag
	//5.for each signal verb look at next tag
	//(pull them in three out of the xml pattern
	



	public HashMap<String,String> matcher (XMLPattern xmlPattern, HashMap<String,String> match, String templateString)
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

		String t = null;
		//iterating through template


		System.out.println("PatternsFactory::Launching Compare Patterns");


		//System.out.println("TESTA: Pattern Element 0: " + pattern.XMLPatternType.get(0).name);


		List<String> templateList = Arrays.asList(templateString.split("<"));

		System.out.println("templateList is " + templateList.get(0));

		for (int i=0;i<templateList.size();i++)
		{
			//extract tags from String templateString
			//



			String [] templateXML = null;

			//break into templates
			templateXML = templateList.toArray(new String[templateList.size()]);

			//each String[k] is a tag








			String t_lemma = null;
			String pos = null;

			//nto sure of the purpose of the line below
			//String [] templateXML = thirdTemplatePattern(t, pos, t_lemma);


			String prevNoun = null;
			String signalVerb = null;
			String nextNoun = null;



			//iterate through patterns
			System.out.println("PatternsFactory: Iterate through patterns");
			//List<String> patternList = Arrays.asList(source.split(">"));
			List<String> patternList = Arrays.asList(xmlPattern.XMLPatternType.get(i).name.split("<"));


			System.out.print("Source XM Pattern : "); //
			for (int j=0;j<xmlPattern.XMLPatternType.size();j++)
			{
				System.out.println(xmlPattern.XMLPatternType.get(j).name);
			}

			System.out.println("Template List [0]" + templateXML[0]);

			for (int j = 0;j<patternList.size();j++)
			{

				System.out.println();
				System.out.print("Origin: ");
	
				//
				System.out.println("PATTERNS FACTORY PATTERNE: " + patternList.get(j));


				String phrase = null;

				String lemma = null;


				String pos2 = null;
				String lemma2 = null;



				String [] patternXML = null;

				patternXML = patternList.toArray(new String[patternList.size()]);

				//				for (int o=0;o<patternXML.length;o++)
				//				{
				//					System.out.println( "patternXML " + patternXML[o]);
				//				}


				//patterns are a list of templates?

				//lists are working but XMLPattern objects aren't - they are null
				
				///////////
				System.out.println("CURRENT TEMPLATE TAG: " + templateXML[i]);
				System.out.println("CURRENT PART OF SPEECH: " + getSpeech(templateXML[i]));
				System.out.println("CURRENT GET LEMMA: " + getLemma(templateXML[i]));
		/////////////
				
				System.out.println("CURRENT PATTERN TAG: " + xmlPattern.XMLPatternType.get(j).name);
				System.out.println("CURRENET PART OF SPEECH: " + getSpeech(patternXML[j]));
				System.out.println("CURRENT GET LEMMA: " + getLemma(patternXML[j]));
		////////////////

				//patternXML[o] each individually is a tag!


				//not sure of the purpose of the line below

				//String [] patternXML = preparePattern(pattern, pos, lemma);
				//String [] templateXML = preparePattern(source, pos2, lemma2);

				//				printXMLList(patternList, "Pattern");
				//				printXMLList(templateList, "Tempaltes");
				//				

				//************************
				//CORRECT: templateXML[] is a tag in a tempalte 
				printXMLList(templateXML,"Template value in loop");
				//patternXML print pattern - need to seperate into tags
				printPatternXMLList(patternXML,"Pattern value in loop:");
				
				
//				`
				
					
					
					
					//each array element is a partofspeech:word?
					//pos:word>
					//System.out.print(patternXML[1]);

					//each array element is a tag
					StringTokenizer st = new StringTokenizer(patternXML[j], ">");
					//while (st.hasMoreTokens())
					//{

					System.out.println();

					//Pattern is sehowing up properly
					///Template however is also working properly
					//although there are more template tokens than patterns
					//so some of them show up empty
					if (templateXML != null && templateXML.length > 0)
					{
						//System.out.println("Template Processed XML pattern 0 is  " + patternXML[0]);

						//System.out.println("Template Processed Template 0 is " + templateXML[0]);
						System.out.println("Template Part of Speech is " + templateXML[0]);

						System.out.println("Template Content " + templateXML[1]);
					}





					//continue;

					if (xmlPattern.XMLPatternType.contains("template"))
					{
						////template marker, skip over
						System.out.println("Template Marker");
						continue;
					}


					if ((patternXML[j].contains(templateXML[i]) || (templateXML[i].contains(patternXML[j]))))
					{
						System.out.println("FOUND: Found XML Match");
					}


					HashMap<String,String> m = null;
					//match is null
					if (m == null)
					{
						System.out.println("m null");
					}

					//store solutions
					//*match.putAll(m);
					

					System.out.println("PATTTERNS PARTS OF SPEECH FAILED TO MATCH");
					System.out.println("SIMPLE WAY FAILED, TRYING TEMPLATES?");
					//xml pattern here is wrong
					//template string is one template
					System.out.println("Origin template " + templateString);
					System.out.print("Origin pattern:: ");
					for (int p=0;p<xmlPattern.XMLPatternType.size();p++)
					{
						System.out.println(xmlPattern.XMLPatternType.get(p).name );
					}
					
					
					//match pattern against current template
					//if pattern element lines up with template
					
					//tokenize pattern into list
					//tokenize template into list
					//compare lists
					//xml pattern here is wrong
					ArrayList<String> patternTokens = new ArrayList<String>();
					ArrayList<String> templateTokens = new ArrayList<String>();
					ArrayList<String> valueTokens = new ArrayList<String>();
					ArrayList<String> otherTokens = new ArrayList<String>();
					
					System.out.println("Tokenize to list name: " + xmlPattern.XMLPatternType.get(0).name);
					
					patternTokens = tokenizeToList(xmlPattern.XMLPatternType.get(0).name, valueTokens);
					templateTokens = tokenizeToList(templateString, otherTokens);
				
					//list lists
					System.out.println("PATTERNS");
					for (int k=0;k<patternTokens.size();k++)
					{
						System.out.println(patternTokens.get(i));
					}
					System.out.println("TEMPLATES");
					for (int k=0;k<templateTokens.size();k++)
					{
						System.out.println(templateTokens.get(i));
					}
					
					
					
					//compare lists
					int quote_ctr = 0;
					for (String templateToken : templateTokens)
					{
						int match_ctr = 0;
						for (String patternToken : patternTokens)
						{
							if (patternToken.equals(templateToken))
							{
								System.out.println("TOKEN MATCH");
								System.out.println("MATCH COUNTER IS " + match_ctr);
								//pattern match, continue
								match_ctr++;
								if (patternToken.equals("quote"))
								{
									quote_ctr++;
								}
								
							}
								//if we take one token of the template list
								//we iterate through the pattern until it 
								//is found 
								//we continue scanning the pattern list
								//if its not found, the match fails
								
								//should keep going throguh pattern to
								///until it finds all the matches
								//if it runs out of templates it completes 
								//if it doesn't find all the matches
								//then it failsd. so if the templates run out
								//without all being matched it fails
								//how do i know that it didn't match all the of the templates
								//on completion of scanning was the template matched or not?
								
							}
						System.out.println("MATCH CTR " + match_ctr);
						if (match_ctr >= templateTokens.size())
						{
							System.out.println("Template: " + templateString);
							System.out.println("TEMPLATE MAATCHED");
							identifySpeaker(patternTokens, templateTokens, valueTokens);
							if (quote_ctr > 3)
							{
								//split sentence around quote 
								//run second half through identify speaker
								identifySpeakee(patternTokens, templateTokens, valueTokens);
						
							}
						}
						
					}


					return match;

				}
			}
		return null;
		
	
	}
	
	public ArrayList<String> tokenizeToList(String lists, ArrayList<String> values)
	{
		ArrayList<String> list = new ArrayList<String>();
		String pos = new String();
		String value = new String();
		//ArrayList<String> values = new ArrayList<String>();
		
		
		
		StringTokenizer st= new StringTokenizer(lists,"<");
		while (st.hasMoreTokens())
		{
			String nxt = st.nextToken();
			nxt = nxt.replace('>',' ');
			System.out.println("nxt is " + nxt);
			
			StringTokenizer st_inner = new StringTokenizer(nxt, ":");
			
			pos = st_inner.nextToken();
			
			
			//remove unused tags
			
			
			if (!pos.contains("template")  &&
					//!pos.contains("quote") &&
					!pos.contains("misctext") &&
					!pos.contains("open") &&
					!pos.contains("adverb") &&
					!pos.contains("adjective"))
			{
				list.add(pos);
				
				if (pos != null)
				{
					System.out.println("POS is" + pos);
				}
				if (st_inner.hasMoreTokens())
				{
					value = st_inner.nextToken();
					values.add(value);
					System.out.println("Value is " + value);
				}
				
				if (pos.contains("signalverb"))
				{
					list.add(value);
					System.out.println("Found VALUE " + value + " in tokenize list");
				} //correct
			}
				
			
			
		}
		if (list.contains("said"))
		{
			System.out.println("Found said in tokenize list");
		}
		
		return list;
		
		
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
	
	HashMap<String, String> identifySpeaker(ArrayList<String> source, ArrayList<String> template, ArrayList<String> values)
	{
		int template_ctr = 0;
		int pattern_ctr = 0;
		
		
		//signal verb is after speakernoun
		
		for (int i=0;i<template.size();i++)
		{
			
			//signal verb in front of speaker noun
			//find position of signal verb
			if (template.get(i).equals("signalverb"))
			{
				System.out.println("Found signal verb");
				if (i>0) 
				{
					if (template.get(i-1).equals("speakernoun"))
					{
						//speaker, said
						template_ctr = i;
						System.out.println("Template Counter stopped at " + i + template.get(i));
						System.out.print("Template: ");
						for (int k=0;k<template.size();k++)
						{
							System.out.println(template.get(k) + " " + k);
						}
						System.out.print("Pattern: ");
						for (int k=0;k<source.size();k++)
						{
							System.out.println(source.get(k) + " " + k);
						}
					}		
				}	
			}
			//signal verb before speakernoun
			if (template.get(i).equals("speakernoun"))
			{
				System.out.println("Found speakernoun");
				if (i>0)
				{
					if (template.get(i-1).equals("signalverb"))
					{
						//speaker, said
						template_ctr = i;
						System.out.println("Template Counter stopped at " + i + template.get(i));
						System.out.print("Template: ");
						for (int k=0;k<template.size();k++)
						{
							System.out.println(template.get(k) + " " + k);
						}
						System.out.print("Pattern: ");
						for (int k=0;k<source.size();k++)
						{
							System.out.println(source.get(k) + " " + k);
						}
					}		

				}

			
		}
		//System.out.println("Template Check - source at template_Ctr: " + source.get(template_ctr-1));
		
		if ((source.get(template_ctr).equals("noun") ))
		{
			//found a speaker
			System.out.println("IDENTIFIED A SPEAKER: " + values.get(template_ctr));
			//System.exit(-1);
			
		}
		
		}
		
		return null;
	}

	
	/***********IDENTIFY SPEAKEE***********/
	
	
	HashMap<String, String> identifySpeakee(ArrayList<String> source, ArrayList<String> template, ArrayList<String> values)
	{
		int template_ctr = 0;
		int pattern_ctr = 0;
		
		
		//split source at quote
		
		ArrayList<String> finalSource = new ArrayList<String>();
		
		int ctr =0;
		int count = 0;
		int quote_location = 0;
		
		if (source.contains("singlequote"))
		{
			System.out.println("Single Quote found in source");
		}
		
		for (ctr=0;ctr<source.size();ctr++)
		{
			System.out.println("FInal Source Speakee::" + source.get(ctr));
			if (source.contains("singlequote"))
			{
				System.out.println("Found a single quote in speakee, ctr = " + ctr);
				count++;
				if (count > 3)
				{
					quote_location = ctr;
					break;
				}
			}
		
		}
		
		for (int i = quote_location; i<source.size();i++)
		{
			System.out.println("Quote location:" + i);
			System.out.println("Adding source" + source.get(i));
			finalSource.add(source.get(i));
		}
		
		//signal verb is after speakernoun
		
		for (int i=0;i<template.size();i++)
		{
			
			//signal verb in front of speaker noun
			//find position of signal verb
			if (template.get(i).equals("signalverb"))
			{
				System.out.println("speakee::Found signal verb");
				if (i>0) 
				{
					if (template.get(i-1).equals("speakernoun"))
					{
						//speaker, said
						template_ctr = i;
						System.out.println("speakee::Template Counter stopped at " + i + template.get(i));
						System.out.print("speakee::Template: ");
						for (int k=0;k<template.size();k++)
						{
							System.out.println(template.get(k) + " " + k);
						}
						System.out.print("Pattern: ");
						for (int k=0;k<finalSource.size();k++)
						{
							System.out.println(finalSource.get(k) + " " + k);
						}
					}		
				}	
			}
			//signal verb before speakernoun
			if (template.get(i).equals("speakernoun"))
			{
				System.out.println("speakee::Found speakernoun");
				if (i>0)
				{
					if (template.get(i-1).equals("signalverb"))
					{
						//speaker, said
						template_ctr = i;
						System.out.println("speakee::Template Counter stopped at " + i + template.get(i));
						System.out.print("speakee::Template: ");
						for (int k=0;k<template.size();k++)
						{
							System.out.println(template.get(k) + " " + k);
						}
						System.out.print("speakee::Pattern: ");
						for (int k=0;k<finalSource.size();k++)
						{
							System.out.println(finalSource.get(k) + " " + k);
						}
					}		

				}

			
		}
			
		System.out.println("speakee:: template_Ctr" + template_ctr);
		System.out.println("speakee:: value at template_ctr" + finalSource.get(template_ctr));
		//System.out.println("Template Check - source at template_Ctr: " + source.get(template_ctr-1));
		
		if ((finalSource.get(template_ctr).equals("noun") ))
		{
			//found a speaker
			System.out.println("IDENTIFIED A SPEAKEE: " + values.get(template_ctr));
			//System.exit(-1);
			
		}
		
		}
		
		return null;
	}
			
	
	String [] preparePattern(String pattern, String pos, String lemma)
	{
		//convert patterns/templates into an array
		
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
		while (str.hasMoreTokens()) //while there are more tags
		{
			String st = str.nextToken(); //grab a template tag
			tmpcounter++;
			
			//while there are pattern tags
			StringTokenizer patternTok = new StringTokenizer(pattern, ">"); //tokenizzer on pattern
			while (patternTok.hasMoreTokens())
			{
				//spilt pattern tag
				String patternTag = patternTok.nextToken(); //grab a pattern tag				
				
				StringTokenizer ptoken = new StringTokenizer(patternTag); //grab a pattern tag
				
				while (ptoken.hasMoreTokens())
				{
					speakercounter++;
					
					String patternTagToken = ptoken.nextToken(); //grab a pattern tag
					
					String [] strArray = patternTagToken.split(":"); ///split over colon
					
					String nameOfToken = strArray[1];
					String partOfSpeech = strArray[0];
					
					System.out.println("Namae of Token: " + nameOfToken);
					System.out.println("Part of Speech" + partOfSpeech);
					
					
					//split template
					String [] tArray = template.split(":");
					String nameOfTemplateToken = tArray[0];
					String partOfSpeechTemplate = tArray[1];
		
					
					if (speakercounter == tmpcounter)
					{
						//positional match
						System.out.println("Discovered a positional matvh");
						System.out.println("Template Name: " + nameOfTemplateToken);
						System.out.println("Template Part of Speech " +  partOfSpeechTemplate);
						System.out.println("Pattern Name: " + nameOfToken);
						System.out.println("Part of Speech" + partOfSpeech);
						
						//save results
						HashMap<String, String> hash = new HashMap<String,String>();
						hash.put(nameOfToken, nameOfTemplateToken);     //template and pattern words
						
						return (hash);
					}
				}
			}

		}
		return null;
	}

	
	
	
	
	
	//A:: XML LISTS ARE SHOWING UP AS NULL!!! NOT GOOD!!@!
	public void printXMLList(String [] xMLList, String name)
	{
		if (xMLList == null)
		{
			System.out.println("print xml xmlList is null for )" + name);
			return;
		}
		for (int i=0;i<xMLList.length;i++)
		{
			System.out.println("XML LIst for " + name + xMLList[i]);
		}
	}
	
	public	void printPatternXMLList(String [] patternXML, String id)
	{
		System.out.print("Print Pattern XML::" );
		for (int i=0;i<patternXML.length;i++)
		{
			System.out.print(patternXML[i]);
		}
	}
	
	
	public String getSpeech(String inputTag)
	{
		String [] speech = inputTag.split(":");
		return speech[0];
	}
	
	public String getLemma(String inputTag)
	{
		String [] lemma = inputTag.split(":");
		if (lemma != null && lemma.length > 1)
		{
			return lemma[1];
		}
		
		return null;
	}
	

}


	


