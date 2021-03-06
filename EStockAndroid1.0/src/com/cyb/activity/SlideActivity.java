package com.cyb.activity;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.cyb.gwjl.R;

public class SlideActivity extends Activity {

	@Override
	public void addContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		super.addContentView(view, params);
		System.out.println("addContentView....");
	}

	@Override
	public void closeContextMenu() {
		// TODO Auto-generated method stub
		super.closeContextMenu();
		System.out.println("closeContextMenu....");
	}

	@Override
	public void closeOptionsMenu() {
		// TODO Auto-generated method stub
		super.closeOptionsMenu();
		System.out.println("closeOptionsMenu....");
	}

	@Override
	public PendingIntent createPendingResult(int requestCode, Intent data,
			int flags) {
		// TODO Auto-generated method stub
		System.out.println("createPendingResult....");
		return super.createPendingResult(requestCode, data, flags);
		
	}

	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		System.out.println("dispatchGenericMotionEvent....");
		return super.dispatchGenericMotionEvent(ev);
		
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		System.out.println("dispatchKeyEvent...");
		return super.dispatchKeyEvent(event);
	}

	@Override
	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		System.out.println("dispatchKeyShortcutEvent...");
		return super.dispatchKeyShortcutEvent(event);
	}

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		System.out.println("dispatchPopulateAccessibilityEvent...");
		return super.dispatchPopulateAccessibilityEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		System.out.println("dispatchTouchEvent....");
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		System.out.println("dispatchTrackballEvent...");
		return super.dispatchTrackballEvent(ev);
	}

	@Override
	public void dump(String prefix, FileDescriptor fd, PrintWriter writer,
			String[] args) {
		// TODO Auto-generated method stub
		System.out.println("dump....");
		super.dump(prefix, fd, writer, args);
	}

	@Override
	public View findViewById(int id) {
		// TODO Auto-generated method stub
		System.out.println("findViewById...");
		return super.findViewById(id);
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		System.out.println("finish....");
	}

	@Override
	public void finishActivity(int requestCode) {
		// TODO Auto-generated method stub
		super.finishActivity(requestCode);
		System.out.println("finishActivity...");
	}

	@Override
	public void finishActivityFromChild(Activity child, int requestCode) {
		// TODO Auto-generated method stub
		super.finishActivityFromChild(child, requestCode);
		System.out.println("finishActivityFromChild...");
	}

	@Override
	public void finishAffinity() {
		// TODO Auto-generated method stub
		System.out.println("finishAffinity....");
		super.finishAffinity();
	}

	@Override
	public void finishFromChild(Activity child) {
		// TODO Auto-generated method stub
		super.finishFromChild(child);
		System.out.println("finishFromChild");
	}

	@Override
	public ActionBar getActionBar() {
		System.out.println("getActionBar...");
		// TODO Auto-generated method stub
		return super.getActionBar();
	}

	@Override
	public ComponentName getCallingActivity() {
		// TODO Auto-generated method stub
		System.out.println("getCallingActivity...");
		return super.getCallingActivity();
	}

	@Override
	public String getCallingPackage() {
		// TODO Auto-generated method stub
		System.out.println("getCallingPackage...");
		return super.getCallingPackage();
	}

	@Override
	public int getChangingConfigurations() {
		System.out.println("getChangingConfigurations...");
		// TODO Auto-generated method stub
		return super.getChangingConfigurations();
	}

	@Override
	public ComponentName getComponentName() {
		// TODO Auto-generated method stub
		System.out.println("getComponentName....");
		return super.getComponentName();
	}

	@Override
	public View getCurrentFocus() {
		// TODO Auto-generated method stub
		System.out.println("getCurrentFocus...");
		return super.getCurrentFocus();
	}

	@Override
	public FragmentManager getFragmentManager() {
		// TODO Auto-generated method stub
		return super.getFragmentManager();
	}

	@Override
	public Intent getIntent() {
		// TODO Auto-generated method stub
		return super.getIntent();
	}

	@Override
	public Object getLastNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return super.getLastNonConfigurationInstance();
	}

	@Override
	public LayoutInflater getLayoutInflater() {
		// TODO Auto-generated method stub
		return super.getLayoutInflater();
	}

	@Override
	public LoaderManager getLoaderManager() {
		// TODO Auto-generated method stub
		return super.getLoaderManager();
	}

	@Override
	public String getLocalClassName() {
		// TODO Auto-generated method stub
		return super.getLocalClassName();
	}

	@Override
	public MenuInflater getMenuInflater() {
		// TODO Auto-generated method stub
		return super.getMenuInflater();
	}

	@Override
	public Intent getParentActivityIntent() {
		// TODO Auto-generated method stub
		return super.getParentActivityIntent();
	}

	@Override
	public SharedPreferences getPreferences(int mode) {
		// TODO Auto-generated method stub
		return super.getPreferences(mode);
	}

	@Override
	public int getRequestedOrientation() {
		// TODO Auto-generated method stub
		return super.getRequestedOrientation();
	}

	@Override
	public Object getSystemService(String name) {
		// TODO Auto-generated method stub
		return super.getSystemService(name);
	}

	@Override
	public int getTaskId() {
		// TODO Auto-generated method stub
		return super.getTaskId();
	}

	@Override
	public Window getWindow() {
		// TODO Auto-generated method stub
		return super.getWindow();
	}

	@Override
	public WindowManager getWindowManager() {
		// TODO Auto-generated method stub
		return super.getWindowManager();
	}

	@Override
	public boolean hasWindowFocus() {
		// TODO Auto-generated method stub
		return super.hasWindowFocus();
	}

	@Override
	public void invalidateOptionsMenu() {
		// TODO Auto-generated method stub
		super.invalidateOptionsMenu();
	}

	@Override
	public boolean isChangingConfigurations() {
		// TODO Auto-generated method stub
		return super.isChangingConfigurations();
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return super.isDestroyed();
	}

	@Override
	public boolean isFinishing() {
		// TODO Auto-generated method stub
		return super.isFinishing();
	}

	@Override
	public boolean isTaskRoot() {
		// TODO Auto-generated method stub
		return super.isTaskRoot();
	}

	@Override
	public boolean moveTaskToBack(boolean nonRoot) {
		// TODO Auto-generated method stub
		return super.moveTaskToBack(nonRoot);
	}

	@Override
	public boolean navigateUpTo(Intent upIntent) {
		// TODO Auto-generated method stub
		return super.navigateUpTo(upIntent);
	}

	@Override
	public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
		// TODO Auto-generated method stub
		return super.navigateUpToFromChild(child, upIntent);
	}

	@Override
	public void onActionModeFinished(ActionMode mode) {
		// TODO Auto-generated method stub
		super.onActionModeFinished(mode);
	}

	@Override
	public void onActionModeStarted(ActionMode mode) {
		// TODO Auto-generated method stub
		super.onActionModeStarted(mode);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onApplyThemeResource(Theme theme, int resid, boolean first) {
		// TODO Auto-generated method stub
		super.onApplyThemeResource(theme, resid, first);
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub
		super.onAttachFragment(fragment);
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		// TODO Auto-generated method stub
		super.onChildTitleChanged(childActivity, title);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		super.onContentChanged();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onContextMenuClosed(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public CharSequence onCreateDescription() {
		// TODO Auto-generated method stub
		return super.onCreateDescription();
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(id, args);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(id);
	}

	@Override
	public void onCreateNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub
		super.onCreateNavigateUpTaskStack(builder);
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreatePanelMenu(featureId, menu);
	}

	@Override
	public View onCreatePanelView(int featureId) {
		// TODO Auto-generated method stub
		return super.onCreatePanelView(featureId);
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		// TODO Auto-generated method stub
		return super.onCreateThumbnail(outBitmap, canvas);
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		return super.onCreateView(name, context, attrs);
	}

	@Override
	public View onCreateView(View parent, String name, Context context,
			AttributeSet attrs) {
		// TODO Auto-generated method stub
		return super.onCreateView(parent, name, context, attrs);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
	}

	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onGenericMotionEvent(event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyLongPress(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyShortcut(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onNavigateUp() {
		// TODO Auto-generated method stub
		return super.onNavigateUp();
	}

	@Override
	public boolean onNavigateUpFromChild(Activity child) {
		// TODO Auto-generated method stub
		return super.onNavigateUpFromChild(child);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onOptionsMenuClosed(menu);
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		super.onPanelClosed(featureId, menu);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog, args);
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog);
	}

	@Override
	public void onPrepareNavigateUpTaskStack(TaskStackBuilder builder) {
		// TODO Auto-generated method stub
		super.onPrepareNavigateUpTaskStack(builder);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onPreparePanel(int featureId, View view, Menu menu) {
		// TODO Auto-generated method stub
		return super.onPreparePanel(featureId, view, menu);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return super.onRetainNonConfigurationInstance();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		return super.onSearchRequested();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub
		super.onTitleChanged(title, color);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTrackballEvent(event);
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
	}

	@Override
	public void onUserInteraction() {
		// TODO Auto-generated method stub
		super.onUserInteraction();
	}

	@Override
	protected void onUserLeaveHint() {
		// TODO Auto-generated method stub
		super.onUserLeaveHint();
	}

	@Override
	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams params) {
		// TODO Auto-generated method stub
		super.onWindowAttributesChanged(params);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
	}

	@Override
	public ActionMode onWindowStartingActionMode(Callback callback) {
		// TODO Auto-generated method stub
		return super.onWindowStartingActionMode(callback);
	}

	@Override
	public void openContextMenu(View view) {
		// TODO Auto-generated method stub
		super.openContextMenu(view);
	}

	@Override
	public void openOptionsMenu() {
		// TODO Auto-generated method stub
		super.openOptionsMenu();
	}

	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		// TODO Auto-generated method stub
		super.overridePendingTransition(enterAnim, exitAnim);
	}

	@Override
	public void recreate() {
		// TODO Auto-generated method stub
		super.recreate();
	}

	@Override
	public void registerForContextMenu(View view) {
		// TODO Auto-generated method stub
		super.registerForContextMenu(view);
	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		super.setContentView(layoutResID);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		super.setContentView(view, params);
	}

	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		super.setContentView(view);
	}

	@Override
	public void setFinishOnTouchOutside(boolean finish) {
		// TODO Auto-generated method stub
		super.setFinishOnTouchOutside(finish);
	}

	@Override
	public void setIntent(Intent newIntent) {
		// TODO Auto-generated method stub
		super.setIntent(newIntent);
	}

	@Override
	public void setRequestedOrientation(int requestedOrientation) {
		// TODO Auto-generated method stub
		super.setRequestedOrientation(requestedOrientation);
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}

	@Override
	public void setTitle(int titleId) {
		// TODO Auto-generated method stub
		super.setTitle(titleId);
	}

	@Override
	public void setTitleColor(int textColor) {
		// TODO Auto-generated method stub
		super.setTitleColor(textColor);
	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		super.setVisible(visible);
	}

	@Override
	public boolean shouldUpRecreateTask(Intent targetIntent) {
		// TODO Auto-generated method stub
		return super.shouldUpRecreateTask(targetIntent);
	}

	@Override
	public ActionMode startActionMode(Callback callback) {
		// TODO Auto-generated method stub
		return super.startActionMode(callback);
	}

	@Override
	public void startActivities(Intent[] intents, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivities(intents, options);
	}

	@Override
	public void startActivities(Intent[] intents) {
		// TODO Auto-generated method stub
		super.startActivities(intents);
	}

	@Override
	public void startActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivity(intent, options);
	}

	@Override
	public void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		super.startActivity(intent);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode, options);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode);
	}

	@Override
	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivityFromChild(child, intent, requestCode, options);
	}

	@Override
	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityFromChild(child, intent, requestCode);
	}

	@Override
	public void startActivityFromFragment(Fragment fragment, Intent intent,
			int requestCode, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivityFromFragment(fragment, intent, requestCode, options);
	}

	@Override
	public void startActivityFromFragment(Fragment fragment, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		super.startActivityFromFragment(fragment, intent, requestCode);
	}

	@Override
	public boolean startActivityIfNeeded(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		return super.startActivityIfNeeded(intent, requestCode, options);
	}

	@Override
	public boolean startActivityIfNeeded(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		return super.startActivityIfNeeded(intent, requestCode);
	}

	@Override
	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags, options);
	}

	@Override
	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags);
	}

	@Override
	public void startIntentSenderForResult(IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
				flagsValues, extraFlags, options);
	}

	@Override
	public void startIntentSenderForResult(IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
				flagsValues, extraFlags);
	}

	@Override
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags, Bundle options)
			throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent,
				flagsMask, flagsValues, extraFlags, options);
	}

	@Override
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent,
				flagsMask, flagsValues, extraFlags);
	}

	@Override
	public void startManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		super.startManagingCursor(c);
	}

	@Override
	public boolean startNextMatchingActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		return super.startNextMatchingActivity(intent, options);
	}

	@Override
	public boolean startNextMatchingActivity(Intent intent) {
		// TODO Auto-generated method stub
		return super.startNextMatchingActivity(intent);
	}

	@Override
	public void startSearch(String initialQuery, boolean selectInitialQuery,
			Bundle appSearchData, boolean globalSearch) {
		// TODO Auto-generated method stub
		super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
	}

	@Override
	public void stopManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		super.stopManagingCursor(c);
	}

	@Override
	public void takeKeyEvents(boolean get) {
		// TODO Auto-generated method stub
		super.takeKeyEvents(get);
		System.out.println("takeKeyEvents....");
	}

	@Override
	public void triggerSearch(String query, Bundle appSearchData) {
		// TODO Auto-generated method stub
		super.triggerSearch(query, appSearchData);
		System.out.println("triggerSearch....");
	}

	@Override
	public void unregisterForContextMenu(View view) {
		// TODO Auto-generated method stub
		super.unregisterForContextMenu(view);
		System.out.println("unregisterForContextMenu....");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("onCreate....");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.slide, menu);
		System.out.println("onCreateOptionsMenu....");
		return true;
	}
}
