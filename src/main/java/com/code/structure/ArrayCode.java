package com.code.structure;

import com.alibaba.fastjson.JSON;

/**
 * @author hurong3
 * @date 2019-07-29 11:10
 */
public class ArrayCode<D> {

    private D object;

    public D getObject() {
        return object;
    }

    public void setObject(D object) {
        this.object = object;
    }

    public static void main(String[] args) {
        int[][] array={{1,2,5,7},{3,4,8,11}};
        int[] a={3,4,5,6,7,8,9,1,2};
        reOrderArray(a);
        System.out.println(JSON.toJSONString(a));
    }

    /**
     * 二维数组查找
     * @param target
     * @param array
     * @return
     */
    public static boolean findInArray2(int target,int[][] array){
        int length=array.length;
        int size=array[0].length;
        int index=length-1;
        int column=0;
        while (index>=0&&column<size){
            if (target>array[index][column]){
                column++;
            }else if (target<array[index][column]){
                index--;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 有序数组旋转，求最小
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array){
        if (array==null||array.length==0){
            return 0;
        }
        int left=0;
        int right=array.length-1;
        while (left<right){
            int middle=left+(right-left)/2;
            if (array[middle]>array[left]){
                left=middle+1;
            }else if (array[middle]<array[right]){
                right=middle;
            }else {
                left+=1;
            }
        }
        return array[left];
    }

    /**
     * 二分查找
     * @param target
     * @param array
     * @return
     */
    public static int findInSortArray(int target,int[] array){
        if (array==null||array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int middle=(left+right)/2;
            if (target>array[middle]){
                left=middle+1;
            }else if (target<array[middle]){
                right=middle-1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static int Fibonacci(int n) {
//        int sum1=1;
//        int sum2=1;
        if (n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
//        for (int i=3;i<n;i++){
//            int temp=sum1;
//            sum1=sum2;
//            sum2=temp+sum2;
//        }
//        return sum1+sum2;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void reOrderArray(int [] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }




}
