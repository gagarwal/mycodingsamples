public class TrinaryNode
{
    private int key = -1;
    private TrinaryNode left;
    private TrinaryNode middle;
    private TrinaryNode right;
    private TrinaryNode parent;

    public TrinaryNode(TrinaryNode parent)
    {
        this.parent = parent;
    }

    public int getKey() 
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
        init();
    }

    public int getSubTreeCount()
    {
        return (getLeft().getKey() > 0 ? 1 : 0) +
                (getRight().getKey() > 0 ? 1 : 0) + (getMiddle().getKey() > 0 ? 1 : 0);
    }

    public boolean hasMiddleChild() {
        return getMiddle().getKey() > 0;
    }

    private void init() {
        setLeft(new TrinaryNode(this));
        setRight(new TrinaryNode(this));
        setMiddle(new TrinaryNode(this));
    }

    public TrinaryNode getLeft()
    {
        return left;
    }

    public void setLeft(TrinaryNode left) {
        this.left = left;
    }

    public TrinaryNode getMiddle() {
        return middle;
    }

    public void setMiddle(TrinaryNode middle) {
        this.middle = middle;
    }

    public TrinaryNode getRight() {
        return right;
    }

    public void setRight(TrinaryNode right) {
        this.right = right;
    }

    public TrinaryNode getParent() {
        return parent;
    }

    public void setParent(TrinaryNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "" + key;
    }
}
