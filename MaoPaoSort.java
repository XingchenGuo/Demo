class Demo{
	public static void main(String[] args){
		int[] a={45,19,78,46,23,4,1};
		
		for (int num : a){
			System.out.print(num+"  ");
		}
		
		System.out.println();
		for (int i = 0 ; i < a.length;i ++){
			for(int j = 0; j < a.length-1-i;j++){
				if (a[j] < a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		for (int num : a){
			System.out.print(num+"  ");
		}
	}
}