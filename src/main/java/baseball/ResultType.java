package baseball;

public enum ResultType {
    Strike("스트라이크"),
    Ball("볼"),
    Nothing("낫싱");

    String name;

    ResultType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
