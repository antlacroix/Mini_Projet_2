<%-- 
    Document   : modifie_profile
    Created on : 2020-04-28, 20:25:54
    Author     : Maison
--%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Profil"/>
</jsp:include>

<div id="container" class="d-flex align-items-center justify-content-center">
    <div class="card" id="connect">
        <div class="card-body">

            <form method="POST" action="${pageContext.request.contextPath}/profile" >
                <div class="form-group row">
                    <div class="col">
                        <label>Nom :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="new_data_nom" placeholder="<%= session.getAttribute("nom")%>">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Prénom :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="new_data_prenom" placeholder="<%= session.getAttribute("prenom")%>">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Date de naissance :</label>
                    </div>
                    <div class="col">
                       <input type="date" class="form-control" name="new_data_ddn" value="<%= session.getAttribute("ddn")%>">
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Identifiant :</label>
                    </div>
                    <div class="col">
                      <div class="mb-0 h5"><%= session.getAttribute("identifiant")%></div>
                    </div>
                </div>
                 <div class="form-group row">
                    <div class="col">
                        <label>Adresse email :</label>
                    </div>
                    <div class="col">
                        <div class="mb-0 h5"><%= session.getAttribute("email")%></div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col">
                        <label>Mot de Passe :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" name="new_data_password" placeholder="">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col">
                        <label>Confirmer :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" name="new_data_password2" placeholder="">
                    </div>
                </div>
                <div>
                    <button class="btn btn-danger" type="submit" value="back" name="Retour"><i class="fa fa-backward"></i> Retour</button>
                    <button class="btn btn-success float-right" type="submit"><i class="fa fa-save"></i> Enregistrer</button>
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
            <% if(request.getAttribute("erreur6") == "true"){ %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <b>Erreur :</b> Les mot de passe de coresponde pas  
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>         
            <% } %> 
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>