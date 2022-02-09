package com.polaris.common.demo.designModel.DecotratorDesign;

/**
 * 装饰器模式
 * 装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 * 意图：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 * <p>
 * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
 * <p>
 * 何时使用：在不想增加很多子类的情况下扩展类。
 * <p>
 * 如何解决：将具体功能职责划分，同时继承装饰者模式。
 * <p>
 * 关键代码： 1、Component 类充当抽象角色，不应该具体实现。 2、修饰类引用和继承 Component 类，具体扩展类重写父类方法。
 */
public class DecotratorDemo {
    public static void main(String[] args) {
        DecotratorShape shape = new DecotratorRectangle();
        shape.draw();

        DecotratorShape redShape = new RedDecotrator(new DecotratorRectangle());
        redShape.draw();

        redShape = new RedDecotrator(new DecotratorCircle());
        redShape.draw();
    }
}
