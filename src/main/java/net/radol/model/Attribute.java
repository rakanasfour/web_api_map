package net.radol.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id", columnDefinition = "INT UNSIGNED")
    private int  attributeId ;

    @Column(name = "attribute_name", length = 25)
    private String attributeName;

    @Enumerated(EnumType.STRING)
    @Column(name = "attribute_type", nullable = false)
    private AttributeType attributeType;

    public enum AttributeType {
        TASTE,
        SIZE,
        SMELL,
        LOCATION
    }

    @Column(name = "attribute_assist_text", length = 250)
    private String attributeAssistText;
    
    
    @OneToMany(mappedBy = "mappedAttribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemAttribute> itemAttributes = new ArrayList<>();


	public Attribute(int attributeId, String attributeName, AttributeType attributeType, String attributeAssistText,
			List<ItemAttribute> itemAttributes) {
		super();
		this.attributeId = attributeId;
		this.attributeName = attributeName;
		this.attributeType = attributeType;
		this.attributeAssistText = attributeAssistText;
		this.itemAttributes = itemAttributes;
	}


	public Attribute() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getAttributeId() {
		return attributeId;
	}


	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}


	public String getAttributeName() {
		return attributeName;
	}


	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}


	public AttributeType getAttributeType() {
		return attributeType;
	}


	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}


	public String getAttributeAssistText() {
		return attributeAssistText;
	}


	public void setAttributeAssistText(String attributeAssistText) {
		this.attributeAssistText = attributeAssistText;
	}


	public List<ItemAttribute> getItemAttributes() {
		return itemAttributes;
	}


	public void setItemAttributes(List<ItemAttribute> itemAttributes) {
		this.itemAttributes = itemAttributes;
	}
	
	



    
	
    
    
}
