package ApplicationClasses;

import java.util.Deque;

import UtilityClasses.XMLPatternTag;

//This class converts scratchPad data to XMLPatternTags

public class ScannersPOS {




	//===================================================\\
	public XMLPatternTag scanVerbs(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
	{

		//failure on size of verbs
		for (int j = 0; j<scratchpad.verb.size();j++)
		{

			//for (String verb : scratchpad.getVerb())
			//{
			//element content has iterates through all of the Voz output
			//execept Alice is showing up in verbs, when she should show up in nouns
			System.out.println("Element COntent " + elmnt.getElementContent() + " against verbs");
			System.out.println("SCratchPad is " + j + " " + scratchpad.verb.get(j));
			System.out.println("ScratchPad verb value is: " +  scratchpad.verb.get(j));
			//if (!scratchpad.signalVerb.equals(elmnt.elementContent))
			//{

			if (elmnt.getElementContent().equals(scratchpad.verb.get(j)))
			{
				return xmlPatternTag;
			}
			//



		}


		return xmlPatternTag;
	}


	//=========================================================\\

	public XMLPatternTag scanSignalVerbs(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
	{

		/*
			for (int j = 0; j<scratchpad.signalVerb.size();j++)
			{
				//THE PROBlEM HERE IS VOZ DOESNT SPIT OUT ENOUGH WORDS
				System.out.println("Element COntent " + elmnt.getElementContent() + " against signal verbs");
				System.out.println("SCratchPad is " + j + " " + scratchpad.signalVerb.get(j));
				System.out.println("ScratchPad size is " + scratchpad.signalVerb.size());
				System.out.println("******** scratchpad signal verb test scratchpad signal verb is " + scratchpad.signalVerb.get(j));
				System.out.println("******** stack element test element is " + elmnt.getElementContent());
		 */



		//below is not working
		/*if (elmnt.elementContent.equals("said"))
				{
					System.out.println("Found say signal verb");

					System.exit(-1);	

				}*/


		for (int j=0;j<scratchpad.signalVerb.size();j++)
		{
			System.out.println("******** scratchpad signal verb test scratchpad signal verb is " + scratchpad.signalVerb.get(j));
			System.out.println("******** stack element test element is " + elmnt.getElementContent());
			System.out.println("SIZE OF STACK IS " + reverseStack.size());

			//if (elmnt.getElementContent().contains(scratchpad.signalVerb.get(j)))
			//
			if (elmnt.getElementContent().contains("say"))
			{		
				System.out.println("Found a signal verb!");

				xmlPatternTag.name =  xmlPatternTag.name + "<signalverb:" + elmnt.elementContent+">";
				System.out.println("Patterns Factory(): tag name signal verb " + xmlPatternTag.name);

				//scratchpad.noun.remove(i);
				//return xmlPatternTag;
				//return xmlPatternTag;
			}


		}

		return xmlPatternTag;
	}


	public XMLPatternTag scanDirectVerbs(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
	{
		for (int j=0;j<scratchpad.directVerb.size();j++)
		{
			System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.directVerb.get(j));
			System.out.println("******** stack element test element is " + elmnt.getElementContent());
			System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
			System.out.println("SIZE OF STACK IS " + reverseStack.size());

			if (elmnt.getElementContent().contains(scratchpad.directVerb.get(j)))
			{		
				System.out.println("Found a direct verb!");

				xmlPatternTag.name =  xmlPatternTag.name + "<directverb:" + elmnt.elementContent+">";
				System.out.println("Patterns Factory(): tag name signal verb " + xmlPatternTag.name);

				//scratchpad.noun.remove(i);
				//return xmlPatternTag;
				return xmlPatternTag;


			}
		}
		return xmlPatternTag;
	}






	//iterates this for each element elmnt
	//============================================\\
	public XMLPatternTag scanNouns(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
	{
		//below, nouns, are not running
		//a whole bunch of stack elements tested against scratchpad nouns
		//for (int i = 0; i<scratchpad.noun.size();i++)
		//{
		//for (int i=0;i<reverseStack.size();i++)
		//{
		//System.out.println("Element COntent " + elmnt.elementContent + " against nouns");
		//System.out.println("SCratchPad " + i + " is " + scratchpad.noun.get(i));

		//System.out.println("ScratchPad noun size is " + scratchpad.noun.size());
		//System.out.println("ScratchPad verb size is " + scratchpad.verb.size());



		//if (scratchpad.noun.get(i).equals(elmnt.getElementContent()))
		//{

		//if (!scratchpad.noun.contains(elmnt.getElementContent()))

		//found a noun also that attachse only one tag
		//if (!xmlPatternTag.name.contains(scratchpad.noun.get(i)))	

		//not more than one but not empty
		for (int j=0;j<scratchpad.noun.size();j++)
		{
			System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.noun.get(j));
			System.out.println("******** stack element test element is " + elmnt.getElementContent());
			System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
			System.out.println("SIZE OF STACK IS " + reverseStack.size());

			if (elmnt.getElementContent().contains(scratchpad.noun.get(j)))
			{		

				//if ((!scratchpad.noun.get(j).equals(elmnt.getElementContent())))
				//if (reverseStack.contains(scratchpad.noun.get(j)))


				//if (scratchpad.noun.size() <= 1)

				System.out.println("Found a noun!");

				xmlPatternTag.name =  xmlPatternTag.name + "<noun:" + elmnt.elementContent+">";
				System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);

				//scratchpad.noun.remove(i);
				//return xmlPatternTag;
				return xmlPatternTag;

			}


		}



		return xmlPatternTag;

	}





	public XMLPatternTag scanAdverbs(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
	{



		for (int j=0;j<scratchpad.adverb.size();j++)
		{
			System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.adverb.get(j));
			System.out.println("******** stack element test element is " + elmnt.getElementContent());
			System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
			System.out.println("SIZE OF STACK IS " + reverseStack.size());

			if (elmnt.getElementContent().contains(scratchpad.adverb.get(j)))
			{				

				System.out.println("Found an adverb!");
				xmlPatternTag.name =  xmlPatternTag.name + "<adverb:" + elmnt.elementContent+">";
				System.out.println("Patterns Factory(): tag name adverb " + xmlPatternTag.name);
				//scratchpad.adverb.remove(i);
				return xmlPatternTag;


			}
		}

		return xmlPatternTag;
	}

		//found a quote tag as well. assigns it open quote then close

		public XMLPatternTag scanQuotes(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )		
		{
			System.out.println("scanQuotes is detecting " + scratchpad.open_quote.size() + " size");
			boolean eraseQuotes = false;
			//for (int k = 0; k<scratchpad.quote.size();k++)
			for (String qa: scratchpad.open_quote)				
			{
				System.out.println("Found a quote");
				System.out.println("size : " + scratchpad.open_quote.size());
				//scratchpad.quote.remove(qa);

				if (scratchpad.open_quote.contains("open quote"))
				{
					//if (!xmlPatternTag.name.contains(qa))	
					//{
					System.out.println("Found a quote - open");
					xmlPatternTag.name = xmlPatternTag.name + "<quote:openquote>";
					//scratchpad.quote.add("open quote");'
					eraseQuotes = true;
					//}								
				}

			}

			if (eraseQuotes == true)
			{
				scratchpad.open_quote.remove("open quote");
			}

			return xmlPatternTag; 
		}


			
		public XMLPatternTag scanCloseQuotes(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )		
		{
			System.out.println("scanCloseQuotes is detecting " + scratchpad.close_quote.size() + " size");

			boolean eraseQuotes = false;
			//for (int k = 0; k<scratchpad.quote.size();k++)
			for (String qa: scratchpad.close_quote)				
			{
				System.out.println("Found a quote");
				System.out.println("size : " + scratchpad.close_quote.size());
				//scratchpad.quote.remove(qa);

				if (scratchpad.close_quote.contains("close quote"))
				{

					System.out.println("Found a close quote");
					xmlPatternTag.name = xmlPatternTag.name + "<quote:closequote>";
					//scratchpad.quote.add("open quote");'
					eraseQuotes = true;

				}
			}

			if (eraseQuotes == true)
			{
				scratchpad.close_quote.remove("close quote");
			}		

			return xmlPatternTag; 
		}
		 
		
		public XMLPatternTag scanSingleQuotes(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )		
		{
			System.out.println("scanQuotes is detecting " + scratchpad.single_quote.size() + " size");
			boolean eraseQuotes = false;
			//for (int k = 0; k<scratchpad.quote.size();k++)
			for (String qa: scratchpad.single_quotee)				
			{
				System.out.println("Found a single quote");
				System.out.println("size : " + scratchpad.single_quote.size());
				//scratchpad.quote.remove(qa);

				if (scratchpad.single_quote.contains("singlequote"))
				{
					//if (!xmlPatternTag.name.contains(qa))	
					//{
					System.out.println("Found a quote - single");
					xmlPatternTag.name = xmlPatternTag.name + "<singlequote:singlequote>";
					//scratchpad.quote.add("open quote");'
					eraseQuotes = true;
					//}								
				}

			}

			if (eraseQuotes == true)
			{
				scratchpad.open_quote.remove("open quote");
			}

			return xmlPatternTag; 
		}

		//OOOOOOOOOOOOOOOOOOOO

		//THE PROBLEM BELOW IS IF THERE IS  A MATCH BETWEEN
		//ELMNT AND THE SCRATCHPD, IT IS 
		//THE PROBLEM IS THAT IT IS REPEATING OVER AND OVER AGAIN
		//FFOR THE NUMBER OF DEFINITE ARTICLEST THAT THERE ARE
		//============================================\\
		public XMLPatternTag scanDefArticle(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )
		{
			//below, nouns, are not running
			for (int j=0;j<scratchpad.def_article.size();j++)
			{
				System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.noun.get(j));
				System.out.println("******** stack element test element is " + elmnt.getElementContent());
				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
				System.out.println("SIZE OF STACK IS " + reverseStack.size());

				if (elmnt.getElementContent().contains(scratchpad.def_article.get(j)))
				{
					//if (!xmlPatternTag.name.contains(scratchpad.adverb.get(i)))	

					//if (!scratchpad.def_article.contains(elmnt.elementContent))
					//if (!xmlPatternTag.name.contains(scratchpad.def_article.get(i)))	

					System.out.println("Found an definite article!");
					xmlPatternTag.name =  xmlPatternTag.name + "<defarticle:" + elmnt.elementContent+">";
					System.out.println("Patterns Factory(): tag name def articles " + xmlPatternTag.name);
					//scratchpad.def_article.remove(i);
					return xmlPatternTag;
				}


			}

			return xmlPatternTag;
		}



