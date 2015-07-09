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

package eu.europa.ec.jrc.euosme.gwt.client.i18n;

import com.google.gwt.i18n.client.Constants;

public interface iso19115Constants extends Constants {
		
	/** CI_PointOfContact fields */
	@DefaultStringValue("Date")
	String date();
	
	/** CI_Address fields */
	@DefaultStringValue("City")
	String city();	
  
	@DefaultStringValue("Delivery point")
	String deliveryPoint();
  
	@DefaultStringValue("Administrative area")
	String administrativeArea();

	@DefaultStringValue("Postal code")
	String postalCode();
  
	@DefaultStringValue("Country")
	String country();
	
	@DefaultStringValue("E-mail")
	String electronicMailAddress();
	
	/** CI_OnlineResource fields */
	@DefaultStringValue("Function")
	String function();
  
	@DefaultStringValue("Description")
	String description();
  
	@DefaultStringValue("Title")
	String name();
  
	@DefaultStringValue("Application profile")
  	String applicationProfile();
  
	@DefaultStringValue("Protocol")
	String protocol();
  
	@DefaultStringValue("Link")
	String linkage();
	
	/** CI_Telephone fields */	
	@DefaultStringValue("Voice")
	String voice();
  
	@DefaultStringValue("Fax")
	String facsimile();

	/** CI_Contact fields */	
	@DefaultStringValue("Hours of service")
	String hoursOfService();
  
	@DefaultStringValue("Contact instructions")
	String contactInstructions();

	@DefaultStringValue("Title")
	String title();
	
	@DefaultStringValue("Resource Title")
	String resourceTitle();
	
	@DefaultStringValue("Alternate Title")
	String alternateTitle();
	
	/** CI_Date fields */
	@DefaultStringValue("Date type")
	String dateType();
		
	/** CI_ResponsibleParty fields */
	@DefaultStringValue("Individual name")
	String individualName();

	@DefaultStringValue("Organisation name")
	String organisationName();

	@DefaultStringValue("Position name")
	String positionName();

	@DefaultStringValue("Role")
	String role();
  
	@DefaultStringValue("Online Resource")
	String ci_onlineResource();

	@DefaultStringValue("Address")
	String ci_address();

	@DefaultStringValue("Contact")
	String ci_contact();

	@DefaultStringValue("Telephone")
	String ci_telephone();

	@DefaultStringValue("Responsible Party")
	String ci_responsibleParty();
	
	@DefaultStringValue("Point of contact")
	String pointOfContact();
	
	@DefaultStringValue("Metadata point of contact")
	String pointOfContactINSPIRE();		
	
	/** MD_Identifier fields */
	@DefaultStringValue("Identifier")
	String md_identifier();
	@DefaultStringValue("Code")
	String code();
	@DefaultStringValue("Codespace")
	String codeSpace();
	@DefaultStringValue("Version")
	String version();
	
	/** Parent identifier field */
	@DefaultStringValue("Parent identifier")
	String parentIdentifier();
	@DefaultStringValue("<h4><a id=\"parentIdentifier\" name=\"parentIdentifier\"> </a>Parent identifier</h4><p>File identifier of the metadata to which this metadata is a subset (child).</p><p>The value domain of this metadata element is free text.</p>")
	String parentIdentifierHelp();	
	
	/** File identifier field */
	@DefaultStringValue("File identifier")
	String fileIdentifier();
	@DefaultStringValue("<h4><a id=\"fileIdentifier\" name=\"fileIdentifier\"> </a>File identifier</h4><p>Parent metadata records (i.e. the data series) should have a unique file identifier that does not change. Do not change this File Identifier even if you update the metadata.</p><p>The value domain of this metadata element is free text.</p>")
	String fileIdentifierHelp();
	
	/** Address field */
	@DefaultStringValue("Address")
	String addressSpecification();
	@DefaultStringValue("<h4><a id=\"addressSpecification\" name=\"addressSpecification\"> </a>Address</h4><p>The web address (url) of the specification</p><p></p>")
	String addressSpecificationHelp();	
	
