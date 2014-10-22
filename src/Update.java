import java.io.*;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class Update { 
	
	public static void main(String args[])throws IOException,ClassNotFoundException
	{
		MaxentTagger tagger = new MaxentTagger("taggers/wsj-0-18-left3words-distsim.tagger");
		FileInputStream fin;
		DataInputStream din;
		BufferedReader br;
		
		fin = new FileInputStream("cricketwi.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		
		String sample;
		String word;
		String pos;
		int start = 0;
		int end = 0;
		int w = 0;;
		
		while ((sample = br.readLine()) != null) { 
			
			String tag = tagger.tagString(sample);
			System.out.println(sample);
			System.out.println(tag);
			w = 0;
			for (int i = 0;i < tag.length(); i++) { 
				
				if (tag.charAt(i) == '_') { 
					 word = tag.substring(w,i);
					 start = i+1;
					 
					 while(tag.charAt(i)!= ' ') {
						 
						 i++;
					 }
					 end = i;
					 w = i+1;
					 pos = tag.substring(start,end);
					 
					 if(pos.equals("NNP") || pos.equals("NN") || pos.equals("NNS")) {
						 
						 FileWriter f = new FileWriter("inounspo.txt",true);
						 BufferedWriter bw = new BufferedWriter(f);
						 bw.write(word);
						 bw.newLine();
						 bw.close();
					 }
					 
					 if(pos.equals("VB") || pos.equals("VBD") || pos.equals("VBN") || pos.equals("VBZ") || pos.equals("VBG") || pos.equals("VBP")) {
						 
						 FileWriter f = new FileWriter("iverbspo.txt",true);
						 BufferedWriter bw = new BufferedWriter(f);
						 bw.write(word);
						 bw.newLine();
						 bw.close();
					 } 
					 
					 if(pos.equals("JJ") || pos.equals("JJS") || pos.equals("JJR")) {
						 
						 FileWriter f = new FileWriter("iadjspo.txt",true);
						 BufferedWriter bw = new BufferedWriter(f);
						 bw.write(word);
						 bw.newLine();
						 bw.close();
					 }
				}
			}
			
		}
		
	}

}
