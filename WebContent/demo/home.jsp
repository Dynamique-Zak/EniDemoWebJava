<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Import -->
<fmt:setLocale value="en" />
<fmt:setBundle basename="fr.eni.demo.i18n.messages" />
 
<jsp:useBean
	id="horloge" 
	scope="request"
	class="fr.eni.demo.bo.Horloge" 
	>
</jsp:useBean>

<jsp:include page="/views/template/page-begin.jsp"></jsp:include>

<h1 class="uk-heading-small">Accueil</h1>

<p>${ horloge.getHour() }</p>
  
<!-- Example traduire message -->
<fmt:message key="welcome" />

<p>
<fmt:message key="welcome.user">
	<fmt:param value="Cintia"></fmt:param>
</fmt:message>
</p>
     
<jsp:include page="/views/template/page-end.jsp"></jsp:include>