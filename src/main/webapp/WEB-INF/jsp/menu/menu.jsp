<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}"/>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="author" content="Index">

    <title>PetShopPlus</title>
  
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
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
            
            <a href="home" class="logo"><b>PETSHOPPLUS</b></a>
           


            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="<c:url value="/"/>">Logout</a></li>
            	</ul>
            </div>
        </header>
      

      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <ul class="sidebar-menu" id="nav-accordion">
                  <div align="center">
              	  <br><br><p><a href="#"><img src="<c:url value="/images/logo.png"/>"></a></p>
              	  <br><br><h5 class="centered">Administrador</h5>
              	  </div>
                  <li class="mt">
                      <a class="active" href="home">
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
                          <li><a  href="<c:url value="/clientes"/>">Listar</a></li>

                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-paw"></i>
                          <span>Animal</span>
                      </a>
                      <ul class="sub">
                          <li><a   href="<c:url value="/animal/cadastro"/>">Cadastrar</a></li>
                          <li><a   href="<c:url value="/animais"/>">Listar</a></li>

                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-group"></i>
                          <span>Funcionário</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="<c:url value="/funcionario/cadastro"/>">Cadastrar</a></li> 
                          <li><a  href="<c:url value="/funcionarios"/>">Listar</a></li>
                      </ul>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-group"></i>
                          <span>Produto</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="<c:url value="/produto/cadastro"/>">Cadastrar</a></li> 
                          <li><a  href="<c:url value="/produtos"/>">Listar</a></li>
                      </ul>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-group"></i>
                          <span>Serviço</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="<c:url value="/servico/cadastro"/>">Cadastrar</a></li> 
                          <li><a  href="<c:url value="/servicos"/>">Listar</a></li>
                      </ul>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-group"></i>
                          <span>Consulta</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="<c:url value="/consulta/cadastro"/>">Cadastrar</a></li> 
                          <li><a  href="<c:url value="/consultas"/>">Listar</a></li>
                      </ul>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-group"></i>
                          <span>Agenda</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="<c:url value="/agenda/cadastro"/>">Cadastrar</a></li> 
                          <li><a  href="<c:url value="agendaList"/>">Listar</a></li>
                          
                      </ul>
                  </li>
              </ul>
          </div>
      </aside>          
      </section>
     