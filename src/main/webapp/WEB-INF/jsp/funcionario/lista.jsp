<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Funcionários</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  <th>Cpf</th>
                                  <th>Nome</th>
                                  <th>Função</th>
                                  <th>Cidade</th>
                                  <th>Bairro</th>
                                  <th>Rua</th>
                                  <th>Telefone</th>
                                  <th>Email</th>

                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${funcionarioList}" var = "funcionario">
	              	          <tr>
	              	              <td>${funcionario.cpf}</td>
	              	              <td>${funcionario.nome}</td>
                                  <td>${funcionario.funcao}</td>
	              	              <td>${funcionario.cidade}</td>
	              	              <td>${funcionario.bairro}</td>
                                  <td>${funcionario.rua}</td>
                                  <td>${funcionario.telefone}</td>
	              	              <td>${funcionario.email}</td>
	              	              <td>
	              	                <a href="funcionario/edita/${funcionario.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="funcionario/remove/${funcionario.id}" class="btn btn-danger btn-xs" onclick="return confirm('Deseja realmente excluir?');"><i class="fa fa-trash-o"></i></a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
	             
