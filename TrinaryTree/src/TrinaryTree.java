import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nixit on 10/29/14.
 */
public class TrinaryTree {
    private TrinaryNode rootNode;

    public void insert(int value) 
    {
        TrinaryNode node = taverseToDesire(value, Operation.INSERT);
        node.setKey(value);
    }

    public boolean delete(int value) {
        TrinaryNode node = taverseToDesire(value, Operation.DELET);
        if (node == null) {
            System.out.println("No Nodes found");
            return false;
        }
        TrinaryNode pNode = node.getParent();

        /*
        //if node is root lets add one imaginary node, kind of lazy approach
        boolean imaginary = pNode == null;
        if (imaginary) {
            pNode = new TrinarryNode(null);
            pNode.setRight(node);
        }*/

        //node has no child, a leaf node
        if (node.getSubTreeCount() == 0) {
            deleteLeafeNode(node, pNode);
        }
        // Node hae One child
        else if (node.getSubTreeCount() == 1) {
            deleteNodeWithBrach(node, pNode);

        }
        //if node is having 2 or more sub tree
        else if (node.getSubTreeCount() >= 2) {
            deleteNodeWithTwoOrMoreBrach(node, pNode);
        }
        //If Node has middle child switch middle child directly to the place of node,
        // since only sub tree possible of middle child is the middle sub tree
        return true;
    }

    private void deleteNodeWithTwoOrMoreBrach(TrinaryNode node, TrinaryNode pNode) {
        //if it is root and has 2 or more child than we need do some more work
        if (pNode == null) {
            if (node.getMiddle().getKey() > 0) {

                node.getMiddle().setParent(pNode);
                node.getLeft().setParent(node.getMiddle());
                node.getRight().setParent(node.getMiddle());

                node.getMiddle().setLeft(node.getLeft());
                node.getMiddle().setRight(node.getRight());
                rootNode = node.getMiddle();
            } else {
                //search for the max{left wing of node}
                TrinaryNode replaceNode = getNodeToReplace(node.getLeft());
                TrinaryNode replaceParentNode = replaceNode.getParent();

                bottomNodeReplace(replaceNode, replaceParentNode);
                System.out.println(replaceNode);
                System.out.println(replaceParentNode);
                printTree();


                replaceNode.setParent(pNode);

                if (replaceNode != node.getLeft()) {
                    replaceNode.setLeft(node.getLeft());
                    node.getLeft().setParent(replaceNode);
                }
                if (replaceNode != node.getRight()) {
                    replaceNode.setRight(node.getRight());
                    node.getRight().setParent(replaceNode);
                }
                rootNode = replaceNode;
//                    System.out.print(replaceNode);
            }
        } else if (node.getKey() == pNode.getRight().getKey()) {
            if (node.getMiddle().getKey() > 0) {
                pNode.setRight(node.getMiddle());
                node.getMiddle().setParent(pNode);
                node.getMiddle().setLeft(node.getLeft());
                node.getMiddle().setRight(node.getRight());
                node.getLeft().setParent(node.getMiddle());
                node.getRight().setParent(node.getMiddle());
            } else {
                TrinaryNode replaceNode = getNodeToReplace(node.getLeft());
                TrinaryNode replaceParentNode = replaceNode.getParent();

                bottomNodeReplace(replaceNode, replaceParentNode);

                if (replaceNode != node.getLeft()) {
                    replaceNode.setLeft(node.getLeft());
                    node.getLeft().setParent(replaceNode);
                }
                if (replaceNode != node.getRight()) {
                    replaceNode.setRight(node.getRight());
                    node.getRight().setParent(replaceNode);
                }
                replaceNode.setParent(pNode);
                pNode.setRight(replaceNode);
//                    System.out.print(replaceNode);
            }
        } else if (node.getKey() == pNode.getLeft().getKey()) {
            if (node.getMiddle().getKey() > 0) {
                pNode.setLeft(node.getMiddle());
                node.getMiddle().setParent(pNode);
                node.getMiddle().setLeft(node.getLeft());
                node.getMiddle().setRight(node.getRight());
                node.getLeft().setParent(node.getMiddle());
                node.getRight().setParent(node.getMiddle());
            } else {
                TrinaryNode replaceNode = getNodeToReplace(node.getLeft());
                TrinaryNode replaceParentNode = replaceNode.getParent();

                bottomNodeReplace(replaceNode, replaceParentNode);

                replaceNode.setParent(pNode);
                pNode.setLeft(replaceNode);
                if (replaceNode != node.getLeft()) {
                    replaceNode.setLeft(node.getLeft());
                    node.getLeft().setParent(replaceNode);
                }
                if (replaceNode != node.getRight()) {
                    replaceNode.setRight(node.getRight());
                    node.getRight().setParent(replaceNode);
                }
//                    System.out.print(replaceNode);
            }
        }
    }

