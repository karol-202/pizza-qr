(this["webpackJsonpgrinchs-code-scanner"]=this["webpackJsonpgrinchs-code-scanner"]||[]).push([[0],{21:function(e,n,t){e.exports=t(52)},26:function(e,n,t){},52:function(e,n,t){"use strict";t.r(n);var a=t(1),r=t.n(a),o=t(12),c=t.n(o),s=(t(26),t(13)),i=t(14),l=t(19),h=t(15),d=t(20),u=t(16),p=t.n(u),m=t(18),f=t.n(m),y=function(e){function n(){var e,t;Object(s.a)(this,n);for(var a=arguments.length,r=new Array(a),o=0;o<a;o++)r[o]=arguments[o];return(t=Object(l.a)(this,(e=Object(h.a)(n)).call.apply(e,[this].concat(r)))).state={qrCode:"",response:"Scan QR Code"},t.handleScan=function(e){e&&(t.setState({response:e}),f.a.get("https://pizzaqr.herokuapp.com/api/token/".concat(e)).then((function(e){var n=!0===e.data?"Dobry kod!":"Sorry memory, wykorzystany";t.setState({response:n})})).catch((function(e){t.setState({response:"B\u0142\u0105d"})})))},t.handleError=function(e){console.error(e)},t}return Object(d.a)(n,e),Object(i.a)(n,[{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"qr-reader"},r.a.createElement(p.a,{delay:1e3,onError:this.handleError,onScan:this.handleScan,style:{width:"100%"}}),r.a.createElement("div",{className:"info"},r.a.createElement("span",null,this.state.response))))}}]),n}(a.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));c.a.render(r.a.createElement(y,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[21,1,2]]]);
//# sourceMappingURL=main.eeeb6045.chunk.js.map