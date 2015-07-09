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
 * Date: August 2014
 * Authors: Marzia Grasso, Angelo Quaglia, Massimo Craglia
LICENSE END***/

package eu.europa.ec.jrc.euosme.gwt.server;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eu.europa.ec.jrc.euosme.gwt.client.InitServiceProxy;

public class InitServiceProxyImpl extends RemoteServiceServlet implements InitServiceProxy {
	private static final long serialVersionUID = 1L;
	Map<String,String> settings = new LinkedHashMap<String, String>();

	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String metadataType = config.getInitParameter("metadataType");
        settings.put("metadataType",metadataType);
        String devMode = config.getInitParameter("devMode");
        settings.put("devMode",devMode);
        String appMode = config.getInitParameter("appMode");
        settings.put("appMode",appMode);
        String rpcCodeList = config.getInitParameter("rpcCodeList");
        settings.put("rpcCodeList",rpcCodeList);
        String apiMapstraction = config.getInitParameter("apiMapstraction");
        settings.put("apiMapstraction",apiMapstraction);
        String showAll = config.getInitParameter("showAll");
        settings.put("showAll",showAll);    
        String rpcRepository = config.getInitParameter("rpcRepository");
        settings.put("rpcRepository",rpcRepository);
        String showHeader = config.getInitParameter("showHeader");
        settings.put("showHeader",showHeader);
        String wmsEndpoint = config.getInitParameter("wmsEndpoint");
        settings.put("wmsEndpoint",wmsEndpoint);
        String euosmePassword = config.getInitParameter("euosmePassword");
        settings.put("euosmePassword",euosmePassword);
      }
    
    public InitServiceProxyImpl() { // must have
    }

    public Map<String,String> getInitService() {
		return settings;    	
    }   
}                