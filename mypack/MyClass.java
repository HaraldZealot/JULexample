package mypack;

import java.util.logging.*;

public class MyClass
{
	private static Logger log = Logger.getLogger(MyClass.class.getName());
	private static java.util.Random rand = new java.util.Random();
        
	public void someMethod()
	{
            log.info("Some message");
            log.fine("Fine message");
            log.finer("Finer message");
            log.finest("Finest message");
	}  
	
	public int otherMethod(int x, double y)
	{
		log.entering(MyClass.class.getName(), "otherMethod", new Object[] {x,y});// variants:
		                                                                         // this.getClass().getEnclosingMethod().getName()
		                                                                         // or
		                                                                         // Thread.currentThread().getStackTrace()[2].getMethodName()
		                                                                         // don't work correct for me
		int result = x + (int) (y * y);
		log.exiting(MyClass.class.getName(), "otherMethod", result);
		return result;
	}
	
	private void dangerous() throws MyException
	{ 
		if(1 == rand.nextInt(3))
			throw new RuntimeException("PANIC!!!");
		MyException e = new MyException("vot blin goblin");
		log.throwing(MyClass.class.getName(), "exceptionDriver", e);
		throw e;
	}
	
	public void exceptionDriver()
	{
		try
		{
			dangerous();
		}
		catch(MyException e)
		{
			log.log(Level.INFO, "we run in exception: ", e);
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, "we catch unexpected exception: ", e);
		}
	}

}

class MyException extends Exception
{
	MyException(String message)
	{
		super(message);
	}
}

 
