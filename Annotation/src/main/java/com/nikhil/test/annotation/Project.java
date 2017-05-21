package com.nikhil.test.annotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project implements Serializable{
	private static final long serialVersionUID = -2494743442843248651L;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectClient=" + projectClient
				+ "]";
	}

	public String getProjectClient() {
		return projectClient;
	}

	public void setProjectClient(String projectClient) {
		this.projectClient = projectClient;
	}

	public Project(){
		super();
	}
	
	@Id
	@Column(name="PROJ_ID")
	private Integer projectId;
	
	@Column(name="PROJ_NAME", nullable=false)
	private String projectName;
	
	@Column(name="PROJ_CLIENT", nullable=false)
	private String projectClient;
	

	
	public Project(Integer projId, String projNm, String projCl){
		setProjectClient(projCl);
		setProjectId(projId);
		setProjectName(projNm);
		
	}


}