	/** TM_Primitive fields */
	@DefaultStringValue("Begin")
	String beginDate();
	@DefaultStringValue("End")
	String endDate();
	@DefaultStringValue("now")
	String now();	
	@DefaultStringValue("Please enter valid dates in the format YYYY-MM-DD or YYYY-MM-DDTHH:MI:SS")
	String mandatoryFieldCombined2();	
	
	/** Messages */
	@DefaultStringValue("The string is empty")
	String emptyString();
	
	@DefaultStringValue("This field is mandatory")
	String mandatoryField();
  
	@DefaultStringValue("Invalid mail address")
	String invalidMail();

	@DefaultStringValue("Invalid URL")
	String invalidURL();
	
	@DefaultStringValue("Input, at least, one of the following fields: Individual name or Organisation name or Position name")
	String mandatoryFieldCombined();

	@DefaultStringValue("Invalid integer number")
	String invalidInteger();
  
	@DefaultStringValue("CodeList Service FAILED. The offline resources will be used.")
	String codelistServiceFailed();

	@DefaultStringValue("Query in progress...")
	String loadingData();

	@DefaultStringValue("--select a value")
	String selectValue();

	@DefaultStringValue("The form is valid")
	String formIsValid();	

	@DefaultStringValue("Unable to load selected file")
	String unableToLoadFile();
	
	@DefaultStringValue("Unable to load selected file: md_scopecode element not found")
	String unableToLoadFilemd_scopecode();	
	
	@DefaultStringValue("Please, select a file")
	String selectFile();
	
	@DefaultStringValue("Loading file...")
	String loadingFile();
	
	@DefaultStringValue("Please enter all the values expressed in decimal degrees, with a precision of at least 2 decimals.")
	String invalidDouble();	
	
	/** Character string multiple */
	@DefaultStringValue("add")
	String add();
	
	/** Menu */
	@DefaultStringValue("New")
	String newFile();
	
	@DefaultStringValue("INSPIRE Spatial dataset")
	String newSpatialDataset();
	
	@DefaultStringValue("INSPIRE Spatial dataset series")
	String newSpatialDatasetSeries();
	
	@DefaultStringValue("INSPIRE Spatial data service")
	String newSpatialDataService();
	
	@DefaultStringValue("ISO 19115 Dataset")
	String newISODataset();
	
	@DefaultStringValue("Save")
	String save();
	
	@DefaultStringValue("Load")
	String load();

	@DefaultStringValue("Validate")
	String validate();
	
	@DefaultStringValue("Info")
	String info();	
		
	/** Tabs Titles */	
	@DefaultStringValue("Metadata")
	String metadataTabTitle();
	@DefaultStringValue("Metadata on metadata")
	String metadataTitle();
	@DefaultStringValue("")
	String metadataSummary();
	
	@DefaultStringValue("Identification")
	String identificationTabTitle();
	@DefaultStringValue("Identification")
	String identificationTitle();
	@DefaultStringValue("")
	String identificationSummary();
	
	@DefaultStringValue("Classification")
	String classificationTabTitle();
	@DefaultStringValue("Classification of spatial data and services")
	String classificationTitle();
	@DefaultStringValue("")
	String classificationSummary();
	
	@DefaultStringValue("Keyword")
	String keywordTitle();
	@DefaultStringValue("")
	String keywordSummary();
	
	@DefaultStringValue("Geographic")
	String geographicTabTitle();
	@DefaultStringValue("Geographic location")
	String geographicTitle();
	@DefaultStringValue("")
	String geographicSummary();

	@DefaultStringValue("Temporal")
	String temporalTabTitle();
	@DefaultStringValue("Temporal")
	String temporalTitle();
	@DefaultStringValue("Individually all temporal reference elements are conditional but one or more temporal reference must be provided.")
	String temporalSummary();
	
