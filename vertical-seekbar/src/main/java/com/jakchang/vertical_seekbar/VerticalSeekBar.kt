package com.jakchang.vertical_seekbar

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ScaleDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.SeekBar

@SuppressLint("AppCompatCustomView")
class VerticalSeekBar : SeekBar {

    private var seekBarColor: Int = -1
    private var progressColor: Int = -1
    private var bottomLeftRadius = 0f
    private var topLeftRadius = 0f
    private var bottomRightRadius = 0f
    private var topRightRadius = 0f
    private var radius = 0f
    private var degree=0f

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        attrs?.apply {
            val typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.VerticalSeekBarStyle, 0, 0)

            seekBarColor = typedArray.getResourceId(R.styleable.VerticalSeekBarStyle_seekBarColor, -1)
            progressColor = typedArray.getResourceId(R.styleable.VerticalSeekBarStyle_progressColor,-1)
            radius = typedArray.getFloat(R.styleable.VerticalSeekBarStyle_radius,0f)
            degree = typedArray.getFloat(R.styleable.VerticalSeekBarStyle_degree,0f)
           setRadius(typedArray, radius)
            typedArray.recycle()
        }


        if(seekBarColor != -1 && progressColor != -1){
            setProgressBarDrawable()
        }
        this.splitTrack = false
    }

    private fun setRadius(typedArray: TypedArray, radius : Float){
        if(radius == 0f){
            bottomLeftRadius = typedArray.getFloat(R.styleable.VerticalSeekBarStyle_bottomLeftRadius,0f)
            topLeftRadius = typedArray.getFloat(R.styleable.VerticalSeekBarStyle_topLeftRadius,0f)
            bottomRightRadius = typedArray.getFloat(R.styleable.VerticalSeekBarStyle_bottomRightRadius,0f)
            topRightRadius = typedArray.getFloat(R.styleable.VerticalSeekBarStyle_topRightRadius,0f)
        }else{
            bottomLeftRadius = radius
            topLeftRadius = radius
            bottomRightRadius = radius
            topRightRadius = radius
        }
    }

    private fun setProgressBarDrawable(){
        val seekBarBackground = GradientDrawable()
        seekBarBackground.cornerRadii = floatArrayOf(bottomLeftRadius, bottomLeftRadius,  //bottom-left, top-left, top-right, bottom-right
            topLeftRadius, topLeftRadius, bottomRightRadius, bottomRightRadius, topRightRadius, topRightRadius)
        seekBarBackground.setColor(context.getColor(seekBarColor))

        val scaleDrawable =  GradientDrawable()
        scaleDrawable.cornerRadii = floatArrayOf(bottomLeftRadius, bottomLeftRadius,  //bottom-left, top-left, top-right, bottom-right
            topLeftRadius, topLeftRadius, bottomRightRadius, bottomRightRadius, topRightRadius, topRightRadius)
        scaleDrawable.setColor(context.getColor(R.color.colorGreen))
        val seekBarProgress = ScaleDrawable(scaleDrawable, Gravity.START,1f,0.1f)
        val drawableList = arrayOf(seekBarBackground, seekBarProgress)
        val layerList : LayerDrawable = LayerDrawable(drawableList)
        layerList.setId(0, android.R.id.background)
        layerList.setId(1, android.R.id.progress)
        this.progressDrawable = layerList
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(h, w, oldh, oldw)
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    override fun onDraw(c: Canvas) {
        c.rotate(270f)
        c.translate(-height.toFloat(), 0f)
        super.onDraw(c)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!isEnabled) {
            return false
        }
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                val i = max - (max * event.y / height).toInt()
                progress = i
                onSizeChanged(width, height, 0, 0)
            }
            MotionEvent.ACTION_CANCEL -> {
            }
        }
        return true
    }

    override fun setProgress(progress: Int) {
        super.setProgress(progress)
        onSizeChanged(width, height, 0, 0)
    }
}
