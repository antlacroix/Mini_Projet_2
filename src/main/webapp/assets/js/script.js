class Game{
    constructor(difficulty, player, type, min, sec){
        if(min=="0" && sec=="0"){
            sec=1;
        }
        this.difficulty = difficulty;
        this.player = player,
        this.type = type;
        this.myPuzzle = new Puzzle(difficulty, min, sec);

    }
}
class Puzzle{
    constructor(difficulty, min = 0, sec = 0){

        this.sec = sec;
        this.min = min;

        this.initailTime = (60 * parseInt(min)) + parseInt(sec);

        this.intervalId = null;

        var puzzleNbr =  Math.floor(Math.random() * 4) + 1;

        switch(difficulty){
            case "Facile":
                this.completPuzzle = puzzleNbr + ".jpg"; 
                this.pieceFolder = "/WebMiniProjet2/assets/images/Puzzle_Image_Game_Dataset/img" + puzzleNbr + "/3x3/";
                this.puzzleTable = [];
                for (let i = 0; i < 9; i++) {

                    var nmb = pad(i + 1,3);
                    
                    var smallPiece = new Piece(
                        "image_part_"+ nmb,
                        "finalPos_" + nmb,
                        "tempPose_" + nmb
                    ) ;

                    this.puzzleTable.push(smallPiece); 
                }
                break;

            case "Moyen":
                this.completPuzzle = puzzleNbr + ".jpg"; 
                this.pieceFolder = "/WebMiniProjet2/assets/images/Puzzle_Image_Game_Dataset/img" + puzzleNbr + "/4x4/";
                this.puzzleTable = [];
                for (let i = 0; i < 16; i++) {

                    var nmb = pad(i + 1,3);

                    var smallPiece = new Piece(
                        "image_part_"+ nmb,
                        "finalPos_" + nmb,
                        "tempPose_" + nmb
                    ) ;

                    this.puzzleTable.push(smallPiece);
                }
                break;

            case "Difficile":
                this.completPuzzle = puzzleNbr + ".jpg"; 
                this.pieceFolder = "/WebMiniProjet2/assets/images/Puzzle_Image_Game_Dataset/img" + puzzleNbr + "/5x5/";
                this.puzzleTable = [];
                for (let i = 0; i < 25; i++) {

                    var nmb = pad(i + 1,3);

                    var smallPiece = new Piece(
                        "image_part_"+ nmb,
                        "finalPos_" + nmb,
                        "tempPose_" + nmb
                    ) ;

                    this.puzzleTable.push(smallPiece);
                }
                break;
        }

        this.puzzleTable = shuffle(this.puzzleTable);
        this.dict = [];
        for (let i = 0; i < this.puzzleTable.length; i++) {
            this.dict[i] = false;
        }
        
    }

}
class Piece{
    constructor(imageLink, realPosition, tempPosition){
        this.imageLink = imageLink + ".jpg";
        this.realPosition = realPosition;
        this.tempPosition = tempPosition;
        this.id = imageLink;
    }
}
class Score{
    constructor(type, difficulty, time, name){
        if(name == ""){
            this.name = "Anonymous";
        }
        else{
            this.name = name;
        }
        this.type = type;
        this.difficulty = difficulty;
        this.time = time;
    }
}

//fonction permettant de passer d'un efenetre a l'autre

//***************************************************************
//ou d'afficher differantre chose selon la selection
function ShowNewPlayer(){
    $("#cc1").show();
    $("#cc2").hide();
    $("#cc4").hide();
    $("#cc5").hide();
}
function ShowGame(playerName){
    $("#cc1").hide();
    $("#cc2").show();
    $("#titlePlayerName").text(playerName);
    $("#cc4").hide();
    $("#cc5").hide();
}
function ShowOption(){
    if($("#vstime").prop("checked") == true)
        $("#timeOption").show();
    else if($("#vstime").prop("checked") == false)
        $("#timeOption").hide();
}
function ShowTimedOut(){
    $("#cc5").show();
}
//***************************************************************

//fonctions utile

//************************************************************************************
//fonction pour "padder les chiffre"
function pad(n, width, z) {
    z = z || '0';
    n = n + '';
    return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
}

//fonction pour "randomiser" un array
function shuffle(array) {
    var tmp, current, top = array.length;
    if(top) while(--top) {
      current = Math.floor(Math.random() * (top + 1));
      tmp = array[current];
      array[current] = array[top];
      array[top] = tmp;
    }
    return array;
}

