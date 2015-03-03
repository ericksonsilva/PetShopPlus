<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
            <h3> Editar Consulta</h3>          
            <div class="row mt">
              <div class="col-lg-12">
                  <div class="form-panel">
                      <a href="${linkTo[AgendaController].lista}"><i class="fa fa-arrow-circle-o-left"></i> Voltar</a>
                      <form class="form-horizontal style-form" method="Post" action="${linkTo[AgendaController].atualiza}">
                          <input type="hidden" class="form-control" name="agenda.id" value="${agenda.id}">
                           <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Data:</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="agenda.data"  value="0${agenda.data.getDay()+1}/0${agenda.data.getMonth()+1}/20${agenda.data.getYear()-100}">
                              </div>
                          </div>
                          
                           <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Horário:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="agenda.hora" value="">${agenda.hora}</textarea>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Descrição:</label>
                              <div class="col-sm-10">
                                  <textarea  class="form-control" name="agenda.descricao" value="">${agenda.descricao}</textarea>
                              </div>
                          </div>
                   
                           <input type="hidden" class="form-control" name="agenda.cliente.id" value="${agenda.cliente.id}">
                           <input type="hidden" class="form-control" name="agenda.animal.id" value="${agenda.animal.id}">
                           <input type="hidden" class="form-control" name="agenda.funcionario.id" value="${agenda.funcionario.id}">
                          
                       
                          
                          <button type="submit" class="btn btn-primary btnCadastro" name="_method" value="PUT">
								Atualizar
						  </button>
                      </form>
                  </div>
              </div>    
            </div>
           
    </section>
      </section>
