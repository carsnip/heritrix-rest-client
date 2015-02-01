package com.github.truemped.heritrix;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

public class JobStatusReportPartialTest {

	private Document document;
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = JobStatusReportPartialTest.class.getResourceAsStream("/partial-status.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		document = documentBuilder.parse(inputStream);
		assertNotNull(document);
	}

	@Test
	public void test() {
		// given
		
		// when 
		JobStatusReport jobStatusReport = JobStatusReport.fromDocument(document);
		
		// then
		Integer toeCount = jobStatusReport.getToeCount();
		assertNull(toeCount);    
		
		
	}

}
