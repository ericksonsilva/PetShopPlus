<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Serviço</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  <th>Nome</th>
                                  <th>Descrição</th>
                                  <th>Valor</th>                                  
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${servicoList}" var = "servico">
	              	          <tr>
	              	              <td>${servico.nome}</td>
	              	              <td>${servico.descricao}</td>
	              	              <td>${servico.valor}</td>	              	              
	              	              <td>
	              	                <a href="servico/edita/${servico.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="servico/remove/${servico.id}" class="btn btn-danger btn-xs" onclick="return confirm('Deseja realmente excluir?');"><i class="fa fa-trash-o"></i></a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
	             
