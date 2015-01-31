<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            
            <h3> Editar Cliente</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                  <a href="${linkTo[ClienteController].lista}"><i class="fa fa-arrow-circle-o-left"></i> Voltar</a>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[ClienteController].atualiza}">
                          <input type="hidden" name="cliente.id" value="${cliente.id}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.nome" value="${cliente.nome}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cpf:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.cpf" value="${cliente.cpf}">
                                  <span class="help-block">Não use(.), hifen(-) ou barra (/).</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cidade:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.cidade" value="${cliente.cidade}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cep:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.cep" value="${cliente.cep}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Bairro:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.bairro" value="${cliente.bairro}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Rua:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.rua" value="${cliente.rua}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Complemento:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.complemento" value="${cliente.complemento}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Telefone:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.telefone" value="${cliente.telefone}">
                              </div>
                          </div>
                          <div class="forneto@.comm-group">
                              <label class="col-sm-2 col-sm-2 control-label">Email:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" placeholder="email.@exemplo.com" name="cliente.email" value="${cliente.email}">
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
