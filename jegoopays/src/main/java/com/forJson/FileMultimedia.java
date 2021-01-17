package com.forJson;

public class FileMultimedia {

	private String name;
	private byte[] filebytes;
	private String extention;
	private boolean present;
	
	
	public FileMultimedia() {
		super();
	}

	public FileMultimedia(String name, byte[] filebytes) {
		super();
		this.name = name;
		this.filebytes = filebytes;
	}

	
	
	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getFilebytes() {
		return filebytes;
	}

	public void setFilebytes(byte[] filebytes) {
		this.filebytes = filebytes;
	}
	
	
}
