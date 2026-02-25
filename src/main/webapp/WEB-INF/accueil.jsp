<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tpmessagerie.Message" %>

<html>
<head>
    <title>Accueil</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #999;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2d97c;
        }

        h2 {
            text-align: center;
        }

        .nav {
            margin: 10px;
        }

        .nav a {
            margin-right: 15px;
        }
    </style>
</head>
<body>

<div class="nav">
    <a href="<%= request.getContextPath() %>/inscription">Inscription</a>
    <a href="<%= request.getContextPath() %>/connexion">Connexion</a>
    <a href="<%= request.getContextPath() %>/sujets">Sujets</a>
</div>

<h2>Liste des messages</h2>

<table>
    <tr>
        <th>Sujet</th>
        <th>Contenu</th>
    </tr>

    <%
        List<Message> messages =
                (List<Message>) request.getAttribute("messages");

        if (messages != null) {
            for (Message m : messages) {
    %>

    <tr>
        <td><%= m.getSujet() %></td>
        <td><%= m.getContenu() %></td>
    </tr>

    <%
            }
        }
    %>

</table>

</body>
</html>