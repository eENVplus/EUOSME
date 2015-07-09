function eu_europa_ec_jrc_euosme_gwt_EUOSMEGWT_JUnit(){
  var $intern_0 = '', $intern_36 = '" for "gwt:onLoadErrorFn"', $intern_34 = '" for "gwt:onPropertyErrorFn"', $intern_21 = '"><\/script>', $intern_10 = '#', $intern_44 = '&', $intern_73 = '.cache.html', $intern_12 = '/', $intern_24 = '//', $intern_61 = '44711A1421DBE3CF182FA46240026178', $intern_63 = '45FFA14815926ED342942EE06EBDA573', $intern_64 = '594F32979B405EE84B7BD8FEB91684F1', $intern_65 = '715720D5972F3BFD638E89865AE2B5A1', $intern_66 = '8C11F479BC648382E38E6B146BEE9C2E', $intern_72 = ':', $intern_28 = '::', $intern_78 = '<script defer="defer">eu_europa_ec_jrc_euosme_gwt_EUOSMEGWT_JUnit.onInjectionDone(\'eu.europa.ec.jrc.euosme.gwt.EUOSMEGWT.JUnit\')<\/script>', $intern_20 = '<script id="', $intern_76 = '<script language="javascript" src="', $intern_31 = '=', $intern_11 = '?', $intern_33 = 'Bad handler "', $intern_67 = 'C78DC3E3A4CEF91F012FE5153F2D25C0', $intern_68 = 'D1DDF0499A40983622C7993C2F293634', $intern_74 = 'DOMContentLoaded', $intern_69 = 'E32E0BB594702A2D452AD84A5F60E961', $intern_70 = 'EEC31B82644D2B6BAB1C9CD4AD40EDA0', $intern_71 = 'FC2B3FF988E58145327488DBA7E546CC', $intern_22 = 'SCRIPT', $intern_47 = 'Unexpected exception in locale detection, using default: ', $intern_46 = '_', $intern_45 = '__gwt_Locale', $intern_19 = '__gwt_marker_eu.europa.ec.jrc.euosme.gwt.EUOSMEGWT.JUnit', $intern_23 = 'base', $intern_15 = 'baseUrl', $intern_4 = 'begin', $intern_3 = 'bootstrap', $intern_14 = 'clear.cache.gif', $intern_30 = 'content', $intern_62 = 'default', $intern_42 = 'en', $intern_9 = 'end', $intern_1 = 'eu.europa.ec.jrc.euosme.gwt.EUOSMEGWT.JUnit', $intern_17 = 'eu.europa.ec.jrc.euosme.gwt.EUOSMEGWT.JUnit.nocache.js', $intern_27 = 'eu.europa.ec.jrc.euosme.gwt.EUOSMEGWT.JUnit::', $intern_55 = 'gecko', $intern_56 = 'gecko1_8', $intern_5 = 'gwt.codesvr=', $intern_6 = 'gwt.hosted=', $intern_7 = 'gwt.hybrid', $intern_35 = 'gwt:onLoadErrorFn', $intern_32 = 'gwt:onPropertyErrorFn', $intern_29 = 'gwt:property', $intern_59 = 'hosted.html?eu_europa_ec_jrc_euosme_gwt_EUOSMEGWT_JUnit', $intern_52 = 'ie10', $intern_54 = 'ie8', $intern_53 = 'ie9', $intern_37 = 'iframe', $intern_13 = 'img', $intern_38 = "javascript:''", $intern_75 = 'js/gwt-openlayers/util.js', $intern_77 = 'js/gwt-openlayers/util.js"><\/script>', $intern_58 = 'loadExternalRefs', $intern_41 = 'locale', $intern_43 = 'locale=', $intern_25 = 'meta', $intern_40 = 'moduleRequested', $intern_8 = 'moduleStartup', $intern_51 = 'msie', $intern_26 = 'name', $intern_39 = 'position:absolute;width:0;height:0;border:none', $intern_50 = 'safari', $intern_16 = 'script', $intern_60 = 'selectingPermutation', $intern_2 = 'startup', $intern_18 = 'undefined', $intern_57 = 'unknown', $intern_48 = 'user.agent', $intern_49 = 'webkit';
  var $wnd = window, $doc = document, $stats = $wnd.__gwtStatsEvent?function(a){
    return $wnd.__gwtStatsEvent(a);
  }
  :null, $sessionId = $wnd.__gwtStatsSessionId?$wnd.__gwtStatsSessionId:null, scriptsDone, loadDone, bodyDone, base = $intern_0, metaProps = {}, values = [], providers = [], answers = [], softPermutationId = 0, onLoadErrorFunc, propertyErrorFunc;
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_3, millis:(new Date).getTime(), type:$intern_4});
  if (!$wnd.__gwt_stylesLoaded) {
    $wnd.__gwt_stylesLoaded = {};
  }
  if (!$wnd.__gwt_scriptsLoaded) {
    $wnd.__gwt_scriptsLoaded = {};
  }
  function isHostedMode(){
    var result = false;
    try {
      var query = $wnd.location.search;
      return (query.indexOf($intern_5) != -1 || (query.indexOf($intern_6) != -1 || $wnd.external && $wnd.external.gwtOnLoad)) && query.indexOf($intern_7) == -1;
    }
     catch (e) {
    }
    isHostedMode = function(){
      return result;
    }
    ;
    return result;
  }

  function maybeStartModule(){
    if (scriptsDone && loadDone) {
      var iframe = $doc.getElementById($intern_1);
      var frameWnd = iframe.contentWindow;
      if (isHostedMode()) {
        frameWnd.__gwt_getProperty = function(name_0){
          return computePropValue(name_0);
        }
        ;
      }
      eu_europa_ec_jrc_euosme_gwt_EUOSMEGWT_JUnit = null;
      frameWnd.gwtOnLoad(onLoadErrorFunc, $intern_1, base, softPermutationId);
      $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_8, millis:(new Date).getTime(), type:$intern_9});
    }
  }

  function computeScriptBase(){
    function getDirectoryOfFile(path){
      var hashIndex = path.lastIndexOf($intern_10);
      if (hashIndex == -1) {
        hashIndex = path.length;
      }
      var queryIndex = path.indexOf($intern_11);
      if (queryIndex == -1) {
        queryIndex = path.length;
      }
      var slashIndex = path.lastIndexOf($intern_12, Math.min(queryIndex, hashIndex));
      return slashIndex >= 0?path.substring(0, slashIndex + 1):$intern_0;
    }

    function ensureAbsoluteUrl(url_0){
      if (url_0.match(/^\w+:\/\//)) {
      }
       else {
        var img = $doc.createElement($intern_13);
        img.src = url_0 + $intern_14;
        url_0 = getDirectoryOfFile(img.src);
      }
      return url_0;
    }

    function tryMetaTag(){
      var metaVal = __gwt_getMetaProperty($intern_15);
      if (metaVal != null) {
        return metaVal;
      }
      return $intern_0;
    }

    function tryNocacheJsTag(){
      var scriptTags = $doc.getElementsByTagName($intern_16);
      for (var i = 0; i < scriptTags.length; ++i) {
        if (scriptTags[i].src.indexOf($intern_17) != -1) {
          return getDirectoryOfFile(scriptTags[i].src);
        }
      }
      return $intern_0;
    }

    function tryMarkerScript(){
      var thisScript;
      if (typeof isBodyLoaded == $intern_18 || !isBodyLoaded()) {
        var markerId = $intern_19;
        var markerScript;
        $doc.write($intern_20 + markerId + $intern_21);
        markerScript = $doc.getElementById(markerId);
        thisScript = markerScript && markerScript.previousSibling;
        while (thisScript && thisScript.tagName != $intern_22) {
          thisScript = thisScript.previousSibling;
        }
        if (markerScript) {
          markerScript.parentNode.removeChild(markerScript);
        }
        if (thisScript && thisScript.src) {
          return getDirectoryOfFile(thisScript.src);
        }
      }
      return $intern_0;
    }

    function tryBaseTag(){
      var baseElements = $doc.getElementsByTagName($intern_23);
      if (baseElements.length > 0) {
        return baseElements[baseElements.length - 1].href;
      }
      return $intern_0;
    }

    function isLocationOk(){
      var loc = $doc.location;
      return loc.href == loc.protocol + $intern_24 + loc.host + loc.pathname + loc.search + loc.hash;
    }

    var tempBase = tryMetaTag();
    if (tempBase == $intern_0) {
      tempBase = tryNocacheJsTag();
    }
    if (tempBase == $intern_0) {
      tempBase = tryMarkerScript();
    }
    if (tempBase == $intern_0) {
      tempBase = tryBaseTag();
    }
    if (tempBase == $intern_0 && isLocationOk()) {
      tempBase = getDirectoryOfFile($doc.location.href);
    }
    tempBase = ensureAbsoluteUrl(tempBase);
    base = tempBase;
    return tempBase;
  }

  function processMetas(){
    var metas = document.getElementsByTagName($intern_25);
    for (var i = 0, n = metas.length; i < n; ++i) {
      var meta = metas[i], name_0 = meta.getAttribute($intern_26), content;
      if (name_0) {
        name_0 = name_0.replace($intern_27, $intern_0);
        if (name_0.indexOf($intern_28) >= 0) {
          continue;
        }
        if (name_0 == $intern_29) {
          content = meta.getAttribute($intern_30);
          if (content) {
            var value_0, eq = content.indexOf($intern_31);
            if (eq >= 0) {
              name_0 = content.substring(0, eq);
              value_0 = content.substring(eq + 1);
            }
             else {
              name_0 = content;
              value_0 = $intern_0;
            }
            metaProps[name_0] = value_0;
          }
        }
         else if (name_0 == $intern_32) {
          content = meta.getAttribute($intern_30);
          if (content) {
            try {
              propertyErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_33 + content + $intern_34);
            }
          }
        }
         else if (name_0 == $intern_35) {
          content = meta.getAttribute($intern_30);
          if (content) {
            try {
              onLoadErrorFunc = eval(content);
            }
             catch (e) {
              alert($intern_33 + content + $intern_36);
            }
          }
        }
      }
    }
  }

  function __gwt_isKnownPropertyValue(propName, propValue){
    return propValue in values[propName];
  }

  function __gwt_getMetaProperty(name_0){
    var value_0 = metaProps[name_0];
    return value_0 == null?null:value_0;
  }

  function unflattenKeylistIntoAnswers(propValArray, value_0){
    var answer = answers;
    for (var i = 0, n = propValArray.length - 1; i < n; ++i) {
      answer = answer[propValArray[i]] || (answer[propValArray[i]] = []);
    }
    answer[propValArray[n]] = value_0;
  }

  function computePropValue(propName){
    var value_0 = providers[propName](), allowedValuesMap = values[propName];
    if (value_0 in allowedValuesMap) {
      return value_0;
    }
    var allowedValuesList = [];
    for (var k in allowedValuesMap) {
      allowedValuesList[allowedValuesMap[k]] = k;
    }
    if (propertyErrorFunc) {
      propertyErrorFunc(propName, allowedValuesList, value_0);
    }
    throw null;
  }

  var frameInjected;
  function maybeInjectFrame(){
    if (!frameInjected) {
      frameInjected = true;
      var iframe = $doc.createElement($intern_37);
      iframe.src = $intern_38;
      iframe.id = $intern_1;
      iframe.style.cssText = $intern_39;
      iframe.tabIndex = -1;
      $doc.body.appendChild(iframe);
      $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_8, millis:(new Date).getTime(), type:$intern_40});
      iframe.contentWindow.location.replace(base + initialHtml);
    }
  }

  providers[$intern_41] = function(){
    var locale = null;
    var rtlocale = $intern_42;
    try {
      if (!locale) {
        var queryParam = location.search;
        var qpStart = queryParam.indexOf($intern_43);
        if (qpStart >= 0) {
          var value_0 = queryParam.substring(qpStart + 7);
          var end = queryParam.indexOf($intern_44, qpStart);
          if (end < 0) {
            end = queryParam.length;
          }
          locale = queryParam.substring(qpStart + 7, end);
        }
      }
      if (!locale) {
        locale = __gwt_getMetaProperty($intern_41);
      }
      if (!locale) {
        locale = $wnd[$intern_45];
      }
      if (locale) {
        rtlocale = locale;
      }
      while (locale && !__gwt_isKnownPropertyValue($intern_41, locale)) {
        var lastIndex = locale.lastIndexOf($intern_46);
        if (lastIndex < 0) {
          locale = null;
          break;
        }
        locale = locale.substring(0, lastIndex);
      }
    }
     catch (e) {
      alert($intern_47 + e);
    }
    $wnd[$intern_45] = rtlocale;
    return locale || $intern_42;
  }
  ;
  values[$intern_41] = {'default':0, en:1};
  providers[$intern_48] = function(){
    var ua = navigator.userAgent.toLowerCase();
    var makeVersion = function(result){
      return parseInt(result[1]) * 1000 + parseInt(result[2]);
    }
    ;
    if (function(){
      return ua.indexOf($intern_49) != -1;
    }
    ())
      return $intern_50;
    if (function(){
      return ua.indexOf($intern_51) != -1 && $doc.documentMode >= 10;
    }
    ())
      return $intern_52;
    if (function(){
      return ua.indexOf($intern_51) != -1 && $doc.documentMode >= 9;
    }
    ())
      return $intern_53;
    if (function(){
      return ua.indexOf($intern_51) != -1 && $doc.documentMode >= 8;
    }
    ())
      return $intern_54;
    if (function(){
      return ua.indexOf($intern_55) != -1;
    }
    ())
      return $intern_56;
    return $intern_57;
  }
  ;
  values[$intern_48] = {gecko1_8:0, ie10:1, ie8:2, ie9:3, safari:4};
  eu_europa_ec_jrc_euosme_gwt_EUOSMEGWT_JUnit.onScriptLoad = function(){
    if (frameInjected) {
      loadDone = true;
      maybeStartModule();
    }
  }
  ;
  eu_europa_ec_jrc_euosme_gwt_EUOSMEGWT_JUnit.onInjectionDone = function(){
    scriptsDone = true;
    $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_58, millis:(new Date).getTime(), type:$intern_9});
    maybeStartModule();
  }
  ;
  processMetas();
  computeScriptBase();
  var strongName;
  var initialHtml;
  if (isHostedMode()) {
    if ($wnd.external && ($wnd.external.initModule && $wnd.external.initModule($intern_1))) {
      $wnd.location.reload();
      return;
    }
    initialHtml = $intern_59;
    strongName = $intern_0;
  }
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_3, millis:(new Date).getTime(), type:$intern_60});
  if (!isHostedMode()) {
    try {
      unflattenKeylistIntoAnswers([$intern_42, $intern_50], $intern_61);
      unflattenKeylistIntoAnswers([$intern_62, $intern_54], $intern_63);
      unflattenKeylistIntoAnswers([$intern_42, $intern_52], $intern_64);
      unflattenKeylistIntoAnswers([$intern_42, $intern_54], $intern_65);
      unflattenKeylistIntoAnswers([$intern_62, $intern_53], $intern_66);
      unflattenKeylistIntoAnswers([$intern_62, $intern_52], $intern_67);
      unflattenKeylistIntoAnswers([$intern_42, $intern_56], $intern_68);
      unflattenKeylistIntoAnswers([$intern_62, $intern_50], $intern_69);
      unflattenKeylistIntoAnswers([$intern_42, $intern_53], $intern_70);
      unflattenKeylistIntoAnswers([$intern_62, $intern_56], $intern_71);
      strongName = answers[computePropValue($intern_41)][computePropValue($intern_48)];
      var idx = strongName.indexOf($intern_72);
      if (idx != -1) {
        softPermutationId = Number(strongName.substring(idx + 1));
        strongName = strongName.substring(0, idx);
      }
      initialHtml = strongName + $intern_73;
    }
     catch (e) {
      return;
    }
  }
  var onBodyDoneTimerId;
  function onBodyDone(){
    if (!bodyDone) {
      bodyDone = true;
      maybeStartModule();
      if ($doc.removeEventListener) {
        $doc.removeEventListener($intern_74, onBodyDone, false);
      }
      if (onBodyDoneTimerId) {
        clearInterval(onBodyDoneTimerId);
      }
    }
  }

  if ($doc.addEventListener) {
    $doc.addEventListener($intern_74, function(){
      maybeInjectFrame();
      onBodyDone();
    }
    , false);
  }
  var onBodyDoneTimerId = setInterval(function(){
    if (/loaded|complete/.test($doc.readyState)) {
      maybeInjectFrame();
      onBodyDone();
    }
  }
  , 50);
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_3, millis:(new Date).getTime(), type:$intern_9});
  $stats && $stats({moduleName:$intern_1, sessionId:$sessionId, subSystem:$intern_2, evtGroup:$intern_58, millis:(new Date).getTime(), type:$intern_4});
  if (!__gwt_scriptsLoaded[$intern_75]) {
    __gwt_scriptsLoaded[$intern_75] = true;
    document.write($intern_76 + base + $intern_77);
  }
  $doc.write($intern_78);
}

eu_europa_ec_jrc_euosme_gwt_EUOSMEGWT_JUnit();
