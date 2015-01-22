package com.github.truemped.heritrix;

import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * POJO to represent a status report from the Heritrix log.
 * @author simon
 */
public class JobStatusReport {
	private static final Logger logger = LoggerFactory.getLogger(JobStatusReport.class);
	
	// identify the job
	private String job;
	
	// the current status
	private String status;

	// writer base path
	private String warcWriterDirectory;

	// uri totals report
	private int downloadedUriCount;
	private int queuedUriCount;
	private int totalUriCount;
	private int futureUriCount;

	// size totals report
	private int dupByHash;
	private int dupByHashCount;
	private int notModified;
	private int notModifiedCount;
	private int novel;
	private int novelCount;
	private int total;
	private int totalCount;

	// rate report
	private double currentDocsPerSecond;
	private double averageDocsPerSecond;
	private int currentKiBPerSec;
	private int averageKiBPerSec;

	// load report
	private int busyThreads;
	private int totalThreads;
	private double congestionRatio;
	private int averageQueueDepth;
	private int deepestQueueDepth;

	// elapsed report
	private int elapsedMilliseconds;
	private String elapsedPretty;

	// thread report
	private int toeCount;
	private List<String> steps; // might need to contain an enum
	private List<String> processors; // might need to contain an enum

	// frontier report
	private int totalQueues;
	private int inProcessQueues;
	private int readyQueues;
	private int snoozedQueues;
	private int activeQueues;
	private int inactiveQueues;
	private int ineligibleQueues;
	private int retiredQueues;
	private int exhaustedQueues;
	private String lastReachedState; // might need to use an enum
	
	
	
	public String getJob() {
		return job;
	}

	public String getStatus() {
		return status;
	}

	public String getWarcWriterDirectory() {
		return warcWriterDirectory;
	}

	public int getDownloadedUriCount() {
		return downloadedUriCount;
	}

	public int getQueuedUriCount() {
		return queuedUriCount;
	}

	public int getTotalUriCount() {
		return totalUriCount;
	}

	public int getFutureUriCount() {
		return futureUriCount;
	}

	public int getDupByHash() {
		return dupByHash;
	}

	public int getDupByHashCount() {
		return dupByHashCount;
	}

	public int getNotModified() {
		return notModified;
	}

	public int getNotModifiedCount() {
		return notModifiedCount;
	}

	public int getNovel() {
		return novel;
	}

