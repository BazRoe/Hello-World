<%@include file="view_header.jsp" %>
<%@ page import="dao.*" %>

		<%! Clienti c = new Clienti(); %>
		<%! Clienti cliente = new Clienti(); %>
		
		<% String id_c = request.getParameter("cod_cliente"); %>

		<%
		if((session.getValue("cliente")) != null){
			cliente = (Clienti) session.getValue("cliente");
		}else{
			cliente= c.trovaCliente(id_c); 		
		}
		%>
		<% 
			session.putValue("cliente", cliente);
			
		%>
		
		<div class="row">
        	<div class="col-lg-12 text-center">

					<h1>Benvenuto/a </br> <%= cliente.getNome()%></h1>
					
<%-- 				</br>	<%= cliente.getCodCliente()%> --%>
<%-- 				</br>	<%= cliente.getCognome()%> --%>
<%-- 				</br>	<%= cliente.getEmail()%> --%>
<%-- 				</br>	<%= cliente.getTelefono()%> --%>
					
				<div class="row bottoni">
					<a href="visualizzaSpettacoli.jsp" class="btn btn-primary">Visualizza elenco spettacoli</a> 
				</div>	
				<div class="row bottoni">
					<a href="prenotaBiglietto.jsp" class="btn btn-primary">Prenota un biglietto</a> 
				</div>	
				<div class="row bottoni">
					<a href="visualizzaPrenotazioni.jsp"  class="btn btn-primary">Visualizza prenotazioni</a>
				</div>	
				
				<div class="row bottoni">
					<a href="index.jsp"  class="btn btn-default">Esci</a>
				</div>
				
			</div>
		</div>

<%@include file="view_header.jsp" %>