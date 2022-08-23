package com.susu.tank.abstractfactory;

import java.awt.Color;
import java.awt.Graphics;


import com.susu.tank.Audio;
import com.susu.tank.ResourceMgr;
import com.susu.tank.TankFrame;

public class RectExplode extends BaseExplode{
	
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int x,y;
	
	//private boolean living = true;
	
	TankFrame tf = null;
	private int step =0;
	
	public RectExplode(int x, int y, TankFrame tf){
		
		this.x=x;
		this.y=y;
		this.tf=tf;
		
		new Thread(() -> new Audio("audio/explode.wav").play()).start();
		
		//new Audio("audio/explode.wav").loop();;
	}
	@Override
	public void paint(Graphics g){
		
		//g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.fillRect(x, y, 10*step, 10*step);
		step++;
		
		if(step >= 10){ 
			
			tf.explodes.remove(this);
		}
		
		}

	

}
