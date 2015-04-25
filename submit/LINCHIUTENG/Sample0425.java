public class Sample0425
{
    public static void main(String args[])
    {
        int m[][] = new m[9][9];
        int i = 0;
        int j = 0;
        
        for(i < 9; i++){
            for(j < 9; j++){
                m[i][j] = (i+1) * (j+1);
            }
        }
        
        for(i = 0; i < 9; i++){
            for(j = 0; j < 9; j++){
                if(m[i][j] < 10){
                    System.out.print("" + m[i][j] + "");
                }else{
                          System.out.print(m[i][j] + "");
                }
            }
        }
              System.out.println();
    }
}