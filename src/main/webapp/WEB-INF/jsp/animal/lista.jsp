<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Animais</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  
                                  <th>Nome</th>
                                  <th>Sexo</th>
                                  <th>Raça</th>
                                  <th>Especie</th>
                                  <th>Porte</th>
                                  <th>Idade</th>
                                  <th>Dono</th>

                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${animais}" var = "animal">
	              	          <tr>
	              	             
	              	              <td>${animal.nome}</td>
                                  <td>${animal.sexo}</td>
	              	              <td>${animal.raca}</td>
	              	              <td>${animal.especie}</td>
                                  <td>${animal.porte}</td>
                                  <td>${animal.idade}</td>
	              	              <td>${animal.dono.nome}</td>
	              	              <td>
	              	                <a href="animal/edita/${animal.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="animal/remove/${animal.id}" class="btn btn-danger btn-xs" onclick="return confirm('Deseja realmente excluir?');"><i class="fa fa-trash-o"></i></a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
	             
