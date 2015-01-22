package com.github.truemped.heritrix;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.sun.corba.se.spi.orbutil.fsm.Input;

public class JobStatusReportTest {

	private Document document;
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = JobStatusReportTest.class.getResourceAsStream("/status.xml");
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
		String status = jobStatusReport.getStatus();
		String warcWriterDirectory = jobStatusReport.getWarcWriterDirectory();
		
		assertNotNull(status);
		assertNotNull(warcWriterDirectory);
	}

}
