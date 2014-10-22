
public class CreateFeat {
	
	public static double[][] CountPos(String s)
	{
		double feat[][] = new double[3][1];
		double noun_sum = 0.0;
		double verb_sum = 0.0;
		double adj_sum = 0.0;
		int count_noun = 0;
		int count_verb = 0;
		int count_adj =  0;
		int start = 0;
		int pos_start  = 0;
		String word = "";
		String label = "";
		for (int i = 0;i < s.length();i++) {
			
			if (s.charAt(i) == '_') {
				
				word = s.substring(start,i);
				pos_start = i+1;
			
			
				while ( i!= s.length() && s.charAt(i) != ' ') {
					
					i++;
				}
			
				label = s.substring(pos_start, i);
				start = i+1;
				int sum = 0;
				for (int j = 0; j < word.length(); j++) {
				
					char ch = s.charAt(j);
				
					if (Character.isLetter(ch)) { 
					
						if (Character.isLowerCase(ch)) { 
					
							ch = (char)(ch - 32);
						}
						sum = sum + ch;
					}
				}
				if (sum != 0) {
					
					sum = sum/word.length();
				}
			
				if (label.equals("JJ") || label.equals("JJR")|| label.equals("JJS")) {
				
					adj_sum = adj_sum + sum;
					count_adj++;
					System.out.println("Adjective : " + word);
				}
			
				if (label.equals("NN") || label.equals("NNP") || label.equals("NNS")) {
				
					noun_sum = noun_sum + sum;
					count_noun++;
					System.out.println("Noun : " + word);
				}
			
				if (label.equals("VB") || label.equals("VBS") || label.equals("VBZ") || label.equals("VBG") || label.equals("VBP") || label.equals("VBN") || label.equals("VBD")) {
				
					verb_sum = verb_sum + sum;
					count_verb++;
					System.out.println("Verb : " + word);
				}
			}
		} 
		
		if (verb_sum != 0) {
			
			verb_sum = verb_sum/count_verb;
		} 
		
		if (noun_sum != 0) {
			
			noun_sum = noun_sum/count_noun;
		} 
		
		if (adj_sum != 0) {
			
			adj_sum = adj_sum/count_adj;
		} 
		
		feat[0][0] = noun_sum;
		feat[1][0] = adj_sum;
		feat[2][0] = verb_sum;
		
		return feat;
	}

}
