package com.susu.tank.abstractfactory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.susu.tank.Audio;
import com.susu.tank.Bullet;
import com.susu.tank.Dir;
import com.susu.tank.FireStrategy;
import com.susu.tank.Group;
import com.susu.tank.PropertyMgr;
import com.susu.tank.ResourceMgr;
import com.susu.tank.Tank;
import com.susu.tank.TankFrame;
import com.susu.tank.abstractfactory.BaseTank;

public class RectTank extends BaseTank{
	
	
	private static final int SPEED = 5;
	public static int WIDTH = ResourceMgr.goodTankU.getWidth();

	public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
	
	private Random random = new Random();
	
	public Rectangle rect = new Rectangle();
	
	 int x, y;

	 Dir dir = Dir.DOWN;

	private boolean moving = true;

	 TankFrame tf = null;
	
	private boolean living = true;
	
	 Group group = Group.BAD;
	 
	 FireStrategy fs;
	
	public RectTank(int x, int y, Dir dir, Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height= HEIGHT;
		
		if(group ==Group.GOOD){
			String goodFsName = (String)PropertyMgr.get("goodFs");
			try {
				fs = (FireStrategy)Class.forName(goodFsName).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			String badFsName = (String)PropertyMgr.get("badFs");
			
			try {
				fs = (FireStrategy)Class.forName(badFsName).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public void fire() {
		//fs.fire(this);
		
		int bX =this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y +Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		
		
		Dir[] dirs = Dir.values();
		for(Dir dir: dirs){
			tf.gf.createBullet(bX, bY, dir, group,tf);
		}
		
		//new Bullet(bX, bY, t.dir, t.group,t.tf);
		
		
		
		if(group == Group.GOOD){
			new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
		}

	}

	public Dir getDir() {
		return dir;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isMoving() {
		return moving;
	}

	private void move() {
		if (!moving)
			return;

		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
		
		
		
		if(this.group == Group.BAD && random.nextInt(100)>95) this.fire();
		
		if(this.group == Group.BAD && random.nextInt(100)>95)
		randomDir();
		
		boundsCheck();
		
		rect.x = this.x;
		rect.y = this.y;
		
	}

	private void boundsCheck() {
		if(this.x <0) x =0;
		if(this.y <30) y =30;
		if(this.x > TankFrame.GAME_WIDTH - RectTank.WIDTH -2) x =TankFrame.GAME_WIDTH - RectTank.WIDTH -2;
		if(this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT -2) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT -2;
		
	}
	private void randomDir() {
		
		this.dir = Dir.values()[random.nextInt(4)];
		
	}
	public void paint(Graphics g) {
		if(!living) tf.tanks.remove(this);
		
		 
		
		/*switch(dir){
		case LEFT:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
			break;
		case UP:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
			break;}*/
		
		Color c = g.getColor();
		g.setColor(group==Group.GOOD? Color.RED:Color.BLUE);
		g.fillRect(x, y, 40, 40);
		g.setColor(c);

		move();

	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void die() {
		
		this.living =false;
		
	}

}
