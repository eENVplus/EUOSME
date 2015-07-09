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
 * Create MD_DigitalTransferOptions model
 * Technical means and media by which a resource is obtained from the distributor.
 * 
 * @version 1.0 - October 2014
 * @author 	Marzia Grasso
 */
public class MD_DigitalTransferOptions extends CI {

	/** Constants declaration */
	protected iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Messages declaration */
	protected iso19115Messages messages = GWT.create(iso19115Messages.class);
	
	/** unitsOfDistribution control declaration */
	CharacterString unitsOfDistributionObj = new CharacterString(constants.unitsODist(), "", false, CheckFunctions.normal, true);
	
	/** transferSize control declaration */
	CharacterString transferSizeObj = new CharacterString(constants.transSize(), "", false, CheckFunctions.integer, true);
	
	/** onLine control declaration */
	CI_OnlineResource onLineObj = new CI_OnlineResource(constants.onLineSrc(), false, true, "");
	
	/** offLine control declaration */
	MD_Medium offLineObj = new MD_Medium (constants.offLineMed(), false, false, "");
	
	/** 
	 * constructor MD_DigitalTransferOptions model
	 * 
	 * @param label		{@link String} = the header
     * @param required	{@link Boolean} = if true, it is required
     * @param multiple	{@link Boolean} = if true, it could be added more than ones
     * @param help		{@link String} = the anchor in the help 
     * 
	 * @return	the widget composed by CI_OnlineResource fields
	 */
	public MD_DigitalTransferOptions(String label, boolean required, boolean multiple, String help) {
		super(label, required, multiple, help, CIOrientations.VERTICAL);	
		fieldsGroup.add(unitsOfDistributionObj);
		fieldsGroup.add(transferSizeObj);
		fieldsGroup.add(onLineObj);
		fieldsGroup.add(offLineObj);
		setInterface(-1);
	}
	
	@Override
	public void myCheck() {
		super.myCheck();
		if (this.getParent().isVisible()) {
			unitsOfDistributionObj.myCheck();
			transferSizeObj.myCheck();
			onLineObj.myCheck();
			offLineObj.myCheck();		
		}
	}

	@Override
	public void setFormName(String name) {
		super.setFormName(name);
		unitsOfDistributionObj.setFormName(name + ".unitsofdistribution[1].characterstring[1]");
		transferSizeObj.setFormName(name + ".transfersize[1].characterstring[1]");
		onLineObj.setFormName(name + ".online[1].ci_onlineresource[1]");
		offLineObj.setFormName(name + ".offline[1].md_medium[1]");
	}
}