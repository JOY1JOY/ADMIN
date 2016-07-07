<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>活动信息管理</title>

		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" />
		
		<!-- 日期控件 -->
		<script src="${pageContext.request.contextPath}/resources/js/date-time/moment.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/date-time/daterangepicker.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/date-time/bootstrap-datetimepicker.js"></script>
		
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tag.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/fuelux/fuelux.spinner.js"></script>
		
		<!-- 富文本件编辑器  -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.custom.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.touch-punch.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/markdown/markdown.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/markdown/bootstrap-markdown.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery.hotkeys.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-wysiwyg.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>	
		
		
	</head>
<body>



<!-- 活动信息管理 -->

<div class="main-content-inner">
	<!-- #section:basics/content.breadcrumbs -->
	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
			try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
		</script>

		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-home home-icon"></i>
				<a href="#">首页</a>
			</li>

			<li>
				<a href="${pageContext.request.contextPath}/view/activity/findList">活动管动</a>
			</li>
			<li class="active">编辑活动基本信息 </li>
		</ul><!-- /.breadcrumb -->

		<!-- /section:basics/content.searchbox -->
	</div>

	<!-- /section:basics/content.breadcrumbs -->
	<div class="page-content">
	
		<!-- /section:settings.box -->
		<div class="page-header">
			<h1>
				活动管理
				<small>
					<i class="ace-icon fa fa-angle-double-right"></i>
					编辑活动基本信息
				</small>
			</h1>
		</div><!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
			
				<!-- PAGE CONTENT BEGINS -->

				<div class="row">
					<div class="col-xs-12">

						<div class="clearfix">
							<div class="pull-right tableTools-container"></div>
						</div>

						<form role="form" id="updateForm" class="form-horizontal" action="${pageContext.request.contextPath}/view/activity/update" method="post" enctype="application/x-www-form-urlencoded">
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label no-padding-right">标题</label>
					
								<div class="col-sm-8">  
									<input type="hidden"   name="id" value="${activity.id }">                                                             
									<input type="text" class="col-xs-12" placeholder="name" id="name" name="name" value="${activity.name }">
								</div>
							</div>
					
							<div class="form-group">
								<label for="status" class="col-sm-2 control-label no-padding-right">状态</label>
								<div class="col-sm-3">
									 
									<select class="chosen-select form-control" id="status" data-placeholder="选择一个状态" name="status">
										<c:forEach items="${statusList }" var="tdict">
											<option value="${tdict.dkey }" >${tdict.dvalue }</option>
										</c:forEach>
									</select>				 
									 
									 
								</div>
								<label for="address" class="col-sm-2 control-label no-padding-right">地址</label>
								<div class="col-sm-3">
									<select class="chosen-select form-control" id="address"  data-placeholder="选择地址" name="address">
										<c:forEach items="${addressList }" var="tdict">
											<option value="${tdict.dkey }" >${tdict.dvalue }</option>
										</c:forEach>
									</select> 
								</div>
										
							</div>
							

							
							<div class="form-group">
								<label for="stime" class="col-sm-2 control-label no-padding-right">开始时间</label>
								<div class="col-sm-3">
									<input type="text" class="form-control  timepicker1"  id="stime" name="stime">
								</div>
								<label for="etime" class="col-sm-2 control-label no-padding-right">结束时间</label>
								<div class="col-sm-3">
									<input type="text" class="form-control  timepicker1" id="etime" name="etime">
								</div>			
							</div>	
							
					
							<div class="form-group">
								<label for="type" class="col-sm-2 control-label no-padding-right">类型</label>
								<div class="col-sm-8">
								
									<c:forEach items="${typeList }" var="tdict">
										<c:if test="${fn:contains(activity.type, tdict.dkey)}"> 
											<label >
												<input type="checkbox" class="ace input-lg" name="type" value="${tdict.dkey }" checked="checked">
												<span class="lbl bigger-120"> ${tdict.dvalue } </span>
											</label>												
										</c:if>
										
										<c:if test="${!fn:contains(activity.type, tdict.dkey)}">
											<label >
												<input type="checkbox" class="ace input-lg" name="type" value="${tdict.dkey }" >
												<span class="lbl bigger-120"> ${tdict.dvalue } </span>
											</label>												
										</c:if>													
									</c:forEach>
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="pnum" class="col-sm-2 control-label no-padding-right">参加人数</label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12" placeholder="pnum" id="pnum" name="pnum" value="${activity.pnum}">
								</div>
								
								<label for="fee" class="col-sm-2 control-label no-padding-right">费用</label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12" placeholder="fee" id="fee" name="fee" value="${activity.fee}">
								</div>			
							</div>	
							
							<div class="form-group">
								<label for="joy_fee" class="col-sm-2 control-label no-padding-right">会员费用</label>
								<div class="col-sm-3">
									<input type="text" class="col-sm-12" placeholder="joy_fee" id="joy_fee" name="joy_fee" value="${activity.joy_fee}">
								</div>
								
								<label for="userid" class="col-sm-2 control-label no-padding-right">用户名</label>
								<div class="col-sm-3">
									<input type="text" class="col-sm-12" placeholder="userid" id="userid" name="userid" value="${activity.userid}">
									<input type="text" class="hidden" placeholder="cuid" id="cuid" name="cuid" value="${activity.cuid}">
									<input type="hidden" id="poster1" name="poster"  value="${activity.poster}"/>
									<input type="hidden" id="description" name="description"  value="${activity.poster}"/>
								</div>			
							</div>	
							
							
							<div class="form-group">
								<label for="cdatetime" class="col-sm-2 control-label no-padding-right">创建时间</label>
								<div class="col-sm-3">
									<input type="text" class="form-control  timepicker1" placeholder="cdatetime" id="cdatetime" name="cdatetime" readonly="readonly">
								</div>
								<label for="audi_datetime" class="col-sm-2 control-label no-padding-right">审核时间</label>
								<div class="col-sm-3">
									<input type="text" class="form-control  timepicker1" placeholder="audi_datetime" name ="audi_datetime" id="audi_datetime" readonly="readonly">
								</div>			
							</div>									
							
							<div class="form-group">
								<label for="poster" class="col-sm-2 control-label no-padding-right">图片</label>
								<div class="col-sm-8">
								
									<span class="profile-picture">
										<img id="avatar" class="editable img-responsive" alt="Alex's Avatar" src="${activity.poster}" />
									</span>								
								
								</div>
							</div>									
							
							<div class="form-group">
								<label for="editor1" class="col-sm-2 control-label no-padding-right">描述</label>
								<div class="col-sm-8">
									<div class="wysiwyg-editor" id="editor1" >${activity.description }</div>
								</div>
							</div>			
						
							
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button type="button" class="btn btn-info" id="savebtn">
										<i class="ace-icon fa fa-check bigger-110"></i>
										保存
									</button>

									&nbsp; &nbsp; &nbsp;
									<button type="reset" class="btn" id="backbtn">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										返回
									</button>
								</div>
							</div>									
						</form>

					</div>
				</div>


				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
