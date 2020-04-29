<%-- 
    Document   : inscription
    Created on : 2020-04-28, 19:27:18
    Author     : Maison
--%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="inscription"/>
</jsp:include>

<div id="container" class="d-flex align-items-center justify-content-center">
    <div class="card" id="connect">
        <div class="card-body">

            <form method="POST" action="${pageContext.request.contextPath}/inscription" >
                <div class="form-group row">
                    <div class="col">
                        <label>Nom :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="new_user_data_nom" placeholder="Entrez votre nom">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Pr�nom :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="new_user_data_prenom" placeholder="Entrez votre pr�nom">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Date de naissance :</label>
                    </div>
                    <div class="col">
                       <input type="date" class="form-control" name="new_user_data_ddn" placeholder="Entrez votre date">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Identifiant :</label>
                    </div>
                    <div class="col">
                      <input type="text" class="form-control" name="new_user_data_identifiant" placeholder="">
                      </div>
                      <div>
                      <button class="btn btn-primary" type="sumit"><i class="fas fa-undo-alt"></i></button>
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Adresse email :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="new_user_data_email" placeholder="Entrez votre email">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col">
                        <label>Mot de Passe :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" name="new_user_data_password" placeholder="Entrez votre mot de passe">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col">
                        <label>Confirmer :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" placeholder="Entrez votre mot de passe">
                    </div>
                </div>
                <div>
                    <button class="btn btn-danger" type="submit" value="back" name="Retour"><i class="fa fa-trash fa-lg"></i> Retour</button>
                    <button class="btn btn-success float-right" type="submit"><i class="fa fa-sign-in fa-lg"></i> Valider</button>
                </div>
            </form> <br>
            
            <% if(request.getAttribute("erreur") == "true"){ %>
            
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <b>Erreur :</b> 
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>         
            
            <% } %>      
            
            <% 
                if(session.getAttribute("identifiant") != null)
                    response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
            %>            
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>