package com.baharlou.customviews.customs

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.baharlou.customviews.R

/***
 * CREATED BY MONA BAHARLOU
 */

class IconicTextView(
    context: Context,
    attrs: AttributeSet?
) :
    RelativeLayout(context, attrs) {
    var iconText: TextView
    var iconPic: ImageView

    var text: String?
        get() = iconText.text.toString()
        set(value) {
            iconText.text = value
        }

    fun setIcon(url: String?) {
        //iconPic.setImageResource(url!!)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.icon_text_view, this, true)

        iconText = findViewById(R.id.iconicText)
        iconPic = findViewById(R.id.iconicPic)
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.iconicTextView)
        val drawable = typedArray.getDrawable(R.styleable.iconicTextView_c_icon)
        val color = typedArray.getColor(
            R.styleable.iconicTextView_c_color,
            resources.getColor(R.color.colorAccent)
        )

        if (drawable != null) {
            iconPic.background = drawable
        }

        val textValue = typedArray.getString(
            R.styleable.iconicTextView_c_value
        )
        if (textValue != null) {
            iconText.text = textValue
        }


        if (color != null) {
            iconText.setTextColor(color)
        }
        /* var typeFaceNumber = 1
         if (typedArray.hasValue(R.styleable.iconicTextView_c_font)) {
             typeFaceNumber = typedArray.getInt(R.styleable.iconicTextView_c_font, 1)
         }
         val yekan = Typeface.createFromAsset(
             context.assets, AppConst().YEKAN_FONT
         )

         if (typeFaceNumber == 1) iconText.setTypeface(yekan)*/

        // if (typeFaceNumber == 1) iconText.setTypeface(font_2)

    }
}