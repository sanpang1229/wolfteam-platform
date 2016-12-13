package org.wechat.material.result;

/**
 * 统计实体对象
 * @author Andy
 *
 */
public class CountEntity {
	private int voice_count; // 语音总数量
	private int video_count; // 视频总数量
	private int image_count; // 图片总数量
	private int news_count; // 图文总数量

	public int getVoice_count() {
		return voice_count;
	}

	public void setVoice_count(int voiceCount) {
		voice_count = voiceCount;
	}

	public int getVideo_count() {
		return video_count;
	}

	public void setVideo_count(int videoCount) {
		video_count = videoCount;
	}

	public int getImage_count() {
		return image_count;
	}

	public void setImage_count(int imageCount) {
		image_count = imageCount;
	}

	public int getNews_count() {
		return news_count;
	}

	public void setNews_count(int newsCount) {
		news_count = newsCount;
	}

	@Override
	public String toString() {
		return "CountEntity [image_count=" + image_count + ", news_count="
				+ news_count + ", video_count=" + video_count
				+ ", voice_count=" + voice_count + "]";
	}
	
}
