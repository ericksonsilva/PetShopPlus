<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Consultas Desmarcadas</h4>
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
                              <c:forEach items="${desmarcados}" var = "desmarcados">
	              	          <tr>
	              	             
	              	              <td>0${desmarcados.data.getDay()+1}/0${desmarcados.data.getMonth()+1}/20${desmarcados.data.getYear()-100}</td>
	              	              <td>${desmarcados.hora}</td>
                                  <td>${desmarcados.descricao}</td>
	              	              <td>${desmarcados.animal.nome}</td>
	              	              <td>${desmarcados.cliente.nome}</td>
	              	              <td>${desmarcados.funcionario.nome}</td>
	              	              <td>
	              	                <a href="agenda/remarcar/${desmarcados.id}" class="btn btn-danger btn-xs"  onclick="return confirm('Deseja realmente Remarcar a Consulta?');">Remarcar</a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              
                            	           
	        
	             
