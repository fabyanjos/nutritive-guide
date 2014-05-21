<!DOCTYPE html>
<html lang="pt-BR" ng-app="nutritive-guide">
  <head>
    <meta charset="UTF-8">
	<meta http-equiv=”content-language” content="pt-BR">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Fabi Anjos">

    <title>Composi&ccedil;&atilde;o de alimentos :: <sitemesh:write property="title"/></title>

    <link href="/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- aside id="canvas" class="navmenu-fixed-right">
      <nav id="side-menu" role="navigation">
        <a class="navmenu-brand" href="#">Nutritive Guide</a>
        <ul>
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">Link</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              Dropdown <b class="caret"></b>
            </a>
            <ul class="dropdown-menu navmenu-nav" role="menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
            </ul>
          </li>
        </ul>
      </nav>
    
      <div class="navbar navbar-default navbar-fixed-top">
        <button type="button" class="navbar-toggle" data-toggle="offcanvas" 
          data-target="#side-menu" data-canvas="aside">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
    </aside-->

	<div class="container">
		<div id="mainContent">
			<div class="page-header">
			  <h1><sitemesh:write property="div.title"/></h1>
			</div>
			
			<sitemesh:write property="div.content"/>
		</div>
			
			<footer>Created by fabyanjos | 2014</footer>
		
	</div>
	
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/angular.min.js"></script>
    <script src="/js/angular-resource.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/ui-bootstrap-tpls-0.10.0.min.js"></script>
    <script src="/js/jasny-bootstrap.min.js"></script>
    <script src="/js/numeral.min.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/services.js"></script>
    <script src="/js/controllers.js"></script>
    <script src="/js/filters.js"></script>
    
    <script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-40354748-3', 'composicao-alimentos.herokuapp.com');
	  ga('send', 'pageview');
	
	</script>
  </body>
</html>