	public int getNovelCount() {
		return novelCount;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public double getCurrentDocsPerSecond() {
		return currentDocsPerSecond;
	}

	public double getAverageDocsPerSecond() {
		return averageDocsPerSecond;
	}

	public int getCurrentKiBPerSec() {
		return currentKiBPerSec;
	}

	public int getAverageKiBPerSec() {
		return averageKiBPerSec;
	}

	public int getBusyThreads() {
		return busyThreads;
	}

	public int getTotalThreads() {
		return totalThreads;
	}

	public double getCongestionRatio() {
		return congestionRatio;
	}

	public int getAverageQueueDepth() {
		return averageQueueDepth;
	}

	public int getDeepestQueueDepth() {
		return deepestQueueDepth;
	}

	public int getElapsedMilliseconds() {
		return elapsedMilliseconds;
	}

	public String getElapsedPretty() {
		return elapsedPretty;
	}

	public int getToeCount() {
		return toeCount;
	}

	public List<String> getSteps() {
		return steps;
	}

	public List<String> getProcessors() {
		return processors;
	}

	public int getTotalQueues() {
		return totalQueues;
	}

	public int getInProcessQueues() {
		return inProcessQueues;
	}

	public int getReadyQueues() {
		return readyQueues;
	}

	public int getSnoozedQueues() {
		return snoozedQueues;
	}

	public int getActiveQueues() {
		return activeQueues;
	}

	public int getInactiveQueues() {
		return inactiveQueues;
	}

	public int getIneligibleQueues() {
		return ineligibleQueues;
	}

	public int getRetiredQueues() {
		return retiredQueues;
	}

	public int getExhaustedQueues() {
		return exhaustedQueues;
	}

	public String getLastReachedState() {
		return lastReachedState;
	}

	public static JobStatusReport fromDocument(Document document) {
		final XPath xPath = XPathFactory.newInstance().newXPath();
		JobStatusReport.Builder builder = new JobStatusReport.Builder();
		try {
			builder.warcWriterDirectory(xPath.evaluate("//value[key/text()='warcWriter.directory']/path", document));
			builder.status(xPath.evaluate("//job/statusDescription", document));
		} catch (XPathExpressionException e) {
			logger.error("status document not in expected format", e);
		}
		return builder.build();
	}

	public static class Builder {
		private String job;
		private String status;
		private String warcWriterDirectory;
		private int downloadedUriCount;
		private int queuedUriCount;
		private int totalUriCount;
		private int futureUriCount;
		private int dupByHash;
		private int dupByHashCount;
		private int notModified;
		private int notModifiedCount;
		private int novel;
		private int novelCount;
		private int total;
		private int totalCount;
		private double currentDocsPerSecond;
		private double averageDocsPerSecond;
		private int currentKiBPerSec;
		private int averageKiBPerSec;
		private int busyThreads;
		private int totalThreads;
		private double congestionRatio;
		private int averageQueueDepth;
		private int deepestQueueDepth;
		private int elapsedMilliseconds;
		private String elapsedPretty;
		private int toeCount;
		private List<String> steps;
		private List<String> processors;
		private int totalQueues;
		private int inProcessQueues;
		private int readyQueues;
		private int snoozedQueues;
		private int activeQueues;
		private int inactiveQueues;
		private int ineligibleQueues;
		private int retiredQueues;
		private int exhaustedQueues;
		private String lastReachedState;

		public Builder job(String job) {
			this.job = job;
			return this;
		}
		
		public Builder status(String status) {
			this.status = status;
			return this;
		}

		public Builder warcWriterDirectory(String warcWriterDirectory) {
			this.warcWriterDirectory = warcWriterDirectory;
			return this;
		}

		public Builder downloadedUriCount(int downloadedUriCount) {
			this.downloadedUriCount = downloadedUriCount;
			return this;
		}

		public Builder queuedUriCount(int queuedUriCount) {
			this.queuedUriCount = queuedUriCount;
			return this;
		}

		public Builder totalUriCount(int totalUriCount) {
			this.totalUriCount = totalUriCount;
			return this;
		}

		public Builder futureUriCount(int futureUriCount) {
			this.futureUriCount = futureUriCount;
			return this;
		}

		public Builder dupByHash(int dupByHash) {
			this.dupByHash = dupByHash;
			return this;
		}

		public Builder dupByHashCount(int dupByHashCount) {
			this.dupByHashCount = dupByHashCount;
			return this;
		}

		public Builder notModified(int notModified) {
			this.notModified = notModified;
			return this;
		}

		public Builder notModifiedCount(int notModifiedCount) {
			this.notModifiedCount = notModifiedCount;
			return this;
		}

		public Builder novel(int novel) {
			this.novel = novel;
			return this;
		}

		public Builder novelCount(int novelCount) {
			this.novelCount = novelCount;
			return this;
		}

		public Builder total(int total) {
			this.total = total;
			return this;
		}

		public Builder totalCount(int totalCount) {
			this.totalCount = totalCount;
			return this;
		}

		public Builder currentDocsPerSecond(double currentDocsPerSecond) {
			this.currentDocsPerSecond = currentDocsPerSecond;
			return this;
		}

		public Builder averageDocsPerSecond(double averageDocsPerSecond) {
			this.averageDocsPerSecond = averageDocsPerSecond;
			return this;
		}

		public Builder currentKiBPerSec(int currentKiBPerSec) {
			this.currentKiBPerSec = currentKiBPerSec;
			return this;
		}

		public Builder averageKiBPerSec(int averageKiBPerSec) {
			this.averageKiBPerSec = averageKiBPerSec;
			return this;
		}

		public Builder busyThreads(int busyThreads) {
			this.busyThreads = busyThreads;
			return this;
		}

		public Builder totalThreads(int totalThreads) {
			this.totalThreads = totalThreads;
			return this;
		}

		public Builder congestionRatio(double congestionRatio) {
			this.congestionRatio = congestionRatio;
			return this;
		}

		public Builder averageQueueDepth(int averageQueueDepth) {
			this.averageQueueDepth = averageQueueDepth;
			return this;
		}

		public Builder deepestQueueDepth(int deepestQueueDepth) {
			this.deepestQueueDepth = deepestQueueDepth;
			return this;
		}

		public Builder elapsedMilliseconds(int elapsedMilliseconds) {
			this.elapsedMilliseconds = elapsedMilliseconds;
			return this;
		}

		public Builder elapsedPretty(String elapsedPretty) {
			this.elapsedPretty = elapsedPretty;
			return this;
		}

		public Builder toeCount(int toeCount) {
			this.toeCount = toeCount;
			return this;
		}

		public Builder steps(List<String> steps) {
			this.steps = steps;
			return this;
		}

		public Builder processors(List<String> processors) {
			this.processors = processors;
			return this;
		}

		public Builder totalQueues(int totalQueues) {
			this.totalQueues = totalQueues;
			return this;
		}

		public Builder inProcessQueues(int inProcessQueues) {
			this.inProcessQueues = inProcessQueues;
			return this;
		}

		public Builder readyQueues(int readyQueues) {
			this.readyQueues = readyQueues;
			return this;
		}

		public Builder snoozedQueues(int snoozedQueues) {
			this.snoozedQueues = snoozedQueues;
			return this;
		}

		public Builder activeQueues(int activeQueues) {
			this.activeQueues = activeQueues;
			return this;
		}

		public Builder inactiveQueues(int inactiveQueues) {
			this.inactiveQueues = inactiveQueues;
			return this;
		}

		public Builder ineligibleQueues(int ineligibleQueues) {
			this.ineligibleQueues = ineligibleQueues;
			return this;
		}

		public Builder retiredQueues(int retiredQueues) {
			this.retiredQueues = retiredQueues;
			return this;
		}

		public Builder exhaustedQueues(int exhaustedQueues) {
			this.exhaustedQueues = exhaustedQueues;
			return this;
		}

		public Builder lastReachedState(String lastReachedState) {
			this.lastReachedState = lastReachedState;
			return this;
		}

		public JobStatusReport build() {
			return new JobStatusReport(this);
		}
	}

	private JobStatusReport(Builder builder) {
		this.job = builder.job;
		this.status = builder.status;
		this.warcWriterDirectory = builder.warcWriterDirectory;
		this.downloadedUriCount = builder.downloadedUriCount;
		this.queuedUriCount = builder.queuedUriCount;
		this.totalUriCount = builder.totalUriCount;
		this.futureUriCount = builder.futureUriCount;
		this.dupByHash = builder.dupByHash;
		this.dupByHashCount = builder.dupByHashCount;
		this.notModified = builder.notModified;
		this.notModifiedCount = builder.notModifiedCount;
		this.novel = builder.novel;
		this.novelCount = builder.novelCount;
		this.total = builder.total;
		this.totalCount = builder.totalCount;
		this.currentDocsPerSecond = builder.currentDocsPerSecond;
		this.averageDocsPerSecond = builder.averageDocsPerSecond;
		this.currentKiBPerSec = builder.currentKiBPerSec;
		this.averageKiBPerSec = builder.averageKiBPerSec;
		this.busyThreads = builder.busyThreads;
		this.totalThreads = builder.totalThreads;
		this.congestionRatio = builder.congestionRatio;
		this.averageQueueDepth = builder.averageQueueDepth;
		this.deepestQueueDepth = builder.deepestQueueDepth;
		this.elapsedMilliseconds = builder.elapsedMilliseconds;
		this.elapsedPretty = builder.elapsedPretty;
		this.toeCount = builder.toeCount;
		this.steps = builder.steps;
		this.processors = builder.processors;
		this.totalQueues = builder.totalQueues;
		this.inProcessQueues = builder.inProcessQueues;
		this.readyQueues = builder.readyQueues;
		this.snoozedQueues = builder.snoozedQueues;
		this.activeQueues = builder.activeQueues;
		this.inactiveQueues = builder.inactiveQueues;
		this.ineligibleQueues = builder.ineligibleQueues;
		this.retiredQueues = builder.retiredQueues;
		this.exhaustedQueues = builder.exhaustedQueues;
		this.lastReachedState = builder.lastReachedState;
	}

	
}