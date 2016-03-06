import java.util.HashMap;

public class TemplateRules {

	

		
	/**
	1.	CC	Coordinating conjunction
	2.	CD	Cardinal number
	3.	DT	Determiner
	4.	EX	Existential there
	5.	FW	Foreign word
	6.	IN	Preposition or subordinating conjunction     <prep:>
	7.	JJ	Adjective									<adj:>
	8.	JJR	Adjective, comparative						<adj:>
	9.	JJS	Adjective, superlative						<adj:>
	10.	LS	List item marker							
	11.	MD	Modal
	12.	NN	Noun, singular or mass						<noun:>
	13.	NNS	Noun, plural								<noun:>
	14.	NNP	Proper noun, singular						<noun:>
	15.	NNPS	Proper noun, plural						<noun:>
	16.	PDT	Predeterminer								
	17.	POS	Possessive ending							
	18.	PRP	Personal pronoun							
	19.	PRP$	Possessive pronoun
	20.	RB	Adverb										<adverb:>
	21.	RBR	Adverb, comparative							<adverb:>
	22.	RBS	Adverb, superlative							<adverb:>
	23.	RP	Particle
	24.	SYM	Symbolt
	25.	TO	to
	26.	UH	Interjection
	27.	VB	Verb, base form								<verbbase:>
	28.	VBD	Verb, past tense							<verbpast:>
	29.	VBG	Verb, gerund or present participle			<verbgerund:>
	30.	VBN	Verb, past participle						<verbpast:>
	31.	VBP	Verb, non-3rd person singular present		<verbsingular:>
	32.	VBZ	Verb, 3rd person singular present			<verbthirdperson:>
	33.	WDT	Wh-determiner						
	34.	WP	Wh-pronoun
	35.	WP$	Possessive wh-pronoun
	36.	WRB	Wh-adverb									<verb:adverb>
	
	/**
	 * extended
	 * 
	 * <open quote>
	 * <close quote>
	 * 
	 **/
	
	
	//
	
	
	
	
	//As of thye time of this writing, there are ten identified patterns
	//for dialogue, including unusualness all the way to pure anomalies.
	
	//This class  identifies and classifies and encodes these patterns using XML
	
	
	
	//Rule  Type 1: Speaker following Signal Verb
	//“There’s no sort of use in knocking,” said the Footman, “and that for two reasons. 
	//FIrst because I’m the same side of the door as you ; secondly because they’re  making such a 
	//noise inside, no one could possibly hear you”

	//In this case the speaker is used in conjunction with the signal variable as above.
	
	//in this instance we have a signal verb being used in  conjunction with the speaker
	//this is a simpler case
	//ibn the sentence the patterns matched are: knocking, and said, 
	//Knocking is ruled out since it doesn't point to any subject  in the sentence
	//so the only verb remaining is said, which is a signal verb (synonym of say)
	//This leaves:     <quote ><text><knocking><quote><signal verb><noun>
	//ANd the noun has to be the speaker since it is in conjunction with the signal verb
	final String rule1 = "<template:one><quote:openquote><misctext:misc><quote:closequote><signalverb:said><speakernoun:Footman><template:end>";
	
	
	
	//Rule Type 2: Speaker begins within the start of the the dialog

	//“Johnathon said to Ali that he was exhausted.”

	//The quote is pushed to the stack indicating the beginning of dialog. 
	//The first part of the dialog is pushed to the stack including 
	//subject, verb, and direct object. The ending quote is pushed
	//indicating the end of dialog. Since the verb is in the “said family”,
	//we know that the Subject (Johnathon) speaking sto somebody (Ali)

	final String rule2 = "<template:two><quote:openquote><speakernoun:Johnathon><signalverb:said><directobject:Ali><misctext:misc><quote:closequote><template:end>";
	
	
	//Rule Type 3: Speaker begins outside the start of the dialog

	//April said, “I am so tired of gardening.”

