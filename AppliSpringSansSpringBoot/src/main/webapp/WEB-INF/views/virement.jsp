<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head><title>login</title></head>
<body>
<h3>virement interne pour le client connect�</h3>
 numClient = ${numClient} <br/>
<form:form action="effectuerVirement" modelAttribute="virement" method="POST">
montant: <form:input  path="montant" /> <br/>
numCptDeb: <form:input  path="numCptDeb" /> <br/>
numCptCred<form:input  path="numCptCred" /> <br/>
 <input type="submit" value="effectuer virement" />
</form:form>
</body>
</html>