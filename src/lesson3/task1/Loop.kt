@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1
import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var result=1
    var number= abs(n)
    if (number==0){
        return 1
    }
    while (number>0){
        if ((number-number%10)/10 !=0) {
            result++
        }
        number/=10
    }
    return result
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var result=0
    var fibn1=1
    var fibn2=1
    var number=n
    if ((n==1)||(n==2)){
        return 1
    }
    while (number>2){
        fibn2=fibn1+fibn2
        result=fibn2
        number=number-1
        if (number>2) {
            fibn1 = fibn2 + fibn1
            result = fibn1
            number = number - 1
        }
    }
    return result
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int{
    var result=1
    if (max(m,n)% min(m,n)==0){
        return max(m,n)
    }
    for (i in 1..min(m,n)){
        if ((m%i==0)&&(n%i==0))
            result = i
    }
    return m*n/result
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var result=1
    for (i in n downTo 2) {
        if (n % i == 0){
            result=i
        }
    }
    return result
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var result=1
    for (i in 1..n/2 ) {
        if (n % i == 0){
            result=i
        }
    }
       return result
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val a = min(m, n)/2
    var result=true
    if ((n==1)||(m==1)) return true
    if ((m % n == 0) || (n % m == 0)){
        return false
    }
    for (i in 2..a){
        if ((m%i==0)&&(n%i==0)){
            result=false
        }
    }
     return result
    }

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var result = true
    var k: Double
    val m1 = sqrt(max(m, n).toDouble()).toInt()
    val n1 = sqrt(min(m, n).toDouble()).toInt()
    for (i in n1..m1) {
        k = i.toDouble()
        result = ((sqr(k) >= min(m, n)) && (sqr(k) <= max(m, n)))
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()
    /*fun factorial(n: Int):Int{
        var result=1
        for (i in 1..n){
            result=result*i
        }
        return result
    }
    var sinx=0.0
    var i=0.0
    var a=0.0
    while (a<eps){
        a=pow(-1.0,i)*pow(x,2.0*i+1.0)/(factorial((2*i+1).toInt()))
        sinx+=a
        i++
    }
    return sinx
}*/

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var x= digitNumber(n).toDouble()
    var number=n
    var result=0.0
    while (number>0){
        result=result+(number%10)* pow(10.0,x-1)
        x-=1
        number/=10
    }
    return result.toInt()
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var x= digitNumber(n).toDouble()
    var result=true
    if ((n>=0)&&(n<=9)) return true
    var number=n
    while (number>9){
        result=((number%10).toDouble()==(number% pow(10.0,x)-number% pow(10.0,x-1))/
                pow(10.0,x-1))
        number=number% pow(10.0,x-1).toInt()
        number/=10
        x-=2
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()
    /*var result=true
    var number=n
    if (n==0) return false
    else {while (number>0){
        if (number%10!=n%10) result=true
        else result=false
        number/=10
    }
        return result
}}*/

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var result=1.0
    var x=1.0
    var number=n.toDouble()
    while (number>0){
        if ((number- digitNumber(sqr(x).toInt()))<=0)
            result=((sqr(x)% pow(10.0, digitNumber(sqr(x).toInt())-number+1)
                    -sqr(x)% pow(10.0, digitNumber(sqr(x).toInt())-number))/
                    pow(10.0, digitNumber(sqr(x).toInt())-number))
        number=number- digitNumber(sqr(x).toInt())
        x++
    }
    return result.toInt()
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var result=1.0
    var x=1
    var number=n.toDouble()
    while (number>0) {
        if ((number- digitNumber(fib(x)))<=0)
        result=(fib(x)% pow(10.0, digitNumber(fib(x))-number+1)
                -fib(x)% pow(10.0, digitNumber(fib(x))-number))/
                pow(10.0, digitNumber(fib(x))-number)
        number=number- digitNumber(fib(x))
        x++}
    return result.toInt()
}