	//Here the speaker is clearly April and the signal verb the word
	//“said”. April would be pushed to the stack, the verb said would
	//be pushed to the stack. The quoted block woujld be pushed as well.
	//The verbs would be extracted: “said, am”. The program would use 
	//Voz to determine that said belongs to the “say” family and “am”
	//is not. In this case the speaker is not speaking to someone that
	//we know of. ? We check the stack to see if there was a quoted
	//block below this quoted block. If so there is a good chance she '
	//is speaking to that person. It is also possible that she is just 
	//talkingt to herself. This is the advantage of using a stack.
	final String rule3 = "<template:three><quote:openquote><speakernoun:April><signalverb:said><quote:openquote><speakernoun:I><directverb:tired><directobject:gardening><quote:closequote><template:end>";
	
	
	
	//Rule Type 4: Speaker Embedded within Quotes

	//Here it is not clear if Alice is still speaking 

	//In the kitchen that did not sneeze were the cook and a large cat, which was grinning from ear to ear. 

	//“Please, would you tell me,” said Alice , a little timiidly, “why your cat grins like that?”

	//“It’s a Cheshire-Cat,” said the Duchess, “and that;s why.”

	//“I didn’t know Cheshire-Cat always grinned, in fact I didn’t know that cats could even grin,” said Alice.

	//“You don’t know much,” said the Duchess, “and that’s a fact.”

	//(underline rules)

	final String rule4 = "<template:four><quote:openquote><speakernoun:Alice><misctext:misc><quote:closequote><signalverb:said><quote:openquote><misctext:misc><subject:Alice><directverb:tell><directobject:cat><open:closequote><template:end>";
	
	
	//A quote is pushed indicating the beginning of the dialog. 
	//“you” is pushed. “me” is pushed. Without pushing those two 
	//the sentence has no context. Push the end quote indicating
	//the end of the sentence. Push the signal verb and then push
	//Alice’s name.  The combination of “you”  and “me” in the 
	//sentence and Alice after the signal verb allows us to
	//determine if Alice is the “you” or “me.” Me is Alice and 
	//You is an unknown target of the dialogue.
  
	
	///
	
	
	///
	//Rule Type 5: Self-Identifying within a quoted dialog - no signal verb

	// “I am Kalir, general of the troops of the Summerland in this time slice.”

	//By identifying the speaker in the beginning of the dialogue, there is no need for a signal verb to identify who is speaking. However, the verb “am” is necessary to occur within the dialogue block. 

	//We would once again use Voz to get the nature of the verb “am”. With no signal verb present, we typically wou;d look down the stack for a dialogue block beforehand (as in the case of multiple dialogue lines intersecting(.  However, that will not yield a solutiomn either. In this cae we have to loook at the special instance where the self-identifying verb “am” occurs.

	//We would begin by processing the sentence as usual, pushing the usual information. We do the normal queries and at the very last query, we look for the verb “am” (to be). If no other rules fit, then we most likely have a case like this. We store the subject as Kalir (since “I AM KALIR”) 

	//As far as speaker and speakee, only the beginnning counts. Subject/Speaker is Kalir and the speakee  is the implicit "you"
	final String rule5 = "<template:fifth><quote:openquote><speakernoun:I><directverb:am><speakernoun:Kalir><quote:closequote><template:end>";

	
	//Rule Type 6: Multiple Speakers

	//They entered and no one was in the hut. "Well, brothers," said one of the three, "let us stop here for a time and rest from our travels."
	//?

	//Rule Type 7: Nested Quotes
	//Case of weird nested quotes:
	//"Do not take anything," she told him, "but an eye. And if you are asked where you got this crown, answer only: 'God gave it to me.'"
	//Here the subject is anonymous, we just know her gender. ANd the speakee is you
	
	
	final String rule7 = "<template:seven><quote:openquote><signalverb:told><quote:openquote><misctext:misc><quote:closequote><template:end>";
	
	
	//Rule Type 8: False Quoted Text

