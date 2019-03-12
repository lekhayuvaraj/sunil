package com.training.bean;

public class CategoryBean {
	private String categoryname;
	private String description;
	private String metatagtitle;
	private String metatagdescription;
	

	public CategoryBean() {
	}

	public CategoryBean(String categoryname, String description, String metatagtitle, String metatagdescription) {
		super();
		this.categoryname = categoryname ;
		this.description= description;
		this.metatagtitle= metatagtitle;
		this.metatagdescription= metatagdescription;
	}

	public String getcategoryname() {
		return categoryname;
	}

	public void setcategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getmetatagtitle() {
		return metatagtitle;
	}

	public void setmetatagtitle(String metatagtitle) {
		this.metatagtitle = metatagtitle;
	}

	public String getmetatagdescription() {
		return metatagdescription;
	}

	public void setmetatagdescription(String metatagdescription) {
		this.metatagdescription = metatagdescription;
	}
	@Override
	public String toString() {
		return "CategoryBean [categoryname=" + categoryname + ", description=" + description + ", metatagtitle=" + metatagtitle + ", metatagdescription=" + metatagdescription + "]";
	}

}