//fonction de popullation du tableau
function popullate(piecesArray, imgFolder){
    var x = 1;
        //creer les tableau pour la dificulter facile
        $("#tableL div").remove();
        for (let i = 0; i < Math.sqrt(piecesArray.length); i++) {
            $("#tableL").append('<div id="leftRow'+(i+1)+'" class="d-flex flex-row"></div>')
            for (let j = 0; j < Math.sqrt(piecesArray.length); j++) {
                $('#leftRow'+(i+1)).append('<div id="image_part_' + pad(x,3) +  '" class="dropPlace"></div>');
                x++;
            }
        };
        var x = 0;        
        $("#tableR div, img").remove(); 
        for (let i = 0; i < Math.sqrt(piecesArray.length); i++) {
            $("#tableR").append('<div id="rightRow'+(i+1)+'" class="d-flex flex-row"></div>')
            for (let j = 0; j < Math.sqrt(piecesArray.length); j++) {
                var img = piecesArray[x];
                $('#rightRow'+(i+1)).append('<div id="' + piecesArray[x].id + '" class="draggable ui-widget-content"><img src="' + imgFolder +piecesArray[x].imageLink + '"></div>');
                x++;
            }          
        };
        
}

//fonction ajoute un scores dans les table
function AddScore(NormalScores, TimedScores){
    $("#tbnormal td").remove();
    for (let i = 0; i < NormalScores.length; i++) {
        $("#tbnormal").append('<tr><td>' + (i+1) + '</td><td>'+ NormalScores[i].name +'</td><td>'+ NormalScores[i].difficulty +'</td><td>'+ NormalScores[i].time +'</td></tr>');
    };
    $("#tbTimed td").remove();
    for (let i = 0; i < TimedScores.length; i++) {
        $("#tbTimed").append('<tr><td>' + (i+1) + '</td><td>'+ TimedScores[i].name +'</td><td>'+ TimedScores[i].difficulty +'</td><td>'+ TimedScores[i].time +'</td></tr>');
    };
}

//est appeler pour verifier la victoire
function CheckVictory(dict){

    for (let i = 0; i < dict.length; i++) {   
        if(dict[i] != true){
            return false;
        }
    }
    return true;
    
}

//************************************************************************************

//fonction en lien avec le timer

//****************************************************************************************
//Afficher terminer lorsque le timer arrive à zéro
function timeover(myGame){
    if(myGame.type == "clocked"){
        clearInterval(myGame.myPuzzle.intervalId);
        $("#Crono").text("TERMINE!");
        
    }
    else if(myGame.type == "normal"){
        var time = $("#Crono").text();
        clearInterval(myGame.myPuzzle.intervalId);
        return time;
    }           
}

//Fonction du timer
function decompte(){
    sec = myGame.myPuzzle.sec;
    min = myGame.myPuzzle.min;
    sec--;
    if(min>=1 && sec<=0){
        sec += 60;
        min--;
        $("#Crono").text(pad(min,2) + " : " + pad(sec,2));
        myGame.myPuzzle.sec = sec;
        myGame.myPuzzle.min = min;
    }
    else{
        $("#Crono").text(pad(min,2) + " : " + pad(sec,2));
        myGame.myPuzzle.sec = sec;
        myGame.myPuzzle.min = min;
    }

    if(min==0 && sec ==0){
        timeover(myGame);
        ShowTimedOut();
    } 
}
//cette fonction commence le timer apprprier
function start(myGame){
    $("#Crono").text("00 : 00");
    if(myGame.type == "normal"){
        myGame.myPuzzle.intervalId = null;
        myGame.myPuzzle.intervalId = setInterval(Chronos, 1000, myGame);
    }else if(myGame.type == "clocked"){
        myGame.myPuzzle.intervalId = null;
        myGame.myPuzzle.intervalId = setInterval(decompte, 1000, myGame);
    }
}
//fonction Chronometre
function Chronos(myGame){
    sec = myGame.myPuzzle.sec;
    min = myGame.myPuzzle.min;
    sec++;
    if(sec >= 60){
        sec -= 60;
        min++;
        $("#Crono").text(pad(min,2) + " : " + pad(sec,2));
        myGame.myPuzzle.sec = sec;
        myGame.myPuzzle.min = min;
    }
    else{
        $("#Crono").text(pad(min,2) + " : " + pad(sec,2));
        myGame.myPuzzle.sec = sec;
        myGame.myPuzzle.min = min;
    }
}
//****************************************************************************************


function ResetGame (myGame, tempGame){
    myGame.myPuzzle.sec = tempGame.myPuzzle.sec;
    myGame.myPuzzle.min = tempGame.myPuzzle.min;
    ShowGame();
    start(myGame);
}

