
import java.util.Deque;

public class Scanners {

//		//===================================================\\
//		public XMLPatternTag scanVerbs(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//		{
//			System.out.println("SCANVERBS");
//			//failure on size of verbs
//			for (int j = 0; j<scratchpad.verb.size();j++)
//			{
//
//				//for (String verb : scratchpad.getVerb())
//				//{
//				//element content has iterates through all of the Voz output
//				//execept Alice is showing up in verbs, when she should show up in nouns
//				System.out.println("Element COntent " + elmnt.getElementContent() + " against verbs");
//				System.out.println("SCratchPad is " + j + " " + scratchpad.verb.get(j));
//				System.out.println("ScratchPad verb value is: " +  scratchpad.verb.get(j));
//				//if (!scratchpad.signalVerb.equals(elmnt.elementContent))
//				//{
//
////				if (elmnt.getElementContent().equals(scratchpad.verb.get(j)))
////				{
////					return xmlPatternTag;
////				}
//				//
//				if (elmnt.getElementContent().contains(scratchpad.directVerb.get(j)))
//				{		
//					System.out.println("Found a direct verb!");
//
//					xmlPatternTag = new XMLPatternTag();
//					
//					xmlPatternTag.name =  xmlPatternTag.name + "<directverb:" + elmnt.elementContent+">";
//					System.out.println("Patterns Factory(): tag name signal verb " + xmlPatternTag.name);
//
//					//scratchpad.noun.remove(i);
//					//return xmlPatternTag;
//					return xmlPatternTag;
//
//				}
//			
//
//
//			}
//
//
//			return xmlPatternTag;
//		}


		public XMLPatternTag sposSignalVerbs(StackElement emt, ScratchPad scratchpad)
		{
			XMLPatternTag patternTag = new XMLPatternTag();
			
			for (int i=0;i<scratchpad.signalVerb.size();i++)
			{
				if (emt.elementContent.contains(scratchpad.signalVerb.get(i)))
				{
					System.out.println("SPOS: Found a signal verb!");
					patternTag.name = "<signalverb:" + emt.elementContent+">";
					System.out.println("STAG: Signal Verb Tag is : " + patternTag.name);
					return patternTag;
					
				}
			}
			return patternTag;
			
		}
		
		public XMLPatternTag sposoNouns(StackElement emt, ScratchPad scratchpad)
		{
			XMLPatternTag patternTag = new XMLPatternTag();
			
			for (int i=0;i<scratchpad.noun.size();i++)
			{
				if (emt.elementContent.contains(scratchpad.noun.get(i)))
				{
					System.out.println("SPOS: Found a noun!");
					patternTag.name = "<noun:" + emt.elementContent+">";
					System.out.println("STAG: Noun Tag is : " + patternTag.name);

				}
			}
			return patternTag;
			
		}
		
