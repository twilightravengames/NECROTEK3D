import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;




public class NPS {

	
	ScratchPad scratchPad = new ScratchPad();
	SentenceStack sentenceStack = new SentenceStack();
	String vozReturnString = null;
	
	public void run(String filename)
	{
		String fileString = loadTextFile(filename);
		System.out.println("NPS:run(): filestring=loadTExtFile is " + fileString);
		
		ArrayList<StackElement> elements = textFileToStackElement(fileString);
		pushToStack(elements);
		
		//run voz on filename and saved the output
		VozOutputGatherer(filename);
	}
	
	
	public String loadTextFile(String filename)
	{
		String fileString = null;      
		
		//loads a file (filename) and stores the file in textString
		BufferedReader fileLoad = null;
		try {
			fileLoad = new BufferedReader(new java.io.FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//file open, funnel file contents into string
		
		String sCurrentLine = null;
		 
		try {
			while ((sCurrentLine = fileLoad.readLine()) != null) {
				System.out.println(sCurrentLine);
				fileString = fileString + sCurrentLine;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileString;
		
	}
	
	
	
	//convert 
		
	
	ArrayList<StackElement> textFileToStackElement(String fileString)
	{
		ArrayList<StackElement> elements = new ArrayList<StackElement>();
		
		
		//this function takes the tokens and wraps them into StackElement
		//datatypes
		
		
		//after wrapping elements 
		//return them, as StackElements array
		
		StringTokenizer stArr=new StringTokenizer(fileString," ");
		int i=0;
		if (stArr != null)
		{
			if (stArr.hasMoreTokens())
			{
				while(stArr.hasMoreElements() && stArr.hasMoreTokens())
				{
					i++;
					String nextToken = stArr.nextToken();
					
					//System.out.println("Token  :"+nextToken);
					//System.out.println("");
					//System.out.println("NUmeral" + i);
					//System.out.println("Wrapping into Stack Element");
					StackElement stackElement = new StackElement();
					stackElement.setElementContent(nextToken);
					elements.add(stackElement);
					System.out.println("StackElement " + stackElement.getElementContent());
					System.out.println("LoadDocument Parser " + stackElement.getElementContent());
					if (stackElement.equals("say"))
					{
						System.out.println("LoadDocument Parse haas a copy of say");
						
						StackElement stackElement1 = new StackElement();
						stackElement1.setElementContent("signal verb");
						elements.add(stackElement1);
						System.out.println("Found and captured say"); //succesful
							
						
						
					}
				}
			}
		}
		return elements;
			
	}
	
	public void pushToStack(ArrayList<StackElement> elements)
	{
		for (StackElement element: elements )
		{
			sentenceStack.stack.push(element);
			System.out.println("pushStackElementArrayList():" + element.getElementContent());
			System.out.println("pushStackElementArrayList(): pushing to sentencestack: " + element.getElementContent());
			
		  }
	   }
	
	  
	public void VozOutputGatherer(String filename)
	{
		Runtime rt = Runtime.getRuntime();
	
		//Send POST to VOZ
		
		
		vozReturnString = cmdExec("/usr/local/bin/wget -qO- --post-file=/Users/ted_gress/Documents/workspace/NPSJava/src/" + filename + " http://127.0.0.1:8080/rpc");
		

		System.out.println("VozOutputGatherer returnString" + vozReturnString);
		
		
		System.out.println("VozOutputGathere cmdExec: " + vozReturnString);
		
	}
	
	//////////////////////
	//
	// Executes a command line string
	//
	//////////////////////

	//testing sendPost
	public String cmdExec(String wgetLine) {
		String line;
		String output = "";
		Process p = null;

		System.out.println("cmdEEC runing string: " + wgetLine);
		System.out.println("Running functionu cmdEXEC");
		try {
			try {
				p = Runtime.getRuntime().exec(wgetLine);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			BufferedReader input = new BufferedReader
					(new InputStreamReader(p.getInputStream()));


			while ((line = input.readLine()) != null) {
				output += line + '\n';
			}

			System.out.println("cmdExec" + wgetLine + '\n');

			input.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("OUTPUT CMDEXEC STRING " + output);

		return output;
	}
	
	public XMLPattern mainLoop()
	{
		XMLPattern pattern = null;
		//Processes one single sentence
		//each iteration of the while loop processes one word
		//outside the  loop processes th sentence
		System.out.println("Sentence Stack Size is " + sentenceStack.stack.size());
		
		//sentenceStack.pop is null
		while(!sentenceStack.stack.isEmpty())
		{
			
			sentenceStack.reverseStack.push(sentenceStack.stack.pop());
		}
		
		//while (!sentenceStack.reverseStack.isEmpty())
		//{
			//System.out.println("Reverse Sentence Stack Size is " + sentenceStack.reverseStack.size());

			
			//System.out.println("Constructing XML Pattern");
			
			//get pattern made up of patterntags
		
			//scratchpad is empty here and shouldn't be
		
			pattern = getXMLPattern(scratchPad);
			
			//for (int i=0; i<pattern.XMLPatternType.size();i++)
			//{
			//	//pattern is null
			//	System.out.println("Pattern constructed: " + pattern.XMLPatternType.get(i));
			//}
			
		//}
		/*
		System.out.println("Printing XML Pattern");
		if (pattern.XMLPatternType == null)
		{
			System.out.println("XMLType is null");
		}
		for (XMLPatternTag tag : pattern.XMLPatternType)
		{
			if (tag.name == null)
			{
				System.out.println("Tag is null");
			}
			System.out.print(tag.name);
		}*/
		return pattern;
		
	}
	
	public XMLPatternTag findSentencePartOfSpeech(ScratchPad scratchpad, StackElement elmnt, XMLPatternTag xmlPatternTag)
	{
		
		StackElement previous = new StackElement();
		StackElement next = new StackElement();
		
		
		StackElement emt1 = sentenceStack.reverseStack.pop();
		StackElement emt2 = sentenceStack.reverseStack.pop();
		StackElement emt3 = sentenceStack.reverseStack.pop();

		
		while(!sentenceStack.reverseStack.isEmpty())
		{
			 
			 previous.next = elmnt;
			
			//below is  working
			if ((elmnt.elementContent.equals("said")) ||
				 (elmnt.elementContent.equals("say!")) ||
				 (elmnt.elementContent.equals("say")) ||
				 (elmnt.elementContent.equals("replied")) ||
				 (elmnt.elementContent.equals("called")) ||
				 (elmnt.elementContent.equals("speak")) ||
				 (elmnt.elementContent.equals("asked")))	
				
			{
				System.out.println("Found say signal verb");
				
				
				 
				
				
			}
			

			previous= elmnt;
			

			emt1 = emt2;
			emt2 = emt3;
			emt3 = sentenceStack.reverseStack.pop();
			
		}		
		
		return xmlPatternTag;
	}

	
		
	public void sendFlexibleArray() //flexibnle
	{
		System.out.println("sendFlexibleArray();");
		
			//get JSON Array or JSON Object from initial object
			//call function with length of array if JSON Array
			//?get JSON Array or JSON Object from parameter object
			//?call function with length of array if JSON Array
			///?continue recursively calling functions for array
			//once inside innermost array, recursive function will execute in while loop[
				//with the number of iterations equal to length
		
		//grab initial object
		
		int total_counter = 0;
		//clear out punctuation
		
		//JSONStringPunctuationUtility jutil = new JSONStringPunctuationUtility();
		//jSONString = jutil.stripPunctuation(jSONString);

		//: A JSONARrray text must start with [ at 1 [character 2 line 1]
		
		//Working with VOZ's output
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(vozReturnString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		//BLOCK BELOW CAUSING PROBLEMS
		JSONArray json_array = null;
		JSONObject json_object = null;
		
		//throwing an exception on payload6.txt (below)
		try {
			//JSONTokener parses text for JSONArray and JSONObject\
			//see exception being thrown
			//JSONTokener token = new JSONTokener(is);
			JSONTokener token = new JSONTokener(vozReturnString);
			
			System.out.println("Return String " + vozReturnString);
			
			//token is false
			System.out.println("Token Next Test " + token.more());
			if (token.more())
			{
				System.out.println("More tokens");
				//line below is the problem? Must be throwing an exception
				//Object json = new JSONTokener(is).nextValue();
				Object json = token.nextValue();
				System.out.println("Preparing instanceofs");
				
				
				if (json instanceof JSONObject)
				{
					json_object = (JSONObject)json;
					System.out.println("I have an object");
				  //you have an object
				}
				
				else if (json instanceof JSONArray)
				{
					json_array = (JSONArray)json;
					System.out.println("I have an array");
					//you have an array
				}
			}
			
			else
			{
				System.out.println("No tokens remaining");
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		System.out.println("Launching array iteration");
		System.out.println("Print statements are working.");
		String parseString = new String();
		if (json_array != null)
		{
			System.out.println("Launching arrayIteration from flexible::json_object");
			arrayIteration(json_array, 0, scratchPad, parseString);
			DetermineVoZOutput dvo = new DetermineVoZOutput();
			dvo.runVoZDeterminer(scratchPad, json_array, 0);

		}
		
		else if(json_object != null)
		{
			System.out.println("Launching arrayIteration from flexible::json_array");
			arrayIteration(json_object, 0,  scratchPad, parseString);
			DetermineVoZOutput dvo = new DetermineVoZOutput();
			dvo.runVoZDeterminer(scratchPad, json_object, 0);

		}
		
		else 
		{
			System.out.println("JSON_ARRAY or JSON_OBJECT is null");
		}
		
		
	}
//it isn't running array iteration for some reason
	void arrayIteration(Object inputObject, int counter, ScratchPad scratchPad, String parseString)
	{

		//either grab JSONObject or JSONArray 
		//from jsonArray parameter
		//if it is a JSONObject come to full stop

		System.out.println("ArrayIteration " + counter);

		if (scratchPad == null)
		{
			System.out.println("Beginning of arrayiteration, scratchpa is null");

		}
		if (inputObject == null)
		{
			return;
		}



		JSONArray jArray = null;
		JSONObject jObject = null;


		//JObjects are enclosed in { }
		//JArrays contain verbs, nouns, and JSONObject
		if (inputObject instanceof JSONArray)
		{




			System.out.println("Found JARRAY");
			jArray = (JSONArray) inputObject;
			System.out.println("inputObject instanceof JSONArray");
			for (int ctr = 0; ctr<jArray.length();ctr++)
			{
				System.out.println("Calling array iteration");
				System.out.println("Length of jArray " + jArray.length());
				System.out.println("jsONARRAY ctr " + ctr);

				try {

					System.out.println("jsONARRAY TRY " + ctr);
					System.out.println("jsonARray instance of String " + ((JSONArray)(inputObject)).get(ctr));

					/*
					 * 
					 * The IF Condition below is not working properly
					 *  and is likely the problem that is occuring
					 *  with the scatchpad
					 * 
					 */

					
					
				}

				catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				Object jsonObject = null;
				try {

					jsonObject = jArray.get(ctr);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DetermineVoZOutput dvo = new DetermineVoZOutput();
				dvo.runVoZDeterminer(scratchPad, inputObject, counter);

				//scratchpad is empty here for some reason
				System.out.println("Signal Verbs : " + scratchPad.signalVerb.size());
				System.out.println("Direct Verbs : " + scratchPad.directVerb.size());
				System.out.println("Direct Objects: " + scratchPad.directObject.size());
				System.out.println("Nouns : " + scratchPad.noun.size());
				System.out.println("Adverbs: " + scratchPad.adverb.size());
				System.out.println("Open Quote: " + scratchPad.open_quote.size());
				System.out.println("Close Quote: " + scratchPad.close_quote.size());
				System.out.println("Adjectives: " + scratchPad.adjective.size());
				System.out.println("Prepositiion: " + scratchPad.prep.size());
				System.out.println("Pronouns: " + scratchPad.pronouns.size());
				System.out.println("Conjunctions: " + scratchPad.conjunction.size());
				System.out.println("Possesive Pronouns: " + scratchPad.pos_pronoun.size());
				
				for (int i=0;i<scratchPad.signalVerb.size();i++)
				{
					System.out.println("Signal verbs are: " + scratchPad.signalVerb.get(i));
				}
				//not sure about including the jsonstring
				
				arrayIteration(jsonObject, counter, scratchPad, parseString);

				

			}




			if (inputObject instanceof JSONObject)
			{
				System.out.println("Found JOBJECT");
				jObject = (JSONObject) inputObject;
				///System.out.println("JOBJECT content " + jObject.)

				JSONObject arguments = null;

				Iterator<String> iter = (Iterator<String>)jObject.keys();

				// System.out.println("Status of map " + iter.)

				String next = null;
				String value = null;

				System.out.println("Entering argument loop");

				while(iter.hasNext())
				{

					next = iter.next();

					try {
						value = jObject.getString(next);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


					System.out.println("Got next and valuei");



					//if ((next != null) && (value != null))
					//{
					System.out.println("Outputting JSONOBject data");

					System.out.println("JOBject is " + jObject);
					System.out.println("next is " + next);
					System.out.println("value is " + value);
			
					ArgumentPOS argPOS = new ArgumentPOS();



					argPOS.key = next;
					argPOS.value = value;

					next = null;
					value = null;

				}

				arrayIteration(inputObject, counter, scratchPad, parseString);
			} 	

		}
	}
	//this funtion is called once only
	//this function is returning null
	public XMLPattern getXMLPattern(ScratchPad scratchpad)
	{

		//create new pattern
		XMLPattern xmlPattern = new XMLPattern();

		
		//Stack<StackElement> repeatStack = new Stack<StackElement>();

		//create a new xmlPatternTag
		XMLPatternTag XMLPatternTag = new XMLPatternTag();
		
		System.out.println("ReverseStack size is " + sentenceStack.reverseStack.size());

		//reverse stack is populated
		//this function is only executing once
		System.out.println("sentenceStack reverse " + sentenceStack.reverseStack.size());
		//only executing this for loop once????
		while (!sentenceStack.reverseStack.isEmpty())
		{
			//temporary stack - size is 41 but only executes once
			System.out.println("Reverse stack zsize is " + sentenceStack.reverseStack.size());
			//1. pop word off of stack
			//currently word popped off stack is null!!!
			StackElement element = sentenceStack.reverseStack.pop();
			System.out.println("Sentencestack-reverseStack size " + sentenceStack.reverseStack.size());
			System.out.println("Reverse Stack popped value " + element.elementContent);
			
			sendFlexibleArray();
		
			StackToTag stackToTag = new StackToTag();
			XMLPatternTag = stackToTag.generatePatternTag(element, scratchpad, XMLPatternTag, sentenceStack);

			//System.out.println("XML Pattern Tag is " + XMLPatternTag.name);
			
			//System.out.println("FINDPOS XMLPatternTag: " + XMLPatternTag.name);

		
			//System.out.println("getXMLPattern: " + XMLPatternTag.name);


			

			xmlPattern.XMLPatternType.add(XMLPatternTag);		

		}
		
		System.out.print("XML Pattern is: ");

		if (xmlPattern == null)
		{
			System.out.println("xmlPattern is null");
		}
		if (xmlPattern.XMLPatternType == null)
		{
			System.out.println("XMLPatternType is null");
		}
		if (xmlPattern.XMLPatternType.size() == 0)
		{
			System.out.println("XML Pattern Size" + xmlPattern.XMLPatternType.size());
		}
		//display XML Pattern
		//xml pattern is showing up as null
		for (int i = 0; i<xmlPattern.XMLPatternType.size();i++)
		{
			System.out.println(xmlPattern.XMLPatternType.get(i));
		}
		
		return xmlPattern;
	
		
	}

	
	
	
	

	public String convertXMLPatternToString(XMLPattern source)
	{
		//String output = null;
		XMLPatternTag n = source.XMLPatternType.get(0);


		String output = n.name;

		for (int k=1; k<source.XMLPatternType.size();k++)
		{
			XMLPatternTag tags = source.XMLPatternType.get(k);

			output = output + tags.name;
		}

		System.out.println("convertXMLPattern " + output);

		return output;
	}

	public HashMap<String,String> comparePatterns(String source, HashMap<String,String> match, String template)
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
					System.out.println("Origin template " + template);
					System.out.println("Origin patterns " + source);
					
					//**need to have access to prev noun, current verb, and next noun
					//if noun is <speakernoun><misc><signalverb> then speakernoun is speaker
					//if noun is <signalverb><misc><speakernoun> then speakernoun is speaker
					//remaining nouns could be speakee

					HashMap<String,String> m = (identifySpeaker(source, template));

					//match is null
					if (match == null)
					{
						System.out.println("m null");
					}

					match.putAll(m);

					HashMap<String, String> e = (identifySpeakee(source, template));



					//identifySpeakee(source, template);
					//printHashMap(match, "Speakers");
					//printHashMap(e, "Speakees");
					match.putAll(e);


					if (e == null)
					{
						System.out.println("speakee is null");
					}

					if (m == null)
					{
						System.out.println("speaker is null");
					}

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
	
	

}


	
