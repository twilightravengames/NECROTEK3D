
public class StackToTag {

	//WORKING WELL

	//FindPOS uses scratchpad to find to maatch a reverse stak element's typ
	//and by using the type, it generates XMLPatternTags

	//only executing once or twice - shouldn't loop throuh entire stack???
	public XMLPatternTag generatePatternTag(StackElement elmnt, ScratchPad scratchpad, XMLPatternTag xmlPatternTag, SentenceStack stack)
	{
		//BELOW IS ABOUT CORRECT. ITS 83 units before popping
		System.out.println("ReverseStack size " + stack.reverseStack.size());

		System.out.println("Running core algorithm - findPOS");



		//Check scratchpad and stackelements cohesion
  
		//System.out.println("ScratchPad data " + scratchpad.);
		//Below, not in proper order
		System.out.println("findPOS(): StackElement content: " + elmnt.elementContent);

		System.out.println("Scratchpad current status");
		System.out.println("and noun size " + scratchpad.noun.size());
		System.out.println("and verb size " + scratchpad.verb.size());

		System.out.println("Preparing loop");


		//this one shows up this on the next tag
		StackElement previous = new StackElement();
		StackElement next = new StackElement();


		StackElement emt1 = stack.reverseStack.pop();
		StackElement emt2 = stack.reverseStack.pop();
		StackElement emt3 = stack.reverseStack.pop();

		XMLPatternTag finalTag = new XMLPatternTag();

		while(!stack.reverseStack.isEmpty())
		{
			//Here is the beginning of the XML pattern tag
			if (xmlPatternTag != null) {
				System.out.println("Tag is " + xmlPatternTag.name);
			}


			System.out.println("ELement is " + elmnt.elementContent);



			previous.next = elmnt;

			System.out.println("nextVariable " + previous.next.elementContent);


			//below is  working

			//	if (xmlPatternTag != null)
			//	{

			//		
			//					//actors.signalVerb = elmnt.elementContent;
			//				
			//					System.out.println("Actors signalVerb " + actors.signalVerb);
			//					System.out.println("Actors previousWord " + actors.previousWord);
			//					System.out.println("Actors nextWord " + actors.nextWord);
			//					
			//actors.previousWord = previous;
			//actors.previousWord.next = previous.next;

			//System.out.println("Element 1 is " + emt1.elementContent);
			//System.out.println("Element 2 is " + emt2.elementContent);
			//System.out.println("Element 3 is " + emt3.elementContent);
			//}

			//previous= elmnt;


			//emt1 = emt2;
			//emt2 = emt3;
			//emt3 = stack.reverseStack.pop();
			//	elmnt = emt3;
			elmnt = stack.reverseStack.pop();
			//values below are correct
			System.out.println("==================");
			//System.out.println("PREVIOUS: " + previous.getElementContent());
			System.out.println("ELMNT: " + elmnt.getElementContent());
			//System.out.println("EMT1 " + emt1.getElementContent());
			//System.out.println("EMT2 " + emt2.getElementContent());
			//System.out.println("EMT3 " + emt3.getElementContent());

			//	elmnt = emt1;





			Scanners spos = new Scanners(); 

			System.out.println("xmlPatternTag building....");


			//element has correct values
			System.out.println("elmnt is " + elmnt.elementContent);

			XMLPatternTag tempTag = null;
			System.out.println("Temp tag starts as" + tempTag);

			//doesn't seem like the scanners (spos) is running
			//problem found. Its not runnning the scanners because
			//the scratchpad is empty

			//problem is the scanners
			//they aren't returning anything
			if (tempTag == null)
			{
				System.out.println("Inside signalverb tag loop");
				//tempTag = spos.scanSignalVerb(elmnt, scratchpad, tempTag, stack.reverseStack);
				tempTag = spos.sposSignalVerbs(elmnt, scratchpad);
				System.out.println("TEMPTAG is " + tempTag.name);
				finalTag.name = finalTag.name+tempTag.name;
			}

			tempTag = null;

			if (tempTag == null)
			{
				System.out.println("Inside second tempTag loop");
				tempTag = spos.sposoNouns(elmnt, scratchpad);
				finalTag.name = finalTag.name+tempTag.name;
				System.out.println("noun temp tag is " + tempTag.name);


			}
			
			tempTag = null;
			
			
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposoAdjectives(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("adjective temp tag is " + tempTag.name);

				}

				tempTag = null;	
				
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag =  spos.sposoDirectVerbs(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("directverb temp tag is " + tempTag.name);

				}

				tempTag = null;
				
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposAdverbs(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("adverb temp tag is " + tempTag.name);

				}

				tempTag = null;
				
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposQuotes(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("quotes temp tag is " + tempTag.name);

				}

				tempTag = null;

				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposSingleQuotes(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("single quotes temp tag is " + tempTag.name);

				}

				tempTag = null;

				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposCloseQuotes(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("close quotes temp tag is " + tempTag.name);

				}

				
				
				
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposDefArticle(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("definite article temp tag is " + tempTag.name);

				}
				
				tempTag = null;
				
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposPrep(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("preposition temp tag is " + tempTag.name);

				}

				
				tempTag = null;
				
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposPronouns(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("pronouns temp tag is " + tempTag.name);

				}
				if (tempTag == null)
				{
					System.out.println("Inside second tempTag loop");
					tempTag = spos.sposConjunctions(elmnt, scratchpad);
					finalTag.name = finalTag.name+tempTag.name;
					System.out.println("preposition temp tag is " + tempTag.name);

				}

				tempTag = null;


				//The scanQuote routine below seems to mess up all the other scans
				//When running scanQuotes, the only thing that shows up is closequote
				//System.out.println("Scanning quotes ");

				//xmlPatternTag = spos.scanQuotes(elmnt, scratchpad, xmlPatternTag, stack.reverseStack);

				/*
			 if (tempTag == null)
			{
				tempTag = spos.miscWordsScan(elmnt, scratchpad, tempTag, stack.reverseStack);
			}


			else if (tempTag == null)
			{
				tempTag = spos.scanSignalVerb(elmnt, scratchpad, tempTag, stack.reverseStack );
			}

			else if (tempTag == null)
			{
				tempTag = spos.scanAdverbs(elmnt, scratchpad, tempTag, stack.reverseStack);
			}

			else if (tempTag == null)
			{
				tempTag = spos.scanDirectVerbs(elmnt, scratchpad, tempTag, stack.reverseStack);
			}

			else if (tempTag == null)
			{
				tempTag = spos.scanDefArticle(elmnt, scratchpad, tempTag, stack.reverseStack);
			}


			else if (tempTag == null)
			{

				tempTag = spos.scanAdverb2(elmnt, scratchpad, tempTag, stack.reverseStack);
			}

			else if (tempTag == null)
			{
				tempTag = spos.scanPrep(elmnt, scratchpad, tempTag, stack.reverseStack);
			}


			else if (tempTag == null)
			{
				tempTag = spos.scanPronouns(elmnt, scratchpad, tempTag, stack.reverseStack);
			}


			else if (tempTag == null)
			{
				tempTag = spos.scanConjunction(elmnt, scratchpad, tempTag, stack.reverseStack);
			}


			else if (tempTag == null)
			{
				spos.sposoAdjectives(elmnt, scratchpad);
			}


			else if (tempTag == null)
			{
				tempTag = spos.scanPosPronoun(elmnt, scratchpad, tempTag, stack.reverseStack);
			}

			else if (tempTag == null)
			{
				tempTag = spos.scanCloseQuotes(elmnt, scratchpad, tempTag, stack.reverseStack);
			}

			if (tempTag == null)
			{
				System.out.println("Temptag is null");
			}
			else
			{
				System.out.println("Temptag is " + tempTag.name);
			}
				 */

				previous = elmnt;
				
				System.out.println("FINALL SCRATCHPAD NOUN SIZE IS: " + scratchpad.noun.size());

				System.out.println("FINAL: Final Pattern is" + finalTag.name);


		}

	
		

		
		System.out.println("DONE: Ending patterns facetory");
		System.out.println("DONE: " + finalTag.name);

		return finalTag;
	}		
}


