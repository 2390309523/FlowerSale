package flower.com.entity;

/**
 * Flower entity. @author MyEclipse Persistence Tools
 */

public class Flower implements java.io.Serializable {

	// Fields

	private Integer id;
	private String flowerName;
	private String storeName;
	private Double flowerPrice;
	private Double flowerUpdataPrice;
	private String flowerArea;
	private String flowerIntroduce;
	private String flowerColor;
	private String flowerType;
	private Integer flowerStoke;
	private Integer flowerMaxBuy;
	private String filePathReal;
	private String filePath;
	private String englishName;
	private String flowerExpress;

	// Constructors

	/** default constructor */
	public Flower() {
	}

	/** minimal constructor */
	public Flower(String flowerName, String storeName, Double flowerPrice) {
		this.flowerName = flowerName;
		this.storeName = storeName;
		this.flowerPrice = flowerPrice;
	}

	/** full constructor */
	public Flower(String flowerName, String storeName, Double flowerPrice,
			Double flowerUpdataPrice, String flowerArea,
			String flowerIntroduce, String flowerColor, String flowerType,
			Integer flowerStoke, Integer flowerMaxBuy, String filePathReal,
			String filePath, String englishName, String flowerExpress) {
		this.flowerName = flowerName;
		this.storeName = storeName;
		this.flowerPrice = flowerPrice;
		this.flowerUpdataPrice = flowerUpdataPrice;
		this.flowerArea = flowerArea;
		this.flowerIntroduce = flowerIntroduce;
		this.flowerColor = flowerColor;
		this.flowerType = flowerType;
		this.flowerStoke = flowerStoke;
		this.flowerMaxBuy = flowerMaxBuy;
		this.filePathReal = filePathReal;
		this.filePath = filePath;
		this.englishName = englishName;
		this.flowerExpress = flowerExpress;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlowerName() {
		return this.flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Double getFlowerPrice() {
		return this.flowerPrice;
	}

	public void setFlowerPrice(Double flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	public Double getFlowerUpdataPrice() {
		return this.flowerUpdataPrice;
	}

	public void setFlowerUpdataPrice(Double flowerUpdataPrice) {
		this.flowerUpdataPrice = flowerUpdataPrice;
	}

	public String getFlowerArea() {
		return this.flowerArea;
	}

	public void setFlowerArea(String flowerArea) {
		this.flowerArea = flowerArea;
	}

	public String getFlowerIntroduce() {
		return this.flowerIntroduce;
	}

	public void setFlowerIntroduce(String flowerIntroduce) {
		this.flowerIntroduce = flowerIntroduce;
	}

	public String getFlowerColor() {
		return this.flowerColor;
	}

	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}

	public String getFlowerType() {
		return this.flowerType;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	public Integer getFlowerStoke() {
		return this.flowerStoke;
	}

	public void setFlowerStoke(Integer flowerStoke) {
		this.flowerStoke = flowerStoke;
	}

	public Integer getFlowerMaxBuy() {
		return this.flowerMaxBuy;
	}

	public void setFlowerMaxBuy(Integer flowerMaxBuy) {
		this.flowerMaxBuy = flowerMaxBuy;
	}

	public String getFilePathReal() {
		return this.filePathReal;
	}

	public void setFilePathReal(String filePathReal) {
		this.filePathReal = filePathReal;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getFlowerExpress() {
		return this.flowerExpress;
	}

	public void setFlowerExpress(String flowerExpress) {
		this.flowerExpress = flowerExpress;
	}

}