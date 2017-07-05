<%@include file="view_header.jsp" %>
<%@ page import="dao.*" %>
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>A Bootstrap Starter Template</h1>
                <p class="lead">Complete with pre-defined file paths that you won't have to change!</p>

		<%

		Rappresentazioni r = new Rappresentazioni();

		
		
		%>


				<table class="table table-striped">

					<%
						for (Rappresentazioni spett : r.getElenco()){		
						
						%>


					<tr><td><a href="pagina3.jsp?tratta=<%= spett%>"><%=spett%></a></td></tr>
		
					<% } %>
					
                </table>
 
 
 
 
 
                
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
<%@include file="view_footer.jsp" %>