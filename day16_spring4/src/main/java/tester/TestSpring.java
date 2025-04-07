package tester;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import dependent.ATM;
import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
	//start / bootstrap  using XML based meta instruction placed in runtime class
		// path
		try(AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class))
		{
			System.out.println("SC up n RUNNING.......");
			//get ready to use : atm bean from SC
			//o.s.b.fbeanfactory:method<T> T getBean(String beanId,Class<T>
			//beancls) throws BeansEx
			ATMImpl atm1=ctx.getBean("my_atm",ATMImpl.class);//1st demand
			//B.L
			atm1.deposit(1000);
			ATMImpl atm2=ctx.getBean("my_atm",ATMImpl.class);//2nd demand
System.out.println(atm1==atm2);//true beacause of "SINGLETON" 
		}//ctx Close()=>Shutting SC--> Checks for Singleton beans-- destroy --
		//spring beans marked for GC
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
