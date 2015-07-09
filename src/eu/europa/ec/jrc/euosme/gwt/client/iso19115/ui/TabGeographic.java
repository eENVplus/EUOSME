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
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.DrawFeatureOptions;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.MousePosition;
import org.gwtopenmaps.openlayers.client.control.DrawFeature.FeatureAddedListener;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.openlayers.client.handler.RegularPolygonHandler;
import org.gwtopenmaps.openlayers.client.handler.RegularPolygonHandlerOptions;
import org.gwtopenmaps.openlayers.client.layer.TransitionEffect;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.WMS;
import org.gwtopenmaps.openlayers.client.layer.WMSOptions;
import org.gwtopenmaps.openlayers.client.layer.WMSParams;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geocode.LocationCallback;
import com.google.gwt.maps.client.geocode.Placemark;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Polyline;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import eu.europa.ec.jrc.euosme.gwt.client.EUOSMEGWT;
import eu.europa.ec.jrc.euosme.gwt.client.i18n.iso19115Constants;
import eu.europa.ec.jrc.euosme.gwt.client.widgets.CodeList;
import eu.europa.ec.jrc.euosme.gwt.client.widgets.GeoBoundsMultiple;

/**
 * Create the tab Geographic
 * 
 * @version 5.1 - February 2011
 * @author 	Marzia Grasso
 */
public class TabGeographic extends Composite {
	
	private static TabGeographicUiBinder uiBinder = GWT.create(TabGeographicUiBinder.class);
	interface TabGeographicUiBinder extends UiBinder<Widget, TabGeographic> {	}
	
	/** Constants declaration */
	private iso19115Constants constants = GWT.create(iso19115Constants.class);
	
	private static final Projection DEFAULT_PROJECTION = new Projection("EPSG:4326");
	
	/** title of the tab */
	@UiField(provided = true)
	Label titleLabel = new Label(constants.geographicTitle());
	
	/** summary of the tab */
	@UiField(provided = true)
	HTML summaryHTML = new HTML(constants.geographicSummary());
	
	/** topic category control declaration */
	@UiField(provided = true)
	DockLayoutPanel dock = new DockLayoutPanel(Unit.PCT);
	
	/** responsiblePartyObj control declaration */
	@UiField(provided = true)
	GeoBoundsMultiple geoBoundsObj = new GeoBoundsMultiple(constants.geoBoundingBox(), true);
	
	/** Horizontal Panel that contains the map */
	@UiField(provided = true)
	HorizontalPanel mapPanel = new HorizontalPanel();
	
	/** Vertical Panel that contains the query text box and the button */
	@UiField(provided = true)
	VerticalPanel queryPanel = new VerticalPanel();
	
	@UiField
	HorizontalPanel preferredObj = new HorizontalPanel();
	
	/** the map */
	Composite map; 
	public org.gwtopenmaps.openlayers.client.MapWidget mapWidget;
	
	// Query Label, TextBox and Button
	@UiField(provided = true)
	Label queryLabel = new Label(constants.geographicQueryInstructions());
	
	@UiField(provided = true)
	public
	static
	TextBox queryTextBox = new TextBox();
	
	@UiField(provided = true)
	public
	static
	Button queryButton = new Button();
	
	/** List of BBox for some countries */
	final CodeList country = new CodeList(constants.countries(),"boundingbox",false,"14","",true);
	
