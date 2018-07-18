package springmvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Phone {
	private int id;
	@Size(min=2,max=24,message="2~24个字")
	private  String brand;
	@Size(min=2,max=24,message="2~24个字")
	private String model;
	@Size(min=2,max=24,message="2~24个字")
	private String os;
	@Size(min=2,max=24,message="2~24个字")
	private String cpuBrand;
	@Size(min=2,max=24,message="2~24个字")
	private String ram;
	@Size(min=2,max=24,message="2~24个字")
	private String storage;
	@Size(min=2,max=24,message="2~24个字")
	private String color;
	@Size(min=2,max=24,message="2~24个字")
	private String description;
	@NotNull(message="必填")
	private int price;
	public Phone() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getCpuBrand() {
		return cpuBrand;
	}
	public void setCpuBrand(String cpuBrand) {
		this.cpuBrand = cpuBrand;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getstorage() {
		return storage;
	}
	public void setstorage(String storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", brand=" + brand + ", model=" + model + ", os=" + os + ", cpuBrand=" + cpuBrand
				+ ", ram=" + ram + ", storage=" + storage + ", color=" + color + ", description=" + description
				+ ", price=" + price + "]";
	}
	
	
}
