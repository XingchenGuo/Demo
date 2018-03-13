class Demo{
	public static void main(String[] args){
		int[] a = {100,43,12,15,165,161,123,12321,1};
		
		for(int num : a){
			System.out.print(num+"   ");
		}
		
		System.out.println();
		
		getSort(a);
		
		System.out.println("Sort End");
		for(int num : a){
			System.out.print(num+"   ");
		}
	}
	
	private static void getSort(int[] a){
		if(a.length != 0){
			quickSort(a,0,a.length-1);
		}
	} 
	
	private static void quickSort(int[] a,int low,int high){
		if(low < high){
			int middle = getMiddle(a,low,high);
			quickSort(a,0,middle-1);
			quickSort(a,middle+1,high);
		}
	}
	
	private static int getMiddle(int[] a,int low,int high){
		int temp = a[low];
		
		while(low < high){
			while(low<high && a[high] >= temp){
				high --;
			}
			a[low] = a[high];
			
			while(low < high && a[low] <= temp){
				low ++;
			} 
			a[high] = a[low];
		}
		a[low] = temp;
		
		return low;
	}
} 