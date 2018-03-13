class Demo{
	public static void main(String[] args){
		int[] a={45,19,78,46,23,4,1};
		
		for (int num : a){
			System.out.print(num+"  ");
		}
		
		System.out.println();
		for (int i = 0 ; i < a.length;i ++){//外层循环控制总次数
			for(int j = 0; j < a.length-1-i;j++){//内存循环将最大或最小的向外移动
				if (a[j] < a[j+1]){	//比较相邻的两个数的大小
					int temp = a[j];	//符合条件的则进行移动
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