	@DefaultStringValue("Quality&Validity")
	String qualityTabTitle();	
	@DefaultStringValue("Quality and validity ")
	String qualityTitle();
	@DefaultStringValue("")
	String qualitySummary();
	@DefaultStringValue("For services, it is not possible to express the restriction of a service concerning the spatial resolution in the current version of ISO 19119. While the problem is addressed by the standardization community, spatial resolution restrictions for services shall be expressed in the Resource Abstract (Identification tab).")
	String qualityServiceSummary();
	
	@DefaultStringValue("Conformity")
	String conformityTabTitle();
	@DefaultStringValue("Conformity")
	String conformityTitle();
	@DefaultStringValue("")
	String conformitySummary();
	
	@DefaultStringValue("Constraints")
	String constraintsTabTitle();
	@DefaultStringValue("Constraint related to access and use")
	String constraintsTitle();
	@DefaultStringValue("")
	String constraintsSummary();
	
	@DefaultStringValue("Organization")
	String organizationTabTitle();
	@DefaultStringValue("Responsible Organization")
	String organizationTitle();	
	@DefaultStringValue("Organisations responsible for the establishment, management, maintenance and distribution of spatial data sets and services")
	String organizationSummary();

	
	/** Buttons */
	@DefaultStringValue("Cancel")
	String cancelButton();
	
	@DefaultStringValue("Save file")
	String saveFileButton();

	@DefaultStringValue("Submit")
	String submitButton();

	@DefaultStringValue("Open file")
	String openFileButton();


	
	/** TabMetadata fields */
	@DefaultStringValue("Metadata date")
	String metadataDate();
	
	@DefaultStringValue("Metadata language")
	String metadataLanguage();
	
	/** TabIdentification fields */
	@DefaultStringValue("Resource")
	String resource();
	
	@DefaultStringValue("Resource abstract")
	String resourceAbstract();
	
	@DefaultStringValue("Please choose the resource type you want to create INSPIRE metadata for: ")
	String resourceType();
	
	@DefaultStringValue("Resource locator")
	String resourceLocator();
	
	@DefaultStringValue("Resource Language")
	String resourceLanguage();
	
	@DefaultStringValue("Unique resource identifier")
	String resourceIdentifier();
	
	@DefaultStringValue("Coupled resource")
	String coupledResource();	
	
	/** TabClassification fields */
	@DefaultStringValue("Topic category")
	String topicCategory();
	
	@DefaultStringValue("Spatial data service type")
	String serviceType();	
	
	/** TabKeywords fields */
	@DefaultStringValue("Keyword value")
	String keywordValue();

	@DefaultStringValue("Originating controlled vocabulary")
	String originatingControlledVocabulary();

	@DefaultStringValue("Keyword")
	String keyword();
	
	@DefaultStringValue("Reference Date")
	String referenceDate();

	/** TabGeographic fields */
	@DefaultStringValue("North Bound Latitude")
	String north();
	
	@DefaultStringValue("South Bound Latitude")
	String south();
	
	@DefaultStringValue("West Bound Longitude")
	String west();
	
	@DefaultStringValue("East Bound Longitude")
	String east();
	
	@DefaultStringValue("Geographic Bounding Box")
	String geoBoundingBox();
	
	@DefaultStringValue("Enter a query to forward geocode, or click on the map to reverse geocode.")
	String geographicQueryInstructions();
	
	@DefaultStringValue("Search Maps")
	String runQuery();
	
	@DefaultStringValue("Address")
	String address();
	
	/** TabTemporal fields */
	@DefaultStringValue("Temporal Extent")
	String temporalExtent();

	@DefaultStringValue("Date of publication")
	String publicationDate();

	@DefaultStringValue("Date of last revision")
	String revisionDate();

	@DefaultStringValue("Date of creation")
	String creationDate();

	/** TabQuality fields */
	@DefaultStringValue("Lineage")
	String lineage();

	@DefaultStringValue("Equivalent Scale")
	String equivalentScale();
	
	@DefaultStringValue("Input either (Equivalent scale) or (Resolution distance and Unit of measure)")
	String equivalentScaleHelp();	
	
	@DefaultStringValue("An example: <Protection and Conservation of European Seas (PROCAS)>-<Water Resources Unit (H01)>-<Institute for Environment and Sustainability (IES)>-Joint Research Centre (JRC)-European Commission")
	String responsiblePartyHelp();
	
