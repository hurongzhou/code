package com.code;

import com.alibaba.fastjson.JSON;
import com.code.domain.TreeNode;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * @author hurong3
 * @date 2019-07-29 10:57
 */
public class Test {


    public static void main(String[] args) {

        Integer integer=new Integer(2);
//        int[] a={1,2,4,7,3,5,6,8};
//        int[] b={4,7,2,1,5,3,8,6};
//        Animal animal=new Animal();
//        ThreadA threadA=new ThreadA(animal);
//        Thread ta=new Thread(threadA);
//        ta.start();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ThreadB threadB=new ThreadB(animal);
//        Thread tb=new Thread(threadB);
//        tb.start();
    }


    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre==null||in==null){
            return null;
        }
        if (pre.length==1){
            return new TreeNode(pre[0]);
        }
        List<Integer> inList=new ArrayList();
        for (int i=0;i<in.length;i++){
            inList.add(in[i]);
        }
        TreeNode head=new TreeNode(pre[0]);
        TreeNode node=head;
        int[] visited=new int[pre.length];
        Stack<TreeNode> stack=new Stack();
        int j=inList.indexOf(pre[0]);
        visited[j]=1;
        int i=1;
        while (i<pre.length){
            if (j>0&&visited[j-1]!=1){
                node.left=new TreeNode(pre[i]);
                stack.push(node);
                visited[j]=1;
                j=inList.indexOf(pre[i]);
                node=node.left;
                i++;
            }else if (j<in.length&&visited[j+1]!=1){
                node.right=new TreeNode(pre[j]);
                visited[j]=1;
                j=inList.indexOf(pre[j]);
                node=node.right;
                i++;
            }else {
                node=stack.pop();
                j=inList.indexOf(node.val);
            }
        }
        return head;
    }


    public static void animalCry(Animal a) {
    }
}
