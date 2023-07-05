package com.example.loginapp

class calculator {
}

fun main(){
    var a = 5
    var b = 6
    println(add(a,b))
    println(multiply(a,b))
    println(subtract(a,b))
    println(divide(a,b))
}


fun add( a:Int, b:Int): Int{
    return a+b
}
fun multiply( a:Int, b:Int): Int{
    return a*b
}
fun divide( a:Int, b:Int): Int{
    if(b==0)
    { println("undifined")
        return -1
    }
    else
        return a/b
}
fun subtract( a:Int, b:Int): Int{
    return a-b
}