	@DefaultStringValue("Distance")
	String distance();

	@DefaultStringValue("Input Equivalent Scale or Distance")
	String mandatoryFieldCombined3();

	@DefaultStringValue("Unit of measure")
	String UM();

	@DefaultStringValue("Please specify a unit of measure")
	String mandatoryFieldCombined4();

	@DefaultStringValue("Please specify a distance")
	String mandatoryFieldCombined5();
	
	@DefaultStringValue("Spatial Resolution")
	String spatialResolution();
	
	/** TabConformity fields */
	@DefaultStringValue("Specification")
	String specification();

	@DefaultStringValue("Degree")
	String degree();

	@DefaultStringValue("See the referenced specification")
	String explanationValue();

	@DefaultStringValue("Not evaluated")
	String notEvaluated();
	
	@DefaultStringValue("Not conformant")
	String notConformant();
	
	@DefaultStringValue("Conformant")
	String conformant();
	
	/** TabConstraints fields */
	@DefaultStringValue("Conditions applying to access and use")
	String useLimitation();

	@DefaultStringValue("Limitations on public access")
	String accessConstraints();

	@DefaultStringValue("Limitations on using the resource or metadata")
	String useConstraints();

	@DefaultStringValue("Other restrictions")
	String otherConstraints();

	@DefaultStringValue("Input other restrictions free text or remove otherRestriction selection")
	String mandatoryFieldCombined6();

	@DefaultStringValue("Saving file...")
	String savingFile();

	@DefaultStringValue("If the download does not start automatically, please click on 'Open file' button.")
	String infoOnDownload();
	
	@DefaultStringValue("Keyword from repositories")
	String repository();
	
	@DefaultStringValue("Keyword from online repositories")
	String onlineRepository();	
	
	@DefaultStringValue("Keyword from GEMET and DROUGHT")
	String repositoryGemet();	
	
	@DefaultStringValue("Show/hide tree")
	String showHideTree();
	
	@DefaultStringValue("Show/hide help")
	String showHideHelp();

	@DefaultStringValue("View")
	String view();
	
	@DefaultStringValue("This data type is not supported")
	String errorDataType();
	
	@DefaultStringValue("Value does not exist in the code list")
	String errorCodeListValue();

	@DefaultStringValue("The multiplicity of this data type is not supported")
	String errorDataTypeMultiple();
	
	@DefaultStringValue("Repository Service FAILED")
	String repositoryServiceFailed();
	
	@DefaultStringValue("ERROR: ")
	String error();
	
	@DefaultStringValue("Warning: ")
	String warning();
	
	@DefaultStringValue("This data type is not supported and on saving it will be added as is it")
	String errorDataType1();

	@DefaultStringValue("This data type is not supported and on saving it will be lost")
	String errorDataType2();

	@DefaultStringValue("Error Code 10001: Connection refused - INSPIRE Data themes service")
	String dataThemesServiceFailed();

	@DefaultStringValue("MANDATORY: Select at least an INSPIRE Data themes from the list. OPTIONAL: Select a keyword from the available repositories.")
	String selectKeywordInfo();

	@DefaultStringValue("DateTime data type is not supported. It will be replaced by Date data type.")
	String errorDateTimeNotSupported();
	
	@DefaultStringValue("Loading...")
	String loading();
	
	@DefaultStringValue("Close")
	String close();
	
	@DefaultStringValue("Conformity")
	String conformity();

	@DefaultStringValue("Commission Regulation (EC) No 1205/2008 of 3 December 2008 implementing Directive 2007/2/EC of the European Parliament and of the Council as regards metadata Text with EEA relevance")
	String regulationTitle();
	
	@DefaultStringValue("RDSI Metadata for Discovery Creation Guidelines")
	String rdsiHelpTitle();	
	
	@DefaultStringValue("Help")
	String help();
	
	@DefaultStringValue("Predefined values")
	String predefinedValues();
	
	@DefaultStringValue("Refresh")
	String refresh();
	
