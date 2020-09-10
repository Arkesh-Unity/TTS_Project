package b4x.tts.demo;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.*;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import android.content.Intent;
import anywheresoftware.b4a.IOnActivityResult;
import android.util.Log;
import b4x.tts.demo.HMSTTSWork;

import com.huawei.hms.mlsdk.tts.MLTtsAudioFragment;
import com.huawei.hms.mlsdk.tts.MLTtsCallback;
import com.huawei.hms.mlsdk.tts.MLTtsConfig;
import com.huawei.hms.mlsdk.tts.MLTtsConstants;
import com.huawei.hms.mlsdk.tts.MLTtsEngine;
import com.huawei.hms.mlsdk.tts.MLTtsError;
import com.huawei.hms.mlsdk.tts.MLTtsWarn;

import com.huawei.hms.mlsdk.*;


@Version(1.0f)
@ShortName("HMSTTS")
@DependsOn(values={	"base-4.0.1.300.aar",
					"agconnect-core-1.0.1.300.aar",
					"tasks-1.3.1.302.aar",
					"network-common-4.0.2.301.aar",
					"network-grs-4.0.2.301.aar",
					"ml-computer-net-2.0.1.300.aar",
					"ml-computer-grs-inner-2.0.1.300.aar",
					"okhttp-3.12.0.jar",
					"okio-1.15.0.jar",
					"ml-computer-voice-tts-2.0.1.300.aar",
"ml-computer-agc-inner-2.0.1.300.aar",
"ml-computer-commonutils-inner-2.0.1.300.aar",
"ml-computer-ha-inner-2.0.1.300.aar"
	})
					
@Permissions(values={"android.permission.INTERNET",
"android.permission.WRITE_EXTERNAL_STORAGE",
"android.permission.ACCESS_NETWORK_STATE",
"android.permission.RECORD_AUDIO",
"android.permission.READ_EXTERNAL_STORAGE",
"android.permission.CHANGE_WIFI_STATE",
"android.permission.ACCESS_WIFI_STATE",
"android.permission.CHANGE_CONFIGURATION",
"android.permission.WAKE_LOCK"})

public class HMSTTS{
	public BA ba;
	public b4x.tts.demo.HMSTTSWork ttswork = null;
	public final String TAG = "tts_Kit";

	public HMSTTS(){
		ttswork = new b4x.tts.demo.HMSTTSWork();
	}

    public void ListenFortts(BA ba, String text) 
	{
		ttswork.ListenFortts(ba,text);
    }

	public void inittts(BA xba) {
		ba = xba;
	
    }
}