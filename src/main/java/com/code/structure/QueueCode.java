package com.code.structure;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @author hurong3
 * @date 2019-07-29 20:13
 */
public class QueueCode {

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        QueueCode queueCode=new QueueCode(stack);
        queueCode.push(6);
        System.out.println(queueCode.pop());
        System.out.println(JSON.toJSONString(queueCode.stack1));
    }

    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();

    public void push(Integer num){
        stack1.push(num);
    }

    public Integer pop(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        Integer result=stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public QueueCode(Stack<Integer> stack1) {
        this.stack1 = stack1;
    }
}
