<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Consultas Realizadas</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  
                                  <th>Data</th>
                                  <th>Horário</th>                                  
                                  <th>Descrição</th>
                                  <th>Animal</th>
                                  <th>Cliente</th>     
                                  <th>Funcionario</th>    
                                  <th>Serviço</th>   
                                                       

                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${consultas}" var = "consultas">
	              	          <tr>
	              	             	
	              	              <td><fmt:formatDate pattern="dd/MM/yyyy" value="${consultas.data}" /></td>
	              	              <td>${consultas.hora}</td>
                                  <td>${consultas.descricao}</td>
	              	              <td>${consultas.animal.nome}</td>
	              	              <td>${consultas.cliente.nome}</td>
	              	              <td>${consultas.funcionario.nome}</td>
	              	              <td>${consultas.servico.nome}</td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              
                            	           
	        
	             
