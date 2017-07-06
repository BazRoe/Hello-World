<%@include file="view_header.jsp" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>I tuoi biglietti prenotati</h1>
                
                
                <% 
                	Clienti c = (Clienti) session.getValue("cliente");
					String cod_cliente =  c.getCodCliente();
				%>

				<%! Biglietti b = new Biglietti(); %>
				<%
					ArrayList<ArrayList<Object>> dati = b.elencoBiglietti(cod_cliente);
		
				%>


				<table class="table table-striped">

					<%
						
						for (ArrayList<Object> dato: dati){		
							String cognome = (String)dato.get(0);
							String nomeCliente = (String)dato.get(1);
							String tipoPagamento = (String)dato.get(2);
							int quantita = (Integer)dato.get(3);
							Date dataReplica = (Date)dato.get(4);
							String titolo = (String)dato.get(5);
							String autore = (String)dato.get(6);
							String regista = (String)dato.get(7);
							String nomeTeatro = (String)dato.get(8);
						%>
						<tr><td><%=cognome%></td>
						<td><%=nomeCliente%></td>
						<td><%=tipoPagamento%></td>
						<td><%=quantita%></td>
						<td><%=dataReplica%></td>
						<td><%=titolo%></td>
						<td><%=autore%></td>
						<td><%=regista%></td>
						<td><%=nomeTeatro%></td></tr>

<%-- 					<tr><td><a href="pagina3.jsp?tratta=<%= spett%>"><%=spett%></a></td></tr> --%>
		
					<% } %>
					
                </table>
                <div class="bottoni">
                	<a href="benvenuto.jsp" class="btn btn-primary">Torna al menù</a>
                </div>
				
 
                
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
<%@include file="view_footer.jsp" %>