// Rachael Colley 2014

package rach.dig.android_animationtest;


import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder holder;
	private MyParticleThread myParticleThread;


	public MySurfaceView(Context context) {
		super(context);
		Log.d(">>>>>>>>>>>>>>>>","MySurfaceView.construct");
		
		holder = getHolder();
		holder.addCallback(this);
	}

	public void resume() { 
		Log.d(">>>>>>>>>>>>>>>>","MySurfaceView.resume");
		// Internally kicks off life cycle
		// Do not attempt to access the surface here as it has not been created yet.
	}  
	public void pause() {      
		Log.d(">>>>>>>>>>>>>>>>","MySurfaceView.pause");
		myParticleThread.setRunning(false);                      
		while(true) {
			try {
				myParticleThread.join();
				break;
			} catch (InterruptedException e) {
				// retry
			}
		}
	}       

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(">>>>>>>>>>>>>>>>","MySurfaceView.surfaceCreated");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		Log.d(">>>>>>>>>>>>>>>>","MySurfaceView.surfaceChanged");

		if (myParticleThread==null){  
			myParticleThread = new MyParticleThread(holder);  
			myParticleThread.setRunning(true);  
			myParticleThread.setSurfaceSize(width, height);  
			myParticleThread.start();  
		}  


	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(">>>>>>>>>>>>>>>>","MySurfaceView.surfaceDestroyed");

		boolean retry = true;  
		myParticleThread.setRunning(false);  
		while (retry) {  
			try {  
				myParticleThread.join();  
				retry = false;  
			} catch (InterruptedException e) {}  
		}  
	}


}
