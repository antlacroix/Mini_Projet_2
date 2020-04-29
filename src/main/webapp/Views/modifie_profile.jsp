<%-- 
    Document   : modifie_profile
    Created on : 2020-04-28, 20:25:54
    Author     : Maison
--%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="UpdateUser"/>
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
                        <input type="text" class="form-control" name="new_data_nom" placeholder="Entrez votre nom">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Prénom :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="new_data_prenom" placeholder="Entrez votre prénom">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Date de naissance :</label>
                    </div>
                    <div class="col">
                       <input type="date" class="form-control" name="new_data_ddn" placeholder="Entrez votre date">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Identifiant :</label>
                    </div>
                    <div class="col">
                      <div class="mb-0 h3"><%= session.getAttribute("identifiant")%></div>
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Adresse email :</label>
                    </div>
                    <div class="col">
                        <div class="mb-0 h3"><%= session.getAttribute("email")%></div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col">
                        <label>Mot de Passe :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" name="new_data_password" placeholder="Entrez votre mot de passe">
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
                    <button class="btn btn-danger" type="reset"><i class="fa fa-trash fa-lg"></i> Retour</button>
                    <button class="btn btn-success float-right" type="submit"><i class="fa fa-sign-in fa-lg"></i> Enregistrer</button>
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