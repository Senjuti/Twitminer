import java.io.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class PrimitiveClassifier { 
	
	private String str;
	PrimitiveClassifier(String str){
		
		this.str = str;
	}
	public String BayesianClassifier() throws IOException,ClassNotFoundException
	{ 
		FileInputStream fin;
		DataInputStream din;
		BufferedReader br;
		String s;
		String pos = "";
		String word = "";
		long tot_nouns = 0;
		long tot_verbs = 0;
		long tot_adj = 0;
		long count_noun = 0;
		long count_adj = 0;
		long count_verb = 0;
		long pol_verb = 0;
		long pol_noun = 0;
		long pol_adj = 0;
		long spo_verb = 0;
		long spo_noun = 0;
		long spo_adj = 0;
		long tot_pol_noun = 0;
		long tot_pol_verb = 0;
		long tot_pol_adj = 0;
		long tot_spo_noun = 0;
		long tot_spo_verb = 0;
		long tot_spo_adj = 0;
		long polnoun[] = new long[21000];
		long polverb[] = new long[21000];
		long poladj[] = new long[21000];
		long spoverb[] = new long[21000];
		long sponoun[] = new long[21000];
		long spoadj[] = new long[21000];
		int cpnoun = 0;
		int cpverb = 0;
		int cpadj = 0;
		int csnoun = 0;
		int csverb = 0;
		int csadj = 0;
		double pi = Math.PI;
		pi = 2*pi;
		pi = Math.sqrt(pi);
		pi = Math.pow(pi,3.0);
		//pi = Math.pow(pi,-1.0);
		
		String label = "";
		MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words-distsim.tagger");
		fin = new FileInputStream("output.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din)); 
		
		while ((s = br.readLine()) != null) {
			
			label = "";
			int first_space = s.indexOf(' ');
			int first_underscore = s.indexOf('_');
			
			if (first_underscore != -1) {
				
				label = s.substring(0,first_underscore);
			}
			
			if (first_space != -1) {
				
				s = s.substring(first_space+1);
			}
			
			int start = 0;
			int end = 0;
			
			for (int i = 0;i < s.length(); i++) { 
				
				if (s.charAt(i) == '_') { 
					
					word = s.substring(start,i);
					end = i+1;
				 
				while (s.charAt(i)!= ' ') {
					
					i++;
				}
				pos = s.substring(end,i);
				start = i+1;
			 
				if (pos.equals("NNP") || pos.equals("NNS") || pos.equals("NN")) { 
					
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
					
					//System.out.print(" Noun: " + (sum/word.length()));
					tot_nouns = tot_nouns + (sum/word.length());
					count_noun++;
					if (label.equals("politics")) {
						
						pol_noun = pol_noun + (sum/word.length());
						tot_pol_noun = tot_pol_noun + 1;
						polnoun[cpnoun++] = (sum/word.length());
					}
					
					if (label.equals("sports")) {
						
						spo_noun = spo_noun + (sum/word.length());
						tot_spo_noun++;
						sponoun[csnoun++] = (sum/word.length());
					}
				} 
				
				if (pos.equals("VB") || pos.equals("VBS") || pos.equals("VBZ") || pos.equals("VBG") || pos.equals("VBP") || pos.equals("VBN") || pos.equals("VBD")) {
					
					
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
					
					
					tot_verbs = tot_verbs + (sum/word.length());
					count_verb++; 
					
					if (label.equals("politics")) {
						
						pol_verb = pol_verb + (sum/word.length());
						tot_pol_verb++;
						polverb[cpverb++] = (sum/word.length());
					}
					
					if (label.equals("sports")) {
						
						spo_verb = spo_verb + (sum/word.length());
						tot_spo_verb++;
						spoverb[csverb++] = (sum/word.length());
					}
				}
				
				if (pos.equals("JJ") || pos.equals("JJS") || pos.equals("JJR")) { 
					
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
					
					
					tot_adj = tot_adj + (sum/word.length());
					count_adj++;
					
					if (label.equals("politics")) {
						
						pol_adj = pol_adj + (sum/word.length());
						tot_pol_adj++;
						poladj[cpadj++] = (sum/word.length());
					} 
					
					if (label.equals("sports")) {
						
						spo_adj = spo_adj + (sum/word.length());
						tot_spo_adj++;
						spoadj[csadj++] = (sum/word.length());
					}
				}		
			  }    	
			}
			//System.out.println();
			
	} 
		
	System.out.println("The total Verbs sum is : " + tot_verbs);
	System.out.println("The total Nouns sum is : " + tot_nouns);
	System.out.println("The total Adjectives sum is : " + tot_adj);
	System.out.println("The total nouns are : " + count_noun);
	System.out.println("The total verbs are : " + count_verb);
	System.out.println("The total Adjectives are : " + count_adj);
	System.out.println("The mean of Verbs is : " + (double)(tot_verbs/count_verb));
	System.out.println("The mean of Nouns is : " + (double)(tot_nouns/count_noun));
	System.out.println("The mean of Adjective is : " + (double)(tot_adj/count_adj));
	System.out.println("The total Political nouns are : " + tot_pol_noun);
	System.out.println("The total Political verbs are : " + tot_pol_verb);
	System.out.println("The total Political Adjectives are : " + tot_pol_adj);
	System.out.println("The total Sports Nouns are : " + tot_spo_noun);
	System.out.println("The total Sports Verbs are : " + tot_spo_verb);
	System.out.println("The total Sports Adjectives are : " + tot_spo_adj);
	System.out.println("The mean of Political Nouns is : " + (pol_noun/tot_pol_noun));
	System.out.println("The mean of Political Verbs is : " + (pol_verb/tot_pol_verb));
	System.out.println("The mean of Political Adjectives is : " + (pol_adj/tot_pol_adj));
	System.out.println("The mean of Sports Nouns is : " + (spo_noun/tot_spo_noun));
	System.out.println("The mean of Sports Verbs is : " + (spo_verb/tot_spo_verb));
	System.out.println("The mean of Sports Adjectives is : " + (spo_adj/tot_spo_adj));
	
	int epolnoun = (int)(pol_noun/tot_pol_noun);
	int epolverb = (int)(pol_verb/tot_pol_verb);
	int epoladj = (int)(pol_adj/tot_pol_adj);
	int esponoun = (int)(spo_noun/tot_spo_noun);
	int espoverb = (int)(spo_verb/tot_spo_verb);
	int espoadj = (int)(spo_adj/tot_spo_adj);
	
	System.out.println("The Variance of Political verbs is : " + variance(polverb,epolverb,cpverb));
	System.out.println("The Variance of Political nouns is : " + variance(polnoun,epolnoun,cpnoun));
	System.out.println("The Variance of Political Adjectives is : " + variance(poladj,epoladj,cpadj));
	System.out.println("The Variance of Sports verbs is : " + variance(spoverb,espoverb,csverb));
	System.out.println("The Variance of Sports nouns is : " + variance(sponoun,esponoun,csnoun));
	System.out.println("The Variance of Sports Adjectives is : " + variance(spoadj,espoadj,csadj));
	
	double pol_mean[][] = {{epolnoun},{epoladj},{epolverb}};
	double spo_mean[][] = {{esponoun},{espoadj},{espoverb}};
	
	double varpolverb = variance(polverb,epolverb,cpverb);
	double varpolnoun = variance(polnoun,epolnoun,cpnoun);
	double varpoladj = variance(poladj,epoladj,cpadj);

	System.out.println("Mean Matrix of Politics: ");
	
	for (int i = 0;i < pol_mean.length; i++) {
		
		for (int j = 0;j < pol_mean[0].length; j++) {
			
			System.out.print(pol_mean[i][j]);
		}
		
		System.out.println();
	} 
	
	System.out.println("Mean Matrix of Sports : "); 
	
	for (int i = 0;i < spo_mean.length; i++) {
		
		for (int j = 0;j < spo_mean[0].length; j++) {
			
			System.out.print(spo_mean[i][j]);
		}
		
		System.out.println();
	}
	
	double noun_adj = 0;
	double noun_verb = 0;
	double adj_verb = 0;
	
	for (int i = 0; i < cpnoun; i++) {
		
		noun_adj = noun_adj + (polnoun[i]- epolnoun)*(poladj[i] - epoladj);
	}
	
	noun_adj = noun_adj/cpnoun;
	
	for (int i = 0; i < cpnoun; i++) {
		
		noun_verb = noun_verb + (polnoun[i]- epolnoun)*(polverb[i] - epolverb);
	}
	
	noun_verb = noun_verb/cpnoun;
	
	for (int i = 0; i < cpverb; i++) {
		
		adj_verb = adj_verb + (polverb[i]- epolverb)*(poladj[i] - epoladj);
	}
	
	adj_verb = adj_verb/cpverb;
	
	double cov_pol[][] = {{varpolnoun,noun_adj,noun_verb},{noun_adj,varpoladj,adj_verb},{noun_verb,adj_verb,varpolverb}};
	
	System.out.println("Covariance Matrix for Politics is : ");
	
	for (int i = 0;i < cov_pol.length; i++) {
		
		for (int j = 0;j < cov_pol[0].length; j++) {
			
			System.out.print((cov_pol[i][j] /= 100) + " ");
		}
		
		System.out.println();
	}
	
	double varspoverb = variance(spoverb,espoverb,csverb);
	double varsponoun = variance(sponoun,esponoun,csnoun);
	double varspoadj = variance(spoadj,espoadj,csadj);
	
	noun_adj = 0;
	noun_verb = 0;
	adj_verb = 0; 
	
	for (int i = 0; i < csnoun; i++) {
		
		noun_adj = noun_adj + (sponoun[i]- esponoun)*(spoadj[i] - espoadj);
	}
	
	noun_adj = noun_adj/csnoun;
	
	for (int i = 0; i < csnoun; i++) {
		
		noun_verb = noun_verb + (sponoun[i]- esponoun)*(spoverb[i] - espoverb);
	}
	
	noun_verb = noun_verb/csnoun;
	
	for (int i = 0; i < csverb; i++) {
		
		adj_verb = adj_verb + (spoadj[i]- espoadj)*(spoverb[i] - espoverb);
	}
	
	adj_verb = adj_verb/csverb;
	
	double cov_spo[][] = {{varsponoun,noun_adj,noun_verb},{noun_adj,varspoadj,adj_verb},{noun_verb,adj_verb,varspoverb}}; 
	
	System.out.println("The Covariance Matrix of the Sports class is : ");
	
	for (int i = 0;i < cov_spo.length; i++) {
		
		for (int j = 0;j < cov_spo[0].length; j++) {
			
			System.out.print((cov_spo[i][j] /= 100)  + " ");
		}
		
		System.out.println();
	}
	
	MatrixOp mop = new MatrixOp(); 
	
	double det_pol = mop.determinant(cov_pol,3);
	double det_spo = mop.determinant(cov_spo,3);
	double inv_spo[][] = new double [3][3];
	double inv_pol[][] = new double [3][3];
	
	inv_spo = mop.inverse(cov_spo);
	inv_pol = mop.inverse(cov_pol);
	
	System.out.println("The Inverse of Sports Matrix is :");
	
	for (int i = 0;i < inv_spo.length; i++) {
		
		for (int j = 0;j < inv_spo[0].length; j++) {
			
			System.out.print(inv_spo[i][j] + " ");
		}
		
		System.out.println();
	} 
	
	System.out.println("Inverse Matrix for Politics is : ");
	
	for (int i = 0;i < inv_pol.length; i++) {
		
		for (int j = 0;j < inv_pol[0].length; j++) {
			
			System.out.print(inv_pol[i][j] + " ");
		}
		
		System.out.println();
	}
	
	System.out.println("The determinant of the politics covariance matrix is :" + det_pol);
	System.out.println("The determinant of the sports covariance matrix is :" + det_spo);
	
	double apriorspo = 0.51;
	double apriorpol = 0.49;
	double const_spo = pi*Math.sqrt(det_spo);
	double const_pol = pi*Math.sqrt(det_pol);

	const_spo = Math.pow(const_spo,-1.0);
	const_pol = Math.pow(const_pol,-1.0);
	
	label = "";
	/*MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words-distsim.tagger");
	fin = new FileInputStream("val3.txt");
	din = new DataInputStream(fin);
	br = new BufferedReader(new InputStreamReader(din));*/
			
		//label = tagger.tagString(str);
		double feat[][] = new double[3][1];
		CreateFeat ft = new CreateFeat();
		
		feat = ft.CountPos(str);
		
		double subt_pol[][] = new double[3][1];
		double subt_spo[][] = new double[3][1];
		double pol_tran[][] = new double[1][3];
		double spo_tran[][] = new double[1][3];
		double pol_12[][] = new double[1][3];
		double pol_23 = 0.0;
		double spo_12[][] = new double[1][3];
		double spo_23 = 0.0;
		
		subt_pol = mop.subtract(feat, pol_mean);
		subt_spo = mop.subtract(feat, spo_mean);
		pol_tran = mop.transpose(subt_pol);
		spo_tran = mop.transpose(subt_spo);
		pol_12 = mop.multiply12(pol_tran, inv_pol);
		pol_23 = mop.multiply23(pol_12, subt_pol);
		spo_12 = mop.multiply12(spo_tran, inv_spo);
		spo_23 = mop.multiply23(spo_12,subt_spo);
		
		spo_23 = -0.5*spo_23;
		pol_23 = -0.5*pol_23;
		
		spo_23 = Math.exp(spo_23);
		pol_23 = Math.exp(pol_23);
		
		double prob_spo = spo_23*const_spo*apriorspo;
		double prob_pol = pol_23*const_pol*apriorpol;
		
		System.out.println("Sports: " + prob_spo);
		System.out.println("Politics: " + prob_pol);
		
		
		if (prob_spo >= prob_pol) {
			
			return "sports";
		}
		
		else {
			
			return "politics";
		}
		
}
	
	public static double variance(long a[],int mean,int n)
	{
		double var = 0;
		
		for (int i = 0; i < n; i++) {
			
			var = var + Math.pow((a[i]-mean),2.0);
		}
		
		var = (var/n-1);
		
		return var;
	}

} 
