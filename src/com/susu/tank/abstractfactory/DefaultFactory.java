package com.susu.tank.abstractfactory;

import com.susu.tank.Bullet;
import com.susu.tank.Dir;
import com.susu.tank.Explode;
import com.susu.tank.Group;
import com.susu.tank.Tank;
import com.susu.tank.TankFrame;

public class DefaultFactory extends GameFactory {

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {

		return new Tank(x, y, dir, group, tf);
	}

	@Override
	public BaseExplode createExplode(int x, int y, TankFrame tf) {

		return new Explode(x, y, tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {

		return new Bullet(x, y, dir, group, tf);
	}

}
