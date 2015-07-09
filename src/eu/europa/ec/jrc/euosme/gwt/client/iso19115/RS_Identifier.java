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

package eu.europa.ec.jrc.euosme.gwt.client.iso19115;

import com.google.gwt.core.client.GWT;

import eu.europa.ec.jrc.euosme.gwt.client.CIOrientations;
import eu.europa.ec.jrc.euosme.gwt.client.CheckFunctions;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Messages;
import eu.europa.ec.jrc.euosme.gwt.client.widgets.CI;
import eu.europa.ec.jrc.euosme.gwt.client.widgets.CharacterString;

/**
 * Create RS_Identifier model
 * identifier used for reference systems 
 * 
 * @version 1.0.0 - October 2014
 * @author 	Marzia Grasso
 */

public class RS_Identifier extends CI {
	
	/** Constants declaration */
 	protected iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Messages declaration */
 	protected iso19115Messages messages = GWT.create(iso19115Messages.class);
	
 	/** code control declaration */
	public CharacterString codeObj = new CharacterString(constants.code(), "", true, CheckFunctions.normal, true);
	
	/** codeSpace control declaration */
	CharacterString codeSpaceObj = new CharacterString(constants.identCodeSpace(),"", false, CheckFunctions.normal, true);
	
	/** version control declaration */
	CharacterString versionObj = new CharacterString(constants.identVrsn(), "", false, CheckFunctions.normal, true);
	
	/** 
     * constructor RS_Identifier model 
     * 
     * @param label		{@link String} = the header
     * @param required	{@link Boolean} = if true, it is required
     * @param multiple	{@link Boolean} = if true, it could be added more than ones
     * @param help		{@link String} = the anchor in the help 
     * 
     * @return	the widget composed by CI_Address fields
     */
	public RS_Identifier(String label, boolean required, boolean multiple, String help) {
		super(label, required, multiple, help, CIOrientations.VERTICAL);
		fieldsGroup.add(codeObj);
		fieldsGroup.add(codeSpaceObj);
		fieldsGroup.add(versionObj);	
	}
	
	@Override
	public void myCheck() {
		if (this.getParent().isVisible()) {
			codeObj.myCheck();
			codeSpaceObj.myCheck();
			versionObj.myCheck();			
		}
	}
	
	@Override
	public void setFormName(String name) {
		super.setFormName(name);
		codeObj.setFormName(name + ".code[1].characterstring[1]");		
		codeSpaceObj.setFormName(name + ".codespace[1].characterstring[1]");		
		versionObj.setFormName(name + ".version[1].characterstring[1]");
	}	
}