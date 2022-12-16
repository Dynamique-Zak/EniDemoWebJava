<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="/views/template/page-begin.jsp"></jsp:include>

<h1 class="uk-heading-small">Accueil Note</h1>
<div>
	<form id="form-note" >

		<input type="text" name="title" />

		<input type="button" id="btnSubmit" value="Enregistrer" />
	</form>
</div>


<!-- Import JQUERY -->
<script src="https://code.jquery.com/jquery-3.6.2.min.js"
	integrity="sha256-2krYZKh//PcchRtd+H+VyyQoZ/e3EcrkxhM8ycwASPA="
	crossorigin="anonymous"></script>

<!-- Utiliser du JS /JQUERY	 -->
<script>
// Quand la page est prête (jquery)
$(document).ready(function() {

	$("#btnSubmit").click(function(event) {

		//stop submit the form, we will post it manually.
		//event.preventDefault();
		// Get form
		var form = $('#form-note')[0];
		// FormData object 
		var data = new FormData(form);

		data.append("title", "Faux titre");
		
		// If you want to add an extra field for the FormData
		$.ajax({
			type : "POST",
			enctype : 'application/json',
			url : 'http://localhost:8080/EniDemo/api/rest/article/add',
			data : JSON.stringify({ title : "Test" }),
			processData : false,
			contentType : false,
			cache : false,
			timeout : 800000,
			// Quand ca marche
			success : function(data) {
			},
			// Quand erreur
			error : function(e) {

			}

		});

	});

});
</script>

<jsp:include page="/views/template/page-end.jsp"></jsp:include>
