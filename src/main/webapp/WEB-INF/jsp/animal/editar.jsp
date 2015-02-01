<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Editar Animal</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <a href="${linkTo[AnimalController].lista}"><i class="fa fa-arrow-circle-o-left"></i> Voltar</a>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[AnimalController].atualiza}">
                          <input type="hidden" class="form-control" name="animal.id" value="${animal.id}">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="animal.nome" value="${animal.nome}">
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
                           <input type="hidden" class="form-control" name="animal.dono.id" value="${animal.dono.id}">
                          
                          <button type="submit" class="btn btn-primary btnCadastro" name="_method" value="PUT">
								Atualizar
						  </button>
                      </form>
                  </div>
              </div>    
            </div>
           
    </section>
      </section>