	@DefaultStringValue("Get UUID")
	String getUUID();

	@DefaultStringValue("Selected value: ")
	String selectedValue();
	
	@DefaultStringValue("Error code 10007. If this error persists, please contact your system administrator.")
	String geoCodeListError();
	
	
	/** exists but not translated until revision 12 ***/
	
	
	
	
	/** not translated until revision 12 ***/
	
	@DefaultStringValue("Press OK if you want to update the Metadata date to today.")
	String update_mddate();
	
	@DefaultStringValue("Measure identification")
	String measureIdentification();

	@DefaultStringValue("Explanation")
	String explanation();
	
	@DefaultStringValue("False")
	String isfalse();
	
	@DefaultStringValue("True")
	String istrue();	

	@DefaultStringValue("Result")
	String result();	

	@DefaultStringValue("Available keywords")
	String availableKeywords();

	@DefaultStringValue("Keyword from INSPIRE Data themes")
	String inspireDataThemes();
	
	@DefaultStringValue("Where do you want to publish your metadata?")
	String publish_info();
	
	@DefaultStringValue("<h4>RDSI</h4><p>IES Reference Data & Services Initiative</p><h4>INSPIRE@EC</h4><p>INSPIRE at EC</p><h4>CHM</h4><p>Climate Change Clearing House</p>")
	String publish_info_help();	
	
	@DefaultStringValue("INSPIRE Metadata Editor User Guide")
	String inspireGuidelines();	

	@DefaultStringValue("Resource constraints")
	String constraints();	
	
	@DefaultStringValue("Keyword Type")
	String keywordType();	
	
	@DefaultStringValue("Test")
	String testTabTitle();
	@DefaultStringValue("Test service")
	String testTitle();
	@DefaultStringValue("")
	String testSummary();		
	
	/** Tree */
	@DefaultStringValue("#value = ")
	String XMLValue();
	
	@DefaultStringValue("#EMPTY")
	String emptyXMLValue();
	
	@DefaultStringValue("Citation")
	String CI_Citation();
	
	@DefaultStringValue("Resource Alternate Title")
	String resourceAlternateTitle();	
	
	
	
	
	
	
	@DefaultStringValue("Free keyword")
	String freeKeyword();
	
	@DefaultStringValue("RDSI")
	String rdsi_rdsi();
	
	@DefaultStringValue("INSPIRE@EC")
	String rdsi_inspire();
	
	@DefaultStringValue("CHM")
	String rdsi_cch();

	@DefaultStringValue("INSPIRE services failed")	
	String inspireServiceFailed();

	@DefaultStringValue("Press ENTER to get all suggestions.")	
	String helpCodeList();
	
	@DefaultStringValue("Unable to load selected file: unsupported schema. EUOSME accepts only ISO 19139 files.")
	String errorSchema();

	@DefaultStringValue("Save as template")
	String saveAsTemplate();
	
	@DefaultStringValue("<Action name>-<Unit name>-<Institute name>-Organisation name")
	String RDSIorganisationName();

	@DefaultStringValue("User Guide")
	String helpUserGuide();
	
	@DefaultStringValue("Developers Guide")
	String helpDeveloperGuide();

	@DefaultStringValue("Countries")
	String countries();

	@DefaultStringValue("Specifications")
	String specifications();

	@DefaultStringValue("Geographic services taxonomy of EN ISO 19119")
	String dataService();
	
	@DefaultStringValue("MANDATORY: Select at least a category from the Geographic services taxonomy of EN ISO 19119. OPTIONAL: Select a keyword from the available repositories.")
	String selectKeywordInfoDataService();
	
	@DefaultStringValue("Apply")
	String apply();

	@DefaultStringValue("Language")
	String languages();

	@DefaultStringValue("About")
	String about();
	
	@DefaultStringValue("OK")
	String okButton();
	
	/* Thesaurus framework */
	@DefaultStringValue("eENVplus repositories")
	String ENVrepository();
	
	@DefaultStringValue("Save in GN")
	String saveInGeonetwork();

