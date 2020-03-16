package designMode.builderMode;

/**
 * 指定创建的复杂对象
 */
public class Product {
    private String pathA;
    private String pathB;
    private String pathC;

    public String getPathA() {
        return pathA;
    }

    public void setPathA(String pathA) {
        this.pathA = pathA;
    }

    public String getPathB() {
        return pathB;
    }

    public void setPathB(String pathB) {
        this.pathB = pathB;
    }

    public String getPathC() {
        return pathC;
    }

    public void setPathC(String pathC) {
        this.pathC = pathC;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pathA='" + pathA + '\'' +
                ", pathB='" + pathB + '\'' +
                ", pathC='" + pathC + '\'' +
                '}';
    }
}
