package in.srain.cube.views.ptr.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.R;
import in.srain.cube.views.ptr.util.PtrCLog;

/**
 *
 */
public class ClassicFooter extends View implements FooterUIHandler{

    private static final String LOG_TAG = ClassicFooter.class.getSimpleName();
    private TextView title;

    public ClassicFooter(Context context, ViewGroup parent) {
        super(context);
        initView(context, parent);
    }


    private void initView(Context context, ViewGroup parent){
        inflate(context, R.layout.cube_ptr_classic_default_footer, parent);
        title = (TextView)findViewById(R.id.ptr_footer_title);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
        PtrCLog.e(LOG_TAG, "onUIReset");
        title.setText("查看更多");
    }

    @Override
    public void onUILoading(PtrFrameLayout frame) {
        PtrCLog.e(LOG_TAG, "onUILoading");
        title.setText("加载中...");
    }

    @Override
    public void onUILoadingFailed(PtrFrameLayout frame) {
        PtrCLog.e(LOG_TAG, "onUILoadingFailed");
        title.setText("加载失败");
    }

    @Override
    public void onUIEnd(PtrFrameLayout frame) {
        PtrCLog.e(LOG_TAG, "onUIEnd");
        title.setText("---End---");
    }
}
