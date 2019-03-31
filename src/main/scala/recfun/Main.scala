package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if ( c>r )
        0
      if (c == r || c == 0)
        1
      else
        pascal(c - 1,r - 1) + pascal(c, r - 1)
    }
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(chars: List[Char], cpt: Int=0): Int ={
        if (cpt < 0)
          cpt
        else if (chars.isEmpty)
          cpt
        else if (chars.head =='(') loop(chars.tail, cpt+1)
        else if (chars.head ==')') loop(chars.tail, cpt-1)
        else loop(chars.tail, cpt)
      }
      if (loop(chars) == 0) true
      else  false
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def loop(money: Int, coins: List[Int]): Int= {
        if (money == 0)
          1
        else if (money < 0 || coins.isEmpty)
          0
        else
          loop(money, coins.tail)+ loop(money - coins.head,coins)
      }
      loop(money, coins)
    }
  }
