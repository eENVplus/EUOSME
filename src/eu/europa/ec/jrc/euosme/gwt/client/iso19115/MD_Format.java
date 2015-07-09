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
 * Create MD_Format model
 * Description of the computer language construct that specifies the representation of data objects in a record, file, message, storage device or transmission channel 
 * 
 * @version 1.0 - October 2014
 * @author 	Marzia Grasso
 */

public class MD_Format extends CI {
	
	/** Constants declaration */
 	protected iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Messages declaration */
 	protected iso19115Messages messages = GWT.create(iso19115Messages.class);
	
	/** name control declaration */
	CharacterString nameObj = new CharacterString(constants.formatName(), "", true, CheckFunctions.normal, true);
	
	/** version control declaration */
	CharacterString versionObj = new CharacterString(constants.formatVer(), "", true, CheckFunctions.normal, true);
	
	/** amendmentNumber control declaration */
	CharacterString amendmentNumberObj = new CharacterString(constants.formatAmdNum(), "", false, CheckFunctions.normal, true);
	
	/** specification control declaration */
	CharacterString specificationObj = new CharacterString(constants.formatSpec(), "", false, CheckFunctions.normal, true);
	
	/** fileDecompressionTechnique control declaration */
	CharacterString fileDecompressionTechniqueObj = new CharacterString(constants.fileDecmTech(), "", false, CheckFunctions.normal, true);
	
	/** 
     * constructor CI_Address model 
     * 
     * @param label		{@link String} = the header
     * @param required	{@link Boolean} = if true, it is required
     * @param multiple	{@link Boolean} = if true, it could be added more than ones
     * @param help		{@link String} = the anchor in the help 
     * 
     * @return	the widget composed by CI_Address fields
     */
	public MD_Format(String label, boolean required, boolean multiple, String help) {
		super(label, required, multiple, help, CIOrientations.VERTICAL);
		fieldsGroup.add(nameObj);
		fieldsGroup.add(versionObj);
		fieldsGroup.add(amendmentNumberObj);
		fieldsGroup.add(specificationObj);
		fieldsGroup.add(fileDecompressionTechniqueObj);	
	}
	
	@Override
	public void myCheck() {
		if (this.getParent().isVisible()) {
			nameObj.myCheck();
			versionObj.myCheck();
			amendmentNumberObj.myCheck();
			specificationObj.myCheck();
			fileDecompressionTechniqueObj.myCheck();					
		}
	}
	
	@Override
	public void setFormName(String name) {
		super.setFormName(name);
		nameObj.setFormName(name + ".name[1].characterstring[1]");		
		versionObj.setFormName(name + ".version[1].characterstring[1]");
		amendmentNumberObj.setFormName(name + ".amendmentnumber[1].characterstring[1]");
		specificationObj.setFormName(name + ".specification[1].characterstring[1]");
		fileDecompressionTechniqueObj.setFormName(name + ".filedecompressiontechnique[1].characterstring[1]");
	}	
}