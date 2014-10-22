import java.io.*;

public class Noiseremove {

	public static void main(String args[])throws IOException
	{
		String s = ""; 
		String ss = "'s";
		String sS = "'S";
		String re = "'re";
		String m = "'m";
		String ve = "'ve";
		String http = "http:";
		String ll = "\\";
		String percent = "%";
		String spt = "u2019t";
		String sps = "u2019s";
		String su = "u2019";
		
		FileInputStream fin;
		DataInputStream din;
		BufferedReader br;
		FileWriter fw;
		BufferedWriter bw;
		boolean b;
		boolean b2;
		int index;
		
		fin = new FileInputStream("verbpol.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		
		while((s = br.readLine()) != null) { 
			
			b = (!(s.equals(ss)) && !(s.equals(sS)) && !(s.equals(m)) && !(s.equals(percent)) && !(s.equals(ve)) );
			b2 = (b && (!(s.equals(spt)) && !(s.equals(sps)) && !(s.equals(su)) && !(s.equals(ll)) && !(s.equals(re)) ));
			index = s.indexOf(http);
			
			if (index != -1 || b2 != false || s.charAt(0)!= '\'') { 
				
				fw = new FileWriter("iverbpol.txt",true);
				bw = new BufferedWriter(fw);
				bw.write(s);
				bw.newLine();
				bw.close();
			}
		}
		
		fin = new FileInputStream("nounpol.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		
		while((s = br.readLine()) != null) { 
			
			b = (!(s.equals(ss)) && !(s.equals(sS)) && !(s.equals(m)) && !(s.equals(percent)) && !(s.equals(ve)) );
			b2 = (b && (!(s.equals(spt)) && !(s.equals(sps)) && !(s.equals(su)) && !(s.equals(ll)) && !(s.equals(re)) ));
			index = s.indexOf(http);
			
			if (index != -1 || b2 != false || s.charAt(0)!= '\'') { 
				
				fw = new FileWriter("inounpol.txt",true);
				bw = new BufferedWriter(fw);
				bw.write(s);
				bw.newLine();
				bw.close();
			}
		}
		
		fin = new FileInputStream("adjpol.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		
		while((s = br.readLine()) != null) { 
			
			b = (!(s.equals(ss)) && !(s.equals(sS)) && !(s.equals(m)) && !(s.equals(percent)) && !(s.equals(ve)) );
			b2 = (b && (!(s.equals(spt)) && !(s.equals(sps)) && !(s.equals(su)) && !(s.equals(ll)) && !(s.equals(re)) ));
			index = s.indexOf(http);
			
			if (index != -1 || b2 != false || s.charAt(0)!= '\'') { 
				
				fw = new FileWriter("iadjpol.txt",true);
				bw = new BufferedWriter(fw);
				bw.write(s);
				bw.newLine();
				bw.close();
			}
		} 
		
		fin = new FileInputStream("verbspo.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		
		while((s = br.readLine()) != null) { 
			
			b = (!(s.equals(ss)) && !(s.equals(sS)) && !(s.equals(m)) && !(s.equals(percent)) && !(s.equals(ve)) );
			b2 = (b && (!(s.equals(spt)) && !(s.equals(sps)) && !(s.equals(su)) && !(s.equals(ll)) && !(s.equals(re)) ));
			index = s.indexOf(http);
			
			if (index != -1 || b2 != false || s.charAt(0)!= '\'') { 
				
				fw = new FileWriter("iverbspo.txt",true);
				bw = new BufferedWriter(fw);
				bw.write(s);
				bw.newLine();
				bw.close();
			}
		}
		
		fin = new FileInputStream("nounspo.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		
		while((s = br.readLine()) != null) { 
			
			b = (!(s.equals(ss)) && !(s.equals(sS)) && !(s.equals(m)) && !(s.equals(percent)) && !(s.equals(ve)) );
			b2 = (b && (!(s.equals(spt)) && !(s.equals(sps)) && !(s.equals(su)) && !(s.equals(ll)) && !(s.equals(re)) ));
			index = s.indexOf(http);
			
			if (index != -1 || b2 != false || s.charAt(0)!= '\'') { 
				
				fw = new FileWriter("inounspo.txt",true);
				bw = new BufferedWriter(fw);
				bw.write(s);
				bw.newLine();
				bw.close();
			}
		}
		
		fin = new FileInputStream("adjspo.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		
		while((s = br.readLine()) != null) { 
			
			b = (!(s.equals(ss)) && !(s.equals(sS)) && !(s.equals(m)) && !(s.equals(percent)) && !(s.equals(ve)) );
			b2 = (b && (!(s.equals(spt)) && !(s.equals(sps)) && !(s.equals(su)) && !(s.equals(ll)) && !(s.equals(re)) ));
			index = s.indexOf(http);
			
			if (index != -1 || b2 != false || s.charAt(0)!= '\'') { 
				
				fw = new FileWriter("iadjspo.txt",true);
				bw = new BufferedWriter(fw);
				bw.write(s);
				bw.newLine();
				bw.close();
			}
		}
	
	}
}
