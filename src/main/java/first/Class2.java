package first;

public class Class2 {

	public boolean method2() throws CustomException {
		Class1 c1 = new Class1();
		if(c1.findValue("000000")) {
			return true;
		}
		return false;
		
	}
}
