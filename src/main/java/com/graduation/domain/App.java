package com.graduation.domain;

public class App {

	private Integer id;

    private String img;

    private String title;
    
    private String link;
    
    private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public App() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", img=" + img + ", title=" + title + ", link=" + link + ", type=" + type + "]";
	}
    
    
}
