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
	
	
	var default_detail_context = {
		//页面信息
		data:null
	};
	/**
	 * 详细页面信息View
	 */
	var infoDetail = Backbone.View.extend({
		context:{},
		_template:_.template(detailtpl),
		initialize:function(info){
			this.context = _.extend({},default_detail_context,{data:info});
			
			this.beforeRender();
			this.render();
			this.afterRender();
		},
		beforeRender:function(){},
		render:function(){
			return this._template(this.context);
		},
		reRender:function(info){
			if(info){
				this.context.data = info;
				var content = this.render();
				this.$el.html($(content).html());
			}
		},
		afterRender:function(){},
		//获取当前机器状态信息
		getStatus:function(){},
		getData:function(){return this.context.data}
	});
	
	
	var view_default_prop = {
		//管理所有的机器VIEW infoDetail type:JSON
		item:{}
		// 不进行监控的列表： type:array|function
		,excludeId:[]
	};

	/**
	 * 监控系统总页面
	 * 
	 * 管理所有的面板信息
	 */
	var view = Backbone.View.extend({
		context:{},
		_template:_.template(viewtpl),
		initialize:function(context){
			this.context = _.extend({},view_default_prop,context);
			this._loadInfo();
			this.render();
			this.afterRender();
		},
		render:function(){
			var that = this;
		},
		
		afterRender:function(){},
		/*
		 *添加一个机器到监控页面 
		 */
		addMachinfo:function(machinfo,updateStatue){
			var detail = this._isExist(machinfo);
			if(detail){
				detail.reRender(machinfo);
			}else{
				detail = new infoDetail(machinfo);
				this.context.item[machinfo.machmac] = detail;
				var $el = $(detail.render());
				this.$el.append($el);
				detail.setElement($el);
			}
			if(updateStatue){
				this.renderMachineState();
			}
		},
		/*
		 * 判断机器定义是否已经存在
		 * R:infoDetail 
		 */
		_isExist:function(machinfo){
			return this.context.item[machinfo.machmac];
		},
		/*
		 * 获取现有的所有的机器信息
		 * R:Array
		 */
		_getMachInfos:function(){
			
		},
		/*
		 * 根据机器ID删除机器信息
		 */
		removeMachinfo:function(machine_id){
			var r = [];
			_.each(this.context.item,function(){
				
			});
		},
		/*
		 * 初始加载系统所有机器信息
		 */
		_loadInfo:function(){
			var ms = this._getMachInfos();
			if(ms){
				for(var machine in ms){
					this.addMachinfo(machine);
				}
				this.renderMachineState();
			}
		},
		/*
		 * 刷新指定的机器信息 
		 * machine_id：		机器ID
		 */
		renderMachinfo:function(machine_id){
			var machine = this.context.item(machine_id);
			if(machine){
				machine.reRender();
			}
		},
		
		/*
		 * 根据状态抓取系统指定的状态列表的机器信息列表
		 * status：			机器状态 
		 * R:Array
		 */
		getMachinfo:function(status){
			var arr = [];
			_.each(this.context.item, function(element, index, list){
				if(element.getData().msgtype == status){
					arr.push(element);
				}
			});
			return arr;
		},
		
		/*
		 * 根据当前机器信息渲染状态信息
		 */
		renderMachineState:function(){
			var a = [0,1,2];//实时状态
			for (var i = 0; i < a.length; i++) {
				var status = a[i];
				var mlist = this.getMachinfo(status);
				switch (status) {
				case 0:
					$("#stopmc span").text(mlist.length);
					break;
				case 1:
					$("#productmc span").text(mlist.length);
					break;
				case 2:
					$("#warnmc span").text(mlist.length);
					break;
				default:
					break;
				}
			}
		}
	});
	
	
	return view;
})