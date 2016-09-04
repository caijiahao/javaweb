package com.pojo;

public class Computer {
  private Chassis chassis = null;
  private Keyboard keyboard = null;
  private Monitor monitor = null;
public Chassis getChassis() {
	return chassis;
}
public void setChassis(Chassis chassis) {
	this.chassis = chassis;
}
public Keyboard getKeyboard() {
	return keyboard;
}
public void setKeyboard(Keyboard keyboard) {
	this.keyboard = keyboard;
}
public Monitor getMonitor() {
	return monitor;
}
public void setMonitor(Monitor monitor) {
	this.monitor = monitor;
}

public void show(){
	chassis.show();
	monitor.show();
	keyboard.show();
}
}