</div>

 


<!-- 初始化页面上的控件 -->
<script type="text/javascript">
	jQuery(function($) {
		
		$("#savebtn").click(function(){
			var description=$('#editor1').wysiwyg().html();
			$("#description").val(description);
			$("#updateForm").submit();
		});
		
		
		$('#stime').datetimepicker({
			defaultDate:'${activity.stime}',
			format: "YYYY-MM-DD",
			icons: {
				time: 'fa fa-clock-o',
				date: 'fa fa-calendar',
				up: 'fa fa-chevron-up',
				down: 'fa fa-chevron-down',
				previous: 'fa fa-chevron-left',
				next: 'fa fa-chevron-right',
				today: 'fa fa-arrows ',
				clear: 'fa fa-trash',
				close: 'fa fa-times'
			}					
		}).next().on(ace.click_event, function(){
				$(this).prev().focus();
	 	});
		
		$('#etime').datetimepicker({
			defaultDate:'${activity.etime}',
			format: "YYYY-MM-DD",
			icons: {
				time: 'fa fa-clock-o',
				date: 'fa fa-calendar',
				up: 'fa fa-chevron-up',
				down: 'fa fa-chevron-down',
				previous: 'fa fa-chevron-left',
				next: 'fa fa-chevron-right',
				today: 'fa fa-arrows ',
				clear: 'fa fa-trash',
				close: 'fa fa-times'
			}					
		}).next().on(ace.click_event, function(){
				$(this).prev().focus();
	 	});		
		
		$('#cdatetime').datetimepicker({
			defaultDate:'${activity.cdatetime}',
			format: "YYYY-MM-DD HH:mm:ss",
			icons: {
				time: 'fa fa-clock-o',
				date: 'fa fa-calendar',
				up: 'fa fa-chevron-up',
				down: 'fa fa-chevron-down',
				previous: 'fa fa-chevron-left',
				next: 'fa fa-chevron-right',
				today: 'fa fa-arrows ',
				clear: 'fa fa-trash',
				close: 'fa fa-times'
			}					
		}).next().on(ace.click_event, function(){
				$(this).prev().focus();
	 	});
		
		$('#audi_datetime').datetimepicker({
			defaultDate:'${activity.audi_datetime}',
			format: "YYYY-MM-DD HH:mm:ss",
			icons: {
				time: 'fa fa-clock-o',
				date: 'fa fa-calendar',
				up: 'fa fa-chevron-up',
				down: 'fa fa-chevron-down',
				previous: 'fa fa-chevron-left',
				next: 'fa fa-chevron-right',
				today: 'fa fa-arrows ',
				clear: 'fa fa-trash',
				close: 'fa fa-times'
			}					
		}).next().on(ace.click_event, function(){
				$(this).prev().focus();
	 	});		
		
		
		
		//another option is using modals
		$('#avatar').on('click', function(){
			
			var modal = 
				'<div class="modal fade" id="selectImage">\
				  <div class="modal-dialog">\
				   <div class="modal-content">\
					<div class="modal-header">\
						<div class="pull-right onpage-help-modal-buttons">\
							<button type="button" class="btn btn-white btn-danger btn-sm" data-dismiss="modal" aria-hidden="true">\
							<i class="ace-icon fa fa-times icon-only"></i></button>	\
						</div>\
						<h4 class="blue">选择上传图片</h4>\
					</div>\
					\
					<form class="no-margin" action="${pageContext.request.contextPath}/file/uploadFile" method="post"  enctype="multipart/form-data" target="iframeid" >\
					 <div class="modal-body">\
						<div class="space-4"></div>\
						<div style="width:75%;margin-left:12%;"><input type="file" name="file" /></div>\
					 </div>\
					\
					 <div class="modal-footer center">\
						<button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> 保存</button>\
						<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> 返回</button>\
					 </div>\
					</form>\
					<iframe style="width:0px;height: 0px;border: 0px;" id="iframeid" name="iframeid"></iframe>\
				  </div>\
				 </div>\
				</div>';			
		 
			
			var modal = $(modal);
			modal.modal("show").on("hidden", function(){
				modal.remove();
			});
	
			var working = false;
	
			var form = modal.find('form:eq(0)');
			var file = form.find('input[type=file]').eq(0);
			file.ace_file_input({
				style:'well',
				btn_choose:'Click to choose new avatar',
				btn_change:null,
				no_icon:'ace-icon fa fa-picture-o',
				thumbnail:'small',
				before_remove: function() {
					//don't remove/reset files while being uploaded
					return !working;
				},
				allowExt: ['jpg', 'jpeg', 'png', 'gif'],
				allowMime: ['image/jpg', 'image/jpeg', 'image/png', 'image/gif']
			});
			
			
			
		});
		
		$('#fee').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus bigger-110', icon_down:'ace-icon fa fa-minus bigger-110', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
		$('#joy_fee').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus bigger-110', icon_down:'ace-icon fa fa-minus bigger-110', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
		
		upload_callback=function(param1){
			var obj=$.parseJSON(param1); 
			$("#poster1").val(obj.filePath);
			$("#avatar").attr("src",obj.filePath);
			$("#selectImage").modal("hide");
		}
		
		$('#editor1').ace_wysiwyg({
			toolbar:
			[
				'font',
				null,
				'fontSize',
				null,
				{name:'bold', className:'btn-info'},
				{name:'italic', className:'btn-info'},
				{name:'strikethrough', className:'btn-info'},
				{name:'underline', className:'btn-info'},
				null,
				{name:'insertunorderedlist', className:'btn-success'},
				{name:'insertorderedlist', className:'btn-success'},
				{name:'outdent', className:'btn-purple'},
				{name:'indent', className:'btn-purple'},
				null,
				{name:'justifyleft', className:'btn-primary'},
				{name:'justifycenter', className:'btn-primary'},
				{name:'justifyright', className:'btn-primary'},
				{name:'justifyfull', className:'btn-inverse'},
				null,
				{name:'createLink', className:'btn-pink'},
				{name:'unlink', className:'btn-pink'},
				null,
				{name:'insertImage', className:'btn-success'},
				null,
				'foreColor',
				null,
				{name:'undo', className:'btn-grey'},
				{name:'redo', className:'btn-grey'}
			],
			'wysiwyg': {
				fileUploadError: showErrorAlert
			}
		}).prev().addClass('wysiwyg-style1');		
		
		function showErrorAlert (reason, detail) {
			var msg='';
			if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
			else {
				//console.log("error uploading file", reason, detail);
			}
			$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
			 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
		}
		
		$("#address option[value=${activity.address}]").prop("selected",true);
		$("#status option[value=${activity.status}]").prop("selected",true);
		
		
});
</script>

</body>	
</html>

