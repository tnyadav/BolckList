package com.tn.beans;

public class ContactBlockSetting {
	
	private int contactId;
	private String contactName;
	private String contactNumber;
	private boolean isIncomingCallBlocked;
	private boolean isOutgoingCallBlocked;
	private boolean isIncomingSmsBlocked;
	private boolean isOutgoingSmsBlocked;
	
	private boolean isScheduleCallBlocked;
	private boolean isScheduleSmsBlocked;
	private long callScheduleBlockStartTime;
	private long callScheduleBlockEndTime;
	private long smsScheduleBlockStartTime;
	private long smsScheduleBlockEndTime;
	
	
	/**
	 * @return the contactId
	 */
	public int getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the isIncomingCallBlocked
	 */
	public boolean isIncomingCallBlocked() {
		return isIncomingCallBlocked;
	}
	/**
	 * @param isIncomingCallBlocked the isIncomingCallBlocked to set
	 */
	public void setIncomingCallBlocked(boolean isIncomingCallBlocked) {
		this.isIncomingCallBlocked = isIncomingCallBlocked;
	}
	/**
	 * @return the isOutgoingCallBlocked
	 */
	public boolean isOutgoingCallBlocked() {
		return isOutgoingCallBlocked;
	}
	/**
	 * @param isOutgoingCallBlocked the isOutgoingCallBlocked to set
	 */
	public void setOutgoingCallBlocked(boolean isOutgoingCallBlocked) {
		this.isOutgoingCallBlocked = isOutgoingCallBlocked;
	}
	/**
	 * @return the isIncomingSmsBlocked
	 */
	public boolean isIncomingSmsBlocked() {
		return isIncomingSmsBlocked;
	}
	/**
	 * @param isIncomingSmsBlocked the isIncomingSmsBlocked to set
	 */
	public void setIncomingSmsBlocked(boolean isIncomingSmsBlocked) {
		this.isIncomingSmsBlocked = isIncomingSmsBlocked;
	}
	/**
	 * @return the isOutgoingSmsBlocked
	 */
	public boolean isOutgoingSmsBlocked() {
		return isOutgoingSmsBlocked;
	}
	/**
	 * @param isOutgoingSmsBlocked the isOutgoingSmsBlocked to set
	 */
	public void setOutgoingSmsBlocked(boolean isOutgoingSmsBlocked) {
		this.isOutgoingSmsBlocked = isOutgoingSmsBlocked;
	}
	/**
	 * @return the isScheduleCallBlocked
	 */
	public boolean isScheduleCallBlocked() {
		return isScheduleCallBlocked;
	}
	/**
	 * @param isScheduleCallBlocked the isScheduleCallBlocked to set
	 */
	public void setScheduleCallBlocked(boolean isScheduleCallBlocked) {
		this.isScheduleCallBlocked = isScheduleCallBlocked;
	}
	/**
	 * @return the isScheduleSmsBlocked
	 */
	public boolean isScheduleSmsBlocked() {
		return isScheduleSmsBlocked;
	}
	/**
	 * @param isScheduleSmsBlocked the isScheduleSmsBlocked to set
	 */
	public void setScheduleSmsBlocked(boolean isScheduleSmsBlocked) {
		this.isScheduleSmsBlocked = isScheduleSmsBlocked;
	}
	/**
	 * @return the callScheduleBlockStartTime
	 */
	public long getCallScheduleBlockStartTime() {
		return callScheduleBlockStartTime;
	}
	/**
	 * @param callScheduleBlockStartTime the callScheduleBlockStartTime to set
	 */
	public void setCallScheduleBlockStartTime(long callScheduleBlockStartTime) {
		this.callScheduleBlockStartTime = callScheduleBlockStartTime;
	}
	/**
	 * @return the callScheduleBlockEndTime
	 */
	public long getCallScheduleBlockEndTime() {
		return callScheduleBlockEndTime;
	}
	/**
	 * @param callScheduleBlockEndTime the callScheduleBlockEndTime to set
	 */
	public void setCallScheduleBlockEndTime(long callScheduleBlockEndTime) {
		this.callScheduleBlockEndTime = callScheduleBlockEndTime;
	}
	/**
	 * @return the smsScheduleBlockStartTime
	 */
	public long getSmsScheduleBlockStartTime() {
		return smsScheduleBlockStartTime;
	}
	/**
	 * @param smsScheduleBlockStartTime the smsScheduleBlockStartTime to set
	 */
	public void setSmsScheduleBlockStartTime(long smsScheduleBlockStartTime) {
		this.smsScheduleBlockStartTime = smsScheduleBlockStartTime;
	}
	/**
	 * @return the smsScheduleBlockEndTime
	 */
	public long getSmsScheduleBlockEndTime() {
		return smsScheduleBlockEndTime;
	}
	/**
	 * @param smsScheduleBlockEndTime the smsScheduleBlockEndTime to set
	 */
	public void setSmsScheduleBlockEndTime(long smsScheduleBlockEndTime) {
		this.smsScheduleBlockEndTime = smsScheduleBlockEndTime;
	}
	

}
