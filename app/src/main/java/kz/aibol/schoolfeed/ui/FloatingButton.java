package kz.aibol.schoolfeed.ui;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

/**
 * SchoolFeed
 * Created by Aibol Kussain on 5/27/2015.
 * For support information write kussain@aibol.kz
 */
public class FloatingButton extends FrameLayout {


    public FloatingButton(Context context) {
        this(context, null, 0, 0);
    }

    public FloatingButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 0);
    }

    public FloatingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public FloatingButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);

        setClickable(true);

        // Set the outline provider for this view. The provider is given the outline which it can
        // then modify as needed. In this case we set the outline to be an oval fitting the height
        // and width.
        setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, getWidth(), getHeight());
            }
        });

        // Finally, enable clipping to the outline, using the provider we set above
        setClipToOutline(true);
    }
}
