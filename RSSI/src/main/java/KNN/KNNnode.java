package KNN;

public class KNNnode {

    private float x; //x轴

    private float y; //y轴

    private String type; //类型

    private double cmp; //比较值

    public KNNnode() {

    }

    public KNNnode(float x, float y, String type, double cmp) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.cmp = cmp;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCmp() {
        return cmp;
    }

    public void setCmp(double cmp) {
        this.cmp = cmp;
    }


    @Override
    public String toString(){
        return "节点信息：x="+x+",y="+y+",type="+type+" ";
    }




}