		public XMLPatternTag sposoAdjectives(StackElement emt, ScratchPad scratchpad)
		{
			XMLPatternTag patternTag = new XMLPatternTag();
			
			for (int i=0;i<scratchpad.adjective.size();i++)
			{
				if (emt.elementContent.contains(scratchpad.adjective.get(i)))
				{
					System.out.println("SPOS: Found a adjective!");
					patternTag.name = "<adjective:" + emt.elementContent+">";
					System.out.println("STAG: Ajective  Tag is : " + patternTag.name);

				}
			}
			return patternTag;
			
		}
		
		
		public XMLPatternTag sposoDirectVerbs(StackElement emt, ScratchPad scratchpad)
		{
			XMLPatternTag patternTag = new XMLPatternTag();
			
			for (int i=0;i<scratchpad.directVerb.size();i++)
			{
				if (emt.elementContent.contains(scratchpad.directVerb.get(i)))
				{
					System.out.println("SPOS: Found a direct verb!");
					patternTag.name = "<directverb:" + emt.elementContent+">";
					System.out.println("STAG: Direct Verb Tag is : " + patternTag.name);

				}
			}
			return patternTag;
			
		}
//		//=========================================================\\
//
//		public XMLPatternTag scanSignalVerb(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//		{
//			System.out.println("SCANSIGNALVERB RUnning.. Size is: " + scratchpad.signalVerb.size());
//			for (int j=0;j<scratchpad.signalVerb.size();j++)
//			{
//				//scratchpad is correct
//				System.out.println("******** scratchpad signal verb test scratchpad signal verb is " + scratchpad.signalVerb.get(j));
//				//stackelement seems correct
//				System.out.println("******** stack element test element is " + elmnt.getElementContent());
//				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.signalVerb.size());
//				System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//				//below is not executing?
//				System.out.println("SPOS: elmnt " + elmnt.getElementContent());
//				System.out.println("scratchpad signalverb " + scratchpad.signalVerb.get(j));
//				if (elmnt.getElementContent().contains(scratchpad.signalVerb.get(j)))
//				{	
//					xmlPatternTag = new XMLPatternTag();
//					
//					System.out.println("Found a signal verb!");
//
//					xmlPatternTag.name =  xmlPatternTag.name + "<signalverb:" + elmnt.elementContent+">";
//					System.out.println("Patterns Factory(): tag name signal verb " + xmlPatternTag.name);
//
//					//scratchpad.noun.remove(i);
//					//return xmlPatternTag;
//					return xmlPatternTag;
//
//				
//				}
//			}
//			return null;
////		}
//		public XMLPatternTag scanDirectVerbs(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//		{
//			for (int j=0;j<scratchpad.directVerb.size();j++)
//			{
//				System.out.println("******** scratchpad directverb test scratchpad directverb is " + scratchpad.directVerb.get(j));
//				System.out.println("******** stack element test element is " + elmnt.getElementContent());
//				System.out.println("NUMBER OF SCRATCHPAD DIRECTVERBS IS " + scratchpad.directVerb.size());
//				System.out.println("SIZE OF STACK IS " + reverseStack.size());
//				System.out.println("SPOS: elmnt " + elmnt.getElementContent());
//				System.out.println("scratchpad directverb " + scratchpad.directVerb.get(j));
//				if (elmnt.getElementContent().contains(scratchpad.directVerb.get(j)))
//				{		
//					xmlPatternTag = new XMLPatternTag();
//					System.out.println("Found a direct verb!");
//
//					xmlPatternTag.name =  xmlPatternTag.name + "<directverb:" + elmnt.elementContent+">";
//					System.out.println("Patterns Factory(): tag name signal verb " + xmlPatternTag.name);
//
//					//scratchpad.noun.remove(i);
//					//return xmlPatternTag;
//					return xmlPatternTag;
//
//				}
//			}
//			return null;
//		}


//
//
//
//
//		//iterates this for each element elmnt
//		//============================================\\
//		public XMLPatternTag scanNouns(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//		{
//			//below, nouns, are not running
//			//a whole bunch of stack elements tested against scratchpad nouns
//			//for (int i = 0; i<scratchpad.noun.size();i++)
//			//{
//			//for (int i=0;i<reverseStack.size();i++)
//			//{
//			//System.out.println("Element COntent " + elmnt.elementContent + " against nouns");
//			//System.out.println("SCratchPad " + i + " is " + scratchpad.noun.get(i));
//
//			//System.out.println("ScratchPad noun size is " + scratchpad.noun.size());
//			//System.out.println("ScratchPad verb size is " + scratchpad.verb.size());
//
//
//
//			//if (scratchpad.noun.get(i).equals(elmnt.getElementContent()))
//			//{
//
//			//if (!scratchpad.noun.contains(elmnt.getElementContent()))
//
//			//found a noun also that attachse only one tag
//			//if (!xmlPatternTag.name.contains(scratchpad.noun.get(i)))	
//
//			//not more than one but not empty
//			for (int j=0;j<scratchpad.noun.size();j++)
//			{
//				System.out.println("******** scratchpad noun test scratchpad noun is " + scratchpad.noun.get(j));
//				System.out.println("******** stack element test element is " + elmnt.getElementContent());
//				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
//				System.out.println("SIZE OF STACK IS " + reverseStack.size());
//				System.out.println("SPOS: elmnt " + elmnt.getElementContent());
//				System.out.println("scratchpad nouns " + scratchpad.noun.get(j));
//				
//				if (elmnt.getElementContent().contains(scratchpad.noun.get(j)))
//				{		
//					System.out.println("Found a noun!");
//					xmlPatternTag = new XMLPatternTag();
//					xmlPatternTag.name =  xmlPatternTag.name + "<noun:" + elmnt.elementContent+">";
//					System.out.println("Patterns Factory(): tag name  noun " + xmlPatternTag.name);
//
//					//scratchpad.noun.remove(i);
//					//return xmlPatternTag;
//					return xmlPatternTag;
//
//				}
//
//			}
//
//
//
//			return null;
//
//		}
//
//

