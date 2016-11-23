package com.example.administrator.test.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.test.R;


/**
 * @author andong
 * 可以下拉刷新和加载更多的ListView
 */
public class RefreshListView extends ListView {

	private int downY; // 按下时y轴的偏移量
	private int mHeaderViewHeight; // 头布局的高度
	private View mHeaderView; // 头布局的view对象
	private final int PULL_DOWN = 0; // 下拉刷新
	private final int RELEASE_REFRESH = 1; // 释放刷新
	private final int REFRESHING = 2; // 正在刷新中

	private int currentState = PULL_DOWN; // 头布局当前的状态, 默认为: 下拉刷新
	private TextView tvState; // 头布局的状态
	private TextView tvLastUpdateTime; // 头布局的最后刷新时间
	private OnRefreshListener onRefreshListener; //用户刷新回调事件



	public RefreshListView(Context context) {
		super(context);
		initHeaderView();
	}

	public RefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initHeaderView();
	}

	public RefreshListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initHeaderView();
	}

	/**
	 * 初始化头布局
	 */
	private void initHeaderView() {
		mHeaderView = View.inflate(getContext(), R.layout.headview_refersh_listview, null);
		tvState = (TextView) mHeaderView.findViewById(R.id.tv_headview_refersh);
		tvLastUpdateTime = (TextView) mHeaderView.findViewById(R.id.tv_headview_time);


		tvLastUpdateTime.setText("最后刷新时间: " + getCurrentTime());

//		mHeaderView.getHeight(); // 只有在当前控件已经在屏幕上显示过之后才可以得到高度.
		// 先测量头布局.
		mHeaderView.measure(0, 0);
		mHeaderViewHeight = mHeaderView.getMeasuredHeight();
		System.out.println("头布局的高度: " + mHeaderViewHeight);

		mHeaderView.setPadding(0, -mHeaderViewHeight, 0, 0);
		this.addHeaderView(mHeaderView);

	}



	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				downY = (int) ev.getY();
				break;
			case MotionEvent.ACTION_MOVE:
				// 如果当前的事件是正在刷新中, 不进行下拉头布局的操作, 而且响应父类ListView的touch事件
				if(currentState == REFRESHING) {
					break;
				}

				int moveY = (int) ev.getY();

				// 计算出拖动的间距
				int diffY = moveY - downY;

				// 如果移动的间距 > 0, 向下拖拽, 并且ListView最顶部显示的条目的索引为0, 才可以执行下拉头的操作.
				if(diffY > 0 && getFirstVisiblePosition() == 0) {
					// 执行下拉头布局的操作
					int paddingTop = -mHeaderViewHeight + diffY / 2;

					if(paddingTop > 0 && currentState != RELEASE_REFRESH) {
						System.out.println("当前头布局已经完全显示了, 进入到释放刷新状态");
						currentState = RELEASE_REFRESH;
						refreshHeaderViewState();
					} else if(paddingTop < 0 && currentState != PULL_DOWN) {
						System.out.println("当前头布局没有完全显示, 进入到下拉刷新状态");
						currentState = PULL_DOWN;
						refreshHeaderViewState();
					}

					mHeaderView.setPadding(0, paddingTop, 0, 0);
					return true; // 处理当前事件, 不让父类ListView响应事件
				}
				break;
			case MotionEvent.ACTION_UP:
				if(currentState == PULL_DOWN) {
					// 当前是下拉刷新状态, 把头布局隐藏
					mHeaderView.setPadding(0, -mHeaderViewHeight, 0, 0);
				} else if(currentState == RELEASE_REFRESH) {
					// 当前是释放刷新状态, 应该进入到正在刷新中状态
					currentState = REFRESHING;
					refreshHeaderViewState();
					mHeaderView.setPadding(0, 0, 0, 0);

					if (onRefreshListener != null) {
						onRefreshListener.onPullToRefresh();
					}
				}
				break;
			default:
				break;
		}
		return super.onTouchEvent(ev);
	}

	/**
	 * 根据currentState来刷新头布局的状态
	 */
	private void refreshHeaderViewState() {
		switch (currentState) {
			case PULL_DOWN:
				tvState.setText("下拉刷新");
				break;
			case RELEASE_REFRESH:
				tvState.setText("释放刷新");
				break;
			case REFRESHING:
				tvState.setText("正在刷新中..");
				break;
			default:
				break;
		}
	}

	/**
	 * 刷新完成时，调用此方法，隐藏头布局
	 */
	public void onRefreshFinish() {
		// 当前是下拉刷新, 隐藏头布局
		mHeaderView.setPadding(0, -mHeaderViewHeight, 0, 0);
		currentState = PULL_DOWN;
		tvState.setText("下拉刷新");
		tvLastUpdateTime.setText("最后刷新时间: " + getCurrentTime());
	}


	public void setOnRefreshListener(OnRefreshListener listener) {
		this.onRefreshListener = listener;
	}

	//定义回调
	public interface OnRefreshListener {
		/**
		 * 下拉刷新是调用此方法
		 */
		public void onPullToRefresh();
	}


	/**
	 * 获取当前时间, 格式为: 1990-09-09 09:09:09
	 * @return
	 */
	private String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}
