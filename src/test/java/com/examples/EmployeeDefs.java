package com.examples;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class EmployeeDefs {

	String actualResponse=null;
	GlobalWeather service=new GlobalWeather();
	GlobalWeatherSoap webService=service.getGlobalWeatherSoap();
	
	@When("^the client calls /customer$")
	public void the_employee_issues_GET_version() throws Throwable {
		actualResponse=webService.getCitiesByCountry("India");
	}
	
	@Then("^the employee receives status code of (\\d+)$")
	public void thestatus_code_of_employee_code(int statusCode) throws Throwable {
		//final int currentStatusCode = service.
		//System.out.println(currentStatusCode + "From Actaul Response");
		System.out.println(statusCode + " : From Feature File");
		//assertThat("status code is incorrect : "+ currentStatusCode, is(statusCode));
	}
	
	@And("^the response should contain:$")
	public void the_employee_receives_server_version_body(String version) throws Throwable {
		System.out.println(actualResponse + "From Actaul Response");
		System.out.println(version + " : From Feature File");
		Assert.assertEquals(actualResponse,version);
		//assertTrue("Message Assertion Status",version.equals(response));
	}
	
}