		public XMLPatternTag sposAdverbs(StackElement emt, ScratchPad scratchpad)
		{
			XMLPatternTag patternTag = new XMLPatternTag();
			
			for (int i=0;i<scratchpad.adverb.size();i++)
			{
				if (emt.elementContent.contains(scratchpad.adverb.get(i)))
				{
					System.out.println("SPOS: Found an adverb verb!");
					patternTag.name = "<adverb:" + emt.elementContent+">";
					System.out.println("STAG: Adverb Tag is : " + patternTag.name);

				}
			}
			return patternTag;
			
		}

//		public XMLPatternTag scanAdverbs(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//		{
//
//
//
//			for (int j=0;j<scratchpad.adverb.size();j++)
//			{
//				System.out.println("******** scratchpad adverb test scratchpad adverb is " + scratchpad.adverb.get(j));
//				System.out.println("******** stack element test element is " + elmnt.getElementContent());
//				System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
//				System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//				if (elmnt.getElementContent().contains(scratchpad.adverb.get(j)))
//				{		
//					System.out.println("Found an adverb!");
//					xmlPatternTag = new XMLPatternTag();
//					
//					xmlPatternTag.name = "<adverb:" + elmnt.elementContent+">";
//					System.out.println("Patterns Factory(): tag name ] adverb " + xmlPatternTag.name);
//
//					//scratchpad.noun.remove(i);
//					//return xmlPatternTag;
//					return xmlPatternTag;
//
//				}
//			}
//
//			return null;
//		}

		
		public XMLPatternTag sposQuotes(StackElement emt, ScratchPad scratchpad)
		{
			XMLPatternTag patternTag = new XMLPatternTag();
			
			for (int i=0;i<scratchpad.adverb.size();i++)
			{
				if (emt.elementContent.contains("\""))
				{
					System.out.println("SPOS: Found a quote!");
					patternTag.name = "<quote:openquote" +">";
					System.out.println("STAG: Quote is : " + patternTag.name);

				}
			}
			return patternTag;
			
		}
//			//found a quote tag as well. assigns it open quote then close
//
//			public XMLPatternTag scanQuotes(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )		
//			{
//				System.out.println("scanQuotes is detecting " + scratchpad.open_quote.size() + " size");
//				boolean eraseQuotes = false;
//				//for (int k = 0; k<scratchpad.quote.size();k++)
//				for (String qa: scratchpad.open_quote)				
//				{
//					System.out.println("Found a quote");
//					System.out.println("size : " + scratchpad.open_quote.size());
//					//scratchpad.quote.remove(qa);
//
//					if (scratchpad.open_quote.contains("open quote"))
//					{
//						xmlPatternTag = new XMLPatternTag();
//						//if (!xmlPatternTag.name.contains(qa))	
//						//{
//						System.out.println("Found a quote - open");
//						xmlPatternTag.name = xmlPatternTag.name + "<quote:openquote>";
//						//scratchpad.quote.add("open quote");'
//						eraseQuotes = true;
//						//}								
//					}
//
//				}
//
//				if (eraseQuotes == true)
//				{
//					scratchpad.open_quote.remove("open quote");
//				}
//
//				return null; 
//			}


				
//			public XMLPatternTag scanCloseQuotes(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )		
//			{
//				System.out.println("scanCloseQuotes is detecting " + scratchpad.close_quote.size() + " size");
//
//				boolean eraseQuotes = false;
//				//for (int k = 0; k<scratchpad.quote.size();k++)
//				for (String qa: scratchpad.close_quote)				
//				{
//					System.out.println("Found a quote");
//					System.out.println("size : " + scratchpad.close_quote.size());
//					//scratchpad.quote.remove(qa);
//
//					if (scratchpad.close_quote.contains("close quote"))
//					{
//						xmlPatternTag = new XMLPatternTag();
//						System.out.println("Found a close quote");
//						xmlPatternTag.name = xmlPatternTag.name + "<quote:closequote>";
//						//scratchpad.quote.add("open quote");'
//						eraseQuotes = true;
//
//					}
//				}
//
//				if (eraseQuotes == true)
//				{
//					scratchpad.close_quote.remove("close quote");
//				}		
//
//				return null; 
//			}
			 
//
//			//OOOOOOOOOOOOOOOOOOOO
//
//			//THE PROBLEM BELOW IS IF THERE IS  A MATCH BETWEEN
//			//ELMNT AND THE SCRATCHPD, IT IS 
//			//THE PROBLEM IS THAT IT IS REPEATING OVER AND OVER AGAIN
//			//FFOR THE NUMBER OF DEFINITE ARTICLEST THAT THERE ARE
//			//============================================\\
//			public XMLPatternTag scanDefArticle(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )
//			{
//				//below, nouns, are not running
//				for (int j=0;j<scratchpad.def_article.size();j++)
//				{
//					System.out.println("******** scratchpad def article test scratchpad def article is " + scratchpad.noun.get(j));
//					System.out.println("******** stack element test element is " + elmnt.getElementContent());
//					System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
//					System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//					if (elmnt.getElementContent().contains(scratchpad.def_article.get(j)))
//					{
//						//if (!xmlPatternTag.name.contains(scratchpad.adverb.get(i)))	
//
//						//if (!scratchpad.def_article.contains(elmnt.elementContent))
//						//if (!xmlPatternTag.name.contains(scratchpad.def_article.get(i)))	
//						xmlPatternTag = new XMLPatternTag();
//						System.out.println("Found an definite article!");
//						xmlPatternTag.name =  xmlPatternTag.name + "<defarticle:" + elmnt.elementContent+">";
//						System.out.println("Patterns Factory(): tag name def articles " + xmlPatternTag.name);
//						//scratchpad.def_article.remove(i);
//						return xmlPatternTag;
//					}
//
//
//				}
//
//				return null;
//			}


			
			public XMLPatternTag sposDefArticle(StackElement emt, ScratchPad scratchpad)
			{
				XMLPatternTag patternTag = new XMLPatternTag();
				
				for (int i=0;i<scratchpad.def_article.size();i++)
				{
					if (emt.elementContent.contains(scratchpad.def_article.get(i)))
					{
						System.out.println("SPOS: Found a definite article!");
						patternTag.name = "<defarticle:" + emt.elementContent+">";
						System.out.println("STAG: Definite Articles : " + patternTag.name);

					}
				}
				return patternTag;
				
			}
			
//
//			//============================================\\
//			public XMLPatternTag scanAdverb2(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )
//			{
//				//below, nouns, are not running
//				for (int i = 0; i<scratchpad.adverb.size();i++)
//				{
//
//					System.out.println("Element COntent " + elmnt.elementContent + " against adverb");
//					System.out.println("SCratchPad " + i + " is " + scratchpad.adverb.get(i));
//
//
//					//found a noun also that attachse only one tag
//					//if (!xmlPatternTag.name.contains(scratchpad.adverb.get(i)))	
//					{
//						if (elmnt.getElementContent().contains(scratchpad.adverb.get(i)))
//						{
//
//							xmlPatternTag = new XMLPatternTag();
//							xmlPatternTag.name =  xmlPatternTag.name + "<adverb:" + elmnt.elementContent+">";
//							System.out.println("Patterns Factory(): tag name adverb 2 " + xmlPatternTag.name);
//							//scratchpad.adverb.remove(i);
//							//return xmlPatternTag;
//							return xmlPatternTag;
//
//						}
//
//
//					}
//				}
//
//
//				return null;
//
//
//			}
			//==============================================//


			
			public XMLPatternTag sposPrep(StackElement emt, ScratchPad scratchpad)
			{
				XMLPatternTag patternTag = new XMLPatternTag();
				
				for (int i=0;i<scratchpad.prep.size();i++)
				{
					if (emt.elementContent.contains(scratchpad.prep.get(i)))
					{
						System.out.println("SPOS: Found a preposition!");
					}
				}
				return patternTag;
				
			}
//
//			public XMLPatternTag scanPrep(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, Deque<StackElement> reverseStack )
//			{
//				//below, nouns, are not running
//				for (int j=0;j<scratchpad.prep.size();j++)
//				{
//					System.out.println("******** scratchpad prep test scratchpad prep is " + scratchpad.prep.get(j));
//					System.out.println("******** stack element test element is " + elmnt.getElementContent());
//					System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.prep.size());
//					System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//					if (elmnt.getElementContent().contains(scratchpad.prep.get(j)))
//					{
//
//						//if (!scratchpad.prep.contains(elmnt.elementContent))
//						//found a noun also that attachse only one tag
//						//if (!xmlPatternTag.name.contains(scratchpad.prep.get(i)))	
//						xmlPatternTag = new XMLPatternTag();
//						System.out.println("Found a prep!");
//
//						xmlPatternTag.name =  xmlPatternTag.name + "<prep:" + elmnt.elementContent+">";
//						System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);
//
//						//scratchpad.prep.remove(i);
//						return xmlPatternTag;
//
//
//					}
//				} return null;
//
//			}