		//============================================\\
		public XMLPatternTag scanAdverb2(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )
		{
			//below, nouns, are not running
			for (int i = 0; i<scratchpad.adverb.size();i++)
			{

				System.out.println("Element COntent " + elmnt.elementContent + " against adverb");
				System.out.println("SCratchPad " + i + " is " + scratchpad.adverb.get(i));


				//found a noun also that attachse only one tag
				//if (!xmlPatternTag.name.contains(scratchpad.adverb.get(i)))	
				{
					if (elmnt.getElementContent().contains(scratchpad.adverb.get(i)))
					{


						xmlPatternTag.name =  xmlPatternTag.name + "<adverb:" + elmnt.elementContent+">";
						System.out.println("Patterns Factory(): tag name adverb 2 " + xmlPatternTag.name);
						//scratchpad.adverb.remove(i);
						//return xmlPatternTag;
						return xmlPatternTag;

					}


				}
			}


			return xmlPatternTag;


		}
		//==============================================//



		public XMLPatternTag scanPrep(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )
		{
			//below, nouns, are not running
			for (int j=0;j<scratchpad.prep.size();j++)
			{
				System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.prep.get(j));
				System.out.println("******** stack element test element is " + elmnt.getElementContent());
				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.prep.size());
				System.out.println("SIZE OF STACK IS " + reverseStack.size());

