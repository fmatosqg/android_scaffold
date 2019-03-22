package net.amazingdomain.sample.myapplication.ui.common.component

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*
import net.amazingdomain.sample.myapplication.R
import net.amazingdomain.sample.myapplication.ui.common.helper.dpToPx
import net.amazingdomain.sample.myapplication.ui.common.helper.spToPx


class GlowingButton @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private var viewWidth = 0
    private var viewHeight = 0

    private val glowPaint: Paint

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        glowPaint = Paint().apply {
            color = resources.getColor(R.color.white)
        }
    }

    private var animatedFactor: Float = 1.0f
        private set(value) {

            field =
                    when {
                        value > 1.0f -> 1.0f
                        value < 0.01f -> 0.01f
                        else -> value
                    }
            updateMask()
        }


    private val mainPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 2.dpToPx().toFloat()
        color = resources.getColor(R.color.someGrey)

        textSize = 16.spToPx()

    }

    override fun onSizeChanged(xNew: Int, yNew: Int, xOld: Int, yOld: Int) {
        super.onSizeChanged(xNew, yNew, xOld, yOld)

        viewWidth = xNew
        viewHeight = yNew

        updateMask()
    }


    private fun updateMask() {
        val glowRadius = paddingTop.toFloat() * .7f * animatedFactor  // TODO: it's the min among all 4 paddings, with a 70% factor determined experimentally

        glowPaint.maskFilter = BlurMaskFilter(glowRadius, BlurMaskFilter.Blur.OUTER)

        invalidate()
    }

    override fun animate(): ViewPropertyAnimator {
        ObjectAnimator
                .ofFloat(this, "animatedFactor", 0f, 1f)

                .apply {
                    repeatCount = ValueAnimator.INFINITE
                    repeatMode = ValueAnimator.REVERSE
                    duration = 1000
                    interpolator = OvershootInterpolator()
                    start()
                }

        return super.animate() // TODO fix this antipattern
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val rect = RectF(paddingLeft.toFloat(),
                paddingTop.toFloat(),
                (viewWidth - paddingRight).toFloat(),
                (viewHeight - paddingBottom).toFloat())

        val radius = (rect.bottom - rect.top) / 2

        canvas?.apply {
            drawRoundRect(rect, radius, radius, mainPaint)
            drawRoundRect(rect, radius, radius, glowPaint)

//            drawText("test", viewWidth / 2f, (viewHeight + 16.spToPx()) / 2f, mainPaint)
        }
    }
}

