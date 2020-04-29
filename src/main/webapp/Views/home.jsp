<%-- 
    Document   : home
    Created on : 2020-04-28, 21:06:05
    Author     : Maison
--%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

<div id="container" class="d-flex align-items-center justify-content-center">
    <div class="card" id="connect">
      
        <div class="card-body">

            <form method="POST" action="${pageContext.request.contextPath}/home" >
                

                <div>
                    <button class="btn btn-success" type="submit"><i class="fa fa-sign-in fa-lg"></i> Se Connecter</button>
                    <button class="btn btn-danger" type="reset"><i class="fa fa-trash fa-lg"></i> S'incrire</button>
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
                    response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
            %>            
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>