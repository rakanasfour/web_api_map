package net.radol.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import net.radol.model.Item.ItemStatus;


public class ItemDTO {

    private Integer itemId;
    private String itemName;
    private String itemSku;
    private String itemDescription;
    private String itemType;
    private Integer itemQuantity;
    private String itemAvailability;
    private String itemMsaPromoItem;
    private BigDecimal itemBasePrice;
    private BigDecimal itemWeight;
    private Timestamp itemCreatedAt;
    private Timestamp itemUpdatedAt;
    private String itemUpdatedAtBy;
    private ItemStatus itemStatus;
    private Integer manufacturerPricing;
    private Integer distributor;
    private Integer model;
    private Integer complianceCategory;
	private List<ItemAttributeDTO> itemAttributes;
	public ItemDTO(Integer itemId, String itemName, String itemSku, String itemDescription, String itemType,
			Integer itemQuantity, String itemAvailability, String itemMsaPromoItem, BigDecimal itemBasePrice,
			BigDecimal itemWeight, Timestamp itemCreatedAt, Timestamp itemUpdatedAt, String itemUpdatedAtBy,
			ItemStatus itemStatus, Integer manufacturerPricing, Integer distributor, Integer model,
			Integer complianceCategory, List<ItemAttributeDTO> itemAttributes) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemSku = itemSku;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemQuantity = itemQuantity;
		this.itemAvailability = itemAvailability;
		this.itemMsaPromoItem = itemMsaPromoItem;
		this.itemBasePrice = itemBasePrice;
		this.itemWeight = itemWeight;
		this.itemCreatedAt = itemCreatedAt;
		this.itemUpdatedAt = itemUpdatedAt;
		this.itemUpdatedAtBy = itemUpdatedAtBy;
		this.itemStatus = itemStatus;
		this.manufacturerPricing = manufacturerPricing;
		this.distributor = distributor;
		this.model = model;
		this.complianceCategory = complianceCategory;
		this.itemAttributes = itemAttributes;
	}
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSku() {
		return itemSku;
	}
	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getItemAvailability() {
		return itemAvailability;
	}
	public void setItemAvailability(String itemAvailability) {
		this.itemAvailability = itemAvailability;
	}
	public String getItemMsaPromoItem() {
		return itemMsaPromoItem;
	}
	public void setItemMsaPromoItem(String itemMsaPromoItem) {
		this.itemMsaPromoItem = itemMsaPromoItem;
	}
	public BigDecimal getItemBasePrice() {
		return itemBasePrice;
	}
	public void setItemBasePrice(BigDecimal itemBasePrice) {
		this.itemBasePrice = itemBasePrice;
	}
	public BigDecimal getItemWeight() {
		return itemWeight;
	}
	public void setItemWeight(BigDecimal itemWeight) {
		this.itemWeight = itemWeight;
	}
	public Timestamp getItemCreatedAt() {
		return itemCreatedAt;
	}
	public void setItemCreatedAt(Timestamp itemCreatedAt) {
		this.itemCreatedAt = itemCreatedAt;
	}
	public Timestamp getItemUpdatedAt() {
		return itemUpdatedAt;
	}
	public void setItemUpdatedAt(Timestamp itemUpdatedAt) {
		this.itemUpdatedAt = itemUpdatedAt;
	}
	public String getItemUpdatedAtBy() {
		return itemUpdatedAtBy;
	}
	public void setItemUpdatedAtBy(String itemUpdatedAtBy) {
		this.itemUpdatedAtBy = itemUpdatedAtBy;
	}
	public ItemStatus getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}
	public Integer getManufacturerPricing() {
		return manufacturerPricing;
	}
	public void setManufacturerPricing(Integer manufacturerPricing) {
		this.manufacturerPricing = manufacturerPricing;
	}
	public Integer getDistributor() {
		return distributor;
	}
	public void setDistributor(Integer distributor) {
		this.distributor = distributor;
	}
	public Integer getModel() {
		return model;
	}
	public void setModel(Integer model) {
		this.model = model;
	}
	public Integer getComplianceCategory() {
		return complianceCategory;
	}
	public void setComplianceCategory(Integer complianceCategory) {
		this.complianceCategory = complianceCategory;
	}
	public List<ItemAttributeDTO> getItemAttributes() {
		return itemAttributes;
	}
	public void setItemAttributes(List<ItemAttributeDTO> itemAttributes) {
		this.itemAttributes = itemAttributes;
	}
	
	
	
	
	
   
	
}

