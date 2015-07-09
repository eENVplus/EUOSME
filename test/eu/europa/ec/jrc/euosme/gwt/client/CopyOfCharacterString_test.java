package eu.europa.ec.jrc.euosme.gwt.client;

import com.google.gwt.junit.client.GWTTestCase;

import eu.europa.ec.jrc.euosme.gwt.client.widgets.CharacterString;

public class CopyOfCharacterString_test extends GWTTestCase {

	public void testEmptyRequiredNormal() {
		// Type empty string, check required and of type normal -> WARNING
		CharacterString testObj = new CharacterString("CI_OnlineResource","CI_OnlineResource",true, CheckFunctions.normal, true);
		testObj.myCheck();
		assertTrue(testObj.myError.isVisible());		
	}
	
	@Override
	public String getModuleName() {
		return "eu.europa.ec.jrc.euosme.gwt.EUOSMEGWT";
	}

}
