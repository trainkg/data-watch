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
 						$(document).alertmsg("info",r.message);
 					}
 				})
 			})
 		})
 	}
 	function init(key){
 		baseCtrl[key]();
 	}
 	return init;
})