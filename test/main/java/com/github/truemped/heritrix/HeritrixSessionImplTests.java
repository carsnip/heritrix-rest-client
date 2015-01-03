package com.github.truemped.heritrix;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

public class HeritrixSessionImplTests {

	@Test
	public void selfSignedConstructor() throws Exception {
		new HeritrixSessionImpl("localhost", 8443, "heritrix", "heritrix");
	}
	
	@Test
	@Ignore("Requires heritrix to be spun up")
	public void testCall() throws Exception {
		HeritrixSession session = new HeritrixSessionImpl("localhost", 8443, "heritrix", "heritrix");
		Document result = session.rescanJobDirectory();
		
		printDocument(result, System.out);
	}
	
	@Test
	@Ignore("Requires heritrix to be spun up")
	public void AddJobDirectory() throws Exception{
		HeritrixSession session = new HeritrixSessionImpl("localhost", 8443, "heritrix", "heritrix");
		boolean result = session.addJobDirectory("/opt/heritrix-3.2.0/jobs/newJob1");
		
		System.out.println(result);
	}
	
	
	public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

	    transformer.transform(new DOMSource(doc), 
	         new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}
}
