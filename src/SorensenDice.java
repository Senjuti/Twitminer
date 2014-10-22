public class SorensenDice
{
   protected String bigram(String s)
   {    
       String parsed;
       
       parsed = "";
       
       for (int i = 1;i < s.length();i++) {
           
           String temp = "" + s.charAt(i-1) + "" + s.charAt(i) + ",";
           parsed = parsed + temp;
       }
       
       return parsed;
   }
   
   private int count(String s)
   {
       int c = 0;
       
       for (int i = 0;i < s.length(); i++) {
           
           if (s.charAt(i) == ',') {
               
               c++;
            }
       }
       
       return c;
    }
    
   public double getCoefficient(String s1,String s2)
   {    
       
       if (s1 == null || s2 == null || s1 == "" || s2 == "") { 
           
           return 0;
        }
        
       int bigram_count1;
       int bigram_count2;
       int start1;
       int start2;
       int common; 
       double d;
       
       String t1,t2;
       start1 = 0;
       start2 = 0;
       common = 0;
       
       String s1_temp = bigram(s1);
       String s2_temp = bigram(s2);
       bigram_count1 = count(s1_temp);
       bigram_count2 = count(s2_temp);
       
       /*System.out.println(s1);
       System.out.println(s2);
       System.out.println(s1_temp);
       System.out.println(s2_temp);*/
       
       
       for (int i = 0;i < s1_temp.length();) {
                    start2 = 0;
                    
                    while(s1_temp.charAt(i) != ',') {   
                        i++;
                    }
                    t1 = s1_temp.substring(start1,i);
                    start1 = i+1;
                    
                    for (int j = 0;j < s2_temp.length();) {
                        
                        while(s2_temp.charAt(j) != ',') {
                            j++;
                        }
                        t2 = s2_temp.substring(start2,j);
                        start2 = j+1;
                        
                        if (t1.equalsIgnoreCase(t2)) {
                            
                            common++;
                        }
                    
                        j++;
                    }
                    i++;
          } 
          /*System.out.println(bigram_count1);
          System.out.println(bigram_count2);
          System.out.println(common);*/
          
          d = (double)((2.0*common)/(1.0*bigram_count1 + 1.0*bigram_count2));
          
          return d;
   }                          
  }

