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

package eu.europa.ec.jrc.euosme.gwt.client.widgets;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

import eu.europa.ec.jrc.euosme.gwt.client.EUOSMEGWT;
import eu.europa.ec.jrc.euosme.gwt.client.InfoButton;
import eu.europa.ec.jrc.euosme.gwt.client.RESTfulWebServiceProxy;
import eu.europa.ec.jrc.euosme.gwt.client.RESTfulWebServiceProxyAsync;
import eu.europa.ec.jrc.euosme.gwt.client.Utilities;
import eu.europa.ec.jrc.euosme.gwt.client.callback.CodeListRpcCallback;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;

/**
 * Create an horizontal panel with a label and a list box
 * At the bottom, there is a text box with the button used to add an item to the list box 
 * 
 * @version 5.0 - February 2011
 * @author 	Marzia Grasso
 */
public class CodeListMultiple extends Composite {

	private static CodeListMultipleUiBinder uiBinder = GWT.create(CodeListMultipleUiBinder.class);
	interface CodeListMultipleUiBinder extends UiBinder<Widget, CodeListMultiple> {	}
	
	/** Error Label declaration */
	@UiField
	public
	Label myError = new Label();
	
	/** grouping fields declaration */
	@UiField(provided = true)
	DisclosurePanel componentPanel = new DisclosurePanel();
	
	/** Label declaration */
	@UiField
	Label myLabel = new Label();
	
	/** FlexTable declaration */
	@UiField
	FlexTable myFlexTable = new FlexTable();
	
	/** ListBox declaration */
	@UiField
	ListBox myListBox = new ListBox();
		
	/** New ListBox declaration */
	@UiField
	ListBox newListBox = new ListBox(true);
	
	/** Add Button declaration */
	@UiField
	Button newButton = new Button();
	
	/** Button for information */
	@UiField
	InfoButton infoButton = new InfoButton();
	
	/** Constants declaration */
	private iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	/** Array of values in the list/FlexTable */
	private ArrayList<String> myList = new ArrayList<String>();
	
	/** Global variable used to check if the field is empty or not */ 
	private boolean isRequired=false;
	
	/** Global variable used to move into the user guide as an anchor */
	private String helpAnchor="";
	
	/** Global variable used in the URL to get the code list */
	private String codeListName="";
   
	/** Relation between the form element and the tree item */
	private TreeItem myTreeItem;
	
	/** true to order the suggestions alphabetically */
	private boolean orderList = true;
	
	/** 
     * constructor CodeListMultiple: 0..* (String)
     * 
     * @param label				{@link String} =  label of the field
     * @param help				{@link String} = the anchor in the help
     * @param required			{@link Boolean}=  it is true, the field is mandatory
     * @param myListName		{@link String} = the name of the code list
     * @param myDefaultValue	{@link String} = the default value
     * @param order				{@link Boolean} = indicate if the list must be ordered alphabetically
     * 
     * @return	the widget composed by an horizontal panel made up a {@link Label}, a {@link ListBox} and a {@link FlexTable}
     */
	public CodeListMultiple(String label, String help, boolean required, String myListName, String myDefaultValue, boolean order) {

		// Set global variables
		isRequired = required;
		codeListName = myListName;
		helpAnchor = help;
		orderList = order;
		
		// Initialize widget
		initWidget(uiBinder.createAndBindUi(this));
	    
	    // Set Label widget
		setLabel(label);
				
	    myListBox.setVisible(false);
	    
	    // Set Label and name of myList widget
		newListBox.addItem(constants.loadingData(),"");		
	    
	    myListBox.addFocusHandler(new FocusHandler(){
			@Override
			public void onFocus(FocusEvent event) {
				addNew("loadFile",myListBox.getItemText(myListBox.getItemCount()-1).trim());
			}	    	
	    });    
	    
	    if (EUOSMEGWT.showAll) setDisplay(true);
		else setDisplay(required);
	    
	    // Invoke RESTful service or get the list from available local resource
		if (EUOSMEGWT.rpcCodeList)
			invokeRESTfulWebService(codeListName, newListBox, myDefaultValue);
		else
			Utilities.setCodeList(Utilities.getResourceCodeList(codeListName), newListBox, myDefaultValue, order);
		
		//Set Error Label widget		
		myError.setVisible(false);
		
		// Set info button
		infoButton.setHelpAnchor(helpAnchor);		
		componentPanel.addCloseHandler(new CloseHandler<DisclosurePanel>() {
			@Override
			public void onClose(CloseEvent<DisclosurePanel> event) {				
				event.getTarget().setOpen(true);
			}
		});
		
		newButton.setVisible(false);
	}	
	
