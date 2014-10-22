
public class EditDistance {

    private String s1;
    private String s2;
    
    EditDistance(String s1,String s2)
    { 
      this.s1 = s1;
      this.s2 = s2;
    }
    
    int minimum(int a,int b,int c)
    {
        if (a < b && a < c) {
               return a;
        } else if (b < a && b < c) {
            return b;
        } else { 
            
            return c;
        }
    }
    
    int distance()
    { 
          
        if (s1 == null || s1 == "")
        {
            if (s2 == "" || s2 == null) {
                
                return 0;
            } else { 
                
                return s2.length();
            }
        } 
        
        if (s2 == null || s2 == "")
        {
            if (s1 == "" || s1 == null) {
                
                return 0;
            } else { 
                
                return s1.length();
            }
        } 
        
        if (s1.equalsIgnoreCase(s2)){ 
            
            return 0;
        }
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        int row = s1.length();
        int col = s2.length();
        int a[][] = new int[s1.length()+1][s2.length()+1];
        
        for (int i = 0;i <= col; i++) {
            
            a[0][i] = i;
        }
        
        for (int i = 0;i <= row; i++) {
            
            a[i][0] = i;
        }
     
            
        for (int i = 1;i <=row; i++) { 
                
                
            for (int j = 1; j <= col; j++) { 
                
                if (s1.charAt(i-1) == s2.charAt(j-1)) { 
                    
                    a[i][j] = a[i-1][j-1];
                } else { 
                    
                   a[i][j] = minimum(a[i-1][j-1] + 1,a[i-1][j] + 1,a[i][j-1] + 1);
                }
            }
       }
       
       /*for (int i = 0;i <=row; i++) { 
                
                
            for (int j = 0; j <= col; j++) { 
                
                System.out.print(a[i][j] + " ");
            }
            
            System.out.println();
        }*/
        
       return a[row][col];
                
    }
  }

    