			public XMLPatternTag sposPronouns(StackElement emt, ScratchPad scratchpad)
			{
				XMLPatternTag patternTag = new XMLPatternTag();
				
				for (int i=0;i<scratchpad.pronouns.size();i++)
				{
					if (emt.elementContent.contains(scratchpad.pronouns.get(i)))
					{
						System.out.println("SPOS: Found a pronoun!");
						patternTag.name = "<pronoun:" + emt.elementContent+">";
						System.out.println("STAG: Pronoun Tag is : " + patternTag.name);

					}
				}
				return patternTag;
				
			}

//			
//			///===========================================\\
//			public XMLPatternTag scanPronouns(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//			{
//				//below, nouns, are not running
//				for (int j=0;j<scratchpad.pronouns.size();j++)
//				{
//					System.out.println("******** scratchpad pronoun test scratchpad pronoun is " + scratchpad.noun.get(j));
//					System.out.println("******** stack element test element is " + elmnt.getElementContent());
//					System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
//					System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//					if (elmnt.getElementContent().contains(scratchpad.pronouns.get(j)))
//					{
//						//found a noun also that attachse only one tag
//						//if (!xmlPatternTag.name.contains(scratchpad.pronouns.get(i)))	
//						//if (!scratchpad.pronouns.contains(elmnt.elementContent))
//						//{
//						//if (scratchpad.pronouns.equals(elmnt.elementContent))
//						//{
//						//if (elmnt.getElementContent().equals(scratchpad.pronouns.get(i)))
//						//{
//						xmlPatternTag = new XMLPatternTag();
//						System.out.println("Found a noun!");
//
//						xmlPatternTag.name =  xmlPatternTag.name + "<pronouns:" + elmnt.elementContent+">";
//						System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);
//
//						//scratchpad.pronouns.remove(i);
//
//
//						return xmlPatternTag;
//					}
//
//				}
//				return null;
//
//			}

