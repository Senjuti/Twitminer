import java.io.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class test {

		public static void main(String args[]) throws IOException,ClassNotFoundException
		{
			
			String sample = "President";
			BufferedReader br;
			BufferedWriter bw;
			FileInputStream fin;
			DataInputStream din;
			SorensenDice sd;
			MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words-distsim.tagger");
			String tag = tagger.tagString(sample);
			
			fin = new FileInputStream("inounpol.txt");
			din = new DataInputStream(fin);
			br = new BufferedReader(new InputStreamReader(din));
			
			String s;
			
			while ((s = br.readLine())!= null) {
				
				sd = new SorensenDice();
				double d = sd.getCoefficient(sample, s);
				if (d == 1.0) { 
					
					System.out.println(sample + ":Politics:" + s + "SD:" + d);
				}
			}
			
			fin = new FileInputStream("inounspo.txt");
			din = new DataInputStream(fin);
			br = new BufferedReader(new InputStreamReader(din));
			
			
			while ((s = br.readLine())!= null) {
				
				sd = new SorensenDice();
				double d = sd.getCoefficient(sample, s);
				if (d == 1.0) { 
					
					System.out.println(sample + ":Sports:" + s + "SD:" + d);
				}
			}
		}
}
