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
	 * 
	 * 管理所有的面板信息
	 */
	var view = Backbone.View.extend({
		context:{
			//管理所有的机器VIEW infoDetail type:JSON
			item:null
			// 不进行监控的列表： type:array|function
			,extendId:null
		},
		_template:_.template(viewtpl),
		initialize:function(){
			this.beforeRender();
			this._loadInfo();
			this.render();
			this.afterRender();
		},
		beforeRender:function(){},
		render:function(){
			var that = this;
			this.$el.append(new infoDetail().render());
		},
		afterRender:function(){},
		
		/*
		 *添加一个机器到监控页面 
		 */
		addMachinfo:function(machinfo){
			var machinfos = this.getMachInfos();
			
		},
		
		/*
		 * 获取现有的所有的机器信息
		 */
		_getMachInfos:function(){
			
		},
		/*
		 * 根据机器ID删除机器信息
		 */
		removeMachinfo:function(machine_id){
			
		},
		/*
		 * 初始加载系统所有机器信息
		 */
		_loadInfo:function(){
			var ms = this._getMachInfos();
			if(ms){
				this.addMachinfo(ms);
			}
		},
		/*
		 * 刷新指定的机器信息 
		 * machine_id：		机器ID
		 */
		renderMachinfo:function(machine_id){
			
		},
		
		/*
		 * 根据状态抓取系统指定的状态列表的机器信息列表
		 * status：			机器状态 
		 */
		getMachinfo:function(status){
			
		}
	});
	
	
	return view;
})