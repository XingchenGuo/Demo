class DeadLock implements Runnable{
	private boolean flag = true;
	
	public DeadLock(boolean flag){
		this.flag = flag;
	}
	
	public void run(){
		if(flag){
			synchronized(MyLock.Locka){
					System.out.println("if Locka");
				synchronized(MyLock.Lockb){
						System.out.println("if Lockb");
				}
			}
		}else{
			synchronized(MyLock.Lockb){
					System.out.println("else Lockb");
				synchronized(MyLock.Locka){
						System.out.println("else Locka");
					
				}
			}
		}		
	}
}


class MyLock{
	public static Object Locka = new Object();
	public static Object Lockb = new Object();
}

class Demo{
	public static void main(String[] args){
		DeadLock dl1 = new DeadLock(true);
		DeadLock dl2 = new DeadLock(false);
		
		new Thread(dl1).start();
		new Thread(dl2).start();
	}
}