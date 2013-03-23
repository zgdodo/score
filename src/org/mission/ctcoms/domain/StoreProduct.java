package org.mission.ctcoms.domain;

public class StoreProduct {
	//ZY_STORE_PRODUCT
	private Long id;//	ID	NUMBER(12)	Y			no	ID
	private String text;
	private String name;//	NAME	VARCHAR2(32)					产品名
	private String productUnit; //	PRODUCT_UNIT	VARCHAR2(32)					产品单位
	private String description;//	DESCRIPTION	CLOB					备注
	private Long parentId;//	PARENT_ID	NUMBER(12)					父节点ID
	private Long kidNum;//KID_NUM
	private Long productNum;
	private boolean leaf;
	private String fillNum;
	
	private String productBrand; //产品品牌
	
	private Long isSmartPhone;
	
	private String isSmartPhoneName;
	
	private String idName ;

	/**
	 * 0表示有下级部门，1表是没有下级部门
	 */
	private Integer isLeaf;
	
	
	public Integer getIsLeaf() {
		if(kidNum != null && kidNum > 0){
			isLeaf = 0;
		}else{
			isLeaf = 1;
			
		}
		return isLeaf;
	}
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
	public Long getKidNum() {
		return kidNum;
	}
	public void setKidNum(Long kidNum) {
		this.kidNum = kidNum;
	}
	public boolean isLeaf() {
		if(kidNum != null && kidNum > 0){
			leaf = false;
		}else{
			leaf = true;
			
		}
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getText() {
		text = name;
//		if(fillNum != null && fillNum.equals("1")){
//			productNum = productNum ==null?0:productNum;
//				if(leaf){
//				text += "("+ productNum +")";
//				}
//				
//			
//			
//			
//		}
		
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public Long getProductNum() {
		productNum = productNum == null?0l:productNum;
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getFillNum() {
		return fillNum;
	}
	public void setFillNum(String fillNum) {
		this.fillNum = fillNum;
	}
	public Long getIsSmartPhone() {
		return isSmartPhone;
	}
	public void setIsSmartPhone(Long isSmartPhone) {
		this.isSmartPhone = isSmartPhone;
	}
	public String getIsSmartPhoneName() {
		return isSmartPhoneName;
	}
	public void setIsSmartPhoneName(String isSmartPhoneName) {
		this.isSmartPhoneName = isSmartPhoneName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}

}
