<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Agendar Consulta</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <h4><i class="fa"></i> Preencha o formulario</h4>
                                            <form class="form-horizontal style-form" method="Post" action="${linkTo[AgendaController].adiciona}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Data:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="agenda.data"  value="${agenda.data}">
                              </div>
                          </div>
                          
                           <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Horário:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="agenda.hora" value="${agenda.hora}"></textarea>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Descrição:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="agenda.descricao" value="${agenda.descricao}"></textarea>
                              </div>
                          </div>
                                                                             
                      
                          <div class="form-group">
                              <label for="animal" class="col-sm-2 col-sm-2 control-label">Animal:</label>
                              <div class="col-sm-10">
                                   <select class="form-control" name="agenda.animal.id" >
                                   <c:forEach items="${animais}" var = "animal">
									  <option  value="${animal.id}">${animal.nome}</option>
									  </c:forEach>
									</select>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label for="cliente" class="col-sm-2 col-sm-2 control-label">Dono:</label>
                              <div class="col-sm-10">
                                   <select class="form-control" name="agenda.cliente.id" >
                                   <c:forEach items="${clientes}" var = "cliente">
									  <option  value="${cliente.id}">${cliente.nome}</option>
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