	/** 
    * constructor TabGeographic
    * 
    * @return	the widget composed by the Geographic Tab
    */
	public TabGeographic() {
		queryButton.setText(constants.runQuery());
		// set style
		titleLabel.removeStyleName("gwt-Label");
		// set form names
		setFormName();
		
		// initialize widget
		initWidget(uiBinder.createAndBindUi(this));
		
		// add scroll bars
		dock.getWidgetContainerElement(dock.getWidget(0)).addClassName("auto");
		dock.getWidgetContainerElement(dock.getWidget(0)).getStyle().clearOverflow();
		Element myTable = dock.getElement().getElementsByTagName("table").getItem(0);
		@SuppressWarnings("unused")
		String txt = myTable.getInnerHTML();
		myTable.getStyle().clearPosition();
		
		if (summaryHTML.getHTML().isEmpty()) summaryHTML.removeFromParent();
		
		//HTML matchFound = new HTML("<div style=\"height:300px;overflow:auto;\"><div id=\"responseCount\" style=\"display:none;\"><span style=\"font-weight: bold;\">Matches found:</span><span id=\"matchCount\" style=\"display:none;\"></span><div id=\"matches\"></div></div>");
		
		// Workaround to the problem of the map position
	    // Issue 366: Google Map widget does not initialize correctly inside a LayoutPanel
	    if (EUOSMEGWT.apiMapstraction.equalsIgnoreCase("google")) {
	    	map = new com.google.gwt.maps.client.MapWidget();
			nativeMakeMap(map.getElement(),geoBoundsObj.newTextBoxNorth.getElement(), geoBoundsObj.newTextBoxEast.getElement(), geoBoundsObj.newTextBoxSouth.getElement(), geoBoundsObj.newTextBoxWest.getElement(),queryTextBox.getElement());
			mapPanel.add(map);
			//google.maps.event.trigger(map, 'resize');			
		    //mapPanel.add(matchFound);
		    //Event.trigger(mapWidget.getMap(), "resize");
	    }
	    else if (EUOSMEGWT.apiMapstraction.equalsIgnoreCase("gwt-ol")) {
	    	queryPanel.removeFromParent();
	    	if (mapWidget == null) {
	    		initMapGwtOl();
	        	mapPanel.add(mapWidget);
	        	mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups MG 06.05.2015
	    	}
	    }
	    else {
	    	queryPanel.removeFromParent();	    	
	    	sinkEvents(Event.ONMOUSEUP);
	    	Element map_el = DOM.getElementById("mapstraction");
	    	mxnMakeMap(map_el, EUOSMEGWT.apiMapstraction);
	    	mapPanel.getElement().insertFirst(map_el);
	    }
	    
	    
	    preferredObj.add(country);
	    country.myListBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				String selValue = country.myListBox.getValue(country.myListBox.getSelectedIndex());
				if (!selValue.isEmpty()) {
					// selValue contains a value like S:-21.39;W:55.84;N:51.09;E:-63.15
					String[] coordinates = selValue.split(";");
					String south = "";
					String west = "";
					String north = "";
					String east = "";
					for (int i = 0; i < coordinates.length; i++) {
						if (coordinates[i].startsWith("S:")) south = coordinates[i].substring(2);
						if (coordinates[i].startsWith("W:")) west = coordinates[i].substring(2);
						if (coordinates[i].startsWith("N:")) north = coordinates[i].substring(2);
						if (coordinates[i].startsWith("E:")) east = coordinates[i].substring(2);						
					}
					if (!north.isEmpty() && !east.isEmpty() && !south.isEmpty() && !west.isEmpty()) {
						geoBoundsObj.newTextBoxSouth.setValue(south);
						geoBoundsObj.newTextBoxWest.setValue(west);
						geoBoundsObj.newTextBoxNorth.setValue(north);
						geoBoundsObj.newTextBoxEast.setValue(east);	
						geoBoundsObj.newButton.click();
						
						// zoom to the country bound
						if (EUOSMEGWT.apiMapstraction.equalsIgnoreCase("gwt-ol")) {
							Map map = mapWidget.getMap();
							map.zoomToExtent(new Bounds(Double.parseDouble(west),Double.parseDouble(south), Double.parseDouble(east), Double.parseDouble(north)));
						}
						else 
							setBoundsMapstraction(Double.parseDouble(south),Double.parseDouble(west),Double.parseDouble(north), Double.parseDouble(east));
					} else Window.alert(constants.geoCodeListError());					
				}
			}
	    });
	    
	    geoBoundsObj.myListBox.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				// refresh the map to avoid shifting cursor
				if (EUOSMEGWT.apiMapstraction.equalsIgnoreCase("gwt-ol")) {
					mapWidget.getMap().setCenter(mapWidget.getMap().getCenter());			
				}				
			}	    	
	    });
	    
	    geoBoundsObj.newButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// refresh the map to avoid shifting cursor
				if (EUOSMEGWT.apiMapstraction.equalsIgnoreCase("gwt-ol")) {
					mapWidget.getMap().setCenter(mapWidget.getMap().getCenter());			
				}
			}
	    });
	}
	/**
	 * initialize map widget using gwt-openlayers
	 * 
	 */
	    void initMapGwtOl() {
	    	
	    	MapOptions defaultMapOptions = new MapOptions();   
	    	defaultMapOptions.setNumZoomLevels(16);//
	    	
	    	//defaultMapOptions.setProjection("EPSG:4326");
			defaultMapOptions.setMaxExtent(new Bounds(-180, -90, 180, 90));
			defaultMapOptions.setRestrictedExtent(new Bounds(-180, -90, 180, 90));
			defaultMapOptions.setUnits("degrees");				
			mapWidget = new MapWidget("500px","500px", defaultMapOptions);		
			/*GoogleV3Options gNormalOptions = new GoogleV3Options();
	        gNormalOptions.setIsBaseLayer(true);
	        gNormalOptions.setType(GoogleV3MapType.G_NORMAL_MAP);
	        GoogleV3 gNormal = new GoogleV3("Google Normal", gNormalOptions);*/
	        
			// Create a WMS layer as base layer
	        WMSParams wmsParams = new WMSParams();
	        wmsParams.setFormat("image/png");
	        wmsParams.setLayers("basic");
	        wmsParams.setStyles("");
	        
			WMSOptions wmsLayerParams = new WMSOptions();
	        wmsLayerParams.setUntiled();
	        wmsLayerParams.setTransitionEffect(TransitionEffect.RESIZE);
	 
	        String wmsUrl = EUOSMEGWT.wmsEndpoint;
	        WMS wmsLayer = new WMS("Basic WMS", wmsUrl, wmsParams, wmsLayerParams);
	 
	        // Add the WMS to the map
	        final Map map = mapWidget.getMap();
	        //map.addLayer(gNormal);
	        map.addLayer(wmsLayer);
						
			/*OSM osm_1 = OSM.Mapnik("Mapnik");
	        OSM osm_2 = OSM.CycleMap("CycleMap");
	        osm_1.setIsBaseLayer(true);
	        osm_2.setIsBaseLayer(true);
	        map.addLayer(osm_1);
	        map.addLayer(osm_2);*/
	 
	        //Lets add some default controls to the map
	        map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
	        map.addControl(new ScaleLine()); //Display the scaleline
	        map.addControl(new MousePosition());
	        //Center and zoom to a location
	        LonLat lonLat = new LonLat(6.95, 50.94);
	        lonLat.transform(DEFAULT_PROJECTION.getProjectionCode(),
	                map.getProjection()); //transform lonlat to OSM coordinate system
	        map.setCenter(lonLat, 3);
	 
	        /*map.addMapClickListener(new MapClickListener() {
	 
	            public void onClick(MapClickListener.MapClickEvent mapClickEvent) {
	                LonLat lonLat = mapClickEvent.getLonLat();
	 
	                lonLat.transform(map.getProjection(), DEFAULT_PROJECTION.getProjectionCode()); //transform lonlat to more readable format
	 
	                Window.alert("LonLat = (" + lonLat.lon() + " ; " + lonLat.lat() + ")");
	            }
	 
	        });*/
			 
	        FeatureAddedListener listener = new FeatureAddedListener(){
				public void onFeatureAdded(VectorFeature vf) {
					Polygon aoi = Polygon.narrowToPolygon(vf.getGeometry().getJSObject());
					LinearRing[] rings = aoi.getComponents();
					if(rings!=null){ rings[0].getComponents();}
					Geometry geo = vf.getGeometry();

					//Window.alert("Feature of class " + geo.getClassName() +  " added with bounds " + geo.getBounds().toString());
					double north = Math.floor(geo.getBounds().getUpperRightY()*100000)/100000;
					double east = Math.floor(geo.getBounds().getUpperRightX()*100000)/100000;
					double south = Math.floor(geo.getBounds().getLowerLeftY()*100000)/100000;
					double west = Math.floor(geo.getBounds().getLowerLeftX()*100000)/100000;
					geoBoundsObj.newTextBoxNorth.setValue("" + north);
			        geoBoundsObj.newTextBoxEast.setValue("" + east);
			        geoBoundsObj.newTextBoxSouth.setValue("" + south);
			        geoBoundsObj.newTextBoxWest.setValue("" + west);
			        map.zoomToExtent(geo.getBounds());
			 		
				}
			};
			Vector boxLayer = new Vector("Box Layer");
			DrawFeatureOptions drawRegularPolygonFeatureOptions = new DrawFeatureOptions();
			drawRegularPolygonFeatureOptions.onFeatureAdded(listener);
			RegularPolygonHandlerOptions regularPolygonHandlerOptions = new RegularPolygonHandlerOptions();
			regularPolygonHandlerOptions.setSides(4);
			regularPolygonHandlerOptions.setIrregular(true);
			regularPolygonHandlerOptions.setPersist(true);
			drawRegularPolygonFeatureOptions.setHandlerOptions(regularPolygonHandlerOptions);
			final DrawFeature drawRegularPolygon = new DrawFeature(boxLayer, new RegularPolygonHandler(), drawRegularPolygonFeatureOptions);
			map.addControl(drawRegularPolygon);	
			drawRegularPolygon.activate();
	    }
	
	/**
	 * This is called to make a client (first) check of the contained fields
	 */
	public void myCheck() {
		geoBoundsObj.myCheck();	
	}
	
	/**
	 * Set the IDs of the contained objects 
	 */
	public void setFormName() {
		geoBoundsObj.setFormName("md_metadata[1].identificationinfo[1]." + MainPanel.identificationInfoSubType + "[1].extent[1].ex_extent[1].geographicelement[1]");		
	}
	
	/**
	 * This function intercepts the user click on the map and call the method named getCenterMapstraction
	 *  
	 * @see com.google.gwt.user.client.ui.Composite#onBrowserEvent(com.google.gwt.user.client.Event)
	 */
	@Override
	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);		
		Element targetElement =  Element.as(((NativeEvent) event).getEventTarget());
		String targetTagName = targetElement.getTagName();
		if (targetTagName.equalsIgnoreCase("svg") || targetTagName.equalsIgnoreCase("path")) getCenterMapstraction(EUOSMEGWT.apiMapstraction, geoBoundsObj.newTextBoxNorth.getElement(), geoBoundsObj.newTextBoxEast.getElement(), geoBoundsObj.newTextBoxSouth.getElement(), geoBoundsObj.newTextBoxWest.getElement());
	}
	
	/**
	 * This function gets the coordinates and put them into the text boxes
	 * 
	 * @param api		{@link String} = the map's type
	 * @param north		{@link Element} = north text box
	 * @param east		{@link Element} = east text box
	 * @param south		{@link Element} = south text box
	 * @param west		{@link Element} = west text box
	 */
	public native static void getCenterMapstraction(String api, Element north, Element east, Element south, Element west) /*-{
		var bounds = $wnd.userBBoxLayer.geometry.getBounds();
		
		// mapstraction bounds
		if (bounds == null || bounds == undefined) {
			bounds =  $wnd.mapstraction.getBounds();
			var sw = bounds.getSouthWest();
	        var ne = bounds.getNorthEast();
	 		north.value = ne.lat;
	 		east.value = ne.lon;
	 		south.value = sw.lat;
	 		west.value = sw.lon;	        
		}
		
		// OpenLayers bounds
		else {
			north.value = bounds.top;
	 		east.value = bounds.right;
	 		south.value = bounds.bottom;
	 		west.value = bounds.left;
		}
 
		     
	}-*/;
	
	/**
	 * JSNI function used by MapWidget
	 * It checks if a string is a valid pattern for the map
	 * 
	 * @param query	{@link String} = the query
	 * 
	 * @return {@link Boolean} = true if the pattern is right
	 */
	public native static boolean isValidQuery(String query) /*-{
	    //var pattern = /(http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
	    var pattern = /\s*^\-?\d+(\.\d+)?\s*\,\s*\-?\d+(\.\d+)?\s*$/;
	    return pattern.test(query);
	}-*/;
	
	/**
	 * JSNI function to parse latitude and longitude
	 * 
	 * @param value	{@link String} 
	 * @return
	 */
	public native static LatLng parseLatLng(String value) /*-{
		value.replace('/\s//g');
		var coords = value.split(',');
		var lat = parseFloat(coords[0]);
		var lng = parseFloat(coords[1]);
		if (isNaN(lat) || isNaN(lng)) {
			return null;
		} else {
			return new $wnd.GLatLng(lat, lng);
		}		
	}-*/;
	
	/**
	 * Run the query and load the map
	 */
	public void runQuery() {
		String query = queryTextBox.getValue();			
		if (isValidQuery(query)) {				
			LatLng latlng = parseLatLng(query);
		    if (latlng == null) {
		    	queryTextBox.setValue("");
		    } else {
		    	Geocoder geocoder = new Geocoder();
		    	latlng = parseLatLng(latlng.toUrlValue(6));
		    	if (latlng != null)
		    		initMap(map.getElement(),latlng);
			    else
			    	initMap(map.getElement(),LatLng.newInstance(0.0, 0.0));
		    	geocoder.getLocations(query, new LocationCallback() {
					@Override
					public void onFailure(int statusCode) {
						//Window.alert("failed");
						Document.get().getElementById("responseCount").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("matches").getStyle().setDisplay(Display.NONE);
					}
					@Override
					public void onSuccess(JsArray<Placemark> locations) {
						responseGeocode(locations,true);
					}				
				});		    	
		    }
		} else {
			initMap(map.getElement(),LatLng.newInstance(0.0, 0.0));
			Geocoder geocoder = new Geocoder();
			//map.setUIToDefault();
		    geocoder.getLocations(query, new LocationCallback() {
				@Override
				public void onFailure(int statusCode) {
					//Window.alert("failed");
					Document.get().getElementById("responseCount").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("matches").getStyle().setDisplay(Display.NONE);				
				}
				@Override
				public void onSuccess(JsArray<Placemark> locations) {
					responseGeocode(locations,false);					  
				}			
			});
		}		
	}
	
	/**
	 * JSNI function to startup the google map
	 */
	public native static void startupMap() /*-{
		var i = 0;
		if ($wnd.selected != null) {
		    $doc.getElementById('p' + $wnd.selected).style.backgroundColor = "white";
		    $wnd.mapOne.removeOverlay($wnd.polylines[$wnd.selected]);
		}
		var myZoom = $wnd.mapOne.getBoundsZoomLevel($wnd.bounds[i]) - $wnd.mapOne.getZoom();
		if (myZoom < 0 || myZoom > 5) {
			$wnd.mapOne.setZoom($wnd.mapOne.getBoundsZoomLevel($wnd.bounds[i]));		
		}
		$wnd.markers[i].openInfoWindowHtml($wnd.details[i]);
		if (! $wnd.mapOne.getBounds().containsBounds($wnd.bounds[i])) {
			$wnd.mapOne.zoomOut();
			$wnd.mapOne.panTo($wnd.bounds[i].getCenter());
		}
		$wnd.mapOne.addOverlay($wnd.polylines[i]);
		$doc.getElementById('p' + i).style.backgroundColor = "#eeeeff";
		$doc.getElementById('matches').scrollTop = $doc.getElementById('p' + i).offsetTop - $doc.getElementById('matches').offsetTop;
		$wnd.selected = i;
	}-*/;

	/**
	 * JSNI function to initialize the google map
	 * @param mapsDiv	{@link Element} = Div element that contains the map
	 * @param latLng	{@link LatLng} = Set the latitude and longitude starting point 
	 */
	public native static void initMap(Element mapsDiv, LatLng latLng) /*-{
		$wnd.mapOne.clearOverlays();
		$wnd.mapOne.setCenter(latLng, 1);
		$wnd.mapOne.setUIToDefault();
	}-*/;
	

	/**
	 * Get the polyline through a given geocode address
	 * 
	 * @param placemark	{@link Placemark} = the geocode address
	 * 
	 * @return {@link Polyline}
	 */
	public Polyline getPolyline(Placemark placemark) {
		LatLng ne = LatLng.newInstance(placemark.getExtendedData().getBounds().getNorthEast().getLatitude(), placemark.getExtendedData().getBounds().getNorthEast().getLongitude());
		LatLng se = LatLng.newInstance(placemark.getExtendedData().getBounds().getSouthWest().getLatitude(), placemark.getExtendedData().getBounds().getNorthEast().getLongitude());
		LatLng sw = LatLng.newInstance(placemark.getExtendedData().getBounds().getSouthWest().getLatitude(), placemark.getExtendedData().getBounds().getSouthWest().getLongitude());
		LatLng nw = LatLng.newInstance(placemark.getExtendedData().getBounds().getNorthEast().getLatitude(), placemark.getExtendedData().getBounds().getSouthWest().getLongitude());
		LatLng[] latLngs = new LatLng[4];
		latLngs[0]=ne;
		latLngs[1]=se;
		latLngs[2]=sw;
		latLngs[3]=nw;
		Polyline polyline = new Polyline(latLngs, "#ff0000", 2, 1.0);
		return polyline;
	}
		
	/**
	 * JSNI function to get the information about an array of locations
	 * 
	 * @param locations	Array of {@link Placemark} = list of locations
	 * 
	 * @return {@link String} = get 
	 */
	public native static String zoomToBounds(JsArray<Placemark> locations) /*-{
		var infoListHtml = "";
		var b = new $wnd.GLatLngBounds();
		var resultCount = locations.length;
		$wnd.info = new Array(resultCount);
			$wnd.details = new Array(resultCount);
			$wnd.markers = new Array(resultCount);
			$wnd.polylines = new Array(resultCount);
			$wnd.bounds = new Array(resultCount);
			var icons   = new Array(resultCount);
			var latlngs = new Array(resultCount);
			for (var i = 0; i < resultCount; i++) {
			icons[i] = new $wnd.GIcon($wnd.G_DEFAULT_ICON);
			icons[i].image = $wnd.MAPFILES_URL + "marker" + String.fromCharCode(65 + i) + ".png";
			latlngs[i] = new $wnd.GLatLng(locations[i].Point.coordinates[1],locations[i].Point.coordinates[0]);
			$wnd.markers[i] = new $wnd.GMarker(latlngs[i], { icon: icons[i] } );
			var ne = new $wnd.GLatLng(locations[i].ExtendedData.LatLonBox.north, locations[i].ExtendedData.LatLonBox.east);
				var se = new $wnd.GLatLng(locations[i].ExtendedData.LatLonBox.south, locations[i].ExtendedData.LatLonBox.east);
				var sw = new $wnd.GLatLng(locations[i].ExtendedData.LatLonBox.south, locations[i].ExtendedData.LatLonBox.west);
				var nw = new $wnd.GLatLng(locations[i].ExtendedData.LatLonBox.north, locations[i].ExtendedData.LatLonBox.west);  
			$wnd.polylines[i] = new $wnd.GPolyline([ne, se, sw, nw, ne], '#ff0000', 2, 1.0);
			var ne = new $wnd.GLatLng(locations[i].ExtendedData.LatLonBox.north, locations[i].ExtendedData.LatLonBox.east);
				var sw = new $wnd.GLatLng(locations[i].ExtendedData.LatLonBox.south, locations[i].ExtendedData.LatLonBox.west);
			$wnd.bounds[i] = new $wnd.GLatLngBounds(sw, ne);
			var tr = function(key, value) {
					return '<tr><td style="text-align: right; font-weight: bold; vertical-align: top; white-space: nowrap;">' + key + ':</td><td>' + value + '</td></tr>';
			};
			var latlngtxt = function(coordinates) {
				return '(' + coordinates[1] + ', ' + coordinates[0] + ')';
			};
			var boundstxt = function(latlonbox) {
				return latlngtxt([latlonbox.west, latlonbox.south]) + ' - ' + latlngtxt([latlonbox.east, latlonbox.north]);
			};
			var accuracytxt = function(accuracy) {
				return accuracy + ' - ' + $wnd.GGeoAddressAccuracy[accuracy];
			};
			var getInfoHtml = function(placemark) {
					var html  = '<table class="tabContent">';
	  			html += tr('Address', placemark.address);
	  			html += tr('Coordinates', latlngtxt(placemark.Point.coordinates));
	  			html += tr('Bounds', boundstxt(placemark.ExtendedData.LatLonBox));
	  			html += tr('Accuracy', accuracytxt(placemark.AddressDetails.Accuracy));
	  			html += '</table>';
					return html;
			};
		  	$wnd.info[i] = getInfoHtml(locations[i]);		  	
		  	var getAddressDetailDt = function(feature) {
		  		var html = '';
					for (var key in feature) {
						if (typeof feature[key]=="array") {
						if (key!="0") html += tr(key, feature[key][0]);
					} else if (typeof feature[key]=="object") {
						if (key!="0") html += getAddressDetailDt(feature[key]);
					} else {
						if (key!="0") html += tr(key, feature[key]);
					}
					}
					return html;
			};		  	
		  	$wnd.details[i] = '<table class="tabContent">' + getAddressDetailDt(locations[i].AddressDetails) + '</table>';
		  	var getInfoListItem = function(i, iconUrl, info) {
		  		var html  = '';
	  			html += '<div class="info" id="p' + i + '">';
	  			html += '<table><tr valign="top">';
	  			html += '<td style="padding: 2px"><a onclick="javascript: selectMarker(' + i + ')" style="cursor:pointer;"><img src="' + iconUrl + '" border="0"/></a></td>';
	  			html += '<td style="padding: 2px">' + info + '</td>';
	  			html += '</tr></table>';
	  			html += '</div>';
					return html;	
			};
			infoListHtml += getInfoListItem(i, icons[i].image, $wnd.info[i]);
			}
			for (var i = 0; i < $wnd.markers.length; i++) {
		  	b.extend($wnd.bounds[i].getSouthWest());
		  	b.extend($wnd.bounds[i].getNorthEast());
		    $wnd.mapOne.addOverlay($wnd.markers[i]);
		    var addInfoWindowListener = function(i, marker, details) {
		    	$wnd.GEvent.addListener(marker, "click", function() {
					if ($wnd.selected != null) {
	  					$doc.getElementById('p' + $wnd.selected).style.backgroundColor = "white";
	  					$wnd.mapOne.removeOverlay($wnd.polylines[$wnd.selected]);
					}
					marker.openInfoWindowHtml(details);
					if (! $wnd.mapOne.getBounds().containsBounds($wnd.bounds[i])) {
	  					$wnd.mapOne.zoomOut();
	  					$wnd.mapOne.panTo($wnd.bounds[i].getCenter());
					}
					$wnd.mapOne.addOverlay($wnd.polylines[i]);
					$doc.getElementById('p' + i).style.backgroundColor = "#eeeeff";
					$doc.getElementById('matches').scrollTop = $doc.getElementById('p' + i).offsetTop - $doc.getElementById('matches').offsetTop;
					$wnd.selected = i;
					});
			};
		    addInfoWindowListener(i, $wnd.markers[i], $wnd.details[i]);		    
		  }
		  var center = b.getCenter();
		  var zoom   = $wnd.mapOne.getBoundsZoomLevel(b);
		  $wnd.mapOne.setCenter(center, zoom);	
		  return infoListHtml;	  
	}-*/;

	/**
	 * Initialize mapstraction map
	 * 
	 * @param api	{@link String} = the map's type
	 */
	private native void mxnMakeMap(Element element, String api) /*-{
		// initialise the map with your choice of API
		if ($wnd.mapstraction==null) {
			$wnd.mapstraction = new $wnd.mxn.Mapstraction(element,api);
			$wnd.mapstraction.addControls({pan: true,zoom: 'small', map_type: true});
		}
        $wnd.mapstraction.setCenterAndZoom(new $wnd.mxn.LatLonPoint(0, 0),5);
        $wnd.mapstraction.setBounds(new $wnd.mxn.BoundingBox(31.694376,-21.595547,72.299844,33.951328));
        $wnd.mapstraction.setZoom(3);
	}-*/;
	
	/**
	 * Create the google map
	 * 
	 * @param mapsDiv	{@link Element} = the div that con
	 * @param north		{@link Element} = north text box
	 * @param east		{@link Element} = east text box
	 * @param south		{@link Element} = south text box
	 * @param west		{@link Element} = west text box
	 * @param query		{@link String} = the geocode address
	 */
	private native void nativeMakeMap(Element mapsDiv, Element north, Element east, Element south, Element west, Element query) /*-{
    	var mapOptions = new Object();
    	mapOptions.size = new $wnd.GSize(500,350);
    	$wnd.mapOne = new $wnd.GMap2(mapsDiv, mapOptions);
    	$wnd.mapOne.setCenter(new $wnd.GLatLng(0.0, 0.0), 1);
    	$wnd.mapOne.setUIToDefault();
    	$wnd.mapOne.addControl(new $wnd.GLargeMapControl());
    	var that = this; 
		$wnd.GEvent.addListener($wnd.mapOne, "click", function(overlay, latlng) {
			if (! overlay) {
        		query.value = latlng.toUrlValue(6);
        		that.@eu.europa.ec.jrc.euosme.gwt.client.iso19115.ui.TabGeographic::runQuery()();        		
      		}
      		var bounds = $wnd.mapOne.getBounds();
  			var ne = bounds.getNorthEast();
  			var sw = bounds.getSouthWest();
  			var myNorth = ne.lat();
  			var myEast = ne.lng();
			var mySouth = sw.lat();
			var myWest = sw.lng();
			try {
	 			north.value = myNorth;
	 			east.value = myEast;
	 			south.value = mySouth;
	 			west.value = myWest;
	 		}
	 		catch(ex) {	}
    	});    	
	}-*/;

	/**
	 * Show the response of the geocode query
	 * 
	 * @param locations	{@link Placemark} = collection of locations
	 * @param reverse	{@link Boolean} = true to reverse the geocode
	 */
	protected static void responseGeocode(JsArray<Placemark> locations, boolean reverse) {
		Document.get().getElementById("matchCount").setInnerHTML(new Integer(locations.length()).toString());
		Document.get().getElementById("responseCount").getStyle().setDisplay(Display.BLOCK);
	    //if (! reverse) {
	    String infoListHtml = zoomToBounds(locations);
	    //}
	    Document.get().getElementById("matches").setInnerHTML(infoListHtml);
	    Document.get().getElementById("p0").getStyle().setBorderStyle(BorderStyle.NONE);
	    Document.get().getElementById("matches").getStyle().setDisplay(Display.BLOCK);
		startupMap();			
	    if (reverse) {
	    	//map.panTo(latlng);
	    	//map.addOverlay(new Marker(latlng));//, { 'icon': reverseIcon })); 
	    }
	}
	
	/**
	 * When the user input ENTER key, the query starts
	 */
	@UiHandler("queryTextBox")
	void onKeyEnterRunQuery(KeyUpEvent event) {
		if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {	
	    	runQuery();	
		}		
	}
	
	/**
	 * Start the geocode query 
	 */
	@UiHandler("queryButton")
	void onClickRunQuery(ClickEvent event) {
		runQuery();
	}
	
	/**
	 * JSNI function to set Bounds on mapstraction map
	 * 
	 * @param swlat	{@link Double} = SW latitude
	 * @param swlon {@link Double} = SW longitude
	 * @param nelat {@link Double} = NE latitude
	 * @param nelon {@link Double} = SW longitude
	 */
	private native void setBoundsMapstraction(double swlat, double swlon, double nelat, double nelon) /*-{
		var bbox = new $wnd.mxn.BoundingBox(swlat,swlon,nelat,nelon);
		$wnd.mapstraction.setBounds(bbox);	
	}-*/;
}