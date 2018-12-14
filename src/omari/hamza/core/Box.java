package omari.hamza.core;

public class Box {

    private boolean hasTop;
    private boolean hasBottom;
    private boolean hasLeft;
    private boolean hasRight;
    private String owner;
    private int boxNum;

    public Box(boolean hasTop, boolean hasBottom, boolean hasLeft, boolean hasRight, String owner, int boxNum) {
        this.hasTop = hasTop;
        this.hasBottom = hasBottom;
        this.hasLeft = hasLeft;
        this.hasRight = hasRight;
        this.owner = owner;
        this.boxNum = boxNum;
    }

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
    }

    public boolean isHasTop() {
        return hasTop;
    }

    public void setHasTop(boolean hasTop) {
        this.hasTop = hasTop;
    }

    public boolean isHasBottom() {
        return hasBottom;
    }

    public void setHasBottom(boolean hasBottom) {
        this.hasBottom = hasBottom;
    }

    public boolean isHasLeft() {
        return hasLeft;
    }

    public void setHasLeft(boolean hasLeft) {
        this.hasLeft = hasLeft;
    }

    public boolean isHasRight() {
        return hasRight;
    }

    public void setHasRight(boolean hasRight) {
        this.hasRight = hasRight;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
