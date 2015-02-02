<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Cadastrar Funcionário</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <h4><i class="fa"></i> Preencha o formulario</h4>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[FuncionarioController].adiciona}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.nome" value="${funcionario.nome}">
                              	  <span class="erros">${errors.from('nome')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Função:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.funcao"  value="${funcionario.funcao}">
                              	  <span class="erros">${errors.from('funcao')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cpf:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.cpf"  value="${funcionario.cpf}">
                                  <span class="help-block">Não use(.), hifen(-) ou barra (/).</span><br>
                              	  <span class="erros">${errors.from('cpf')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cidade:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.cidade"  value="${funcionario.cidade}">
                                  <span class="erros">${errors.from('cidade')}</span>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Bairro:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.bairro"  value="${funcionario.bairro}">
                                  <span class="erros">${errors.from('bairro')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Rua:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.rua"  value="${funcionario.rua}">
                                  <span class="erros">${errors.from('rua')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Complemento:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.complemento"  value="${funcionario.complemento}">
                              	  <span class="erros">${errors.from('complemento')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Telefone:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.telefone"  value="${funcionario.telefone}">
                              	  <span class="erros">${errors.from('telefone')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Email:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" placeholder="email.@exemplo.com" name="funcionario.email"  value="${funcionario.email}">
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
