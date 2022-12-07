<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajout Personne</title>
</head>
<body>

    <!-- Formulaire -->
    <form method="post" action="/EniDemo/add-person">
        <!-- Champ Prenom  -->
        <input type="text" name="firstname" placeholder="Prenom" value="" />
        
        <!-- Champ Non -->
        <input type="text" name="lastname" placeholder="Nom" value="" />
    
        <!-- Bouton de validation  -->
        <input type="submit" value="Enregistrer" />
    </form>

</body>

</html>