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
		
		<!-- dataTables 插件 -->
		<script src="${pageContext.request.contextPath}/resources/js/dataTables/jquery.dataTables.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/dataTables/jquery.dataTables.bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/dataTables/extensions/buttons/dataTables.buttons.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/dataTables/extensions/buttons/buttons.flash.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/dataTables/extensions/buttons/buttons.html5.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/dataTables/extensions/buttons/buttons.print.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/dataTables/extensions/buttons/buttons.colVis.js"></script>
		
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
				<a href="${pageContext.request.contextPath}/view/activity/findList">活动管理</a>
			</li>
			<li class="active">活动列表</li>
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
					活动列表
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

						<div>
							<table id="dynamic-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">
											<label class="pos-rel">
												<input type="checkbox" class="ace" />
												<span class="lbl"></span>
											</label>
										</th>
										<th>标题</th>
										<th>状态</th>
										<th class="hidden-480">发布时间</th>

										<th>
											<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
											发布人
										</th>
										<th class="hidden-480">地址</th>

										<th></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${list}" var="activity">
									<tr>
										<td class="center">
											<label class="pos-rel">
												<input type="checkbox" class="ace" value="${activity.id }" />
												<span class="lbl"></span>
											</label>
										</td>

										<td>${activity.name}</td>
										<td>${activity.statusAdmin}</td>
										<td>
											<fmt:formatDate value="${activity.cdatetime}" type="date" dateStyle="full"/>
										</td>
										<td>${activity.userid}</td>
										<td>${activity.address}</td>

										<td>
											<div class="hidden-sm hidden-xs action-buttons">
											
												<a class="blue" href="#">
													<i class="ace-icon fa fa-search-plus bigger-130"></i>
												</a>

												<a class="green" href="${pageContext.request.contextPath}/view/activity/edit.do?id=${activity.id }" >
													<i class="ace-icon fa fa-pencil bigger-130"></i>
												</a>


												<a class="blue tooltip-success pass" href="javascript:void(0);"   data-rel="tooltip" title="审核通过" opid="${activity.id }">
													<i class="ace-icon fa fa-unlock bigger-130"></i>
												</a>													
												
												<a class="green tooltip-error nopass"  href="javascript:void(0);"  data-rel="tooltip" title="审核不通过" opid="${activity.id }">
													<i class="ace-icon fa fa-lock bigger-130"></i>
												</a>

												<a class="red del" href="javascript:void(0);" data-rel="tooltip" title="删除" opid="${activity.id }" >
													<i class="ace-icon fa fa-trash-o bigger-130"></i>
												</a>												
												
																										
												
											</div>

										</td>
									</tr>

									</c:forEach>
								
								</tbody>
							</table>
						</div>
					</div>
				</div>


				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
</div>



