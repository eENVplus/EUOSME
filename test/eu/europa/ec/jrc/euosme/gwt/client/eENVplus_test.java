package eu.europa.ec.jrc.euosme.gwt.client;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class eENVplus_test extends GWTTestCase {

	public void testThesaurusCapabilities() {
		// Try to connect to GetCapabilities of Thesaurus
		
		/* since RPC calls are asynchronous, we will need to wait 
	       for a response after this test method returns. This line 
	       tells the test runner to wait up to 10 seconds 
	       before timing out. */
	    delayTestFinish(10000);

	      /* send a request to the server. */
	    RESTfulWebServiceProxyAsync ls = RESTfulWebServiceProxy.Util.getInstance();
		ls.invokeGetRESTfulWebService("repositories_env", "", LocaleInfo.getCurrentLocale().getLocaleName(), "", "virtuoso", 
	         new AsyncCallback<String>() {
	         public void onFailure(Throwable caught) {
	            /* The request resulted in an unexpected error. */
	            fail("Request failure: " + caught.getMessage());
	         }

	         public void onSuccess(String result) {
	            /* verify that the response is correct. */
	            assertTrue(result.startsWith("Hello, GWT User!"));

	            /* now that we have received a response, we need to 
	             tell the test runner that the test is complete. 
	             You must call finishTest() after an asynchronous test 
	             finishes successfully, or the test will time out.*/
	            finishTest();
	         }
	      });
		
	      //assertTrue(testObj.myError.isVisible());		
	}
	
	public void testThesaurusList() {
		// Try to connect to GetCapabilities of Thesaurus and check list
			
	}
	
	public void testThesaurusTopmostAll() {
		// Try to get at least one top most concept from thesaurus (All Thesauri)
		
	}
	
	public void testThesaurusTopmostEarth() {
		// Try to get at least one top most concept from Earth thesaurus
		
	}
	
	public void testAddKeyword() {
		// Try to add keyword from Earth thesaurus and check result
				
	}
	
	public void testCheckNarrower() {
		// Try to get a list of narrower from a keyword
		
	}
	
	public void testAddTwoKeywordFromSameThesaurus() {
		// Try to add two keyword from the same Thesaurus and check result
			
	}
	
	public void testAddTwoKeywordFromDifferentThesaurus() {
		// Try to add two keyword from different Thesaurus and check result
				
	}
	
	public void testInteroperabilityMandatory() {
		// Leave empty mandatory fields of interoperability and validate
		
	}
	
	public void testValidation() {
		// Compile mandatory fields and validate
			
	}
	
	public void testSaveinGN() {
		// Save a metadata into Geonetwork
				
	}
	
	public void openFromGN() {
		// Open a metadata saved into Geonetwork
			
	}
	
	@Override
	public String getModuleName() {
		return "eu.europa.ec.jrc.euosme.gwt.EUOSMEGWT";
	}

}