			public XMLPatternTag sposConjunctions(StackElement emt, ScratchPad scratchpad)
			{
				XMLPatternTag patternTag = new XMLPatternTag();
				
				for (int i=0;i<scratchpad.conjunction.size();i++)
				{
					if (emt.elementContent.contains(scratchpad.conjunction.get(i)))
					{
						System.out.println("SPOS: Found a conjuncion!");
					}
				}
				return patternTag;
				
			}
			//=======================================================//

//
//			public XMLPatternTag scanConjunction(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//			{
//				//below, nouns, are not running
//				for (int j=0;j<scratchpad.conjunction.size();j++)
//				{
//					System.out.println("******** scratchpad conjunction test scratchpad conjunction is " + scratchpad.noun.get(j));
//					System.out.println("******** stack element test element is " + elmnt.getElementContent());
//					System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
//					System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//					if (elmnt.getElementContent().contains(scratchpad.conjunction.get(j)))
//					{
//
//						//found a noun also that attachse only one tag
//						//if (!xmlPatternTag.name.contains(scratchpad.conjunction.get(i)))	
//						{
//							//if (!scratchpad.conjunction.contains(elmnt.elementContent))
//
//							if (elmnt.getElementContent().equals(scratchpad.conjunction.get(j)))
//							{
//
//								xmlPatternTag = new XMLPatternTag();
//								xmlPatternTag.name =  xmlPatternTag.name + "<conj:" + elmnt.elementContent+">";
//								System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);
//
//								//scratchpad.conjunction.remove(i);
//
//								return xmlPatternTag;
//							}
//						}
//					}
//
//
//				} return null;
//
//			}


