package maksym.db;

/**
 * TypeProd entity
 *
 * @author Maks
 */
public enum TypeProduct {
    MAIN_FOOD(0, "Основна іжа"),
    MED_FOOD(1, "Медичні препарати"),
    GOODIES(2, "Ласощі"),
    CANNED_FOOD(3, "Консерви");

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
