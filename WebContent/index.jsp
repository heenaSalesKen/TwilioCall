<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script type="text/javascript"
      src="//media.twiliocdn.com/sdk/js/client/v1.3/twilio.min.js"></script>
      <script type="text/javascript"
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js">
    </script>
    
</head>
<body>
<form action="TwilioCall/src/TwilioCall" method="post">  
 <input type="text" id="number" name="number"
      placeholder="Enter a phone number to call"/>


<input type="submit" value="login" placeholder="click to call"/>  
  <div id="log">Loading pigeons...</div>
</form>  
<% String userlabel=(String)request.getAttribute("token"); %>

</body>
<script>




	 
		
	    Twilio.Device.setup('<%= userlabel %>');
	   

Twilio.Device.ready(function (device) {
    $("#log").text("Ready");
  });

  Twilio.Device.error(function (error) {
    $("#log").text("Error: " + error.message);
  });

  Twilio.Device.connect(function (conn) {
    $("#log").text("Successfully established call");
  });

  Twilio.Device.disconnect(function (conn) {
    $("#log").text("Call ended");
  });

  Twilio.Device.incoming(function (conn) {
    $("#log").text("Incoming connection from " + conn.parameters.From);
    // accept the incoming connection and start two-way audio
    conn.accept();
  });

  function call() {
    // get the phone number to connect the call to
    params = {"PhoneNumber": $("#number").val()};
    console.log("fgfgfg");
    Twilio.Device.connect();
  }

  function hangup() {
    Twilio.Device.disconnectAll();
  }



</script>
</html>
