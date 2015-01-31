<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Editar Funcionário</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <a href="${linkTo[FuncionarioController].lista}"><i class="fa fa-arrow-circle-o-left"></i> Voltar</a>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[FuncionarioController].atualiza}">
                          <input type="hidden" class="form-control" name="funcionario.id" value="${funcionario.id}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.nome" value="${funcionario.nome}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Função:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.funcao" value="${funcionario.funcao}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cpf:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.cpf" value="${funcionario.cpf}">
                                  <span class="help-block">Não use(.), hifen(-) ou barra (/).</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Cidade:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.cidade" value="${funcionario.cidade}">
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Bairro:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.bairro" value="${funcionario.bairro}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Rua:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.rua" value="${funcionario.rua}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Complemento:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.complemento" value="${funcionario.complemento}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Telefone:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="funcionario.telefone" value="${funcionario.telefone}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Email:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" placeholder="email.@exemplo.com" name="funcionario.email" value="${funcionario.email}">
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
