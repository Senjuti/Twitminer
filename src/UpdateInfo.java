import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.*;


public class UpdateInfo {
	
	private String tagged;
	private String label;
	
	UpdateInfo(String tagged,String label) {
		
		this.tagged = tagged;
		this.label = label;		
	}
	
	public void Update()throws IOException
	{	
		int w = 0;
		int found = 0;
		String s = "";
		BufferedReader br;
		BufferedWriter bw;
		FileWriter fw;
		FileInputStream fin;
		DataInputStream din;
		String word = "";
		String pos = "";
		int start;
		
		if (label.equalsIgnoreCase("sports")) {
			
			for (int i = 0; i < tagged.length(); i++) {
				
				found = 0;
				start = 0;
				word = "";
				
				if (tagged.charAt(i) == '_') {
					
					word = tagged.substring(w,i);
					start = i+1;
					
					while (tagged.charAt(i) != ' ') { 
						
						i++;
					} 
					
					w = i+1;
					
					pos = tagged.substring(start,i);
					
					if (pos.equals("JJ") || pos.equals("JJR") || pos.equals("JJS")) {
						
						fin = new FileInputStream("iadjspo.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){ 
							
							if (s.equalsIgnoreCase(word)) { 
								found = 1;
								break;
							}		
						}
						
						if (found == 0) {
							
							fw = new FileWriter("iadjspo.txt",true);
							bw = new BufferedWriter(fw);
							
							bw.write(word);
							bw.newLine();
							bw.close();
						}
					}
					
				if (pos.equals("NN") || pos.equals("NNP") || pos.equals("NNPS") || pos.equals("NNS")) {
					
					fin = new FileInputStream("inounspo.txt");
					din = new DataInputStream(fin);
					br = new BufferedReader(new InputStreamReader(din));
				
					while((s = br.readLine()) != null){ 
						
						if (s.equalsIgnoreCase(word)) { 
							found = 1;
							break;
						}		
					}
					
					if (found == 0) {
						
						fw = new FileWriter("inounspo.txt",true);
						bw = new BufferedWriter(fw);
						
						bw.write(word);
						bw.newLine();
						bw.close();
					}
				}
				
				if (pos.equals("VB") || pos.equals("VBD") || pos.equals("VBG") || pos.equals("VBN") || pos.equals("VBP") || pos.equals("VBZ")) {
					
					fin = new FileInputStream("iverbspo.txt");
					din = new DataInputStream(fin);
					br = new BufferedReader(new InputStreamReader(din));
				
					while((s = br.readLine()) != null){ 
						
						if (s.equalsIgnoreCase(word)) { 
							found = 1;
							break;
						}		
					}
					
					if (found == 0) {
						
						fw = new FileWriter("iverbspo.txt",true);
						bw = new BufferedWriter(fw);
						
						bw.write(word);
						bw.newLine();
						bw.close();
					}
				}
			 }
		  }
	   }
		
		else if (label.equalsIgnoreCase("politics")) {
			
			for (int i = 0; i < tagged.length(); i++) {
				
				found = 0;
				start = 0;
				word = "";
				
				if (tagged.charAt(i) == '_') {
					
					word = tagged.substring(w,i);
					start = i+1;
					
					while (tagged.charAt(i) != ' ') { 
						
						i++;
					}
					
					w = i+1;
					
					pos = tagged.substring(start,i);
					
					if (pos.equals("JJ") || pos.equals("JJR") || pos.equals("JJS")) {
						
						fin = new FileInputStream("iadjpol.txt");
						din = new DataInputStream(fin);
						br = new BufferedReader(new InputStreamReader(din));
					
						while((s = br.readLine()) != null){ 
							
							if (s.equalsIgnoreCase(word)) { 
								found = 1;
								break;
							}		
						}
						
						if (found == 0) {
							
							fw = new FileWriter("iadjpol.txt",true);
							bw = new BufferedWriter(fw);
							
							bw.write(word);
							bw.newLine();
							bw.close();
						}
					}
					
				if (pos.equals("NN") || pos.equals("NNP") || pos.equals("NNPS") || pos.equals("NNS")) {
					
					fin = new FileInputStream("inounpol.txt");
					din = new DataInputStream(fin);
					br = new BufferedReader(new InputStreamReader(din));
				
					while((s = br.readLine()) != null){ 
						
						if (s.equalsIgnoreCase(word)) { 
							found = 1;
							break;
						}		
					}
					
					if (found == 0) {
						
						fw = new FileWriter("inounpol.txt",true);
						bw = new BufferedWriter(fw);
						
						bw.write(word);
						bw.newLine();
						bw.close();
					}
				}
				
				if (pos.equals("VB") || pos.equals("VBD") || pos.equals("VBG") || pos.equals("VBN") || pos.equals("VBP") || pos.equals("VBZ")) {
					
					fin = new FileInputStream("iverbpol.txt");
					din = new DataInputStream(fin);
					br = new BufferedReader(new InputStreamReader(din));
				
					while((s = br.readLine()) != null){ 
						
						if (s.equalsIgnoreCase(word)) { 
							found = 1;
							break;
						}		
					}
					
					if (found == 0) {
						
						fw = new FileWriter("iverbpol.txt",true);
						bw = new BufferedWriter(fw);
						
						bw.write(word);
						bw.newLine();
						bw.close();
					}
				}
			 }
		  }
	   }
		
}

}
