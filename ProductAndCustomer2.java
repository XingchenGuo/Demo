import java.util.concurrent.locks.*;

class Demo{
	public static void main(String[] args){
		Resource r = new Resource();
		
		Input in = new Input(r);
		Output out = new Output(r);
		
		new Thread(in).start();
		new Thread(out).start();
	}
}

class Resource{
	private String name;
	private int count = 1;
	
	private boolean flag = false;
	
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	
	public  void set(String name) throws Exception{
			
		lock.lock();
		try{
			while(flag){
				condition.await();
			}
			this.name = name + "----"+count ++;
			
			System.out.println(Thread.currentThread().getName()+"       "+this.name);
			flag = true;
			
			condition.signalAll();
		}finally{
			lock.unlock();
		}
		
	}
	
	public  void out() throws Exception{
		lock.lock();
		try{
			while(!flag){
				condition.await();
			}
				System.out.println(Thread.currentThread().getName()+"     "+this.name);
				
				flag = false;
				condition.signalAll();
		}finally{
			lock.unlock();
		}
	}
}

class Input implements Runnable{
	Resource r ;
	
	Input(Resource r){
		this.r = r;
	}
	
	public void run(){
		while(true){
			try{
				r.set("goods");
			}catch(Exception e){
				
			}
			
		}
	}
}
class Output implements Runnable{
	Resource r;
	
	Output(Resource r){
		this.r = r;
	}
	
	public void run(){
		while(true){
			try{
				r.out();
			}catch(Exception e){}
			
		}
	}
}