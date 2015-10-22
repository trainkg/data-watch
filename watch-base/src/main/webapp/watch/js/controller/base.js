/**
 * data-watch 基础控制
 */
define(['jquery','backbone','plugins/bjui/bjui-extends'],function($,Backbone){
 	var baseCtrl = {};
 	//index page
 	baseCtrl.index = function(){
 		$("#login_form").on('valid.form',function(event){
 			var fd = $(this).serializeJson();
 			require(['watchuser/js/login.js'],function(loginModel){
 				var lm = new loginModel(fd);
 				Backbone.sync('create',lm,{
 					success:function(r){
 						if(r.status == '200'){
 							window.location.href = "app";
 						}else{
 							$(document).alertmsg("error",r.message);
 						}
 					}
 				})
 			})
 		})
 	}
 	
 	//machine info
 	baseCtrl.machine = function(){
 		
 		//机器上下文管理
 		var machineContext;
 		
		var webSocket =
	      new WebSocket('ws://localhost/watch/iwatch');
	 
	    webSocket.onerror = function(event) {
	      onError(event)
	    };
	 
	    webSocket.onopen = function(event) {
	      onOpen(event)
	    };
	 
	    webSocket.onmessage = function(event) {
	      onMessage(event)
	    };
	 
	    function onMessage(event) {
	      if(machineContext){
	    	  var info = $.parseJSON(event.data);
	    	  machineContext.addMachinfo(info);
	      }
	    }
	 
	    function onOpen(event) {
	      //document.getElementById('home').innerHTML = '成功链接服务器~';
	    }
	 
	    function onError(event) {
	      alert(event.data?event.data:'服务器已经停止或者链接超时！');
	    }
	 
	    function start() {
	      webSocket.send('hello');
	      return false;
	    }

	    window.onbeforeunload = function(){
	    	webSocket.close();
	    };
 		    
 		require(['watchcore/js/machinInfo.js'],function(Machine){
 			var config = {
 				el:"#machineInfo #home"
 			}
 			machineContext = new Machine(config);
 		})
 	}
 	
 	function init(key){
 		baseCtrl[key]();
 	}
 	return init;
})