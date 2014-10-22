import java.io.*;

public class Pearson { 
	
	public static void main(String args[])throws IOException { 
		
		BufferedReader br,br1;
		FileInputStream fin,fin1;
		DataInputStream din,din1;
		FileWriter fw;
		BufferedWriter bw;
		
		
		fin = new FileInputStream("BOOK_LOD.txt");
		din = new DataInputStream(fin);
		br = new BufferedReader(new InputStreamReader(din));
		fw = new FileWriter("pearson1.txt",true);
		bw = new BufferedWriter(fw);
		
		String s;
		String s1;
		double a[] = new double[5];
		double b[] = new double[5];
		String book_name;
		s = br.readLine();
		int start;
		int line = 0;
		int c,c1;
		c = 0;
		c1 = 0;
		
		while (!(s = br.readLine()).equalsIgnoreCase("FileEndsHere")) { 
			
			start = 0;
			line++; 
			
			while (s.charAt(start) != '\t') { 
				
				start++;
			}
			
			book_name = s.substring(0,start);
			s = s.substring(start+1);
					
			for (int i = 0;i < s.length(); i++) { 
				
				start = i; 
				
				while ( i < s.length() && s.charAt(i) != '\t') { 
					
					i++;			
				}
				
				if (i > start) { 
					
					String str = s.substring(start,i);
					double d = Double.parseDouble(str);
					//System.out.println("Float value: " + d);
					a[c++] = d;
					
				} 
						
			}
				
			/*System.out.println("Array A is :");
			
			for (int k = 0; k < a.length; k++) { 
				
				System.out.println(a[k]);
			} */
				
			c = 0; 
			
			fin1 = new FileInputStream("BOOK_LOD.txt");
			din1 = new DataInputStream(fin1);
			br1 = new BufferedReader(new InputStreamReader(din1));
			
			for (int i = 1; i <= line+1; i++) { 
				
				br1.readLine();
			}
			
			while (!(s1 = br1.readLine()).equalsIgnoreCase("FileEndsHere")) {
				
				//System.out.println("S1 is :" + s1); 
				start = 0; 
				
				while (s1.charAt(start) != '\t') { 
					
					start++;
				} 
				
				String book_name1 = s1.substring(0,start);
				s1 = s1.substring(start+1);
				
			
				for (int i = 0;i < s1.length(); i++) { 
					
					start = i; 
					
					while ( i < s1.length() && s1.charAt(i) != '\t') { 
						
						i++;			
					} 
					
					if (i > start) { 
						
						String str = s1.substring(start,i);
						double d = Double.parseDouble(str);
						//System.out.println("Float value1: " + d);
						b[c1++] = d;
						
					}  					
				}
					
				
				c1 = 0;  
				
				/*System.out.println("Array B is :"); 
				
				for (int k1 = 0; k1 < b.length; k1++) { 
					
					System.out.println(b[k1]);
				} */ 
				
				System.out.println(book_name);
				System.out.println("The Pearson Coefficient is : " + correlate(a,b));
				System.out.println(book_name1);
				System.out.println("\n-------------------------------");
				 bw.write(book_name);
				 bw.newLine();
				 bw.write("The Pearson Coefficient is : " + correlate(a,b));
				 bw.newLine();
				 bw.write(book_name1);
				 bw.newLine();
				 bw.write("-------------------------------------------");
				 bw.newLine();
				 
			}
			//System.out.println(s);
			
			
		}
		bw.close();
	}
	
	public static double similar(double a[],double b[]) 
	{ 
		int i;
		double pearson = 0.0;
		double mean_a = 0.0;
		double mean_b = 0.0;
		double variance_a = 0.0;
		double variance_b = 0.0;
		double covariance_ab = 0.0;
		double sum_a = 0.0;
		double sum_b = 0.0;
		
		for (i = 0;i < a.length; i++) {
		
			sum_a = sum_a + a[i];
		}
		mean_a = sum_a/a.length; 
		
		for (i = 0;i < b.length; i++) {
			
			sum_b = sum_b + b[i];
		}
		mean_b = sum_b/b.length;
		
		for (i = 0;i < a.length;i++) { 
			
			variance_a = variance_a + Math.pow((a[i]-mean_a),2.0);
		}
		
		variance_a = (variance_a/(a.length-1));
		
		for (i = 0;i < b.length;i++) { 
			
			variance_b = variance_b + Math.pow((b[i]-mean_b),2.0);
		}
		
			variance_b = (variance_b/(b.length-1));
			
		for (i = 0; i < a.length; i++) { 
			
			double temp = (a[i] - mean_a) * (b[i] - mean_b);
			covariance_ab = covariance_ab + temp;
		}
		covariance_ab = covariance_ab/a.length;
		
		pearson = covariance_ab/(Math.sqrt(variance_a)*Math.sqrt(variance_b));
		
		return pearson;
	} 
	
	public static double correlate(double a[],double b[]) 
	{ 
		double pearson = 0.0;
		double temp = 0.0;
		double square_a = 0.0;
		double square_b = 0.0;
		
		for (int i = 0;i < a.length; i++) { 
			 
			for (int j = 0; j < b.length; j++) { 
				
				temp = temp + a[i]*b[j];
			}  
			
			square_a = square_a + (a[i]*a[i]);
			square_b = square_b + (b[i]*b[i]);
		}
		
		square_a = Math.sqrt(square_a);
		square_b = Math.sqrt(square_b);
		
		pearson = (temp/(square_a * square_b)); 
		
		return pearson;
	}
}
