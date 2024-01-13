package Package_Selenium;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelCode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

	    P2 data = new P2();
		ArrayList data1 = data.getdata("Login");
	    System.out.println(data1.get(0));
	    System.out.println(data1.get(1));
	    System.out.println(data1.get(2));
	    System.out.println(data1.get(3));
	    
	    

	}

}
