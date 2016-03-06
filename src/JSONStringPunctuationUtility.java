



public class JSONStringPunctuationUtility {

	
	public StackElement stripElementPunctuation(StackElement element)
	{
		JSONString js = new JSONString();
		js.elementContent = element.getElementContent();
		
		JSONString json = stripPunctuation(js);
		
		StackElement elmnt = new StackElement();
		elmnt.setElementContent(json.getElementContent());
		
		return elmnt;
	}
	
	public JSONString stripPunctuation(JSONString word)
	{
		
		System.out.println("========Punctuation Utility=============");
		System.out.println("Original word before punctuation strip ");
		
		JSONString jString = stripCommas(word);
		System.out.println("Commas jstring stripped " + jString.getElementContent());
		JSONString jString2 = stripDoubleQuotes(jString);
		System.out.println("Double Quotes jstring stripped " + jString2.elementContent);
		JSONString jString3 = stripQuotes(jString2);
		System.out.println("Strip Quotes jstring stripped " + jString3.elementContent);
		
		JSONString jString4 = stripPeriods(jString3);
		System.out.println("Strip periods jstring stripped" + jString4.elementContent);
		
		JSONString jString5 = stripSingleQuote(jString4);
		System.out.println("Strip single quote jstring stripped" + jString5.elementContent);
		
		JSONString jString6 = stripQuestionMark(jString5);
		System.out.println("Strip quetsion mark jstring stripped" + jString6.elementContent);
		
		JSONString jString7 = stripNulls(jString6);
		System.out.println("Strip null statements stripped" + jString7.elementContent);
		
		JSONString jString8 = stripCurleyBraces(jString7);
		System.out.println("Stripped curley braces" + jString8.elementContent);
		
		
		JSONString jString9 = stripRightCurleyBrace(jString8);
		System.out.println("Stripped curley braces" + jString9.elementContent);
		
		JSONString jString10 = stripColon(jString9);
		System.out.println("Stripped colon:" + jString10.elementContent);
		
		JSONString jString11 = stripText(jString10);
		System.out.println("Stripped text" + jString10.elementContent);
		
		
		System.out.println("=========END PUNCTUATION UTIL================================");
		return jString11;
		
	}
	
	public JSONString stripCommas(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll(",",""));
		System.out.println("PunctuationUtility: commas(): "  + word.elementContent);
		return stringWord;
	}
	
	public JSONString stripQuotes(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("\"", ""));
		System.out.println("PunctuationUtility: single quote(): "  + word.elementContent);
		return stringWord;
	}

	public JSONString stripDoubleQuotes(JSONString word)
	{
		JSONString stringWord = new JSONString();
		
		stringWord.setElementContent(word.elementContent.replaceAll("\"", ""));
		System.out.println("PunctuationUtility:Double QUotes(): "  + word.elementContent);
		
		
		
		return stringWord;
	}
	
	public JSONString stripPeriods(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("\\.", ""));
		System.out.println("PunctuationUtility:Periods(): "  + word.elementContent);
		return stringWord;
	}
	
	
	public JSONString stripSingleQuote(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("'", ""));
		System.out.println("PunctuationUtility:Singlquote(): "  + word.elementContent);
		return stringWord;
	}
	
	public JSONString stripQuestionMark(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("\\?", ""));
		System.out.println("PunctuationUtility:Quotation():  "  + word.elementContent);
		return stringWord;
	}
	
	public JSONString stripNulls(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("null", ""));
		System.out.println("PunctuationUtility:null statement "  + word.elementContent);
		return stringWord;
		
	}
	public JSONString stripCurleyBraces(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("\\{", ""));
		System.out.println("PunctuationUtility:Curley Braces:  "  + word.elementContent);
		return stringWord;
	}
	public JSONString stripRightCurleyBrace(JSONString word)
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("\\}", ""));
		System.out.println("PunctuationUtility:Curley Braces:  "  + word.elementContent);
		return stringWord;
	}
	
	public JSONString stripColon(JSONString word)
	
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll(":", ""));
		System.out.println("PunctuationUtility:Colon  "  + word.elementContent);
		return stringWord;
	}
	public JSONString stripText(JSONString word)
	
	{
		JSONString stringWord = new JSONString();
		stringWord.setElementContent(word.elementContent.replaceAll("text", ""));
		System.out.println("PunctuationUtility:Colon  "  + word.elementContent);
		return stringWord;
	}
	
	
	
	
}
