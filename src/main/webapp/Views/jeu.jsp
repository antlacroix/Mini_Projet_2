 <!-- ajoute le header pour le navigateur -->   
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Se connecter"/>
</jsp:include>




    <!--ecran de nouvel partie-->
    <div id="cc1" class="cardcontainer">
        <div id="Acceuil" class="card">
            
            <h5 class="card-header">
                <i class="fa fa-book"></i> Nouvelle Partie
                <button id=btn_np_score class="btn btn-outline-success my-2 my-sm-0">Score</button>
            </h5>
            <br/>
            <form>
              <div class="col d-flex justify-content-between">
                <label>Joueur :</label>
                <input type="text" placeholder="Nom du joueur" id="playerName" style="width: 150px"/>
                </div>
                <br/>
                <div class="col d-flex justify-content-between">
                <label>Difficulté :</label>
                <select id="difficulte" style="width: 150px">
                  <option value="Facile">Facile</option>
                  <option value="Moyen">Moyen</option>
                  <option value="Difficile">Difficile</option>
                </select>
                </div>
                <br/>
                <div class="leftMargin">
                    <input type="checkbox" id="vstime" name="time" value="vstime">
                    <label for="vstime">Contre la montre</label>
                </div>

              <div id="timeOption" class="leftMargin">
                <label>Minutes :</label>
                <div class="d-inline">
                  <label id="minute" style="width: 30px">1</label>
                  <button id="minP" type="button">+</button>
                  <button id="minM" type="button">-</button>
                </div>
                <label class="leftMargin">Secondes :</label>
                <div class="d-inline">
                  <label id="seconde" style="width: 30px">0</label>
                  <button id="secP"  type="button">+</button>
                  <button id="secM"  type="button">-</button>
                </div>
              </div>
              <div class="col d-flex justify-content-between">
                <div class="col">
                  <button class="btn btn-danger myButton" type="reset" style="width: 8em">Réinitialiser</button>
                </div>
                <div class="col">
                  <button id="btn_np_start" type="button" class="btn btn-success myButton" style="width: 8em">Commencer</button>
                </div>
              </div>
              <br/>
          </form>
        </div>
    </div>

    <!--ecran de jeu-->
    <div id="cc2" class="cardcontainer">
        <div id="Jeux" class="card">
            <div class="card-header">
                <h5 style="display: inline;" id="titlePlayerName"></h5>
                <p id="Crono" class="display"></p>
                
            </div>
            <br />
            <div id="gameTable" class="col d-flex justify-content-between">
                <div id="tableL" class="d-flex flex-column" border="3" width="50%"></div>
                <div id="tableR" class="d-flex flex-column bigDroppable" border="3" width="50%"></div>

            </div>
            <br />
            <div class="leftMargin">
                <button id="btn_jeu_stop" class="btn btn-danger myButton" type="reset" style="width: 8em">Abondonner</button>
            </div>
            <br />
        </div>
    </div>

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
                <button id="btn_score_main" class="btn btn-danger myButton">Retour</button>
            </div>
            <br />
        </div>
    </div>

    <!--ecran de fin de partie-->
    <div id="cc4" class="cardcontainer">
        <div id="Gameover" class="card">
            <h1><i class="fa fa-user"></i>Game Over !</h1>
            <div class="col d-flex justify-content-between">
                <div class="col myButton">
                    <button class="btn btn-danger myButton" type="reset" style="width: 8em">Menu</button>
                </div>
                <div class="col myButton">
                    <button id="beggin" type="button" class="btn btn-success myButton" style="width: 8em">Rejouer</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Game Over screen -->
    <div id="cc5" class="cardcontainer">
        <div id="timedOut" class="card d-flex flex-column justify-content-around">
            <div class="d-flex justify-content-around">
                <h1 style="display: inline;"><i class="fa fa-hourglass-end"></i><b>Game Over!</b></h1>
            </div>
            <div class="d-flex justify-content-around">
                <div>
                  <button id="timedOut_Menu" class="btn btn-danger myButton" type="button" style="width: 8em">Menu</button>
                </div>
                <div>
                  <button id="timedOut_Reset" class="btn btn-success myButton" type="button" style="width: 8em">Rejouer</button>
                </div>
            </div>
        </div>
        
    </div>
    
    
    
    
<!-- ajoute le footer pour le navigateur -->    
<%@include file="footer.jsp"%>