	//Case of quoted text that is not dialogue:
	//The devil wrinkled up his face when the soldier addressed him as "My good man!"
	//Here the speakernoun is the devil and the direct object is the soldier
	
	final String rule8 = "<template:eight><quote:openquote><speakernoun:The Devil><directverb:wrinkled><misctext:misc></misctext><quote:openquote><speakee:soldier><misctext:misc><quote:closequote><template:end>";
	
	//Rule Type 9: Entire Dialogue Utterance without Quotes

	//Case of not quoted utterance of text:
	//The dolls cuckooed:
	//Cuckoo, Prince Danila, Cuckoo, Govorila, Cuckoo, he takes his sister, Cuckoo, for a wife, Cuckoo, earth open wide, Cuckoo, sister, fall inside!

	//NO idea how to handle this presently
	
	//Rule Type 10: Talking to one 

	//“Albert,” he said. Seren wondered…could this be his brother? It was so long ago the image of him in his mind had faded.

	final String rule10 = "<template:tenth><quote:openquote><speakee:Seren><signalverb:said><quote:closequote><speakernoun:Seren><misctext></misc>";
	
	//Rule Type 11: Engineered demo  template
	
	final String rule11 = "<template:eleven><quote:openquote><noun:hat><signalverb:said><noun:sword><directverb:shield><template:end>";
	
	//Rule Type 12: speaker nouns
	final String rule12 = "<template:twelfth><quote:openquote><speakernoun:Jason><directverb:flew><misctexct:misc><directobject:Sarah><signalverb:said>";
	
	/*
	 * 
	 * NOTE: IN the joined tags <noun:Alice> or <verb:tell> the part of speech shouold always
	 * come first, and the name, lemma, or whatever is to be second.
	 * 
	 */
	
	//rule Type 13: test
	final String rule13 = "<templatee:thirteenth><quote:openquote><speakernoun:Alice><directverb:tell><noun:Duchess><noun:cat><directverb:speak><noun:manners><noun:Alice><directverb:tell><noun:ear><noun:hearth><noun:cook><directverb:sneeze><noun:kitchen><quote:closequote>";
	
	//Extra Templates
	//“Begin at the beginning," the 
	//King said, very gravely, "and go on till you come to the end: then stop.” 
	final String rule14 = "<template:fourth><quote:openquote><speakernoun:King><signalverb:said><misctext:misc><quote:closequote>";
	
	//Extra Template
	//Oh, you can’t help that,” said the cat. “We’re all mad here.”
	//Extra Template
	final String rule15 = "<template:fifteenth><quote:openquote><signalverb:said><misctext:misc><speakernoun:cat><cquote:closequote>";
	
	//Extra Template
	//I think I should understand that better,
	//if I had it written down: but I can't quite follow it as you say it.
	final String rule16 = "<template:sixtenth>e<quote:openquote><speakernoun:I><directverb:think><speakernoun:I><directverb:should><quote:closequote>";
	
	//Extra Template
	//Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 
	//'and what is the use of a book,' thought Alice 'without pictures or conversations?'
	final String rule17 = "<template:seventeen><speakernoun:Alice><directverb:was><misctext:misc><quote:closequote>";
	
	//Extra Template
	//'Well!' thought Alice to herself, 'after such a fall as this, I shall think nothing of tumbling down stairs! How brave they'll all think me at home! 
	final String rule18 = "<template:eighteen><quote:openquote><speakernoun:Alice><speakernoun:herself><quote:closequote>";

	//Extra TEmplate
	//'What a curious feeling!' said Alice; 'I must be shutting up like a telescope.'
	//
	final String rule19 = "<template:nineteen><quote:openquote><signalverb:said><speakernoun:Alice>";
	
	//
	//
	//rule 20, next set - Brave New World
	//"And this," said the Director opening the door, "is the Fertilizing 	Room." 
	final String rule20 = "<template:twenty><quote:openquote><misctext:misc><signalverb:said><speakernoun:Director>";
	
