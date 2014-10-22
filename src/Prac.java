
import java.io.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Prac {

		public static void main(String args[]) throws IOException,ClassNotFoundException
		{
			MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words-distsim.tagger");
			
			String sample = "President Obama signs the new pact though it took him too long";
			String tag = tagger.tagString(sample);
			System.out.println(sample);
			System.out.println(tag);
			int word = 0;
			int noun = 0;
			int verb = 0;
			int political = 0;
			int sports = 0;
			int adjective = 0;
			long pol_verb = 0;
			long pol_noun = 0;
			long pol_adj = 0;
			long sport_verb = 0;
			long sport_noun = 0;
			long sport_adj = 0;
			
			FileInputStream fstream  = new FileInputStream("filter.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			while ((sample = br.readLine())!= null) { 
				
				tag = tagger.tagString(sample);
				FileWriter q = new FileWriter("output.txt",true);
				BufferedWriter out = new BufferedWriter(q);
				
				out.write(tag);
				out.newLine();
				out.close();
			} 			
			FileInputStream fst  = new FileInputStream("output.txt");
			in = new DataInputStream(fst);
			br = new BufferedReader(new InputStreamReader(in));
			String w = "";
			String first = "";
			
			while ((sample = br.readLine()) != null) { 
				
				word = 0;
				noun = 0;
				verb = 0;
				adjective = 0;
				first = "";
				w = "";
				System.out.println();
				for (int i = 0;i < sample.length();i++) { 
					if (sample.charAt(i) == '_') { 
						int start = i+1;
						w = sample.substring(word,i);
							if (word == 0) {
								System.out.print(w + " ");
								first = w;
							}
						while (sample.charAt(i) != ' ') { 
							
							i++;
						}
						int end = i;
						word = i+1;
						String s = sample.substring(start,end);
						//System.out.print(s + " ");
						
						if (s.equals("NNP") || s.equals("NNS") || s.equals("NN")) { 
							
							System.out.print("Noun ");
							noun++;
							if (first.equals("politics")) { 
								
								FileWriter f = new FileWriter("nounpol.txt",true);
								BufferedWriter out = new BufferedWriter(f);
								
								if (!w.equals("politics")) { 
									
									out.write(w);
									out.newLine();
									out.close();
								}
							}
							
							if (first.equals("sports")) { 
								
								FileWriter f = new FileWriter("nounspo.txt",true);
								BufferedWriter out = new BufferedWriter(f);
								
								if (!w.equals("sports")) { 
									
									out.write(w);
									out.newLine();
									out.close();
								}
							}
						}
						
						else if (s.equals("JJ") || s.equals("JJR") || s.equals("JJS")) { 
							
							System.out.print(" Adjective ");
							adjective++;
							
							if (first.equals("politics")) { 
								
								FileWriter f = new FileWriter("adjpol.txt",true);
								BufferedWriter out = new BufferedWriter(f);
								out.write(w);
								out.newLine();
								out.close();
							}
							
							if (first.equals("sports")) { 
								
								FileWriter f = new FileWriter("adjspo.txt",true);
								BufferedWriter out = new BufferedWriter(f);
								out.write(w);
								out.newLine();
								out.close();
							}
						} 
						
						else if (s.equals("VB")|| s.equals("VBZ") || s.equals("VBD") || s.equals("VBN")|| s.equals("VBP") || s.equals("VBG")) {
							
							System.out.print(" Verb ");
							verb++;
							if (first.equals("politics")) { 
								
								FileWriter f = new FileWriter("verbpol.txt",true);
								BufferedWriter out = new BufferedWriter(f);
								out.write(w);
								out.newLine();
								out.close();
							}
							
							if (first.equals("sports")) { 
								
								FileWriter f = new FileWriter("verbspo.txt",true);
								BufferedWriter out = new BufferedWriter(f);
								out.write(w);
								out.newLine();
								out.close();
							}
						}
					}
					
				}
					
				
				if (first.equals("sports")) { 
				
					sport_verb = sport_verb + verb;
					sport_adj = sport_adj + adjective;
					sport_noun = sport_noun + noun;
					sports++;
				} 
				if (first.equals("politics")) { 
					
					pol_verb = pol_verb + verb;
					pol_adj = pol_adj + adjective;
					pol_noun = pol_noun + noun;
					political++;
				}
				System.out.print(" V: " + verb + " N: " + noun + " A: " + adjective);
			} 
			System.out.println("For Politics :");
			System.out.println(" Verb: " + pol_verb + " Nouns: " + pol_noun + " Adjective: " + pol_adj);
			System.out.println("For Sports");
			System.out.println(" Verb: " + sport_verb + " Nouns: " + sport_noun + " Adjective: " + sport_adj);
			System.out.println("Number of political tweets :");
			System.out.println(political);
			System.out.println("Number of Sports tweets : ");
			System.out.println(sports);
		}
		 
}
		
		

