package com.code.structure;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hurong3
 * @date 2019-08-02 12:47
 */
public class SortCode {

    public static void main(String[] args) {
        int[] a=new int[10000];
        for (int i=1;i<=10000;i++){
            a[i-1]= (int) (Math.random()*50000);
        }
        System.out.println(JSON.toJSONString(a));
//        int[] a={3,5,2,1,9,4,6,11,15,21,15,100,5,26,76,32,16,35};
        long start=System.currentTimeMillis();
        heapSort(a);
        System.out.println(JSON.toJSONString(a));
        long end=System.currentTimeMillis();
        System.out.println("排序耗时："+(end-start)+"ms");
    }

    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array){
        if (array==null){
            return;
        }
        int len=array.length;
        for (int i=0;i<len;i++){
            for (int j=0;j<len-i-1;j++){
                if (array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(int[] array){
        if (array==null){
            return;
        }
        int len=array.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if (array[j]<array[i]){
                    int tem=array[i];
                    array[i]=array[j];
                    array[j]=tem;
                }
            }
            System.out.println(JSON.toJSONString(array));
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array){
        if (array==null){
            return;
        }
        int i;
        for (i=1;i<array.length;i++){
            int cur=array[i];
            int j=i-1;
            while (j>=0&&cur<array[j]){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=cur;
        }
    }

    /**
     * 快速排序
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array,int left,int right){
        if (array==null||array.length==1){
            return;
        }
        if (left<right){
            int part= partition(array,left,right);
            quickSort(array,left,part-1);
            quickSort(array,part+1,right);
        }
    }

    public static int partition(int[] array, int left, int right){
        int key=array[left];
        while (left<right){
            while (left<right&&array[right]>key){
                right--;
            }
            array[left]=array[right];
            while (left<right&&array[left]<=key){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=key;
        return left;
    }


    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        int len=array.length;
        for (int i=len/2;i>=0;i--){
            buildHeap(array,i,len);
        }
        for (int j=len-1;j>=0;j--){
            swap(array,0,j);
            buildHeap(array,0,j);
        }
    }

    public static void buildHeap(int[] array,int index,int len){
        int root=index;
        for (int left=2*root+1;left<len;left=2*left+1){
            if ((left+1)<len&&array[left+1]>array[left]){
                left=left+1;
            }
            if (array[root]<array[left]){
                swap(array,root,left);
            }
            root=left;
        }
    }

    public static void swap(int[] array,int i,int j){
        int tem=array[i];
        array[i]=array[j];
        array[j]=tem;
    }


}
