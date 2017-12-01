package com.maven.download;

public class Params {

	/**
	 * jar包在maven仓库中的groupId
	 */
	private String groupId;
	/**
	 * jar包在maven仓库中的artifactId
	 */
	private String artifactId;
	/**
	 * jar包在maven仓库中的version
	 */
	private String version;
	/**
	 * 远程maven仓库的URL地址
	 */
	private String repository;
	/**
	 * 下载的jar包存放的目标地址，默认为./temp
	 */
	private String target = "temp";
	/**
	 * 登录远程maven仓库的用户名，若远程仓库不需要权限，设为null，默认为null
	 */
	private String username = null;
	/**
	 * 登录远程maven仓库的密码，若远程仓库不需要权限，设为null，默认为null
	 */
	private String password = null;

	public Params() {
		super();
	}

	public Params(String groupId, String artifactId) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
	}

	public Params(String groupId, String artifactId, String username,
			String password) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.username = username;
		this.password = password;
	}

	public Params(String groupId, String artifactId, String version,
			String repository, /* String target, */String username,
			String password) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.repository = repository;
		/* this.target = target; */
		this.username = username;
		this.password = password;
	}

	public Params(String groupId, String artifactId, String version,
			String username, String password) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.username = username;
		this.password = password;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}