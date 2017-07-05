package com.willard.pattern.factory;

/** 
* @ClassName: ShapeFactory 
* @Description:工厂模式，用于生产给定类型的实例对象
* @author willard
* @date 2017年6月14日 下午2:09:12 
*  
*/
public class ShapeFactory {
	public Shape getShape(String shape){
		switch (shape) {
		case "circle":
			return new Circle();
		case "rectangle":
			return new Rectangle();
		case "square":
			return new Square();
		}
		return null;
	}
}
