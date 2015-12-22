
import java.applet.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;

import java.util.*;

public class Assignment extends Applet  {

    boolean flagbg,flagfg;
    int x,y,w,h,arcx,arcy,fsize1,counter,fstyle1,msgsize,awidth,aheight,width;
    String size1,size2,ftype,bg,fg,msg,shape1,style2;
    Color bg1,fg1;
    HashMap map;
    Font f;
    Iterator itr,itr1;
    Set colors;
    FontMetrics fmetric;
    AppletContext Context ;
    
    @SuppressWarnings("empty-statement")
    public void init()
    {
      
       awidth= getWidth();
       aheight=getHeight();
       bg= getParameter("BGCOLOR");
       fg= getParameter("COLOR");       
       shape1= getParameter("SHAPE");
       ftype= getParameter("FTYPE");
       fsize1= Integer.parseInt(getParameter("FTSIZE"));  
       //fstyle1= Integer.parseInt(getParameter("FTSTYLE"));   
    style2=getParameter("FTSTYLE");      
       w= Integer.parseInt(getParameter("X"));
       h=Integer.parseInt(getParameter("Y"));
       arcx= Integer.parseInt(getParameter("ARCWIDTH"));
       arcy= Integer.parseInt(getParameter("ARCHEIGHT"));
    
    }
    
    // Shape Paramter
    public void paint(Graphics g)
    { 
    
     shape1 = getParameter("SHAPE");
        if (shape1==null)
            g.drawRect(awidth/3,aheight/4,h,w);
        
          else 
          
      {   
         switch (shape1) {
            case "RECTANGLE":
                g.drawRect(awidth/3,aheight/4,h,w);
                break;
            case "OVAL":
                g.drawOval(awidth/3,aheight/4,h,w);
                break;
            case "RoundRectangle":
                g.drawRoundRect(awidth/3,aheight/4,h,w,arcx,arcy);
                break;
            default:
                g.drawString("ERROR:INVALID SHAPE VALUE ",awidth/3+h/7,aheight/4+w/7);
                break;
        }  
          
      } 
        
    // Background Colors & Foreground Colors    
   
    HashMap h1 = new HashMap();
   
    h1.put("Red",Color.RED);
    h1.put("Black",Color.BLACK);
    h1.put("Blue",Color.BLUE);
    h1.put("Cyan",Color.CYAN);
    h1.put("DarkGray",Color.DARK_GRAY);
    h1.put("Green",Color.GREEN);
    h1.put("LightGray",Color.LIGHT_GRAY);
    h1.put("Magenta",Color.MAGENTA);
    h1.put("Orange",Color.ORANGE);
    h1.put("Pink",Color.PINK);
    h1.put("White",Color.WHITE);
    h1.put("Yellow",Color.YELLOW);
    
     colors =h1.keySet();
     itr= colors.iterator();
    
    while(itr.hasNext())
    {
        if(!bg.equals((String)itr.next()))
        {
           continue;
           
        }
        
       else
        { 
            
        bg1=((Color)h1.get(bg));
        
        flagbg = true; 
        
        }
        
    }
    // Foreground Colors
  
  itr1= colors.iterator();
      
    while(itr1.hasNext())
    {
        if(!fg.equals((String)itr1.next()))
        {
           continue;
           
        }
        
       else
        { 
            
       fg1= (Color) h1.get(fg);
       
        flagfg = true; 
        
        }
        
    }
    
    
    if(bg1!=fg1&&flagbg==true && flagfg==true)
        
    {
         setBackground(bg1);
         setForeground(fg1);
        
    }
  
    //if colour is same of background & foreground
    else if(flagbg==true || flagfg==true)
    {
        setBackground(bg1);
        setForeground(fg1);  
    }   
    
    else if (flagbg!=true && flagfg!=true)
     {
      g.drawString("ERROR:INVALID VALUE FOR COLOR",awidth/3+h/3,aheight/4+w/4);
      setBackground(Color.RED);
      }
    
  // Font time 
    
     
   
    if(style2.equals("BOLD"))
        {
              f= new Font("Times New Roman",Font.BOLD,fsize1);
              g.setFont(f);
        }
     else if (style2.equals ("PLAIN")) 
         {
             f= new Font("Times New Roman",Font.PLAIN,fsize1);
             g.setFont(f);
         }  
      
      else if(style2 .equals ("ITALIC"))
        {
           f= new Font("Times New Roman",Font.ITALIC,fsize1);
           g.setFont(f);
         }
         
         else
         {
            g.drawString ("Invalid Font Style",100,100);
         }
    
    
      
     msg= getParameter("MESSAGE");
     
          if(msg==null)
          {
             g.drawString("DEFAULT MSG VALUE",awidth/3+h/3,aheight/4+w/2);
             
          }
            
          else 
          {
              
              g.drawString(msg,awidth/3+h/3,aheight/4+w/2);
          
          }   
    
          // Vertically check
         if(fsize1>w)
      {
           g.setFont(new Font("Serif",Font.BOLD,20));
           g.drawString("MESSAGE TO LARGE TO FIT",100,240);
           
      }
          
       
          
    
      Toolkit t = Toolkit.getDefaultToolkit();
        fmetric=t.getFontMetrics(f);
      
     
     if(msg!=null)
     {
         width = fmetric.stringWidth(msg);
        
     }
        
        if(width>w && msg!=null)
        {
           
             g.setFont(new Font("Serif",Font.BOLD,15));
            g.drawString("MESSAGE TOO LARGE TO FIT",100,260);
             
        
        }  
      
        
    }

}
     
   