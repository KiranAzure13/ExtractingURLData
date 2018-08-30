package com.javainuse.controllers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.javainuse.model.Employee;


import javax.print.DocFlavor;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@RestController
public class TestController {
	String pagecontent=" ";
	String pConcatenated="";
	/*@RequestMapping(value = "/employee", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	String Submit(@RequestParam("url") String name) {
		// your logic here
		return "got it";*/
		@CrossOrigin(origins = "http://localhost:8080")
		@RequestMapping(value = "/employee", method = {RequestMethod.POST,RequestMethod.GET},produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody
		String Submit(@RequestParam("urllink") String URLLINK) throws MalformedURLException,IOException {
			// your logic here
			if (!URLLINK.equals(null)) {
			/*	WebClient webClient = new WebClient(BrowserVersion.CHROME);
				webClient.getOptions().setJavaScriptEnabled(true);
				webClient.getOptions().setThrowExceptionOnScriptError(false);
				HtmlPage page = webClient.getPage(URLLINK);
				String pagecontent = page.asText();
				System.out.println(pagecontent);*/

				Document document = Jsoup.connect(URLLINK).get();
				String pagecontent  = document.select("div.story").text();
				System.out.println(pagecontent);


				return pagecontent;
			}
		else
			{
				return "<--ERROR-->";
			}

	}}


	/*@RequestMapping(value = "/employee", method = RequestMethod.GET,
			produces = { "application/json", "application/xml" })
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}*/

