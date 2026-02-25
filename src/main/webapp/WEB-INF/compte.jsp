<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tpmessagerie.Message" %>

<html>
<head>
    <title>Mon Compte</title>
</head>
<body>

<h2>Mes messages privés</h2>

<a href="<%= request.getContextPath() %>/deconnexion">
    Déconnexion
</a>

<table border="1" cellpadding="10">
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