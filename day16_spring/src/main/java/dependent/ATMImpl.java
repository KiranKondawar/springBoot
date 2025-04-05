package dependent;


import dependency.HttpTransport;
import dependency.Transport;

public class ATMImpl implements ATM {
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

	
	// Custom INIT method
	//beacuse we dont have any intrusive framework here
	//meaning your bean class not extending or tightly coupled with spring API
	//SO USE CUSTOM INIT METHOD
	public void anyInit()//name cany be ANY and THROWS EXCEPTION allowed
	//
	{
		System.out.println("in init"+myTransport);
	}
	// Custom Destroy method
	public void anyDestroy()//name cany be ANY and THROWS EXCEPTION allowed
	//
	{
		System.out.println("in Destroy"+myTransport);
		
	}
	
	
}
