<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Cadastrar Consulta</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <h4><i class="fa"></i> Preencha o formulario</h4>
                                            <form class="form-horizontal style-form" method="Post" action="${linkTo[ConsultaController].adiciona}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Data:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="consulta.data"  value="${consulta.data}">
                              	  <span class="erros">${errors.from('data')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Descrição:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="consulta.descricao" value="${consulta.descricao}"></textarea>
                                  <span class="erros">${errors.from('descricao')}</span>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label for="servico" class="col-sm-2 col-sm-2 control-label">Serviço:</label>
                              <div class="col-sm-10">
                                   <select class="form-control" name="consulta.servico.id" >
                                   <c:forEach items="${servicos}" var = "servico">
									  <option  value="${servico.id}">${servico.nome}</option>
									  </c:forEach>
									</select>
                              </div>
                          </div>

                          <div class="form-group">
                              <label for="cliente" class="col-sm-2 col-sm-2 control-label">Cliente:</label>
                              <div class="col-sm-10">
                                   <select class="form-control" name="consulta.cliente.id" >
                                   <c:forEach items="${clientes}" var = "cliente">
									  <option  value="${cliente.id}">${cliente.nome}</option>
									  </c:forEach>
									</select>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label for="animal" class="col-sm-2 col-sm-2 control-label">Animal:</label>
                              <div class="col-sm-10">
                                   <select class="form-control" name="consulta.animal.id" >
                                   <c:forEach items="${animais}" var = "animal">
									  <option  value="${animal.id}">${animal.nome}</option>
									  </c:forEach>
									</select>
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
