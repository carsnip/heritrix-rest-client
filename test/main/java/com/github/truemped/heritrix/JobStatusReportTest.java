package com.github.truemped.heritrix;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

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
		
		Integer downloadedUriCount = jobStatusReport.getDownloadedUriCount();
		Integer queuedUriCount = jobStatusReport.getQueuedUriCount();
		Integer totalUriCount = jobStatusReport.getTotalUriCount();
		Integer futureUriCount = jobStatusReport.getFutureUriCount();
		assertNotNull(downloadedUriCount);
		assertNotNull(queuedUriCount);
		assertNotNull(totalUriCount);
		assertNotNull(futureUriCount);
		
		Integer dupByHash = jobStatusReport.getDupByHash();
		Integer dupByHashCount = jobStatusReport.getDupByHashCount();
		Integer notModified = jobStatusReport.getNotModified();
		Integer notModifiedCount = jobStatusReport.getNotModifiedCount();
		Integer novel = jobStatusReport.getNovel();
		Integer novelCount = jobStatusReport.getNovelCount();
		Integer total = jobStatusReport.getTotal();
		Integer totalCount = jobStatusReport.getTotalCount();
		assertNotNull(dupByHash);
		assertNotNull(dupByHashCount);
		assertNotNull(notModified);
		assertNotNull(notModifiedCount);
		assertNotNull(novel);
		assertNotNull(novelCount);
		assertNotNull(total);
		assertNotNull(totalCount);
		
		Double currentDocsPerSecond = jobStatusReport.getCurrentDocsPerSecond();
		Double averageDocsPerSecond = jobStatusReport.getAverageDocsPerSecond();
		Integer currentKiBPerSec = jobStatusReport.getCurrentKiBPerSec();
		Integer averageKiBPerSec = jobStatusReport.getAverageKiBPerSec();
		assertNotNull(currentDocsPerSecond);
		assertNotNull(averageDocsPerSecond);
		assertNotNull(currentKiBPerSec);
		assertNotNull(averageKiBPerSec);
		
		
		Integer busyThreads = jobStatusReport.getBusyThreads();
		Integer totalThreads = jobStatusReport.getTotalThreads();
		Double congestionRatio = jobStatusReport.getCongestionRatio();
		Integer averageQueueDepth = jobStatusReport.getAverageQueueDepth();
		Integer deepestQueueDepth = jobStatusReport.getDeepestQueueDepth();
		assertNotNull(busyThreads);
		assertNotNull(totalThreads);
		assertNotNull(congestionRatio);
		assertNotNull(averageQueueDepth);    
		assertNotNull(deepestQueueDepth);    
		
		Integer elapsedMilliseconds = jobStatusReport.getElapsedMilliseconds();
		String elapsedPretty = jobStatusReport.getElapsedPretty();
		assertNotNull(elapsedMilliseconds);    
		assertNotNull(elapsedPretty); 
		
		Integer toeCount = jobStatusReport.getToeCount();
		List<String> steps = jobStatusReport.getSteps();
		List<String> processors = jobStatusReport.getProcessors();
		assertNotNull(toeCount);    
		//assertNotNull(steps); 
		//assertNotEquals(0, steps.size());
		//assertNotNull(processors); 
		//assertNotEquals(0, processors.size());
		
		Integer totalQueues = jobStatusReport.getTotalQueues();
		Integer inProcessQueues = jobStatusReport.getInProcessQueues();
		Integer readyQueues = jobStatusReport.getReadyQueues();
		Integer snoozedQueues = jobStatusReport.getSnoozedQueues();
		Integer activeQueues = jobStatusReport.getActiveQueues();
		Integer inactiveQueues = jobStatusReport.getInactiveQueues();
		Integer ineligibleQueues = jobStatusReport.getIneligibleQueues();
		Integer retiredQueues = jobStatusReport.getRetiredQueues();
		Integer exhaustedQueues = jobStatusReport.getExhaustedQueues();
		String lastReachedState = jobStatusReport.getLastReachedState();
		assertNotNull(totalQueues);
		assertNotNull(inProcessQueues);
		assertNotNull(readyQueues);
		assertNotNull(snoozedQueues);
		assertNotNull(activeQueues);
		assertNotNull(inactiveQueues);
		assertNotNull(ineligibleQueues);
		assertNotNull(retiredQueues);
		assertNotNull(exhaustedQueues);
		assertNotNull(lastReachedState);
		
		
	/*	
		
	  assertNotNull(inProcessQueues
	   assertNotNull(readyQueues
	    assertNotNull(snoozedQueues
	    assertNotNull(activeQueues
	    assertNotNull(inactiveQueues
	    assertNotNull(ineligibleQueues
	    assertNotNull(retiredQueues
	    assertNotNull(exhaustedQueues
	    assertNotNull(lastReachedState
	  */
		
	}

}
