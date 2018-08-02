package br.com.galaga.calculadoraslp4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        YoYo.with(Techniques.FadeOut).duration(1).playOn(imgAnimation)
    }

    fun anime(view: View){
        YoYo.with(Techniques.RollIn)
                .duration(1000)
                .repeat(2)
                .onEnd {
                    Picasso.get()
                            .load("https://www.sensacionalista.com.br/wp-content/uploads/2017/08/maxresdefault.jpg")
                            .into(imgAnimation)
                    YoYo.with(Techniques.Shake).duration(600).repeat(2).playOn(imgAnimation)
                    YoYo.with(Techniques.Landing).duration(600).repeat(2).playOn(imgAnimation)
                    YoYo.with(Techniques.Swing).duration(600).repeat(2).repeat(YoYo.INFINITE).playOn(imgAnimation)
                    YoYo.with(Techniques.Bounce).duration(600).repeat(YoYo.INFINITE).playOn(imgAnimation)
                }
                .playOn(txtAnimation)

    }

}
