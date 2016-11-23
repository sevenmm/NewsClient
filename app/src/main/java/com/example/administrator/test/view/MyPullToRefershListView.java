//package com.example.administrator.test.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.ListView;
//
//import com.example.administrator.test.R;
//import com.example.administrator.test.utils.Utils;
//
///**
// * Created by 007 on 2016/11/22.
// */
//
//public class MyPullToRefreshListView extends ListView {
//
//    private int downY;
//    private int moveY;
//    private View mHeadView;
//    private int headViewHeight;
//    private final int PULL_DOWN000 = 0;//下拉刷新
//    private final int RELEASE_REFERSH000 = 1;//释放刷新
//    private final int REFERSH000 = 2;//正在刷新中
//    private int currentState000= PULL_DOWN;
//
//    public MyPullToRefreshListView(Context context) {
//        super(context);
//        initHeadView();
//    }
//
//    public MyPullToRefreshListView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        initHeadView();
//    }
//
//    public MyPullToRefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initHeadView();
//    }
//
//    public void initHeadView() {
//        mHeadView = View.inflate(getContext(), R.layout.headview_refersh_listview, null);
//        this.addHeaderView(mHeadView);
//        mHeadView.measure(0, 0);
//        //测量之后，即可获取高度
//        headViewHeight = mHeadView.getMeasuredHeight();
//        //屏幕显示过之后，才可以获取高度
////        mHeadView.getHeight();
//        mHeadView.setPadding(0, -headViewHeight, 0, 0);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                downY = (int) ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                moveY = (int) ev.getY();
//                //计算出拖拽的距离
//                int diffY = moveY - downY;
//                if (diffY > 0 && getFirstVisiblePosition() == 0) {
//                    int paddingTop = -headViewHeight + diffY;
//
//                    if (paddingTop > 0 && currentState != RELEASE_REFERSH) {
//                        Log.e("007", "头布局完全显示，进入释放刷新......");
//                        Utils.MyToast(getContext(),"头布局完全显示...");
//                        currentState = RELEASE_REFERSH
//
//                    } else if (paddingTop < 0 && currentState != PULL_DOWN) {
//                        Log.e("007", "头布局没有完全显示，进入下拉刷新......");
//                        Utils.MyToast(getContext(),"没有完全显示");
//                        currentState = PULL_DOWN;
//                    }
//
//
//                    mHeadView.setPadding(0, paddingTop, 0, 0);
//                    return true;
//
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                if(currentState == PULL_DOWN) {
//                    // 当前是下拉刷新状态, 把头布局隐藏
//                    mHeadView.setPadding(0, -headViewHeight, 0, 0);
//                } else if(currentState == RELEASE_REFERSH) {
//                    // 当前是释放刷新状态, 应该进入到正在刷新中状态
//                    currentState = REFERSH;
////                    refreshHeaderViewState();
////                    mHeaderView.setPadding(0, 0, 0, 0);
////
////                    // 调用用户下拉刷新的回调方法
////                    if(mOnRefreshListener != null) {
////                        mOnRefreshListener.onPullDownRefresh();
////                    }
//                }
//                break;
//        }
//
//
//        return super.onTouchEvent(ev);
//    }
//}