			//===============================================\\
//
//			public XMLPatternTag scanAdjective(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//			{
//
//				for (int j=0;j<scratchpad.adjective.size();j++)
//				{
//					System.out.println("******** scratchpad adjective test scratchpad adjective is " + scratchpad.noun.get(j));
//					System.out.println("******** stack element test element is " + elmnt.getElementContent());
//					System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
//					System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//					if (elmnt.getElementContent().contains(scratchpad.adjective.get(j)))
//					{
//						{
//
//							//if (!xmlPatternTag.name.contains(scratchpad.adjective.get(i)))	
//							//if (!scratchpad.adjective.get(j).equals(elmnt.getElementContent()))
//							//if (reverseStack.contains(scratchpad.adjective.get(j)))
//
//							//if (scratchpad.adjective.size() <= 1)
//							{
//								xmlPatternTag = new XMLPatternTag();
//								System.out.println("Element COntent " + elmnt.elementContent + " against adjective");
//								System.out.println("SCratchPad " + j + " is " + scratchpad.adjective.get(j));
//
//								System.out.println("ScratchPad adjective size is " + scratchpad.adjective.size());
//
//								System.out.println("******** scratchpad adjective test scratchpad adjective is " + scratchpad.adjective.get(j));
//								System.out.println("******** stack element test element is " + elmnt.getElementContent());
//
//								System.out.println("Found an  adjective!");
//								xmlPatternTag.name =  xmlPatternTag.name + "<adjective:" + elmnt.elementContent+">";
//								System.out.println("Patterns Factory(): tag name def articles " + xmlPatternTag.name);
//							}
//
//							return xmlPatternTag;
//
//						}
//					}
//
//				}
//
//				return null;
//			}
//


//
//			//==============================================\\
//			public XMLPatternTag scanPosPronoun(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//			{
//				System.out.println("POS PRONOUNS SIZE " + scratchpad.pos_pronoun.size());
//				//below, nouns, are not running
//
//
//
//
//				for (int j=0;j<scratchpad.pos_pronoun.size();j++)
//				{
//					System.out.println("******** scratchpad pos_pronoun test scratchpad pos_pronoun is " + scratchpad.noun.get(j));
//					System.out.println("******** stack element test element is " + elmnt.getElementContent());
//					System.out.println("NUMBER OF SCRATCHPAD NOUNS IS " + scratchpad.noun.size());
//					System.out.println("SIZE OF STACK IS " + reverseStack.size());
//
//					if (elmnt.getElementContent().contains(scratchpad.pos_pronoun.get(j)))
//					{
//
//						xmlPatternTag = new XMLPatternTag();
//
//						xmlPatternTag.name =  xmlPatternTag.name + "<pos_pronoun:" + elmnt.elementContent+">";
//						System.out.println("Patterns Factory(): tag name noun " + xmlPatternTag.name);
//						//scratchpad.pos_pronoun.remove(i);
//
//						return xmlPatternTag;
//					}
//				}
//
//				return null;
//
//			}
//
//			//===============================================================\\
//			public XMLPatternTag miscWordsScan(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag,  Deque<StackElement> reverseStack )
//			{
//				/*
//
//				//check word against scratchpad
//				System.out.println("Patterns Factory(): element working with: " + elmnt.getElementContent());
//				if (scratchpad.directObject.contains(elmnt.elementContent))
//				{
//					System.out.println("Found a direct object");
//					xmlPatternTag.name = xmlPatternTag.name + "<directobject>";
//				}
//
//				else if (scratchpad.signalVerb.contains("signal verb"))
//				{
//					System.out.println("Found a signal verb!");
//
//
//					xmlPatternTag.name = xmlPatternTag.name + "<signalverb>";
//					
//				}
//				else  if (scratchpad.subject.contains(elmnt.elementContent))
//				{
//					System.out.println("Found a subject!");
//					xmlPatternTag.name = xmlPatternTag.name + "<subject>";
//				}
//
//
//				else if (scratchpad.adverb.contains(elmnt.elementContent))
//				{
//					System.out.println("Found an Adverb");
//					xmlPatternTag.name = xmlPatternTag.name + elmnt.elementContent + ">";
//				}
//				
//				else if (scratchpad.open_quote.contains(elmnt.elementContent))
//				{
//					System.out.println("Found an open quote");
//					xmlPatternTag.name = xmlPatternTag.name + elmnt.elementContent + ">";
//				}
//				
//				
//
//				return null;
//			}
//			
			
	


}

