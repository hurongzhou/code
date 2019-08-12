package com.code.structure;

import com.code.domain.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hurong3
 * @date 2019-08-01 19:51
 */
public class FindCode {

    public static void main(String[] args) {
        Node node=new Node();
        node.setS("Df");
        ArrayCode<Node> arrayCode=new ArrayCode<>();
        arrayCode.setObject(node);

        System.out.println(arrayCode.getObject().getS());
    }


    public static boolean halfFind(int target,int[] array){
        if (array==null){
            return false;
        }
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (target>array[mid]){
                left=mid+1;
            }else if (target<array[mid]){
                right=mid-1;
            }else {
                return true;
            }
        }
        return false;
    }
}
