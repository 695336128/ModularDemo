package zt.zhang.modulardemo

import org.junit.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        getTargetClass()
        getConstructor()
        getField()
        getMethod()
    }

    /**
     * 获取目标类型的'Class'对象的方式主要有四种
     */
    private fun getTargetClass(){
        // 方式1：Object.getClass
        val carson = true
        val classType: Class<*> = carson.javaClass
        println(classType)

        // 方式2：T.class 方法
        val classType2 = Boolean::class.java
        println(classType2)

        // 方法3：static method Class.forName
        val classType3 = Class.forName("java.lang.Boolean")
        println(classType3)

        // 方法4：TYPE 语法
        val classType4 = java.lang.Boolean.TYPE
        println(classType4)

        println(classType3 === classType4)
    }

    /**
     * 获取类的构造函数（传入构造函数的参数类型）
     */
    private fun getConstructor(){
        val userBean = UserBean()
        val classType: Class<*> = userBean.javaClass
        // a.获取指定的构造函数
        val constructor: Constructor<*> = classType.getConstructor()
        println(constructor)
        // b.获取所有的构造函数（公共/继承）
        val constructors: Array<Constructor<*>> = classType.constructors
        println(constructors[0])
        // c.获取指定的构造函数(不包括继承)
        val declaredConstructor: Constructor<*> = classType.getDeclaredConstructor()
        println(declaredConstructor)
        // d.获取所有的构造函数（不包括继承）
        val declaredConstructors: Array<Constructor<*>> = classType.declaredConstructors
        println(declaredConstructors[0])
    }

    /**
     * 获取类的属性
     */
    private fun getField(){
        val peopleBean = PeopleBean()
        val classType: Class<*> = peopleBean.javaClass

        // a.获取指定的属性(公共/继承)
        var field: Field = classType.getField("userName")
        println(field)
        // a.获取属性(公共/继承)
        val fields: Array<Field> = classType.fields
        for (f in fields){
            println(f)
        }
    }

    /**
     * 获取类的方法(传入方法名、参数类型)
     */
    private fun getMethod(){
        val peopleBean = PeopleBean()
        val classType: Class<*> = peopleBean.javaClass
        // a.获取指定的方法（公共/继承）
        val method: Method = classType.getMethod("getName",0.javaClass)
        println(method.returnType)
    }
}
