<%@ include file="../menu/menu.jsp" %>
      
	            <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                          <table class="table table-striped table-advance table-hover" >
	                  	  	  <h4><i class="fa fa-angle-right"></i> Lista de Produtos</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>                              	  
                                  <th>Nome</th>
                                  <th>Descrição</th>
                                  <th>Preço</th>                                  
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${produtoList}" var = "produto">
	              	          <tr>
	              	              <td>${produto.nome}</td>
	              	              <td>${produto.descricao}</td>
	              	              <td>${produto.preco}</td>	              	              
	              	              <td>
	              	                <a href="produto/edita/${produto.id}" class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
	              	                <a href="produto/remove/${produto.id}" class="btn btn-danger btn-xs" onclick="return confirm('Deseja realmente excluir?');"><i class="fa fa-trash-o"></i></a>
                                  </td>
	              	          </tr>
	              	    	  </c:forEach>
                              </tbody>
                          </table>
                      </div>
                  </div>
              </div>
	             
