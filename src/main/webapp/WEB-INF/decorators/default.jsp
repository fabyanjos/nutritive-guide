<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
	<meta http-equiv=”content-language” content="en">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Fabi Anjos">

    <title>Template <sitemesh:write property="title"/></title>

    <link href="/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <aside id="canvas" class="navmenu-fixed-right">
      <nav id="side-menu" role="navigation">
        <a class="navmenu-brand" href="#">Brand</a>
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
    </aside>

	<div class="container">
		<div class="page-header">
		  <h1><sitemesh:write property="div.title"/></h1>
		</div>
		
		<sitemesh:write property="div.content"/>
		
	</div>

    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jasny-bootstrap.min.js"></script>
  </body>
</html>
