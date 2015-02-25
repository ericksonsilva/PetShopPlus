<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            
            <h3> Editar Serviço</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                  <a href="${linkTo[ServicoController].lista}"><i class="fa fa-arrow-circle-o-left"></i> Voltar</a>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[ServicoController].atualiza}">
                          <input type="hidden" name="servico.id" value="${servico.id}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="servico.nome" value="${servico.nome}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Descrição:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="servico.descricao" value="${servico.descricao}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Valor:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="servico.valor" value="${servico.valor}">
                              </div>
                          </div>
                          
                          <button type="submit" class="btn btn-primary btnCadastro" name="_method" value="PUT">
								Atualizar
						  </button>
										  
                      </form>
                  </div>
              </div>    
            </div>
           
    </section>
      </section>
