package maksym.db;
/**
 * TypeProd entity
 * @author Maks
 *
 */
public enum TypeProduct {
	//��������, �����������, ���������, ��������;
	MAIN_FOOD(0,"������� ���"), 
	MED_FOOD(1,"������ ���������"), 
	GOODIES(2,"������"), 
	CANNED_FOOD(3,"��������");
	
	private final int id;
	private final String name;
	
	private TypeProduct(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static TypeProduct fromId(int id) {
		for (TypeProduct type : values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		return null;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
