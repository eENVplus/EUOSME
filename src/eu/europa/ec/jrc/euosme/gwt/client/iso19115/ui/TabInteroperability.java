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

package eu.europa.ec.jrc.euosme.gwt.client.iso19115.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import eu.europa.ec.jrc.euosme.gwt.client.DataTypes;
import eu.europa.ec.jrc.euosme.gwt.client.EUOSMEGWT;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;
import eu.europa.ec.jrc.euosme.gwt.client.iso19115.MD_Distribution;
import eu.europa.ec.jrc.euosme.gwt.client.iso19115.MD_ReferenceSystem;
import eu.europa.ec.jrc.euosme.gwt.client.widgets.CIMultiple;
import eu.europa.ec.jrc.euosme.gwt.client.widgets.CodeList;


/**
 * Create the tab Quality
 * 
 * @version 1.0 - October 2014
 * @author 	Marzia Grasso
 */
public class TabInteroperability extends Composite {
	
	private static TabInteroperabilityUiBinder uiBinder = GWT.create(TabInteroperabilityUiBinder.class);
	interface TabInteroperabilityUiBinder extends UiBinder<Widget, TabInteroperability> {	}
	
	/** Constants declaration */
	private iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** title of the tab */
	@UiField(provided = true)
	Label titleLabel = new Label(constants.interoperabilityTitle());
	
	/** summary of the tab */
	@UiField(provided = true)
	HTML summaryHTML = new HTML(constants.interoperabilitySummary());
	
	/** coordinateReferenceSystemInfo control declaration */
	MD_ReferenceSystem coordinateReferenceSystemInfoObj = new MD_ReferenceSystem(constants.coordinateReferenceSystemInfo(), true, true, "");
	@UiField(provided = true)
	CIMultiple coordinateReferenceSystemInfoContainerObj = new CIMultiple(constants.coordinateReferenceSystemInfo(), coordinateReferenceSystemInfoObj, true, "");

	/** coordinateReferenceSystemInfo control declaration */
	MD_ReferenceSystem temporalReferenceSystemInfoObj = new MD_ReferenceSystem(constants.temporalReferenceSystemInfo(), false, true, "");
	@UiField(provided = true)
	CIMultiple temporalReferenceSystemInfoContainerObj = new CIMultiple(constants.temporalReferenceSystemInfo(), temporalReferenceSystemInfoObj, false, "");

	/** encoding control declaration */
	@UiField(provided = true)
	MD_Distribution distributionObj = new MD_Distribution(constants.distribution(), true, false, "");
	
	/** characterset control declaration */
	@UiField(provided = true)
	CodeList characterSetObj =	new CodeList(constants.characterset(),"",true,"17","",true);
	
	/** characterset control declaration */
	@UiField(provided = true)
	CodeList spatialRepresentationTypeObj = new CodeList(constants.spatialRepresentationType(),"",true,"18","",true);
	
	/** Note on mandatory fields */
	@UiField(provided = true)
	Label mandatoryFieldLabel = new Label("(*) " + constants.mandatoryField());
	
	/** 
    * constructor TabQuality
    * 
    * @return	the widget composed by the Quality Tab
    */
	public TabInteroperability() {
		// initialize widget
		initWidget(uiBinder.createAndBindUi(this));
		// set style
		titleLabel.removeStyleName("gwt-Label");
		// set form names
		setFormName();
		// set interface
		setInterface();
	}

	/**
	 * This is called to make a client (first) check of the contained fields
	 */
	public void myCheck() {
		coordinateReferenceSystemInfoObj.myCheck();
		temporalReferenceSystemInfoObj.myCheck();
		distributionObj.myCheck();
		characterSetObj.myCheck();
		spatialRepresentationTypeObj.myCheck();
	}
	
	/**
	 * Set the IDs of the contained objects 
	 */
	public void setFormName() {
		coordinateReferenceSystemInfoObj.setFormName("md_metadata[1].referencesysteminfo[1].md_referencesystem[1]");
		temporalReferenceSystemInfoObj.setFormName("md_metadata[1].referencesysteminfo[2].md_referencesystem[1]");
		distributionObj.setFormName("md_metadata[1].distributioninfo[1].md_distribution[1]");
		characterSetObj.setFormName("md_metadata[1].characterset[1].md_charactersetcode[1]");
		spatialRepresentationTypeObj.setFormName("md_metadata[1].identificationinfo[1]." + MainPanel.identificationInfoSubType + "[1].spatialrepresentationtype[1].md_spatialrepresentationtypecode[1]");
	}
	
	/**
	 * Show or hide elements according to the selected {@link AppModes}
	 */
	public void setInterface() {
		temporalReferenceSystemInfoObj.referenceSystemIdentifierObj.codeObj.isRequired=false;
		if (EUOSMEGWT.metadataType.equalsIgnoreCase(DataTypes.DATA_SERVICE.toString())) {
			spatialRepresentationTypeObj.setVisible(false);
			spatialRepresentationTypeObj.setRequired(false);
		}
		else {
			spatialRepresentationTypeObj.setRequired(true);	
			spatialRepresentationTypeObj.setVisible(true);
		}
	}	
}