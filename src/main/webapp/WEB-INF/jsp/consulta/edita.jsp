<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Editar Consulta</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <a href="${linkTo[ConsultaController].lista}"><i class="fa fa-arrow-circle-o-left"></i> Voltar</a>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[ConsultaController].atualiza}">
                          <input type="hidden" class="form-control" name="consulta.id" value="${consulta.id}">
                           <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Data:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="consulta.data"  value="<fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.data}" />">
                              </div>
                          </div>
                          
                           <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Horário:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="consulta.hora" value="">${consulta.hora}</textarea>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Descrição:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="consulta.descricao" value="">${consulta.descricao}</textarea>
                              </div>
                          </div>
                   
                           <input type="hidden" class="form-control" name="consulta.cliente.id" value="${consulta.cliente.id}">
                           <input type="hidden" class="form-control" name="consulta.animal.id" value="${consulta.animal.id}">
                           <input type="hidden" class="form-control" name="consulta.funcionario.id" value="${consulta.funcionario.id}">
                            <input type="hidden" class="form-control" name="consulta.servico.id" value="${consulta.servico.id}">
                          
                       
                          
                          <button type="submit" class="btn btn-primary btnCadastro" name="_method" value="PUT">
								Atualizar
						  </button>
                      </form>
                  </div>
              </div>    
            </div>
           
    </section>
      </section>
