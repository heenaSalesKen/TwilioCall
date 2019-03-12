

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.google.common.collect.Lists;
import com.twilio.Twilio;
import com.twilio.jwt.client.ClientCapability;
import com.twilio.jwt.client.IncomingClientScope;
import com.twilio.jwt.client.OutgoingClientScope;
import com.twilio.jwt.client.Scope;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TwilioCall
 */
@WebServlet("/TwilioCall")
public class TwilioCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientCapability.Builder capabilityBuilder;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwilioCall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		final String ACCOUNT_SID = "AC987e2fbf310cf57077bc6e7d64fd17d5";
	    final String AUTH_TOKEN = "b28ab3467f6cf8beea18de7bf92d5b4f";
	    
	    capabilityBuilder=new ClientCapability.Builder(ACCOUNT_SID, AUTH_TOKEN);
	    OutgoingClientScope outgoingScope = new OutgoingClientScope.Builder("APa2253d53957d6ebf4ac2cdfa521149eb").build();
	    IncomingClientScope incomingScope = new IncomingClientScope("test");
	    
	    List<Scope> scopes = Lists.newArrayList(outgoingScope, incomingScope);

	    String token = capabilityBuilder.scopes(scopes).build().toJwt();
	    System.out.println(token);
	   
	  
	    request.setAttribute("token",token); //Setting UsernameLabel to mes_add_pageTitle

	    RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
	    rd.forward(request,response);
	   

        
    
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
