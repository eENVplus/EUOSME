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
 * Date: 16 August 2014
 * Authors: Marzia Grasso, Angelo Quaglia, Massimo Craglia
LICENSE END***/

package eu.europa.ec.jrc.euosme.gwt.server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.Logger;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = -4356636877078339046L;
	private static Logger _log = Logger.getLogger(UploadServlet.class);

	byte[] bbuf = new byte[1024];

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
	    try {	    	
	    	System.out.println(request.getReader().readLine());
		}
		catch (Exception e) {
			//e.printStackTrace();
			_log.error(" error " + e.getMessage());
		}		
	}	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
		doPost(request, response);
	}
}