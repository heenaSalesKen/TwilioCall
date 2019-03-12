

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.twiml.*;
import com.twilio.twiml.Number;


@SuppressWarnings("serial")
@WebServlet("/voice")
public class CallController extends HttpServlet {
  // Handle HTTP POST to /voice
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
	  String twilioPhoneNumber = null;
	  String phoneNumber = "+919739888988";
	  Dial.Builder dialBuilder = new Dial.Builder();
	  Number number = new Number.Builder(phoneNumber).build();
	  dialBuilder = dialBuilder.number(number).callerId(twilioPhoneNumber);
	  Dial dial = dialBuilder.build();
	  VoiceResponse twimlResponse = new VoiceResponse.Builder().dial(dial).build();
    // Render TwiML as XML
    response.setContentType("text/xml");
    try {
		response.getWriter().print(twimlResponse.toXml());
	} catch (com.twilio.twiml.TwiMLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}







