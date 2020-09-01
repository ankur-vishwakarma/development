package check;

import java.util.Scanner;

public class aa {
public static void main(String[] args) {
	int a[]=new int[10];
	Scanner sc=new Scanner(System.in);
	for(int i=0;i<10;i++) a[i]=sc.nextInt();
	for(int i=0;i<10;i++) System.out.println(a[i]);
	for(int i=0;i<10;i++) {
		for(int j=i+1;j<10;j++) {
			if(a[i]>a[j]) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	System.out.println("dddd");
	for(int i=0;i<10;i++) System.out.println(a[i]);
}
}
