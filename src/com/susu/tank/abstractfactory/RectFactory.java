package com.susu.tank.abstractfactory;

import com.susu.tank.Dir;
import com.susu.tank.Group;
import com.susu.tank.TankFrame;

public class RectFactory extends GameFactory{

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		
		return new RectTank(x,y,dir,group,tf);
	}

	@Override
	public BaseExplode createExplode(int x, int y, TankFrame tf) {
		
		return new RectExplode(x, y, tf);
	}

	
	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		// TODO Auto-generated method stub
		return new RectBullet(x, y, dir, group, tf);
	}

}
