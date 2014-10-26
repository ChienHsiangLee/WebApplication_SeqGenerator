import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.com.gss.spring.sequence.SequenceGenerator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("Sequence-Beans.xml");
			
			SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
			
			System.out.println(generator.getSequence());
			System.out.println(generator.getSequence());
			System.out.println(generator.getSequence());
		} catch (BeanInitializationException e) {
			// TODO Auto-generated catch block
			System.out.println("error:"+e.toString());
		}

	}

}
