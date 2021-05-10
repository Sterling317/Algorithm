package Queue;

import sun.invoke.empty.Empty;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}
class ArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//头
    private int rear;//尾
    private int[] arr;//用于存放数据，模拟队列

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return  rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void add(int n){
        if(isFull()){
            System.out.println("The queue is full");

        }else{
            rear++;
            arr[rear] = n;
        }
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("The queue is empty,can not read data");
        }
        front++;
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("no data");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException(("no data"));
        }
        return arr[front+1];
    }
}