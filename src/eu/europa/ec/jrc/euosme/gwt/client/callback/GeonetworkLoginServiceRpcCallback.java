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
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import eu.europa.ec.jrc.euosme.gwt.client.EUOSMEGWT;
import eu.europa.ec.jrc.euosme.gwt.client.RESTfulWebServiceProxy;
import eu.europa.ec.jrc.euosme.gwt.client.RESTfulWebServiceProxyAsync;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;

/**
 * Contains the implementation of the callback class from INSPIRE Web service
 * 
 * @version 1.0 - December 2010
 * @author 	Marzia Grasso 
 */
public class GeonetworkLoginServiceRpcCallback implements AsyncCallback <GeonetworkLoginServiceRpcCallback.returnType>, RequestCallback {
	/** Constants declaration */
	@SuppressWarnings("unused")
	private iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	String myXMLTree;
	String myFileName;
	
	public static class returnType implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private boolean ret;
		
		public boolean getResponse() {
			return ret;
		}
		public void setResponse(boolean ret) {
			this.ret = ret;	
		}
	}
	
	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.rpc.AsyncCallback#onSuccess(java.lang.Object)
	 */
	public void onSuccess(final returnType result) {
		Document.get().getBody().getStyle().setCursor(Style.Cursor.DEFAULT);		        
	    
		//if (1==1){
			//resourceDialog.hide();
			//lblMessage.setText("");
			Document.get().getBody().getStyle().setCursor(Style.Cursor.WAIT);		        
		    
			// call validation service via RPC
			AsyncCallback <GeonetworkServiceRpcCallback.returnType> callback = new GeonetworkServiceRpcCallback();
			RESTfulWebServiceProxyAsync ls = RESTfulWebServiceProxy.Util.getInstance();
			String url = EUOSMEGWT.getHref();
			ls.invokeHarvestService(url, myXMLTree, myFileName, LocaleInfo.getCurrentLocale().getLocaleName(), callback);
		
		//} else {
		//	lblMessage.setText(constants.wrongLogin());
		//}
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
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.http.client.RequestCallback#onResponseReceived(com.google.gwt.http.client.Request, com.google.gwt.http.client.Response)
	 */
	@Override
	public void onResponseReceived(Request request, Response response) {
		String ret = response.getText();
		Window.alert(ret);
	}		
	
	/**
	 * @param codeListName	{@link String} = the name of the code list
	 */
	public void setXMLTree(String XMLTree) {
		this.myXMLTree=XMLTree;		
	}
	
	/**
	 * @param codeListName	{@link String} = the name of the code list
	 */
	public void setFileName(String FileName) {
		this.myFileName=FileName;		
	}
}