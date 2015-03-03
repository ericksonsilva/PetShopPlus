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
                                  <th>Hor�rio</th>                                  
                                  <th>Descri��o</th>
                                  <th>Animal</th>
                                  <th>Cliente</th>     
                                  <th>Funcionario</th>                            

                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${marcados}" var = "marcados">
	              	          <tr>
	              	             
	              	              <td>0${marcados.data.getDay()+1}/0${marcados.data.getMonth()+1}/20${marcados.data.getYear()-100}</td>
	              	              <td>${marcados.hora}</td>
                                  <td>${marcados.descricao}</td>
	              	              <td>${marcados.animal.nome}</td>
	              	              <td>${marcados.cliente.nome}</td>
	              	              <td>${marcados.funcionario.nome}</td>
	              	              <td>
	              	                <a href="agenda/edita/${marcados.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="agenda/desmarcar/${marcados.id}" class="btn btn-danger btn-xs"  onclick="return confirm('Deseja realmente desmarcar?');">Desmarcar</a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              
                            	           
	        
	             
