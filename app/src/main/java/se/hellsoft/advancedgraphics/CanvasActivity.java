package se.hellsoft.advancedgraphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        Bitmap bitmap = Bitmap.createBitmap(640, 480, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.WHITE);
        doPainting(bitmap);
        ((ImageView) findViewById(R.id.imageView)).setImageBitmap(bitmap);
    }

    private void doPainting(Bitmap bitmap) {
        // Draw a smiley in the middle of the bitmap
    }
}
