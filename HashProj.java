package testclass;
import javax.swing.JOptionPane;

        
/**
 *
 
 */

class Student{
    int ID;
    String name;
   String major;
   double avg;
   String s(){ String s ="Student ID="+ID+"\nStudent name="+name+"\nStudent avg="+avg+"\nStudent Major="+major;
   return s;}
    Student(int ID,String name ,String major,double avg)
   {this.ID=ID;
   this.name=name;
   this.avg=avg;
   this.major=major;
   }
   
   public int getID(){return ID;}
   public String getMajor(){return major;}
   public double getavg(){return avg;}
   
   public void PrintDetails(){
       
     
       System.out.println("Student ID ="+ID);
       System.out.println("Student avg ="+avg);
       System.out.println("Student major ="+major);
}
}
class Node{
  
 Student data;
 Node next;


public Node(){next=null;}
public Node(Student data){
    
    this.data=data;
    this.next=null;
}

}
 

 
 
  class HashTable{
    Node []a;
    int size;
   public HashTable(int size){
       this.size=size;
       a= new Node[this.size];
       for(int i=0;i<a.length;i++)
           a[i]=null;
   }
    public boolean empty(){return (size==0);}
    
    
   public int H(int key){return key%size;}
   
   
   public boolean insert(int key,Student value){
       
       int pos = H(key);
       if(a[pos]==null)a[pos]=new Node(value);
       
       else{
       
       
       Node temp=new Node(value);
      temp.next= a[pos].next;
       a[pos].next=temp;
       
   }return true;}
   
   
   public Student retrive(int key){
       
   Student s=null;
       
       int pos =H(key);
       Node p=a[pos];
       
       while(p!=null){
           if(p.data.ID==key){
               s = p.data;
                       break;}
       p=p.next;
       }
       return s; 
       
   }
   
  
   public boolean delete(int key){
   int pos=H(key); 
       if(a[pos]==null)return false;
   Node prev=a[pos];
   Node follow=a[pos];
   
   
  
     
   while(follow.next!=null &&follow.data.ID!=key){
       prev=follow;
       follow=follow.next;}
   
   if(follow.data.ID==key){
       if(follow==a[pos]){a[pos]=follow.next;follow=null;}
       
       else{
           prev.next=follow.next;follow=null;}}
   return true;
       
       
   }}
   
   
   
   
   
   
   
   
 

public class TestClass {

    
        
   
    public static void menu(){
     
    }        
            
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
         
        int ID;
   
        String name;
        double avg;
        String major;
        
    
         HashTable h = new HashTable(10);
       Character ch = new Character(' ');
     String s=ch.toString();
     String s1= "Please enter your choice"
      
           +"Welcome"+ "\n1 : insert\n2 Delete\n3 : Retrive\n4 : End\n";
    
    
            
     for(;;) {
         
        s=(JOptionPane.showInputDialog(null,s1, "Enter Choice",JOptionPane.QUESTION_MESSAGE));
     
      
      
        
       
            if(s.equals("1"))  {
                     ID=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter ID", "Enter ",JOptionPane.QUESTION_MESSAGE));

            
            while (h.retrive(ID)!=null)
            ID=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter ID", "Enter ",JOptionPane.WARNING_MESSAGE));
            name=JOptionPane.showInputDialog(null,"Enter name", "Enter ",JOptionPane.QUESTION_MESSAGE);
            avg= Double.parseDouble(JOptionPane.showInputDialog(null,"Enter avg", "Enter ",JOptionPane.QUESTION_MESSAGE));
             
            major=JOptionPane.showInputDialog(null,"Enter major", "Enter ",JOptionPane.QUESTION_MESSAGE);
            Student s2 = new Student(ID,name,major,avg);
            
            h.insert(s2.getID(), s2);}
            
             
            else  if(s.equals("2")){
            ID=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter ID", "Enter ",JOptionPane.QUESTION_MESSAGE));
            
                if(h.retrive(ID)!=null)h.delete(ID);
                else 
                    JOptionPane.showMessageDialog(null,"Not found", " ", JOptionPane.ERROR_MESSAGE);
            }
                
                
         else  if(s.equals("3")) {
       ID=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter ID", "Enter ",JOptionPane.QUESTION_MESSAGE));
                if(h.retrive(ID)==null) JOptionPane.showMessageDialog(null,"Notfound", "Enter ",JOptionPane.ERROR_MESSAGE);
                else 
                    JOptionPane.showMessageDialog(null,h.retrive(ID).s());
         }
         else if (s.equals("4")){break;}
     
     
     }
      JOptionPane.showMessageDialog(null, "Exit", "Exit",JOptionPane.ERROR_MESSAGE );
    
        // TODO code application logic here
       
      
     
    }
 
}
