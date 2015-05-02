class java0415{
	public static void main(String[] args){
		// 九九表を画面に表示しなさい
		int row = 9;
		int col = 9;
		
		for(int i=1;i<=row;i++){
			for(int j=1;j<=col;j++){
				System.out.print(String.format(" %1$02d",i*j));
			}
			System.out.println("");
		}
		
	}
}

