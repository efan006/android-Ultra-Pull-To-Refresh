package in.srain.cube.views.ptr.footer;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.srain.cube.views.ptr.util.PtrCLog;

/**
 * Created by efan on 15-6-11.
 */
public class LoadMoreDecoration extends RecyclerView.ItemDecoration {

    private View loadMoreView;
    private int height;

    public LoadMoreDecoration(View loadMoreView, int height){
        this.loadMoreView = loadMoreView;
        this.height = height;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int lastPos = parent.getAdapter().getItemCount() - 1;
        RecyclerView.ViewHolder holder = parent.findViewHolderForPosition(lastPos);
        View child = null;
        if (holder != null){
            child = holder.itemView;
        }
        if (child != null){
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams)child.getLayoutParams();
            int top = child.getBottom() + lp.bottomMargin;
            c.save();
            PtrCLog.e("xxx", "top>>" + top);
            c.translate(0, top);
//            ViewGroup.LayoutParams moreLp = loadMoreView.getLayoutParams();
//            if (moreLp == null){
//                moreLp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                loadMoreView.setLayoutParams(moreLp);
//            }
            int widthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            loadMoreView.measure(widthSpec, heightSpec);
            loadMoreView.layout(0, 0, loadMoreView.getMeasuredWidth(), loadMoreView.getMeasuredHeight());
            loadMoreView.draw(c);
            c.restore();
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildPosition(view);
        int childCount = parent.getAdapter().getItemCount();
        if (position == childCount -1){
            outRect.set(0, 0, 0, height);
        }
    }
}
