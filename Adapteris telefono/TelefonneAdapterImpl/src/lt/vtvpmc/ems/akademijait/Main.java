package lt.vtvpmc.ems.akademijait;

import itaphones.phone.AutomaticDialer;

public class Main {

	public static void main(String[] args) {
		
		AutomaticDialer automaticDialer = new AutomaticDialer();
		AdapterFromAutomatikDilerToMobilePhone adapter = new AdapterFromAutomatikDilerToMobilePhone();
		
		String autoDailerAts = automaticDialer.dial(adapter);
		System.out.println(autoDailerAts);
}}
