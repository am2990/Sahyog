<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sahyog Dashboard</title>

	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
  	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	
	
    <!-- Custom CSS -->
    <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" style="color: white;">Home</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            	
                
                    
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/chs/dashboard/newtopic">New Topic</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li >
                        <a href="#">Contact</a>
                    </li>
                    
                </ul>
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

		   <div class="panel panel-default">
		    <table class="table table-hover">
		      <tbody>
		        <tr>
		          <td>
		          <span class="glyphicon glyphicon-chevron-right"></span>
		            Total Number of Ebola Patients
		          </td>
		          <td class="text-right text-nowrap">
		          	<button class="btn btn-success">Subscribe</button>&nbsp
		            <button class="btn btn-warning">Edit</button>&nbsp
		            <button type="button" class="btn btn-danger btn-default">
		            	<span class="glyphicon glyphicon-trash"></span>
		            </button>&nbsp 
		          </td>
		        </tr>
		      </tbody>
		    </table>
		  </div>

        <!-- /.row -->

    </div>
    <!-- /.container -->
</body>

</html>
