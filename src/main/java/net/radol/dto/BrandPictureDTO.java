package net.radol.dto;

public class BrandPictureDTO {

    private Integer brandPictureId;
    private String brandPictureName;
    private String brandPictureLink;
    private Integer brand; // ID of the associated Brand
    
	public BrandPictureDTO(Integer brandPictureId, String brandPictureName, String brandPictureLink, Integer brand) {
		super();
		this.brandPictureId = brandPictureId;
		this.brandPictureName = brandPictureName;
		this.brandPictureLink = brandPictureLink;
		this.brand = brand;
	}

	public BrandPictureDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBrandPictureId() {
		return brandPictureId;
	}

	public void setBrandPictureId(Integer brandPictureId) {
		this.brandPictureId = brandPictureId;
	}

	public String getBrandPictureName() {
		return brandPictureName;
	}

	public void setBrandPictureName(String brandPictureName) {
		this.brandPictureName = brandPictureName;
	}

	public String getBrandPictureLink() {
		return brandPictureLink;
	}

	public void setBrandPictureLink(String brandPictureLink) {
		this.brandPictureLink = brandPictureLink;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	
	
    
}
