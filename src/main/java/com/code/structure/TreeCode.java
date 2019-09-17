package com.code.structure;

import com.code.domain.TreeNode;

import java.util.*;

/**
 * @author hurong3
 * @date 2019-08-04 18:35
 */
public class TreeCode {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.right.left=new TreeNode(5);
        System.out.println(binaryTreePaths(treeNode));
    }

    public static List<Integer> binaryTreePaths(TreeNode root){
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            if (treeNode.left==null&&treeNode.right==null){
                list.add(treeNode.val);
            }
            if (treeNode.left!=null){
                treeNode.left.val=treeNode.val+treeNode.left.val;
                stack.push(treeNode.left);
            }
            if (treeNode.right!=null){
                treeNode.right.val=treeNode.val+treeNode.right.val;
                stack.push(treeNode.right);
            }
        }
        return list;
    }


    public static ArrayList<Integer> prePrint(TreeNode root){
        ArrayList<Integer> arr=new ArrayList<>();
        if (root==null){
            return arr;
        }
        TreeNode curNode;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            curNode=stack.pop();
            arr.add(curNode.val);
            if (curNode.right!=null){
                stack.add(curNode.right);
            }if (curNode.left!=null){
                stack.add(curNode.left);
            }
        }
        return arr;
    }

    public static ArrayList<Integer> middlePrint(TreeNode root){
        ArrayList<Integer> arr=new ArrayList<>();
        if (root==null){
                return arr;
        }
        TreeNode curNode=root;
        Stack<TreeNode> stack=new Stack<>();
        while (curNode!=null||!stack.isEmpty()){
            while (curNode!=null){
                stack.push(curNode);
                curNode=curNode.left;
            }
            TreeNode node=stack.pop();
            arr.add(node.val);
            curNode=node.right;
        }
        return arr;
    }

    public static ArrayList<Integer> afterPrint(TreeNode root){
        ArrayList<Integer> arr=new ArrayList<>();
        if (root==null){
            return arr;
        }
        TreeNode curNode=root;
        TreeNode pre=null;
        Stack<TreeNode> stack=new Stack<>();
        while (curNode!=null||!stack.isEmpty()){
            while (curNode!=null){
                stack.add(curNode);
                curNode=curNode.left;
            }
            curNode=stack.peek();
            if (curNode.right!=null&&curNode.right!=pre){
                curNode=curNode.right;
            }else {
                curNode=stack.pop();
                arr.add(curNode.val);
                pre=curNode;
                curNode=null;
            }
        }
        return arr;
    }


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null){
            return false;
        }
        if(root2==null){
            return false;
        }
        boolean flag=false;
        flag=subTree(root1,root2);
        if(!flag){
            flag=HasSubtree(root1.left,root2);
        }
        if(!flag){
            flag=HasSubtree(root1.right,root2);
        }
        return flag;
    }

    public boolean subTree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return subTree(root1.left,root2.left)&&subTree(root1.right,root2.right);
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root==null){
            return null;
        }
        ArrayList<Integer> list=new ArrayList();
        List<TreeNode> queue=new ArrayList();
        queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            for (int i=0;i<n;i++){
                TreeNode cur=queue.remove(0);
                list.add(cur.val);
                if (cur.left!=null){
                    queue.add(cur.left);
                }
                if (cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }
        return list;
    }
}