<script type="text/javascript">
	jQuery(function($) {
		
		
		$(".del").click(function(){
			var id=$(this).attr("opid");
			$.get("op", { id: id, del:'Y'},function(data){
			   	window.location.href="${pageContext.request.contextPath}/view/activity/findList";
			});
		});
		
		$(".pass").click(function(){
			var id=$(this).attr("opid");
			$.get("op", { id: id,status:1},function(data){
				window.location.href="${pageContext.request.contextPath}/view/activity/findList";
			});
		});
		
		$(".nopass").click(function(){
			var id=$(this).attr("opid");
			$.get("op", { id: id, status:-2},function(data){
				window.location.href="${pageContext.request.contextPath}/view/activity/findList";
			});
		});		
		
		var myTable = 
		$('#dynamic-table')
		//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
		.DataTable( {
			bAutoWidth: false,
			"aoColumns": [
			  { "bSortable": false },
			  null, null,null, null, null,
			  { "bSortable": false }
			],
			"aaSorting": [],
			
			
			//"bProcessing": true,
	        //"bServerSide": true,
	        //"sAjaxSource": "http://127.0.0.1/table.php"	,
	
			//,
			//"sScrollY": "200px",
			//"bPaginate": false,
	
			//"sScrollX": "100%",
			//"sScrollXInner": "120%",
			//"bScrollCollapse": true,
			//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
			//you may want to wrap the table inside a "div.dataTables_borderWrap" element
	
			//"iDisplayLength": 50
	
	
			select: {
				style: 'multi'
			}
	    } );
	
		
		
		$.fn.dataTable.Buttons.swfPath = "${pageContext.request.contextPath}/resources/js/dataTables/extensions/buttons/swf/flashExport.swf"; //in Ace demo ../assets will be replaced by correct assets path
		$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
		
		new $.fn.dataTable.Buttons( myTable, {
			buttons: [
			  {
				"extend": "colvis",
				"text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
				"className": "btn btn-white btn-primary btn-bold",
				columns: ':not(:first):not(:last)'
			  },
			  {
				"extend": "copy",
				"text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "csv",
				"text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "excel",
				"text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "pdf",
				"text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
				"className": "btn btn-white btn-primary btn-bold"
			  },
			  {
				"extend": "print",
				"text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
				"className": "btn btn-white btn-primary btn-bold",
				autoPrint: false,
				message: 'This print was produced using the Print button for DataTables'
			  }		  
			]
		} );
		myTable.buttons().container().appendTo( $('.tableTools-container') );
		
		//style the message box
		var defaultCopyAction = myTable.button(1).action();
		myTable.button(1).action(function (e, dt, button, config) {
			defaultCopyAction(e, dt, button, config);
			$('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
		});
		
		
		var defaultColvisAction = myTable.button(0).action();
		myTable.button(0).action(function (e, dt, button, config) {
			
			defaultColvisAction(e, dt, button, config);
			
			
			if($('.dt-button-collection > .dropdown-menu').length == 0) {
				$('.dt-button-collection')
				.wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
				.find('a').attr('href', '#').wrap("<li />")
			}
			$('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
		});
	
		////
	
		setTimeout(function() {
			$($('.tableTools-container')).find('a.dt-button').each(function() {
				var div = $(this).find(' > div').first();
				if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
				else $(this).tooltip({container: 'body', title: $(this).text()});
			});
		}, 500);
		
		
		myTable.on( 'select', function ( e, dt, type, index ) {
			if ( type === 'row' ) {
				$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', true);
			}
		} );
		myTable.on( 'deselect', function ( e, dt, type, index ) {
			if ( type === 'row' ) {
				$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', false);
			}
		} );
	
	
		/////////////////////////////////
		//table checkboxes
		$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);
		
		//select/deselect all rows according to table header checkbox
		$('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function(){
			var th_checked = this.checked;//checkbox inside "TH" table header
			
			$('#dynamic-table').find('tbody > tr').each(function(){
				var row = this;
				if(th_checked) myTable.row(row).select();
				else  myTable.row(row).deselect();
			});
		});
		
		//select/deselect a row when the checkbox is checked/unchecked
		$('#dynamic-table').on('click', 'td input[type=checkbox]' , function(){
			var row = $(this).closest('tr').get(0);
			if(!this.checked) myTable.row(row).deselect();
			else myTable.row(row).select();
		});
	
	
	
		$(document).on('click', '#dynamic-table .dropdown-toggle', function(e) {
			e.stopImmediatePropagation();
			e.stopPropagation();
			e.preventDefault();
		});
		
		
		
		//And for the first simple table, which doesn't have TableTools or dataTables
		//select/deselect all rows according to table header checkbox
		var active_class = 'active';
		$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
			var th_checked = this.checked;//checkbox inside "TH" table header
			
			$(this).closest('table').find('tbody > tr').each(function(){
				var row = this;
				if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
				else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
			});
		});
		
		//select/deselect a row when the checkbox is checked/unchecked
		$('#simple-table').on('click', 'td input[type=checkbox]' , function(){
			var $row = $(this).closest('tr');
			if(this.checked) $row.addClass(active_class);
			else $row.removeClass(active_class);
		});
	
		
	
		/********************************/
		//add tooltip for small view action buttons in dropdown menu
		$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
		
		//tooltip placement on right or left
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();
	
			var off2 = $source.offset();
			//var w2 = $source.width();
	
			if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
			return 'left';
		}
		
	
	});
	

	
</script>

</body>	
</html>	
    
   