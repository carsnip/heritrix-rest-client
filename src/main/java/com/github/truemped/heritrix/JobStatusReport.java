package com.github.truemped.heritrix;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.math.NumberUtils;
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
	private Integer downloadedUriCount;
	private Integer queuedUriCount;
	private Integer totalUriCount;
	private Integer futureUriCount;

	// size totals report
	private Integer dupByHash;
	private Integer dupByHashCount;
	private Integer notModified;
	private Integer notModifiedCount;
	private Integer novel;
	private Integer novelCount;
	private Integer total;
	private Integer totalCount;

	// rate report
	private Double currentDocsPerSecond;
	private Double averageDocsPerSecond;
	private Integer currentKiBPerSec;
	private Integer averageKiBPerSec;

	// load report
	private Integer busyThreads;
	private Integer totalThreads;
	private Double congestionRatio;
	private Integer averageQueueDepth;
	private Integer deepestQueueDepth;

	// elapsed report
	private Integer elapsedMilliseconds;
	private String elapsedPretty;

	// thread report
	private Integer toeCount;
	private String steps; // might need to contain an enum
	private String processors; // might need to contain an enum

	// frontier report
	private Integer totalQueues;
	private Integer inProcessQueues;
	private Integer readyQueues;
	private Integer snoozedQueues;
	private Integer activeQueues;
	private Integer inactiveQueues;
	private Integer ineligibleQueues;
	private Integer retiredQueues;
	private Integer exhaustedQueues;
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

	public Integer getDownloadedUriCount() {
		return downloadedUriCount;
	}

	public Integer getQueuedUriCount() {
		return queuedUriCount;
	}

	public Integer getTotalUriCount() {
		return totalUriCount;
	}

	public Integer getFutureUriCount() {
		return futureUriCount;
	}

	public Integer getDupByHash() {
		return dupByHash;
	}

	public Integer getDupByHashCount() {
		return dupByHashCount;
	}

	public Integer getNotModified() {
		return notModified;
	}

	public Integer getNotModifiedCount() {
		return notModifiedCount;
	}

	public Integer getNovel() {
		return novel;
	}

	public Integer getNovelCount() {
		return novelCount;
	}

	public Integer getTotal() {
		return total;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Double getCurrentDocsPerSecond() {
		return currentDocsPerSecond;
	}

	public Double getAverageDocsPerSecond() {
		return averageDocsPerSecond;
	}

	public Integer getCurrentKiBPerSec() {
		return currentKiBPerSec;
	}

	public Integer getAverageKiBPerSec() {
		return averageKiBPerSec;
	}

	public Integer getBusyThreads() {
		return busyThreads;
	}

	public Integer getTotalThreads() {
		return totalThreads;
	}

	public Double getCongestionRatio() {
		return congestionRatio;
	}

	public Integer getAverageQueueDepth() {
		return averageQueueDepth;
	}

	public Integer getDeepestQueueDepth() {
		return deepestQueueDepth;
	}

	public Integer getElapsedMilliseconds() {
		return elapsedMilliseconds;
	}

	public String getElapsedPretty() {
		return elapsedPretty;
	}

	public Integer getToeCount() {
		return toeCount;
	}

	public String getSteps() {
		return steps;
	}

	public String getProcessors() {
		return processors;
	}

	public Integer getTotalQueues() {
		return totalQueues;
	}

	public Integer getInProcessQueues() {
		return inProcessQueues;
	}

	public Integer getReadyQueues() {
		return readyQueues;
	}

	public Integer getSnoozedQueues() {
		return snoozedQueues;
	}

	public Integer getActiveQueues() {
		return activeQueues;
	}

	public Integer getInactiveQueues() {
		return inactiveQueues;
	}

	public Integer getIneligibleQueues() {
		return ineligibleQueues;
	}

	public Integer getRetiredQueues() {
		return retiredQueues;
	}

	public Integer getExhaustedQueues() {
		return exhaustedQueues;
	}

	public String getLastReachedState() {
		return lastReachedState;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activeQueues == null) ? 0 : activeQueues.hashCode());
		result = prime
				* result
				+ ((averageDocsPerSecond == null) ? 0 : averageDocsPerSecond
						.hashCode());
		result = prime
				* result
				+ ((averageKiBPerSec == null) ? 0 : averageKiBPerSec.hashCode());
		result = prime
				* result
				+ ((averageQueueDepth == null) ? 0 : averageQueueDepth
						.hashCode());
		result = prime * result
				+ ((busyThreads == null) ? 0 : busyThreads.hashCode());
		result = prime * result
				+ ((congestionRatio == null) ? 0 : congestionRatio.hashCode());
		result = prime
				* result
				+ ((currentDocsPerSecond == null) ? 0 : currentDocsPerSecond
						.hashCode());
		result = prime
				* result
				+ ((currentKiBPerSec == null) ? 0 : currentKiBPerSec.hashCode());
		result = prime
				* result
				+ ((deepestQueueDepth == null) ? 0 : deepestQueueDepth
						.hashCode());
		result = prime
				* result
				+ ((downloadedUriCount == null) ? 0 : downloadedUriCount
						.hashCode());
		result = prime * result
				+ ((dupByHash == null) ? 0 : dupByHash.hashCode());
		result = prime * result
				+ ((dupByHashCount == null) ? 0 : dupByHashCount.hashCode());
		result = prime
				* result
				+ ((elapsedMilliseconds == null) ? 0 : elapsedMilliseconds
						.hashCode());
		result = prime * result
				+ ((elapsedPretty == null) ? 0 : elapsedPretty.hashCode());
		result = prime * result
				+ ((exhaustedQueues == null) ? 0 : exhaustedQueues.hashCode());
		result = prime * result
				+ ((futureUriCount == null) ? 0 : futureUriCount.hashCode());
		result = prime * result
				+ ((inProcessQueues == null) ? 0 : inProcessQueues.hashCode());
		result = prime * result
				+ ((inactiveQueues == null) ? 0 : inactiveQueues.hashCode());
		result = prime
				* result
				+ ((ineligibleQueues == null) ? 0 : ineligibleQueues.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime
				* result
				+ ((lastReachedState == null) ? 0 : lastReachedState.hashCode());
		result = prime * result
				+ ((notModified == null) ? 0 : notModified.hashCode());
		result = prime
				* result
				+ ((notModifiedCount == null) ? 0 : notModifiedCount.hashCode());
		result = prime * result + ((novel == null) ? 0 : novel.hashCode());
		result = prime * result
				+ ((novelCount == null) ? 0 : novelCount.hashCode());
		result = prime * result
				+ ((processors == null) ? 0 : processors.hashCode());
		result = prime * result
				+ ((queuedUriCount == null) ? 0 : queuedUriCount.hashCode());
		result = prime * result
				+ ((readyQueues == null) ? 0 : readyQueues.hashCode());
		result = prime * result
				+ ((retiredQueues == null) ? 0 : retiredQueues.hashCode());
		result = prime * result
				+ ((snoozedQueues == null) ? 0 : snoozedQueues.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
		result = prime * result
				+ ((toeCount == null) ? 0 : toeCount.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result
				+ ((totalCount == null) ? 0 : totalCount.hashCode());
		result = prime * result
				+ ((totalQueues == null) ? 0 : totalQueues.hashCode());
		result = prime * result
				+ ((totalThreads == null) ? 0 : totalThreads.hashCode());
		result = prime * result
				+ ((totalUriCount == null) ? 0 : totalUriCount.hashCode());
		result = prime
				* result
				+ ((warcWriterDirectory == null) ? 0 : warcWriterDirectory
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobStatusReport other = (JobStatusReport) obj;
		if (activeQueues == null) {
			if (other.activeQueues != null)
				return false;
		} else if (!activeQueues.equals(other.activeQueues))
			return false;
		if (averageDocsPerSecond == null) {
			if (other.averageDocsPerSecond != null)
				return false;
		} else if (!averageDocsPerSecond.equals(other.averageDocsPerSecond))
			return false;
		if (averageKiBPerSec == null) {
			if (other.averageKiBPerSec != null)
				return false;
		} else if (!averageKiBPerSec.equals(other.averageKiBPerSec))
			return false;
		if (averageQueueDepth == null) {
			if (other.averageQueueDepth != null)
				return false;
		} else if (!averageQueueDepth.equals(other.averageQueueDepth))
			return false;
		if (busyThreads == null) {
			if (other.busyThreads != null)
				return false;
		} else if (!busyThreads.equals(other.busyThreads))
			return false;
		if (congestionRatio == null) {
			if (other.congestionRatio != null)
				return false;
		} else if (!congestionRatio.equals(other.congestionRatio))
			return false;
		if (currentDocsPerSecond == null) {
			if (other.currentDocsPerSecond != null)
				return false;
		} else if (!currentDocsPerSecond.equals(other.currentDocsPerSecond))
			return false;
		if (currentKiBPerSec == null) {
			if (other.currentKiBPerSec != null)
				return false;
		} else if (!currentKiBPerSec.equals(other.currentKiBPerSec))
			return false;
		if (deepestQueueDepth == null) {
			if (other.deepestQueueDepth != null)
				return false;
		} else if (!deepestQueueDepth.equals(other.deepestQueueDepth))
			return false;
		if (downloadedUriCount == null) {
			if (other.downloadedUriCount != null)
				return false;
		} else if (!downloadedUriCount.equals(other.downloadedUriCount))
			return false;
		if (dupByHash == null) {
			if (other.dupByHash != null)
				return false;
		} else if (!dupByHash.equals(other.dupByHash))
			return false;
		if (dupByHashCount == null) {
			if (other.dupByHashCount != null)
				return false;
		} else if (!dupByHashCount.equals(other.dupByHashCount))
			return false;
		if (elapsedMilliseconds == null) {
			if (other.elapsedMilliseconds != null)
				return false;
		} else if (!elapsedMilliseconds.equals(other.elapsedMilliseconds))
			return false;
		if (elapsedPretty == null) {
			if (other.elapsedPretty != null)
				return false;
		} else if (!elapsedPretty.equals(other.elapsedPretty))
			return false;
		if (exhaustedQueues == null) {
			if (other.exhaustedQueues != null)
				return false;
		} else if (!exhaustedQueues.equals(other.exhaustedQueues))
			return false;
		if (futureUriCount == null) {
			if (other.futureUriCount != null)
				return false;
		} else if (!futureUriCount.equals(other.futureUriCount))
			return false;
		if (inProcessQueues == null) {
			if (other.inProcessQueues != null)
				return false;
		} else if (!inProcessQueues.equals(other.inProcessQueues))
			return false;
		if (inactiveQueues == null) {
			if (other.inactiveQueues != null)
				return false;
		} else if (!inactiveQueues.equals(other.inactiveQueues))
			return false;
		if (ineligibleQueues == null) {
			if (other.ineligibleQueues != null)
				return false;
		} else if (!ineligibleQueues.equals(other.ineligibleQueues))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (lastReachedState == null) {
			if (other.lastReachedState != null)
				return false;
		} else if (!lastReachedState.equals(other.lastReachedState))
			return false;
		if (notModified == null) {
			if (other.notModified != null)
				return false;
		} else if (!notModified.equals(other.notModified))
			return false;
		if (notModifiedCount == null) {
			if (other.notModifiedCount != null)
				return false;
		} else if (!notModifiedCount.equals(other.notModifiedCount))
			return false;
		if (novel == null) {
			if (other.novel != null)
				return false;
		} else if (!novel.equals(other.novel))
			return false;
		if (novelCount == null) {
			if (other.novelCount != null)
				return false;
		} else if (!novelCount.equals(other.novelCount))
			return false;
		if (processors == null) {
			if (other.processors != null)
				return false;
		} else if (!processors.equals(other.processors))
			return false;
		if (queuedUriCount == null) {
			if (other.queuedUriCount != null)
				return false;
		} else if (!queuedUriCount.equals(other.queuedUriCount))
			return false;
		if (readyQueues == null) {
			if (other.readyQueues != null)
				return false;
		} else if (!readyQueues.equals(other.readyQueues))
			return false;
		if (retiredQueues == null) {
			if (other.retiredQueues != null)
				return false;
		} else if (!retiredQueues.equals(other.retiredQueues))
			return false;
		if (snoozedQueues == null) {
			if (other.snoozedQueues != null)
				return false;
		} else if (!snoozedQueues.equals(other.snoozedQueues))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (steps == null) {
			if (other.steps != null)
				return false;
		} else if (!steps.equals(other.steps))
			return false;
		if (toeCount == null) {
			if (other.toeCount != null)
				return false;
		} else if (!toeCount.equals(other.toeCount))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		if (totalQueues == null) {
			if (other.totalQueues != null)
				return false;
		} else if (!totalQueues.equals(other.totalQueues))
			return false;
		if (totalThreads == null) {
			if (other.totalThreads != null)
				return false;
		} else if (!totalThreads.equals(other.totalThreads))
			return false;
		if (totalUriCount == null) {
			if (other.totalUriCount != null)
				return false;
		} else if (!totalUriCount.equals(other.totalUriCount))
			return false;
		if (warcWriterDirectory == null) {
			if (other.warcWriterDirectory != null)
				return false;
		} else if (!warcWriterDirectory.equals(other.warcWriterDirectory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JobStatusReport [job=" + job + ", status=" + status
				+ ", warcWriterDirectory=" + warcWriterDirectory
				+ ", downloadedUriCount=" + downloadedUriCount
				+ ", queuedUriCount=" + queuedUriCount + ", totalUriCount="
				+ totalUriCount + ", futureUriCount=" + futureUriCount
				+ ", dupByHash=" + dupByHash + ", dupByHashCount="
				+ dupByHashCount + ", notModified=" + notModified
				+ ", notModifiedCount=" + notModifiedCount + ", novel=" + novel
				+ ", novelCount=" + novelCount + ", total=" + total
				+ ", totalCount=" + totalCount + ", currentDocsPerSecond="
				+ currentDocsPerSecond + ", averageDocsPerSecond="
				+ averageDocsPerSecond + ", currentKiBPerSec="
				+ currentKiBPerSec + ", averageKiBPerSec=" + averageKiBPerSec
				+ ", busyThreads=" + busyThreads + ", totalThreads="
				+ totalThreads + ", congestionRatio=" + congestionRatio
				+ ", averageQueueDepth=" + averageQueueDepth
				+ ", deepestQueueDepth=" + deepestQueueDepth
				+ ", elapsedMilliseconds=" + elapsedMilliseconds
				+ ", elapsedPretty=" + elapsedPretty + ", toeCount=" + toeCount
				+ ", steps=" + steps + ", processors=" + processors
				+ ", totalQueues=" + totalQueues + ", inProcessQueues="
				+ inProcessQueues + ", readyQueues=" + readyQueues
				+ ", snoozedQueues=" + snoozedQueues + ", activeQueues="
				+ activeQueues + ", inactiveQueues=" + inactiveQueues
				+ ", ineligibleQueues=" + ineligibleQueues + ", retiredQueues="
				+ retiredQueues + ", exhaustedQueues=" + exhaustedQueues
				+ ", lastReachedState=" + lastReachedState + "]";
	}

	public static JobStatusReport fromDocument(Document document) {
		final XPath xPath = XPathFactory.newInstance().newXPath();
		JobStatusReport.Builder builder = new JobStatusReport.Builder();
		try {
			builder.warcWriterDirectory(xPath.evaluate("//value[key/text()='warcWriter.directory']/path", document));
			
			String basePath = "//job";
			
			builder.status(xPath.evaluate(basePath + "/statusDescription", document));
			
			String baseUriTotalsReport = basePath + "/uriTotalsReport";
			builder.downloadedUriCount(tryCreateIntegerFromDocumentPath(xPath, baseUriTotalsReport + "/downloadedUriCount", document));
			builder.queuedUriCount(tryCreateIntegerFromDocumentPath(xPath, baseUriTotalsReport + "/queuedUriCount", document));
			builder.totalUriCount(tryCreateIntegerFromDocumentPath(xPath, baseUriTotalsReport + "/totalUriCount", document));
			builder.futureUriCount(tryCreateIntegerFromDocumentPath(xPath, baseUriTotalsReport + "/futureUriCount", document));
			
			String baseSizeTotalsReport = basePath + "/sizeTotalsReport";
			builder.dupByHash(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/dupByHash", document));
			builder.dupByHashCount(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/dupByHashCount", document));
			builder.notModified(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/notModified", document));
			builder.notModifiedCount(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/notModifiedCount", document));
			builder.novel(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/novel", document));
			builder.novelCount(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/novelCount", document));
			builder.total(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/total", document));
			builder.totalCount(tryCreateIntegerFromDocumentPath(xPath, baseSizeTotalsReport + "/totalCount", document));
		
			String baseRateReport = basePath + "/rateReport";
			builder.currentDocsPerSecond(tryCreateDoubleFromDocumentPath(xPath, baseRateReport + "/currentDocsPerSecond", document));
			builder.averageDocsPerSecond(tryCreateDoubleFromDocumentPath(xPath, baseRateReport + "/averageDocsPerSecond", document));
			builder.currentKiBPerSec(tryCreateIntegerFromDocumentPath(xPath, baseRateReport + "/currentKiBPerSec", document));
			builder.averageKiBPerSec(tryCreateIntegerFromDocumentPath(xPath, baseRateReport + "/currentKiBPerSec", document));
			
			String baseLoadReport = basePath + "/loadReport";
			builder.busyThreads(tryCreateIntegerFromDocumentPath(xPath, baseLoadReport + "/busyThreads", document));
			builder.totalThreads(tryCreateIntegerFromDocumentPath(xPath, baseLoadReport + "/totalThreads", document));
			builder.congestionRatio(tryCreateDoubleFromDocumentPath(xPath, baseLoadReport + "/congestionRatio", document));
			builder.averageQueueDepth(tryCreateIntegerFromDocumentPath(xPath, baseLoadReport + "/averageQueueDepth", document));
			builder.deepestQueueDepth(tryCreateIntegerFromDocumentPath(xPath, baseLoadReport + "/deepestQueueDepth", document));
			
			String baseElapsedReport = basePath + "/elapsedReport";
			builder.elapsedMilliseconds(tryCreateIntegerFromDocumentPath(xPath, baseElapsedReport + "/elapsedMilliseconds", document));
			builder.elapsedPretty(xPath.evaluate(baseElapsedReport + "/elapsedPretty", document));
			
			String baseThreadReport = basePath + "/threadReport";
			builder.toeCount(tryCreateIntegerFromDocumentPath(xPath, baseThreadReport + "/toeCount", document));
			builder.steps(xPath.evaluate(baseThreadReport + "/steps/value", document));
			builder.processors(xPath.evaluate(baseThreadReport + "/processors/value", document));
			
			String baseFrontierReport = basePath + "/frontierReport";
			builder.totalQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/totalQueues", document));
			builder.inProcessQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/inProcessQueues", document));
			builder.readyQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/readyQueues", document));
			builder.snoozedQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/snoozedQueues", document));
			builder.activeQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/activeQueues", document));
			builder.inactiveQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/inactiveQueues", document));
			builder.ineligibleQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/ineligibleQueues", document));
			builder.retiredQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/retiredQueues", document));
			builder.exhaustedQueues(tryCreateIntegerFromDocumentPath(xPath, baseFrontierReport + "/exhaustedQueues", document));
			builder.lastReachedState(xPath.evaluate(baseFrontierReport + "/lastReachedState", document));
		} catch (XPathExpressionException e) {
			logger.error("status document not in expected format", e);
		}
		return builder.build();
	}
	
	/**
	 * Try and create an integer from an xpath into the document.
	 * @param xPath
	 * @param path
	 * @param document
	 * @return null if result of xpath is null or a blank string, or not a valid number
	 * @throws XPathExpressionException
	 */
	private static Integer tryCreateIntegerFromDocumentPath(XPath xPath, String path,  Document document) throws XPathExpressionException {
		try {
			return NumberUtils.createInteger(xPath.evaluate(path, document));
		}
		catch (NumberFormatException e){
			return null;
		}
	}
	
	private static Double tryCreateDoubleFromDocumentPath(XPath xPath, String path,  Document document) throws XPathExpressionException {
		try {
			return NumberUtils.createDouble(xPath.evaluate(path, document));
		}
		catch (NumberFormatException e){
			return null;
		}
	}
	
	public static class Builder {
		private String job;
		private String status;
		private String warcWriterDirectory;
		private Integer downloadedUriCount;
		private Integer queuedUriCount;
		private Integer totalUriCount;
		private Integer futureUriCount;
		private Integer dupByHash;
		private Integer dupByHashCount;
		private Integer notModified;
		private Integer notModifiedCount;
		private Integer novel;
		private Integer novelCount;
		private Integer total;
		private Integer totalCount;
		private Double currentDocsPerSecond;
		private Double averageDocsPerSecond;
		private Integer currentKiBPerSec;
		private Integer averageKiBPerSec;
		private Integer busyThreads;
		private Integer totalThreads;
		private Double congestionRatio;
		private Integer averageQueueDepth;
		private Integer deepestQueueDepth;
		private Integer elapsedMilliseconds;
		private String elapsedPretty;
		private Integer toeCount;
		private String steps;
		private String processors;
		private Integer totalQueues;
		private Integer inProcessQueues;
		private Integer readyQueues;
		private Integer snoozedQueues;
		private Integer activeQueues;
		private Integer inactiveQueues;
		private Integer ineligibleQueues;
		private Integer retiredQueues;
		private Integer exhaustedQueues;
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

		public Builder downloadedUriCount(Integer downloadedUriCount) {
			this.downloadedUriCount = downloadedUriCount;
			return this;
		}

		public Builder queuedUriCount(Integer queuedUriCount) {
			this.queuedUriCount = queuedUriCount;
			return this;
		}

		public Builder totalUriCount(Integer totalUriCount) {
			this.totalUriCount = totalUriCount;
			return this;
		}

		public Builder futureUriCount(Integer futureUriCount) {
			this.futureUriCount = futureUriCount;
			return this;
		}

		public Builder dupByHash(Integer dupByHash) {
			this.dupByHash = dupByHash;
			return this;
		}

		public Builder dupByHashCount(Integer dupByHashCount) {
			this.dupByHashCount = dupByHashCount;
			return this;
		}

		public Builder notModified(Integer notModified) {
			this.notModified = notModified;
			return this;
		}

		public Builder notModifiedCount(Integer notModifiedCount) {
			this.notModifiedCount = notModifiedCount;
			return this;
		}

		public Builder novel(Integer novel) {
			this.novel = novel;
			return this;
		}

		public Builder novelCount(Integer novelCount) {
			this.novelCount = novelCount;
			return this;
		}

		public Builder total(Integer total) {
			this.total = total;
			return this;
		}

		public Builder totalCount(Integer totalCount) {
			this.totalCount = totalCount;
			return this;
		}

		public Builder currentDocsPerSecond(Double currentDocsPerSecond) {
			this.currentDocsPerSecond = currentDocsPerSecond;
			return this;
		}

		public Builder averageDocsPerSecond(Double averageDocsPerSecond) {
			this.averageDocsPerSecond = averageDocsPerSecond;
			return this;
		}

		public Builder currentKiBPerSec(Integer currentKiBPerSec) {
			this.currentKiBPerSec = currentKiBPerSec;
			return this;
		}

		public Builder averageKiBPerSec(Integer averageKiBPerSec) {
			this.averageKiBPerSec = averageKiBPerSec;
			return this;
		}

		public Builder busyThreads(Integer busyThreads) {
			this.busyThreads = busyThreads;
			return this;
		}

		public Builder totalThreads(Integer totalThreads) {
			this.totalThreads = totalThreads;
			return this;
		}

		public Builder congestionRatio(Double congestionRatio) {
			this.congestionRatio = congestionRatio;
			return this;
		}

		public Builder averageQueueDepth(Integer averageQueueDepth) {
			this.averageQueueDepth = averageQueueDepth;
			return this;
		}

		public Builder deepestQueueDepth(Integer deepestQueueDepth) {
			this.deepestQueueDepth = deepestQueueDepth;
			return this;
		}

		public Builder elapsedMilliseconds(Integer elapsedMilliseconds) {
			this.elapsedMilliseconds = elapsedMilliseconds;
			return this;
		}

		public Builder elapsedPretty(String elapsedPretty) {
			this.elapsedPretty = elapsedPretty;
			return this;
		}

		public Builder toeCount(Integer toeCount) {
			this.toeCount = toeCount;
			return this;
		}

		public Builder steps(String steps) {
			this.steps = steps;
			return this;
		}

		public Builder processors(String processors) {
			this.processors = processors;
			return this;
		}

		public Builder totalQueues(Integer totalQueues) {
			this.totalQueues = totalQueues;
			return this;
		}

		public Builder inProcessQueues(Integer inProcessQueues) {
			this.inProcessQueues = inProcessQueues;
			return this;
		}

		public Builder readyQueues(Integer readyQueues) {
			this.readyQueues = readyQueues;
			return this;
		}

		public Builder snoozedQueues(Integer snoozedQueues) {
			this.snoozedQueues = snoozedQueues;
			return this;
		}

		public Builder activeQueues(Integer activeQueues) {
			this.activeQueues = activeQueues;
			return this;
		}

		public Builder inactiveQueues(Integer inactiveQueues) {
			this.inactiveQueues = inactiveQueues;
			return this;
		}

		public Builder ineligibleQueues(Integer ineligibleQueues) {
			this.ineligibleQueues = ineligibleQueues;
			return this;
		}

		public Builder retiredQueues(Integer retiredQueues) {
			this.retiredQueues = retiredQueues;
			return this;
		}

		public Builder exhaustedQueues(Integer exhaustedQueues) {
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