<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Christopher Diehl">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <title>Emily Blog</title>

  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!--Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Dancing+Script' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Josefin+Sans' rel='stylesheet' type='text/css'>

  <!-- Custom CSS -->
  <link href="css/style.css" rel="stylesheet">

</head>
<body>
  <!--Navbar-->
  <!-- Static navbar -->
  <div class = "page container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header navbar-left">

          <a class="nav-logo navbar-brand nav-items" href="#"><strong>Small Feet Big Strides</strong></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-right">
          <ul class="nav navbar-nav navbar-left">
          </ul>
          <ul class="nav navbar-nav navbar-brand" >
            <li class ="nav-items"><a href="#">Blog</a></li>
            <li class= "nav-items" ><a href="videos.html">Videos</a></li>
            <li class= "nav-items"><a href="#">About Us</a></li>
          </ul><span></span>
          <ul class="nav navbar-nav  navbar-brand">
          	<li><a href="https://www.instagram.com/ecatalds/"><i class="fa fa-fw fa-twitter"></i></a></li>
          	<li><a href="https://www.instagram.com/ecatalds/"><i class="fa fa-fw fa-instagram"></i></a></li>
          	<li><a href="https://www.facebook.com/emily.cataldi.7?fref=ts"><i class="fa fa-fw fa-facebook"></i></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div id="content" class="col-md-8">
        <c:forEach items="${blogs}" var="blog_post">
          <article class = "blog_excerpt">
            <header>
              <h1><a href="blog_post.html">${blog_post.getTitle()}</a></h1>
              <p>${blog_post.getSummary()}</p>
            </header>
            ${blog.getFirstParagraph()}

          </article>
        </c:forEach>
      <center>
      <nav>
        <ul class="pagination pagination-lg">
          <li>
            <a href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li>
            <a href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
      </center>

    </div>
    <aside class="col-md-4">
      <div class = "search">
        <form class="navbar-form navbar-left" role="search">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>  
      </div>  
      <h4><b>Taking a bite out of the big apple</b></h4>
      <p>
        <iframe width="300" height="250" src="https://www.youtube.com/embed/0QD7VntQ1q0" frameborder="0" allowfullscreen></iframe>
      </p>
      <br><br>
      <h4><b>Rutgers and the family</b></h4>
      <p>
        <iframe width="300" height="250" src="https://www.youtube.com/embed/uGR5a9CBW0Y" frameborder="0" allowfullscreen></iframe>
      </p>
      <br><br>
      <h4><b>A day in the life of teen parents</b></h4>
      <p>
        <iframe width="300" height="250" src="https://www.youtube.com/embed/bAPFB-ZuR_Q" frameborder="0" allowfullscreen></iframe>
      </p>
      
    </aside>
    </div>

    <footer class="container-fluid">
     <center>
      <p>Copyright &copy 2016 Christopher Diehl </p>
      <p><small>all rights reserved</small></p>
     </center>
    </footer>
  </body>
  </html>
