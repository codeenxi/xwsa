(function(f){var d="",e="/static/bui/js";function a(h){if(!/:/.test(h)){return true}}function c(h){if(a(h)){var i=b();return i+"/"+h}return h}function b(){var h=location.href,i;h=h.replace(/\?.*$/,"").replace(/\#.*$/,"");i=h.lastIndexOf("/");return h.substring(0,i)}function g(){var h=f("script"),i="";f.each(h,function(k,j){var l=j.src,m=l.indexOf(e+"/config");if(m!==-1){i=l.substring(0,m);return false}});return c(i)}if(!d){d=g();d=d.replace(/(.*)\/$/,"$1")}BUI.config({alias:{common:d+e+"/common",module:d+e+"/module"}})})(jQuery);