	//rule 21 
	//"To-morrow," he would add, smiling at them with a slightly menacing 
	//geniality, "you'll be settling down to serious work. You won't have time 
	//for generalities. Meanwhile ..." 
	final String rule21 = "<template:twenty-first><quote:openquote><misctext:misc><speakernoun:he>";	
	
	///rule 22
	///"I shall begin at the beginning," said the D.H.C. and the more zealous 
	//students recorded his intention in their notebooks: Begin at the begin- 
	//ning. "These," he waved his hand, "are the incubators." And opening 
	//an insulated door he showed them racks upon racks of numbered test- 
	//tubes. "The week's supply of ova. Kept," he explained, "at blood heat; 
	//whereas the male gametes," and here he opened another door, "they 
//	have to be kept at thirty-five instead of thirty-seven. Full blood heat 
	//sterilizes." Rams wrapped in theremogene beget no lambs. 

	final String rule22 = "<template:twenty-second><quote:openquote><speakernoun:I><misctext:misc><signalverb:said>";
	
	
	//rule 23
	//"Bokanovsky's Process," repeated the Director, and the students un- 
	//derlined the words in their little notebooks. 
	final String rule23 = "<tempalate:twenty-third><quote:openquote><misctext:misc><signalverb:repeated><speakernoun:the Director>";
	
	
	//rule 24
	//"Essentially," the D.H.C. concluded, "bokanovskification consists of a 
	//series of arrests of development. We check the normal growth and, 
	//paradoxically enough, the egg responds by budding." 
	final String rule24 = "<template:twenty-four><quote:openquote><misctext:misc><speakernoun:D.H.C><signalverb:concluded>";
	
	
	//rule 25
	//"Scores," the Director repeated and flung out his arms, as though he 
	//were distributing largesse. "Scores." 
	final String rule25 = "<template:tenty-five><quote:openquote><misctext:misc><speakernoun:Director><signalverb:repeated>";
	
	//rule 26
	//"My good boy!" The Director wheeled sharply round on him. "Can't you 
	///see? Can't you see?" He raised a hand; his expression was solemn. 
	//"Bokanovsky's Process is one of the major instruments of social stabil- 
	//ity!
	
	final String rule26 = "<template:twenty-six:rule<quote:openquote><misctext:misc><noun:boy><speakernoun:Director>";
	//rule 27
	//"Ninety-six identical twins working ninety-six identical machines!" The 
	//voice was almost tremulous with enthusiasm. "You really know where 
	//you are. For the first time in history." He quoted the planetary motto. 
	//"Community, Identity, Stability." Grand words. "If we could bo- 
	//kanovskify indefinitely the whole problem would be solved." 

	//rule 27
	//
	//"But, alas," the Director shook his head, "we can't bokanovskify indefi- 
	//nitely." 
	
	final String rule27 = "<template:twenty-seven><quote:openquote><speakernoun:Director><directverb:shook>";
	
	//rule 28
	// "For in nature it takes thirty years for two hundred eggs to reach ma- 
//	turity. But our business is to stabilize the population at this moment, 
	//here and now. Dribbling out twins over a quarter of a century-what 
	//would be the use of that?" 
	
	final String rule28 = "<template:twenty-eight><quote:openquote>";
	
	//rule29
	//"And in exceptional cases we can make one ovary yield us over fifteen 
	//thousand adult individuals." "
		
	final String rule29 = "<template:twenty-nine><quote:openquote><speakernoun:unknown><signalverb:unknown>";
	
	//rule30
	// Beckoning to a fair-haired, ruddy young man who happened to be 
	//passing at the moment. "Mr. Foster," he called. The ruddy young man 
	//approached. "Can you tell us the record for a single ovary, Mr. Foster?" 

	final String rule30 = "<template:thirty><quote:openquote><misctext:misc><speakernoun:he>";
	
	//rule31
	//"That's the spirit I like!" cried the Director, and clapped Mr. Foster on 
	//the shoulder. "Come along with us, and give these boys the benefit of 
	///your expert knowledge." 

