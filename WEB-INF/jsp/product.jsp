<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<form:form method="POST" action="${pageContext.request.contextPath}/saveproduct" modelAttribute="product" name='frm_input_product' id='frm_input_product'  >
		Product ID : <form:input path="productId" cssClass="form-control inputclass"  />
		Product Type : <form:input path="productType" cssClass="form-control inputclass"  />
		<button type="submit" class="btn btn-info btn-sm toolbargrpright" id="export_btn" ><i class="glyphicon glyphicon-save"></i>Save</button>
	</form:form>