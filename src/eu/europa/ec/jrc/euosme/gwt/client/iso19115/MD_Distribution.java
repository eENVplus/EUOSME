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
 * Create MD_Distribution model
 * Information about the distributor 
 * 
 * @version 1.0 - October 2014
 * @author 	Marzia Grasso
 */
public class MD_Distribution extends CI {
	
	/** Constants declaration */
	protected iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Messages declaration */
	protected iso19115Messages messages = GWT.create(iso19115Messages.class);
	
	/** distributorFormat control declaration */
	MD_Format distributorFormatObj = new MD_Format(constants.distributionFormat(), true, true, "");
	
	/** distributorContact control declaration */
	MD_Distributor distributorObj = new MD_Distributor(constants.distributor(), false, true, "");
	
	/** distributionOrderProcess control declaration */
	MD_StandardOrderProcess distributionOrderProcessObj = new MD_StandardOrderProcess(constants.distorOrdPrc(),false,true,"");
	
	/** distributorTransferOptions control declaration */
	MD_DigitalTransferOptions distributorTransferOptionsObj = new MD_DigitalTransferOptions(constants.distorTran(), false, true, "");
	
	/** 
     * constructor CI_ResponsibleParty model
     * 
     * @param label		{@link String} = the header
     * @param required	{@link Boolean} = if true, it is required
     * @param multiple	{@link Boolean} = if true, it could be added more than ones
     * @param help		{@link String} = the anchor in the help 
     * 
     * @return	the widget composed by CI_ResponsibleParty fields
     */
	public MD_Distribution(String label, boolean required, boolean multiple, String help) {
		super(label, required, multiple, help, CIOrientations.VERTICAL);	
		fieldsGroup.add(distributorFormatObj);		
		fieldsGroup.add(distributorObj);
		fieldsGroup.add(distributionOrderProcessObj);		
		fieldsGroup.add(distributorTransferOptionsObj);
		
		setInterface(-1);
	}
	
	@Override
	public void myCheck() {
		distributorFormatObj.myCheck();		
		distributorObj.myCheck();
		distributionOrderProcessObj.myCheck();		
		distributorTransferOptionsObj.myCheck();
		myError.setVisible(false);
	}
	
	@Override
	public void setFormName(String name) {
		super.setFormName(name);
		distributorFormatObj.setFormName(name + ".distributionformat[1].md_format[1]");
		distributorObj.setFormName(name + ".distributorcontact[1]");
		distributionOrderProcessObj.setFormName(name + ".distributionorderprocess[1].md_standardorderprocess[1]");
		distributorTransferOptionsObj.setFormName(name + ".distributortransferoptions[1].md_digitaltransferoptions[1]");
		myError.getElement().setId("error-" + name);
	}
	
	@Override
	public void setInterface(int i) {
		distributorObj.setVisible(false);
		distributionOrderProcessObj.setVisible(false);
		distributorTransferOptionsObj.setVisible(false);
	}
}