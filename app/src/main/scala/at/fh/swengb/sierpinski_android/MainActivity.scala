package at.fh.swengb.sierpinski_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import at.fh.swengb.sierpinski_android.triangle.TriangleView

class MainActivity extends AppCompatActivity {
  private[sierpinski_android] var drawT: TriangleView = null

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    drawT = new TriangleView(this)
    setContentView(drawT)
  }
}