	/**
	 * Set the header
	 * 
	 * @param label	{@link String} = the header string
	 */
	public void setLabel(String label) {
		myLabel.setText(label);
		if (isRequired==true) myLabel.setText(myLabel.getText() + " (*)");		
	}
	
	/**
	 * @param b	{@link Boolean} = true to order suggestions alphabetically
	 */
	public void setOrderList(boolean b) {
		orderList = b;		
	}
	
	/**
     * This is called whenever a user press a key (tab, for instance) and force the field check
     * 
     * @see onKeyPress event
     */
	@UiHandler("newListBox")
	public void handleonKeyPressNew(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {	
		   	addNew("newButton",newListBox.getValue(newListBox.getSelectedIndex()).trim());
		}		
	}
	
	/**
	 * This is called to make field's validation and show an error if it fails
	 */
	public void myCheck() {
		// hide error label
		myError.setVisible(false);
		if (isRequired==true && myList.size() == 0) {
	  	    myError.setText(constants.mandatoryField());
	  	    myError.setVisible(true);			
  	  	}
	}

	/**
	 * Add an item to FlexTable. Executed when the user clicks the newButton 
	 */
	public void addNew(String fromWhere, String myString) {
		final String newItem = myString;
		myError.setVisible(false);
		if (fromWhere=="newButton") {
			newListBox.setFocus(true);
						 
			// Check if is empty
			if (newItem.isEmpty()){
				myError.setText(constants.emptyString());
		  	    myError.setVisible(true);
				return;
			}
			// Don't add if it's already in the table.
			if (myList.contains(newItem.toUpperCase()))
			      return;		
			
		}
		
		// Add the String to the table.
		Integer row = myFlexTable.getRowCount();
		myList.add(newItem.toUpperCase());
		if (fromWhere=="newButton") {
			myListBox.addItem(newItem);
			myListBox.setItemSelected(myListBox.getItemCount()-1,true);
			// if it is empty, set the value of the current tree item
			Integer i = myListBox.getItemCount();
			if (i==1) {
				TreeItem val = Utilities.getSelectTreeItem(myListBox.getName());
				Utilities.setTextTreeItem(val,newItem);
				TreeItem attributeCodeListValue = null;
				attributeCodeListValue = Utilities.getSelectTreeItem(myListBox.getName() + ".@codeListValue");
				Utilities.setTextTreeItem(attributeCodeListValue,newItem);
			}
			else { // else add a new node
				if (myTreeItem==null) myTreeItem = Utilities.getSelectTreeItem(myListBox.getName());
				if (myTreeItem!=null) {
					int j = myListBox.getName().lastIndexOf("[1]");
					String myFormName = myListBox.getName().substring(0,j);
					j = myFormName.lastIndexOf("[1]");
					myFormName = myFormName.substring(0,j) + "[" + i.toString() + "]";
					if (Utilities.getSelectTreeItem(myFormName)==null) { 
						// clone parent of codelist element
						TreeItem pcloneMyTreeItem = new TreeItem();
						pcloneMyTreeItem.setTitle(myFormName);
						pcloneMyTreeItem.setText(myTreeItem.getParentItem().getParentItem().getText());
						// clone codelist element
						TreeItem cloneMyTreeItem = new TreeItem();
						myFormName+=myListBox.getName().substring(j+"[1]".length(), myListBox.getName().length());
						cloneMyTreeItem.setTitle(myFormName);
						cloneMyTreeItem.setText(myTreeItem.getParentItem().getText());
						pcloneMyTreeItem.addItem(cloneMyTreeItem);
						// clone
						Utilities.cloneTreeItems(myTreeItem.getParentItem(),cloneMyTreeItem, myListBox.getName().toLowerCase(),myFormName);  	   
						// insert item
						int beforeIndex = myTreeItem.getParentItem().getParentItem().getParentItem().getChildIndex(myTreeItem.getParentItem().getParentItem());
						myTreeItem.getParentItem().getParentItem().getParentItem().insertItem(beforeIndex+1, pcloneMyTreeItem);
						// attributes
					 	TreeItem attributeCodeListValue = Utilities.getSelectTreeItem(myFormName + ".@codeListValue");
						Utilities.setTextTreeItem(attributeCodeListValue,newItem);
						// set value
						TreeItem myTreeItemValue = Utilities.getSelectTreeItem(myFormName);
						Utilities.setTextTreeItem(myTreeItemValue,newItem);
						// set selected
						Utilities.ensureItemVisible(myTreeItemValue);
					}
				}	
			}
			
		}		
		myFlexTable.setText(row, 0, newItem);
		  
		// Add a button to remove this row from the table.
		Button removeButton = new Button();
		removeButton.addStyleName("minusButton");
		removeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Integer removedIndex = myList.indexOf(newItem.toUpperCase()) + 1;
				myList.remove(removedIndex-1);
		        myListBox.removeItem(removedIndex-1);
		        myFlexTable.removeRow(removedIndex-1);
		        int j = myListBox.getName().lastIndexOf("[1]");
				String myFormName = myListBox.getName().substring(0,j);
				j = myFormName.lastIndexOf("[1]");
				myFormName = myFormName.substring(0,j) + "[" + (removedIndex).toString() + "]";// + myListBox.getName().substring(j+"[1]".length(), myListBox.getName().length());
				if (myListBox.getItemCount()!=0) {
			        TreeItem val = Utilities.getSelectTreeItem(myFormName);
					if (val!=null) {
						GWT.log("TREE: remove " + myFormName, null);
						val.remove();
					}
					for (Integer x = removedIndex + 1; x <= (myListBox.getItemCount()+1);x++) {
						// Reset count of tree items
						j = myListBox.getName().lastIndexOf("[1]");
						myFormName = myListBox.getName().substring(0,j);
						j = myFormName.lastIndexOf("[1]");
						String searchFormName = myFormName.substring(0,j) + "[" + (x).toString() + "]";// + myListBox.getName().substring(j+"[1]".length(), myListBox.getName().length());
						Integer z = x-1;
						String newFormName = myFormName.substring(0,j) + "[" + (z).toString() + "]";
						GWT.log("TREE: search " + searchFormName + " and change to " + newFormName,null);								
						TreeItem val1 = Utilities.getSelectTreeItem(searchFormName);
						if (val1!=null) {
							val1.getChild(0).setTitle(val1.getChild(0).getTitle().replace(searchFormName, newFormName));
							val1.setTitle(newFormName);
						}
					}
		        }
		        else {
		        	TreeItem val = Utilities.getSelectTreeItem(myFormName+myListBox.getName().substring(j+"[1]".length(), myListBox.getName().length()));
					Utilities.setTextTreeItem(val,constants.emptyXMLValue());
					TreeItem attributeCodeListValue = null;
					attributeCodeListValue = Utilities.getSelectTreeItem(myFormName+myListBox.getName().substring(j+"[1]".length(), myListBox.getName().length()) + ".@codeListValue");
					Utilities.setTextTreeItem(attributeCodeListValue,constants.emptyXMLValue());					
		        }
		    }
		});
		myFlexTable.setWidget(row, 1, removeButton);
		
		newListBox.setFocus(true);
	}

	/**
	 * @param myValues 	{@link ArrayList} of {@link String} = set the values in the {@link FlexTable}
	 */
	public void setMyValues(ArrayList<String> myValues) {
		myList.clear();
		myListBox.clear();
		myFlexTable.clear();
		for (int i=0;i<myValues.size();i++) {
			myList.add(myValues.get(i).toUpperCase());
			myListBox.addItem(myValues.get(i));
			myListBox.setItemSelected(i,true);			
			myFlexTable.setText(i, 0, myValues.get(i));
		}		
	}

	/**
	 * @return {@link ArrayList} of {@link String} = the values in the {@link FlexTable}
	 */
	public ArrayList<String> getMyValues() {
		return myList;
	}

	/**
	 * @param name {@link String} = the name of the field in the form
	 */
	public void setFormName(String name) {
		myListBox.setName(name);
		myListBox.getElement().setId(name);
		newButton.getElement().setId("newButton-" + name);
		newListBox.getElement().setId("new-" + name);
		myError.getElement().setId("error-" + name);
	}
	
	/**
	 * @param required {@link Boolean} = true if the field is required
	 */
	public void setRequired(boolean required) {
		this.isRequired = required;
		//if (required==true) myFlexTable.setText(0, 0,  myFlexTable.getText(0, 0) + " (*)");
		if (required==true) myLabel.setText(myLabel.getText().replace("(*)", "") + " (*)");
		if (EUOSMEGWT.showAll) setDisplay(true);
		else setDisplay(required);
	}
	
	/**
	 * @param visible {@link Boolean} = true to open disclosure panel and show fields group
	 */
	public void setDisplay(boolean visible) {
		componentPanel.setOpen(visible);
	}
	
	/**
     * This is called whenever a user click the add button
     * 
     * @see onClick
     */
	@UiHandler("newButton")
	void handleonClick(ClickEvent event) {
		addNew("newButton",newListBox.getValue(newListBox.getSelectedIndex()).trim());	    	
	}
	
	/**
     * This is called whenever a user press a key (tab, for instance) and force the field check
     * 
     * @see onKeyPress
     */
	@UiHandler("newButton")
	void handleonKeyPressNewButton(KeyPressEvent event) {
		if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_TAB) {	
			myCheck();
		   	if (myError.isVisible()) newListBox.setFocus(true);		    	 
		}	
	}
	
	/**
     * This is called whenever a user focus on the new text box
     * 1. goto related anchor in the user guide
     * 2. select related tree item
     * 
     * @see onFocus event
     */
	@UiHandler("newListBox")
	void onFocus(FocusEvent event) {
		// select the related tree item
		TreeItem val = null;
		val = Utilities.getSelectTreeItem(myListBox.getName());
		myTreeItem = val;						
		// set selected item
		Utilities.ensureItemVisible(myTreeItem);
		// get focus: it is lost on tree item selection 
	 	newListBox.setFocus(true);	 	
	}
	
	/**
     * This is called whenever a user select a value
     * 
     * @see onChange
     */
	@UiHandler("newListBox")
	void onChange(ChangeEvent event) {
		addNew("newButton",newListBox.getValue(newListBox.getSelectedIndex()).trim());	 
	}
	
	/**
	 * This is called to invoke the RESTful service
	 * 
	 * @param	codeListname	{@link String} = the name of the code list
	 * @param	myListRPC		{@link ListBox} = the list to put values on callback
	 * @param myDefaultValue	{@link String} = the default value 
	 */
	private void invokeRESTfulWebService(String codeListName, ListBox myListRPC, String myDefaultValue) {
		CodeListRpcCallback callback = new CodeListRpcCallback();
		callback.setList(myListRPC,myDefaultValue);
		callback.setCodeListName(codeListName);
		callback.setOrderList(orderList);
		RESTfulWebServiceProxyAsync ls = RESTfulWebServiceProxy.Util.getInstance();
		ls.invokeGetRESTfulWebService("codelists", codeListName, LocaleInfo.getCurrentLocale().getLocaleName(), "", "sesame", callback);
	}	
}