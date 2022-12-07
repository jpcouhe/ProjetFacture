<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Facture</title>
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="navbar.jsp"%>
<main class="container">


        <c:choose>
            <c:when test="${!empty client}">
                <div class="py-5 text-center">
                    <h2>Editer le client</h2>
                    <p class="lead">Veuillez renseigner les données nécessaires pour éditer le client</p>
                </div>
                <div class="row g-5 d-flex justify-content-center" >
                    <div class="col-md-7 col-lg-8">
                        <form method="post" action="/client/edit?id=${client.idClient}">
                            <div class="row g-3">
                                <div class="col-12">
                                    <label for="firstName" class="form-label">Nom</label>
                                    <input type="text" class="form-control" id="firstNameEdit" placeholder="" value="${client.nameClient}" required name="clientName">
                                </div>

                                <div class="col-12">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="emailEdit" placeholder="you@example.com" name="clientEmail" value="${client.emailClient}">
                                </div>


                                <div class="col-12">
                                    <label for="phone" class="form-label">Téléphone</label>
                                    <input type="text" class="form-control" id="phoneEdit" name="clientTel" value="${client.telClient}">
                                </div>

                                <div class="col-12">
                                    <label for="address" class="form-label">Addresse</label>
                                    <input type="text" class="form-control" id="addressEdit" name="clientAdress" value="${client.adressClient}">
                                </div>

                                <div class="col-12">
                                    <label for="city" class="form-label">Ville</label>
                                    <input type="text" class="form-control" id="cityEdit" name="clientCity" value="${client.cityClient}">
                                </div>


                                <div class="col-md-3">
                                    <label for="zip" class="form-label">Code postal</label>
                                    <input type="text" class="form-control" id="zipEdit" placeholder="" required name="clientPostalCode" value="${client.postalCodeClient}">
                                </div>
                            </div>
                            <hr class="my-4">
                            <button class="w-100 btn btn-primary btn-lg" type="submit">Valider</button>
                        </form>
                    </div>
                </div>


            </c:when>
            <c:otherwise>
                <div class="py-5 text-center">
                    <h2>Nouveau client</h2>
                    <p class="lead">Veuillez renseigner les données nécessaires pour la création d'un nouveau client</p>
                </div>
                <div class="row g-5 d-flex justify-content-center" >
                    <div class="col-md-7 col-lg-8">
                        <form method="post" action="/client/add">
                            <div class="row g-3">
                                <div class="col-12">
                                    <label for="firstName" class="form-label">Nom</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" value="" required name="clientName">
                                </div>

                                <div class="col-12">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" placeholder="you@example.com" name="clientEmail">
                                </div>


                                <div class="col-12">
                                    <label for="phone" class="form-label">Téléphone</label>
                                    <input type="text" class="form-control" id="phone" name="clientTel">
                                </div>

                                <div class="col-12">
                                    <label for="address" class="form-label">Addresse</label>
                                    <input type="text" class="form-control" id="address" name="clientAdress">
                                </div>

                                <div class="col-12">
                                    <label for="city" class="form-label">Ville</label>
                                    <input type="text" class="form-control" id="city" name="clientCity">
                                </div>


                                <div class="col-md-3">
                                    <label for="zip" class="form-label">Code postal</label>
                                    <input type="text" class="form-control" id="zip" placeholder="" required name="clientPostalCode">
                                </div>
                            </div>
                            <hr class="my-4">
                            <button class="w-100 btn btn-primary btn-lg" type="submit">Valider</button>
                        </form>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

</main>
</body>
</html>
