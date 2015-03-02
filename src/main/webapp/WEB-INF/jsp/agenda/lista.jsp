<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Consultas Marcadas</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  
                                  <th>Data</th>
                                  <th>Horário</th>                                  
                                  <th>Descrição</th>
                                  <th>Animal</th>
                                  <th>Cliente</th>     
                                  <th>Funcionario</th>                            

                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${marcados}" var = "marcados">
	              	          <tr>
	              	             
	              	              <td>${marcados.data}</td>
	              	              <td>${marcados.hora}</td>
                                  <td>${marcados.descricao}</td>
	              	              <td>${marcados.animal.nome}</td>
	              	              <td>${marcados.cliente.nome}</td>
	              	              <td>${marcados.funcionario.nome}</td>
	              	              <td>
	              	                <a href="agenda/edita/${agenda.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="agenda/desmarcar/${agenda.id}" class="btn btn-danger btn-xs"  onclick="return confirm('Deseja realmente desmarcar?');"><i class="fa fa-times"></i></a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              
                            	           
	        
	             
