public class MatrixOp
{
   double determinant(double a[][],int n)
   {

    double b[][] = new double[n][n];
    double det = 1.0;
    int i;
    int j;
    int k;
    double temp = 1.0;

    for (i = 0;i < n; i++) { 

        for (j = 0;j < n;j++) { 

            b[i][j] = a[i][j];
        }
    } 

    for (i = 0;i < n-1;i++) { 

        for (j = i+1;j < n; j++) {  

            if (b[i][i] != 0.0) { 
            
                 temp = b[j][i]/b[i][i]; 
            }
               
            for (k = 0; k < n; k++) { 

                b[j][k] = (b[j][k] - b[i][k]*temp);
            }
        }
    } 

    for (i = 0;i < n;i++) { 

        for (j = 0;j < n;j++) { 

            if (i == j) { 


                det = det * b[i][j];
            } 

        //  printf("%f ",b[i][j]);
        } 

    //  printf("\n");
    } 

    return det;
} 

   public double[][] transpose(double a[][]) 
   { 
    int i;
    int j;
    //int k; 
    double b[][] = new double[a[0].length][a.length];

      for (i = 0;i < a.length;i++) { 

        for (j = 0; j < a[0].length; j++) { 

            b[j][i] = a[i][j];
        }
    } 
    
    return b;
} 

   public double[][] subtract(double a[][],double b[][])
   {
    int i;
    int j;
    double c[][] = new double[a.length][b[0].length];

    for (i = 0;i < a.length;i++) {

        for (j = 0;j < a[0].length;j++) { 

            c[i][j] = a[i][j]-b[i][j];
        }
    }
    
    return c;
} 

   double[][] multiply12(double a[][],double b[][])
   {
    int i;
    int j;
    int k;
    double res[][] = new double[1][3];
    double temp = 0.0;

    for (i = 0;i <1;i++) { 

        for (j = 0;j < 3;j++) { 

            for (k = 0;k < 3;k++) { 

                temp = temp + a[i][k]*b[k][j];

            }  
            
            res[i][j] = temp;
            temp = 0.0;
        }
    }
    
    return res;
} 

   double multiply23(double a[][],double b[][]) 
   { 

    int i;
    int j;
    int k;
    
    double temp = 0;

    for (i = 0;i < 1;i++) {

        for (j = 0;j < 1;j++) { 

            for (k = 0;k < 3; k++) {

                temp = temp + a[i][k]*b[k][j];
            }
        }
    }

    return temp;
}
 
 

    
    public static double[][] inverse(double[][]in){ 
        
		int st_vrs=in.length, st_stolp=in[0].length;
		double[][]out=new double[st_vrs][st_stolp];
		double[][]old=new double[st_vrs][st_stolp*2];
		double[][]new1 = new double[st_vrs][st_stolp*2];

		
		for (int v=0;v<st_vrs;v++){//ones vector
			for (int s=0;s<st_stolp*2;s++){
				if (s-v==st_vrs) 
					old[v][s]=1;
				if(s<st_stolp)
					old[v][s]=in[v][s];
			}
		}
		//zeros below the diagonal
		for (int v=0;v<st_vrs;v++){
			for (int v1=0;v1<st_vrs;v1++){
				for (int s=0;s<st_stolp*2;s++){
					if (v==v1)
						new1[v][s]=old[v][s]/old[v][v];
					else
						new1[v1][s]=old[v1][s];
				}
			}
			old=prepisi(new1);		
			for (int v1=v+1;v1<st_vrs;v1++){
				for (int s=0;s<st_stolp*2;s++){
					new1[v1][s]=old[v1][s]-old[v][s]*old[v1][v];
				}
			}
			old=prepisi(new1);
		}
		
		for (int s=st_stolp-1;s>0;s--){
			for (int v=s-1;v>=0;v--){
				for (int s1=0;s1<st_stolp*2;s1++){
					new1[v][s1]=old[v][s1]-old[s][s1]*old[v][s];
				}
			}
			old=prepisi(new1);
		}
		for (int v=0;v<st_vrs;v++){
			for (int s=st_stolp;s<st_stolp*2;s++){
				out[v][s-st_stolp]=new1[v][s];
			}
		}
		return out;
	}

	public static double[][] prepisi(double[][]in){ 
	    
		double[][]out=new double[in.length][in[0].length];
		for(int v=0;v<in.length;v++){
			for (int s=0;s<in[0].length;s++){
				out[v][s]=in[v][s];
			}
		}
		return out;
	}
}