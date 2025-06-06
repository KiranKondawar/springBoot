package dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//Singleton n lazy with id =soap
@Component("soap")
@Lazy(value=true)
public class SoapTransport implements Transport {
	public SoapTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
