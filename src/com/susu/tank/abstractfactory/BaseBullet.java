package com.susu.tank.abstractfactory;

import java.awt.Graphics;

import com.susu.tank.Tank;

public abstract class BaseBullet {

	public abstract void paint(Graphics g);

	public abstract void collideWith(BaseTank tank);

}
