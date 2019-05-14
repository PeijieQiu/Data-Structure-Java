package tree.expression;

import java.util.Stack;

public class ExpressionTree {
    private String s="";
    private BinaryNode root;

    public static BinaryNode createTree(String[] expressions){
        BinaryNode operand1;
        BinaryNode operand2;
        Stack<BinaryNode> stack=new Stack<>();
        for (String s:expressions){
           if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
               operand1=stack.pop();
               operand2=stack.pop();
               stack.push(new BinaryNode(s,operand2,operand1));
           }else {
               stack.push(new BinaryNode(s));
           }

        }
        return stack.pop();
    }

    public static void printBinaryTree(int depth, BinaryNode binaryNode){
        for (int i=0;i<depth;i++){
            System.out.print(" ");
        }
        System.out.println(binaryNode.getElement());
        if (binaryNode.getLeft()!=null){
            printBinaryTree(depth+1,binaryNode.getLeft());
        }
        if (binaryNode.getRight()!=null){
            printBinaryTree(depth+1,binaryNode.getRight());
        }
    }

    public static void main(String[] args){
        String s="ab+cde+**";
        String[] splits=s.split("");
        BinaryNode binaryNode=createTree(splits);
        printBinaryTree(0,binaryNode);
    }
}