    private void deleteNodeWithBrach(TrinaryNode node, TrinaryNode pNode) {
        //if it is root and has one child just remove the node and make child root node
        if (pNode == null) {
            if (node.getMiddle().getKey() > 0) {
                node.getMiddle().setParent(null);
                rootNode = node.getMiddle();
            } else if (node.getRight().getKey() > 0) {
                node.getRight().setParent(null);
                rootNode = node.getRight();
            } else if (node.getLeft().getKey() > 0) {
                node.getLeft().setParent(null);
                rootNode = node.getLeft();
            }
        }
        // If node is in right wing of the parent node
        else if (node.getKey() == pNode.getRight().getKey()) {
            //remove the reference of node from the parent's right wing with the use of child node
            if (node.getMiddle().getKey() > 0) {
                pNode.setRight(node.getMiddle());
                node.getMiddle().setParent(pNode);
            } else if (node.getRight().getKey() > 0) {
                pNode.setRight(node.getRight());
                node.getRight().setParent(pNode);
            } else {
                pNode.setRight(node.getLeft());
                node.getLeft().setParent(pNode);
            }
        }
        //if node is on the left wing
        else if (node.getKey() == pNode.getLeft().getKey()) {
            //remove the reference of node from the parent's left wing with the use of child node
            if (node.getMiddle().getKey() > 0) {
                pNode.setLeft(node.getMiddle());
                node.getMiddle().setParent(pNode);
            } else if (node.getRight().getKey() > 0) {
                pNode.setLeft(node.getRight());
                node.getRight().setParent(pNode);
            } else {
                pNode.setLeft(node.getLeft());
                node.getLeft().setParent(pNode);
            }
        }
    }

    private void deleteLeafeNode(TrinaryNode node, TrinaryNode pNode) {
        //if it is root and has no child than just remove the node
        if (pNode == null) {
            rootNode = null;
        }
        //node is in the right wing of the parent node
        else if (node.getKey() == pNode.getRight().getKey()) {
            //since there is no sub tree of node, so, just adding blank node to the parent node
            pNode.setRight(node.getRight());
        }
        //node is in the left wing of the parent node
        else if (node.getKey() == pNode.getLeft().getKey()) {
            pNode.setLeft(node.getLeft());
        }
    }

    private void bottomNodeReplace(TrinaryNode node, TrinaryNode pNode) {
        //Remove the node MAXimum node from the right wing
        if (node.getKey() == pNode.getRight().getKey()) {
            //remove the reference of node from the parent's right wing with the use of child node
            if (node.getMiddle().getKey() > 0) {
                pNode.setRight(node.getMiddle());
                node.getMiddle().setParent(pNode);
            } else if (node.getRight().getKey() > 0) {
                pNode.setRight(node.getRight());
                node.getRight().setParent(pNode);
            } else {
                pNode.setRight(node.getLeft());
                node.getLeft().setParent(pNode);
            }
        }
        //if node is on the left wing
        else if (node.getKey() == pNode.getLeft().getKey()) {
            //remove the reference of node from the parent's left wing with the use of child node
            if (node.getMiddle().getKey() > 0) {
                pNode.setLeft(node.getMiddle());
                node.getMiddle().setParent(pNode);
            } else if (node.getRight().getKey() > 0) {
                pNode.setLeft(node.getRight());
                node.getRight().setParent(pNode);
            } else {
                pNode.setLeft(node.getLeft());
                node.getLeft().setParent(pNode);
            }
        }
    }

    private TrinaryNode taverseToDesire(int value, Operation operation) {
        TrinaryNode node;
        if (rootNode == null) {
            rootNode = node = new TrinaryNode(null);
        } else {
            node = rootNode;
            while (checkCondition(node, value, operation)) {
                if (node.getKey() > value) {
                    node = node.getLeft();
                } else if (node.getKey() < value) {
                    node = node.getRight();
                } else if (node.getKey() == value) {
                    node = node.getMiddle();
                }
            }
        }
        return node;
    }

    private TrinaryNode getNodeToReplace(TrinaryNode node) {
        TrinaryNode rNode = node;
        while (rNode.getRight().getKey() > 0) {
            rNode = rNode.getRight();
        }
        return rNode;
    }

    private boolean checkCondition(TrinaryNode node, int value, Operation operation) {
        switch (operation) {
            case INSERT:
                return node.getKey() > 0;
            case DELET:
                return node.getKey() != value;

        }
        return false;
    }

    public List<Integer> inorderTraversal(TrinaryNode root) {
        List<Integer> lst = new ArrayList<Integer>();

        if (root == null)
            return lst;

        Stack<TrinaryNode> stack = new Stack<TrinaryNode>();
        //define a pointer to track nodes
        TrinaryNode p = root;

        while (!stack.empty() || (p != null && p.getKey() > 0)) {

            // if it is not null, push to stack
            //and go down the tree to left
            if (p != null && p.getKey() > 0) {
                stack.push(p);
                if (p.hasMiddleChild()) {
                    stack.push(p.getMiddle());
                }
                p = p.getLeft();

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            } else {
                TrinaryNode t = stack.pop();
                lst.add(t.getKey());
                p = t.getRight();
            }
        }

        return lst;
    }

    public void printTree() {
        System.out.println(inorderTraversal(rootNode));
    }

    enum Operation {
        INSERT, DELET;
    }
}