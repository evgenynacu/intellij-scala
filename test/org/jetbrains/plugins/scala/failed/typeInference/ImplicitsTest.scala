package org.jetbrains.plugins.scala.failed.typeInference

import org.jetbrains.plugins.scala.PerfCycleTests
import org.jetbrains.plugins.scala.lang.typeInference.TypeInferenceTestBase
import org.junit.experimental.categories.Category

/**
  * @author Alefas
  * @since 21/03/16
  */

@Category(Array(classOf[PerfCycleTests]))
class ImplicitsTest extends TypeInferenceTestBase {
  override def folderPath: String = super.folderPath + "bugs5/"

  def testSCL7955(): Unit = doTest()

  def testSCL8242(): Unit = doTest()

  def testSCL9076(): Unit = doTest()

  def testSCL9525(): Unit = doTest()

  def testSCL9961(): Unit = doTest()

  def testSCL3987(): Unit = doTest()
  
  def testSCL7605(): Unit = doTest()

  def testSCL8831(): Unit = doTest()
  
  def testSCL7474(): Unit = doTest(
    """
      | object Repro {
      |
      |   import scala.collection.generic.IsTraversableLike
      |
      |   def head[A](a: A)(implicit itl: IsTraversableLike[A]): itl.A = itl.conversion(a).head
      |
      |   val one: Int = /*start*/head(Vector(1, 2, 3))/*end*/
      | }
      |
      | //Int""".stripMargin
  )

  def testSCL9302(): Unit = doTest {
    """
      |object SCL9302 {
      |
      |  class User
      |
      |  implicit class RichUser(user: User) {
      |    def hello(): Int = 1
      |  }
      |
      |  val user = new User
      |  user.hello()
      |
      |  trait UserTrait {
      |    this: User =>
      |
      |    /*start*/this.hello()/*end*/
      |  }
      |}
      |//Int
    """.stripMargin.trim
  }

  def testSCL7809(): Unit = doTest {
    """
      |class SCL7809 {
      |  implicit def longToString(s: Long): String = s.toString
      |  def useString(s: String) = s
      |  def useString(d: Boolean) = d
      |  /*start*/useString(1)/*end*/
      |}
      |//String
    """.stripMargin.trim
  }
}