package week_1.jhsong.vo;

public class Command {

    private final String function;
    private final Integer number;

    public Command(String function, Integer number) {
        this.function = function;
        this.number = number;
    }

    public String getFunction() {
        return this.function;
    }

    public Integer getNumber() {
        return this.number;
    }
}
