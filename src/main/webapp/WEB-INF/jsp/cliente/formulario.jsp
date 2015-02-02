<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <div class="erros">
			  <ul>
			    <c:forEach items="${errors}" var="error">
			     <li><h5>ERRO - ${error.message }</h5></li>
			    </c:forEach>
			  </ul>
			</div>
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
                                  <span class="help-block">Não use hifen(-).</span>
                                  
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
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Email:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" placeholder="email.@exemplo.com" name="cliente.email" value="${cliente.email}">
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
