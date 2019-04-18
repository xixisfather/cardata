$(function() {
	// 动态树形菜单数据
	var treeData = [
			{
				text : "保司合作分析",
				"iconCls" : "icon-edit",
				children : [
						{
							text : "保费贡献及收益比",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/bshzfx/tobfgxjsybanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "保司效益险种贡献",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "保司推送修满足率",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						} ]

			},
			{
				text : "保险贡献分析",
				"iconCls" : "icon-edit",
				children : [
						{
							text : "保险对回厂贡献",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "保险对回厂频次贡献",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "续保业务分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "售后赋能子险贡献",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						} ]

			},
			{
				text : "售后产值分析",
				"iconCls" : "icon-edit",
				children : [
						{
							text : "售后赋能子险贡献",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "产值构成分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "流失客户专员分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "新增客户渠道分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "事故车毛利率分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						} ]

			},
			{
				text : "客户标签",
				"iconCls" : "icon-edit",
				children : [
						{
							text : "售后赋能子险贡献",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "产值构成分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "流失客户专员分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "新增客户渠道分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						},
						{
							text : "事故车毛利率分析",
							attributes : {
								url : '<iframe width="100%" height="100%" frameborder="0"  src="/shsjanalyse/toshsjanalyse" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
							}
						} ]

			} ];

	// 实例化树形菜单
	$("#tree").tree({
		data : treeData,
		lines : false,
		onClick : function(node) {
			if (node.attributes) {
				Open(node.text, node.attributes.url);
			}
		}
	});
	// 在右边center区域打开菜单，新增tab
	function Open(text, url) {
		if ($("#tabs").tabs('exists', text)) {
			$('#tabs').tabs('select', text);
		} else {
			$('#tabs').tabs('add', {
				title : text,
				closable : true,
				content : url
			});
		}
	}

	// 绑定tabs的右键菜单
	$("#tabs").tabs({
		onContextMenu : function(e, title) {
			e.preventDefault();
			$('#tabsMenu').menu('show', {
				left : e.pageX,
				top : e.pageY
			}).data("tabTitle", title);
		}
	});

	// 实例化menu的onClick事件
	$("#tabsMenu").menu({
		onClick : function(item) {
			CloseTab(this, item.name);
		}
	});

	// 几个关闭事件的实现
	function CloseTab(menu, type) {
		var curTabTitle = $(menu).data("tabTitle");
		var tabs = $("#tabs");

		if (type === "close") {
			tabs.tabs("close", curTabTitle);
			return;
		}

		var allTabs = tabs.tabs("tabs");
		var closeTabsTitle = [];

		$.each(allTabs, function() {
			var opt = $(this).panel("options");
			if (opt.closable && opt.title != curTabTitle && type === "Other") {
				closeTabsTitle.push(opt.title);
			} else if (opt.closable && type === "All") {
				closeTabsTitle.push(opt.title);
			}
		});

		for (var i = 0; i < closeTabsTitle.length; i++) {
			tabs.tabs("close", closeTabsTitle[i]);
		}
	}
});