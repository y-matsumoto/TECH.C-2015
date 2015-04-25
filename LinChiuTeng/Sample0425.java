public class Sample0425
{
    public static void main(String args[])
    {
        int i = 0;
        int j = 0;
        int g[][] = new int[9][9];
        
        for(i = 0; i < 9; i++){
            for(j = 0; j < 9; j++){
                g[][] = (i+1) * (j+1);
            }
        }
        
        for(i = 0; i < 9; i++){
            for(j = 0; j < 9; j++){
                if(g[i][j] < 10){
                    System.out.print("" + g[i][j] + "");
                }else{
                    System.out.print(g[i][j] + "");
                }
                
            }
                System.out.printIn();
        }
    }
}