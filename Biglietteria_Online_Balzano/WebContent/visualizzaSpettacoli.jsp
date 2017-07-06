<%@include file="view_header.jsp" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>Visualizza spettacoli</h1>
                
                <%! Teatri t = new Teatri(); %>

		<%
		
		ArrayList<ArrayList<Object>> dati = t.visualizzaSpettacoliPerTeatro();
		
		%>


				<table class="table table-striped">

					<%
						
						for (ArrayList<Object> dato: dati){		
							String nomeTeatro = (String)dato.get(0);
							String titolo = (String)dato.get(1);
							String autore = (String)dato.get(2);
							String regista = (String)dato.get(3);
							Double prezzo = (Double)dato.get(4);
							Date dataReplica = (Date)dato.get(5);
							String codReplica = (String)dato.get(6);
						%>
						<tr><td><%=nomeTeatro%></td>
						<td><%=titolo%></td>
						<td><%=autore%></td>
						<td><%=regista%></td>
						<td><%=prezzo%></td>
						<td><%=dataReplica%></td>
						<td><%=codReplica%></td></tr>

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