package at.fh.swengb.sierpinski_android.triangle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

class TriangleView(val context: Context) extends View(context) {
  private[triangle] val p: Paint = new Paint
  p.setStrokeWidth(3)


  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    val mainT: Triangle = new Triangle(0, 200, 1080, 0)
    val middleT: Triangle = new Triangle(((mainT.length / 4)).toInt, mainT.Py + ((mainT.height / 2)).toInt, (mainT.length / 2), mainT.counter + 1)

    canvas.drawLine(mainT.Px, mainT.Py, mainT.Px + mainT.length, mainT.Py, p)
    canvas.drawLine(mainT.Px, mainT.Py, mainT.Px + (mainT.length / 2), mainT.Py + mainT.height, p)
    canvas.drawLine(mainT.Px + mainT.length, mainT.Py, mainT.Px + (mainT.length / 2), mainT.Py + mainT.height, p)

    drawT(canvas, p, middleT)
    triangleRec(middleT, canvas, p)
  }

  def drawT(canvas: Canvas, p: Paint, triangle: Triangle) {
    canvas.drawLine(triangle.Px, triangle.Py, triangle.Px + triangle.length, triangle.Py, p)
    canvas.drawLine(triangle.Px, triangle.Py, triangle.Px + (triangle.length / 2), triangle.Py - triangle.height, p)
    canvas.drawLine(triangle.Px + triangle.length, triangle.Py, triangle.Px + (triangle.length / 2), triangle.Py - triangle.height, p)
  }

  def triangleRec(t: Triangle, canvas: Canvas, p: Paint) {
    val leftT: Triangle = new Triangle(t.Px - ((t.length / 4)).toInt, t.Py - ((t.height / 2)).toInt, (t.length / 2), t.counter + 1)
    val rightT: Triangle = new Triangle(t.Px + ((t.length / 4)).toInt * 3, t.Py - ((t.height / 2)).toInt, (t.length / 2), t.counter + 1)
    val bottomT: Triangle = new Triangle(t.Px + ((t.length / 4)).toInt, t.Py + ((t.height / 2)).toInt, (t.length / 2), t.counter + 1)

    drawT(canvas, p, leftT)
    drawT(canvas, p, rightT)
    drawT(canvas, p, bottomT)

    if (leftT.counter < 7) {
      triangleRec(leftT, canvas, p)
    }
    if (rightT.counter < 7) {
      triangleRec(rightT, canvas, p)
    }
    if (bottomT.counter < 7) {
      triangleRec(bottomT, canvas, p)
    }
  }
}
