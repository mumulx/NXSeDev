/*
 *  Created by IntelliJ IDEA.
 *  User: 木木
 *  Date: 2020/6/19
 *  Time: 16:33
 */

public class Plain {
    //标准件名称
    private String name;
    //内径
    private String insideDiameter;
    //外径
    private String outsideDiameter;
    //厚度
    private String thickness;
    public Plain() {
    }
    public Plain(String name, String insideDiameter, String outsideDiameter, String thickness) {
        this.name = name;
        this.insideDiameter = insideDiameter;
        this.outsideDiameter = outsideDiameter;
        this.thickness = thickness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsideDiameter() {
        return insideDiameter;
    }

    public void setInsideDiameter(String insideDiameter) {
        this.insideDiameter = insideDiameter;
    }

    public String getOutsideDiameter() {
        return outsideDiameter;
    }

    public void setOutsideDiameter(String outsideDiameter) {
        this.outsideDiameter = outsideDiameter;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "Plain{" +
                "name='" + name + '\'' +
                ", insideDiameter='" + insideDiameter + '\'' +
                ", outsideDiameter='" + outsideDiameter + '\'' +
                ", thickness='" + thickness + '\'' +
                '}';
    }
}
