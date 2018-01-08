package org.fuys.owndb.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial") // Different from specific value
public class Goal implements Serializable {

	private String goalId;
	private String name;
	private String description;
	private Date startTime;
	private Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getGoalId() {
		return goalId;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Goal [goalId=" + goalId + ", name=" + name + ", description=" + description + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

}
