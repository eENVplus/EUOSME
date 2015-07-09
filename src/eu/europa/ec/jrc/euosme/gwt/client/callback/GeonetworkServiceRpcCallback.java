/***LICENSE START
 * Copyright 2011 EUROPEAN UNION
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * 
 * Date: 03 January 2011
 * Authors: Marzia Grasso, Angelo Quaglia, Massimo Craglia
LICENSE END***/

package eu.europa.ec.jrc.euosme.gwt.client.callback;

import java.io.Serializable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;

import eu.europa.ec.jrc.euosme.gwt.client.EUOSMEGWT;
import eu.europa.ec.jrc.euosme.gwt.client.Utilities;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;

/**
 * Contains the implementation of the callback class from INSPIRE Web service
 * 
 * @version 1.0 - December 2010
 * @author 	Marzia Grasso 
 */
public class GeonetworkServiceRpcCallback implements AsyncCallback <GeonetworkServiceRpcCallback.returnType>, RequestCallback {
	/** Constants declaration */
	private iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	public static class returnType implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String url;
		private String text;
		private String ret;
		
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUrl() {
			return url;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getText() {
			return text;
		}
		public String getResponse() {
			return ret;
		}
		public void setResponse(String ret) {
			this.ret = ret;	
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.rpc.AsyncCallback#onSuccess(java.lang.Object)
	 */
	public void onSuccess(final returnType result) {
		Document.get().getBody().getStyle().setCursor(Style.Cursor.DEFAULT);		        
	    
		if (result == null)
    		return;
    	String url = result.getUrl();
    	String ret = result.getResponse();
    	if (url != null && ret != null){
    		String myFileInterface = Utilities.foundInterface(ret);
        	if (myFileInterface.isEmpty()) 
        		Window.alert(constants.unableToLoadFilemd_scopecode());
        	else {
        		if (!ret.contains("xmlns:gmd=\"http://www.isotc211.org/2005/gmd\"")) 
        			Window.alert(constants.errorSchema());
	        	else {
	        		// Check if uuid is into the file
	        		try {
	    	    		com.google.gwt.xml.client.Document uuidDocument = XMLParser.parse(ret);
	    	    		String uuid = "";    
	    	    		for (int ii = 0; ii < uuidDocument.getElementsByTagName("fileIdentifier").item(0).getChildNodes().getLength(); ii++) {
	        	        	Node currentNode = uuidDocument.getElementsByTagName("fileIdentifier").item(0).getChildNodes().item(ii);        	
	        	        	if (currentNode.getNodeName().toLowerCase().endsWith("characterstring")) {
	        	        		for (int kk = 0; kk < currentNode.getChildNodes().getLength(); kk++) {
	        	        			Node currentNodeUUID = currentNode.getChildNodes().item(kk);  
	        	        			uuid = currentNodeUUID.getNodeValue();
	        	        		}
	        	        	}	        	        			
	        	        }		
	    	    		if (uuid.length() > 0) 
	    	    			EUOSMEGWT.mainPanel.newForm(myFileInterface,ret);
	    	    		else
	    	    			Window.alert(constants.gnServiceUuid());	    	    		
	    	    	}
	    	    	catch (Exception ex) {
	    	    		Window.alert(constants.gnServiceFailed() + " " + ex.getMessage());
	    	    	}
	        		
	        	}
        	}
    	}
        else if (url!= null){
    		Window.alert(result.getText());
    	}
    	EUOSMEGWT.mainPanel.loadingPanel.hide();
    }

    /* (non-Javadoc)
     * @see com.google.gwt.user.client.rpc.AsyncCallback#onFailure(java.lang.Throwable)
     */
    public void onFailure(Throwable caught) {
    	Document.get().getBody().getStyle().setCursor(Style.Cursor.DEFAULT);		        
	    
    	if (EUOSMEGWT.gnserviceAvailable) {
    		EUOSMEGWT.gnserviceAvailable=false;
    		iso19115Constants constants = GWT.create(iso19115Constants.class);
    		String msg=caught.getMessage();
    		if (msg != null)
    			Window.alert(constants.gnServiceFailed() + " " + msg);
    	}	
    }

	/* (non-Javadoc)
	 * @see com.google.gwt.http.client.RequestCallback#onError(com.google.gwt.http.client.Request, java.lang.Throwable)
	 */
	@Override
	public void onError(Request request, Throwable exception) {
		String msg=exception.getMessage();
		if (msg != null)
			Window.alert(constants.gnServiceFailed() + " " + msg);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.http.client.RequestCallback#onResponseReceived(com.google.gwt.http.client.Request, com.google.gwt.http.client.Response)
	 */
	@Override
	public void onResponseReceived(Request request, Response response) {
		String ret = response.getText();
		Window.alert(ret);
	}		
}