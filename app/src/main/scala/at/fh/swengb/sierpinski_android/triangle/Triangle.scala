package at.fh.swengb.sierpinski_android.triangle

import android.graphics.Point

class Triangle(var Px: Int, var Py: Int, var length: Float, var counter: Int) {
  var height: Float = 0.0f
  this.height = (Math.sqrt(3) * (length / 2)).toFloat

}