	final String rule32 = "<template:thirty-one><quote:openquote><misctext:misc><signalverb:cried><speakernoun:Director>";
	
	//rule33
	//"Containing all the relevant information," added the Director. 
	//"Brought up to date every morning." 
	//"And co-ordinated every afternoon." 
	//"On the basis of which they make their calculations." 
	//"So many individuals, of such and such quality," said Mr. Foster. 
	//"Distributed in such and such quantities." 
	//"The optimum Decanting Rate at any given moment." 
	//"Unforeseen wastages promptly made good." 
	
	final String rule33 = "<template:twenty-three><quote:openquote><misctext:misc><signalverb:added><speakernoun:Director>";
	
	//rule34
	//"Promptly," repeated Mr. Foster. "If you knew the amount of overtime I 
	//had to put in after the last Japanese earthquake!" He laughed good- 
	//humouredly and shook his head. 
	
	
	final String rule34 = "<template:thirty-four><quote:openquote><miscctext:misc><signalverb:repeated><speakernoun:Foster>";
	//rule35
	//"The Predestinators send in their figures to the Fertilizers." 
	//"Who give them the embryos they ask for." 

	final String rule35 = "<template:thirty-five><quote:openquote><speakernoun:unkown>";
	
	//rule36
	//"And the bottles come in here to be predestined in detail." 
	//"After which they are sent down to the Embryo Store." 
	//"Where we now proceed ourselves." 
	
	final String rule36 = "<template:thirty-six><quote:openquote><speakernoun:unknown>";
			
	
	//rule37
	//"Embryos are like photograph film," said Mr. Foster waggishly, as he 
	//pushed open the second door. "They can only stand red light." 
	//And in effect the sultry darkness into which the students now followed 
	//him was visible and crimson, like the darkness of closed eyes on a 
	//summer's afternoon. The bulging flanks of row on receding row and 
	//tier above tier of bottles glinted with innumerable rubies, and among 
	//the rubies moved the dim red spectres of men and women with purple 
	//eyes and all the symptoms 

	final String rule37 = "<template:thirty-seven><quote:openquote><misctext:misc><signalverb:said><speakernoun:Foster>";
	
	//rule38
	//"Give them a few figures, Mr. Foster," said the Director, who was tired 
	//of talking. 
	
	final String rule38 = "template:thirty-eight><quote:openquote><misctext:misc><noun:Foster><signalverb:said><speakernoun:Director>";
	
	
	//rule39
	//"That's the spirit I like," said the Director once more. "Let's walk 
	//around. You tell them everything, Mr. Foster." 
	final String rule39 = "<template:thirty-nine><quote:openquote><misctext:misc><signalverb:said><speakernoun:Director>";
	
	
	
	//rule40
	//He was going to say "future World controllers," but correcting 
	//himself, said "future Directors of Hatcheries," instead.
	
	final String rule40 = "<template:forty><quote:openquote><misctext:miscc><speakernoun:He><<misctext:misc><signalverb:say>";
	
	
	///////fear and loathing in lost vegas
	
	//rule 41
	//"Can you hear me?" I yelled.
	
	final String rule41 = "<tempalte:forty-one><quote:openquote><misctext:misc><noun:you><misctext:text><speakernoun:I><signalverb:yelled>";
	
	//rule 42
	//	"That's why we rented this car. It was the only way to do it. Can you grasp that?"
	
	final String rule42 = "<template:forty-two><quote:openquote><misctext:misc><speakernoun:we><noun:car>";
	
	//rule 43
	//	"Indeed," he said. "We must do it."
	
	final String rule43 = "<template:forty-three><quote:openquote><misctext:text><speakernoun:he><signalverb:said>";
	
	//rule 44
	//	 "Say there...uh ...you fellas are going to be careful with this car, aren't you?"
	
	final String rule44 = "<template:forty-for><quote:openquote><noun:you><noun:fellas><noun:you>";
	
	
	//rule 45
	//	"My heart, he groaned. "Where's the medicine?"
	
