import java.io.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Prototype {
	
	private String str;
	
	Prototype(String str) 
	{
		this.str = str;
	}
	public String PatternMatch()throws IOException,ClassNotFoundException
	{
		MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words-distsim.tagger");
		String sample;
		String tag;
		String word;
		String pos;
		String s;
		int sports;
		int politics;
		BufferedReader br;
		BufferedReader br1;
		FileWriter fw;
		FileInputStream fin,fin1;
		FileOutputStream fout;
		DataInputStream din,din1;
		EditDistance ed;
		SorensenDice sd;
		sample = "";
		sports = 0;
		politics = 0;
		int w = 0;
		int start;
		int end;
		int pol_temp = 999;
		int spo_temp = 999;
		double soren_spo = -1;
		double soren_pol = -1;
		int total_politics = 0;
		int total_sports = 0;
		
					
		
			tag = str;
			w = 0;	
			for (int i = 0; i < tag.length(); i++) { 
			
				if (tag.charAt(i)== '_') { 
				
					word = tag.substring(w,i);
					start = i+1;
					while (tag.charAt(i)!= ' ') { 
					
						i++;
					}
					end = i;
					w = i+1; 
				
					pos = tag.substring(start,end);
					System.out.println(word);
					System.out.println(pos); 
					
					spo_temp = 999;
					pol_temp = 999;
					
					if (pos.equals("JJ") || pos.equals("JJR") || pos.equals("JJS")) {
					
						fin = new FileInputStream("iadjspo.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){
						
							/*sd = new SorensenDice();
							double t = sd.getCoefficient(word, s);
						
							if (t < soren_spo) { 
								soren_spo = t;
							}*/
							ed = new EditDistance(word,s);
							int temp = ed.distance();
						
							if (temp < spo_temp) {
							
								spo_temp = temp;		
							} 
						}
					
						/*if (s.equalsIgnoreCase(word)) { 
						
							sports++;
							break;
						}*/		
							 
						fin = new FileInputStream("iadjpol.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){
						
							/*sd = new SorensenDice();
							double t = sd.getCoefficient(word, s);
						
							if (t < soren_pol) { 
								soren_pol = t;
							}*/
							ed = new EditDistance(word,s);
							int temp = ed.distance();
						
							if (temp < pol_temp) {
							
								pol_temp = temp;
							}

							/*if (s.equalsIgnoreCase(word)) { 
							
								politics++;
								break;
							}*/
					
						}
				
						/*if (soren_spo > soren_pol) {
						
							sports++;
							System.out.println("Spo: "+ word);
					} 
				
					else if(soren_pol > soren_spo) {
					
						politics++;
						System.out.println("Pol: "+ word);
					} else {
					
						sports++;
						politics++;
					}
			 	}
					soren_spo = -1;
					soren_pol = -1; */
				
						if (spo_temp < pol_temp) {
					
							sports++;
							System.out.println("Spo: "+ word);
						} 
				
						else if(pol_temp < spo_temp) {
					
							politics++;
							System.out.println("Pol: "+ word);
						} else {
					
							sports++;
							politics++;
						}
					}
					spo_temp = 999;
					pol_temp = 999; 
				
					if (pos.equals("NN") || pos.equals("NNP") || pos.equals("NNPS") || pos.equals("NNS")) {
					
						fin = new FileInputStream("inounspo.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){
						
						
							/*sd = new SorensenDice();
							double t = sd.getCoefficient(word, s);
						
							if (t < soren_spo) { 
								soren_spo = t;
							}*/
						
							ed = new EditDistance(word,s);
							int temp = ed.distance();
						
							if (temp < spo_temp) {
							
								spo_temp = temp;
							}
						
							/*if (s.equalsIgnoreCase(word)) { 
							
								sports++;
								break;
							}*/
						} 
					
						fin = new FileInputStream("inounpol.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){
						
							/*sd = new SorensenDice();
							double t = sd.getCoefficient(word, s);
						
							if (t < soren_pol) { 
								soren_pol = t;
							}*/
						
							ed = new EditDistance(word,s);
							int temp = ed.distance();
						
							if (temp < pol_temp) {
							
								pol_temp = temp;
							}
							/*if (s.equalsIgnoreCase(word)) { 
							
								politics++;
								break;
							}*/
						}
						/*if (soren_spo > soren_pol) {
						
							sports++;
							System.out.println("Spo: "+ word);
					} 
				
					else if(soren_pol > soren_spo) {
					
						politics++;
						System.out.println("Pol: "+ word);
					} else {
					
						sports++;
						politics++;
					}
			 	}
					soren_spo = -1;
					soren_pol = -1;*/
						if (spo_temp < pol_temp) {
						
							sports++;
							System.out.println("Spo: "+ word);
						} 
				
						else if(pol_temp < spo_temp) {
					
							politics++;
							System.out.println("Pol: "+ word);
					
						} else {
					
							sports++;
							politics++;
						}
					}
				
					spo_temp = 999;
					pol_temp = 999; 
					
				
					if (pos.equals("VB") || pos.equals("VBD") || pos.equals("VBG") || pos.equals("VBN") || pos.equals("VBP") || pos.equals("VBZ")) {
					
						fin = new FileInputStream("iverbspo.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){
						
							/*sd = new SorensenDice();
							double t = sd.getCoefficient(word, s);
						
							if (t < soren_spo) { 
								soren_spo = t;
							}*/
						
							ed = new EditDistance(word,s);
							int temp = ed.distance();
						
							if (temp < spo_temp) {
							
								spo_temp = temp;
							
							}
						
							/*if (s.equalsIgnoreCase(word)) { 
							
								sports++;
								break;
							}*/
						} 
					
						fin = new FileInputStream("iverbpol.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){
						
							/*sd = new SorensenDice();
							double t = sd.getCoefficient(word, s);
						
							if (t < soren_pol) { 
								soren_pol = t;
							}*/
						
							ed = new EditDistance(word,s);
							int temp = ed.distance();
						
							if (temp < pol_temp) {
							
								pol_temp = temp;
							}
						
							/*if (s.equalsIgnoreCase(word)) { 
							
								politics++;
								break;
							}*/
						}
						if (spo_temp < pol_temp) {
						
							sports++;
							System.out.println("Spo: "+ word);
						} 
				
						else if(pol_temp < spo_temp) {
					
							politics++;
							System.out.println("Pol: "+ word);
					
						} else {
					
							sports++;
							politics++;
						}
					}
						/*if (soren_spo > soren_pol) {
						
							sports++;
							System.out.println("Spo: "+ word);
					} 
				
					else if(soren_pol > soren_spo) {
					
						politics++;
						System.out.println("Pol: "+ word);
					} else {
					
						sports++;
						politics++;
					}
			 	}
					soren_spo = -1;
					soren_pol = -1;	

					}*/
				}
	
			}
		
		
			System.out.println("The Political terms are : " + politics);
			System.out.println("The Sports terms are : " + sports);
		
			if (politics > sports) { 
			
				System.out.println("The Tweet is political in nature");
				total_politics++;
				return "politics";
			
			} else if(sports > politics) { 
			
				System.out.println("The Tweet is Sports in nature"); 
				total_sports++;
				return "sports";
				
			} else {
		
				System.out.println("The category cannot be determined by the present tools");
				return "undetermined";
			} 
			
			
		
		
		
	}

}
