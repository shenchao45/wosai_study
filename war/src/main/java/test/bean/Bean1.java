package test.bean;

public class Bean1 implements Bean1Interface {
    @Override
    public void say() {
        System.out.println("say 1");
    }


    private String name;
}
