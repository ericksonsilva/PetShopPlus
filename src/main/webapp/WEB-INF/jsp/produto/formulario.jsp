<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Cadastrar Produto</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <h4><i class="fa"></i> Preencha o formulario</h4>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[ProdutoController].adiciona}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="produto.nome" value="${produto.nome}">
                                  <span class="erros">${errors.from('nome')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Descrição:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="produto.descricao" value="${produto.descricao}"></textarea>
                     			  <span class="erros">${errors.from('descricao')}</span>
                             </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Preço:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="produto.preco" value="${produto.preco}">
                              	  <span class="erros">${errors.from('preco')}</span>
                              </div>
                          </div>                   
                          <button type="submit" class="btn btn-primary btnCadastro">
								Cadastrar
						  </button>
                      </form>
                  </div>
              </div>    
            </div>
           
    </section>
      </section>
