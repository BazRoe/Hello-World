<%@include file="view_header.jsp" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.ArrayList" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>Visualizza spettacoli</h1>
                <p class="lead">Complete with pre-defined file paths that you won't have to change!</p>
                
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
							String dataReplica = (String)dato.get(5);
							String codReplica = (String)dato.get(6);
						%>
						<tr><td><%=nomeTeatro%></td></tr>
						<tr><td><%=titolo%></td></tr>
						<tr><td><%=autore%></td></tr>
						<tr><td><%=regista%></td></tr>
						<tr><td><%=prezzo%></td></tr>
						<tr><td><%=dataReplica%></td></tr>
						<tr><td><%=codReplica%></td></tr>

<%-- 					<tr><td><a href="pagina3.jsp?tratta=<%= spett%>"><%=spett%></a></td></tr> --%>
		
					<% } %>
					
                </table>
 
 
 
 
 
                
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
<%@include file="view_footer.jsp" %>