<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!--script type="text/javascript"  src="/ProjetExercice3/WebContent/script.js"></script--->
</head>
<body>
<form action= "jedevine.php" method="post">
  <div class="container">
	   <H3>Exercice 3 Deviner le nombre</H3>
	      <label><strong>Devinez ce nombre:</strong></label><br><br>
	      <input type="text"  name="nombre" id="nbr" required pattern = "[0-9]+" title="Saisir un chiffre entre 0 et 100 !"
	      />
	      <input type="submit" name="cherch" id="search" value="Essaie"/>
	      <c:if test="${ fini == false || fini == null }">
	          <input type="submit"  name="cherch" value="Rejouer"  disabled/>
	      </c:if>
	      <c:if test="${fini == true}">
	         <input type="submit"  name="cherch" value="Rejouer"/>
	      </c:if> 
	      <br>
	      <p><p>
	      <div id="message"></div>
	      <br/><br/>
	      <label>
	        ${Jdevine.historique[fn:length(Jdevine.historique)-1]}
	      </label>  
	      <br><br/><br/>
	      <label><strong>Historique:</strong></label>
	      <ol class ="container-list">
	        <c:forEach items= "${Jdevine.historique}" var="his">
	           <li class="List-group-items">${his}</li>
	        </c:forEach> 
	        <c:if test=" ${fini==true}">
	        <div class="alert alert-success" style="font-size:40px">
	           <strong>Fin</strong><br/>Le nombre  a trouver est : ${atrouver}
	        </div>
	      </c:if> 
	      </ol>         
	  </div>    
 </form>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>	
 <script>
    $(function(){
    	
    	$("#search").on( 'click' , function(evt){
    		var nombre= document.querySelector('#nbr').value	
    		if(nombre<0){
    			evt.preventDefault();
    			var msg=document.querySelector('#message')
    			$(msg).text("Le nombre que vous avez saisie est inferieur a 0")
    			
    			$(msg).addClass("alert");
    			$(msg).addClass("alert-danger");
    		}else if(nombre>100){
    			evt.preventDefault();
    			var msg=document.querySelector('#message')
    			$(msg).text("Le nombre que vous avez saisie est superieur a 100")
    			
    			$(msg).addClass("alert");
    			$(msg).addClass("alert-danger");
    		}
    	});
    	
    });
    
</script>
</body>
</html>