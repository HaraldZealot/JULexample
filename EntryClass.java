import java.util.logging.*;
import java.io.*;
import mypack.*;

public class EntryClass{
	
	public static void main(String[] args){
		try {
            LogManager.getLogManager().readConfiguration(
                    EntryClass.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        
        MyClass object = new MyClass();
        object.someMethod();
        object.otherMethod(5,3.7);
        object.exceptionDriver();
	}
}
