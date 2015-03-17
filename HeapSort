public class HeapSort {
	public static void maxHeapify(int[] a, int i, int length)  
	{  
	    int l = left(i);  
	    int r = right(i);  
	    int largest = i;  
	        if(l < length && a[l] > a[i])  
	                largest = l;  
	        if(r < length && a[r] > a[largest])  
	                largest = r;  
	        if(i != largest)  
	            swap(a, i, largest);  
	        else 
	        	return;
	       maxHeapify(a,largest,length);
	}
	public static int left(int i)
	{
		return 2*i+1;
	}
	public static int right(int i)
	{
		return 2*i+2;
	}
	public static void swap(int[] a,int i,int j)
	{
		int temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String args[])
	{
		int[] a={4,2,5,6,8,2,3,6,878,3562,234,231,141,23,1,45,65,7};
		
		for(int i=a.length/2;i>=0;i--)
		{
			maxHeapify(a,i,a.length);
		}
		
		
		for(int k=a.length-1;k>=0;k--)
		{
			swap(a,0,k);
			maxHeapify(a,0,k);
		}
		int i=a.length;
		int j=0;
		
		while(i>0)
		{
			System.out.print(a[j]+" ");
			j++;
			i--;
		}
	}
}
