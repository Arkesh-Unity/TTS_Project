package b4x.tts.demo;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.*;
import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import com.huawei.hms.common.ApiException;

import android.content.Intent;
import anywheresoftware.b4a.IOnActivityResult;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.io.IOException;
import java.io.InputStream;
import android.os.Bundle;

import com.huawei.hms.mlsdk.tts.MLTtsAudioFragment;
import com.huawei.hms.mlsdk.tts.MLTtsCallback;
import com.huawei.hms.mlsdk.tts.MLTtsConfig;
import com.huawei.hms.mlsdk.tts.MLTtsConstants;
import com.huawei.hms.mlsdk.tts.MLTtsEngine;
import com.huawei.hms.mlsdk.tts.MLTtsError;
import com.huawei.hms.mlsdk.tts.MLTtsWarn;
import com.huawei.hms.mlsdk.common.MLApplication;
import com.huawei.hms.mlsdk.*;
import android.os.Bundle;
import android.util.Pair;


@ShortName("HMSTTSWork")
@Events(values={"SpeakerStatus (token As String)", "Stop (token As String)", "Start (token As String)"})
public class HMSTTSWork {
	public String eventName = "listener";
	public final String TAG = "tts_Kit";
	public BA ba;
	
    public void init (Context context){
        AGConnectServicesConfig.fromContext(context).overlayWith(new LazyInputStream(context) {
            @Override
            public InputStream get(Context context) {
                try {
					return context.getAssets().open("agconnect-services.json");
                } catch (IOException e) {
					e.printStackTrace();
                    BA.Log(e.toString());
                }
                return null;
            }
        });
    }
	
	private IOnActivityResult ion;
       
        public void ListenFortts(BA ba1, String text) 
		{
			ba = ba1;
		MLApplication.getInstance().setApiKey("api_key");
			
		MLTtsConfig mlConfigs = new MLTtsConfig().setLanguage(MLTtsConstants.TTS_EN_US).setPerson(MLTtsConstants.TTS_SPEAKER_FEMALE_EN).setSpeed(1.0f).setVolume(1.0f);
        MLTtsEngine mlTtsEngine = new MLTtsEngine(mlConfigs);
		Log.d(" text from ui ",text);
        mlTtsEngine.updateConfig(mlConfigs);
        mlTtsEngine.setTtsCallback(callback);
       
        String id = mlTtsEngine.speak(text, MLTtsEngine.QUEUE_APPEND);
   
		}
    
	   MLTtsCallback callback = new MLTtsCallback() {
		  
        @Override
        public void onError(String taskId, MLTtsError err) {
			
		}

        @Override
        public void onWarn(String taskId, MLTtsWarn warn) {

        }

        @Override

        public void onRangeStart(String taskId, int start, int end) {

        }

        @Override
        public void onAudioAvailable(String taskId, MLTtsAudioFragment audioFragment, int offset, Pair<Integer, Integer> range, Bundle bundle) {
			
        }

         @Override
        public void onEvent(String taskId, int eventId, Bundle bundle) {
;
            switch (eventId) {
							
                case MLTtsConstants.EVENT_PLAY_START:

                    ba.raiseEventFromUI(this, eventName + "_start","Start");
                    
					break;

                case MLTtsConstants.EVENT_PLAY_STOP:
				
                    boolean isInterrupted = bundle.getBoolean(MLTtsConstants.EVENT_PLAY_STOP_INTERRUPTED);
				
                    ba.raiseEventFromUI(this, eventName + "_stop","Stop");
                  
                    break;

                case MLTtsConstants.EVENT_PLAY_RESUME:
                
				   break;

                case MLTtsConstants.EVENT_PLAY_PAUSE:
				
                   break;

                case MLTtsConstants.EVENT_SYNTHESIS_START:
                
				   break;

                case MLTtsConstants.EVENT_SYNTHESIS_END:
                   
				   break;

                case MLTtsConstants.EVENT_SYNTHESIS_COMPLETE:
				
                    boolean isInterrupted1 = bundle.getBoolean(MLTtsConstants.EVENT_SYNTHESIS_INTERRUPTED);
		
                  	break;

                default:
                    break;
            }
        }
    };
}






