package testcases;

import java.io.FileNotFoundException;

import appModules.Homepage;
import utilities.DriverSetup;

public class test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
DriverSetup.Initiate(1);
Homepage.execution();
DriverSetup.Kill();
	}

}
