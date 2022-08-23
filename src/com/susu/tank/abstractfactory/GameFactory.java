package com.susu.tank.abstractfactory;

import com.susu.tank.Dir;
import com.susu.tank.Group;
import com.susu.tank.TankFrame;

public abstract class GameFactory {
	public abstract BaseTank createTank(int x,int y,Dir dir,Group group,TankFrame tf);
	public abstract BaseExplode createExplode(int x ,int y,TankFrame tf);
	public abstract BaseBullet createBullet(int x,int y,Dir dir,Group group,TankFrame tf);
}