	final String rule45 = "<template:forty-five><quote:openquote><speakernoun:My><misctext:text><misctext:misc><signalverb:groaned>";
	
	//rule 46
	//	He was laughing out of control. "What the fuck are we doing out in this desert?"	//	
	//  he shouted. Somebody call the police! We need help!"
	
	final String rule46 ="<template:forty-six><quote:openquote><speakernoun:He>";
	
	
	//rule 47
	//  "Savage Henry has cashed his check!" My attorney snarled at the kid in the back
	//	seat."We're going to rip his lungs out!"
	
	final String  rule47 = "<template:forty-seven><quote:openquote><speakernoun:My attorney>";
	
	
	//rule 48 "Shoot it" said my attorney. "Not yet," I said, "I want to study its habits."
	//
	
	final String rule48 = "<template:forty-eight><quote:openquote><misctext:misc><speakernoun:I><signalverb:said>";
	
	//rule 49 "He laughed distractedly. "Listen madam," he snapped.
	
	final String rule49 = "<tempalate:forty-nine><quote:openquote><speakernoun:He>";
	
	//rule 50 "We'll see about thi;s!" my attorney said as we drove away. "You paranoid scum"
	
	final String rule50 = "<template:fifty><quote:openquote><speakernoun:We'll><speakernoun:attorney><signalverb:said>";
		
	
	
	//rule 51 "Bolt everything," said my attorney. 
	
	final String rule51 = "<tempalte:fifty-one><quote:openquote><misctext:misc><signalverb:said><speakernoun:attorney";
	
	//rule 52  "Pardon me, I feel sick," I said to the first leg I stepped on.
	
	final String rule52 = "<template:fifty-two><quote:openquote><misctext:misc><speakernoun:I><signalverb:said> ";
	
	//rule 53 "Naw!" said the Georgia man. "Not down in my parts."
	
	final String rule53 = "<template:fifty-three><quote:openquote><misctext:misc><signalverb:said><speakernoun:Georgia Man>";
	
	//rule 54 "Yes!" she said eagerly. "I'll help you all you need, I hate dope!"
	
	final String rule54 = "<template:fifty-for><quote:openquote><misctext:misc><speakernoun:she><signalverb:said>"; 
	
	//rule 55 "What is this?" she snapped. "A napkin," said my attorney.
	
	final String rule55 = "<template:fifty-five><quote:openquote><misctext:misc><speakernoun:she><signalverb:snapped>";
	
	//rule 56 "Well," I said, "I guess they've brought the car around by now. Let's get the stuff
	// out of the trunk.
	
	final String rule56 = "<template:fifty-six><quote:openquote><misctext:misc><speakernoun:I><signalverb:said>";
	
	//rule 57 I laughed. "It's straight economics. This girl is a god-send! I fixed him with
	//	natural Bogar smile, all teeth ..."Shit , we're almost broke! And suddenly you pick up
	// some musclebound looney who can make us a grand a day."
	
	final String rule57 = "<template:fifty-seven><quote:openquote><speakernoun:I><signalverb:laughed>";
	
	
	//rule 58 I shook my head. "No it's gone too far."
	
	final String rule58 = "<template:fifty-eight><quote:openquote><speakernoun:I><directverb:shook><noun:head>";
	
	//rule 59 "Crying?" My brain had locked up. 
	
	final String rule59 = "<template:fifty-nine>quote:openquote><misctext:misc><speakernoun:My>";
	
	//tuesdays with morrie
	
	//rule 60
	
	///There was no known cure. "How did I get it?" Morrie asked.
	
	final String rule60 = "<template:sixty><quote:openquote><misctext:misc><speakernoun:Morrie><signalverb:asked>";
	
	// rule 61
	
	//"If you feel this is a problem, I understand if you wish to drop the mnj"
	
	final String rule61 = "<template:sixty-one><quote:openquote><misctext:misc><noun:you><misctext:misc><speakernoun:I>";
	
	// rule 62
	
