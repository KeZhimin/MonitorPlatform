$(document).ready(function(){
	
	//监听导航的事件
	$(".nav-href").click(function(){
		var target = $(this).attr('target');
		$.ajax({
			url: "/MonitorPlatform" + target,
			type: 'get',
			dataType: 'html',
			success: function(data){
				$("#content").empty();
				$("#content").append(data);
			}
		});
	});
});