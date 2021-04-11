import first.Class3;
import first.CustomException;
import second.Pizza;
import second.Food;
import second.Kebab;
import second.Sushi;
import second.Time;

import java.lang.reflect.*;
public class MainClass {

	public static void main(String[] args) {
		
		//Question1
		/*try {
			Class3 c3 = new Class3();
		} catch (CustomException e) {
			System.err.print(e);
		}*/
		
		
		//Question2
		System.out.println("Annotation Example");
		try {

			Food foodAnno = new Pizza().getClass().getAnnotation(Food.class);
			System.out.println("The price of this meal is: " + foodAnno.price());
			
			Method[] methods = new Pizza().getClass().getDeclaredMethods();
			for (Method method : methods) {
			    if (method.isAnnotationPresent(Time.class)) {
			        Time timeAnno = method.getAnnotation(Time.class);
			        System.out.println("Method: " + method.getName());
			        System.out.println("Time:" + timeAnno.takes());
			    }
			}
			
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

}
