package is.swan.mcmarketapi;

public class Token {

    private final String tokenString;
    private final Type type;

    public Token(String tokenString, Type type) {
        this.tokenString = tokenString;
        this.type = type;
    }

    @Override
    public String toString() {
        return type.displayName + " " + tokenString;
    }

    public enum Type {
        PRIVATE("Private"),
        SHARED("Shared");

        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }
    }
}
