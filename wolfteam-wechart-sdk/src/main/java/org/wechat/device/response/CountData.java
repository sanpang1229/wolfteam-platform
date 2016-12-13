package org.wechat.device.response;

/**
 * 统计数据
 * 
 * @author Andy
 * 
 */
public class CountData {
	private int click_pv;		// 点击摇周边消息的次数
	private int click_uv;		//点击摇周边消息的人数
	private long ftime;			//当天0点对应的时间戳
	private int shake_pv;		//摇周边的次数
	private int shake_uv;		//摇周边的人数
	
	public int getClick_pv() {
		return click_pv;
	}

	public void setClick_pv(int clickPv) {
		click_pv = clickPv;
	}

	public int getClick_uv() {
		return click_uv;
	}

	public void setClick_uv(int clickUv) {
		click_uv = clickUv;
	}

	public long getFtime() {
		return ftime;
	}

	public void setFtime(long ftime) {
		this.ftime = ftime;
	}

	public int getShake_pv() {
		return shake_pv;
	}

	public void setShake_pv(int shakePv) {
		shake_pv = shakePv;
	}

	public int getShake_uv() {
		return shake_uv;
	}

	public void setShake_uv(int shakeUv) {
		shake_uv = shakeUv;
	}
}