<!-- import necessaire pour faire fonctionner l'ajout des scores -->
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.miniprojet2.dto.ScoreVstimeDto"%>
<%@page import="com.mycompany.miniprojet2.dto.ScoreNormalDto"%>

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
                <h6> Mode contre la montre </h6>
                <table  border="3" width="100%">
                    <tbody id="tbnormal">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Joueur</th>
                            <th scope="col">Difficulté</th>
                            <th scope="col">Temps choisie</th>
                            <th scope="col">Temps finale</th>
                        </tr>
                        <%  List<ScoreVstimeDto> scores = new ArrayList<ScoreVstimeDto>();
                            scores = (ArrayList<ScoreVstimeDto>)request.getAttribute("scoreVstime");
                            if(scores != null){
                                for (ScoreVstimeDto score: scores){%>
                                
                                    <tr>
                                        <th scope="col"><%= score.getIdscore() %></th>
                                        <th scope="col"><%= score.getJoueur()%></th>
                                        <th scope="col"><%= score.getDifficulte()%></th>
                                        <th scope="col"><%= score.getTemp_init()%></th>
                                        <th scope="col"><%= score.getTemp_fin() %></th>
                                    </tr>  
                                
                        <% }} %>
                    </tbody>
                </table>
            </div>
            <br />
            <div class="leftMargin">
                <h6> Mode Normal </h6>
                <table border="3" width="100%">
                    <tbody id="tbTimed">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Joueur</th>
                            <th scope="col">Difficulté</th>
                            <th scope="col">Temps écoulé</th>
                        </tr>
                        
                        <%  List<ScoreNormalDto> scores2 = new ArrayList<ScoreNormalDto>();
                            scores2 = (ArrayList<ScoreNormalDto>)request.getAttribute("scoreNormal");
                            if(scores2 != null){
                                for (ScoreNormalDto score: scores2){%>
                                
                                    <tr>
                                        <th scope="col"><%= score.getId()%></th>
                                        <th scope="col"><%= score.getJoueur()%></th>
                                        <th scope="col"><%= score.getDifficulte()%></th>
                                        <th scope="col"><%= score.getTemps()%></th>
                                    </tr>  
                                
                        <% }} %>
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