<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Cadastrar Cliente</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <h4><i class="fa"></i> Preencha o formulario</h4>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[ClienteController].adiciona}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.nome" value="${cliente.nome}">
                                  <span class="erros">${errors.from('nome')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cpf:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.cpf" value="${cliente.cpf}">
                                  <span class="help-block">Não use(.), hifen(-) ou barra (/).</span><br>
                     			  <span class="erros">${errors.from('cpf')}</span>
                             </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cidade:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.cidade" value="${cliente.cidade}">
                              	  <span class="erros">${errors.from('cidade')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cep:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.cep" value="${cliente.cep}">
                                  <span class="help-block">Não use hifen(-).</span><br>
                                  <span class="erros">${errors.from('cep')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Bairro:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.bairro" value="${cliente.bairro}">
                              	  <span class="erros">${errors.from('bairro')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Rua:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.rua" value="${cliente.rua}">
                                  <span class="erros">${errors.from('rua')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Complemento:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.complemento" value="${cliente.complemento}">
                              	  <span class="erros">${errors.from('complemento')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Telefone:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="cliente.telefone" value="${cliente.telefone}">
                              	  <span class="erros">${errors.from('telefone')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Email:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" placeholder="email.@exemplo.com" name="cliente.email" value="${cliente.email}">
                              	  <span class="erros">${errors.from('email')}</span>
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
