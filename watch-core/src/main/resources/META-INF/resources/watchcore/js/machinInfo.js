/**定义机器基本信息页面*/
define(['backbone','underscore','text!watchcore/js/tpl/machinfoA.html','plugins/process/jquery.process'],function(Backbone,_,viewtpl){
	var view = Backbone.View.extend({
		_template:_.template(viewtpl),
		initialize:function(){
			this.beforeRender();
			this.render();
			this.afterRender();
		},
		beforeRender:function(){},
		render:function(){
			var that = this;
			$.when(this.$el.process()).then(function() {
				that.$el.html(that._template());
				that.$el.process('complete')
			});
		},
		afterRender:function(){}
	});
	return view;
})