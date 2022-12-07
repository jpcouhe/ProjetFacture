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
        <h2>Nouveau service</h2>
        <p class="lead">Quel nouveau service voulez-vous ajouter? </p>
      </div>
      <div class="row g-5 d-flex justify-content-center" >
        <div class="col-md-7 col-lg-8">
          <form method="post" action="/product/add">
            <div class="row g-3">
              <div class="col-12">
                <label for="description" class="form-label">Description</label>
                <input type="text" class="form-control" id="description" name="description">
              </div>

              <div class="col-12">
                <label for="price" class="form-label">Prix</label>
                <input type="number" class="form-control" id="price" name="price">
              </div>

              <div class="col-12">
                <label for="tva" class="form-label">TVA</label>
                <select class="form-select form-profil" id="tva" name="tva">
                  <option value="">Choisir...</option>
                  <option value="1">0</option>
                  <option value="2">2.2%</option>
                  <option value="3">5.5%</option>
                  <option value="4">10%</option>
                  <option value="5">20%</option>
                </select>
              </div>
            <hr class="my-4">
            <button class="w-100 btn btn-primary btn-lg" type="submit">Valider</button>
            </div>
          </form>
        </div>
      </div>

</main>
</body>
</html>
