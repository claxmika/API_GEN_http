package com.examples;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

//import gherkin.deps.net.iharder.Base64.InputStream;
//import gherkin.deps.net.iharder.Base64.OutputStream;


@WebAppConfiguration
@IntegrationTest

public class SpringIntegrationTest {
	HttpResponse LatestResponse;
	String response;
	
	public void executeGet () throws ClientProtocolException, IOException {

	try {	
		 /*String RequestXML = ".\\src\\test\\java\\com\\examples\\Request.xml";
		 
		 URL url = new URL(customerAPI);
		 URLConnection connection = url.openConnection();
		 HttpURLConnection httpConn = (HttpURLConnection) connection;

		 FileInputStream fin = new FileInputStream(RequestXML);
		 ByteArrayOutputStream bout = new ByteArrayOutputStream();
		 copy(fin, bout);
		 fin.close();
		 byte[] b = bout.toByteArray();
		 StringBuffer buf=new StringBuffer();
		 String s=new String(b);
		 
		//replacing a sample value in Request XML
		 s=s.replaceAll("VALUE","India");
		 b=s.getBytes();
		 
		 // Set the appropriate HTTP parameters.
		 	httpConn.setRequestProperty("Host","www.webservicex.com");
	        httpConn.setRequestProperty("Content-Length", "length");
	        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
	        httpConn.setRequestProperty("SOAPAction", "http://www.webserviceX.NET/GetWeather");
	        httpConn.setRequestMethod("POST");
	        httpConn.setDoOutput(true);
		 
		// send the XML that was read in to b.
	        OutputStream out = (OutputStream) httpConn.getOutputStream();
	        out.write(b);
	        out.close();
	        	
			 httpConn.connect();
		        System.out.println("http connection status :"+ httpConn.getResponseMessage());
		        response = httpConn.getResponseMessage();
		        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		        BufferedReader in = new BufferedReader(isr);
		     
		      
		        in.close();
*/		            
			GlobalWeather service=new GlobalWeather();
			GlobalWeatherSoap webService=service.getGlobalWeatherSoap();
			String weather=webService.getWeather("", "India");
			System.out.println("Weather in India:"+weather);
			 
			 
		 } finally {
			 System.out.println("FINAL MESSAGE");
		 }
		
	}



	public static void copy(FileInputStream fin, ByteArrayOutputStream bout)
	            throws IOException {

	        synchronized (fin) {
	            synchronized (bout) {
	                byte[] buffer = new byte[256];
	                while (true) {
	                    int bytesRead = fin.read(buffer);
	                    if (bytesRead == -1)
	                        break;
	                    bout.write(buffer, 0, bytesRead);
	                }
	            }
	        }
	    }
	}

