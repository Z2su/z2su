<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
</div>

<!-- ace settings handler -->
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/garam-extra.min.js"></script>



<script type="text/javascript">
	if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts start -->
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/bootbox.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/jquery-cookie/jquery.cookie.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/date-time/locales/bootstrap-datepicker.kr.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/jquery.gritter.min.js"></script>


<script src='<%=request.getContextPath()%>/resources/commons/scripts/index.js' type="text/javascript"></script>
<!-- page specific plugin scripts end -->

<!-- ace scripts -->
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/garam-elements.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/libs/garam-admin-template/1.3.5/dist/js/garam.min.js"></script>

<!-- inline scripts related to this page start -->

<script src="<%=request.getContextPath()%>/resources/commons/scripts/common.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/scripts/garam.garam.js"></script>
<script src="<%=request.getContextPath()%>/resources/commons/scripts/parent.reload.js"></script>
<script src="<%=request.getContextPath()%>/resources/configuration/dataModulesWidgetJson.htm"></script>

<script>
	var fullDate =$('div#Date');
	var hours = $('li#hours');
	var min = $('li#min');
	var sec = $('li#sec');
	
	var intervalFunc=function(){
		var today = new Date();
		let year = today.getFullYear();
		let month = today.getMonth()+1;
		let date = today.getDate();
		let days=["일","월","화","수","목","금","토"];
		let day = days[today.getDay()];
		let hour = "00"+today.getHours();
		let minute = "00"+today.getMinutes();
		let second = "00"+today.getSeconds();

		hour = hour.substring(hour.length-2);
		minute= minute.substring(minute.length-2);
		second= second.substring(second.length-2);
		
		
		
		fullDate.text(year+"년 "+month+"월 "+date+"일 "+day+"요일");
		hours.text(hour);
		min.text(minute);
		sec.text(second);
		
	}
	intervalFunc();
	
	var time = setInterval(intervalFunc,1000)
	
	
	

</script>



</body>
    