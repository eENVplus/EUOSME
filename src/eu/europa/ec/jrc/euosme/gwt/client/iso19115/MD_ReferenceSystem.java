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
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Messages;
import eu.europa.ec.jrc.euosme.gwt.client.widgets.CI;

/**
 * Create MD_ReferenceSystem model
 * Reference system information
 * 
 * @version 1.0 - October 2014
 * @author 	Marzia Grasso
 */
public class MD_ReferenceSystem extends CI {
	
	/** Constants declaration */
 	protected iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Messages declaration */
 	protected iso19115Messages messages = GWT.create(iso19115Messages.class);
	
	/** referenceSystemIdentifierObj control declaration */
	public RS_Identifier referenceSystemIdentifierObj = new RS_Identifier(constants.referenceSystem(),false,true,"");
	
	/** 
     * constructor MD_ReferenceSystem model
     * 
     * @param label		{@link String} = the header
     * @param required	{@link Boolean} = if true, it is required
     * @param multiple	{@link Boolean} = if true, it could be added more than ones
     * @param help		{@link String} = the anchor in the help 
     * 
     * @return	the widget composed by MD_Resolution fields
     */
	public MD_ReferenceSystem(String label, boolean required, boolean multiple, String help) {
		super(label, required, multiple, help, CIOrientations.VERTICAL);	
		fieldsGroup.add(referenceSystemIdentifierObj);		
	}
	
	@Override
	public void myCheck() {
		if (this.getParent().isVisible()) {
			referenceSystemIdentifierObj.myCheck();
			myError.setVisible(false);
		}
	}

	@Override
	public void setFormName(String name) {
		super.setFormName(name);
		referenceSystemIdentifierObj.setFormName(name + ".referencesystemidentifier[1].rs_identifier[1]");		
		myError.getElement().setId("error-" + name);
	}
}