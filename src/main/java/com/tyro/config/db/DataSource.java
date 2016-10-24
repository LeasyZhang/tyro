package com.tyro.config.db;

public class DataSource extends org.apache.tomcat.jdbc.pool.DataSource {

	private String schema;
	private String data;

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
