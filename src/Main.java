import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Main {

	

	HashMap<String,String> match = new HashMap<String,String>();
	
	 
	public static void main(String[] args) {
		
		long time =  System.currentTimeMillis();

		NPS npsObject = new NPS();
			
		//this loads the  text file line by line
		//into a stack (fileString)
		npsObject.run("testpayload10.txt");
		
		
		//this runs VoZ feeding it the document file
		//VoZ outputs the parts of speech
		//vozReturnString
		//it then processes VoZ's output and
		//saves the part of speech on the scratchpad
		npsObject.sendFlexibleArray();
		
		
		//extracts a pattern from the sentence stack
		XMLPattern pattern = npsObject.mainLoop();
		
		
		
		
		//match templates
		//matches against a string, shouldn't it be a pattern??
		//!!
		
		Main m = new Main();
		m.matching(npsObject, pattern);
		
		
		
		long endtime = System.currentTimeMillis();
		
		long totaltime = endtime - time;
		
		System.out.println("Time in milliseconds: " + totaltime);


			
	}
	
	public void matching(NPS npsObject, XMLPattern xmlPattern)
	{
		TemplateComparator temc = new TemplateComparator();
		
		TemplateRules templates = new TemplateRules();
		//Alice
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule1));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule2));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule3));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule4));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule5));
		//fail temc.matcher(xmlPattern, match,  templates.rule7);
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule8));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule10));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule11));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule12));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule13));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule14));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule15));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule16));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule17));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule18));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule19));
		
		///brave new world 20-40
		//match.putAll(temc.matcher(xmlPattern, match,  templates.rule20));
		
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule20));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule21));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule22));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule23));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule24));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule25));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule26));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule27));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule28));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule29));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule30));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule32));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule33));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule34));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule35));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule35));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule36));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule37));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule38));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule39));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule40));
		
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule41));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule42));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule43));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule44));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule45));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule46));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule47));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule48));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule49));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule50));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule51));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule52));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule53));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule54));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule55));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule56));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule57));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule58));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule59));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule60));
		
		//
		
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule61));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule62));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule63));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule64));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule65));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule66));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule67));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule68));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule69));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule70));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule71));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule72));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule73));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule74));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule75));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule76));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule77));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule78));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule79));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule80));
		
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule81));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule82));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule83));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule84));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule85));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule86));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule87));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule88));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule89));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule90));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule91));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule92));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule93));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule94));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule95));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule96));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule97));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule98));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule99));
		match.putAll(temc.matcher(xmlPattern, match,  templates.rule100));
		
		outputResults(match);
	}
	
	public void outputResults(HashMap<String,String> match)
	{
		System.out.println("Output Results");
		System.out.println("Match size is " + match.size());
		Iterator it = match.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        
	        System.out.println("Source:" + pair.getKey());
	        System.out.println("Template" +  pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
}