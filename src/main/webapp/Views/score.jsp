 <!-- ajoute le header pour le navigateur -->   
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Score"/>
</jsp:include>


<!--ecran de score-->
    <div id="cc3" class="cardcontainer">
        <div id="Score" class="card">
            <h5 class="card-header"><i class="fa fa-book"></i> Scores </h5>
            <br />
            <div class="leftMargin">
                <h6> Mode Normal </h6>
                <table  border="3" width="50%">
                    <tbody id="tbnormal">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Joueur</th>
                            <th scope="col">Difficulté</th>
                            <th scope="col">Temps écoulé</th>
                        </tr>
                    </tbody>
                </table>
            </div>
            <br />
            <div class="leftMargin">
                <h6> Mode contre la montre </h6>
                <table border="3" width="50%">
                    <tbody id="tbTimed">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Joueur</th>
                            <th scope="col">Difficulté</th>
                            <th scope="col">Temps écoulé</th>
                        </tr>
                    </tbody>
                </table>
                <br>
                <form method="POST" action="${pageContext.request.contextPath}/BackToGame">
                    <button id="btn_score_main" type="submit" class="btn btn-danger myButton">Retour</button>
                </form>
            </div>
            <br />
        </div>
    </div>



<!-- ajoute le footer pour le navigateur -->    
<%@include file="footer.jsp"%>