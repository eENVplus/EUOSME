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
import eu.europa.ec.jrc.euosme.gwt.client.widgets.DateImpl;

/**
 * Create MD_StandardOrderProcess model
 * Common ways in which the resource may be obtained or received, and related instructions and fee information.
 * 
 * @version 1.0 - October 2014
 * @author 	Marzia Grasso
 */
public class MD_StandardOrderProcess extends CI {

	/** Constants declaration */
	protected iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Messages declaration */
	protected iso19115Messages messages = GWT.create(iso19115Messages.class);
	
	/** fees control declaration */
	CharacterString feesObj = new CharacterString(constants.resFees(), "", false, CheckFunctions.normal, true);
	
	/** plannedAvailableDateTime control declaration */
	DateImpl plannedAvailableDateTimeObj = new DateImpl(constants.planAvDtTm(), "", false);
	
	/** orderingInstructions control declaration */
	CharacterString orderingInstructionsObj = new CharacterString(constants.ordInstr(), "", false, CheckFunctions.normal, true);
	
	/** turnaround control declaration */
	CharacterString turnaroundObj = new CharacterString(constants.ordTurn(), "", false, CheckFunctions.normal, true);
	
	/** 
	 * constructor MD_StandardOrderProcess model
	 * 
	 * @param label		{@link String} = the header
     * @param required	{@link Boolean} = if true, it is required
     * @param multiple	{@link Boolean} = if true, it could be added more than ones
     * @param help		{@link String} = the anchor in the help 
     * 
	 * @return	the widget composed by CI_OnlineResource fields
	 */
	public MD_StandardOrderProcess(String label, boolean required, boolean multiple, String help) {
		super(label, required, multiple, help, CIOrientations.VERTICAL);	
		fieldsGroup.add(feesObj);
		fieldsGroup.add(plannedAvailableDateTimeObj);
		fieldsGroup.add(orderingInstructionsObj);
		fieldsGroup.add(turnaroundObj);
		setInterface(-1);
	}
	
	@Override
	public void myCheck() {
		super.myCheck();
		if (this.getParent().isVisible()) {
			feesObj.myCheck();
			plannedAvailableDateTimeObj.myCheck();
			orderingInstructionsObj.myCheck();
			turnaroundObj.myCheck();	
		}
	}

	@Override
	public void setFormName(String name) {
		super.setFormName(name);
		feesObj.setFormName(name + ".fees[1].characterstring[1]");
		plannedAvailableDateTimeObj.setFormName(name + ".plannedavailabledatetime[1].date[1]");
		orderingInstructionsObj.setFormName(name + ".orderinginstructions[1].characterstring[1]");
		turnaroundObj.setFormName(name + ".turnaround[1].characterstring[1]");	
	}
}