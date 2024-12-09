package controllers.EJ1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Ej1KtTest {

  @Test
  fun translacion1() {
   val expect = Punt(5f,5f)
   val puntoA = Punt(4f, 4f)
   val puntoB = Punt(1f,1f)
   translacion(puntoA, puntoB)
   assertTrue(sonIguales(expect,puntoA))
  }
  @Test
  fun translacion2() {
   val expect = Punt(275f,-275f)
   val puntoA = Punt(-25f, 25f)
   val puntoB = Punt(300f,-300f)
   translacion(puntoA, puntoB)
   assertTrue(sonIguales(expect,puntoA))
  }

  @Test
  fun escalar1() {
   val expect = Punt(16f,16f)
   val puntoA = Punt(4f, 4f)
   val escala = 4f
   escalar(puntoA, escala)
   assertTrue(sonIguales(expect,puntoA))
  }
  @Test
  fun escalar2() {
   val expect = Punt(-100f,100f)
   val puntoA = Punt(4f, -4f)
   val escala = -25f
   escalar(puntoA, escala)
   assertTrue(sonIguales(expect,puntoA))
  }
  @Test
  fun sonIguales1() {
   val puntoA = Punt(2f, 2f)
   val puntoB = Punt(2f, 2f)
   assertTrue(sonIguales(puntoA, puntoB))
  }
  @Test
  fun sonIguales2() {
   val puntoA = Punt(2f, 2f)
   val puntoB = Punt(2f, 3f)
   assertTrue(!sonIguales(puntoA, puntoB))
  }
}