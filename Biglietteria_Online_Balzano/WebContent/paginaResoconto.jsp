<%@include file="view_header.jsp" %>
<%@ page import="dao.*" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>Resoconto Prenotazione</h1>
                
<%--                 <%! Biglietti b = new Biglietti(); %> --%>

				<% 
					String cod_cliente = request.getParameter("cod_cliente");
					String cod_replica = request.getParameter("cod_replica");
					int num_biglietti = Integer.parseInt(request.getParameter("num_biglietti"));
					String tipo_pagamento = request.getParameter("tipo_pagamento");
					
					Biglietti b = new Biglietti(cod_cliente, cod_replica, tipo_pagamento, num_biglietti);
				%>
				
				
<%-- 				<%= session.getValue("utente") %><br/> --%>
<%-- 				<%= session.getValue("tratta") %><br/> --%>
<%-- 				<%= num_biglietti %> --%>
<%-- 				<%= data_prenotazione %> --%>
			
				<%
				if(b.controllaPosti(cod_replica, num_biglietti)){
						if(b.inserisciBiglietto()){
							out.println("");
							out.println("prenotazione effettuata");
						}
						else{
							out.println("");
							out.println("Errore, prenotazione non effettuata");
						}
				}else{
					out.println("");
					out.println("Posti esauriti per questo spettacolo");
				}
				%>


		<div class="bottoni">
			<a href="prenotaBiglietto.jsp" class="btn btn-primary">Torna alle prenotazioni</a>
		</div>
 
                
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
<%@include file="view_footer.jsp" %>