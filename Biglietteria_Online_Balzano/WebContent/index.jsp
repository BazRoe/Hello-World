<%@include file="view_header.jsp" %>

		<% 
			session.putValue("cliente", null);
			
		%>


	<div class="row">
        <div class="col-lg-12 text-center">
        
                <h1>Benvenuto nella biglietteria On Line</h1>
		                
			<form action="benvenuto.jsp" method="post">
				<input type="text"  name="cod_cliente" placeholder="Inserisci il tuo codice utente" />
				<input type="submit" value="invia" />
			</form>

        </div>
     </div>


<%@include file="view_footer.jsp" %>
