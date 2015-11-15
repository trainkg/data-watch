/**定义机器基本信息页面*/
define(['backbone','underscore',
        'text!watchcore/js/tpl/machinfoA.html',
        'text!watchcore/js/tpl/machinfoDetail.html',
        'text!watchcore/js/tpl/machinfoMin.html',
        'plugins/process/jquery.process'],
        
    /**
     * viewtpl:		总页面模板
     * detailtpl：	详细信息模板
     * deliveryTpl:	机器节点的详细信息页面 
     */
    function(Backbone,_,viewtpl,detailtpl,deliveryTpl){
	
	
	var default_detail_context = {
		//页面信息
		data:null,
		//是否打开了详细信息页面
		delivery:false,
		deliveryView:null,
		//字段数据类型枚举
		types:null
	};
	/**
	 * 详细页面信息View
	 */
	var infoDetail = Backbone.View.extend({
		context:{},
		_template:_.template(detailtpl),
		initialize:function(context){
			this.context = _.extend({},default_detail_context,context);
			
			this.beforeRender();
			this.render();
			this.afterRender();
		},
		events:{
			'click':'openDelivery'
		},
		beforeRender:function(){},
		openDelivery:function(){
			var view = this;
			var $div = $('<div></div');
			$('body').append($div);
			var config = {el:$div,data:view.context.data,types:this.context.types};
			this.context.deliveryView = new machineDelivery(config);
			view.context.delivery = true;
			$div.bind('m-delivery-close',function(){
				view.context.delivery = false;
				view.context.deliveryView = null;
			})
		},
		render:function(){
			this.$el.html(this._template(this.context));
		},
		reRender:function(info){
			if(info){
				this.context.data = info;
				var content = this.render();
				this.$el.html($(content).html());
				if(this.context.delivery){
					this.context.deliveryView.reRender(info);
				}
			}
		},
		afterRender:function(){},
		//获取当前机器状态信息
		getStatus:function(){console.log('status')},
		getData:function(){return this.context.data}
	});
	
	/**
	 * 机器节点的详细信息
	 */
	var machineDelivery = Backbone.View.extend({
		default_config:{vid:'',title:'',data:null},
		context:null,
		_template:_.template(deliveryTpl),
		events:{
			'click .close':'close'
		},
		initialize:function(context){
			this.context = _.extend({},this.default_config,context);
			this.render();
		},
		/**
		 * 计算节点颜色
		 */
		_execTempColor:function(){
			var info = this.context.data;
			for(var i=1; i<=8; i++){
				var tvalue  = info['temper'+i+'value'];
				var tstatue = info['temper'+i+'statue'];
				if(tvalue == 777 || tvalue == 888 || tvalue == 999 || tvalue == 970
				   || tvalue == 990 || tvalue == 988 || tstatue == 2 ){
					info['temp'+i+'color'] = 'red';
				}else if(tstatue == 1 || tstatue == 3){
					info['temp'+i+'color'] = 'yellow';
				}else{
					info['temp'+i+'color'] = 'green';
				}
			}
		},
		render:function(){
			this._execTempColor();
			this.$el.html(this._template(this.context));
			this.$el.find('.modal').show();
		},
		close:function(){
			this.$el.trigger('m-delivery-close');
			this.$el.remove();
		},
		reRender:function(info){
			this.context.data = info;
			this.render();
		}
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
				var $div = $('<div class="m-machinfor-detail col-md-3" ></div>');
				this.$el.append($div);
				var context = {el:$div,data:machinfo,types:this.context.types};
				detail = new infoDetail(context);
				this.context.item[machinfo.machmac] = detail;
				/*var $el = $(detail.render());
				this.$el.append($el);
				detail.setElement($el);*/
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
			var view = this;
			$.when($.getJSON('/watch/machine/list'),
				   $.getJSON('/watch/machine/alarmtypes'),
				   $.getJSON('/watch/machine/opermodes'),
				   $.getJSON('/watch/machine/operstepmodes')).then(function(data,alarmtypes,opermodes,operstepmodes){
			    var types = {
			    	'at':alarmtypes[0],
			    	'opt':opermodes[0],
			    	'set':operstepmodes[0]
			    };
			    view.context.types = types;
				_.each(data[0],function(item){
					view.addMachinfo(item);
				})
				view.renderMachineState();
			})
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
			this._getMachInfos();
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