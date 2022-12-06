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

    <div class="py-5 text-center">

        <h2>Nouveau client</h2>
        <p class="lead">Veuillez renseigner les données nécessaires pour la création d'un nouveau client</p>
    </div>
    <div class="row g-5 d-flex justify-content-center">
        <div class="col-md-7 col-lg-8">
            <form class="needs-validation" novalidate>
                <div class="row g-3">
                    <div class="col-12">
                        <label for="firstName" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                    </div>

                    <div class="col-12">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="you@example.com">
                    </div>


                    <div class="col-12">
                        <label for="address" class="form-label">Addresse</label>
                        <input type="text" class="form-control" id="address">
                    </div>

                    <div class="col-12">
                        <label for="city" class="form-label">Ville</label>
                        <input type="text" class="form-control" id="city" >
                    </div>


                    <div class="col-md-3">
                        <label for="zip" class="form-label">Code postal</label>
                        <input type="text" class="form-control" id="zip" placeholder="" required>
                    </div>
                </div>
                <hr class="my-4">
                <button class="w-100 btn btn-primary btn-lg" type="submit">Valider</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>
