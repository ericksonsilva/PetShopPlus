<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Consultas</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  
                                  <th>Data</th>
                                  <th>Descrição</th>
                                  <th>Serviço</th>
                                  <th>Animal</th>
                                  <th>Dono</th>                                

                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${consultas}" var = "consulta">
	              	          <tr>
	              	             
	              	              <td>${consulta.data}</td>
                                  <td>${consulta.descricao}</td>
	              	              <td>${consulta.servico.nome}</td>
	              	              <td>${consulta.animal.nome}</td>
	              	              <td>${consulta.cleinte.nome}</td>
	              	              <td>
	              	                <a href="consulta/edita/${consulta.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="consulta/remove/${consulta.id}" class="btn btn-danger btn-xs" onclick="return confirm('Deseja realmente excluir?');"><i class="fa fa-trash-o"></i></a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
	             
