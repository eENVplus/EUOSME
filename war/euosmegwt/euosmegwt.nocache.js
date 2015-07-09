function euosmegwt(){
  var $wnd_0 = window, $doc_0 = document, $stats = $wnd_0.__gwtStatsEvent?function(a){
    return $wnd_0.__gwtStatsEvent(a);
  }
  :null, $sessionId_0 = $wnd_0.__gwtStatsSessionId?$wnd_0.__gwtStatsSessionId:null, scriptsDone, loadDone, bodyDone, base = '', metaProps = {}, values = [], providers = [], answers = [], softPermutationId = 0, onLoadErrorFunc, propertyErrorFunc;
  $stats && $stats({moduleName:'euosmegwt', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'bootstrap', millis:(new Date).getTime(), type:'begin'});
  if (!$wnd_0.__gwt_stylesLoaded) {
    $wnd_0.__gwt_stylesLoaded = {};
  }
  if (!$wnd_0.__gwt_scriptsLoaded) {
    $wnd_0.__gwt_scriptsLoaded = {};
  }
  function isHostedMode(){
    var result = false;
    try {
      var query = $wnd_0.location.search;
      return (query.indexOf('gwt.codesvr=') != -1 || (query.indexOf('gwt.hosted=') != -1 || $wnd_0.external && $wnd_0.external.gwtOnLoad)) && query.indexOf('gwt.hybrid') == -1;
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
      var iframe = $doc_0.getElementById('euosmegwt');
      var frameWnd = iframe.contentWindow;
      if (isHostedMode()) {
        frameWnd.__gwt_getProperty = function(name_0){
          return computePropValue(name_0);
        }
        ;
      }
      euosmegwt = null;
      frameWnd.gwtOnLoad(onLoadErrorFunc, 'euosmegwt', base, softPermutationId);
      $stats && $stats({moduleName:'euosmegwt', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'moduleStartup', millis:(new Date).getTime(), type:'end'});
    }
  }

  function computeScriptBase(){
    function getDirectoryOfFile(path){
      var hashIndex = path.lastIndexOf('#');
      if (hashIndex == -1) {
        hashIndex = path.length;
      }
      var queryIndex = path.indexOf('?');
      if (queryIndex == -1) {
        queryIndex = path.length;
      }
      var slashIndex = path.lastIndexOf('/', Math.min(queryIndex, hashIndex));
      return slashIndex >= 0?path.substring(0, slashIndex + 1):'';
    }

    function ensureAbsoluteUrl(url_0){
      if (url_0.match(/^\w+:\/\//)) {
      }
       else {
        var img = $doc_0.createElement('img');
        img.src = url_0 + 'clear.cache.gif';
        url_0 = getDirectoryOfFile(img.src);
      }
      return url_0;
    }

    function tryMetaTag(){
      var metaVal = __gwt_getMetaProperty('baseUrl');
      if (metaVal != null) {
        return metaVal;
      }
      return '';
    }

    function tryNocacheJsTag(){
      var scriptTags = $doc_0.getElementsByTagName('script');
      for (var i = 0; i < scriptTags.length; ++i) {
        if (scriptTags[i].src.indexOf('euosmegwt.nocache.js') != -1) {
          return getDirectoryOfFile(scriptTags[i].src);
        }
      }
      return '';
    }

    function tryMarkerScript(){
      var thisScript;
      if (typeof isBodyLoaded == 'undefined' || !isBodyLoaded()) {
        var markerId = '__gwt_marker_euosmegwt';
        var markerScript;
        $doc_0.write('<script id="' + markerId + '"><\/script>');
        markerScript = $doc_0.getElementById(markerId);
        thisScript = markerScript && markerScript.previousSibling;
        while (thisScript && thisScript.tagName != 'SCRIPT') {
          thisScript = thisScript.previousSibling;
        }
        if (markerScript) {
          markerScript.parentNode.removeChild(markerScript);
        }
        if (thisScript && thisScript.src) {
          return getDirectoryOfFile(thisScript.src);
        }
      }
      return '';
    }

    function tryBaseTag(){
      var baseElements = $doc_0.getElementsByTagName('base');
      if (baseElements.length > 0) {
        return baseElements[baseElements.length - 1].href;
      }
      return '';
    }

    function isLocationOk(){
      var loc = $doc_0.location;
      return loc.href == loc.protocol + '//' + loc.host + loc.pathname + loc.search + loc.hash;
    }

    var tempBase = tryMetaTag();
    if (tempBase == '') {
      tempBase = tryNocacheJsTag();
    }
    if (tempBase == '') {
      tempBase = tryMarkerScript();
    }
    if (tempBase == '') {
      tempBase = tryBaseTag();
    }
    if (tempBase == '' && isLocationOk()) {
      tempBase = getDirectoryOfFile($doc_0.location.href);
    }
    tempBase = ensureAbsoluteUrl(tempBase);
    base = tempBase;
    return tempBase;
  }

  function processMetas(){
    var metas = document.getElementsByTagName('meta');
    for (var i = 0, n = metas.length; i < n; ++i) {
      var meta = metas[i], name_0 = meta.getAttribute('name'), content_0;
      if (name_0) {
        name_0 = name_0.replace('euosmegwt::', '');
        if (name_0.indexOf('::') >= 0) {
          continue;
        }
        if (name_0 == 'gwt:property') {
          content_0 = meta.getAttribute('content');
          if (content_0) {
            var value_0, eq = content_0.indexOf('=');
            if (eq >= 0) {
              name_0 = content_0.substring(0, eq);
              value_0 = content_0.substring(eq + 1);
            }
             else {
              name_0 = content_0;
              value_0 = '';
            }
            metaProps[name_0] = value_0;
          }
        }
         else if (name_0 == 'gwt:onPropertyErrorFn') {
          content_0 = meta.getAttribute('content');
          if (content_0) {
            try {
              propertyErrorFunc = eval(content_0);
            }
             catch (e) {
              alert('Bad handler "' + content_0 + '" for "gwt:onPropertyErrorFn"');
            }
          }
        }
         else if (name_0 == 'gwt:onLoadErrorFn') {
          content_0 = meta.getAttribute('content');
          if (content_0) {
            try {
              onLoadErrorFunc = eval(content_0);
            }
             catch (e) {
              alert('Bad handler "' + content_0 + '" for "gwt:onLoadErrorFn"');
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
      var iframe = $doc_0.createElement('iframe');
      iframe.src = "javascript:''";
      iframe.id = 'euosmegwt';
      iframe.style.cssText = 'position:absolute;width:0;height:0;border:none';
      iframe.tabIndex = -1;
      $doc_0.body.appendChild(iframe);
      $stats && $stats({moduleName:'euosmegwt', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'moduleStartup', millis:(new Date).getTime(), type:'moduleRequested'});
      iframe.contentWindow.location.replace(base + initialHtml);
    }
  }

  providers['locale'] = function(){
    var locale = null;
    var rtlocale = 'en';
    try {
      if (!locale) {
        var queryParam = location.search;
        var qpStart = queryParam.indexOf('locale=');
        if (qpStart >= 0) {
          var value_0 = queryParam.substring(qpStart + 7);
          var end = queryParam.indexOf('&', qpStart);
          if (end < 0) {
            end = queryParam.length;
          }
          locale = queryParam.substring(qpStart + 7, end);
        }
      }
      if (!locale) {
        locale = __gwt_getMetaProperty('locale');
      }
      if (!locale) {
        locale = $wnd_0['__gwt_Locale'];
      }
      if (locale) {
        rtlocale = locale;
      }
      while (locale && !__gwt_isKnownPropertyValue('locale', locale)) {
        var lastIndex = locale.lastIndexOf('_');
        if (lastIndex < 0) {
          locale = null;
          break;
        }
        locale = locale.substring(0, lastIndex);
      }
    }
     catch (e) {
      alert('Unexpected exception in locale detection, using default: ' + e);
    }
    $wnd_0['__gwt_Locale'] = rtlocale;
    return locale || 'en';
  }
  ;
  values['locale'] = {bg:0, cs:1, da:2, de:3, 'default':4, el:5, en:6, es:7, fr:8, hu:9, it:10, nl:11, pl:12, pt:13, sk:14, sl:15, sv:16};
  providers['user.agent'] = function(){
    var ua = navigator.userAgent.toLowerCase();
    var makeVersion = function(result){
      return parseInt(result[1]) * 1000 + parseInt(result[2]);
    }
    ;
    if (function(){
      return ua.indexOf('webkit') != -1;
    }
    ())
      return 'safari';
    if (function(){
      return ua.indexOf('msie') != -1 && $doc_0.documentMode >= 10;
    }
    ())
      return 'ie10';
    if (function(){
      return ua.indexOf('msie') != -1 && $doc_0.documentMode >= 9;
    }
    ())
      return 'ie9';
    if (function(){
      return ua.indexOf('msie') != -1 && $doc_0.documentMode >= 8;
    }
    ())
      return 'ie8';
    if (function(){
      return ua.indexOf('gecko') != -1;
    }
    ())
      return 'gecko1_8';
    return 'unknown';
  }
  ;
  values['user.agent'] = {gecko1_8:0, ie10:1, ie8:2, ie9:3, safari:4};
  euosmegwt.onScriptLoad = function(){
    if (frameInjected) {
      loadDone = true;
      maybeStartModule();
    }
  }
  ;
  euosmegwt.onInjectionDone = function(){
    scriptsDone = true;
    $stats && $stats({moduleName:'euosmegwt', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'loadExternalRefs', millis:(new Date).getTime(), type:'end'});
    maybeStartModule();
  }
  ;
  processMetas();
  computeScriptBase();
  var strongName;
  var initialHtml;
  if (isHostedMode()) {
    if ($wnd_0.external && ($wnd_0.external.initModule && $wnd_0.external.initModule('euosmegwt'))) {
      $wnd_0.location.reload();
      return;
    }
    initialHtml = 'hosted.html?euosmegwt';
    strongName = '';
  }
  $stats && $stats({moduleName:'euosmegwt', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'bootstrap', millis:(new Date).getTime(), type:'selectingPermutation'});
  if (!isHostedMode()) {
    try {
      unflattenKeylistIntoAnswers(['nl', 'gecko1_8'], '020882AC91C588C9AACA00D9CBFB8A8D');
      unflattenKeylistIntoAnswers(['sv', 'gecko1_8'], '024A69278DED64FFDB0DEE893DAC4AA0');
      unflattenKeylistIntoAnswers(['cs', 'ie10'], '030FAE8B05B4E058F729BFF656C2ADEE');
      unflattenKeylistIntoAnswers(['el', 'ie9'], '046BD894CDFEE949F0A84C91273E7F43');
      unflattenKeylistIntoAnswers(['default', 'ie10'], '0A2152A40589D54CDC4BB0BD326BA752');
      unflattenKeylistIntoAnswers(['pl', 'gecko1_8'], '0B3A95A40C590ACB05F69BBA7A032796');
      unflattenKeylistIntoAnswers(['el', 'ie10'], '0BE715FC7C5C0DE36AADFA639C985083');
      unflattenKeylistIntoAnswers(['nl', 'ie8'], '1050F43D6DAB2A834FE6A0F8A2F2D219');
      unflattenKeylistIntoAnswers(['bg', 'ie9'], '129A6213CEDC3F87A025B92CD1DE7C4F');
      unflattenKeylistIntoAnswers(['cs', 'gecko1_8'], '1518DC3CE8E107F105B13F7F8CD0610B');
      unflattenKeylistIntoAnswers(['sk', 'gecko1_8'], '15ABB1DC41DDF0D95778D87F22FEF4D4');
      unflattenKeylistIntoAnswers(['it', 'gecko1_8'], '191281C206109B0E410B3F9915946163');
      unflattenKeylistIntoAnswers(['en', 'ie9'], '1D6F5D3224E0D7C1232D974B825E644C');
      unflattenKeylistIntoAnswers(['de', 'safari'], '1DB02CA6C94C6F26CCDD7F0A4D66270A');
      unflattenKeylistIntoAnswers(['el', 'ie8'], '1EFA9ED49E18E34A113986131FF174F0');
      unflattenKeylistIntoAnswers(['en', 'gecko1_8'], '2046CA6618B1B48399222B9B62F928F8');
      unflattenKeylistIntoAnswers(['de', 'ie8'], '2304F6AAA2D5A30BB6843915FD95501A');
      unflattenKeylistIntoAnswers(['da', 'gecko1_8'], '25F4D1532F14AE3363B3412C0A88CAA8');
      unflattenKeylistIntoAnswers(['hu', 'ie9'], '2CD57261A08E7F19D0267BF49237DB60');
      unflattenKeylistIntoAnswers(['pt', 'ie8'], '2DD8BE4FD37FC09D8C3F471ED65ADE43');
      unflattenKeylistIntoAnswers(['default', 'ie8'], '2E9AFD4864097FE558A44ACE69BD7D38');
      unflattenKeylistIntoAnswers(['sv', 'ie10'], '2F6962D47DF2B570FB6E79DEFD90AD9C');
      unflattenKeylistIntoAnswers(['de', 'ie9'], '323EE1F1175A3DC4C2A664BE1506C231');
      unflattenKeylistIntoAnswers(['sv', 'ie8'], '37D31209945309E16C3CB18AFD6E6E5B');
      unflattenKeylistIntoAnswers(['pt', 'gecko1_8'], '395C299808838C18312B994306CBEB52');
      unflattenKeylistIntoAnswers(['sk', 'ie9'], '3FDC5E96B8B8D55A5968A66D2DCACFB5');
      unflattenKeylistIntoAnswers(['sk', 'safari'], '40D1BBB8BCCF93C43444CBB3C9D0110E');
      unflattenKeylistIntoAnswers(['default', 'safari'], '44492774359DD0C9B1E2111F1388F79F');
      unflattenKeylistIntoAnswers(['sl', 'ie8'], '46E662D479DBBABB2A694C55C4FEDCC5');
      unflattenKeylistIntoAnswers(['es', 'ie10'], '484C1EE93F9266198A5953DB88A119A1');
      unflattenKeylistIntoAnswers(['es', 'ie8'], '49267A34D8433606383CF4FA4A5B07B4');
      unflattenKeylistIntoAnswers(['it', 'ie10'], '49C60019AAA96AB9D849BDF4A2AF0421');
      unflattenKeylistIntoAnswers(['sl', 'gecko1_8'], '4B2F1D84DD60544767A39D460B97D74D');
      unflattenKeylistIntoAnswers(['en', 'safari'], '4C28D2B572A4159F8C51995A5CF790AC');
      unflattenKeylistIntoAnswers(['bg', 'ie8'], '4D3E78394A2B26CFF066D34E99DABE89');
      unflattenKeylistIntoAnswers(['it', 'ie8'], '5028F46E2F6765B7D054FD922F8CEDD7');
      unflattenKeylistIntoAnswers(['hu', 'ie10'], '528CDC9B0B99B62B11839BFCBB180729');
      unflattenKeylistIntoAnswers(['it', 'safari'], '53FFADE36B9403A47017DC5CB6DCFAF6');
      unflattenKeylistIntoAnswers(['es', 'gecko1_8'], '56B6A043C8FDF6C29DA2EAA609ABDCB2');
      unflattenKeylistIntoAnswers(['hu', 'gecko1_8'], '594A3DE3189DF7164B5CE2407F716828');
      unflattenKeylistIntoAnswers(['hu', 'ie8'], '59BC276878632706B127A6EA8ABDBCC5');
      unflattenKeylistIntoAnswers(['el', 'gecko1_8'], '5D4C2F197B6AD16996E3B7A604534119');
      unflattenKeylistIntoAnswers(['da', 'ie9'], '66D06BD7AFF24CE3F4B1E801026CE486');
      unflattenKeylistIntoAnswers(['hu', 'safari'], '6798EFAF2C8BE4120C028CDEA77C8A10');
      unflattenKeylistIntoAnswers(['es', 'ie9'], '73EBF040CA9B93AE8FE369817ACB40BC');
      unflattenKeylistIntoAnswers(['nl', 'ie9'], '75102DC2F61938B0391005D0D42FF8B7');
      unflattenKeylistIntoAnswers(['fr', 'ie10'], '7964C4CB938023F84BA3C51605B7C9DE');
      unflattenKeylistIntoAnswers(['fr', 'gecko1_8'], '7D99D645DEB82CD0AD0EE433BC88F26F');
      unflattenKeylistIntoAnswers(['cs', 'ie9'], '7E7C541B8538D855172E50E55AD3E289');
      unflattenKeylistIntoAnswers(['fr', 'ie8'], '812ACE0816143B58175B0FC97F98EF2A');
      unflattenKeylistIntoAnswers(['sv', 'ie9'], '88551C17B5E444EAECDA0E08868A2315');
      unflattenKeylistIntoAnswers(['bg', 'ie10'], '91A13F05CDF5686DB1B70F095302EB80');
      unflattenKeylistIntoAnswers(['sk', 'ie8'], '947C1139FAAC604AA3A2058BA4976DF2');
      unflattenKeylistIntoAnswers(['bg', 'gecko1_8'], '95D86528A5C328E10FD03B319556E701');
      unflattenKeylistIntoAnswers(['sv', 'safari'], '96BD1F4FA156F75E3F53CDDB078096AE');
      unflattenKeylistIntoAnswers(['es', 'safari'], '997955A38666BEDB510FDB48A3C970DE');
      unflattenKeylistIntoAnswers(['da', 'ie10'], '9A09E1903A26A48CFBA3466615A542AA');
      unflattenKeylistIntoAnswers(['sl', 'ie9'], 'A28FF1334DD8B68249C2C1F7692F743B');
      unflattenKeylistIntoAnswers(['bg', 'safari'], 'A6B82893F46FC9BBD61EF0668C00E67F');
      unflattenKeylistIntoAnswers(['cs', 'safari'], 'A6DF8EEE1AF10B2CE18D8951CB5FFAE3');
      unflattenKeylistIntoAnswers(['sl', 'safari'], 'ABF8FDA9974FB6F7D7E28E3D1C82CDB7');
      unflattenKeylistIntoAnswers(['pl', 'ie8'], 'AE67C7B96D2CC07A3580E5C679E72D8E');
      unflattenKeylistIntoAnswers(['da', 'safari'], 'AE6D341D520EDEABA963A72C459858C3');
      unflattenKeylistIntoAnswers(['pl', 'ie10'], 'AE76C7583E876DDDE0DF2B5D353D30B8');
      unflattenKeylistIntoAnswers(['el', 'safari'], 'AF0E24242348B6E6FEB7FD1F835B462E');
      unflattenKeylistIntoAnswers(['it', 'ie9'], 'AF25168B0CB76CA42671DB5209EEF1ED');
      unflattenKeylistIntoAnswers(['fr', 'safari'], 'AF70D97F5B5BE1217AB37A653176B48B');
      unflattenKeylistIntoAnswers(['sk', 'ie10'], 'B495D08321BA0AC3D5550E705382BE0A');
      unflattenKeylistIntoAnswers(['cs', 'ie8'], 'B70D603503C2C0FEA67C2106C6C712C2');
      unflattenKeylistIntoAnswers(['pt', 'safari'], 'BA25F32B3B52226037FD8AB3465672C2');
      unflattenKeylistIntoAnswers(['de', 'gecko1_8'], 'C05FB7103BE40AA0CEAED8CE48341DA5');
      unflattenKeylistIntoAnswers(['de', 'ie10'], 'C59027925833D83EEA00DAEF6FC2DBF1');
      unflattenKeylistIntoAnswers(['default', 'gecko1_8'], 'D3BCC54045FD2246AAC59B63F84BF1D8');
      unflattenKeylistIntoAnswers(['en', 'ie10'], 'D9DCB2A984785BA566951911EFF89813');
      unflattenKeylistIntoAnswers(['pl', 'ie9'], 'DA072697295D94096A9492F7F3DE1D22');
      unflattenKeylistIntoAnswers(['nl', 'ie10'], 'E27183D0CFD5C1552F2156F062203EEE');
      unflattenKeylistIntoAnswers(['pl', 'safari'], 'E594CB5BFD4B60FD1093839BD87E19BD');
      unflattenKeylistIntoAnswers(['pt', 'ie9'], 'E6E47FEFFBDB9B08F237AFD6575A8AFE');
      unflattenKeylistIntoAnswers(['sl', 'ie10'], 'E91170E76207DFCD008C6EC460AAB079');
      unflattenKeylistIntoAnswers(['da', 'ie8'], 'F2632F19DDE207FB7A5B87935F923F47');
      unflattenKeylistIntoAnswers(['nl', 'safari'], 'F395FABAED192A0CB192F81961D2FEA1');
      unflattenKeylistIntoAnswers(['fr', 'ie9'], 'F3BA6E27FBD5F1E3A8A8DFC09776171B');
      unflattenKeylistIntoAnswers(['default', 'ie9'], 'F5AB8DCFB14E046CE7EDC61F6F958178');
      unflattenKeylistIntoAnswers(['pt', 'ie10'], 'F615A5CF34EF6DD861A37D9D6B25B87E');
      unflattenKeylistIntoAnswers(['en', 'ie8'], 'F7F9B041DD9F264FDE6B5D4DAA437D9E');
      strongName = answers[computePropValue('locale')][computePropValue('user.agent')];
      var idx = strongName.indexOf(':');
      if (idx != -1) {
        softPermutationId = Number(strongName.substring(idx + 1));
        strongName = strongName.substring(0, idx);
      }
      initialHtml = strongName + '.cache.html';
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
      if ($doc_0.removeEventListener) {
        $doc_0.removeEventListener('DOMContentLoaded', onBodyDone, false);
      }
      if (onBodyDoneTimerId) {
        clearInterval(onBodyDoneTimerId);
      }
    }
  }

  if ($doc_0.addEventListener) {
    $doc_0.addEventListener('DOMContentLoaded', function(){
      maybeInjectFrame();
      onBodyDone();
    }
    , false);
  }
  var onBodyDoneTimerId = setInterval(function(){
    if (/loaded|complete/.test($doc_0.readyState)) {
      maybeInjectFrame();
      onBodyDone();
    }
  }
  , 50);
  $stats && $stats({moduleName:'euosmegwt', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'bootstrap', millis:(new Date).getTime(), type:'end'});
  $stats && $stats({moduleName:'euosmegwt', sessionId:$sessionId_0, subSystem:'startup', evtGroup:'loadExternalRefs', millis:(new Date).getTime(), type:'begin'});
  if (!__gwt_scriptsLoaded['js/gwt-openlayers/util.js']) {
    __gwt_scriptsLoaded['js/gwt-openlayers/util.js'] = true;
    document.write('<script language="javascript" src="' + base + 'js/gwt-openlayers/util.js"><\/script>');
  }
  $doc_0.write('<script defer="defer">euosmegwt.onInjectionDone(\'euosmegwt\')<\/script>');
}

euosmegwt();
