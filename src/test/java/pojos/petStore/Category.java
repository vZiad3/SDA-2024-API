package pojos.petStore;

public class Category{
	private String name;
	private Integer id;

	public Category(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public Category() {
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Category{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
