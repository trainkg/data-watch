/**
 * data-watch 基础控制
 */
define(['jquery'],function($){
 	var baseCtrl = {};
 	//index page
 	baseCtrl.index = function(){
 		$("#login_form").on('valid.form',function(event){
 			
 		})
 	}
 	function init(key){
 		baseCtrl[key]();
 	}
 	return init;
})