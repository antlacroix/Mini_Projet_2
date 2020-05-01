<!-- ajoute le header pour le navigateur -->
<jsp:include page="header.jsp">
    <jsp:param name="title" value="inscription"/>
</jsp:include>



<div id="container" class="d-flex align-items-center justify-content-center">
    <div class="card border-dark" id="connect">
        <h3 class="card-header">
            <i class="fa fa-address-card"></i> Inscription
        </h3>
        <div class="card-body">
            <form method="POST" action="${pageContext.request.contextPath}/inscription2">
                
                <!-- nom de famille -->
                <div class="form-group row">
                    <div class="col">
                        <label>Nom :</label>
                    </div>
                    <div class="col">
                        <input id="name" type="text" class="form-control" name="new_user_data_nom" placeholder="">
                    </div>
                </div>
                
                <!-- prenom -->
                <div class="form-group row">
                    <div class="col">
                        <label>Prénom :</label>
                    </div>
                    <div class="col">
                        <input id="firstname" type="text" class="form-control" name="new_user_data_prenom" placeholder="">
                    </div>
                </div>
                
                <!-- date de naissance -->
                <div class="form-group row">
                    <div class="col">
                        <label>Date de naissance :</label>
                    </div>
                    <div class="col">
                       <input type="date" class="form-control" name="new_user_data_ddn" placeholder="">
                    </div>
                </div>
                
                <!-- identifiant créé a l'aide du bouton -->
                <div class="form-group row">
                    <div class="col">
                        <label>Identifiant :</label>
                    </div>
                    <div class="col">
                        <input id="reslt" type="text" class="form-control" name="new_user_data_identifiant" disabled>
                    </div>
                    <div>
                        <button class="btn btn-primary" type="button" id="generate_id"><i class="fa fa-undo"></i></button>
                    </div>
                </div>
                
                <!-- section cachédu formulaire qui sert a récupérer l'identifiant par le code -->
                <div class="d-none">
                    <input id="new_id" type="text" name="new_user_data_identifiant">
                </div>
                
                <!-- email -->
                <div class="form-group row">
                    <div class="col">
                        <label>Adresse email :</label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" name="new_user_data_email" placeholder="">
                    </div>
                </div>
                
                <!-- mot de passe -->
                <div class="form-group row">
                    <div class="col">
                        <label>Mot de Passe :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" name="new_user_data_password" placeholder="">
                    </div>
                </div>
                
                <!-- confirmation du mot de passe -->
                <div class="form-group row">
                    <div class="col">
                        <label>Confirmer :</label>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" name="new_user_data_password2" placeholder="">
                    </div>
                </div>
                
                <!-- bouton -->
                <div>
                    <button class="btn btn-danger" type="submit" value="back" name="Retour"><i class="fa fa-backward"></i> Retour</button>
                    <button class="btn btn-success float-right" type="submit"><i class="fa fa-check"></i> Valider</button>
                </div>
            </form> <br>
            
            
            
            <!-- 3 error message for when the form is not fill correctly -->
            <% if(request.getAttribute("erreur") == "true"){ %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <b>Erreur :</b> 
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>         
            <% } %>      
             <% if(request.getAttribute("erreur1") == "true"){ %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <b>Erreur :</b> L'identifiant existe et/ou l'email
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

<!-- redirection si le jeu est deja connecté -->
<% 
    if(session.getAttribute("identifiant") != null)
        response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
%>         
        
<!-- ajoute le footer pour le navigateur -->         
<%@ include file="footer.jsp"%>