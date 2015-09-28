<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="renderer" content="webkit">
    <title>数据监控平台</title>
    <!-- Bootstrap -->
    <link href="zsq/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	body { padding-top: 70px; }
    	#machineInfo 。pageContent{position: relative;}
    	#runInfo{position: absolute;right: 0;}
    </style>
    <script src="./zsq/r.js"></script>
	<script src="./zsq/base.js"></script>
    <script type="text/javascript">
    	require(['ctrl/base','bootstrap'],function(app){/* app('machine') */})

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
	      console.log(event);
	      document.getElementById('messages').innerHTML
	        += '<br />' + event.data;
	    }
	 
	    function onOpen(event) {
	      document.getElementById('messages').innerHTML
	        = 'Connection established';
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

    </script>
  </head>
  <body>
	<div class="container-fluid">
	  	<nav class="navbar navbar-default navbar-fixed-top">
		  <div class="container-fluid">
		  
	        <div class="navbar-header">
	         <!-- <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-action" aria-expanded="false">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button> -->
	          <a class="navbar-brand" href="javascript:;">数据监控系统</a>
	        </div>
			
	        <div class="collapse navbar-collapse" id="nav-action">
	          <ul class="nav navbar-nav">
	           <!--  <li class="active"><a href="#">Home</a></li>
	           <li><a href="#">Link</a></li>
	           <li><a href="#">Link</a></li> -->
	          </ul>
	        </div>
	      </div>
		</nav>
		<div class="row" id="machineInfo">
			<div class="pageHeader">
				<div></div>
			</div>
			<div class="pageContent">
				 <div id="runInfo">
			  		<button class="btn btn-primary" type="button">
					  运行状态 <span class="badge">4</span>
					</button>
			  		<button class="btn btn-primary" type="button">
					  正常状态 <span class="badge">4</span>
					</button>
					<button class="btn btn-primary" type="button">
					  调试状态 <span class="badge">4</span>
					</button>
					<button class="btn btn-primary" type="button">
					  暂停状态 <span class="badge">4</span>
					</button>	
					<button class="btn btn-primary" type="button">
					  停止状态 <span class="badge">4</span>
					</button>			
			  	</div>
				 <!-- Nav tabs -->
			  <ul class="nav nav-tabs" role="tablist">
			    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">详细页</a></li>
			    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">缩小版</a></li>
			    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">高级版</a></li>
			  </ul>
			
			  <!-- Tab panes -->
			  <div class="tab-content">
			    <div role="tabpanel" class="tab-pane active" id="home">HOME</div>
			    <div role="tabpanel" class="tab-pane" id="profile">.22..</div>
			    <div role="tabpanel" class="tab-pane" id="messages">..22.</div>
			  </div>
			</div>
			<div class="pageFooter">
				<div id="messages"></div>
			</div>
		</div>
	</div>
  </body>
</html>