import java.util.Scanner;

public class Stack {

    int top;
    int capacity;
    int arr[];

    Stack(int size){

        top = -1;
        capacity = size;
        arr = new int[size];
    }

    boolean isfull(){

        return top +1 == capacity;

    }

    boolean isempty(){
        return top == -1;

    }

    public void push(int x){

        if (isfull()) {
            System.out.println("Stack is full. ");

        }else{
            top++;
            arr[top] = x;
            System.out.println(" " + x );
        }


    }

    public void pop(){
        if (isempty()) {
            System.out.println("Stack is empty.");

        }else{
            System.out.println(" "+arr[top]);
            top--;
        }
    }

    public void print(){
        System.out.println("All value : ");
        for(int i = top; i>= 0; i--){
            System.out.println(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Stack ST = new Stack(5);

        System.out.println("Enter Data : ");

        for(int i = 0; i < 5; i++){
            int A = sc.nextInt();

            ST.push(A);
        }

        for(int i = ST.top; i>= 0;){
            System.out.println( ST.arr[ST.top] +"Complted stack , this remove   yes/no");
            
            String input = sc.nextLine().trim();

            if (input.equals("yes")) {
                ST.pop();
                i--;
            }
            else if (input.equals("no")) {
                System.out.println("Pending.....");
                break;

            }else{
                System.out.println("Invalid");
            }

        }
        System.out.println();
        ST.print();
        input.close();
    }
}

//Queue

import java.util.Scanner;

public class testQQ {


    int front;
    int rear;
    int capacity;
    String arr[];


    testQQ(int size){

        front = 0;
        rear = -1;
        capacity = size;
        arr = new String[size];

    }

    boolean isfull(){
        return rear + 1 == capacity;

    }
    boolean isempty(){
        return rear == -1; 
    }

    public void enqueue(String task){
        if (isfull()) {
            System.out.println("Q is full");
        }
        else{
            rear++;
            arr[rear] = task;
            System.out.println(task);
        }
    }
    public void dequeue(){
        if (isempty()) {
            System.out.println("Q is empty");
        }
        else{

            System.out.println(arr[front]);
            rear++;
        }
    }
    public void print(){
        System.out.println("a");
        for(int i=front; i <= rear; i++){
            System.out.println(arr[i]);
        } 
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        testQQ tq = new testQQ(5);
 
        tq.enqueue("red");
        tq.enqueue("blu");
        tq.enqueue("uhsn");
        tq.enqueue("hshjk");
      
        System.out.println();

        for(int i = tq.front; i <= tq.rear; i++){
            System.out.println(tq.arr[tq.front]+"task comple yes / no");
            String input = sc.nextLine().trim();

            
         if (input.equals("yes")) {
                tq.dequeue();
                
            }
        else if (input.equals("no")) {
            System.out.println("pending");
            break;

        }else{

            System.out.println("invalid");
                }   

        }
        System.out.println();
        tq.print();
    }

}

//Merge

import java.util.Arrays;
import java.util.Scanner;

public class testmerg1{

    static double[] merge(double[]arr){
        if(arr.length <= 1)
        return arr;

        int mid = arr.length/2;
        double[]left = Arrays.copyOfRange(arr, 0, mid);
        double[]right = Arrays.copyOfRange(arr, mid, arr.length);

        return mergeslogic(merge(left), merge(right));

    }

    static double[] mergeslogic(double[]a, double[]b){
        double[] res = new double[a.length+b.length];

        for(int i=0,j=0,k=0; k < res.length ; k++){
            if (i < a.length && (j >= b.length || a[i] < b[j])) res[k] = a[i++] ;

            else res[k] = b[j++];

        }
        return res;
    }
    
    public static void main(String[] args) {
        double arr[] = new double[5];
        double size = 5;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enterrr Data : ");

        for(int i =0 ; i < size ; i++){
            arr[i] = sc.nextDouble();

        }

        System.err.println("Sorted : " + Arrays.toString(merge(arr)));

    }
}

//Quick

import java.util.Scanner;

public class Quick {
   
    public static void main(String[] args) {
        int qarray[] = new int[10];
        int size = 10;
        Scanner UserIn = new Scanner(System.in);
        System.out.println("Enter data \n");

        for(int a=0; a<size; a++){
            qarray[a] = UserIn.nextInt();
        }

        System.out.println("\n Sorted : "+ " ");
        sort(qarray, 0, qarray.length - 1);
        for(int n : qarray)
        System.out.println(n + " ");
    }

    static void sort(int [] qarray, int low, int high){
        if (low<high) {
            int p = partition(qarray, low , high);
            sort(qarray, low, p-1);
            sort(qarray, p+1, high);
        }
    }

    static int partition(int[] qarray, int low, int high){
        int pivot = qarray[high];
        int i = low -1;
        for(int j = low; j < high; j++)
        if (qarray[j] <= pivot)
        swap(qarray, ++i, j);
        swap(qarray, i + 1, high);
        return i+ 1;
               
    }

    static void swap(int[] qarray, int i , int j){
        int t = qarray[i]; qarray[i] = qarray[j]; qarray[j] = t;
        
    }
}

//Tree

class node
 {
    int data;
    node left;
    node right;

    public node(int data)
    {
      this.data=data;
    }
 }
public class BST
{
   node root;
   
   public void insert(int data)
   {
       root=insertRec(root,data);
   }
   
   public node insertRec(node root, int data)
   {
       if(root==null)
       {
           root=new node(data);
       }
       else if(data<root.data)
       {
           root.left=insertRec(root.left, data);
       }
       else if(data>root.data)
       {
           root.right=insertRec(root.right, data);
       }
       
       return root;
   }
   
   public void preorder()
   {
       System.out.println();
       System.out.print("preorder :");
       preorderRec(root);
   }
   
   public void preorderRec(node root)
   {
       if(root !=null)
       {
           System.out.print(root.data+" ");
           preorderRec(root.left);
           preorderRec(root.right);
       }
   }
   
   public void inorder()
   {
       System.out.println();
       System.out.print("inorder :");
       inorderRec(root);
   }
   
   public void inorderRec(node root)
   {
       if(root != null)
       {
           inorderRec(root.left);
           System.out.print(root.data+" ");
           inorderRec(root.right);
       }
   }
   
   public void postorder()
   {
       System.out.println();
       System.out.print("Postorder: ");
       postorderRec(root);
   }
   
   public void postorderRec(node root)
   {
       if(root != null)
       {
           postorderRec(root.left);
           postorderRec(root.right);
           System.out.print(root.data+" ");
       }
   }
   
   public static void main(String[] args)
   {
       BST tree=new BST();
       tree.insert(25);
       tree.insert(56);
       tree.insert(42);
       tree.insert(12);
       tree.insert(30);
       tree.insert(21);
       tree.insert(90);
       tree.insert(100);
       tree.insert(8);
       tree.insert(95);
         
       tree.preorder();
       tree.inorder();
       tree.postorder();
   }
}