package dependency;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//prototype,auto derived/assignend id by SC:HttpTransport
@Component()
@Scope("prototype")
public class HttpTransport implements Transport {
	public HttpTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
