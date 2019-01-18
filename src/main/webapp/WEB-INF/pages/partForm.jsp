
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Vasili Khalko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Part Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
        .panel-title{
            color: #d1cbbc;
        }

        .btn {
            padding: 2px 2px;
            width: 5em;
            height: 2em;
            background-color: #4d3a1e;
            color: #f1f1f1;
            border-radius: 0;
            transition: .2s;
        }

        .btn:hover, .btn:focus {
            border: 1px solid #4d3a1e;
            background-color: #fff;
            color: #000;
        }
    </style>
</head>
<body class=".container-fluid" style="background-color:whitesmoke">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading" style="background-color:#786455">
            <h3 class="panel-title" style="color: #d1cbbc">
                Part Details
            </h3>
        </div>
        <div class="panel-body">
            <form:form id="partForm" cssClass="form-horizontal" modelAttribute="part" method="post" action="${pageContext.request.contextPath}/savePart">

                <div class="form-group">
                    <div class="control-label col-xs-3"> <form:label path="name" >Name</form:label> </div>
                    <div class="col-xs-6">
                        <form:hidden path="id" value="${partObject.id}"/>
                        <form:input cssClass="form-control" path="name" value="${partObject.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="quantity" cssClass="control-label col-xs-3">Quantity</form:label>
                    <div class="col-xs-6">
                        <form:input cssClass="form-control" path="quantity" value="${partObject.quantity}"/>
                    </div>
                </div>


                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="need">Need?</form:label></div>
                    <div class="col-xs-6">
                        <input type="radio" name="need" value="true" <c:if test="${partObject.need=='true'}">checked</c:if>>True</input>
                        <input type="radio" name="need" value="false" <c:if test="${partObject.need=='false'}">checked</c:if>>False</input>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-4">
                        </div>
                        <div class="col-xs-4">
                            <input type="submit" id="savePart" class="btn btn-primary" value="Save" onclick="return submitPartForm();"/>
                        </div>
                        <div class="col-xs-4">
                        </div>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function submitPartForm() {

// getting the user form values
        var name = $('#name').val().trim();
        var quantity = $('#quantity').val();
        var need = $('#need').val();
        if(name.length ==0) {
            alert('Please enter name');
            $('#name').focus();
            return false;
        }

        if(quantity < 0) {
            alert('Please enter proper quantity');
            $('#quantity').focus();
            return false;
        }

        if(need < 0 || need > 1) {
            alert('Please enter proper need');
            $('#need').focus();
            return false;
        }
        return true;
    };
</script>
</body>
</html>
