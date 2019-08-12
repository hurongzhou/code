package com.code.structure;

import com.code.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hurong3
 * @date 2019-08-04 18:35
 */
public class TreeCode {
    public static void main(String[] args) {

    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root==null){
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        List<TreeNode> queue=new ArrayList<>();
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
