<%-- 
    Document   : login
    Created on : 2020-04-28, 14:41:06
    Author     : Maison
--%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Se connecter"/>
</jsp:include>

<div id="container" class="d-flex align-items-center justify-content-center">
    <div class="card" id="connect">
        <h5 class="card-header"><i class="fa fa-user fa-lg"></i> Connexion</h5>
        <div class="card-body">

            <form method="POST" action="${pageContext.request.contextPath}/login" >
                <div class="form-group row">
                    <div class="col">
                        <label>Identifiant :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="data_login" placeholder="Entrez votre identifiant">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col">
                        <label>Mot de Passe :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" name="data_password" placeholder="Entrez votre mot de passe">
                    </div>
                </div>

                <div>
                    <button class="btn btn-danger" type="reset"><i class="fa fa-trash fa-lg"></i> Retour</button>
                    <button class="btn btn-success float-right" type="submit"><i class="fa fa-sign-in fa-lg"></i> Valider</button>
                </div>
            </form> <br>
            
            <% if(request.getAttribute("erreur") == "true"){ %>
            
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <b>Erreur :</b> L'identifiant ou le mot de passe est incorrect !
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>         
            
            <% } %>      
            
            <% 
                if(session.getAttribute("identifiant") != null)
                    response.sendRedirect(request.getContextPath() + "/Views/home.jsp");
            %>            
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>