	@DefaultStringValue("Geonetwork service failed")
	String gnServiceFailed();

	@DefaultStringValue("URI")
	String URI();

	/* MD_ReferenceSystem fields */
	@DefaultStringValue("Information about the reference system")
	String referenceSystem();
	
	/* MD_Format fields */
	@DefaultStringValue("Name of the data transfer format")
	String formatName();
	@DefaultStringValue("Version of the format (date, number, etc.)")
	String formatVer();	
	@DefaultStringValue("Amendment number of the format version")
	String formatAmdNum();
	@DefaultStringValue("Name of a subset, profile, or product specification of the format") 
	String formatSpec();	
	@DefaultStringValue("Recommendations of algorithms or processes that can be applied to read or expand resources to which compression techniques have been applied") 
	String fileDecmTech();
	@DefaultStringValue("Provides information about the distributor’s format") 
	String formatDist();

	/* MD_Distributor fields */
	@DefaultStringValue("Party from whom the resource may be obtained")
	String distorCont();
	
	/* MD_StandardOrderProcess fields */
	@DefaultStringValue("Date and time when the resource will be available")
	String planAvDtTm();
	@DefaultStringValue("General instructions, terms and services provided by the distributor")
	String ordInstr();	
	@DefaultStringValue("Typical turnaround time for the filling of an order")
	String ordTurn();
	@DefaultStringValue("Fees and terms for retrieving the resource. Include monetary units")
	String resFees();
	
	/* MD_DigitalTransferOptions fields */
	@DefaultStringValue("Tiles, layers, geographic areas, etc., in which data is available")
	String unitsODist();	
	@DefaultStringValue("Estimated size of a unit in the specified transfer format, expressed in megabytes. The transfer size is > 0.0")
	String transSize();
	@DefaultStringValue("Information about online sources from which the resource can be obtained")
	String onLineSrc();
	@DefaultStringValue("Information about offline media on which the resource can be obtained")
	String offLineMed();

	/* Tab Interoperability fields */
	@DefaultStringValue("Interoperability")
	String interoperabilityTabTitle();
	@DefaultStringValue("Interoperability")
	String interoperabilityTitle();
	@DefaultStringValue("The metadata describing a spatial data set shall include the following metadata elements required for interoperability:")
	String interoperabilitySummary();
	@DefaultStringValue("Coordinate Reference System")
	String coordinateReferenceSystemInfo();
	@DefaultStringValue("Temporal Reference System")
	String temporalReferenceSystemInfo();
	@DefaultStringValue("Information about the distributor of and options for obtaining the resource")
	String distribution();
	@DefaultStringValue("Character encoding")
	String characterset();
	@DefaultStringValue("Method used to spatially represent geographic information")
	String spatialRepresentationType();
	
	/* MD_Distribution fields */
	@DefaultStringValue("Encoding")
	String distributionFormat();
	@DefaultStringValue("Information about the distributor")
	String distributor();
	@DefaultStringValue("Provides information about how the resource may be obtained, and related instructions and fee information")
	String distorOrdPrc();
	@DefaultStringValue("Provides information about the technical means and media used by the distributor")
	String distorTran();
	
	/* RS_Identifier fields */
	@DefaultStringValue("Version identifier for the namespace")
	String identVrsn();	
	@DefaultStringValue("Name or identifier of the person or organization responsible for namespace")
	String identCodeSpace();

	@DefaultStringValue("All thesauri")
	String allThesauri();

	@DefaultStringValue("Type the password to access EUOSME")
	String inputPassword();
	@DefaultStringValue("Wrong password. Please try again")
	String wrongPassword();
	
	@DefaultStringValue("UUID not found in the document. Please check the source file into Geonetwork")
	String gnServiceUuid();
	
	@DefaultStringValue("Geonetwork Username")
	String username();
	@DefaultStringValue("Geonetwork Password")
	String password();
	@DefaultStringValue("Type username and password of your Geonetwork account")
	String inputPasswordGeonetwork();
	@DefaultStringValue("Type username and password")
	String inputUsernamePassword();
}
