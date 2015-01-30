<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}"/>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="author" content="Index">

    <title>PetShopPlus</title>
  
    <link href="<c:url value="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="    //maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"/>" rel="stylesheet"/>    
    
    <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    <script class="include" type="text/javascript" src="<c:url value="/js/jquery.dcjqaccordion.js"/>"></script>
    <script class="include" type="text/javascript" src="<c:url value="/js/common-scripts.js"/>"></script>
    
<fmt:setLocale value="pt_br"/>
  </head>

  <body>

  <section id="container" >
  
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            
            <a href="#" class="logo"><b>PETSHOPPLUS</b></a>
           


            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="<c:url value="/"/>">Logout</a></li>
            	</ul>
            </div>
        </header>
      

      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="#"><img src="<c:url value="/images/imgUsuario.png"/>" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">Franco Neto</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="#">
                          <i class="fa fa-dashboard"></i>
                          <span>Painel</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-user"></i>
                          <span>Cliente</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="<c:url value="/cliente/cadastro"/>">Cadastrar</a></li> 
                          <li><a  href="#">Listar</a></li>

                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-paw"></i>
                          <span>Animal</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="#">Cadastrar</a></li>
                          <li><a  href="#">Editar</a></li>
                          <li><a  href="#">Excluir</a></li>
                          <li><a  href="#">Listar</a></li>

                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-group"></i>
                          <span>Funcionário</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="#">Cadastrar</a></li>
                          <li><a  href="#">Editar</a></li>
                          <li><a  href="#">Excluir</a></li>
                          <li><a  href="#">Listar</a></li>

                      </ul>
                  </li>
              </ul>
          </div>
      </aside>          
      </section>
     