<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
          <div class="erros">
			  <ul>
			    <c:forEach items="${errors}" var="error">
			     <li><h5><i class="fa fa-exclamation-circle"></i>ERRO - ${error.message }</h5></li>
			    </c:forEach>
			  </ul>
			</div>
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
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Sexo:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.sexo" value="${animal.sexo}">
                                  
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Raça:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.raca" value="${animal.raca}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Especie:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.especie" value="${animal.especie}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Porte:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.porte" value="${animal.porte}">
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Idade:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.idade" value="${animal.idade}">
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
