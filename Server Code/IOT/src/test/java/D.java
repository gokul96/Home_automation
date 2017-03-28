 
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javassist.bytecode.ByteArray;
 
public class D {
 
	    static void bubbleSort(int[] arr) {  
	        int n = arr.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] > arr[j]){  
	                                 //swap elements  
	                                 temp = arr[j-1];  
	                                 arr[j-1] = arr[j];  
	                                 arr[j] = temp;  
	                         }  
	                          
	                 } 
	                 
	                 for(int x=0; x < arr.length; x++){  
	                        System.out.print(arr[x] + " ");  
	                } 
	                 System.out.println();
	         }  
	  
	    }  
	    public static void main(String[] args) {  
	                int arr[] ={3,60,35,2,45,320,5};  
	                 
	                System.out.println("Array Before Bubble Sort");  
	                for(int i=0; i < arr.length; i++){  
	                        System.out.print(arr[i] + " ");  
	                }  
	                System.out.println();  
	                  
	                bubbleSort(arr);//sorting array elements using bubble sort  
	                 
	                System.out.println("Array After Bubble Sort");  
	                for(int i=0; i < arr.length; i++){  
	                        System.out.print(arr[i] + " ");  
	                }  
	   
	        }  
	}  



