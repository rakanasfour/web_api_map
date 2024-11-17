package net.radol.dto;

public class ItemAttributeDTO {

    private Integer itemAttributeId;
    private Integer mappedItemId;      // To hold the ID of the associated item
    private Integer attributeId;
    
    
	public ItemAttributeDTO(Integer itemAttributeId, Integer mappedItemId, Integer attributeId) {
		super();
		this.itemAttributeId = itemAttributeId;
		this.mappedItemId = mappedItemId;
		this.attributeId = attributeId;
	}


	public ItemAttributeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getItemAttributeId() {
		return itemAttributeId;
	}


	public void setItemAttributeId(Integer itemAttributeId) {
		this.itemAttributeId = itemAttributeId;
	}


	public Integer getMappedItemId() {
		return mappedItemId;
	}


	public void setMappedItemId(Integer mappedItemId) {
		this.mappedItemId = mappedItemId;
	}


	public Integer getAttributeId() {
		return attributeId;
	}


	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
    
	
	
	
    
    
    
    
}
