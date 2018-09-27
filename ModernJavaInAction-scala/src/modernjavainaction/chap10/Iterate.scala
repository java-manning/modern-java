package modernjavainaction.chap10

object Iterate {

  def timesStandard(i: Int, f: => Unit): Unit = {
    f
    if (i > 1) timesStandard(i - 1, f)
  }

  def timesCurried(i: Int)(f: => Unit) : Unit = {
    f
    if (i > 1) timesCurried(i - 1)(f)
  }

  implicit def intToTimes(i: Int) = new {
    def times(f: => Unit): Unit = {
      def times(i: Int, f: => Unit): Unit = {
        f
        if (i > 1) times(i - 1, f)
      }
      times(i, f)
    }
  }

  /**
   * The method definition order is not important except for the implicit
   * definition added to the Int class (intToTimes above), which must appear
   * before its usage (below).
   */
  def main(args: Array[String]) = {
    println("The standard way:")
    timesStandard(3, println("Hello World"))

    println("The curried way:")
    timesCurried(3)(println("Hello World"))

    println("The infixed way:")
    3 times {
      println("Hello World")
    }
  }

}