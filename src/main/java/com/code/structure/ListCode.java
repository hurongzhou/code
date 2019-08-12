package com.code.structure;

import com.code.domain.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author hurong3
 * @date 2019-07-29 11:06
 */
public class ListCode {

    public static void main(String[] args) {
        int n=10;
        ListNode head=new ListNode(1);
        ListNode curHeader=head;
        for (int i=2;i<=n;i++){
            head.next=new ListNode(i);
            head=head.next;
        }
        ListNode newHead=ReverseList(curHeader);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }

    /**
     * 从链表尾到头打印（递归）
     * @param listNode
     * @return
     */
    public static List<Integer> result=new ArrayList<>();
    public static List<Integer> printListFromTailToHead(ListNode listNode){
        if (listNode!=null){
            System.out.println("====进入方法 "+listNode.getVal());
            printListFromTailToHead(listNode.next);
            System.out.println("====返回上一级方法 "+listNode.getVal());
            result.add(listNode.val);
        }
        return result;
    }

    /**
     * 从链表尾到头打印（栈）
     * @param listNode
     * @return
     */
    public static List<Integer> printListFromTailToHead1(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        ListNode curNode=listNode;
        while (curNode!=null){
            stack.push(curNode.val);
            curNode=curNode.next;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 旋转链表（单指针，闭合圈）
     * @param listNode
     * @param k
     * @return
     */
    public static ListNode reverListNode(ListNode listNode,int k){
        if (listNode==null){
            return null;
        }
        ListNode indexNode=listNode;
        int n=1;
        while (indexNode.next!=null){
            indexNode=indexNode.next;
            n++;
        }
        indexNode.next=listNode;
        int i=n-k-1;
        for (int j=1;j<=i;j++){
            listNode=listNode.next;
        }
        ListNode newHeader=listNode.next;
        listNode.next=null;
        return newHeader;
    }

    /**
     * 旋转链表（双指针）
     * @param listNode
     * @param k
     * @return
     */
    public static ListNode reverListNode1(ListNode listNode,int k){
        if (listNode==null){
            return null;
        }
        ListNode fastNode=listNode;
        ListNode slowNode=listNode;
        int i=1;
        while (i<=k){
            fastNode=fastNode.next;
            i++;
        }
        while (fastNode.next!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next;
        }
        fastNode.next=listNode;
        ListNode newHeader=slowNode.next;
        slowNode.next=null;
        return newHeader;
    }

    /**
     * 找到链表环的入口
     * @param head
     * @return
     */
    public static int findCircleEntrance(ListNode head){
        if (head==null||head.next==null){
            return -1;
        }
        ListNode slowNode=head;
        ListNode fastNode=head;
        while (fastNode!=null&&fastNode.next!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next.next;
            if (slowNode==fastNode){
                ListNode newNode=head;
                while (newNode!=slowNode){
                    newNode=newNode.next;
                    slowNode=slowNode.next;
                }
                return newNode.val;
            }
        }
        return -1;
    }

    /**
     * 找到链表倒数第k个节点
     * 双指针，快的指针先移动k个节点，然后慢的再开始移动
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<1){
            return null;
        }
        ListNode fastNode=head;
        ListNode slowNode=head;
        int i=0;
        //fast移动到null为止
        while (fastNode!=null){
            fastNode=fastNode.next;
            if (i>=k){
                slowNode=slowNode.next;
            }
            i++;
        }
        if (i<k){
            return null;
        }
        return slowNode;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode next=head.next;
        pre.next=null;
        while (next!=null){
            ListNode cur=next;
            next=next.next;
            cur.next=pre;
            pre=cur;
        }
        return pre;
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode head=new ListNode();
        ListNode curHead=head;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                curHead.next=list1;
                curHead=curHead.next;
                list1=list1.next;
            }else {
                curHead.next=list2;
                curHead=curHead.next;
                list2=list2.next;
            }
        }
        if (list1!=null){
            curHead.next=list1;
        }
        if (list2!=null){
            curHead.next=list2;
        }
        return head.next;
    }
 }
