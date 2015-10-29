/**
 * 登录Model
 */
define(['backbone','underscore'],function(Backbone,_){
	var login = Backbone.Model.extend({
		userName:null,
		password:null,
		url:'datawc/login'
	})
	return login;
})