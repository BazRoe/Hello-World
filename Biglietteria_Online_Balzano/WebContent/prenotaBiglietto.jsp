<%@include file="view_header.jsp" %>
<%@ page import="dao.*" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>Prenota i tuoi spettacoli</h1>

			<%  Clienti cliente = (Clienti) session.getValue("cliente");   %>
			
			<h1><%= cliente.getNome()%></h1>
		
<%-- 			<% int id_tratta =  Integer.parseInt(   request.getParameter("tratta")   )  ; %> --%>
<%-- 			<%  Tratte t = new Tratte();  %> --%>
<%-- 			<%  Tratte prenotaTratta = t.trovaTratta(id_tratta);  %> --%>
		
<!-- 				<h1>prenotazione viaggio</h1> -->
<%-- 				<%= utente.getUtente() %>	 --%>
<%-- 				<%= prenotaTratta.getDescrizione()%> --%>
<%-- 				<% session.putValue("tratta", prenotaTratta); %> --%>

		<form action="paginaResoconto.jsp" method="post">
		
	
		<div class="bottoni">
			Codice Cliente: <input type="text"  name="cod_cliente" value="<%= cliente.getCodCliente() %>"  /><br/>
		</div>
		<div class="bottoni">
			Codice Replica: <input type="text"  name="cod_replica" value="" placeholder="inserisci codice replica"  /><br/>
		</div>
		<div class="bottoni">
			numero biglietti <input type="number" name="num_biglietti"></br>		
		</div>
		<div class="bottoni">
			Tipo di pagamento: <select name="tipo_pagamento">
								   <option value="Carta di credito">Carta di Credito</option>
								   <option value="Bonifico">Bonifico</option>
							   </select></br>		
		</div>
		<div class="bottoni">
			<input class="btn btn-warning" type="submit" name= "invia_prenotazione" value="prenota" />
		</div>
			
			
				
		</form>
		
		<div class="bottoni">
			<a href="benvenuto.jsp" class="btn btn-primary">Torna al menù</a>
		</div>
 
                
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
<%@include file="view_footer.jsp" %>