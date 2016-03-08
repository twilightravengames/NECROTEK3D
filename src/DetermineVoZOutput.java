import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetermineVoZOutput {

		
		
	
	
		public void runVoZDeterminer(ScratchPad scratchPad, Object inputObject, int ctr)
		{

			try {
			//ITS ONLY SHOWING NOUN TAGS AND ITS SHOWING MULTIPLES OF THEM

			String parseString = new String();
			
			if(((JSONArray)(inputObject)).get(ctr) instanceof String)
			{



			
				JSONStringPunctuationUtility punc = new JSONStringPunctuationUtility();


			
				//First Block should ALWAYS CAPTURE a verb
				//Second Block shoujld ALWAYS CAPTURE a noun

				//Blocks cannot be consecutive because one takes over the other
				StackElement completeElmntCont = null;
				StackElement completeElmntContN = null;
				StackElement completeElmntContR = null;
				StackElement completeElmntContQ = null;
				StackElement completeElmntContD = null;
				StackElement completeElmntContJ = null;
				StackElement completeElmntContT = null;
				StackElement completeElmntContW = null;
				StackElement completeElmntContC = null;
				StackElement completeElmntContM = null;
				StackElement completeElmntContP = null;
				StackElement completeELmntContX = null;

				StackElement completeElmntCont2 = null;
				StackElement completeElmntContN2 = null;
				StackElement completeElmntContR2 = null;
				StackElement completeElmntContQ2 = null;
				StackElement completeElmntContD2 = null;
				StackElement completeElmntContJ2 = null;
				StackElement completeElmntContT2 = null;
				StackElement completeElmntContW2 = null;
				StackElement completeElmntContC2 = null;
				StackElement completeElmntContM2 = null;
				StackElement completeElmntContP2 = null;
				StackElement completeELmntContX2 = null;





				//System.out.println("Verbs: Contents of innermost array " + ((JSONArray)(inputObject)).getString(++ctr));
				String word = ((JSONArray)(inputObject)).getString(ctr);
				//word is correct JSONArray data might not be corrupt
				System.out.println("Starting test on alphabet string is "  + word);

				//value of this word above is correct


				parseString = parseString + word;
				System.out.println("parse arrayIteration: " + parseString);

				//before stripping punctuation
				//execute this routine before stripping the quotes
				//String word = ((JSONArray)(inputObject)).getString(ctr);
				//System.out.println("WORD IS..." + word);

				//THIS IS PROBABLY THE SOURCE OF THE CLOSE QUOTE FIX
				if (word.startsWith("\\"))
				{
					System.out.println("Open Quote - getElementContent Value");
					scratchPad.quote.add("open quote");	
					System.out.println("JSONINTERFACE QUOTE");

				}




				if (word.startsWith("V"))
				{
					System.out.println("VERB");
					//Below gets the following information
					word = ((JSONArray)inputObject).getString(1);
					System.out.println("Inside a verb, string is " + word);
					System.out.println("Verbs: Captured verb: " + word);
					StackElement wordElementContent = new StackElement();
					System.out.println("wordElementContent" + wordElementContent.elementContent);
					wordElementContent.setElementContent(word);
					completeElmntCont = punc.stripElementPunctuation(wordElementContent);
					completeElmntCont.isVerb = true;
					completeElmntCont.isNoun = false;
					System.out.println("completeElmnTont" + completeElmntCont.elementContent);
					//word = ((JSONArray)inputObject).getString(++ctr);
					//System.out.println("VERB 2 " + word);

					//inputObject is inputObject.toString()["N","pig","Pig",[0,{}]]
					//String arrayBracketSystem = inputObject.toString();
					///System.out.println("entire word is " + arrayBracketSystem);

					//extractVerbArguments(arrayBracketSystem, scratchPad);
					//ctr--;

				}

				if (word.startsWith("V"))
				{
					System.out.println("VERB2");
					//Below gets the following information
					word = ((JSONArray)inputObject).getString(2);
					System.out.println("Inside a verb, string is " + word);
					System.out.println("Verbs: Captured verb: " + word);
					StackElement wordElementContent = new StackElement();
					System.out.println("WordElementContent" + wordElementContent.getElementContent());
					wordElementContent.setElementContent(word);
					completeElmntCont2 = punc.stripElementPunctuation(wordElementContent);
					completeElmntCont2.isVerb = true;
					completeElmntCont2.isNoun = false;
					//word = ((JSONArray)inputObject).getString(++ctr);
					//System.out.println("VERB 2 " + word);

					//inputObject is inputObject.toString()["N","pig","Pig",[0,{}]]
					//String arrayBracketSystem = inputObject.toString();
					///System.out.println("entire word is " + arrayBracketSystem);

					//extractVerbArguments(arrayBracketSystem, scratchPad);
					//ctr--;

				}



				//=
				//testing NOUN again

				if (word.startsWith("J"))
				{
					word = ((JSONArray)inputObject).getString(1);
					System.out.println("Adjective: :" + word);
					StackElement adjective = new StackElement();
					adjective.setElementContent(word);
					System.out.println("Inside an qadjective article, string is " + word);
					System.out.println("Adjecctive: : " + word);
					completeElmntContJ = punc.stripElementPunctuation(adjective);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//actr--;
				}

				if (word.startsWith("J"))
				{
					word = ((JSONArray)inputObject).getString(2);
					System.out.println("Adjective2: :" + word);
					StackElement adjective = new StackElement();
					adjective.setElementContent(word);
					System.out.println("Inside an qadjective2 article, string is " + word);
					System.out.println("Adjecctive: : " + word);
					completeElmntContJ2 = punc.stripElementPunctuation(adjective);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//actr--;
				}

				if (word.startsWith("N"))
				{
					word = ((JSONArray)inputObject).getString(1);
					System.out.println("Nouns: Captured noun:" + word);
					StackElement nounElementContent = new StackElement();
					nounElementContent.setElementContent(word);
					completeElmntContN = punc.stripElementPunctuation(nounElementContent);
					completeElmntContN.isNoun = true;
					completeElmntContN.isVerb= false;
					System.out.println("NOUN");
					word = ((JSONArray)inputObject).getString(++ctr);
					System.out.println("NOUN2:" + word);
					completeElmntContN.setElementContent(word);

					System.out.println("NOUN2 data " + word);
					System.out.println("Noun Parsed " + completeElmntContN.getElementContent());
					//inputObject is inputObject.toString()["N","pig","Pig",[0,{}]]
					String arrayBracketSystem = inputObject.toString();
					System.out.println("entire word is " + arrayBracketSystem);

				}		

				if (word.startsWith("N"))
				{
					word = ((JSONArray)inputObject).getString(2);
					System.out.println("Nouns2: Captured noun:" + word);
					StackElement nounElementContent = new StackElement();
					nounElementContent.setElementContent(word);
					completeElmntContN2 = punc.stripElementPunctuation(nounElementContent);
					completeElmntContN2.isNoun = true;
					completeElmntContN2.isVerb= false;
					System.out.println("NOUN");
					word = ((JSONArray)inputObject).getString(++ctr);
					System.out.println("NOUN2:" + word);
					completeElmntContN2.setElementContent(word);

					System.out.println("NOUN2 data " + word);
					System.out.println("Noun Parsed " + completeElmntContN2.getElementContent());
					//inputObject is inputObject.toString()["N","pig","Pig",[0,{}]]
					String arrayBracketSystem = inputObject.toString();
					System.out.println("entire word is " + arrayBracketSystem);

				}		








				//System.out.println("Nouns: Contents of innermost array " + ((JSONArray)(inputObject)).getString(ctr));
				//word = ((JSONArray)inputObject).getString(++ctr);

				//System.out.println("Verbs: Contents of innermost array " + ((JSONArray)(inputObject)).getString(ctr));
				//word = ((JSONArray)(inputObject)).getString(++ctr); //set up for Nouns;

				//System.out.println("Starting test on N, string is "  + word);


				JSONArray j_son_array = null;
				JSONObject j_son_obj = null;



				//adverbs
				//showing uip as adjeective
				if (word.startsWith("R"))
				{
					word = ((JSONArray)inputObject).getString(1);
					System.out.println("Adverbs: Captured adverb:" + word);
					StackElement adverbElementContent = new StackElement();
					adverbElementContent.setElementContent(word);
					System.out.println("Inside an adverb, string is " + word);
					System.out.println("AdVerbs: Captured verb: " + word);
					completeElmntContR = punc.stripElementPunctuation(adverbElementContent);
					completeElmntContR.isNoun = true;
					completeElmntContR.isVerb= false;
					completeElmntContR.isAdverb = true;
					//ctr--;
				}

				if (word.startsWith("R"))
				{
					word = ((JSONArray)inputObject).getString(2);
					System.out.println("Adverbs: Captured adverb:" + word);
					StackElement adverbElementContent = new StackElement();
					adverbElementContent.setElementContent(word);
					System.out.println("Inside an adverb, string is " + word);
					System.out.println("AdVerbs: Captured verb: " + word);
					completeElmntContR2 = punc.stripElementPunctuation(adverbElementContent);
					completeElmntContR2.isNoun = true;
					completeElmntContR2.isVerb= false;
					completeElmntContR2.isAdverb = true;
					//ctr--;
				}

				/*
					if (word.startsWith("D"))
					{
						word = ((JSONArray)inputObject).getString(0);
						System.out.println("Definite Article: :" + word);
						StackElement definiteArticle = new StackElement();
						definiteArticle.setElementContent(word);
						System.out.println("Inside an defininite article, string is " + word);
						System.out.println("Definite ARticle: Captured article: " + word);
						completeElmntContD = punc.stripElementPunctuation(definiteArticle);
						//completeElmntContD.isNoun = true;
						//completeElmntContR.isVerb= false;
						//completeElmntContR.isAdverb = true;
						//ctr--;
					}
				 */
				//conjunction


				if (word.startsWith("T") || word.startsWith("0"))
				{
					word = ((JSONArray)inputObject).getString(1);
					System.out.println("Preposition: :" + word);
					StackElement preposition = new StackElement();
					preposition.setElementContent(word);
					System.out.println("Inside an preposition, string is " + word);
					System.out.println("Preposition: Captured preposition: " + word);
					completeElmntContT = punc.stripElementPunctuation(preposition);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;


				}

				if (word.startsWith("T") || word.startsWith("I"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Preposition: :" + word);
					StackElement preposition = new StackElement();
					preposition.setElementContent(word);
					System.out.println("Inside an preposition, string is " + word);
					System.out.println("Preposition: Captured preposition: " + word);
					completeElmntContT2 = punc.stripElementPunctuation(preposition);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;


				}

				if (word.startsWith("W"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Pronouns: :" + word);
					StackElement pronoun = new StackElement();
					pronoun.setElementContent(word);
					System.out.println("Inside an pronoun, string is " + word);
					System.out.println("Pronoun: Captured pronoun: " + word);
					completeElmntContW = punc.stripElementPunctuation(pronoun);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//ctr--;
				}

				if (word.startsWith("W"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Pronouns: :" + word);
					StackElement pronoun = new StackElement();
					pronoun.setElementContent(word);
					System.out.println("Inside an pronoun, string is " + word);
					System.out.println("Pronoun: Captured pronoun: " + word);
					completeElmntContW2 = punc.stripElementPunctuation(pronoun);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//ctr--;
				}



				if (word.startsWith("C"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Conjunctions: :" + word);
					StackElement conjunction = new StackElement();
					conjunction.setElementContent(word);
					System.out.println("Inside a conjuction " + word);
					System.out.println("conjuction: Captured conjuction " + word);
					completeElmntContC = conjunction;
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//ctr--;
					if (completeElmntContC == null)
					{
						System.out.println("Conjunctions  null");


					}
					if (completeElmntContC != null)
					{
						System.out.println("COnjunction not null");

					}

				}

				if (word.startsWith("C"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Conjunctions: :" + word);
					StackElement conjunction = new StackElement();
					conjunction.setElementContent(word);
					System.out.println("Inside a conjuction " + word);
					System.out.println("conjuction: Captured conjuction " + word);
					completeElmntContC2 = conjunction;
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//ctr--;
					if (completeElmntContC2 == null)
					{
						System.out.println("Conjunctions  null");


					}
					if (completeElmntContC2 != null)
					{
						System.out.println("COnjunction not null");

					}

				}

				if (word.startsWith("P"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Poss Pronoun: :" + word);
					StackElement possesivepronoun = new StackElement();
					possesivepronoun.setElementContent(word);
					System.out.println("Inside an possessive pronoun, string is " + word);
					System.out.println("Adjective: poss pronoun poss pronoun: " + word);
					completeElmntContP = punc.stripElementPunctuation(possesivepronoun);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//ctr--;
				} 

				if (word.startsWith("P"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Poss Pronoun: :" + word);
					StackElement possesivepronoun = new StackElement();
					possesivepronoun.setElementContent(word);
					System.out.println("Inside an possessive pronoun, string is " + word);
					System.out.println("Adjective: poss pronoun poss pronoun: " + word);
					completeElmntContP2 = punc.stripElementPunctuation(possesivepronoun);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//ctr--;
				} 

				if (word.startsWith("M"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Verb : :" + word);
					StackElement mverb = new StackElement();
					mverb.setElementContent(word);
					System.out.println("Verb  " + word);
					System.out.println("WouldVerb " + word);
					completeElmntContM = punc.stripElementPunctuation(mverb);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//actr--;
				}

				if (word.startsWith("M"))
				{
					word = ((JSONArray)inputObject).getString(0);
					System.out.println("Verb : :" + word);
					StackElement mverb = new StackElement();
					mverb.setElementContent(word);
					System.out.println("Verb  " + word);
					System.out.println("WouldVerb " + word);
					completeElmntContM2 = punc.stripElementPunctuation(mverb);
					//completeElmntContD.isNoun = true;
					//completeElmntContR.isVerb= false;
					//completeElmntContR.isAdverb = true;
					//actr--;
				}

				if (word.contains("?") && !scratchPad.close_quote.contains("close quote"))

				{
					System.out.println("Close Quote Question Mark discovered");
					scratchPad.close_quote.add("close quote");

					//only exeutes once
					System.out.println("Adding closing quote to scratchpad: ");

				}

				if (word.contains(".") && !scratchPad.close_quote.contains("close quote"))

				{
					System.out.println("Close Quote Period discovered");
					scratchPad.close_quote.add("close quote");

					//only exeutes once
					System.out.println("Adding closing quote to scratchpad: ");

				}

				if (word.contains("!") && !scratchPad.close_quote.contains("close quote"))

				{
					System.out.println("Close Quote Exclamation Mark discovered");
					scratchPad.close_quote.add("close quote");

					//only exeutes once
					System.out.println("Adding closing quote to scratchpad: ");

				}

				if (word.contains(",'") && !scratchPad.close_quote.contains("close quote"))				
				{
					System.out.println("Close Comma Quote discovered");
					scratchPad.close_quote.add("close quote");

					//only exeutes once
					System.out.println("Adding closing quote to scratchpad: ");
				}

				if (word.contains("\"") && !scratchPad.open_quote.contains("open quote"))				
				{
					System.out.println("Open Comma Quote discovered");
					scratchPad.open_quote.add("open quote");

					//only exeutes once
					System.out.println("Adding open quote to scratchpad: ");
					//System.exit(-1);
				}
				
				if (word.contains("say"))
				{
					scratchPad.signalVerb.add("say");
				}
				
				if (word.contains("said"))
				{
					scratchPad.signalVerb.add("said");
				}
				
				if (word.contains("says"))
				{
					scratchPad.signalVerb.add("says");
				}
				
				if (word.contains("replied"))
				{
					scratchPad.signalVerb.add("replied");	
				}
				if (word.contains("called"))
				{
					scratchPad.signalVerb.add("called");
				}
				
				if (word.contains("speak"))
				{
					scratchPad.signalVerb.add("speak");
				}
				
				if (word.contains("spoke"))
				{
					scratchPad.signalVerb.add("spoke");
				}
				
				if (word.contains("ask"))
				{
					scratchPad.signalVerb.add("ask");
				}
				
				if (word.contains("asked"))
				{
					scratchPad.signalVerb.add("asked");
				}


				/////////////////////////////////////////////////
				/// WRITE TO SCRATCH BELOW
				//////////////////////////////////////////////////



				/*
				 * 
				 * 
				 *  Determine the correct part of speech in the scratchpad
				 *  and add// it to there
				 * 
				 * 
				 * 
				 */

			


				//THIS WILL BE REPLACED WITH THE SIGNAL VERB SYNONYMS
//
//				System.out.println("Testing signal verb");
//				//tag appears, wrong value
//				if ((completeElmntCont != null && !scratchPad.signalVerb.contains(completeElmntCont.getElementContent())))  
//				{	
//					System.out.println("Signal Verb detected");
//					//signal verb
//					if (completeElmntCont.getElementContent().equals("say"))
//
//					{
//						scratchPad.signalVerb.add(completeElmntCont.getElementContent());
//						System.out.println("signalVerb being added");
//					}	
//				}

				System.out.println("Testing direct verb");
				if ((completeElmntCont != null && !scratchPad.directVerb.contains(completeElmntCont.getElementContent())))
				{

					//direct verb

					System.out.println("directVerb detected");
					scratchPad.directVerb.add(completeElmntCont.getElementContent());

					//scratchpad.directVerb.add(elmnt.getElementContent());
					//scratchpad.verb.remove(j);


				}

				


				System.out.println("testing direct verb 2: " + completeElmntCont2);


				if ((completeElmntCont2 != null && !scratchPad.directVerb.contains(completeElmntCont2.getElementContent())))

					//direct verb
				{

					System.out.println("direct Verb detected");

					scratchPad.directVerb.add(completeElmntCont2.getElementContent());

					//scratchpad.directVerb.add(elmnt.getElementContent());
					//scratchpad.verb.remove(j);
				}



				//if(!scratchPad.verb.contains(completeElmntCont2))
				//{
				//	scratchPad.verb.add(completeElmntCont2.getElementContent());

				//}

				//System.out.println("Adding  verb to scratchpad: " + completeElmntCont2.elementContent);





				//appears, but only twice and sdhould be more
				System.out.println("Testing noun");

				if ((completeElmntContN != null) && !scratchPad.containsNoun(completeElmntContN.elementContent)) ///&& !scratchPad.noun.contains(completeElmntContN.getElementContent())))
				{
					if (!scratchPad.noun.contains(completeElmntContN.elementContent))
					{ 
						scratchPad.noun.add(completeElmntContN.elementContent);
					}
					//scratchPad.noun.add("noun");

					//All nouns are processed
					System.out.println("Adding noun to scratchpad: " + completeElmntContN.elementContent);

				}

				if ((completeElmntContN2 != null) && !scratchPad.containsNoun(completeElmntContN2.elementContent)) ///&& !scratchPad.noun.contains(completeElmntContN.getElementContent())))
				{
					if (!scratchPad.noun.contains(completeElmntContN2.elementContent))
					{ 
						scratchPad.noun.add(completeElmntContN2.elementContent);
					}
					//scratchPad.noun.add("noun");

					//All nouns are processed
					System.out.println("Adding noun to scratchpad: " + completeElmntContN2.elementContent);

				}



				//doesn't show up
				if ((completeElmntContR != null && !scratchPad.adverb.contains(completeElmntContR.getElementContent())))
				{
					if (!scratchPad.adverb.contains(completeElmntContR))
					{
						scratchPad.adverb.add(completeElmntContR.elementContent);
					}
					//scratchPad.noun.add("noun");
					//all adverbs are processed
					System.out.println("Adding adverb to scratchpad: " + completeElmntContR.elementContent);

				}

				if ((completeElmntContR2 != null && !scratchPad.adverb.contains(completeElmntContR2.getElementContent())))
				{
					if (!scratchPad.adverb.contains(completeElmntContR2))
					{
						scratchPad.adverb.add(completeElmntContR2.elementContent);
					}
					//scratchPad.noun.add("noun");
					//all adverbs are processed
					System.out.println("Adding adverb to scratchpad: " + completeElmntContR.elementContent);

				}

				/*
					//doesn't show up
					if ((completeElmntContD != null && !scratchPad.def_article.contains(completeElmntContD.getElementContent())))
					{
						if (!scratchPad.def_article.contains(completeElmntContD))
						{
							scratchPad.def_article.add(completeElmntContD.elementContent);
						}
						//scratchPad.noun.add("noun");
						//seems as all definite articles are processed
						System.out.println("Adding definite article to scratchpad: " + completeElmntContD.elementContent);

					}

					if ((completeElmntContD2 != null && !scratchPad.def_article.contains(completeElmntContD2.getElementContent())))
					{
						if (!scratchPad.def_article.contains(completeElmntContD2))
						{
							scratchPad.def_article.add(completeElmntContD2.elementContent);
						}
						//scratchPad.noun.add("noun");
						//seems as all definite articles are processed
						System.out.println("Adding definite article to scratchpad: " + completeElmntContD2.elementContent);

					}*/

				//tag appears, wrong value
				if ((completeElmntContJ != null && !scratchPad.adjective.contains(completeElmntContJ.getElementContent())))
				{
					if (!scratchPad.adjective.contains(completeElmntContJ))
					{
						scratchPad.adjective.add(completeElmntContJ.elementContent);
					}
					//incorrect entries
					System.out.println("Adding adjective to scratchpad: " + completeElmntContJ.elementContent);

				}


				if ((completeElmntContJ2 != null && !scratchPad.adjective.contains(completeElmntContJ2.getElementContent())))
				{
					if (!scratchPad.adjective.contains(completeElmntContJ2))
					{
						scratchPad.adjective.add(completeElmntContJ2.elementContent);
					}
					//incorrect entries
					System.out.println("Adding conjunction to scratchpad: " + completeElmntContJ2.elementContent);

				}

				//appears multiple times, wrong value
				if ((completeElmntContT != null && !scratchPad.prep.contains(completeElmntContT.getElementContent())))

				{
					if (!scratchPad.prep.contains(completeElmntContT))
					{
						scratchPad.prep.add(completeElmntContT.elementContent);
					}
					//scratchPad.noun.add("noun");
					//incorrect entries
					System.out.println("Adding prep to scratchpad: " + completeElmntContT.elementContent);

				}

				if ((completeElmntContT2 != null && !scratchPad.prep.contains(completeElmntContT2.getElementContent())))

				{
					if (!scratchPad.prep.contains(completeElmntContT2))
					{
						scratchPad.prep.add(completeElmntContT2.elementContent);
					}
					//scratchPad.noun.add("noun");
					//incorrect entries
					System.out.println("Adding prep to scratchpad: " + completeElmntContT2.elementContent);

				}

				//appears a few times, wrong value
				if ((completeElmntContW != null && !scratchPad.pronouns.contains(completeElmntContW.getElementContent())))
				{
					if (!scratchPad.pronouns.contains(completeElmntContW))
					{
						scratchPad.pronouns.add(completeElmntContW.elementContent);
						//scratchPad.noun.add("noun");
						//incorrect entries
					}
					System.out.println("Adding pronouns to scratchpad: " + completeElmntContW.elementContent);

				}


				//appears a few times, wrong value
				if ((completeElmntContW2 != null && !scratchPad.pronouns.contains(completeElmntContW2.getElementContent())))
				{
					if (!scratchPad.pronouns.contains(completeElmntContW2))
					{
						scratchPad.pronouns.add(completeElmntContW2.elementContent);
						//scratchPad.noun.add("noun");
						//incorrect entries
					}
					System.out.println("Adding pronouns to scratchpad: " + completeElmntContW2.elementContent);

				}


				//doesn't appear
				if ((completeElmntContC != null && !scratchPad.conjunction.contains(completeElmntContC.getElementContent())))
				{
					System.out.println("Conjunction " + completeElmntContC.getElementContent());
					if (!scratchPad.conjunction.contains(completeElmntContC))
					{
						//has a lot of ands but it loooks like its adding other stuff
						scratchPad.conjunction.add(completeElmntContC.elementContent);

					}
				}

				//doesn't appear
				if ((completeElmntContC2 != null && !scratchPad.conjunction.contains(completeElmntContC2.getElementContent())))
				{
					System.out.println("Conjunction " + completeElmntContJ2.getElementContent());
					if (!scratchPad.conjunction.contains(completeElmntContC2))
					{
						//has a lot of ands but it loooks like its adding other stuff
						scratchPad.conjunction.add(completeElmntContC2.elementContent);

					}
				}

				///doesn't apppear
				if ((completeElmntContP != null && !scratchPad.pos_pronoun.contains(completeElmntContP.getElementContent())))
				{
					if (!scratchPad.pos_pronoun.contains(completeElmntContP))
					{
						scratchPad.pos_pronoun.add(completeElmntContP.elementContent);
					}
					//scratchPad.noun.add("noun");
					//some mistakes, mostly correct
					System.out.println("Adding pos pronoun to scratchpad: " + completeElmntContP.elementContent);

				}


				if ((completeElmntContP2 != null && !scratchPad.pos_pronoun.contains(completeElmntContP2.getElementContent())))
				{
					if (!scratchPad.pos_pronoun.contains(completeElmntContP2))
					{
						scratchPad.pos_pronoun.add(completeElmntContP2.elementContent);
					}
					//scratchPad.noun.add("noun");
					//some mistakes, mostly correct
					System.out.println("Adding pos pronoun to scratchpad: " + completeElmntContP2.elementContent);

				}

				if (word.contains("`") && !scratchPad.open_quote.contains("open quote"))
				{

					System.out.println("Open Quote discovered");
					scratchPad.open_quote.add("open quote");

					word.replaceAll("`", " ");
					//word.replace("``", " ");


					//only exeutes once
					System.out.println("Adding quote to scratchpad: ");

				}//add also close quote. the words open quote
				//must be exact for PatternFactory

				//if the word has a ? but doesn't contain a close quote already proceed


				if (word.contains("dobj"))
				{
					System.out.println("Found a dobj");
					scratchPad.directObject.add(word);
					System.out.println("DOBJ added to scratchpad");
				}

				
				
			}
		}
			catch (JSONException je)
			{
				je.printStackTrace();
			}

		}
		
}
