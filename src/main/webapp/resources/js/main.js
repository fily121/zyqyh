var Message = function(){
	return {
		//提示消息
		alert:function(msg,fn){
			if(fn){
				$.messager.alert('消息',msg,'',fn);
			}else{
				$.messager.alert('消息',msg);
			}
		},
		
		//消息提示
		info:function(msg,fn){
			if(fn){
				$.messager.alert('消息',msg,'info',fn);
			}else{
				$.messager.alert('消息',msg,'info');
			}
		},
		
		//警告消息
		warn:function(msg,fn){
			if(fn){
				$.messager.alert('警告',msg,'warning',fn);
			}else{
				$.messager.alert('警告',msg,'warning');
			}
		},
		
		//错误消息
		error:function(msg,fn){
			if(fn){
				$.messager.alert('错误',msg,'error',fn);
			}else{
				$.messager.alert('错误',msg,'error');
			}
		},
		
		
		/**
		 * 确认消息
		 * demo:
		 * Message.confirm('yes or no?',function(r){
		 *		if(r){
		 *			Ict.alert('yes');
		 *		}else{
		 *			Ict.alert('no');
		 *		}
		 *	});
		 */
		confirm : function(msg,callback){  
			$.messager.confirm('确认消息', msg, callback);  
		}
	}
}();

$(function(){
	ustc.initTabPanel();
})
var ustc = function(){
	return {
		// 初始化tabpanel
		initTabPanel : function() {
			$('#mainPanel').tabs({
				fit : true,
				border : false,
				onSelect : function(title, index) {
					if (title == '首页') {
						$('#frame' + title).attr('src', '../leftframe/right');
					}
				},
				onContextMenu : function(e, title) {
					// 阻止默认的右键单击行为
					e.preventDefault();
					$('#mainPanel').tabs('select', title);
					$('#mm').menu('show', {
						left : e.pageX,
						top : e.pageY
					});
				}
			});
		},
		//添加Tab
		addTab:function(title,href,iconCls,closable){
			title = title.replace("(", "（");
			title = title.replace(")", "）");
			$.mainPanel = null;
			if (window.top != window.self) {
				$.mainPanel = $('#mainPanel',parent.document);
			}else{
				$.mainPanel = $('#mainPanel');
			}
			var exist = $.mainPanel.tabs('exists',title);
			if(exist){
				$.mainPanel.tabs('select', title);
				$('#frame'+title).attr('src', href);
			}else{
				var content = '<iframe id="frame'+title+'" name="frame'+title+'" scrolling="auto" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';  
				$.mainPanel.tabs('add',{  
		            title:title,  
		            content:content,
		            iconCls:iconCls,
		            closable:closable,
		            tools:[
		            	{
		            		iconCls:'icon-mini-refresh',
		            		handler:function(){
		            			$('#frame'+title).attr('src', href);
		            		}
		           		}
		            ]
		        });  
			}
		},
		
		//取得所有可以关闭的tab
		getClosableTabs :function(){
			var tabs = $('#mainPanel').tabs('tabs');
			var closableTabs = new Array();
			for (var i = 0; i < tabs.length; i++) {
				var panel = tabs[i];
				var closable = panel.panel('options').closable;
				if(closable==true){
					closableTabs.push(i);
				}
			}
			return closableTabs;
		},
		
		//移除可以关闭的所有tab
		removeTabs:function(){
			var closableTabs = this.getClosableTabs();
			if(closableTabs.length>0){
				var tab = closableTabs.shift();
				$('#mainPanel').tabs('close',tab);
				if(closableTabs.length>0){
					this.removeTabs();
				}
			}
		},
		
		//关闭选中标签页
		closeSelectedTab:function(){
			var panel = $('#mainPanel').tabs('getSelected');
			var closable = panel.panel('options').closable;
			var title = panel.panel('options').title;
			if(closable==true){
				$('#mainPanel').tabs('close',title);
			}
		},
		
		//关闭所有标签页
		closeAllTab:function(){
			this.removeTabs();
		},
		
		//关闭除选中之外的所有tab
		removeOtherTab:function(){
			var panel = $('#mainPanel').tabs('getSelected');
			var title = panel.panel('options').title;
			
			var tabs = $('#mainPanel').tabs('tabs');
			var closableTabs = new Array();
			for (var i = 0; i < tabs.length; i++) {
				var p = tabs[i];
				var closable = p.panel('options').closable;
				var tt = p.panel('options').title;
				if(title!=tt && closable==true){
					closableTabs.push(i);
				}
			}
			
			if(closableTabs.length>0){
				var tab = closableTabs.shift();
				$('#mainPanel').tabs('close',tab);
				if(closableTabs.length>0){
					this.removeOtherTab();
				}
			}
		},
		//关闭其他标签
		closeOtherTab:function(){
			this.removeOtherTab();
		},
        
		//右下角滑动提示框
		slideMsg : function(msg,timeout){
            $.messager.show({  
                title:'提示消息',  
                msg:msg, 
                timeout:timeout?timeout:3000,
                showType:'show'  
            });  
        },
        
        //打开窗口（默认使用）
        openWin : function(title,width,height,href){
		   $('#commonWindow').window({
			     title: title,
			     width: width,
			     shadow: false,
			     closed: false,
				 cache:  false,
			     height: height,
				 collapsible:false,
				 minimizable:false,
				 maximizable:false,
				 resizable:false,
				 href:href,
//				 content:content,
				 top:(document.body.clientHeight-height)/2,   
		         left:(document.body.scrollWidth-width)/2,
				 modal:true
			});
		},
		
		//弹出窗口（特殊情况下选择使用）
		openWin2 : function(title,width,height,href){
          var content = '<iframe scrolling="auto" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';  
          parent.$('#commonWindow').window({
			     title: title,
			     width: width,
			     shadow: false,
			     closed: false,
				 cache:  false,
			     height: height,
				 collapsible:false,
				 minimizable:false,
				 maximizable:false,
				 resizable:false,
				 content:content,
				 top:(parent.document.body.clientHeight-height)/2 ,   
		         left:(parent.document.body.scrollWidth-width)/2,
				 modal:true
			});	
		},
		//打开对话框
     
		//关闭窗口
		closeWin : function (){
			$('#commonWindow').window('close');
	 	},
	 	
	 	//关闭弹窗
	 	closeWin2 : function(){
	 		parent.$('#commonWindow').window('close');
	 	},
	 	//图片等比例缩小放大
	 	autoResizeImage:function(maxWidth,maxHeight,objImg){
	 		var img = new Image();
	 		img.src = objImg.src;
	 		setTimeout(function(){
				var width = img.width;
				var height = img.height;
				if(width > maxWidth){
					objImg.width = maxWidth;
					objImg.height = height*maxWidth/width;
				}
			},100);
	 	},
	 	/**
		 * 查看图片
		 * @param value
		 * @returns
		 */
		photo : function(value){
			art.dialog({
				content : '<img src="/mobileImages2/'+value+'"/>',
				width:'auto',
				height:'auto',
				zIndex : "20000",
				left: '15%',
			    top: '15%',
			    lock : true,
			    cancelVal: '关闭',
			    cancel: true
			});
		}
	};
}();