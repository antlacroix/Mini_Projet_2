<!-- ajoute le header pour le navigateur -->
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

<div id="container" class="d-flex align-items-center justify-content-center">
    <div class="card border-dark" id="connect">
        <div>
            <h3 class="card-header">Bienvenue dans ce jeu de puzzle formidable</h3>
        </div>
        <div class="card-body">
            <form method="POST" action="${pageContext.request.contextPath}/home" >
                <div class="d-flex justify-content-around mt-4">
                    <button class="btn btn-success" type="submit"><i class="fa fa-sign-in fa-lg"></i> Se Connecter</button>
                    <button class="btn btn-danger" value="inscriT" type="submit" name="Inscrire"><i class="fa fa-plus"></i> S'incrire</button>
                </div>
            </form> 
                
        </div>
    </div>
</div>

<!-- redirection si le jeu est deja connecté -->
<% 
if(session.getAttribute("identifiant") != null)
    response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
%> 

<!-- ajoute le footer pour le navigateur -->  
<%@ include file="footer.jsp"%>