	// What a waste," he said. "All those people saying all those wonderful things, 
	//and IRc never got to hear any of it."
	
	final String rule62 = "<template:sixty-two><quote:openquote><misctext:misc><speakernoun:he><signalverb:said>";
	
	// rule 63
	
	//"I hope Morrie goes easy on Ted, " said the other.
	final String rule63 = "<template:sixty-three><quote:openquote><speakernoun:I><misctext:misc><signalverb:said>";
	
	// rule 64
	
	// "Okay he said," It's gonna take a second."
	
	final String rule64 = "<template:sixty-four><open:openquote><misctext:misc><speakernoun:he><signalverb:said>";
	
	// rule 65
	
	// "Yeah yeah I'm here," I whispered.
	
	final String rule65 = "<template:sixty-five><open:openquote><misctext:misc><speakernoun:I><signalverb:whispered>";
	
	
	// rule 66
	
	//	"You know Mitch, now that I'm dying, I've beocme much more interesting to people."
	//
	
	final String rule66 = "<template:sixty-six<open:openquote><noun:Mitch><speakernoun:I'm>";
	
	// rule 67
	// "Are you tryinng to be as human as you can be?"
	
	final String rule67 = "<template;sixty-seven><open:openquote><noun:you>";
	
	//rule 68
	// "Yes. After all, I get to be a baby one more time."
	
	final String rule68 = "<template:sixty-eight><open:openquote><misctext:misc><speakernoun:I>";
	
	//rule 69
	//	Sure, I said, too quickly.
	
	final String rule69 = "<template:sixty-nine><open:openquote><misctext:misc><speakernoun:I><signalverb:said>";
	
	//rule 70
	//	"Mitch says that you're a professional singer."
	
	final String rule70 = "<template:seventy><open:openquote><speakernoun:you're>";
	
	//rule 71
	//	Morrie raised his eyebrows, "Will you sing something for me?"
	
	final String rule71 = "<template:seventy-one><open:openquote><speakernoun:Morrie>";
	
	//rule 72
	// "You're my only brother," I said. "I dont want to lose you, I love you."
	final String rule72 = "<template:seventy-two><open:openquote><noun:you're><misctext:misc><speakernoun:I><signalverb:said>";
	
	//rule 73
	
	//	Ted, I need to check you out before I agree to do this interview."
	
	final String rule73 = "<template:seventy-third><open:openquote><noun:Ted><speakernoun:I>";
	
	//rule 74
	
	// "How about Tuesday?" Tuesday would be good I said. Tuesday would be fine.
	//
	
	final String rule74 = "<template:seventy-four><open:openquote><misctext:misc><speakernoun:I><signalverb:said>";
	
	//rule 75
	//	"Take a look at this," the producer said.
	
	final String rule75 = "<template:seventy-five><open:openquote><misctext:misc><speakernoun:producer><signalverb:said>";
	
	//rule 76
	//He grinned. "Ah Mitch. I'm gonna loosen you up. One day, I'm gonna show 
	//its ok to cry."
	// 
	
	final String rule76 = "<template:seventy-six><speakernoun:He><signalverb:grinned>";
	
	//rule 77
	//"We're Tuesday people" he said. Tuesday people, I repeated.
	
	final String rule77 = "<template:seventy-seven><open:openquote><speakernoujn:We're>";
	
	//rule 78
	//"Mitch? Morrie said."
	
	final String rule78 = "<template:seventy-eight><open:openquote><speakernonun:Morrie><signalverb:said>";
	
	//rule 79
	//"Why not? Like I said, no one really believes they are going to die?"
	
	final String rule79 = "<template:seventy-nine><open:openquote><misctext:misc><speakernoun:I><signalverb:said>";
	//O'Henry
	//rule 80
	// "You've cut off your hair," asked Jim.
	
	final String rule80 = "<template:eighty><open:openquote><misctext:misc><signalverb:asked><speakernoun:Jim>";
	
	//rule 81
	//"A chance said she!"
	
