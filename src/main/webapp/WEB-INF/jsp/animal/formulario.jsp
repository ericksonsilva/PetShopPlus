<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Cadastrar Animal</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <h4><i class="fa"></i> Preencha o formulario</h4>
                                            <form class="form-horizontal style-form" method="Post" action="${linkTo[AnimalController].adiciona}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.nome"  value="${animal.nome}">
                              	  <span class="erros">${errors.from('nome')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Sexo:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.sexo" value="${animal.sexo}">
                                  <span class="erros">${errors.from('sexo')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Raça:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.raca" value="${animal.raca}">
                                  <span class="erros">${errors.from('raca')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Especie:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.especie" value="${animal.especie}">
                              	  <span class="erros">${errors.from('especie')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Porte:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.porte" value="${animal.porte}">
                              	  <span class="erros">${errors.from('porte')}</span>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Idade:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.idade" value="${animal.idade}">
                              	  <span class="erros">${errors.from('idade')}</span>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label for="cliente" class="col-sm-2 col-sm-2 control-label">Dono:</label>
                              <div class="col-sm-10">
                                   <select class="form-control" name="animal.dono.id" >
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
