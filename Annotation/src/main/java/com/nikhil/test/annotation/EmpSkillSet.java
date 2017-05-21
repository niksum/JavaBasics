package com.nikhil.test.annotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_SKILL_SET")
public class EmpSkillSet implements Serializable {

	private static final long serialVersionUID = -8446637801828566096L;

	@Id
	@Column(name = "RECORD_ID", unique = true, nullable = false)
	private Integer recordId;

	@Column(name = "SKILL_NAME", unique = true, nullable = false)
	private String skillName;

	@Column(name = "YEAR_OF_EXP", unique = true, nullable = false)
	private Integer yearOfExpe;

	public EmpSkillSet() {
		super();
	}

	public EmpSkillSet(String skillNm, Integer yearOfEx) {
		setSkillName(skillNm);
		setYearOfExpe(yearOfEx);
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getYearOfExpe() {
		return yearOfExpe;
	}

	public void setYearOfExpe(Integer yearOfExpe) {
		this.yearOfExpe = yearOfExpe;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@Override
	public String toString() {
		return "EmpSkillSet [recordId=" + recordId + ", skillName=" + skillName + ", yearOfExpe=" + yearOfExpe + "]";
	}

}
