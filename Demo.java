//关于死锁的程序

class DeadLock implements Runnable{		//声明类继承Runnable，主要实现多线程
	private boolean flag ;				//设置一个控制变量
	
	public DeadLock(boolean flag){		//在创建对象的时候
		this.flag = flag;
	}
	
	public void run(){			//可以多线程访问的代码
		if(flag){
			synchronized(MyLock.locka){
				System.out.println("if locka");
				synchronized(MyLock.lockb){
					System.out.println("if lockb");
				}
			}
		}else{
			synchronized(MyLock.lockb){
				System.out.println("else lockb");
				synchronized(MyLock.locka){
					System.out.println("if locka");
				}
			}
		}
	}
}

class MyLock {
	public static Object locka = new Object();			//A锁
	public static Object lockb = new Object();			//B锁
}

class Demo{
	public static void main(String[] args){
		DeadLock dl1 =new  DeadLock(true);
		DeadLock dl2 =new  DeadLock(false);
	
		new Thread(dl1).start();
		new Thread(dl2).start();
	}
}