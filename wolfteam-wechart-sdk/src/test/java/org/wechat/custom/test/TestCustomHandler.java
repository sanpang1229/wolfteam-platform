package org.wechat.custom.test;

import org.junit.Test;
import org.wechat.common.entity.resp.bean.Image;
import org.wechat.common.entity.resp.bean.Music;
import org.wechat.common.entity.resp.bean.Text;
import org.wechat.common.entity.resp.bean.Voice;
import org.wechat.custom.entity.CVideo;
import org.wechat.custom.entity.ImageCustom;
import org.wechat.custom.entity.MusicCustom;
import org.wechat.custom.entity.TextCustom;
import org.wechat.custom.entity.VideoCustom;
import org.wechat.custom.entity.VoiceCustom;
import org.wechat.custom.handler.CustomHandler;

/**
 * 测试客服消息
 * @author Andy
 *
 */
public class TestCustomHandler {
	
	/**
	 * 测试文本消息
	 */
	@Test
	public void testToTextJson(){
		TextCustom textcustmon = new TextCustom();
		Text text = new Text();
		text.setContent("content");
		textcustmon.setText(text);
		textcustmon.setTouser("toUser");
		System.out.println(CustomHandler.toTextJson(textcustmon));
	}
	
	/**
	 * 测试图片消息
	 */
	@Test
	public void testToImageJson(){
		ImageCustom imagemessage = new ImageCustom();
		Image image = new Image();
		image.setMedia_id("mediaId");
		imagemessage.setImage(image);
		imagemessage.setTouser("toUser");
		System.out.println(CustomHandler.toImageJson(imagemessage));
	}
	
	/**
	 * 测试音乐消息
	 */
	@Test
	public void testToMusicJson(){
		MusicCustom musicMsg = new MusicCustom();
		musicMsg.setTouser("toUser");
		Music music = new Music();
		music.setDescription("Description");
		music.setHQMusicUrl("HQMusicUrl");
		music.setMusicURL("MusicURL");
		music.setThumbMediaId("ThumbMediaId");
		music.setTitle("Title");
		musicMsg.setMusic(music);
		System.out.println(CustomHandler.toMusicJson(musicMsg));
	}
	
	/**
	 * 测试视频消息
	 */
	@Test
	public void testVideoJson(){
		VideoCustom videoMsg = new VideoCustom();
		CVideo video = new CVideo();
		video.setDescription("description");
		video.setMediaId("mediaId");
		video.setThumb_media_id("Thumb_media_id");
		video.setTitle("Title");
		videoMsg.setVideo(video);
		videoMsg.setTouser("toUser");
		System.out.println(CustomHandler.toVideoJson(videoMsg));
	}
	
	/**
	 * 测试语言消息
	 */
	@Test
	public void testVoiceJson(){
		VoiceCustom voiceMsg = new VoiceCustom();
		Voice voice = new Voice();
		voice.setMedia_id("MediaI多");
		voiceMsg.setTouser("toUser");
		voiceMsg.setVoice(voice);
		System.out.println(CustomHandler.toVoiceJson(voiceMsg));
	}
}
