/**定义机器基本信息页面*/
define(['backbone','underscore',
        'text!watchcore/js/tpl/machinfoA.html',
        'text!watchcore/js/tpl/machinfoDetail.html',
        'plugins/process/jquery.process'],
    /**
     * viewtpl:总页面模板
     * detailtpl：详细信息模板
     */
    function(Backbone,_,viewtpl,detailtpl){
	
	/**
	 * 详细页面信息View
	 */
	var infoDetail = Backbone.View.extend({
		_template:_.template(detailtpl),
		initialize:function(){
			this.beforeRender();
			this.render();
			this.afterRender();
		},
		beforeRender:function(){},
		render:function(){
			return this._template();
		},
		afterRender:function(){}
	});
	
	
	/**
	 * 监控系统总页面
	 */
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
			this.$el.append(new infoDetail().render());
		},
		afterRender:function(){}
	});
	
	
	return view;
})