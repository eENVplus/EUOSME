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
import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;


//import eu.europa.ec.jrc.euosme.gwt.client.EUOSMEGWT;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;

/**
 * Create the tabs container
 * 
 * @version 4.0 - October 2014
 * @author 	Marzia Grasso
 */
public class Tabs extends Composite implements LoadHandler, HasLoadHandlers {
	
	private static TabsUiBinder uiBinder = GWT.create(TabsUiBinder.class);
	interface TabsUiBinder extends UiBinder<Widget, Tabs> {	}
	
	@UiField
	public static TabLayoutPanel tabs;
	
	/** Constants declaration */
	private iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Define TABS */
	@UiField(provided = true)
	Label metadataTabLabel = new Label(constants.metadataTabTitle());
		
	@UiField(provided = true)
	Label identificationTabLabel = new Label(constants.identificationTabTitle());
	
	@UiField(provided = true)
	Label classificationTabLabel = new Label(constants.classificationTabTitle());
	
	@UiField(provided = true)
	Label keywordTabLabel = new Label(constants.keyword());
	
	@UiField(provided = true)
	Label geographicTabLabel = new Label(constants.geographicTabTitle());
	
	@UiField(provided = true)
	Label temporalTabLabel = new Label(constants.temporalTabTitle());
	
	@UiField(provided = true)
	Label qualityTabLabel = new Label(constants.qualityTabTitle());
	
	@UiField(provided = true)
	Label conformityTabLabel = new Label(constants.conformityTabTitle());
	
	@UiField(provided = true)
	Label constraintsTabLabel = new Label(constants.constraintsTabTitle());
	
	@UiField(provided = true)
	Label organizationTabLabel = new Label(constants.organizationTabTitle());
	
	@UiField(provided = true)
	Label interoperabilityTabLabel = new Label(constants.interoperabilityTabTitle());
	
	/** tab content declaration */
	@UiField(provided = true)
	TabMetadata tabMetadataObj = new TabMetadata();
		
	@UiField(provided = true)
	TabOrganization tabOrganizationObj= new TabOrganization();
	
	@UiField(provided = true)
	TabIdentification tabIdentificationObj = new TabIdentification();
	
	@UiField(provided = true)
	TabClassification tabClassificationObj = new TabClassification(); 
	
	@UiField(provided = true)
	TabKeyword tabKeywordObj = new TabKeyword();
	
	@UiField(provided = true)	
	TabGeographic tabGeographicObj = new TabGeographic();
	
	@UiField(provided = true)
	TabTemporal tabTemporalObj = new TabTemporal();
	
	@UiField(provided = true)
	TabQuality tabQualityObj = new TabQuality();
	
	@UiField(provided = true)
	TabConformity tabConformityObj = new TabConformity();
	
	@UiField(provided = true)
	TabConstraints tabConstraintsObj = new TabConstraints(); 
	
	@UiField(provided = true)
	TabInteroperability tabInteroperabilityObj = new TabInteroperability(); 
	
	/** 
     * constructor for tabs
     */
	public Tabs() {
		this.addLoadHandler(this);
		this.sinkEvents(Event.ONLOAD);		
		initWidget(uiBinder.createAndBindUi(this));		
		
		tabs.addSelectionHandler(new SelectionHandler<Integer>() {

			@Override
			public void onSelection(SelectionEvent<Integer> event) {				
				// tab metadata 
				if (event.getSelectedItem() == 0){

				}
				
			}
			
		});
			
	
	}	
	
	/**
	 * This is called to make the validation of all the tabs
	 */
	public void myCheck() {
		tabMetadataObj.myCheck();
		tabIdentificationObj.myCheck();		
		tabClassificationObj.myCheck();
		tabKeywordObj.myCheck();
		tabGeographicObj.myCheck();
		tabQualityObj.myCheck();
		tabConformityObj.myCheck();
		tabConstraintsObj.myCheck();
		tabOrganizationObj.myCheck();
		tabInteroperabilityObj.myCheck();
	}

	/**
	 * @param n	{@link Integer} the number of tab to open
	 */
	public void selectTab(int n) {
		tabs.selectTab(n);
	}
	
	public void addKeyword (String myString, String mySource, String myDate, String myDateType, String myUri, String nodeName, String parent ) { //MG 28.04.2015
		tabKeywordObj.addKeyword(myString, mySource, myDate, myDateType, myUri, nodeName, parent);
	}	
	
	@Override
	public HandlerRegistration addLoadHandler(LoadHandler handler) {
		return addDomHandler(handler, LoadEvent.getType());	    
	}

	@Override
	public void onLoad(LoadEvent event) {
		
		
	}
}