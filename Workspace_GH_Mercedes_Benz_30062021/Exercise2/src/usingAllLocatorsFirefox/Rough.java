package usingAllLocatorsFirefox;

import java.util.Date;

public class Rough {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d);
		String newDateformat = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(newDateformat);
	}

}
