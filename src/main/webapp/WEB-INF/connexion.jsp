<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>

<h2>Connexion</h2>

<form action="<%= request.getContextPath() %>/connexion" method="post">
    Nom : <input type="text" name="nom" required><br><br>
    Prénom : <input type="text" name="prenom" required><br><br>
    Mot de passe : <input type="password" name="motDePasse" required><br><br>

    <button type="submit">Se connecter</button>
</form>

<p style="color:red;">
    <%= request.getAttribute("error") != null ?
            request.getAttribute("error") : "" %>
</p>

</body>
</html>