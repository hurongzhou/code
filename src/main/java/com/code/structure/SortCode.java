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
        int[] a={3,5,2,1,9,4,6};
        quickSort(a,0,a.length-1);
        HashSet<String> set=new HashSet();
        set.add("aa");
        System.out.println(JSON.toJSONString(a));
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

}
