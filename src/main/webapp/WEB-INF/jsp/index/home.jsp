<%@ include file="../menu/menu.jsp" %>

      <section id="main-content">
          <section class="wrapper">
          		 <div align="center">
          		 
              	  <br><br><br><br><br><p><img src="images/logo.png"></a></p>
              	  <br><br><h5>Sistema gerenciador de PetShops</h5><br><br><br><br><br><br>
              	  <div style="width: 80%; display: table;">
              	  <div style="width: 600px; display: table-cell;">
              	   <h4>Quantidade de registros</h4>
              	  <canvas id="registros" value="${registros}" width="300" height="200"></canvas>  
              	  </div>
        				<div style="display: table-cell;">
        				  <h4>Situação das consultas</h4>
          		 <canvas id="consultas" value="${consultas}" width="300" height="200"></canvas> 
        				</div>
              	 
              	        		 
              	  </div>
              	          		 
              	  </div>
              	  <script>
              	var registros = document.getElementById("registros");
              	var attribute = registros.getAttribute("value");
              	list = attribute.split('_');
              	var barData = {
              			labels : ["Animais","Clientes","Serviços","Produtos"],
              			datasets : [
              				{
              					fillColor : "#48A497",
              					strokeColor : "#48A4D1",
              					data : [list[0],list[1],list[2],list[3]]
              				}
              			]
              		}
 
              	  </script>
              	  <script>
              		var consultas = document.getElementById("consultas");
              		var attribute = consultas.getAttribute("value");
                  	list = attribute.split('_');
              		var pieOptions = {
              				segmentShowStroke : false,
              				animateScale : true
              			};
              		var pieData = [
                	          {
                	              value: list[0],
                	              color:"#F7464A",
                	              highlight: "#FF5A5E",
                	              label: "Marcadas"
                	          },
                	          {
                	              value: list[1],
                	              color: "#46BFBD",
                	              highlight: "#5AD3D1",
                	              label: "Desmarcadas"
                	          },
                	          {
                	              value: attribute[2],
                	              color: "#FDB45C",
                	              highlight: "#FFC870",
                	              label: "Atendidas"
                	          }
                	      ]
              	  </script>
              	  <script>
				var consultas= document.getElementById("consultas").getContext("2d");
				consultas.fillStyle = "blue";
				consultas.font = "bold 16px Arial";
              	consultas.fillText('Pizza',100,100);
				new Chart(consultas).Pie(pieData, pieOptions);
              
				</script>
              	  <script>
              	var registros = document.getElementById("registros").getContext("2d");
              	new Chart(registros).Bar(barData);
				</script>
				

