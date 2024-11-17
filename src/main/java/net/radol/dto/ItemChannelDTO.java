package net.radol.dto;

public class ItemChannelDTO {

    private Integer itemChannelId;
    
    private Integer mappedChannelId; 
    
    private Integer mappedItemChannelId;

	public ItemChannelDTO(Integer itemChannelId, Integer mappedChannelId, Integer mappedItemChannelId) {
		super();
		this.itemChannelId = itemChannelId;
		this.mappedChannelId = mappedChannelId;
		this.mappedItemChannelId = mappedItemChannelId;
	}

	public ItemChannelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemChannelId() {
		return itemChannelId;
	}

	public void setItemChannelId(Integer itemChannelId) {
		this.itemChannelId = itemChannelId;
	}

	public Integer getMappedChannelId() {
		return mappedChannelId;
	}

	public void setMappedChannelId(Integer mappedChannelId) {
		this.mappedChannelId = mappedChannelId;
	}

	public Integer getMappedItemChannelId() {
		return mappedItemChannelId;
	}

	public void setMappedItemChannelId(Integer mappedItemChannelId) {
		this.mappedItemChannelId = mappedItemChannelId;
	}
	
	
	


	
   
    
}
