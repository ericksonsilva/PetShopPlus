<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Clientes</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  <th>Cpf</th>
                                  <th>Nome</th>
                                  <th>Cidade</th>
                                  <th>Cep</th>
                                  <th>Bairro</th>
                                  <th>Telefone</th>
                                  <th>Email</th>

                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${clienteList}" var = "cliente">
	              	          <tr>
	              	              <td>${cliente.cpf}</td>
	              	              <td>${cliente.nome}</td>
	              	              <td>${cliente.cidade}</td>
	              	              <td>${cliente.cep}</td>
	              	              <td>${cliente.bairro}</td>
	              	              <td>${cliente.telefone}</td>
	              	              <td>${cliente.email}</td>
	              	              <td>
	              	                <a href="cliente/edita/${cliente.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="cliente/remove/${cliente.id}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
	             
