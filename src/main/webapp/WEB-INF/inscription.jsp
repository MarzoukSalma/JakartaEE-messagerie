<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>

<h2>Inscription</h2>

<form action="<%= request.getContextPath() %>/inscription" method="post">

    Nom :
    <input type="text" name="nom" required>
    <br><br>

    Prénom :
    <input type="text" name="prenom" required>
    <br><br>

    Mot de passe :
    <input type="password" name="motDePasse" required>
    <br><br>

    <button type="submit">S'inscrire</button>

</form>

<p style="color:green;">
    <%= request.getAttribute("message") != null ?
            request.getAttribute("message") : "" %>
</p>

</body>
</html>