	final String rule81 = "<template:eighty-one><open:openquote><misctext:misc><signalverb:said><speakernoun:she>";
	
	//rule 82
	//"Well she said to the burglar."
	
	final String rule82 = "<template:eighty-two><open:openquote><misctext:misc><speakernoun:she><signalverb:said>";
	
	//rule 83
	//"Certainly , sir, " he tittered. 
	
	final String rule83 = "<template:eighty-three><open:openquote><misctext:misc><speakernoun:he><signalverb:tittered>";
	
	
	//rule 84
	//"Well, she said. "It certainly dhows you have imagination."
	
	final String rule84 = "<template:eighty-four><open:openquote><misctext:misc><speakernoun:she><signalverb:said>";
	
	//rule 85
	//"What do you mean by fresh?"

	final String rule85 = "<template:eighty-five><speakernoun:unknown>";
	
	//rule 86
	//"Everything," he answered almost savagely. 
	
	final String rule86 = "<template:eighty-six><open:openquote><misctext:misc><speakernoun::he><signalverb:answered>";
	
	//rule 87
	//"Robert", said the calm, cool, voice of his judge. "I thought I married a gentleman."
	
	final String rule87 = "<template:eighty-seven><open:openquote><misctext:misc><signalverb:said><misctext:misc><speakernoun:judge>";
	
	//rule 88
	//"No," said Teddy, "no one minds what he says , just so he doesn't do it again."
	
	final String rule88  = "<template:eighty-eight><open:openquote><misctext:misc><signalverb:said><speakernoun:Teddy>";
	
	//rule 89 
	//"The little devil!" said Mrs. MacIntyre , driven to violence.
	
	final String rule89 = "<template:eighty-nine><open:openquote><misctext:misc><signalverb:said><speakernoun:Mrs. MacIntyre>";
	
	//rule 90
	//"Excuse me, friend," said he. Can I quickly talk with you on the level?"
	
	final String rule90 = "<template:ninety><open:openquote><misctext:misc><signalverb:said><speakernoun:he>";
	
	//rule 91
	//"All right," said the stranger. "And then what?"
	
	final String rule91 = "<template:ninenty-one><open:openquote><misctext:misc><signalverb:said><speakernoun:the stranger>";
	
	//rule 92
	// "How's my girl?" he asked, holding her close.

	final String rule92 = "<template:ninety-two><open:openquote><misctext:misc><speakernoun:he><signalverb:said>";
	
	//rule 93
	//	"I'll see how it looks later on, " was his decision.
	
	final String rule93 = "<template:ninety-three><open:openquote><misctext:misc><speakernoun:his><signalverb:decision>";
	
	//rule 94
	//	"His arm," said Chad, "is hardr'n a diamond."
	
	final String rule94 = "<template:ninety-four><open:openquote><misctext:misc><signalverb:said><speakernoun:Chad>";
	
	//rule 95
	//	"How's that? asked McGuire , a little startled.
	
	final String rule95 = "<template:ninety-five><open:openquote><misctext:misc><signalverb:asked><speakernoun:McGuire>";
	
	//rule 96
	//	"Buckboard greys," said Sam.
	
	final String rule96 = "<template:ninety-six><open:openquote˘><misctext:misc><signalverb:said><speakernoun:Sam>";
	
	//rule 97
	// 	""Back Ranse", said the old man looking up?
	
	final String rule97 = "<template: ninety-seven><open:openquote><misctext:misc><signalverb:said><speakernoun:old man>";
	
	//rule 98
	//	"Is that ship out there?" asked the Kid
	final String rule98 = "<template:ninety-eight><open:openquote><misctext><ssignalverb:asked><speakernoun: Kid:>";
	
	//rule 99
	//	"Let me see your hand, is it bruised?"
	
	final String rule99  = " <template:ninety-nine><speakernoun:unkown><noun:hand>";
	
	//rule 100
	//	"For goodness sakes get out."
	
	final String rule100 = "<template:one-hundred><speakernoun:unkown>";
	


}
