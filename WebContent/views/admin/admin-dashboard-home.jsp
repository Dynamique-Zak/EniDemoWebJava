<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/views/template/admin-header.jsp" />
			
<!-- Instance un ModelView/Bean -->
<jsp:useBean
	id="adminBean" 
	scope="request"
	class="fr.eni.demo.bean.admin.AdminDashboardBean" 
	>
</jsp:useBean>
 
<!-- Appel la methode render -->
<%= adminBean.render(request) %>
		
<jsp:include page="/views/template/admin-footer.jsp" />