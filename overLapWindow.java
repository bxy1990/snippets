
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
//Define Rectangle
class Rect{                            
       int x1,y1,x2,y2;
       int cpx,cpy;
       //Center of The Rectangle
       class CenterPoint{
               int x,y;
               public CenterPoint(int x,int y)
               {
                       this.x=x;
                       this.y=y;
               }
       }
       public Rect(int x1,int y1,int x2,int y2){
               this.x1=x1;
               this.y1=y1;
               this.x2=x2;
               this.y2=y2;
       }
       public CenterPoint getCP()
       {
                cpx=(x1+x2)/2;
             cpy=(y1+y2)/2;
               CenterPoint cp=new CenterPoint(cpx,cpy);
               return cp;
       }
       //Area of The rectangle
       public int getArea()
       {
               return (x2-x1)*(y2-y1);
       }
       //check if this rect overlap with other
       public Rect overLapCheck(Rect obj)
       {
    	   Rect temp=new Rect(0,0,0,0);
    	 if(obj==null)
    		temp=null;
    	 else
    	 {
    		 if((Math.abs(this.getCP().x-obj.getCP().x)<=((this.x2-this.x1)/2)+(obj.x2-obj.x1)/2)&&(Math.abs(this.getCP().y-obj.getCP().y)<=((this.y2-this.y1)/2)+(obj.y2-obj.y1)/2))
    		 {
    			 int x1,x2,y1,y2;
    			 x1=Math.max(this.x1, obj.x1);
    			 x2=Math.min(this.x2, obj.x2);
    			 y1=Math.max(this.y1, obj.y1);
    			 y2=Math.min(this.y2, obj.y2);
    			 temp=new Rect(x1,y1,x2,y2);
    		 }
    		 else
    			 temp=null;
    	 }
		return temp;

       }
       public boolean equals(Object obj)
       {
    	   boolean flag=false;
    	   if(obj==null)
    	   {
    		  flag=false;
    	   }
    	   else if(obj instanceof Rect)
    	   {
    		   Rect instance=(Rect) obj;
    		   if(instance.x1==this.x1&&instance.x2==this.x2&&instance.y1==this.y1&&instance.y2==this.y2)
    		   {
    			   flag= true;
    		   }
    		   else flag=false;
    	   }
    	  
    	   return flag;
       }
}

public class rectAreaCal { 
  //check if one rect is the same as other
static void inspector(ArrayList<Rect> arr)
{
	for(int i=0;i<arr.size()-1;i++)
	{
		for(int j=i+1;j<arr.size();j++)
		{
			if(arr.get(i).equals(arr.get(j)))
			{
				arr.remove(j);
				j--;
			}
		}
	}
}
static Scanner sc=new Scanner(System.in);
public static void main(String[] args)
{     //n rects to calculate
      int n=sc.nextInt();
      //use inclusive and exclusive principle .
      int totalArea=0,eachOverLap=0,third=0,last=0;
      ArrayList<Rect> arr=new ArrayList<Rect>();
      //input rect
      for(int i=0;i<n;i++)
      {
    	  Rect temp=new Rect(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
    	  arr.add(temp);
      }
      for(int i=0;i<n;i++)
      {
    	  totalArea+=arr.get(i).getArea();
      }
      //check the second item of in-exclusive princle
      for(int i=0;i<n-1;i++)
      {
    	  for(int j=i+1;j<n;j++)
    	  {
    		  if(arr.get(i).overLapCheck(arr.get(j))!=null)
    		  eachOverLap+=arr.get(i).overLapCheck(arr.get(j)).getArea();
    	  }
      }
      //calculate third item
     for(int i=0;i<n-2;i++)
     {
    	 for(int j=i+1;j<n-1;j++)
    	 {
    		 for(int k=j+1;k<n;k++)
    		 {
    			 if (arr.get(i).overLapCheck(arr.get(j))!=null) {
					Rect temp=arr.get(i).overLapCheck(arr.get(j));
					if(temp.overLapCheck(arr.get(k))!=null)
					third+=temp.overLapCheck(arr.get(k)).getArea();
					else 
						break;
				}
    			 else 
    				 break;
    		 }
    	 }
     }
     //the fourth item
     Rect temp=null;
     for(int i=1;i<n-1;i++)
     {
    	
    	if(arr.get(i).overLapCheck(arr.get(i-1))!=null&&i==1)
    	{
    	 temp=arr.get(i).overLapCheck(arr.get(i-1));
    	}
    	else if(temp!=null&&i>1)
    	{
    		if(temp.overLapCheck(arr.get(i))!=null);
    		{temp=temp.overLapCheck(arr.get(i));}
    	}
    	else 
    		break;
     }
     if(temp!=null)
     last=temp.getArea();
   //total area of the rects
     double k=totalArea-eachOverLap+third+Math.pow(-1, n-1)*last;
      System.out.println((int)k);
}
}