//initialisation des variables
var myGame;
var tempGame;
var TimedScores = [];
var NormalScores = [];
var myScrore;

$(document).ready(function(){
    
    ShowNewPlayer();
    ShowOption();

    //function permettant de montrer ou cacher les option de temps
    $("#vstime").on("click", function(){
        ShowOption();
    })

    //bouton option de temps
    //**********************************************************
    $("#minP").on("click",function(){
        $("#minute").text(parseInt($("#minute").text()) + 1);
    })

    $("#minM").on("click",function(){
        if(parseInt($("#minute").text()) > 0){
            $("#minute").text(parseInt($("#minute").text()) - 1);
        }
        else if (parseInt($("#minute").text()) <= 0){
            $("#minute").text("0");
        }
    })

    $("#secP").on("click",function(){
        $("#seconde").text(parseInt($("#seconde").text()) + 1);
    })

    $("#secM").on("click",function(){
        if(parseInt($("#seconde").text()) > 0)
            $("#seconde").text(parseInt($("#seconde").text()) - 1);
        else if(parseInt($("#seconde").text()) <= 0)
            $("#seconde").text("0");
    })

    //**********************************************************

    //fonction des boutons de l'ecran nouvelle partie
    $("#btn_np_score").on("click", function(){
        ShowScore();
    });
    
    $("#btn_np_start").on("click", function(){

        
        if($("#vstime").prop("checked") == true){
            myGame = new Game($("#difficulte").val(), $("#playerName").val(), "clocked", $("#minute").text(), $("#seconde").text());
            tempGame = new Game($("#difficulte").val(), $("#playerName").val(), "clocked", $("#minute").text(), $("#seconde").text());
        }
        else if($("#vstime").prop("checked") == false){
            myGame = new Game($("#difficulte").val(), $("#playerName").val(), "normal");
            tempGame = new Game($("#difficulte").val(), $("#playerName").val(), "normal");
        }

        start(myGame)
        ShowGame(myGame.player);
        popullate(myGame.myPuzzle.puzzleTable, myGame.myPuzzle.pieceFolder)
        
        
        //rend les objet avec la classe draggable deplacable
        $( function() {
            $( ".draggable" ).draggable({
                snap: ".dropPlace",
                snapMode: "inner",
                snapTolerance: 50,
                containment : "#cc2",
                revert: "invalid",
                revertDuration: 200,
                start:function(){
                    $(this).css("z-index", "10")
                },
                stop:function(){
                    $(this).css("z-index", "0")
                }

            });
        } );
        //rend les emplacement valide et verifie si le bon div y a ete placer
        $( function() {

            $(".bigDroppable").droppable({
                accept: ".draggable",
                tolerance: "intersect"
            })
            $( ".dropPlace").droppable({
                accept: ".draggable",
                tolerance: "intersect",

                drop: function( event, ui ) {

                    var dragId = ui.draggable.attr("id");
                    var dropId = $(this).attr("id");

                    if(dropId == dragId){
                        myGame.myPuzzle.dict[parseInt(dragId.split("_")[2]-1)] = true;
                        if(CheckVictory(myGame.myPuzzle.dict)){
                            if(myGame.type == "normal"){
                                myScrore = new Score(myGame.type, myGame.difficulty, $("#Crono").text(), myGame.player);
                                NormalScores.push(myScrore);   
                            }else{
                                var finalTime = myGame.myPuzzle.initailTime - ((60 * parseInt(myGame.myPuzzle.min)) + parseInt(myGame.myPuzzle.sec));

                                myScrore = new Score(myGame.type, myGame.difficulty, finalTime + " sec" , myGame.player);
                                TimedScores.push(myScrore);
                            }
                            timeover(myGame);
                            AddScore(NormalScores, TimedScores);
                            ShowGameOver();
                        }
                    }else if(dropId != dragId){
                        myGame.myPuzzle.dict[parseInt(dragId.split("_")[2]-1)] = false;
                    }
                }
            })
        })
    })
    
    //fonction du bouton de l'ecran de jeu
    $("#btn_jeu_stop").on("click", function(){
        timeover(myGame);
        ShowGameOver();
    })

    //fonction du bouton dans l<ecran de score
    $("#btn_score_main").on("click", function(){
        ShowNewPlayer();
    })

    //fonction des bouton du Game Over Screen
    $("#timedOut_Menu").on("click", function(){
        ShowNewPlayer();
    })
    
    $("#timedOut_Reset").on("click", function(){
        ResetGame(myGame, tempGame)
    })
})