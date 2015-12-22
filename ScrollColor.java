import java.awt.*;
import java.awt.event.*;

class ScrollColor implements AdjustmentListener
{
	static int r,g,b;
	Frame f;
	Scrollbar sb1,sb2,sb3;
	Panel p1,p2;
	Label l1,l2,l3;
	TextField t1,t2,t3;
	public ScrollColor()
	{
		f=new Frame();
		f.setSize(500,500);
		p1=new Panel(new GridLayout(1,3));
		sb1=new Scrollbar(Scrollbar.VERTICAL,25,5,0,260);
		sb2=new Scrollbar(Scrollbar.VERTICAL,15,5,0,260);
		sb3=new Scrollbar(Scrollbar.VERTICAL,50,5,0,260);
		r=sb1.getValue();	g=sb2.getValue();	b=sb3.getValue();
		sb1.addAdjustmentListener(this);
		sb2.addAdjustmentListener(this);
		sb3.addAdjustmentListener(this);

		p1.add(sb1);	p1.add(sb2);	p1.add(sb3);

		p2=new Panel();
		l1=new Label("Red");
		l2=new Label("Green");
		l3=new Label("Blue");
		t1=new TextField((sb1.getValue()+""),5);
		t2=new TextField((sb2.getValue()+""),5);
		t3=new TextField((sb3.getValue()+""),5);

		p2.add(l1);	p2.add(t1);	
		p2.add(l2);	p2.add(t2);	
		p2.add(l3);	p2.add(t3);
		p2.setBackground(new Color(255,255,255));
		
		f.add(p1,BorderLayout.EAST);
		f.add(p2,BorderLayout.SOUTH);
		f.setBackground(new Color(r,g,b));
		f.setVisible(true);
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		if(e.getSource()==sb1)
		{
			t1.setText(e.getValue()+"");
			r=e.getValue();
		}
		else if(e.getSource()==sb2)
		{
			t2.setText(e.getValue()+"");
			g=e.getValue();
		}
		else
		{
			t3.setText(e.getValue()+"");
			b=e.getValue();
		}
		f.setBackground(new Color(r,g,b));
	}

	public static void main(String args[])
	{
		ScrollColor obj=new ScrollColor();
	}
}
