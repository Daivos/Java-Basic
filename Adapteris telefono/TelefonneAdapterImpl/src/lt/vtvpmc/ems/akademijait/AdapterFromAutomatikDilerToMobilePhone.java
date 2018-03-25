package lt.vtvpmc.ems.akademijait;

import itaphones.phone.MobilePhone;
import itaphones.phone.Phone;

public class AdapterFromAutomatikDilerToMobilePhone implements Phone {
	String response;
	MobilePhone mobilePhone = new MobilePhone();
	
	@Override
	public void dial(String phoneNumber) {
	
	response=mobilePhone.dial(phoneNumber);
		}

	@Override
	public String getReponse() {
		// TODO Auto-generated method stub
		return response;
	}

}

/*
MOBILE PHONE
public java.lang.String dial(java.lang.String number)
Parameters:
    number - phone number
Returns:
    response 
    
 Automatic Diler   
    public static java.lang.String dial(Phone phone)
    Dials the correct number and returns a response
    Parameters:
        phone - the phone to use
    Returns:
        response 

*/