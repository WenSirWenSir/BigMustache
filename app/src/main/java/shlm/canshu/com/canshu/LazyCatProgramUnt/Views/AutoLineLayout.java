package shlm.canshu.com.canshu.LazyCatProgramUnt.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class AutoLineLayout extends ViewGroup {
    public AutoLineLayout(Context context) {
        super(context);
    }

    public AutoLineLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoLineLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        init();

    }

    private void init() {
        final int count = getChildCount();/*取得总数*/

        final int lineWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();/*总的宽度*/

        int paddingTop = getPaddingTop();/*距离头部*/
        int childTop = 0;
        int childLeft = getPaddingLeft();/*距离左边*/

        int availableLineWidh = lineWidth;/*保存宽度*/

        int maxLineHight = 0;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child == null) {
                continue;
            } else if (child.getVisibility() != GONE) {
                final int childWidth = child.getMeasuredWidth();/*获取子类的宽度*/
                final int childHeight = child.getMeasuredHeight();/*获取子类的高度*/

                if (availableLineWidh < childWidth) {
                    availableLineWidh = lineWidth;//太长了
                    paddingTop = paddingTop + maxLineHight;
                    childLeft = getPaddingLeft();
                    maxLineHight = 0;

                }
                childTop = paddingTop;
                setChildFrame(child, childLeft, childTop, childWidth, childHeight);
                childLeft += childWidth;
                availableLineWidh = availableLineWidh - childWidth;
                maxLineHight = Math.max(maxLineHight, childHeight);
            }
        }
    }

    private void setChildFrame(View child, int childLeft, int childTop, int childWidth, int
            childHeight) {
        child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }


        if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED) {
            final int width = MeasureSpec.getSize(widthMeasureSpec);
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(getDesireHeight(width),
                    MeasureSpec.EXACTLY));


        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private int getDesireHeight(int width) {
        final int lineWidth = width - getPaddingLeft() - getPaddingRight();
        int availableLineWidth = lineWidth;
        int totalHeight = getPaddingTop() + getPaddingBottom();
        int lineHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            final int childWidth = child.getMeasuredWidth();
            final int childHeight = child.getMeasuredHeight();
            if (availableLineWidth < childWidth) {
                availableLineWidth = lineWidth;
                totalHeight = totalHeight + lineHeight;
                lineHeight = 0;
            }
            availableLineWidth = availableLineWidth - childWidth;
            lineHeight = Math.max(childHeight, lineHeight);
        }
        totalHeight = totalHeight + lineHeight;
        return totalHeight;
    }
}
