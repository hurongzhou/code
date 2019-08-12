package com.code.structure;

import java.util.Stack;

/**
 * @author hurong3
 * @date 2019-08-04 17:09
 */
public class StackCode {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||popA==null){
            return false;
        }
        int j=0;
        Stack<Integer> s=new Stack<>();
        for (int i=0;i<pushA.length;i++){
            s.push(pushA[i]);
            while (!s.isEmpty()&&s.peek()==popA[j]){
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }
}
