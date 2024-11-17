package net.radol.dto;

import java.util.List;

import net.radol.model.SalesCategory.MeasurementType;
import net.radol.model.SalesCategory.SystemMeasurement;


public class SalesCategoryDTO {
    private Integer salesCategoryId;
    private String salesCategoryName;
    private  MeasurementType salesCategoryMeasurementType;
    private  SystemMeasurement salesCategorySystemMeasurement;
    private List<ItemSalesCategoryDTO> itemSalesCategories;
    
    
	public SalesCategoryDTO(Integer salesCategoryId, String salesCategoryName,
			MeasurementType salesCategoryMeasurementType, SystemMeasurement salesCategorySystemMeasurement,
			List<ItemSalesCategoryDTO> itemSalesCategories) {
		super();
		this.salesCategoryId = salesCategoryId;
		this.salesCategoryName = salesCategoryName;
		this.salesCategoryMeasurementType = salesCategoryMeasurementType;
		this.salesCategorySystemMeasurement = salesCategorySystemMeasurement;
		this.itemSalesCategories = itemSalesCategories;
	}


	public SalesCategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getSalesCategoryId() {
		return salesCategoryId;
	}


	public void setSalesCategoryId(Integer salesCategoryId) {
		this.salesCategoryId = salesCategoryId;
	}


	public String getSalesCategoryName() {
		return salesCategoryName;
	}


	public void setSalesCategoryName(String salesCategoryName) {
		this.salesCategoryName = salesCategoryName;
	}


	public MeasurementType getSalesCategoryMeasurementType() {
		return salesCategoryMeasurementType;
	}


	public void setSalesCategoryMeasurementType(MeasurementType salesCategoryMeasurementType) {
		this.salesCategoryMeasurementType = salesCategoryMeasurementType;
	}


	public SystemMeasurement getSalesCategorySystemMeasurement() {
		return salesCategorySystemMeasurement;
	}


	public void setSalesCategorySystemMeasurement(SystemMeasurement salesCategorySystemMeasurement) {
		this.salesCategorySystemMeasurement = salesCategorySystemMeasurement;
	}


	public List<ItemSalesCategoryDTO> getItemSalesCategories() {
		return itemSalesCategories;
	}


	public void setItemSalesCategories(List<ItemSalesCategoryDTO> itemSalesCategories) {
		this.itemSalesCategories = itemSalesCategories;
	}
	
	
    
    
    
    
    
}


