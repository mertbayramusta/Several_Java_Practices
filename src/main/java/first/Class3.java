package first;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.FileHandler;
public class Class3 {

	public Class3() throws CustomException{
		Logger logger = LoggerFactory.getLogger(Class3.class);
		Class2 c2 = new Class2();
		if(c2.method2()) {
			System.out.println("\n");
		}else {
			logger.info("An exception occurred!", new CustomException("Something went wrong, you've got an exception!"));
		}
	}
}