				if (elmnt.getElementContent().contains(scratchpad.prep.get(j)))
				{

					//if (!scratchpad.prep.contains(elmnt.elementContent))
					//found a noun also that attachse only one tag
					//if (!xmlPatternTag.name.contains(scratchpad.prep.get(i)))	

					System.out.println("Found a prep!");

					xmlPatternTag.name =  xmlPatternTag.name + "<prep:" + elmnt.elementContent+">";
					System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);

					//scratchpad.prep.remove(i);
					return xmlPatternTag;


				}
			} return xmlPatternTag;

		}


		///===========================================\\
		public XMLPatternTag scanPronouns(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
		{
			//below, nouns, are not running
			for (int j=0;j<scratchpad.pronouns.size();j++)
			{
				System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.noun.get(j));
				System.out.println("******** stack element test element is " + elmnt.getElementContent());
				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
				System.out.println("SIZE OF STACK IS " + reverseStack.size());

				if (elmnt.getElementContent().contains(scratchpad.pronouns.get(j)))
				{
					//found a noun also that attachse only one tag
					//if (!xmlPatternTag.name.contains(scratchpad.pronouns.get(i)))	
					//if (!scratchpad.pronouns.contains(elmnt.elementContent))
					//{
					//if (scratchpad.pronouns.equals(elmnt.elementContent))
					//{
					//if (elmnt.getElementContent().equals(scratchpad.pronouns.get(i)))
					//{

					System.out.println("Found a noun!");

					xmlPatternTag.name =  xmlPatternTag.name + "<pronouns:" + elmnt.elementContent+">";
					System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);

					//scratchpad.pronouns.remove(i);


					return xmlPatternTag;
				}

			}
			return xmlPatternTag;

		}


		//=======================================================//


		public XMLPatternTag scanConjunction(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
		{
			//below, nouns, are not running
			for (int j=0;j<scratchpad.conjunction.size();j++)
			{
				System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.noun.get(j));
				System.out.println("******** stack element test element is " + elmnt.getElementContent());
				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
				System.out.println("SIZE OF STACK IS " + reverseStack.size());

				if (elmnt.getElementContent().contains(scratchpad.conjunction.get(j)))
				{

					//found a noun also that attachse only one tag
					//if (!xmlPatternTag.name.contains(scratchpad.conjunction.get(i)))	
					{
						//if (!scratchpad.conjunction.contains(elmnt.elementContent))

						if (elmnt.getElementContent().equals(scratchpad.conjunction.get(j)))
						{


							xmlPatternTag.name =  xmlPatternTag.name + "<conj:" + elmnt.elementContent+">";
							System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);

							//scratchpad.conjunction.remove(i);

							return xmlPatternTag;
						}
					}
				}


			} return xmlPatternTag;

		}


		//===============================================\\

		public XMLPatternTag scanAdjective(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
		{

			for (int j=0;j<scratchpad.adjective.size();j++)
			{
				System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.noun.get(j));
				System.out.println("******** stack element test element is " + elmnt.getElementContent());
				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
				System.out.println("SIZE OF STACK IS " + reverseStack.size());

				if (elmnt.getElementContent().contains(scratchpad.adjective.get(j)))
				{
					{

						//if (!xmlPatternTag.name.contains(scratchpad.adjective.get(i)))	
						//if (!scratchpad.adjective.get(j).equals(elmnt.getElementContent()))
						//if (reverseStack.contains(scratchpad.adjective.get(j)))

						//if (scratchpad.adjective.size() <= 1)
						{
							System.out.println("Element COntent " + elmnt.elementContent + " against adjective");
							System.out.println("SCratchPad " + j + " is " + scratchpad.adjective.get(j));

							System.out.println("ScratchPad adjective size is " + scratchpad.adjective.size());

							System.out.println("******** scratchpad adjective test scratchpad adjective is " + scratchpad.adjective.get(j));
							System.out.println("******** stack element test element is " + elmnt.getElementContent());

							System.out.println("Found an  adjective!");
							xmlPatternTag.name =  xmlPatternTag.name + "<adjective:" + elmnt.elementContent+">";
							System.out.println("Patterns Factory(): tag name def articles " + xmlPatternTag.name);
						}

						return xmlPatternTag;

					}
				}

			}

			return xmlPatternTag;
		}




		//==============================================\\
		public XMLPatternTag scanPosPronoun(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
		{
			System.out.println("POS PRONOUNS SIZE " + scratchpad.pos_pronoun.size());
			//below, nouns, are not running




			for (int j=0;j<scratchpad.pos_pronoun.size();j++)
			{
				System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.noun.get(j));
				System.out.println("******** stack element test element is " + elmnt.getElementContent());
				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
				System.out.println("SIZE OF STACK IS " + reverseStack.size());

				if (elmnt.getElementContent().contains(scratchpad.pos_pronoun.get(j)))
				{



					xmlPatternTag.name =  xmlPatternTag.name + "<pos_pronoun:" + elmnt.elementContent+">";
					System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);
					//scratchpad.pos_pronoun.remove(i);

					return xmlPatternTag;
				}
			}

			return xmlPatternTag;

		}

		//===============================================================\\
		public XMLPatternTag miscWordsScan(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
		{

			//check word against scratchpad
			System.out.println("Patterns Factory(): element working with: " + elmnt.getElementContent());
			if (scratchpad.directObject.contains(elmnt.elementContent))
			{
				System.out.println("Found a direct object");
				xmlPatternTag.name = xmlPatternTag.name + "<directobject>";
			}

			else if (scratchpad.signalVerb.contains("signal verb"))
			{
				System.out.println("Found a signal verb!");


				xmlPatternTag.name = xmlPatternTag.name + "<signalverb>";
				
			}
			else  if (scratchpad.subject.contains(elmnt.elementContent))
			{
				System.out.println("Found a subject!");
				xmlPatternTag.name = xmlPatternTag.name + "<subject>";
			}


			else if (scratchpad.adverb.contains(elmnt.elementContent))
			{
				System.out.println("Found an Adverb");
				xmlPatternTag.name = xmlPatternTag.name + elmnt.elementContent + ">";
			}
			
			else if (scratchpad.open_quote.contains(elmnt.elementContent))
			{
				System.out.println("Found an open quote");
				xmlPatternTag.name = xmlPatternTag.name + elmnt.elementContent + ">";
			}
			
			

			return xmlPatternTag;
		}

		//Iterate through a template
		//ALlready agreed the templates are matches
		//recovrd the indices for speakernoun (to start, then we o directobject)

		/* 
			public void discoverSpeaker(String template, String source)
			{
				int counter = 0;
				StringTokenizer stok = new StringTokenizer(template, ">");

				while (stok.hasMoreTokens())
				{
					counter++;
					String [] brackets = template.split(":");
					if (brackets[0].contains("speakernoun"))
					{
						System.out.println("Found temnplate speaker");
						break;
					}

				}

				StringTokenizer stokr = new StringTokenizer(source, ">");
				int ctr = 0;

				while (stokr.hasMoreTokens())
				{
					ctr++;
					String template_tag = stokr.nextToken();
					if (ctr == counter)
					{
						System.out.println("Match template speaker");

						System.out.println(template_tag);
					}
				}


			} */

	//}

}


