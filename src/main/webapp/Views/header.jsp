<!DOCTYPE html>
<html>
<head>
    <title>${param.title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/script.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/main.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 

</head>
<body>
    
    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-secondary">
        <div id="nav-div" class="d-flex justify-content-between">
            <div class="">
                <span class="mb-0 h1">Jeux Puzzle</span>
            </div>
            
            <% if(session.getAttribute("identifiant") != null){ %>
            
                <div class="collapse navbar-collapse d-flex justify-content-center">
                    <ul class="navbar-nav">
                        <li class="nav-item mx-5 active">
                            <a class="nav-link mb-0 h3" href="">  Jeu  </a>
                        </li>
                        <li class="nav-item mx-5">
                            <a class="nav-link mb-0 h3" href="">  Profile  </a>
                        </li>
                        <li class="nav-item mx-5">
                            <a class="nav-link mb-0 h3" href="">  Score  </a>
                        </li>
                        <li class="nav-item mx-5">
                            <a class="nav-link mb-0 h3" href="">  Se déconnecter  </a>
                        </li>
                    </ul>
                </div>
                <div class="mb-0 h1"><%= session.getAttribute("identifiant")%></div>
                
                <% } %>
                
        </div>
    </nav>