<%@ include file="../menu/menu.jsp" %>
      <section id="main-content">
          <section class="wrapper">
             <div class="container">
	             <h3>Clintes</h3>
	             <table class="table table-hover">
	                  <thead>
	                      <th>Id</th>
	                      <th>Nome</th>
	                      <th>Cpf</th>	
	                  </thead>
	              	  <tbody>
	              	      <c:forEach items="${clienteList}" var = "cliente">
	              	          <tr>
	              	              <td>${cliente.id}</td>
	              	              <td>${cliente.nome}</td>
	              	              <td>${cliente.cpf}</td>
	              	          </tr>
	              	      </c:forEach>
	              	  </tbody>
	              </table> 
              </div>
          </section>
      </section>
