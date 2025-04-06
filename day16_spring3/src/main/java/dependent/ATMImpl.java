package dependent;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.HttpTransport;
import dependency.Transport;
//Singleton and eager, id=my_atm
@Component("my_atm")
public class ATMImpl implements ATM {
	@Autowired//(required = false)//autowire=byType
	@Qualifier("httpTransport")//autowire =byName
	private Transport myTransport;//=new HttpTransport();
	public ATMImpl() {
		System.out.println("in cnstr of " +getClass().getName()+" "+myTransport);
	}
//Setter based dependacy Injection
	public void setMyTransport(Transport myTransport) {
		System.out.println("in setter "+ myTransport);
		this.myTransport = myTransport;
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing "+amt);
		byte[] data=("depositing "+amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing "+amt);
		byte[] data=("withdrawing "+amt).getBytes();
		myTransport.informBank(data);
	}

	//Custom INIT Method
	@PostConstruct
	public void anyInit()//name cany be ANY and THROWS EXCEPTION allowed
	//
	{
		System.out.println("in init"+myTransport);
	}
	//Custom Destroy Method
	@PreDestroy
	public void anyDestroy()//name cany be ANY and THROWS EXCEPTION allowed
	//
	{
		System.out.println("in Destroy"+myTransport);
		
	}
	
	
}
