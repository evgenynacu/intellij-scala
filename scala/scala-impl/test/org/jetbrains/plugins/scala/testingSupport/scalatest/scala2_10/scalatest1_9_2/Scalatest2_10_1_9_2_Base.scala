package org.jetbrains.plugins.scala.testingSupport.scalatest.scala2_10.scalatest1_9_2

import org.jetbrains.plugins.scala.base.libraryLoaders.{ScalaTestLoader, ThirdPartyLibraryLoader}
import org.jetbrains.plugins.scala.debugger.{ScalaVersion, Scala_2_10}
import org.jetbrains.plugins.scala.testingSupport.scalatest.ScalaTestTestCase

/**
  * @author Roman.Shein
  * @since 11.02.2015.
  */
abstract class Scalatest2_10_1_9_2_Base extends ScalaTestTestCase {

  override implicit val version: ScalaVersion = Scala_2_10

  override protected def additionalLibraries: Seq[ThirdPartyLibraryLoader] = {
    Seq(ScalaTestLoader("1.9.2"))
  }
}
