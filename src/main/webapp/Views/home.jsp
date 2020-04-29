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
                    <button class="btn btn-danger" value="inscriT" type="submit" name="Inscrire"><i class="fa fa-trash fa-lg"></i> S'incrire</button>
                </div>
            </form>     
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>